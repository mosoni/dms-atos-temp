package com.moi.api.handler.internal.resource.v1_0;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.dynamic.data.mapping.kernel.DDMFormValues;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.vulcan.multipart.BinaryFile;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import com.liferay.portal.vulcan.pagination.Page;
import com.moi.api.handler.dto.v1_0.DocumentResult;
import com.moi.api.handler.resource.v1_0.JiraAPIHandlerResource;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
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

	private static long PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

	@Override
	public Page<DocumentResult> uploadJiraDocument(String consumerCode,
			String ticketNumber, String documentTitle, String metadata,
			MultipartBody multipartBody) throws Exception {

		ServiceContext serviceContext = ServiceContextThreadLocal
				.getServiceContext();

		// Step 1: Authorize and authenticate user - To be done by OAuth 2.0
		// Step 2: Check input parameters
		String consumerCodeParam = getJiraUploadDocParams("consumerCode",
				consumerCode, multipartBody);
		String ticketNumberParam = getJiraUploadDocParams("ticketNumber",
				ticketNumber, multipartBody);
		String documentTitleParam = getJiraUploadDocParams("documentTitle",
				documentTitle, multipartBody);
		String metadataParam = getJiraUploadDocParams("metadata", metadata,
				multipartBody);

		// TODO: Step 3: Check Consumer Code

		// TODO: Step 4: Check Document Type

		// Step 5: Check Folder. If Folder not available, create new folder with
		// ticket number
		Folder uploadFolder = getFolder(ticketNumberParam, serviceContext);

		// Step 6: Check File
		boolean fileExists = isFileExist(uploadFolder, documentTitleParam,
				serviceContext);

		// Step 6.1 If file available, send error message if not upload the
		// file.
		if (!fileExists) {
			BinaryFile binaryFile = multipartBody.getBinaryFile("document");
			if (binaryFile == null) {
				System.out.println("No file found in body");
				return null;
			}
			uploadJiraFile(ticketNumberParam, documentTitleParam, metadataParam,
					binaryFile, uploadFolder, serviceContext);
		} else {

		}

		return super.uploadJiraDocument(consumerCode, ticketNumber,
				documentTitle, metadata, multipartBody);
	}

	private String getJiraUploadDocParams(String paramName, String paramValue,
			MultipartBody multipartBody) {

		String value = null;
		if (null == paramValue || paramValue.isEmpty()) {
			value = multipartBody.getValueAsString(paramName);
		} else {
			value = paramValue;
		}

		if (null == value || value.isEmpty()) {
			// Throw Exception
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

	private boolean isFileExist(Folder folder, String documentTitle,
			ServiceContext serviceContext) throws PortalException {

		boolean fileExists = false;
		String fileName = folder.getName() + "_" + documentTitle;

		List<FileEntry> fileEntryList = DLAppServiceUtil.getFileEntries(
				getRepositoryId(serviceContext), folder.getFolderId());
		for (FileEntry fileEntry : fileEntryList) {
			if (fileEntry.getFileName().equals(fileName)) {
				fileExists = true;
			}
		}
		return fileExists;
	}

	/*private long getRepositoryId() {
		long repoId = 0;
		List<Repository> repoList = RepositoryLocalServiceUtil.getRepositories(
				0, RepositoryLocalServiceUtil.getRepositoriesCount());
		for (Repository repo : repoList) {
			if ("".equalsIgnoreCase(repo.getName())) {
				repoId = repo.getRepositoryId();
			}
		}
		return repoId;
	}*/

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
						serviceContext.getScopeGroupId(), PARENT_FOLDER_ID,
						folderName, "", serviceContext);
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
			ServiceContext serviceContext) throws PortalException {
		String fileName = binaryFile.getFileName();
		String mimeType = binaryFile.getContentType();
		String title = ticketNumber + "_" + documentTitle;
		String description = ticketNumber + "_" + documentTitle;
		String changeLog = "";
		long repositoryId = getRepositoryId(serviceContext);
		long fileEntryTypeId = 0;

		DLFileEntry dlFileEntry = null;

		InputStream is = binaryFile.getInputStream();
		File file = new File("");
		Map<String, DDMFormValues> ddmFormValuesMap = new HashMap<String, DDMFormValues>();

		// Add map and file object
		dlFileEntry = DLFileEntryLocalServiceUtil.addFileEntry(
				serviceContext.getUserId(), serviceContext.getScopeGroupId(),
				repositoryId, uploadFolder.getFolderId(), fileName, mimeType,
				title, description, changeLog, fileEntryTypeId,
				ddmFormValuesMap, file, is, binaryFile.getSize(),
				serviceContext);
	}
}