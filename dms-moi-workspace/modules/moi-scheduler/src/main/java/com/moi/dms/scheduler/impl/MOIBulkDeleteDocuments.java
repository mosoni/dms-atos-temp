package com.moi.dms.scheduler.impl;

import com.liferay.document.library.kernel.exception.NoSuchFolderException;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.StorageType;
import com.liferay.portal.kernel.scheduler.StorageTypeAware;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.moi.dms.delete.documents.model.MOIDeleteDocuments;
import com.moi.dms.delete.documents.service.MOIDeleteDocumentsLocalService;
import com.moi.dms.scheduler.constants.MOIBulkDeleteDocumentConstants;
import com.moi.dms.trace.request.model.MOITraceRequest;
import com.moi.dms.trace.request.service.MOITraceRequestLocalServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
			"delete.documents.cron.expression=0/5 * * ? * * *"
		}, 
	service = MOIBulkDeleteDocuments.class
)
public class MOIBulkDeleteDocuments extends BaseMessageListener {

	@Override
	protected void doReceive(Message message) throws MessageListenerException {

		if (_log.isDebugEnabled()) {
			_log.debug("Starting Scheduler-" + System.currentTimeMillis());
		}
		BufferedReader reader = null;
		String nextLine = StringPool.BLANK;
		String folderName = StringPool.BLANK;

		try {

			Company company = CompanyLocalServiceUtil.getCompanyByMx(
					PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
			// TODO: Create new delete user which will be used to delete
			// documents.
			User deleteUser = UserLocalServiceUtil.getUserByScreenName(
					company.getCompanyId(),
					MOIBulkDeleteDocumentConstants.DELETE_USER_SCREEN_NAME);

			PrincipalThreadLocal.setName(deleteUser.getUserId());
			PermissionChecker permissionChecker = PermissionCheckerFactoryUtil
					.create(deleteUser);
			PermissionThreadLocal.setPermissionChecker(permissionChecker);

			// TODO: Currently Guest group is used. Group to be changed in
			// actual implementation. New Constant to be created. Group Id
			// is Repo Id.
			Group group = GroupLocalServiceUtil.getFriendlyURLGroup(
					company.getCompanyId(),
					MOIBulkDeleteDocumentConstants.FRIENDLY_URL);
			long repositoryId = group.getGroupId();

			/*
			 * Entry Point : Trace the request
			 */
			MOITraceRequest moiTraceRequest = null;
			moiTraceRequest = MOITraceRequestLocalServiceUtil
					.addMOITraceRequest(String.valueOf(deleteUser.getUserId()),
							new Date(), StringPool.BLANK, StringPool.BLANK,
							"Deleting Documents", StringPool.BLANK, false, null,
							null, StringPool.BLANK);
			updateTraceComment(
					MOIBulkDeleteDocumentConstants.DELETE_SCHEDULER_STARTED,
					moiTraceRequest);

			// Get list of all the delete document entries with status
			// "Approved"
			List<String> statusList = new ArrayList<String>();
			statusList.add(MOIBulkDeleteDocumentConstants.STATUS_APPROVED);
			statusList.add(MOIBulkDeleteDocumentConstants.STATUS_INPROGRESS);
			List<MOIDeleteDocuments> deleteDocumentList = _deleteDocumentsService
					.getDeleteDocumentsByStatus(statusList);

			if (_log.isDebugEnabled()) {
				_log.debug("repositoryId: " + repositoryId);
				_log.debug(
						"Total Document Entries: " + deleteDocumentList.size());
			}

			for (MOIDeleteDocuments deleteDocument : deleteDocumentList) {

				StringBuilder pendingIdentifiers = new StringBuilder();
				updateTraceComment(
						"Deleting entries in "
								+ deleteDocument.getFileEntryName()
								+ " with status " + deleteDocument.getStatus(),
						moiTraceRequest);
				if (MOIBulkDeleteDocumentConstants.STATUS_APPROVED
						.equals(deleteDocument.getStatus())) {
					// Get the uploaded file and parse it.
					long fileEntryId = deleteDocument.getFileEntryId();
					FileEntry fileEntry = _dlAppService
							.getFileEntry(fileEntryId);

					if (_log.isDebugEnabled()) {
						_log.debug("fileEntryId: " + fileEntryId);
					}

					if (null != fileEntry) {
						reader = new BufferedReader(new InputStreamReader(
								fileEntry.getContentStream()));

						// Skipped First Line. Considering it a header.
						reader.readLine();
						while ((nextLine = reader.readLine()) != null) {
							// Deleting folder with identifier:

							// TODO: Once CSV format is decided, revisit this
							// logic. Currently only one column per line is
							// considered.
							folderName = nextLine;
							try {
								deleteFolder(repositoryId, folderName,
										moiTraceRequest);
							} catch (NoSuchFolderException e) {
								updateTraceComment(
										MOIBulkDeleteDocumentConstants.FOLDER_NOT_FOUND
												+ folderName,
										moiTraceRequest);
							} catch (PortalException e) {
								pendingIdentifiers.append(folderName)
										.append(StringPool.COMMA);
							}
						}
						if (null != reader) {
							reader.close();
						}
					}
				} else if (MOIBulkDeleteDocumentConstants.STATUS_INPROGRESS
						.equals(deleteDocument.getStatus())) {
					String[] exitingIdentifierList = deleteDocument
							.getPendingIdentifiers().split(",");
					for (String existingIdentifier : exitingIdentifierList) {
						// Deleting folder with identifier:

						// TODO: Once CSV format is decided, revisit this
						// logic. Currently only one column per line is
						// considered.
						folderName = existingIdentifier;
						try {
							deleteFolder(repositoryId, folderName,
									moiTraceRequest);
						} catch (NoSuchFolderException e) {
							updateTraceComment(
									MOIBulkDeleteDocumentConstants.FOLDER_NOT_FOUND
											+ folderName,
									moiTraceRequest);
						} catch (PortalException e) {
							pendingIdentifiers.append(folderName).append(",");
						}
					}
				}

				// Update the list and mark the process completed.
				if (pendingIdentifiers.length() > 0) {
					pendingIdentifiers
							.deleteCharAt(pendingIdentifiers.length() - 1);
					deleteDocument.setStatus(
							MOIBulkDeleteDocumentConstants.STATUS_INPROGRESS);
				} else {
					deleteDocument.setStatus(
							MOIBulkDeleteDocumentConstants.STATUS_COMPLETED);
				}

				deleteDocument
						.setPendingIdentifiers(pendingIdentifiers.toString());
				_deleteDocumentsService
						.updateMOIDeleteDocuments(deleteDocument);
			}

			updateTraceComment(
					MOIBulkDeleteDocumentConstants.DELETE_SCHEDULER_COMPLETED,
					moiTraceRequest);
			System.out.println(
					"Final Comments: -----" + moiTraceRequest.getComment());
			updateTraceRequest(
					MOIBulkDeleteDocumentConstants.DELETE_SCHEDULER_COMPLETED,
					moiTraceRequest, true);
		} catch (PrincipalException e) {
			if (_log.isErrorEnabled()) {
				_log.error(e);
			}
		} catch (IOException e) {
			if (_log.isErrorEnabled()) {
				_log.error(e);
			}
		} catch (PortalException e) {
			e.printStackTrace();
			if (_log.isErrorEnabled()) {
				_log.error(e);
			}
		} finally {
			try {
				if (null != reader) {
					reader.close();
				}
			} catch (IOException e) {
				if (_log.isErrorEnabled()) {
					_log.error(e);
				}
			}
		}

		if (_log.isDebugEnabled()) {
			_log.debug("Scheduler completed-" + System.currentTimeMillis());
		}
	}

	/**
	 * Function to delete folder if it exists.
	 * 
	 * @param repositoryId
	 * @param folderName
	 * @param moiTraceRequest
	 * @throws PortalException
	 */
	private void deleteFolder(long repositoryId, String folderName,
			MOITraceRequest moiTraceRequest) throws PortalException {

		// Check if folder exists.
		Folder folder = _dlAppService.getFolder(repositoryId,
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, folderName);

		if (null != folder && 0 != folder.getFolderId()) {
			if (_log.isDebugEnabled()) {
				_log.debug(folder.getName() + " deleted.");
			}

			List<FileEntry> fileEntries = _dlAppService
					.getFileEntries(repositoryId, folder.getFolderId());
			for (FileEntry file : fileEntries) {
				// TODO: Populate Audit table.
			}

			_dlAppService.deleteFolder(folder.getFolderId());
			updateTraceComment(folder.getName() + " deleted", moiTraceRequest);

		} else {
			updateTraceComment(MOIBulkDeleteDocumentConstants.FOLDER_NOT_FOUND
					+ folderName, moiTraceRequest);
		}
	}

	/**
	 * This method is used to concatinate comment section of MOITraceRequest
	 *
	 * @param comment
	 * @param traceRequest :
	 */
	public static void updateTraceComment(String comment,
			MOITraceRequest traceRequest) {
		if (Validator.isNotNull(traceRequest)) {
			if (Validator.isNotNull(traceRequest.getComment())) {
				traceRequest.setComment(
						traceRequest.getComment() + " | " + comment + ".");
			} else {
				traceRequest.setComment(comment + ".");
			}
		}
	}

	/**
	 * This method is used to Update trace request with result and date
	 *
	 * @param result
	 * @param moiTraceRequest :
	 */
	public static void updateTraceRequest(String result,
			MOITraceRequest moiTraceRequest, boolean requestValid) {

		if (Validator.isNotNull(moiTraceRequest)) {
			moiTraceRequest.setRequestResult(result);
			moiTraceRequest.setRequestResultDate(new Date());
			moiTraceRequest.setRequestValid(requestValid);
			MOITraceRequestLocalServiceUtil
					.updateMOITraceRequest(moiTraceRequest);
		}
	}

	/**
	 * activate: Called whenever the properties for the component change (ala
	 * Config Admin) or OSGi is activating the component.
	 * 
	 * @param properties The properties map from Config Admin.
	 * @throws SchedulerException in case of error.
	 */
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties)
			throws SchedulerException {

		// extract the cron expression from the properties
		String cronExpression = GetterUtil.getString(
				properties.get("delete.documents.cron.expression"),
				_DEFAULT_CRON_EXPRESSION);

		// create a new trigger definition for the job.
		String listenerClass = getClass().getName();
		Trigger jobTrigger = _triggerFactory.createTrigger(listenerClass,
				listenerClass, new Date(), null, cronExpression);

		// Create a new scheduleEntryImpl
		_schedulerEntryImpl = new SchedulerEntryImpl(getClass().getName(),
				jobTrigger);

		// if we were initialized
		if (_initialized) {
			// first deactivate the current job before we schedule.
			deactivate();
		}

		// register the scheduled task
		_schedulerEngineHelper.register(this, _schedulerEntryImpl,
				DestinationNames.SCHEDULER_DISPATCH);

		// set the initialized flag.
		_initialized = true;
	}

	/**
	 * deactivate: Called when OSGi is deactivating the component.
	 */
	@Deactivate
	protected void deactivate() {
		// if we previously were initialized
		if (_initialized) {
			// unschedule the job so it is cleaned up
			try {
				_schedulerEngineHelper.unschedule(_schedulerEntryImpl,
						getStorageType());
			} catch (SchedulerException se) {
				if (_log.isWarnEnabled()) {
					_log.warn("Unable to unschedule trigger", se);
				}
			}
			// unregister this listener
			_schedulerEngineHelper.unregister(this);
		}
		// clear the initialized flag
		_initialized = false;
	}

	/**
	 * getStorageType: Utility method to get the storage type from the scheduler
	 * entry wrapper.
	 * 
	 * @return StorageType The storage type to use.
	 */
	protected StorageType getStorageType() {
		if (_schedulerEntryImpl instanceof StorageTypeAware) {
			return ((StorageTypeAware) _schedulerEntryImpl).getStorageType();
		}

		return StorageType.MEMORY_CLUSTERED;
	}

	/**
	 * setModuleServiceLifecycle: So this requires some explanation...
	 * 
	 * OSGi will start a component once all of it's dependencies are satisfied.
	 * However, there are times where you want to hold off until the portal is
	 * completely ready to go.
	 * 
	 * This reference declaration is waiting for the ModuleServiceLifecycle's
	 * PORTAL_INITIALIZED component which will not be available until, surprise
	 * surprise, the portal has finished initializing.
	 * 
	 * With this reference, this component activation waits until portal
	 * initialization has completed.
	 * 
	 * @param moduleServiceLifecycle
	 */
	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(
			ModuleServiceLifecycle moduleServiceLifecycle) {
	}

	@Reference(unbind = "-")
	protected void setTriggerFactory(TriggerFactory triggerFactory) {
		_triggerFactory = triggerFactory;
	}

	@Reference(unbind = "-")
	protected void setSchedulerEngineHelper(
			SchedulerEngineHelper schedulerEngineHelper) {
		_schedulerEngineHelper = schedulerEngineHelper;
	}

	@Reference
	private DLAppService _dlAppService;

	@Reference
	private MOIDeleteDocumentsLocalService _deleteDocumentsService;

	// the default cron expression is to run daily at midnight
	private static final String _DEFAULT_CRON_EXPRESSION = "0 0 0 * * ?";

	private static final Log _log = LogFactoryUtil
			.getLog(MOIBulkDeleteDocuments.class);

	private volatile boolean _initialized;
	private TriggerFactory _triggerFactory;
	private SchedulerEngineHelper _schedulerEngineHelper;
	private SchedulerEntryImpl _schedulerEntryImpl = null;

}
