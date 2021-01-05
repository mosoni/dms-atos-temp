/**
 * 
 */
package com.moi.mosip.validator;

import com.moi.dms.mosip.constants.CommonConstants;

/**
 * The purpose of this class is to maintain utilities used for Mosip
 *
 * Accessibility : Functionalities related to Mosip
 *
 *
 *@author Mohit Soni
 * 
 */
public class MosipUtil {

	
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
}
