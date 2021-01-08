/**
 * 
 */
package com.moi.jira.validator;

import com.liferay.portal.kernel.util.Validator;
import com.moi.dms.mosip.constants.CommonConstants;
import com.moi.dms.mosip.constants.MosipErrorConstants;
import com.moi.dms.trace.request.model.MOITraceRequest;
import com.moi.dms.trace.request.service.MOITraceRequestLocalServiceUtil;

import java.util.Date;

/**
 * The purpose of this class is to maintain utilities used for JIRA
 *
 * Accessibility : Functionalities related to JIRA
 *
 * @author Chintan Bhadra
 * 
 */
public class JiraUtil {

	/**
	 * This method is used to get the action performed on document type
	 *
	 * @param documentType
	 * @param isNewUpload
	 * @return : action
	 */
	public static String getAction(String documentType, boolean isNewUpload) {
		if (isNewUpload) {
			return documentType + CommonConstants.UPLOAD;
		}
		return documentType + CommonConstants.UPDATE;
	}

	public static String validateJiraRequestParameters(String consumerCode,
			String ticketNumber, String documentTitle, String metadata) {
		// Step 2: Check input parameters
		if (null == consumerCode || consumerCode.isEmpty()) {
			return MosipErrorConstants.JIRA_INVALID_CONSUMER_CODE_MSG;
		}

		if (null == ticketNumber || ticketNumber.isEmpty()) {
			return MosipErrorConstants.JIRA_INVALID_TICKET_NUMBER_MSG;
		}

		if (null == documentTitle || documentTitle.isEmpty()) {
			return MosipErrorConstants.JIRA_INVALID_DOCUMENT_TITLE_MSG;
		}
		return null;
	}

	/**
	 * This method is used to Update trace request with result and date
	 *
	 * @param result
	 * @param moiTraceRequest :
	 */
	public static void updateTraceRequest(String result,
			MOITraceRequest moiTraceRequest) {

		if (Validator.isNotNull(moiTraceRequest)) {
			moiTraceRequest.setRequestResult(result);
			moiTraceRequest.setRequestResultDate(new Date());
			MOITraceRequestLocalServiceUtil
					.updateMOITraceRequest(moiTraceRequest);
		}
	}
}
