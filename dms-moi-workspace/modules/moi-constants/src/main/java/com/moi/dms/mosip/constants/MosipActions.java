/**
 * 
 */
package com.moi.dms.mosip.constants;

/**
 * The purpose of this class is manage all actions performed from Mosip
 *
 * Accessibility : {Please mention the places from where this class gets executed}
 *
 *
 *@author Mohit Soni
 * 
 */
public class MosipActions {

	/**
	 * Constant for POI Upload
	 */
	public static final String POI_UPLOAD="MOSIP_POI"+CommonConstants.UPLOAD;

	/**
	 * Constant for POI Update
	 */
	public static final String POI_UPDATE="MOSIP_POI"+CommonConstants.UPDATE;

	/**
	 * Constant for POA Upload
	 */
	public static final String POA_UPLOAD="MOSIP_POA"+CommonConstants.UPLOAD;

	/**
	 * Constant for POA Update
	 */
	public static final String POA_UPDATE="MOSIP_POA"+CommonConstants.UPDATE;
	
	/**
	 * Constant for POR Upload
	 */
	public static final String POR_UPLOAD="MOSIP_POR"+CommonConstants.UPLOAD;

	/**
	 * Constant for POR Update
	 */
	public static final String POR_UPDATE="MOSIP_POR"+CommonConstants.UPDATE;
	
	/**
	 * Constant for POB Upload
	 */
	public static final String POB_UPLOAD="MOSIP_POB"+CommonConstants.UPLOAD;

	/**
	 * Constant for POB Update
	 */
	public static final String POB_UPDATE="MOSIP_POB"+CommonConstants.UPDATE;
	
	/**
	 * Constant for POE Upload
	 */
	public static final String POE_UPLOAD="MOSIP_POE"+CommonConstants.UPLOAD;

	/**
	 * Constant for POE Update
	 */
	public static final String POE_UPDATE="MOSIP_POE"+CommonConstants.UPDATE;
	
	/**
	 * Constant for TPOA Upload
	 */
	public static final String TPOA_UPLOAD="MOSIP_TPOA"+CommonConstants.UPLOAD;

	/**
	 * Constant for TPOA Update
	 */
	public static final String TPOA_UPDATE="MOSIP_TPOA"+CommonConstants.UPDATE;
	
	/**
	 * Constant for TPOA Upload
	 */
	public static final String SFR_UPLOAD="MOSIP_TPOA"+CommonConstants.UPLOAD;

	/**
	 * Constant for TPOA Update
	 */
	public static final String SFR_UPDATE="MOSIP_TPOA"+CommonConstants.UPDATE;
	
	
	/**
	 * This method is used to get actions associated to Document Type
	 *
	 * @param documentType
	 * @param isNewUpload
	 * @return :
	 */
	public String getAction(String documentType, boolean isNewUpload) {

		if (isNewUpload) {
			return documentType + CommonConstants.UPLOAD;
		}
		return documentType + CommonConstants.UPDATE;

	}
}
