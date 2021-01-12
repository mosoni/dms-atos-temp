package com.moi.mosip.validator;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.moi.dms.consumer.registration.service.ConsumerRegistrationLocalServiceUtil;
import com.moi.dms.mosip.constants.MosipErrorConstants;
import com.moi.dms.mosip.constants.MosipPhase;
import com.moi.dms.trace.request.model.MOITraceRequest;
import com.moi.dms.trace.request.service.MOITraceRequestLocalServiceUtil;

import java.io.File;
import java.util.Date;

/**
 * The purpose of this class is to trace and validate Mosip Request
 * 
 * @author Mohit Soni
 *
 */
public class MosipValidator {

	/**
	 * This method validates the requets coming from Mosip and checks following. -
	 * If request has proper authorization level on resource - If request has valid
	 * Consumer code - If request has valid Document Type - If Document is valid in
	 * terms of Size, extension
	 * 
	 * @return null if request is valid else returns message
	 */
	public static String validateRequest(String moduleType, String consumerCode,
			String documentType, String identifierNumber, long userId,
			File file, MOITraceRequest moiTraceRequest,String previousModuleType,String previousidentifier,
			boolean isNewUpload) {

		String requestedOperation = MosipUtil.getAction(documentType,
				isNewUpload);

		/* Start : moduleType */
		if (Validator.isNull(moduleType)
				|| !MosipPhase.getPhases().contains(moduleType)) {
			updateTraceRequest(MosipErrorConstants.MOSIP_INVALID_MODULE_TYPE,
					moiTraceRequest);
			return MosipErrorConstants.MOSIP_INVALID_MODULE_TYPE;
		}
		/* End : moduleType */

		String identifierResult = validateIdentifier(previousModuleType,
				previousidentifier, moiTraceRequest, previousModuleType,
				identifierNumber);
		
		if(Validator.isNotNull(identifierResult)) {
			updateTraceRequest(
					identifierResult,
					moiTraceRequest);
			return identifierResult;
		}

		/* End : Previous Module/Identifier */

		/* Start : Consumer and Document Type */
		if (!isConsumerCodeValid(consumerCode, documentType)) {
			/* Update Trace Request */
			updateTraceRequest(
					MosipErrorConstants.MOSIP_INVALID_CONSUMER_CODE_OR_DOCUMENT_TYPE,
					moiTraceRequest);
			return MosipErrorConstants.MOSIP_INVALID_CONSUMER_CODE_OR_DOCUMENT_TYPE;
		}
		/* End : Consumer and Document Type */

		/* Start : Validating Document */
		String documentValidation = MosipDocumentValidator
				.isDocumentValid(file);
		if (Validator.isNotNull(documentValidation)) {
			/* Update Trace Request */
			updateTraceRequest(documentValidation, moiTraceRequest);
			return documentValidation;
		}
		/* End : Validating Document */

		/* Start : Validating Authority */
		if (!MosipAuthorizationValidator.isRequestAuthorized(moduleType,
				requestedOperation)) {
			/* Update Trace Request */
			updateTraceRequest(
					MosipErrorConstants.MOSIP_AUTHORIZATION_LEVEL_MESSAGE,
					moiTraceRequest);
			return MosipErrorConstants.MOSIP_AUTHORIZATION_LEVEL_MESSAGE;
		}
		/* End : Validating Authority */

		return null;
	}
	
	
	/**
	 * This method is used to validate identifier based on API Documentation 1.0
	 *
	 * @param previousModuleType
	 * @param previousIdentifier
	 * @param moiTraceRequest
	 * @param moduleType
	 * @param identifier
	 * @return :
	 */
	private static String validateIdentifier(String previousModuleType,
			String previousIdentifier, MOITraceRequest moiTraceRequest,
			String moduleType,String identifier) {

		
		updateTraceComment(
				"previousModuleType is :" + previousModuleType,
				moiTraceRequest);
		updateTraceComment(
				"previousIdentifier is :" + previousIdentifier,
				moiTraceRequest);
		updateTraceComment(
				"moduleType is :" + moduleType,
				moiTraceRequest);		
		updateTraceComment(
				"identifier is :" + identifier,
				moiTraceRequest);
		
		/*Previous Module and Identifier should never be Blank*/
		if (Validator.isNull(previousModuleType)
				|| Validator.isNull(previousIdentifier)) {
			updateTraceComment(
					"Treating Request as Invalid ",
					moiTraceRequest);
			updateTraceRequest(
					MosipErrorConstants.MOSIP_INVALID_PREVIOUS_MODULE_TYPE_OR_IDENTIFIER,
					moiTraceRequest);
			return MosipErrorConstants.MOSIP_INVALID_PREVIOUS_MODULE_TYPE_OR_IDENTIFIER;
		}else if(!MosipPhase.getPreviousPhaseOptions().contains(previousModuleType)) {
			updateTraceComment(
					"Treating Request as Invalid ",
					moiTraceRequest);
			updateTraceRequest(
					MosipErrorConstants.MOSIP_INVALID_PREVIOUS_MODULE_TYPE_OR_IDENTIFIER,
					moiTraceRequest);
		}
		
		switch (moduleType) {
			case MosipPhase.PRE_REGISTRATION_PHASE :
				/*
				 * Its First Entry point for any Document and No Previous Module
				 * and Identifier is applicable
				 */

				if (!previousModuleType.equals(MosipPhase.NO_PREVIOUS_MODULE)
						|| !previousIdentifier
								.equals(MosipPhase.NO_PREVIOUS_IDENTIFIER)) {
					updateTraceRequest(
							MosipErrorConstants.MOSIP_INVALID_PREVIOUS_MODULE_TYPE_OR_IDENTIFIER,
							moiTraceRequest);
					return MosipErrorConstants.MOSIP_INVALID_PREVIOUS_MODULE_TYPE_OR_IDENTIFIER;
				}
				updateTraceComment(
						"VALID Request : DMS assumes Identifier is Pre registration ID, Phase is Pre Registration Phase ",
						moiTraceRequest);
				
				return null;
			case MosipPhase.REGISTRATION_PHASE :
				/*
				 * Registration has 2 use cases , 
				 * 1st : When end user directly comes to Registration phase i.e. No Pre Registration.
				 * 2nd : When end user directly comes to Pre Registration then move to Registration phase.
				 */

				
				
				if (previousModuleType.equals(MosipPhase.NO_PREVIOUS_MODULE)) {
					/*Start Use case 1 : When end user directly comes to Registration phase i.e. No Pre Registration*/
					
					
					updateTraceComment(
							"Assuming No Pre registration Exist for Registration ID "
									+ identifier,
							moiTraceRequest);
					
					if (!previousIdentifier
							.equals(MosipPhase.NO_PREVIOUS_IDENTIFIER)) {
						updateTraceRequest(
								"No Previous Module Should have No Previous Identifier, Please make sure parameters are correct",
								moiTraceRequest);
						return "No Previous Module Should have No Previous Identifier, Please make sure parameters are correct";
					}

					updateTraceComment(
							"VALID Request : DMS assumes Identifier Registration ID, Phase is Registration Phase and Citizen Directly came to Registration i.e.  No Pre Registration",
							moiTraceRequest);
					
					/*End Use case 1*/
				}else {
					/*Start Use case 2 : When end user directly comes to Pre Registration then move to Registration phase*/
					updateTraceComment(
							"Assuming Pre registration Exist for Registration ID "
									+ identifier +" and Pre Registration ID "+previousIdentifier,
							moiTraceRequest);
					
					if(!previousModuleType.equals(MosipPhase.PRE_REGISTRATION_PHASE)) {
						updateTraceComment(
								"Treating Request as Invalid ",
								moiTraceRequest);
						updateTraceRequest(
								"Invalid Previous Module :"+previousModuleType,
								moiTraceRequest);
						return "Invalid Previous Module :"+previousModuleType;
					}
					
					if(!previousIdentifier.equals(MosipPhase.NO_PREVIOUS_IDENTIFIER) || !previousIdentifier.equals(MosipPhase.NOT_APPLICABLE)) {
						updateTraceComment(
								"Treating Request as Invalid ",
								moiTraceRequest);
						updateTraceRequest(
								"Invalid Previous Identifier :"+previousIdentifier,
								moiTraceRequest);
						return "Invalid Previous Identifier :"+previousIdentifier;
					}
					
					updateTraceComment(
							"VALID Request : DMS assumes Identifier Registration ID, Phase is Registration Phase and Citizen Came to Pre registration with ID :"+previousIdentifier,
							moiTraceRequest);
					
					return null;
				}			
			case MosipPhase.FREEZED_PHASE :
				if(!previousModuleType.equals(MosipPhase.REGISTRATION_PHASE)) {
					updateTraceComment(
							"Treating Request as Invalid ",
							moiTraceRequest);
					updateTraceRequest(
							"Invalid Previous Module :"+previousModuleType,
							moiTraceRequest);
					return "Invalid Previous Module :"+previousModuleType;
				}
				
				if(!previousIdentifier.equals(MosipPhase.NO_PREVIOUS_IDENTIFIER) || !previousIdentifier.equals(MosipPhase.NOT_APPLICABLE)) {
					updateTraceComment(
							"Treating Request as Invalid ",
							moiTraceRequest);
					updateTraceRequest(
							"Invalid Previous Identifier :"+previousIdentifier,
							moiTraceRequest);
					return "Invalid Previous Identifier :"+previousIdentifier;
				}
				updateTraceComment(
						"VALID Request ",
						moiTraceRequest);
			return null;
			case MosipPhase.PORTAL_FOR_AGENT :
				if(!previousModuleType.equals(MosipPhase.NOT_APPLICABLE) || !previousIdentifier.equals(MosipPhase.NOT_APPLICABLE)) {
					updateTraceComment(
							"Treating Request as Invalid ",
							moiTraceRequest);
					updateTraceRequest(
							"Previous Module Type and Previous Identifier is not applicable for Module Type"+MosipPhase.PORTAL_FOR_AGENT,
							moiTraceRequest);
					return "Previous Module Type and Previous Identifier is not applicable for Module Type"+MosipPhase.PORTAL_FOR_AGENT;
				}
				updateTraceComment(
						"VALID Request ",
						moiTraceRequest);
				return null;	
			case MosipPhase.PORTAL_FOR_RESIDENT :
				if(!previousModuleType.equals(MosipPhase.NOT_APPLICABLE) || !previousIdentifier.equals(MosipPhase.NOT_APPLICABLE)) {
					updateTraceComment(
							"Treating Request as Invalid ",
							moiTraceRequest);
					updateTraceRequest(
							"Previous Module Type and Previous Identifier is not applicable for Module Type"+MosipPhase.PORTAL_FOR_RESIDENT,
							moiTraceRequest);
					return "Previous Module Type and Previous Identifier is not applicable for Module Type"+MosipPhase.PORTAL_FOR_RESIDENT;
				}
				updateTraceComment(
						"VALID Request ",
						moiTraceRequest);
				return null;
			default :
				return "Error";
		}
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

	
	/**
	 * This method validates Consumer Code with Document Type.
	 * 
	 * @return true if Consumer Code and Document Type is valid
	 */
	private static boolean isConsumerCodeValid(String consumerCode,
			String documentType) {

		long count = ConsumerRegistrationLocalServiceUtil
				.countByConsumerIdDocumentType(consumerCode, documentType);

		return (count >= 1) ? true : false;
	}
	private static final Log _log = LogFactoryUtil.getLog(
			MosipValidator.class);
}
