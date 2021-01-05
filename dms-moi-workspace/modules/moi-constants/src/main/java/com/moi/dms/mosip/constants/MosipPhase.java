/**
 * 
 */
package com.moi.dms.mosip.constants;

/**
 * The purpose of this class is {Please explain the usability of this class}
 *
 * Accessibility : {Please mention the places from where this class gets executed}
 *
 *
 *@author Mohit
 * 
 */
public class MosipPhase {

	/**
	 * Pre Registration Phase Constant
	 */
	public static final String PRE_REGISTRATION_PHASE="MOSIP_PRE_REG";

	/**
	 * Registration Phase Constant
	 */
	public static final String REGISTRATION_PHASE="MOSIP_REG";

	/**
	 * Freezed Phase Constant
	 */
	public static final String FREEZED_PHASE="MOSIP_FREEZED";

	/**
	 * Portal For Agent Phase Constant
	 */
	public static final String PORTAL_FOR_AGENT="MOSIP_AGENT_PORTAL";

	/**
	 * Portal For Resident Phase Constant
	 */
	public static final String PORTAL_FOR_RESIDENT="MOSIP_RESIDENT_PORTAL";

	
	
	/**
	 * This method is used to get all mosip phases
	 *
	 * @return : MOSIP_PRE_REG/MOSIP_REG/MOSIP_FREEZED/MOSIP_AGENT_PORTAL/PORTAL_FOR_RESIDENT
	 */
	public static String getPhases() {

		return PRE_REGISTRATION_PHASE + "/" + REGISTRATION_PHASE + "/"
				+ FREEZED_PHASE + "/" + PORTAL_FOR_AGENT+ "/" + PORTAL_FOR_RESIDENT;
	}
}
