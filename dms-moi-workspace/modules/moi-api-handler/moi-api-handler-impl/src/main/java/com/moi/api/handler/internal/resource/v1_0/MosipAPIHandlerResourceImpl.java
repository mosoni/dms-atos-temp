package com.moi.api.handler.internal.resource.v1_0;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import com.liferay.portal.vulcan.pagination.Page;
import com.moi.api.handler.dto.v1_0.DocumentResult;
import com.moi.api.handler.internal.result.APIConstants;
import com.moi.api.handler.internal.result.GenerateDocumentResult;
import com.moi.api.handler.resource.v1_0.MosipAPIHandlerResource;
import com.moi.dms.trace.request.model.MOITraceRequest;
import com.moi.dms.trace.request.service.MOITraceRequestLocalServiceUtil;
import com.moi.mosip.validator.MosipUtil;
import com.moi.mosip.validator.MosipValidator;

import java.io.File;
import java.util.Date;

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
	
	private static final Log _log = LogFactoryUtil.getLog(
			MosipAPIHandlerResourceImpl.class);
}