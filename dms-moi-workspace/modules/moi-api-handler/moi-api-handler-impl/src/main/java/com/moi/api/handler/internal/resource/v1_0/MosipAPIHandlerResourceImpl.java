package com.moi.api.handler.internal.resource.v1_0;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFileEntryType;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.model.DLVersionNumberIncrease;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryTypeServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.dynamic.data.mapping.kernel.DDMForm;
import com.liferay.dynamic.data.mapping.kernel.DDMFormField;
import com.liferay.dynamic.data.mapping.kernel.DDMFormFieldValue;
import com.liferay.dynamic.data.mapping.kernel.DDMFormValues;
import com.liferay.dynamic.data.mapping.kernel.DDMStructure;
import com.liferay.dynamic.data.mapping.kernel.LocalizedValue;
import com.liferay.dynamic.data.mapping.kernel.Value;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ResourcePermissionServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.multipart.BinaryFile;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import com.liferay.portal.vulcan.pagination.Page;
import com.moi.api.handler.dto.v1_0.DocumentResult;
import com.moi.api.handler.internal.result.APIConstants;
import com.moi.api.handler.internal.result.GenerateDocumentResult;
import com.moi.api.handler.resource.v1_0.MosipAPIHandlerResource;
import com.moi.dms.delete.documents.service.MOIDeleteDocumentsLocalServiceUtil;
import com.moi.dms.id.mapper.model.MOIIdMapper;
import com.moi.dms.id.mapper.service.MOIIdMapperLocalServiceUtil;
import com.moi.dms.mosip.constants.CommonConstants;
import com.moi.dms.mosip.constants.MOIProperties;
import com.moi.dms.mosip.constants.MosipConstants;
import com.moi.dms.mosip.constants.MosipErrorConstants;
import com.moi.dms.mosip.constants.MosipPhase;
import com.moi.dms.trace.request.model.MOITraceRequest;
import com.moi.dms.trace.request.service.MOITraceRequestLocalServiceUtil;
import com.moi.mosip.validator.MosipUtil;
import com.moi.mosip.validator.MosipValidator;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.activation.MimetypesFileTypeMap;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Mohit
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/mosip-api-handler.properties",
	scope = ServiceScope.PROTOTYPE, service = MosipAPIHandlerResource.class
)
public class MosipAPIHandlerResourceImpl
	extends BaseMosipAPIHandlerResourceImpl {
	
	
	private String MOSIP_SITE_FRIENDLY_URL="/mosip";
	private String FOLDER_NAME_DYNAMIC_PARAM="{folderName}";
	private String GROUP_NOT_FOUND="Oops !! Problem Identifying Mosip Group, Please contact DMS Administrator";		
	private String UNABLE_TO_CREATE_FOLDER="Oops !! Problem Creating folder with Name "+FOLDER_NAME_DYNAMIC_PARAM+", Please contact DMS Administrator";	
	private String DOCUMENT_TYPE_ALREADY_EXIST="Looks like "+MosipConstants.DOCUMENT_TYPE_DYNAMIC_PARAMETER+" Document Already Exist. Please upload another Document type or call update API";	

	private String CURRENT_STATE_PRE_REGISTRATION="PRE_REGISTRATION";
	
	private String CURRENT_STATE_REGISTRATION="REGISTRATION";
	private String CURRENT_STATE_FREEZED="FREEZED";
	private String CURRENT_STATE_AGENT_FOR_PORTAL="AGENT_FOR_PORTAL";
	// TODO: Ths is static user. Need to find a way to get original user.
	private static long DEFAULT_USER_ID = 20130;
	
	@Override
	public Page<DocumentResult> uploadMosipDocument(String ModuleType,
			String ConsumerCode, String DocumentType, String IdentifierNumber,
			String Metadata, String PreviousModuleType,
			String PreviousIdentifier, MultipartBody multipartBody)
			throws Exception {

		BinaryFile file = multipartBody
				.getBinaryFile(CommonConstants.JIRA_REQ_PARAM_DOCUMENT);

		
		
		long userId = 0;

		/*
		 * Entry Point : Trace the request
		 */
		MOITraceRequest moiTraceRequest = null;
		try {
			moiTraceRequest = MOITraceRequestLocalServiceUtil
					.addMOITraceRequest(String.valueOf(userId), new Date(),
							ConsumerCode, null,
							MosipUtil.getAction(DocumentType, true),
							DocumentType, false, null, null, StringPool.BLANK);
			MosipValidator.updateTraceComment("Mapping Initiated",
					moiTraceRequest);
		} catch (PortalException e) {
			_log.error(e);
		}

		
		/* Start : Check file */
		if(Validator.isNull(file)) {
			MosipValidator.updateTraceComment(
					"Document is blank/Empty" ,
					moiTraceRequest);
			return GenerateDocumentResult.generateDocumentResult(
					moiTraceRequest.getRequestId(), APIConstants.FAILURE,
					MosipErrorConstants.MOSIP_BLANK_DOCUMENT, null);
		}
		
		
		
		String validationResult = MosipValidator.validateRequest(ModuleType,
				ConsumerCode, DocumentType, IdentifierNumber, userId, file,
				moiTraceRequest, PreviousModuleType, PreviousIdentifier, true);

		_log.info(" validationResult  :"+validationResult);
		if (Validator.isNotNull(validationResult)) {
			return GenerateDocumentResult.generateDocumentResult(
					moiTraceRequest.getRequestId(), APIConstants.FAILURE,
					validationResult, null);
		}

		/* Identifier Check */
			
				
		Group group = GroupLocalServiceUtil.fetchFriendlyURLGroup(
				CompanyThreadLocal.getCompanyId(), MOSIP_SITE_FRIENDLY_URL);

		if (Validator.isNull(group)) {
			MosipValidator.updateTraceComment(GROUP_NOT_FOUND, moiTraceRequest);
			MosipValidator.updateTraceRequest(GROUP_NOT_FOUND, moiTraceRequest,
					false);

			return GenerateDocumentResult.generateDocumentResult(
					moiTraceRequest.getRequestId(), APIConstants.FAILURE,
					GROUP_NOT_FOUND, null);
		}

	
		
		Map<String, String> idMapperResult =	MosipValidator.validateIDMapper(group.getGroupId(), group.getCompanyId(),
				userId, IdentifierNumber, ModuleType, PreviousIdentifier, DocumentType, PreviousModuleType, moiTraceRequest);

		System.out.println("idMapperResult=="+idMapperResult);
		if (Validator.isNotNull(idMapperResult)) {

			String error = idMapperResult.get(MosipConstants.ERROR);
			String errorMessage = idMapperResult.get(MosipConstants.ERROR);
			if (Validator.isNotNull(error)) {
				MosipValidator.updateTraceComment(error, moiTraceRequest);
				MosipValidator.updateTraceRequest(error, moiTraceRequest,
						false);

				return GenerateDocumentResult.generateDocumentResult(
						moiTraceRequest.getRequestId(), APIConstants.FAILURE,
						errorMessage, null);
			}
		}
		ServiceContext serviceContext = ServiceContextThreadLocal
				.getServiceContext();
		
		return processNewDocument(IdentifierNumber, group.getGroupId(), userId,
				ModuleType, serviceContext, file, DocumentType,
				IdentifierNumber, moiTraceRequest,idMapperResult);
	}

	

	@Override
	public Page<DocumentResult> updateMosipDocument(String ModuleType,
			String ConsumerCode, String DocumentType, String IdentifierNumber,
			String Metadata, String PreviousModuleType,
			String PreviousIdentifier, MultipartBody multipartBody)
			throws Exception {
		
		
		
		
		return super.updateMosipDocument(ModuleType, ConsumerCode, DocumentType,
				IdentifierNumber, Metadata, PreviousModuleType, PreviousIdentifier,
				multipartBody);
	}

	@Override
	public Page<DocumentResult> getMosipDocument(String ModuleType,
			String ConsumerCode, String DocumentType, String Identifier)
			throws Exception {

		// Authorize and authenticate user - To be done by OAuth 2.0
		// Get user id & serviceContext
		ServiceContext serviceContext = ServiceContextThreadLocal
				.getServiceContext();
		long userId = serviceContext.getUserId();

		// TODO: Remove in actual implementation.
		if (0 == userId) {
			userId = DEFAULT_USER_ID;
		}

		debugLog("ModuleType: " + ModuleType);
		debugLog("ConsumerCode: " + ConsumerCode);
		debugLog("DocumentType: " + DocumentType);
		debugLog("Identifier: " + Identifier);
		debugLog("userId: " + userId);

		/*
		 * Entry Point : Trace the request
		 */
		MOITraceRequest moiTraceRequest = null;
		try {
			moiTraceRequest = MOITraceRequestLocalServiceUtil
					.addMOITraceRequest(String.valueOf(userId), new Date(),
							ConsumerCode, null,
							MosipUtil.getAction(DocumentType, true),
							DocumentType, false, null, null, StringPool.BLANK);
		} catch (PortalException e) {
			_log.error(e);
		}

		// TODO: Perform Validation:

		// TODO: Start download process:
		StringBuilder fileName = new StringBuilder(DocumentType)
				.append(StringPool.UNDERLINE).append(Identifier);
		Folder folder = getFolder(Identifier, false, serviceContext);
		FileEntry fileEntry = getFileEntry(folder, fileName.toString(),
				serviceContext);

		if (null != fileEntry) {
			return GenerateDocumentResult.generateDocumentResult(
					moiTraceRequest.getRequestId(), APIConstants.SUCCESS,
					"Successful",
					FileUtil.getBytes(fileEntry.getContentStream()));
		} else {
			return GenerateDocumentResult.generateDocumentResult(
					moiTraceRequest.getRequestId(), APIConstants.FAILURE,
					"Failure", null);
		}
	}

	/**
	 * This API will fetch a csv file and store it in a predefined folder
	 * location. This csv file will contain identifier number which would be
	 * then deleted by DMS Admin.
	 * 
	 * @param ModuleType
	 * @param ConsumerCode
	 * @param multipartBody
	 */
	@Override
	public Page<DocumentResult> deleteMosipDocument(String ModuleType,
			String ConsumerCode, MultipartBody multipartBody) throws Exception {

		// Authorize and authenticate user - To be done by OAuth 2.0
		// Get user id & serviceContext
		ServiceContext serviceContext = ServiceContextThreadLocal
				.getServiceContext();
		long userId = serviceContext.getUserId();

		// TODO: Remove in actual implementation.
		if (0 == userId) {
			userId = DEFAULT_USER_ID;
		}

		String moduleTypeParam = getMosipUploadDocParams(
				CommonConstants.MOSIP_REQ_PARAM_MODULE_TYPE, ModuleType,
				multipartBody);

		String consumerCodeParam = getMosipUploadDocParams(
				CommonConstants.MOSIP_REQ_PARAM_CONSUMER_CODE, ConsumerCode,
				multipartBody);

		debugLog("ModuleType: " + moduleTypeParam);
		debugLog("ConsumerCode: " + consumerCodeParam);

		BinaryFile binaryFile = multipartBody
				.getBinaryFile(CommonConstants.MOSIP_REQ_PARAM_DOCUMENT);

		// TODO: Mohit to check this part.
		String DocumentType = "Bulk_Delete_File";

		/*
		 * Entry Point : Trace the request
		 */
		MOITraceRequest moiTraceRequest = null;
		try {
			moiTraceRequest = MOITraceRequestLocalServiceUtil
					.addMOITraceRequest(String.valueOf(userId), new Date(),
							consumerCodeParam, null,
							MosipUtil.getAction(DocumentType, true),
							DocumentType, false, null, null, StringPool.BLANK);
		} catch (PortalException e) {
			debugLog(e);
		}

		// TODO: Perform Validation.
		String validationResult = "";

		if (Validator.isNotNull(validationResult)) {
			return GenerateDocumentResult.generateDocumentResult(
					moiTraceRequest.getRequestId(), APIConstants.FAILURE,
					validationResult, null);
		}

		// Fetch folder name from propertiees file.
		// TODO: Add error string
		String folderName = PropsUtil
				.get(MOIProperties.MOSIP_DELETE_FOLDER_NAME);
		if(Validator.isNull(folderName)) {
			return GenerateDocumentResult.generateDocumentResult(
					moiTraceRequest.getRequestId(), APIConstants.FAILURE,
					"", null);
		}

		// Check Folder. If Folder not available, create new folder with
		// ticket number
		Folder uploadFolder = null;
		try {
			uploadFolder = getFolder(folderName, true, serviceContext);
			debugLog("folderId: " + uploadFolder.getFolderId());

			FileEntry fileEntry = uploadDeleteCSVFile(binaryFile, uploadFolder.getFolderId(),
					serviceContext);

			// Perform Custom Table entry
			String userScreenName = UserLocalServiceUtil
					.getUser(fileEntry.getUserId()).getScreenName();
			MOIDeleteDocumentsLocalServiceUtil.addMOIDeleteDocuments(
					fileEntry.getFileEntryId(), fileEntry.getFileName(),
					consumerCodeParam, moduleTypeParam, userScreenName,
					new Date(), "Pending", StringPool.BLANK, StringPool.BLANK,
					null, StringPool.BLANK);

		} catch (PortalException | IOException e) {
			MosipUtil.updateTraceRequest(MosipErrorConstants.JIRA_COMMON_ERROR,
					moiTraceRequest);
			return GenerateDocumentResult.generateDocumentResult(
					moiTraceRequest.getRequestId(), APIConstants.FAILURE,
					MosipErrorConstants.JIRA_COMMON_ERROR, null);
		}

		MosipUtil.updateTraceRequest(MosipErrorConstants.JIRA_FILE_UPLOADED_MSG,
				moiTraceRequest);
		return GenerateDocumentResult.generateDocumentResult(
				moiTraceRequest.getRequestId(), APIConstants.SUCCESS,
				MosipErrorConstants.JIRA_FILE_UPLOADED_MSG, null);
	}

	@Override
	public Page<DocumentResult> addIDCSNumber(String RegistrationNumber,
			String IDCSNumber) throws Exception {
		// TODO Auto-generated method stub
		return super.addIDCSNumber(RegistrationNumber, IDCSNumber);
	}

	/*
	 * This method is used to check if Folder Exist
	 *
	 * @param folderName
	 * @param groupId
	 * @return :
	 */
	private DLFolder checkFolder(String folderName, long groupId) {
		return DLFolderLocalServiceUtil.fetchFolder(groupId, 0,
				folderName);
		
	}
	
	/*
	 * This method is used to Create folder
	 *
	 * @param folderName
	 * @param groupId
	 * @param userId
	 * @param moduleType
	 * @param serviceContext
	 * @return :
	 */
	private long createFolder(String folderName, long groupId,
			ServiceContext serviceContext) {
		try {
			Folder folder = DLAppServiceUtil.addFolder(
					serviceContext.getScopeGroupId(),
					DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, folderName,
					folderName, serviceContext);
			setPermission(folder.getCompanyId(), folder.getGroupId(),
					folder.getFolderId(), DLFolder.class.getName());
			return folder.getFolderId();
		} catch (PortalException e) {
			_log.error(e);
			return 0;
		}
	}
	
	/**
	 * This method is used to Set permission for the resource
	 *
	 * @param companyId
	 * @param groupId
	 * @param primKey
	 * @param className
	 * @throws PortalException :
	 */
	private void setPermission(long companyId, long groupId, long primKey,
			String className) throws PortalException {
		
		/* Setting permission for Resource */
		Role guestRole = RoleLocalServiceUtil.getRole(companyId,
				RoleConstants.SITE_MEMBER);
		ResourcePermissionServiceUtil.setIndividualResourcePermissions(groupId,
				companyId, className, String.valueOf(primKey),
				guestRole.getRoleId(), new String[]{"VIEW", "UPDATE"});

	}
	private static String METADATA_SETS_NAME = "RNP";
	private static String PRE_REG_ID = "Pre Registration Number";
	private static String REG_ID = "Registration Number";
	private static String IDCS_ID = "IDCS Number";
	/**
	 * This method is used to Process Document
	 *
	 * @param folderName
	 * @param groupId
	 * @param userId
	 * @param moduleType
	 * @param serviceContext
	 * @param moiTraceRequest
	 * @return :
	 */
	private Page<DocumentResult> processNewDocument(String folderName, long groupId, long userId,
			String moduleType, ServiceContext serviceContext, BinaryFile file,String documentType,String identifier,
			MOITraceRequest moiTraceRequest,
			Map<String, String> idMapperResult) {

		MosipValidator.updateTraceComment("{ Processing Document ",
				moiTraceRequest);

		long folderId = 0;
		DLFolder dlFolder = checkFolder(folderName, groupId);
		boolean newFolder = false;
		if (Validator.isNull(dlFolder)) {
			MosipValidator.updateTraceComment(
					"folderName " + folderName
							+ " is not available, Start creating it ",
					moiTraceRequest);
			folderId = createFolder(folderName, groupId, serviceContext);

			if (folderId == 0) {
				MosipValidator.updateTraceComment(
						"Unable to Create folderName :" + folderName,
						moiTraceRequest);
				MosipValidator.updateTraceRequest(
						UNABLE_TO_CREATE_FOLDER
								.replace(FOLDER_NAME_DYNAMIC_PARAM, folderName),
						moiTraceRequest, false);
				return GenerateDocumentResult
						.generateDocumentResult(moiTraceRequest.getRequestId(),
								APIConstants.FAILURE,
								UNABLE_TO_CREATE_FOLDER.replace(
										FOLDER_NAME_DYNAMIC_PARAM, folderName),
								null);
			}

			newFolder = true;
		}

		/* Generating Document Title */
		String documentTitle = MosipUtil.generateDocumentTitle(documentType,
				identifier);

		/* Checking Existing Document */
		DLFileEntry fileEntry = null;
		if (!newFolder) {

			fileEntry = DLFileEntryLocalServiceUtil.fetchFileEntry(groupId,
					folderId, documentTitle);
			if (Validator.isNotNull(fileEntry)) {
				return GenerateDocumentResult.generateDocumentResult(
						moiTraceRequest.getRequestId(), APIConstants.FAILURE,
						DOCUMENT_TYPE_ALREADY_EXIST.replace(
								MosipConstants.DOCUMENT_TYPE_DYNAMIC_PARAMETER,
								documentType),
						null);
			}

		}
		/*
		 * Validate Document Title, Should be added If not added. If already
		 * added, then Throw Exception
		 */

		return uploadNewDocument(folderId, groupId, userId, moduleType, serviceContext,
				file, documentType, identifier, moiTraceRequest,
				idMapperResult);
	}
	
	
	
	/**
	 * This method is used to Process Document
	 *
	 * @param folderName
	 * @param groupId
	 * @param userId
	 * @param moduleType
	 * @param serviceContext
	 * @param moiTraceRequest
	 * @return :
	 */
	private Page<DocumentResult> uploadNewDocument(long folderId, long groupId, long userId,
			String moduleType, ServiceContext serviceContext, BinaryFile file,String documentType,String identifier,
			MOITraceRequest moiTraceRequest,
			Map<String, String> idMapperResult) {

		MosipValidator.updateTraceComment("{ Upload Document Process Start ",
				moiTraceRequest);

		/* Generating Document Title */
		String documentTitle = MosipUtil.generateDocumentTitle(documentType,
				identifier);

		/* Generating Document Description */
		String documentDesc = MosipUtil.generateDocumentDescription(null,
				documentType, identifier);

		/* Generating Document Metada */
		String documentMetadata = MosipUtil.generateDocumentMetadata(null,
				documentType, identifier);

		String changeLog = null;
		List<DLFileEntryType> fileEntryTypes;

		InputStream is = null;

		try {
			/* Fetching Custome Document Type */
			fileEntryTypes = DLFileEntryTypeServiceUtil.getFolderFileEntryTypes(
					PortalUtil.getCurrentAndAncestorSiteGroupIds(groupId),
					folderId, true);

			DLFileEntryType mosipFileEntryType = null;
			DDMStructure ddmStruct = null;
			DDMFormValues ddmFormValues = null;
			for (DLFileEntryType fileEntryType : fileEntryTypes) {
				if (METADATA_SETS_NAME
						.equalsIgnoreCase(fileEntryType.getName(Locale.US))) {
					mosipFileEntryType = fileEntryType;

					break;
				}
			}

			if (Validator.isNull(mosipFileEntryType)) {
				MosipValidator.updateTraceComment("File Entry Type is null ",
						moiTraceRequest);
				return GenerateDocumentResult
						.generateDocumentResult(moiTraceRequest.getRequestId(),
								APIConstants.FAILURE,
								"File Entry Type is null " + documentType
										+ ": Please contact DMS Administrator",
								null);
			}

			List<DDMStructure> structures = mosipFileEntryType
					.getDDMStructures();
			for (DDMStructure struct : structures) {
				if (METADATA_SETS_NAME
						.equalsIgnoreCase(struct.getName(Locale.US))) {
					ddmStruct = struct;
					break;
				}
			}

			if (Validator.isNull(ddmStruct)) {
				MosipValidator.updateTraceComment("DMS Structure ",
						moiTraceRequest);
				return GenerateDocumentResult
						.generateDocumentResult(moiTraceRequest.getRequestId(),
								APIConstants.FAILURE,
								"DMS Structure is null " + documentType
										+ ": Please contact DMS Administrator",
								null);
			}

			DDMForm ddmForm = ddmStruct.getDDMForm();
			List<DDMFormField> ddmFormFields = ddmForm.getDDMFormFields();

			List<DDMFormFieldValue> ddmFormFieldValues = new ArrayList<DDMFormFieldValue>();

			int i = 0;
			for (DDMFormField formField : ddmFormFields) {
				Value value = new LocalizedValue();
				DDMFormFieldValue ddmFormFieldValue = new DDMFormFieldValue();
				i++;
				if (PRE_REG_ID.equalsIgnoreCase(
						formField.getLabel().getString(Locale.US))
						&& moduleType
								.equals(MosipPhase.PRE_REGISTRATION_PHASE)) {
					value.addString(Locale.US, identifier);
					ddmFormFieldValue.setName(formField.getName());
					ddmFormFieldValue.setValue(value);
					ddmFormFieldValues.add(ddmFormFieldValue);
				} else if (REG_ID.equalsIgnoreCase(
						formField.getLabel().getString(Locale.US))
						&& moduleType.equals(MosipPhase.REGISTRATION_PHASE)) {
					value.addString(Locale.US, identifier);
					ddmFormFieldValue.setName(formField.getName());
					ddmFormFieldValue.setValue(value);
					ddmFormFieldValues.add(ddmFormFieldValue);
				} else if (IDCS_ID.equalsIgnoreCase(
						formField.getLabel().getString(Locale.US))
						&& moduleType.equals(MosipPhase.FREEZED_PHASE)) {
					value.addString(Locale.US, identifier);
					ddmFormFieldValue.setName(formField.getName());
					ddmFormFieldValue.setValue(value);
					ddmFormFieldValues.add(ddmFormFieldValue);
				}
			}

			// Set the name of value you need to set
			Set<Locale> localeSet = new HashSet<Locale>();
			localeSet.add(Locale.US);
			ddmFormValues = new DDMFormValues(ddmForm);
			ddmFormValues.setAvailableLocales(localeSet);
			ddmFormValues.setDefaultLocale(Locale.US);
			ddmFormValues.setDDMFormFieldValues(ddmFormFieldValues);

			Map<String, DDMFormValues> ddmFormValuesMap = new HashMap<String, DDMFormValues>();
			ddmFormValuesMap.put(ddmStruct.getStructureKey(), ddmFormValues);

			MimetypesFileTypeMap fileTypeMap = new MimetypesFileTypeMap();
			String mimeType = fileTypeMap.getContentType(file.getFileName());

			is = file.getInputStream();


			MosipValidator.updateTraceComment(
					"Starting file upload for Module type  " + moduleType
							+ " and Identifier :" + identifier,
					moiTraceRequest);

			MosipValidator.updateTraceComment(
					"Starting file upload in Folder ID " + folderId,
					moiTraceRequest);
			MosipValidator.updateTraceComment(
					"Starting file upload with title " + documentTitle,
					moiTraceRequest);
			MosipValidator.updateTraceComment(
					"Starting file upload Document Type " + documentType,
					moiTraceRequest);

			DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.addFileEntry(
					userId, groupId, groupId, folderId, documentTitle, mimeType,
					documentTitle, documentDesc, changeLog,
					mosipFileEntryType.getFileEntryTypeId(), ddmFormValuesMap,
					null, is, file.getSize(), serviceContext);
			MosipValidator
					.updateTraceComment(
							"File Added Draft Status with File Entry ID "
									+ dlFileEntry.getFileEntryId()
									+ " and Identifier :" + identifier,
							moiTraceRequest);

			DLAppServiceUtil.updateFileEntry(dlFileEntry.getFileEntryId(),dlFileEntry.getFileName(),dlFileEntry.getMimeType(),
					dlFileEntry.getTitle(),dlFileEntry.getDescription(),null,DLVersionNumberIncrease.NONE,is,file.getSize(),serviceContext);

			MosipValidator
					.updateTraceComment(
							"File Updated Published Status with File Entry ID "
									+ dlFileEntry.getFileEntryId()
									+ " and Identifier :" + identifier,
							moiTraceRequest);
			MosipValidator.updateTraceRequest(
					"File Uploaded with Document Type :" + documentType
							+ " and Identifier :" + identifier,
					moiTraceRequest, true);
		} catch (PortalException e) {
			_log.error(e);
			MosipValidator.updateTraceComment(
					"Error uploading File " + e.getMessage(), moiTraceRequest);
			MosipValidator.updateTraceRequest(
					"Error uploading File " + e.getMessage()
							+ " and Identifier :" + identifier,
					moiTraceRequest, true);
			return GenerateDocumentResult
					.generateDocumentResult(moiTraceRequest.getRequestId(),
							APIConstants.FAILURE,
							"DMS Portal Error uploading " + documentType
									+ ": Please contact DMS Administrator",
							null);
		} catch (Exception e) {
			_log.error(e);
			MosipValidator.updateTraceComment(
					"Error uploading File " + e.getMessage(), moiTraceRequest);
			MosipValidator.updateTraceRequest(
					"Error uploading File " + e.getMessage()
							+ " and Identifier :" + identifier,
					moiTraceRequest, true);
			return GenerateDocumentResult
					.generateDocumentResult(moiTraceRequest.getRequestId(),
							APIConstants.FAILURE,
							"DMS File Error uploading " + documentType
									+ ": Please contact DMS Administrator",
							null);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					_log.error(e);
				}
			}
		}

		/*
		 * Validate Document Title, Should be added If not added. If already
		 * added, then Throw Exception
		 */

		return GenerateDocumentResult.generateDocumentResult(
				moiTraceRequest.getRequestId(), APIConstants.SUCCESS,
				"Document Type :" + documentType + " Successfully uploaded ",
				null);
	}
	
	
	/**
	 * This method is used to Process Identifier and Mapping
	 *
	 * @param identifierNumber
	 * @param previousModule
	 * @param previousIdentifier
	 * @param moiTraceRequest
	 * @param documentType
	 * @param ModuleType
	 * @param group
	 * @param userId
	 */
	private void processIdentifier(String identifierNumber, String previousModule , String previousIdentifier,
			MOITraceRequest moiTraceRequest,String documentType,String ModuleType, Group group,long userId) {

		MosipValidator.updateTraceComment("No Id Found for Identifier :"
				+ identifierNumber + "and Phase " + ModuleType
				+ ". Therefore Adding into Mapper", moiTraceRequest);

		try {
			MOIIdMapper moiIdMapper = MOIIdMapperLocalServiceUtil
					.addMOIIdMapper(group.getCompanyId(), group.getCompanyId(),
							CURRENT_STATE_PRE_REGISTRATION, documentType,
							identifierNumber,
							CounterLocalServiceUtil
									.increment(MOIIdMapper.class.getName()),
							null, 1, null, new Date(), String.valueOf(userId));
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	private Folder getFolder(String folderName, boolean createNew, ServiceContext serviceContext)
			throws PortalException {
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
	 * Method to fetch File
	 * 
	 * @param folder
	 * @param documentTitle
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 */
	private FileEntry getFileEntry(Folder folder, String fileName,
			ServiceContext serviceContext) {

		FileEntry fileEntry = null;

		try {
			fileEntry = DLAppServiceUtil.getFileEntry(
					serviceContext.getScopeGroupId(), folder.getFolderId(),
					fileName.toString());

		} catch (PortalException e) {
			if (_log.isErrorEnabled()) {
				_log.error(e);
			}
		}
		return fileEntry;
	}

	/**
	 * This method uploads delete csv file to predefined folder.
	 * 
	 * @param binaryFile
	 * @param uploadFolder
	 * @param serviceContext
	 * @throws PortalException
	 * @throws IOException
	 */
	private FileEntry uploadDeleteCSVFile(BinaryFile binaryFile, long folderId,
			ServiceContext serviceContext) throws PortalException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyyy_HH:mm:ss:SSS");

		FileEntry fileEntry = null;
		String sourceFileName = binaryFile.getFileName();
		String title = sdf.format(new Date()) + ".csv";
		String description = sdf.format(new Date());
		String mimeType = binaryFile.getContentType();
		String changeLog = StringPool.BLANK;
		long repositoryId = serviceContext.getScopeGroupId();
		InputStream is = binaryFile.getInputStream();

		debugLog("repositoryId: " + repositoryId);
		debugLog("sourceFileName: " + sourceFileName);
		debugLog("title: " + title);

		// Add file object
		fileEntry = DLAppServiceUtil.addFileEntry(repositoryId, folderId,
				sourceFileName, mimeType, title, description, changeLog, is,
				binaryFile.getSize(), serviceContext);
		is.close();

		debugLog("File Added with ID: " + fileEntry.getFileEntryId());
		return fileEntry;
	}

	/**
	 * Get parameter either from request URL or from request body
	 * 
	 * @param paramName
	 * @param paramValue
	 * @param multipartBody
	 * @return String
	 */
	private String getMosipUploadDocParams(String paramName, String paramValue,
			MultipartBody multipartBody) {

		String value = null;
		if (null == paramValue || paramValue.isEmpty()) {
			value = multipartBody.getValueAsString(paramName);
		} else {
			value = paramValue;
		}
		return value;
	}

	private static void debugLog(Object msg) {
		// if(_log.isDebugEnabled()) {
		_log.debug(msg);
		// }
	}

	private static final Log _log = LogFactoryUtil
			.getLog(MosipAPIHandlerResourceImpl.class);
}