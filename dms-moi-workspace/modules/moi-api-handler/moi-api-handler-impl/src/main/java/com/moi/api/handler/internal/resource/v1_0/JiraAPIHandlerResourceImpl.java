package com.moi.api.handler.internal.resource.v1_0;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFileEntryType;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLVersionNumberIncrease;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryTypeServiceUtil;
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
import com.liferay.portal.kernel.util.PortalUtil;
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
import java.util.List;
import java.util.Locale;
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

	@Override
	public Page<DocumentResult> uploadJiraDocument(String consumerCode,
			String ticketNumber, String documentTitle, String metadata,
			MultipartBody multipartBody) {

		// Authorize and authenticate user - To be done by OAuth 2.0
		// Get user id & serviceContext
		ServiceContext serviceContext = ServiceContextThreadLocal
				.getServiceContext();
		long userId = serviceContext.getUserId();
		System.out.println("User Id: " + userId);

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
		System.out.println(consumerCodeParam + "::" + ticketNumberParam + "::"
				+ documentTitleParam + "::" + metadataParam);

		BinaryFile binaryFile = multipartBody
				.getBinaryFile(CommonConstants.JIRA_REQ_PARAM_DOCUMENT);

		/*
		 * Entry Point : Trace the request
		 */
		MOITraceRequest moiTraceRequest = null;

		try {
			moiTraceRequest = MOITraceRequestLocalServiceUtil
					.addMOITraceRequest(String.valueOf(userId), new Date(),
							consumerCodeParam, null,
							JiraUtil.getAction(documentTitle, true),
							documentTitle, true, null, null, StringPool.BLANK);
		} catch (PortalException e) {
			e.printStackTrace();
			_log.error(e);
		}

		/*
		 * validateRequest() method will Check input parameters, Consumer Code
		 * and Document Type
		 */
		String validationResult = JiraValidator.validateRequest(
				consumerCodeParam, ticketNumberParam, documentTitleParam,
				metadataParam, binaryFile, moiTraceRequest);
		System.out.println("validationResult: " + validationResult);

		if (Validator.isNotNull(validationResult)) {
			return GenerateDocumentResult.generateDocumentResult(
					moiTraceRequest.getRequestId(), APIConstants.FAILURE,
					validationResult);
		}

		// Check Folder. If Folder not available, create new folder with
		// ticket number
		Folder uploadFolder = null;
		try {
			uploadFolder = getFolder(ticketNumberParam, serviceContext);

			// Check if File exists
			boolean fileExists = isFileExist(uploadFolder, documentTitleParam,
					FileUtil.getExtension(binaryFile.getFileName()),
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
						MosipErrorConstants.JIRA_FILE_EXISTS_MSG);
			}
		} catch (PortalException | IOException e) {
			JiraUtil.updateTraceRequest(MosipErrorConstants.JIRA_COMMON_ERROR,
					moiTraceRequest);
			return GenerateDocumentResult.generateDocumentResult(
					moiTraceRequest.getRequestId(), APIConstants.FAILURE,
					MosipErrorConstants.JIRA_COMMON_ERROR);
		}
		JiraUtil.updateTraceRequest(MosipErrorConstants.JIRA_FILE_UPLOADED_MSG,
				moiTraceRequest);
		return GenerateDocumentResult.generateDocumentResult(
				moiTraceRequest.getRequestId(), APIConstants.SUCCESS,
				MosipErrorConstants.JIRA_FILE_UPLOADED_MSG);
	}

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

	private DLFolder isFolderExist(String folderName) {
		DLFolder dlFolder = null;

		List<DLFolder> dlFolders = DLFolderLocalServiceUtil.getDLFolders(0,
				DLFolderLocalServiceUtil.getDLFoldersCount());
		for (DLFolder folder : dlFolders) {
			if (folderName.equalsIgnoreCase(folder.getName())) {
				dlFolder = folder;
				break;
			}
		}
		return dlFolder;
	}

	private boolean isFileExist(Folder folder, String documentTitle, String ext,
			ServiceContext serviceContext) throws PortalException {

		boolean fileExists = false;
		StringBuilder fileName = new StringBuilder(32);
		fileName.append(folder.getName()).append(StringPool.UNDERLINE)
				.append(documentTitle).append(StringPool.PERIOD).append(ext);

		List<FileEntry> fileEntryList = DLAppServiceUtil.getFileEntries(
				getRepositoryId(serviceContext), folder.getFolderId());
		for (FileEntry fileEntry : fileEntryList) {
			if (fileEntry.getFileName().equals(fileName.toString())) {
				fileExists = true;
			}
		}
		return fileExists;
	}

	/*
	 * private long getRepositoryId() { long repoId = 0; List<Repository>
	 * repoList = RepositoryLocalServiceUtil.getRepositories( 0,
	 * RepositoryLocalServiceUtil.getRepositoriesCount()); for (Repository repo
	 * : repoList) { if ("".equalsIgnoreCase(repo.getName())) { repoId =
	 * repo.getRepositoryId(); } } return repoId; }
	 */

	private long getRepositoryId(ServiceContext serviceContext) {
		return serviceContext.getScopeGroupId();
	}

	private Folder getFolder(String folderName, ServiceContext serviceContext)
			throws PortalException {
		DLFolder dlFolder = isFolderExist(folderName);
		Folder folder = null;
		if (null == dlFolder) {
			try {
				folder = DLAppServiceUtil.addFolder(
						serviceContext.getScopeGroupId(),
						CommonConstants.JIRA_PARENT_FOLDER_ID, folderName,
						StringPool.BLANK, serviceContext);
			} catch (PortalException e1) {
				e1.printStackTrace();
			} catch (SystemException e1) {
				e1.printStackTrace();
			}
		} else {
			folder = DLAppServiceUtil.getFolder(dlFolder.getFolderId());
		}
		return folder;
	}

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

		DLFileEntry dlFileEntry = null;
		List<DLFileEntryType> fileEntryTypes = null;
		DLFileEntryType jiraFileEntryType = null;
		Map<String, DDMFormValues> ddmFormValuesMap = new HashMap<String, DDMFormValues>();

		fileEntryTypes = DLFileEntryTypeServiceUtil.getFolderFileEntryTypes(
				PortalUtil.getCurrentAndAncestorSiteGroupIds(
						serviceContext.getScopeGroupId()),
				uploadFolder.getFolderId(), true);

		for (DLFileEntryType fileEntryType : fileEntryTypes) {
			if (CommonConstants.JIRA_METADATA_SETS_NAME
					.equalsIgnoreCase(fileEntryType.getName(Locale.US))) {
				jiraFileEntryType = fileEntryType;
				break;
			}
		}

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
		System.out.println("File Added");

		DLAppServiceUtil.updateFileEntry(dlFileEntry.getFileEntryId(),
				dlFileEntry.getFileName(), mimeType, title, description,
				changeLog, DLVersionNumberIncrease.NONE, file, serviceContext);
		System.out.println("File Updated");
	}

	private static final Log _log = LogFactoryUtil
			.getLog(JiraAPIHandlerResourceImpl.class);
}