/**
 * 
 */
package com.moi.dms.mosip.constants;

/**
 * The purpose of this class is to manage Error constants for Mosip
 * 
 * @author Mohit Soni
 *
 */
public class MosipErrorConstants {

	/**
	 * Message to be displayed when Mosip Authorization is failed
	 */
	public static final String MOSIP_AUTHORIZATION_LEVEL_MESSAGE = "Access Denied ! "
			+ MosipConstants.PHASE_DYNAMIC_PARAMETER
			+ " does not have access to "
			+ MosipConstants.ACTION_DYNAMIC_PARAMETER + " the "
			+ MosipConstants.DOCUMENT_TYPE_DYNAMIC_PARAMETER;

	/**
	 * Message to be displayed when Mosip Consumer Code is invalid
	 */
	public static final String MOSIP_INVALID_CONSUMER_CODE_OR_DOCUMENT_TYPE = "Consumer Code/Document Type is invalid";

	/**
	 * Message to be displayed when Mosip Document extension is invalid
	 */
	public static final String MOSIP_INVALID_DOCUMENT_EXTENSION = "Document Extension is invalid , Please upload document with extension "
			+ MosipConstants.DOCUMENT_EXTENSION_DYNAMIC_PARAMETER;

	/**
	 * Message to be displayed when Mosip Document is null
	 */
	public static final String MOSIP_BLANK_DOCUMENT = "Document can not be blank/empty ";

	/**
	 * Message to be displayed when Mosip Document extension is invalid
	 */
	public static final String MOSIP_INVALID_DOCUMENT_SIZE = "Document Size is invalid , Please upload document with size no longer than "
			+ MosipConstants.DOCUMENT_SIZE_DYNAMIC_PARAMETER;

	/**
	 * Message to be displayed when Mosip Document extension is invalid
	 */
	public static final String MOSIP_INVALID_MODULE_TYPE = "Module Type is invalid , please provide any of the following "
			+ MosipPhase.getPhases();

	/**
	 * Message to be displayed when Mosip Previous Module Type/Identifier is invalid
	 */
	public static final String MOSIP_INVALID_PREVIOUS_MODULE_TYPE_OR_IDENTIFIER = "Previous Module Type/Identifier is invalid, Please provide correct details.";
	
	/**
	 * Message to be displayed when Mosip Document extension is invalid
	 */
	public static final String JIRA_INVALID_DOCUMENT_EXTENSION = "Document Extension is invalid. Please upload document with valid extension";

	/**
	 * Message to be displayed when JIRA consumer code is invalid
	 */
	public static final String JIRA_FILE_UPLOADED_MSG = "Document uploaded successfully";

	/**
	 * Message to be displayed when JIRA consumer code is invalid
	 */
	public static final String JIRA_INVALID_CONSUMER_CODE_MSG = "Consumer Code is invalid";

	/**
	 * Message to be displayed when JIRA ticket number is invalid
	 */
	public static final String JIRA_INVALID_TICKET_NUMBER_MSG = "JIRA Ticket number is invalid";

	/**
	 * Message to be displayed when JIRA uploaded document is invalid
	 */
	public static final String JIRA_INVALID_DOCUMENT_MSG = "Uploaded document is invalid";

	/**
	 * Message to be displayed when JIRA document title is invalid
	 */
	public static final String JIRA_INVALID_DOCUMENT_TITLE_MSG = "Document title is invalid";

	/**
	 * Message to be displayed when type document title is invalid
	 */
	public static final String JIRA_INVALID_DOCUMENT_TYPE_MSG = "Document type is invalid";

	/**
	 * Message to be displayed when JIRA document size is too large
	 */
	public static final String JIRA_INVALID_DOCUMENT_SIZE_MSG = "Document Size is invalid. Please upload document with size no longer than "
			+ MosipConstants.DOCUMENT_SIZE_DYNAMIC_PARAMETER;

	/**
	 * Message to be displayed when JIRA document already exists
	 */
	public static final String JIRA_FILE_EXISTS_MSG = "Document already exists";

	/**
	 * Message to be displayed when JIRA document title is invalid
	 */
	public static final String JIRA_COMMON_ERROR = "Internal Error occured: ";
}
