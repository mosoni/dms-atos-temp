package com.moi.mosip.validator;

import com.moi.dms.constants.MosipConstants;

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
	public static String validateRequest(String consumerCode, String documentType) {

		/*
		 * Entry Point : Trace the request
		 */

		/* Validating Authority */
		if (!MosipAuthorizationValidator.isRequestAuthorized()) {
			/* Update Trace Request */
			return MosipConstants.MOSIP_AUTHORIZATION_LEVEL_MESSAGE;
		}
		if (!ConsumerCodeValidator.isConsumerCodeValid(consumerCode)) {
			/* Update Trace Request */
			return MosipConstants.MOSIP_INVALID_CONSUMER_CODE;
		}
		if (!DocumentTypeValidator.isDocumentTypeValid(documentType)) {
			/* Update Trace Request */
			return MosipConstants.MOSIP_INVALID_DOCUMENT_TYPE;
		}

		return null;
	}

}
