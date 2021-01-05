/**
 * 
 */
package com.moi.mosip.validator;

import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.moi.dms.mosip.constants.MOIProperties;
import com.moi.dms.mosip.constants.MosipConstants;
import com.moi.dms.mosip.constants.MosipErrorConstants;

import java.io.File;

/**
 * The purpose of this class is to validate Document i.e. extension,size
 * 
 * @author Mohit Soni
 *
 */
public class MosipDocumentValidator {

	/**
	 * This method validates Document like extension,size.
	 * 
	 * @return true if Document is valid
	 */
	public static String isDocumentValid(File file) {

		/* Start : Check file */
		if(Validator.isNull(file)) {
			return MosipErrorConstants.MOSIP_BLANK_DOCUMENT;
		}
		/* End : Check file */
		
		/* Start : Check file extension */
		String availableExtension = PropsUtil
				.get(MOIProperties.MOSIP_FILE_EXTENSION);

		String fileExtension = FileUtil.getExtension(file.getName());

		if (Validator.isNotNull(fileExtension)
				&& Validator.isNotNull(availableExtension)) {
			if (!availableExtension.contains(fileExtension)) {
				return MosipErrorConstants.MOSIP_INVALID_DOCUMENT_EXTENSION
						.replace(
								MosipConstants.DOCUMENT_EXTENSION_DYNAMIC_PARAMETER,
								String.valueOf(availableExtension));
			}
		}

		/* End : Check file extension */

		/* Start : Check file size */
		long length = file.length();
		long mosipFileSize = Long
				.valueOf(PropsUtil.get(MOIProperties.MOSIP_FILE_SIZE));

		if (length > mosipFileSize) {
			return MosipErrorConstants.MOSIP_INVALID_DOCUMENT_SIZE.replace(
					MosipConstants.DOCUMENT_SIZE_DYNAMIC_PARAMETER,
					String.valueOf(mosipFileSize));
		}
		/* End : Check file size */
		return null;
	}
	
	public static void main(String[] args) {
		String a = "Document Extension is invalid , Please upload document with extension {extension} ";
		//a = a.replace("{extension}", "12345");
		System.out.println(a.replace("{extension}", "12345"));
	}
}
