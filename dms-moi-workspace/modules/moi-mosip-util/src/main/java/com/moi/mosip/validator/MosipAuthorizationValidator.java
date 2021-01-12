/**
 * 
 */
package com.moi.mosip.validator;

import com.liferay.portal.kernel.util.Validator;
import com.moi.dms.mosip.constants.MosipActions;
import com.moi.dms.mosip.constants.MosipPhase;
import com.moi.dms.trace.request.model.MOITraceRequest;

/**
 * The purpose of this class is to validate Authorization level of Mosip
 * 
 * @author Mohit Soni
 *
 */
public class MosipAuthorizationValidator {

	/**
	 * This method implements action Matrix defined in API documentation
	 * 
	 * @return true if authorized
	 */
	public static boolean isRequestAuthorized(String phase, String action,
			MOITraceRequest moiTraceRequest) {

		boolean result = false;
		switch (phase) {
			case MosipPhase.PRE_REGISTRATION_PHASE :
				if (action.equalsIgnoreCase(MosipActions.TPOA_UPLOAD)
						|| action.equalsIgnoreCase(MosipActions.SFR_UPLOAD)
						|| action.equalsIgnoreCase(MosipActions.TPOA_UPDATE)
						|| action.equalsIgnoreCase(MosipActions.SFR_UPDATE)) {

				} else {
					result = true;
				}
				break;
			case MosipPhase.REGISTRATION_PHASE :
				if (action.equalsIgnoreCase(MosipActions.TPOA_UPLOAD)
						|| action.equalsIgnoreCase(MosipActions.SFR_UPLOAD)
						|| action.equalsIgnoreCase(MosipActions.TPOA_UPDATE)
						|| action.equalsIgnoreCase(MosipActions.SFR_UPDATE)) {

				} else {
					result = true;
				}
				break;
			case MosipPhase.FREEZED_PHASE :
				if (action.equalsIgnoreCase(MosipActions.POI_UPLOAD)
						|| action.equalsIgnoreCase(MosipActions.POA_UPLOAD)
						|| action.equalsIgnoreCase(MosipActions.TPOA_UPLOAD)
						|| action.equalsIgnoreCase(MosipActions.SFR_UPLOAD)
						|| action.equalsIgnoreCase(MosipActions.TPOA_UPDATE)
						|| action.equalsIgnoreCase(MosipActions.SFR_UPDATE)) {
				} else {
					result = true;
				}
				break;
			case MosipPhase.PORTAL_FOR_AGENT :
				if (action.equalsIgnoreCase(MosipActions.POI_UPDATE)) {
					result = true;
				}
				break;
			case MosipPhase.PORTAL_FOR_RESIDENT :
				if (action.equalsIgnoreCase(MosipActions.TPOA_UPLOAD)
						|| action.equalsIgnoreCase(MosipActions.SFR_UPLOAD)
						|| action.equalsIgnoreCase(MosipActions.TPOA_UPDATE)
						|| action.equalsIgnoreCase(MosipActions.SFR_UPDATE)) {
					result = true;
				}
				break;
			default :
				break;
		}

		updateTraceComment(phase + " is and looking for action :" + action
				+ ": Authorization : " + result, moiTraceRequest);
		return result;
	}
	
	/*
	 * This method is used to concatinate comment section of MOITraceRequest
	 *
	 * @param comment
	 * @param traceRequest : 
	 */
	private static void updateTraceComment(String comment,
			MOITraceRequest traceRequest) {
		if (Validator.isNotNull(traceRequest)) {
			if (Validator.isNotNull(traceRequest.getComment())) {
				traceRequest.setComment(
						traceRequest.getComment() + " | " + comment + ".");
			} else {
				traceRequest.setComment(comment + ".");
			}
		}
	}
}
