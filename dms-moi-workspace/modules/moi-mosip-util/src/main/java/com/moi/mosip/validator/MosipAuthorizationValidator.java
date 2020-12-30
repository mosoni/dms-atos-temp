/**
 * 
 */
package com.moi.mosip.validator;

import com.moi.dms.mosip.constants.MosipActions;
import com.moi.dms.mosip.constants.MosipPhase;

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
	public static boolean isRequestAuthorized(String phase, String action) {

		switch (phase) {
			case MosipPhase.PRE_REGISTRATION_PHASE :
				if (action.equalsIgnoreCase(MosipActions.TPOA_UPLOAD)
						|| action.equalsIgnoreCase(MosipActions.SFR_UPLOAD)
						|| action.equalsIgnoreCase(MosipActions.TPOA_UPDATE)
						|| action.equalsIgnoreCase(MosipActions.SFR_UPDATE)) {
					return false;
				} else {
					return true;
				}
			case MosipPhase.REGISTRATION_PHASE :
				if (action.equalsIgnoreCase(MosipActions.TPOA_UPLOAD)
						|| action.equalsIgnoreCase(MosipActions.SFR_UPLOAD)
						|| action.equalsIgnoreCase(MosipActions.TPOA_UPDATE)
						|| action.equalsIgnoreCase(MosipActions.SFR_UPDATE)) {
					return false;
				} else {
					return true;
				}
			case MosipPhase.FREEZED_PHASE :
				if (action.equalsIgnoreCase(MosipActions.POI_UPLOAD)
						|| action.equalsIgnoreCase(MosipActions.POA_UPLOAD)
						|| action.equalsIgnoreCase(MosipActions.TPOA_UPLOAD)
						|| action.equalsIgnoreCase(MosipActions.SFR_UPLOAD)
						|| action.equalsIgnoreCase(MosipActions.TPOA_UPDATE)
						|| action.equalsIgnoreCase(MosipActions.SFR_UPDATE)) {
					return false;
				} else {
					return true;
				}
			case MosipPhase.PORTAL_FOR_AGENT :
				if (action.equalsIgnoreCase(MosipActions.POI_UPDATE)) {
					return true;
				} else {
					return false;
				}
			case MosipPhase.PORTAL_FOR_RESIDENT :
				if (action.equalsIgnoreCase(MosipActions.TPOA_UPLOAD)
						|| action.equalsIgnoreCase(MosipActions.SFR_UPLOAD)
						|| action.equalsIgnoreCase(MosipActions.TPOA_UPDATE)
						|| action.equalsIgnoreCase(MosipActions.SFR_UPDATE)) {
					return true;
				} else {
					return false;
				}
			default :
				return false;
		}
	}
}
