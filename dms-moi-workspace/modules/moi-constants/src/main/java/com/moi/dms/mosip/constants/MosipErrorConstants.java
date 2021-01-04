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
	public static final String MOSIP_AUTHORIZATION_LEVEL_MESSAGE="Access Denied ! "+MosipConstants.PHASE_DYNAMIC_PARAMETER+" does not have access to "+MosipConstants.ACTION_DYNAMIC_PARAMETER+
			" the "+MosipConstants.DOCUMENT_TYPE_DYNAMIC_PARAMETER;
	/**
	 * Message to be displayed when Mosip Consumer Code is invalid
	 */
	public static final String MOSIP_INVALID_CONSUMER_CODE_OR_DOCUMENT_TYPE="Consumer Code/Document Type is invalid";
	
	/**
	 * Message to be displayed when Mosip Document extension is invalid
	 */
	public static final String MOSIP_INVALID_DOCUMENT_EXTENSION="Document Extension is invalid , Please upload document with extension "+MosipConstants.DOCUMENT_EXTENSION_DYNAMIC_PARAMETER;
	
	/**
	 * Message to be displayed when Mosip Document extension is invalid
	 */
	public static final String MOSIP_INVALID_DOCUMENT_SIZE="Document Size is invalid , Please upload document with size no longer than "+MosipConstants.DOCUMENT_SIZE_DYNAMIC_PARAMETER;

}
