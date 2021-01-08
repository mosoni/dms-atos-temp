/**
 * 
 */
package com.moi.jira.validator;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.multipart.BinaryFile;
import com.moi.dms.mosip.constants.MOIProperties;
import com.moi.dms.mosip.constants.MosipConstants;
import com.moi.dms.mosip.constants.MosipErrorConstants;

/**
 * The purpose of this class is to validate Document i.e. extension,size
 * 
 * @author Chintan Bhadra
 *
 */
public class JiraDocumentValidator {

	/**
	 * This method validates Document like extension,size.
	 * 
	 * @return true if Document is valid
	 */
	public static String isDocumentValid(BinaryFile binaryFile) {

		/* Start : Check file */
		if (Validator.isNull(binaryFile)) {
			return MosipErrorConstants.JIRA_INVALID_DOCUMENT_MSG;
		}
		/* End : Check file */

		/* Start : Check file size */
		long length = binaryFile.getSize();
		long maxFileSize = Long
				.valueOf(PropsUtil.get(MOIProperties.JIRA_MAX_FILE_SIZE));

		if(length <= 0) {
			return MosipErrorConstants.JIRA_INVALID_DOCUMENT_MSG;
		} else if (length > maxFileSize) {
			return MosipErrorConstants.JIRA_INVALID_DOCUMENT_SIZE_MSG.replace(
					MosipConstants.DOCUMENT_SIZE_DYNAMIC_PARAMETER,
					String.valueOf(maxFileSize));
		}
		/* End : Check file size */

		/* Start : Check file extension */
		String fileName = binaryFile.getFileName();
		if (null == fileName || StringPool.BLANK.equals(fileName)) {
			return MosipErrorConstants.JIRA_INVALID_DOCUMENT_MSG;
		}

		String availableExtension = PropsUtil
				.get(MOIProperties.JIRA_FILE_EXTENSION);
		String fileExtension = FileUtil.getExtension(fileName);
		if (Validator.isNotNull(fileExtension)
				&& Validator.isNotNull(availableExtension)) {
			if (!availableExtension.contains(fileExtension)) {
				return MosipErrorConstants.JIRA_INVALID_DOCUMENT_EXTENSION;
			}
		}
		/* End : Check file extension */
		return null;
	}
}
