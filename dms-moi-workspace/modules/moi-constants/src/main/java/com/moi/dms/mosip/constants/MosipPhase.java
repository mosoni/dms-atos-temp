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
	 * No Previous Module
	 */
	public static final String NO_PREVIOUS_MODULE="NO_PREVIOUS_MODULE";

	/**
	 * No Previous Identifier
	 */
	public static final String NO_PREVIOUS_IDENTIFIER="NO_PREVIOUS_IDENTIFIER";
	/**
	 * No Previous Identifier
	 */
	public static final String NOT_APPLICABLE="NOT_APPLICABLE";
	
	/**
	 * This method is used to get all mosip phases
	 *
	 * @return : MOSIP_PRE_REG/MOSIP_REG/MOSIP_FREEZED/MOSIP_AGENT_PORTAL/PORTAL_FOR_RESIDENT
	 */
	public static String getPhases() {

		return PRE_REGISTRATION_PHASE + "/" + REGISTRATION_PHASE + "/"
				+ FREEZED_PHASE + "/" + PORTAL_FOR_AGENT+ "/" + PORTAL_FOR_RESIDENT;
	}
	
	/**
	 * This method is used to get previous phases list based on API documentation 1.0
	 *
	 * @return : PRE_REGISTRATION_PHASE/REGISTRATION_PHASE/NOT_APPLICABLE/NO_PREVIOUS_MODULE
	 */
	public static String getPreviousPhaseOptions() {

		return PRE_REGISTRATION_PHASE + "/" + REGISTRATION_PHASE + "/"
				+ NOT_APPLICABLE + "/" + NO_PREVIOUS_MODULE;
	}
}
