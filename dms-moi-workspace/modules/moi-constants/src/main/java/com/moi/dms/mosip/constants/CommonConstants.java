/**
 * 
 */
package com.moi.dms.mosip.constants;

import com.liferay.document.library.kernel.model.DLFolderConstants;

/**
 * The purpose of this class is to manage all constants used in common among
 * all consumers like Mosip,JIRA etc
 * 
 * @author Mohit Soni
 *
 */
public class CommonConstants {

	/**
	 * Message to be displayed when upload file is null
	 */
	public static final String FILE_NOT_AVAILABLE = "File is empty";

	/**
	 * Constant for update
	 */
	public static final String UPDATE = "_UPDATE";

	/**
	 * Constant for upload
	 */
	public static final String UPLOAD = "_UPLOAD";

	/**
	 * Constant for JIRA Parent Folder Id
	 */
	public static long JIRA_PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

	/**
	 * Constant for JIRA document metadata type
	 */
	public static String JIRA_METADATA_SETS_NAME = "Basic Document";

	/**
	 * Constant for consumerCode request parameter in JIRA API
	 */
	public static String JIRA_REQ_PARAM_CONSUMER_CODE = "consumerCode";

	/**
	 * Constant for documentType request parameter in JIRA API
	 */
	public static String JIRA_REQ_PARAM_DOCUMENT_TYPE = "documentType";

	/**
	 * Constant for ticketNumber request parameter in JIRA API
	 */
	public static String JIRA_REQ_PARAM_TICKET_NUMBER = "ticketNumber";

	/**
	 * Constant for documentTitle request parameter in JIRA API
	 */
	public static String JIRA_REQ_PARAM_DOCUMENT_TITLE = "documentTitle";

	/**
	 * Constant for metadata request parameter in JIRA API
	 */
	public static String JIRA_REQ_PARAM_METADATA = "metadata";

	/**
	 * Constant for document request parameter in JIRA API
	 */
	public static String JIRA_REQ_PARAM_DOCUMENT = "document";
}
