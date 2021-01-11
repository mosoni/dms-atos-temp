package com.moi.api.handler.internal.resource.v1_0;

import com.liferay.dynamic.data.mapping.kernel.Value;
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
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import com.liferay.portal.vulcan.pagination.Page;
import com.moi.api.handler.dto.v1_0.DocumentResult;
import com.moi.api.handler.internal.result.APIConstants;
import com.moi.api.handler.internal.result.GenerateDocumentResult;
import com.moi.api.handler.resource.v1_0.MosipAPIHandlerResource;
import com.moi.dms.id.mapper.model.MOIIdMapper;
import com.moi.dms.id.mapper.service.MOIIdMapperLocalServiceUtil;
import com.moi.dms.mosip.constants.CommonConstants;
import com.moi.dms.trace.request.model.MOITraceRequest;
import com.moi.dms.trace.request.service.MOITraceRequestLocalServiceUtil;
import com.moi.mosip.validator.MosipUtil;
import com.moi.mosip.validator.MosipValidator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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

		File file = null;
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
		} catch (PortalException e) {
			_log.error(e);
		}

		String validationResult = MosipValidator.validateRequest(ModuleType,
				ConsumerCode, DocumentType, IdentifierNumber, userId, file,
				moiTraceRequest, true);

		if (Validator.isNotNull(validationResult)) {
			return GenerateDocumentResult.generateDocumentResult(
					moiTraceRequest.getRequestId(), APIConstants.FAILURE,
					validationResult, null);
		}

		/* Identifier Check */
		List<MOIIdMapper> idMapperList = MOIIdMapperLocalServiceUtil
				.findByRegistrationId(IdentifierNumber);
		
		Group group = GroupLocalServiceUtil.fetchFriendlyURLGroup(
				CompanyThreadLocal.getCompanyId(), MOSIP_SITE_FRIENDLY_URL);

		if(Validator.isNull(group)) {
			MosipValidator.updateTraceRequest(GROUP_NOT_FOUND, moiTraceRequest);
			return GenerateDocumentResult.generateDocumentResult(
					moiTraceRequest.getRequestId(), APIConstants.FAILURE,
					GROUP_NOT_FOUND, null);
		}
		
		if (Validator.isNull(idMapperList)) {
			
			
			/*
			 * Assuming Request is coming for the first time with
			 * IdentifierNumber
			 */
			processIdentifier(IdentifierNumber, PreviousModuleType,
					PreviousIdentifier, moiTraceRequest, DocumentType,
					ModuleType, group, userId);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		processDocument(IdentifierNumber, group.getGroupId(), userId, ModuleType, serviceContext, file, moiTraceRequest);
		
		
		return super.uploadMosipDocument(ModuleType, ConsumerCode, DocumentType,
				IdentifierNumber, Metadata, PreviousModuleType,
				PreviousIdentifier, multipartBody);
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

	@Override
	public Page<DocumentResult> deleteMosipDocument(String ModuleType,
			MultipartBody multipartBody) throws Exception {
		// TODO Auto-generated method stub
		return super.deleteMosipDocument(ModuleType, multipartBody);
	}

	@Override
	public Page<DocumentResult> addIDCSNumber(String RegistrationNumber,
			String IDCSNumber) throws Exception {
		// TODO Auto-generated method stub
		return super.addIDCSNumber(RegistrationNumber, IDCSNumber);
	}

	/*
	 * This method is used to Process folder
	 *
	 * @param folderName
	 * @param groupId
	 * @param userId
	 * @param moduleType
	 * @param serviceContext
	 * @return :
	 */
	private long processFolder(String folderName, long groupId,
			ServiceContext serviceContext) {

		DLFolder dlFolder = DLFolderLocalServiceUtil.fetchFolder(groupId, 0,
				folderName);
		if (Validator.isNull(dlFolder)) {
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
		return dlFolder.getFolderId();
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
	private static String PRE_REG_ID = "Pre-Reg Id";
	private static String REG_ID = "Reg Id";
	private static String IDCS_ID = "IDCS Id";
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
	private Page<DocumentResult> processDocument(String folderName, long groupId, long userId,
			String moduleType, ServiceContext serviceContext,File file, MOITraceRequest moiTraceRequest) {
		
		/*Processing Folder. Folder should be available with Identifier Name*/
		long folderId = processFolder(folderName, groupId, serviceContext);
		if(folderId==0) {
			MosipValidator.updateTraceRequest(UNABLE_TO_CREATE_FOLDER.replace(FOLDER_NAME_DYNAMIC_PARAM, folderName), moiTraceRequest);
			return GenerateDocumentResult.generateDocumentResult(
					moiTraceRequest.getRequestId(), APIConstants.FAILURE,
					UNABLE_TO_CREATE_FOLDER.replace(FOLDER_NAME_DYNAMIC_PARAM, folderName), null); 
		}
		
		String documentTitle = null;
		String documentDesc = null;
		String changeLog = null;
		List<DLFileEntryType> fileEntryTypes;
		
		InputStream is = null;
		
		try {
			fileEntryTypes = DLFileEntryTypeServiceUtil
					.getFolderFileEntryTypes(
							PortalUtil.getCurrentAndAncestorSiteGroupIds(
									groupId),
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
		String preRegNo = null;
		String regNo = null;
		String idcsNo = null;
		
		if (null != mosipFileEntryType) {
			
			List<DDMStructure> structures = mosipFileEntryType
					.getDDMStructures();
			for (DDMStructure struct : structures) {
				if (METADATA_SETS_NAME
						.equalsIgnoreCase(struct.getName(Locale.US))) {
					ddmStruct = struct;
					break;
				}
			}

			if (null != ddmStruct) {
			
				DDMForm ddmForm = ddmStruct.getDDMForm();
				List<DDMFormField> ddmFormFields = ddmForm
						.getDDMFormFields();

				List<DDMFormFieldValue> ddmFormFieldValues = new ArrayList<DDMFormFieldValue>();

				int i = 0;
				for (DDMFormField formField : ddmFormFields) {
					Value value = new LocalizedValue();
					DDMFormFieldValue ddmFormFieldValue = new DDMFormFieldValue();
					i++;
					if (PRE_REG_ID.equalsIgnoreCase(
							formField.getLabel().getString(Locale.US))) {
						System.out.println("PRE REG ID");
						value.addString(Locale.US, preRegNo);
						ddmFormFieldValue.setName(formField.getName());
						ddmFormFieldValue.setValue(value);
						ddmFormFieldValues.add(ddmFormFieldValue);
					} else if (REG_ID.equalsIgnoreCase(
							formField.getLabel().getString(Locale.US))) {
						System.out.println("REG ID");
						value.addString(Locale.US, regNo);
						ddmFormFieldValue.setName(formField.getName());
						ddmFormFieldValue.setValue(value);
						ddmFormFieldValues.add(ddmFormFieldValue);
					} else if (IDCS_ID.equalsIgnoreCase(
							formField.getLabel().getString(Locale.US))) {
						System.out.println("idcsNo: " + idcsNo);
						value.addString(Locale.US, idcsNo);
						ddmFormFieldValue.setName(formField.getName());
						ddmFormFieldValue.setValue(value);
						ddmFormFieldValues.add(ddmFormFieldValue);
					}
					System.out.println(i);
				}

				// Set the name of value you need to set
				Set<Locale> localeSet = new HashSet<Locale>();
				localeSet.add(Locale.US);
				ddmFormValues = new DDMFormValues(ddmForm);
				ddmFormValues.setAvailableLocales(localeSet);
				ddmFormValues.setDefaultLocale(Locale.US);
				ddmFormValues.setDDMFormFieldValues(ddmFormFieldValues);

				Map<String, DDMFormValues> ddmFormValuesMap = new HashMap<String, DDMFormValues>();
				ddmFormValuesMap.put(ddmStruct.getStructureKey(),
						ddmFormValues);

				
				MimetypesFileTypeMap fileTypeMap = new MimetypesFileTypeMap();
				String mimeType = fileTypeMap.getContentType(file.getName());
				
				is = new FileInputStream(file);
				
				DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.addFileEntry(
						userId,
						groupId, groupId,
						folderId, documentTitle, mimeType, documentTitle,
						documentDesc, changeLog,
						mosipFileEntryType.getFileEntryTypeId(),
						ddmFormValuesMap, file, is, file.length(),
						serviceContext);
				System.out.println("File Added");

				/*DLAppServiceUtil.updateFileEntry(
						dlFileEntry.getFileEntryId(),
						dlFileEntry.getFileName(), mimeType, title,
						description, changeLog, false, null,
						dlFileEntry.getSize(), serviceContext);*/

				
					DLAppServiceUtil.updateFileEntry(
							dlFileEntry.getFileEntryId(),
							dlFileEntry.getFileName(), mimeType, documentTitle,
							documentDesc, changeLog,
							DLVersionNumberIncrease.NONE, file, serviceContext);
				
				System.out.println("File Status Updated");
			}
			
		}
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
				}
			}
		}
		
		/*Validate Document Title, Should be added If not added. If already added, then Throw Exception*/
		
		return null;
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
		moiTraceRequest.setComment("No Id Found for Identifier :"
				+ identifierNumber + "and Phase " + ModuleType
				+ ". Therefore Adding into Mapper");

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

	private static void debugLog(Object msg) {
		//if(_log.isDebugEnabled()) {
			_log.debug(msg);
		//}
	}

	private static final Log _log = LogFactoryUtil.getLog(
			MosipAPIHandlerResourceImpl.class);
}