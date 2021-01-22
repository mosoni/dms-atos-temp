package com.moi.api.handler.internal.resource.v1_0;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFileEntryType;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLVersionNumberIncrease;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryTypeLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.dynamic.data.mapping.kernel.DDMFormValues;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.multipart.BinaryFile;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import com.liferay.portal.vulcan.pagination.Page;
import com.moi.api.handler.dto.v1_0.DocumentResult;
import com.moi.api.handler.internal.result.APIConstants;
import com.moi.api.handler.internal.result.GenerateDocumentResult;
import com.moi.api.handler.resource.v1_0.JiraAPIHandlerResource;
import com.moi.dms.mosip.constants.CommonConstants;
import com.moi.dms.mosip.constants.MosipErrorConstants;
import com.moi.dms.trace.request.model.MOITraceRequest;
import com.moi.dms.trace.request.service.MOITraceRequestLocalServiceUtil;
import com.moi.jira.validator.JiraUtil;
import com.moi.jira.validator.JiraValidator;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Mohit
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/jira-api-handler.properties",
	scope = ServiceScope.PROTOTYPE, service = JiraAPIHandlerResource.class
)
public class JiraAPIHandlerResourceImpl extends BaseJiraAPIHandlerResourceImpl {

	// TODO: Ths is static user. Need to find a way to get original user.
	private static long DEFAULT_USER_ID = 20130;

	/**
	 * Main method to implement the document upload received from JIRA Rest API
	 * 
	 * @param consumerCode
	 * @param ticketNumber
	 * @param documentTitle
	 * @param metadata
	 * @param multipartBody
	 * @return Page<DocumentResult>
	 */
	@Override
	public Page<DocumentResult> uploadJiraDocument(String consumerCode,
			String ticketNumber, String documentTitle, String metadata,
			MultipartBody multipartBody) {

		// Authorize and authenticate user - To be done by OAuth 2.0
		// Get user id & serviceContext
		ServiceContext serviceContext = ServiceContextThreadLocal
				.getServiceContext();
		long userId = serviceContext.getUserId();

		// TODO: Remove in actual implementation.
		if (0 == userId) {
			userId = DEFAULT_USER_ID;
		}

		/* Check input parameter from URL. If not available, get it from body */
		String consumerCodeParam = getJiraUploadDocParams(
				CommonConstants.JIRA_REQ_PARAM_CONSUMER_CODE, consumerCode,
				multipartBody);

		String ticketNumberParam = getJiraUploadDocParams(
				CommonConstants.JIRA_REQ_PARAM_TICKET_NUMBER, ticketNumber,
				multipartBody);

		String documentTitleParam = getJiraUploadDocParams(
				CommonConstants.JIRA_REQ_PARAM_DOCUMENT_TITLE, documentTitle,
				multipartBody);

		String metadataParam = getJiraUploadDocParams(
				CommonConstants.JIRA_REQ_PARAM_METADATA, metadata,
				multipartBody);
		if (null == metadataParam) {
			metadataParam = StringPool.BLANK;
		}

		debugLog("consumerCode: " + consumerCodeParam);
		debugLog("ticketNumber: " + ticketNumberParam);
		debugLog("documentTitle: " + documentTitleParam);
		debugLog("metadata: " + metadataParam);
		debugLog("userId: " + userId);

		BinaryFile binaryFile = multipartBody
				.getBinaryFile(CommonConstants.JIRA_REQ_PARAM_DOCUMENT);

		/*
		 * Entry Point : Trace the request
		 */
		MOITraceRequest moiTraceRequest = null;

		moiTraceRequest = MOITraceRequestLocalServiceUtil.addMOITraceRequest(
				String.valueOf(userId), new Date(), consumerCodeParam, null,
				JiraUtil.getAction(documentTitle, true), documentTitle, true,
				null, null, StringPool.BLANK);

		/*
		 * validateRequest() method will Check input parameters, Consumer Code
		 * and Document Type
		 */
		String validationResult = JiraValidator.validateRequest(
				consumerCodeParam, ticketNumberParam, documentTitleParam,
				metadataParam, binaryFile, moiTraceRequest);
		debugLog("validationResult: " + validationResult);

		if (Validator.isNotNull(validationResult)) {
			return GenerateDocumentResult.generateDocumentResult(
					moiTraceRequest.getRequestId(), APIConstants.FAILURE,
					validationResult, null);
		}

		// Check Folder. If Folder not available, create new folder with
		// ticket number
		Folder uploadFolder = null;
		try {
			uploadFolder = getFolder(ticketNumberParam, true, serviceContext);
			debugLog("folderId: " + uploadFolder.getFolderId());

			// Check if File exists
			boolean fileExists = isFileExist(uploadFolder, documentTitleParam,
					serviceContext);

			// If file available, send error message if not upload the
			// file.
			if (!fileExists) {
				uploadJiraFile(ticketNumberParam, documentTitleParam,
						metadataParam, binaryFile, uploadFolder,
						serviceContext);
			} else {
				JiraUtil.updateTraceRequest(
						MosipErrorConstants.JIRA_FILE_EXISTS_MSG,
						moiTraceRequest);
				return GenerateDocumentResult.generateDocumentResult(
						moiTraceRequest.getRequestId(), APIConstants.FAILURE,
						MosipErrorConstants.JIRA_FILE_EXISTS_MSG, null);
			}
		} catch (PortalException | IOException e) {
			JiraUtil.updateTraceRequest(MosipErrorConstants.JIRA_COMMON_ERROR,
					moiTraceRequest);
			return GenerateDocumentResult.generateDocumentResult(
					moiTraceRequest.getRequestId(), APIConstants.FAILURE,
					MosipErrorConstants.JIRA_COMMON_ERROR, null);
		}
		JiraUtil.updateTraceRequest(MosipErrorConstants.JIRA_FILE_UPLOADED_MSG,
				moiTraceRequest);
		return GenerateDocumentResult.generateDocumentResult(
				moiTraceRequest.getRequestId(), APIConstants.SUCCESS,
				MosipErrorConstants.JIRA_FILE_UPLOADED_MSG, null);
	}

	/**
	 * Get parameter either from request URL or from request body
	 * 
	 * @param paramName
	 * @param paramValue
	 * @param multipartBody
	 * @return String
	 */
	private String getJiraUploadDocParams(String paramName, String paramValue,
			MultipartBody multipartBody) {

		String value = null;
		if (null == paramValue || paramValue.isEmpty()) {
			value = multipartBody.getValueAsString(paramName);
		} else {
			value = paramValue;
		}
		return value;
	}

	/**
	 * Method to check if folder exists or not
	 * 
	 * @param folderName
	 * @param serviceContext
	 * @return DLFolder
	 */
	private DLFolder isFolderExist(String folderName,
			ServiceContext serviceContext) {
		DLFolder dlFolder = null;

		try {
			dlFolder = DLFolderLocalServiceUtil.getFolder(
					serviceContext.getScopeGroupId(),
					CommonConstants.JIRA_PARENT_FOLDER_ID, folderName);
		} catch (PortalException e) {
			if (_log.isErrorEnabled()) {
				_log.error(e);
			}
		}

		return dlFolder;
	}

	/**
	 * Method to check if file exists or not
	 * 
	 * @param folder
	 * @param documentTitle
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 */
	private boolean isFileExist(Folder folder, String documentTitle,
			ServiceContext serviceContext) {

		boolean fileExists = false;
		FileEntry fileEntry = null;

		StringBuilder fileName = new StringBuilder(32);
		fileName.append(folder.getName()).append(StringPool.UNDERLINE)
				.append(documentTitle);

		try {
			fileEntry = DLAppServiceUtil.getFileEntry(
					serviceContext.getScopeGroupId(), folder.getFolderId(),
					fileName.toString());

			if (null != fileEntry) {
				fileExists = true;
			}
		} catch (PortalException e) {
			if (_log.isErrorEnabled()) {
				_log.error(e);
			}
		}
		return fileExists;
	}

	/**
	 * Get existing repository Id
	 * 
	 * @param serviceContext
	 * @return long
	 */
	private long getRepositoryId(ServiceContext serviceContext) {
		return serviceContext.getScopeGroupId();
	}

	/**
	 * Get folder. If folder is not present, this method will create one and
	 * return the same.
	 * 
	 * @param folderName
	 * @param serviceContext
	 * @return Folder
	 * @throws PortalException
	 */
	private Folder getFolder(String folderName, boolean createNew,
			ServiceContext serviceContext) throws PortalException {
		DLFolder dlFolder = isFolderExist(folderName, serviceContext);
		Folder folder = null;
		if (null == dlFolder && createNew) {
			try {
				folder = DLAppServiceUtil.addFolder(
						serviceContext.getScopeGroupId(),
						CommonConstants.JIRA_PARENT_FOLDER_ID, folderName,
						folderName, serviceContext);
			} catch (PortalException e) {
				if (_log.isErrorEnabled()) {
					_log.error(e);
				}
			} catch (SystemException e) {
				if (_log.isErrorEnabled()) {
					_log.error(e);
				}
			}
		} else {
			folder = DLAppServiceUtil.getFolder(dlFolder.getFolderId());
		}
		return folder;
	}

	/**
	 * This method uploads file to JIRA Folder.
	 * 
	 * @param ticketNumber
	 * @param documentTitle
	 * @param metadata
	 * @param binaryFile
	 * @param uploadFolder
	 * @param serviceContext
	 * @throws PortalException
	 * @throws IOException
	 */
	private void uploadJiraFile(String ticketNumber, String documentTitle,
			String metadata, BinaryFile binaryFile, Folder uploadFolder,
			ServiceContext serviceContext) throws PortalException, IOException {
		String fileName = binaryFile.getFileName();
		String title = ticketNumber + StringPool.UNDERLINE + documentTitle;
		String description = ticketNumber + StringPool.UNDERLINE
				+ documentTitle;
		String mimeType = binaryFile.getContentType();
		String changeLog = StringPool.BLANK;
		long repositoryId = getRepositoryId(serviceContext);

		debugLog("repositoryId: " + repositoryId);

		DLFileEntry dlFileEntry = null;
		Map<String, DDMFormValues> ddmFormValuesMap = new HashMap<String, DDMFormValues>();

		DLFileEntryType jiraFileEntryType = DLFileEntryTypeLocalServiceUtil
				.getBasicDocumentDLFileEntryType();

		InputStream is = binaryFile.getInputStream();
		File file = FileUtil.createTempFile(is);
		// TODO: Metadata parsing and attaching it to document.

		// Add map and file object
		dlFileEntry = DLFileEntryLocalServiceUtil.addFileEntry(DEFAULT_USER_ID,
				serviceContext.getScopeGroupId(), repositoryId,
				uploadFolder.getFolderId(), fileName, mimeType, title,
				description, changeLog, jiraFileEntryType.getFileEntryTypeId(),
				ddmFormValuesMap, file, is, binaryFile.getSize(),
				serviceContext);
		is.close();
		debugLog("File Added with ID: " + dlFileEntry.getFileEntryId());

		DLAppServiceUtil.updateFileEntry(dlFileEntry.getFileEntryId(),
				dlFileEntry.getFileName(), mimeType, title, description,
				changeLog, DLVersionNumberIncrease.NONE, file, serviceContext);
		debugLog("Updated file status");
	}

	private static void debugLog(Object msg) {
		if (_log.isDebugEnabled()) {
			_log.debug(msg);
		}
	}

	private static final Log _log = LogFactoryUtil
			.getLog(JiraAPIHandlerResourceImpl.class);
}