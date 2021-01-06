package com.moi.api.handler.internal.resource.v1_0;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ResourcePermissionServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import com.liferay.portal.vulcan.pagination.Page;
import com.moi.api.handler.dto.v1_0.DocumentResult;
import com.moi.api.handler.internal.result.APIConstants;
import com.moi.api.handler.internal.result.GenerateDocumentResult;
import com.moi.api.handler.resource.v1_0.MosipAPIHandlerResource;
import com.moi.dms.id.mapper.model.MOIIdMapper;
import com.moi.dms.id.mapper.service.MOIIdMapperLocalServiceUtil;
import com.moi.dms.trace.request.model.MOITraceRequest;
import com.moi.dms.trace.request.service.MOITraceRequestLocalServiceUtil;
import com.moi.mosip.validator.MosipUtil;
import com.moi.mosip.validator.MosipValidator;

import java.io.File;
import java.util.Date;
import java.util.List;

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
							DocumentType, false, null, null);
		} catch (PortalException e) {
			_log.error(e);
		}

		String validationResult = MosipValidator.validateRequest(ModuleType,
				ConsumerCode, DocumentType, IdentifierNumber, userId, file,
				moiTraceRequest, true);

		if (Validator.isNotNull(validationResult)) {
			return GenerateDocumentResult.generateDocumentResult(
					moiTraceRequest.getRequestId(), APIConstants.FAILURE,
					validationResult);
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
					GROUP_NOT_FOUND);
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

		return super.uploadMosipDocument(ModuleType, ConsumerCode, DocumentType,
				IdentifierNumber, Metadata, PreviousModuleType,
				PreviousIdentifier, multipartBody);
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
			String moduleType, ServiceContext serviceContext,MOITraceRequest moiTraceRequest) {
		
		/*Processing Folder. Folder should be available with Identifier Name*/
		long folderId = processFolder(folderName, groupId, serviceContext);
		if(folderId==0) {
			MosipValidator.updateTraceRequest(UNABLE_TO_CREATE_FOLDER.replace(FOLDER_NAME_DYNAMIC_PARAM, folderName), moiTraceRequest);
			return GenerateDocumentResult.generateDocumentResult(
					moiTraceRequest.getRequestId(), APIConstants.FAILURE,
					UNABLE_TO_CREATE_FOLDER.replace(FOLDER_NAME_DYNAMIC_PARAM, folderName)); 
		}
		
		
		/*Validate Document Title, Should be added If not added. If already added, then Throw Exception*/
		
		return null;
	}
	
	/*
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
	
	private static final Log _log = LogFactoryUtil.getLog(
			MosipAPIHandlerResourceImpl.class);
}