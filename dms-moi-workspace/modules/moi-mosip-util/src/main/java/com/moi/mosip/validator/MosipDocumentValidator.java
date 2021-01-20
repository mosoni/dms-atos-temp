/**
 * 
 */
package com.moi.mosip.validator;

import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.multipart.BinaryFile;
import com.moi.dms.mosip.constants.MOIProperties;
import com.moi.dms.mosip.constants.MosipConstants;
import com.moi.dms.mosip.constants.MosipErrorConstants;
import com.moi.dms.trace.request.model.MOITraceRequest;

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
	public static String isDocumentValid(BinaryFile file,MOITraceRequest moiTraceRequest) {

		
		/* End : Check file */
		
		/* Start : Check file extension */
		String availableExtension = PropsUtil
				.get(MOIProperties.MOSIP_FILE_EXTENSION);

		String fileExtension = FileUtil.getExtension(file.getFileName());

		if (Validator.isNotNull(fileExtension)
				&& Validator.isNotNull(availableExtension)) {
			if (!availableExtension.contains(fileExtension)) {
				updateTraceComment(
						"Incorrect Extension :"+fileExtension ,
						moiTraceRequest);
				return MosipErrorConstants.MOSIP_INVALID_DOCUMENT_EXTENSION
						.replace(
								MosipConstants.DOCUMENT_EXTENSION_DYNAMIC_PARAMETER,
								String.valueOf(availableExtension));
			}
		}

		/* End : Check file extension */

		/* Start : Check file size */
		long length = file.getSize();
		long mosipFileSize = Long
				.valueOf(PropsUtil.get(MOIProperties.MOSIP_FILE_SIZE));

		if (length > mosipFileSize) {
			updateTraceComment(
					"Incorrect file Size :"+length,
					moiTraceRequest);
			return MosipErrorConstants.MOSIP_INVALID_DOCUMENT_SIZE.replace(
					MosipConstants.DOCUMENT_SIZE_DYNAMIC_PARAMETER,
					String.valueOf(mosipFileSize));
		}
		/* End : Check file size */
		return null;
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
