package com.moi.api.handler.internal.resource.v1_0;

import com.liferay.portal.vulcan.multipart.MultipartBody;
import com.liferay.portal.vulcan.pagination.Page;
import com.moi.api.handler.dto.v1_0.DocumentResult;
import com.moi.api.handler.resource.v1_0.MosipAPIHandlerResource;
import com.moi.mosip.validator.MosipValidator;

import java.io.File;

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
	
	@Override
	public Page<DocumentResult> uploadMosipDocument(String ModuleType,
			String ConsumerCode, String DocumentType, String IdentifierNumber,
			String Metadata, String PreviousModuleType,
			String PreviousIdentifier, MultipartBody multipartBody)
			throws Exception {
		
		File file = null;
		
		/*
		 * MosipValidator.validateRequest(ModuleType, ConsumerCode,
		 * DocumentType, IdentifierNumber, Metadata, PreviousModuleType,
		 * PreviousIdentifier, file);
		 */
		
		
		return super.uploadMosipDocument(ModuleType, ConsumerCode, DocumentType,
				IdentifierNumber, Metadata, PreviousModuleType, PreviousIdentifier,
				multipartBody);
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
}