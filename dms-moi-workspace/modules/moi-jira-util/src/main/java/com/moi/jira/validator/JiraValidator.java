package com.moi.jira.validator;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.multipart.BinaryFile;
import com.moi.dms.consumer.registration.service.ConsumerRegistrationLocalServiceUtil;
import com.moi.dms.mosip.constants.MosipErrorConstants;
import com.moi.dms.trace.request.model.MOITraceRequest;

/**
 * The purpose of this class is to trace and validate JIRA Request
 * 
 * @author Chintan Bhadra
 *
 */
public class JiraValidator {

	/**
	 * This method validates the requets coming from JIRA and checks following.
	 * - If request has proper authorization level on resource - If request has
	 * valid Consumer code - If request has valid Document Type - If Document is
	 * valid in terms of Size, extension
	 * 
	 * @return null if request is valid else returns message
	 */
	public static String validateRequest(String consumerCode,
			String ticketNumber, String documentTitle, String metadata,
			BinaryFile binaryFile, MOITraceRequest moiTraceRequest) {

		/* Start : Request Param validation */
		String parameterValidation = JiraUtil.validateJiraRequestParameters(
				consumerCode, ticketNumber, documentTitle, metadata);
		if (Validator.isNotNull(parameterValidation)) {
			/* Update Trace Request */
			JiraUtil.updateTraceRequest(parameterValidation, moiTraceRequest);
			return parameterValidation;
		}
		/* End : Request Param validation */

		/* Start : Consumer and Document Type */
		if (!isConsumerCodeValid(consumerCode)) {
			/* Update Trace Request */
			JiraUtil.updateTraceRequest(
					MosipErrorConstants.JIRA_INVALID_CONSUMER_CODE_MSG,
					moiTraceRequest);
			return MosipErrorConstants.JIRA_INVALID_CONSUMER_CODE_MSG;
		}
		/* End : Consumer and Document Type */

		/* Start : Validating Document */
		String documentValidation = JiraDocumentValidator
				.isDocumentValid(binaryFile);
		if (Validator.isNotNull(documentValidation)) {
			/* Update Trace Request */
			JiraUtil.updateTraceRequest(documentValidation, moiTraceRequest);
			return documentValidation;
		}
		/* End : Validating Document */

		return null;
	}

	/**
	 * This method validates Consumer Code with Document Type.
	 * 
	 * @return true if Consumer Code and Document Type is valid
	 */
	private static boolean isConsumerCodeValid(String consumerCode) {

		System.out.println("consumerCode: " + consumerCode);
		long count = ConsumerRegistrationLocalServiceUtil
				.countByConsumerName(consumerCode);
		System.out.println("count: " + count);

		return (count >= 1) ? true : false;
	}
}
