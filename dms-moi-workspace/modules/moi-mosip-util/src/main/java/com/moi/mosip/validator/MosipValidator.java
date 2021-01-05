package com.moi.mosip.validator;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.moi.dms.consumer.registration.service.ConsumerRegistrationLocalServiceUtil;
import com.moi.dms.mosip.constants.MosipActions;
import com.moi.dms.mosip.constants.MosipErrorConstants;
import com.moi.dms.mosip.constants.MosipPhase;
import com.moi.dms.trace.request.model.MOITraceRequest;
import com.moi.dms.trace.request.service.MOITraceRequestLocalServiceUtil;

import java.io.File;
import java.util.Date;

/**
 * The purpose of this class is to trace and validate Mosip Request
 * 
 * @author Mohit Soni
 *
 */
public class MosipValidator {

	/**
	 * This method validates the requets coming from Mosip and checks following. -
	 * If request has proper authorization level on resource - If request has valid
	 * Consumer code - If request has valid Document Type - If Document is valid in
	 * terms of Size, extension
	 * 
	 * @return null if request is valid else returns message
	 */
	public static String validateRequest(String moduleType, String consumerCode,
			String documentType, String identifierNumber, long userId,
			File file, MOITraceRequest moiTraceRequest, boolean isNewUpload) {

		String requestedOperation = MosipUtil.getAction(documentType,
				isNewUpload);

		/* Start : Module */
		if (Validator.isNull(moduleType)
				|| !MosipPhase.getPhases().contains(moduleType)) {
			updateTraceRequest(MosipErrorConstants.MOSIP_INVALID_MODULE_TYPE,
					moiTraceRequest);
			return MosipErrorConstants.MOSIP_INVALID_MODULE_TYPE;
		}
		/* End : Module */

		/* Start : Consumer and Document Type */
		if (!isConsumerCodeValid(consumerCode, documentType)) {
			/* Update Trace Request */
			updateTraceRequest(
					MosipErrorConstants.MOSIP_INVALID_CONSUMER_CODE_OR_DOCUMENT_TYPE,
					moiTraceRequest);
			return MosipErrorConstants.MOSIP_INVALID_CONSUMER_CODE_OR_DOCUMENT_TYPE;
		}
		/* End : Consumer and Document Type */

		/* Start : Validating Document */
		String documentValidation = MosipDocumentValidator
				.isDocumentValid(file);
		if (Validator.isNotNull(documentValidation)) {
			/* Update Trace Request */
			updateTraceRequest(documentValidation, moiTraceRequest);
			return documentValidation;
		}
		/* End : Validating Document */

		/* Start : Validating Authority */
		if (!MosipAuthorizationValidator.isRequestAuthorized(moduleType,
				requestedOperation)) {
			/* Update Trace Request */
			updateTraceRequest(
					MosipErrorConstants.MOSIP_AUTHORIZATION_LEVEL_MESSAGE,
					moiTraceRequest);
			return MosipErrorConstants.MOSIP_AUTHORIZATION_LEVEL_MESSAGE;
		}
		/* End : Validating Authority */

		return null;
	}

	/**
	 * This method is used to Update trace request with result and date
	 *
	 * @param result
	 * @param moiTraceRequest :
	 */
	private static void updateTraceRequest(String result,
			MOITraceRequest moiTraceRequest) {

		if (Validator.isNotNull(moiTraceRequest)) {
			moiTraceRequest.setRequestResult(result);
			moiTraceRequest.setRequestResultDate(new Date());
			MOITraceRequestLocalServiceUtil
					.updateMOITraceRequest(moiTraceRequest);
		}
	}

	
	/**
	 * This method validates Consumer Code with Document Type.
	 * 
	 * @return true if Consumer Code and Document Type is valid
	 */
	private static boolean isConsumerCodeValid(String consumerCode,
			String documentType) {

		long count = ConsumerRegistrationLocalServiceUtil
				.countByConsumerIdDocumentType(consumerCode, documentType);

		return (count >= 1) ? true : false;
	}
	private static final Log _log = LogFactoryUtil.getLog(
			MosipValidator.class);
}
