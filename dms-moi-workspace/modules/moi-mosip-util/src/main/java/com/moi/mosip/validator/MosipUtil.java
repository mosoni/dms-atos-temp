/**
 * 
 */
package com.moi.mosip.validator;

import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.Validator;
import com.moi.dms.mosip.constants.CommonConstants;
import com.moi.dms.trace.request.model.MOITraceRequest;
import com.moi.dms.trace.request.service.MOITraceRequestLocalServiceUtil;

import java.util.Date;

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
	
	
	/**
	 * This method is used to generate document title 
	 *
	 * @param documentType
	 * @param identifier
	 * @return : document title
	 */
	public static String generateDocumentTitle(String documentType, String identifier,String fileName) {
		String extension = FileUtil.getExtension(fileName);
		return documentType+"_"+identifier+"."+extension;
	}
	
	/**
	 * This method is used to generate document Description
	 *
	 * @param documentType
	 * @param identifier
	 * @param currentDocumentDescription
	 * @return : document Description 
	 */
	public static String generateDocumentDescription(
			String currentDocumentDescription, String documentType,
			String identifier) {

		if (Validator.isNotNull(currentDocumentDescription)) {
			return currentDocumentDescription + "/n" + identifier;
		}

		return identifier;
	}
	
	
	/**
	 * This method is used to generate document metadata
	 *
	 * @param documentType
	 * @param identifier
	 * @param currentDocumentDescription
	 * @return : document Description 
	 */
	public static String generateDocumentMetadata(
			String currentDocumentMetadata, String documentType,
			String metadata) {
		
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
