package com.moi.mosip.validator;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.moi.dms.consumer.registration.service.ConsumerRegistrationLocalServiceUtil;
import com.moi.dms.id.mapper.model.MOIIdMapper;
import com.moi.dms.id.mapper.service.MOIIdMapperLocalServiceUtil;
import com.moi.dms.mosip.constants.MosipConstants;
import com.moi.dms.mosip.constants.MosipErrorConstants;
import com.moi.dms.mosip.constants.MosipPhase;
import com.moi.dms.trace.request.model.MOITraceRequest;
import com.moi.dms.trace.request.service.MOITraceRequestLocalServiceUtil;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The purpose of this class is to trace and validate Mosip Request
 * 
 * @author Mohit Soni
 *
 */
public class MosipValidator {

	
	public static final String INVALID_REQUEST="Invalid Request";
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
		updateTraceComment(
				"requestedOperation is :" + requestedOperation,
				moiTraceRequest);
		/* Start : moduleType */
		if (Validator.isNull(moduleType)
				|| !MosipPhase.getPhases().contains(moduleType)) {
			updateTraceComment(
					INVALID_REQUEST,
					moiTraceRequest);
			updateTraceRequest(MosipErrorConstants.MOSIP_INVALID_MODULE_TYPE,
					moiTraceRequest,false);
			return MosipErrorConstants.MOSIP_INVALID_MODULE_TYPE;
		}
		/* End : moduleType */

		String identifierResult = validateIdentifier(previousModuleType,
				previousidentifier, moiTraceRequest, previousModuleType,
				identifierNumber);

		if (Validator.isNotNull(identifierResult)) {
			updateTraceComment(
					INVALID_REQUEST,
					moiTraceRequest);
			updateTraceRequest(identifierResult, moiTraceRequest,false);
			return identifierResult;
		}

		/* End : Previous Module/Identifier */

		/* Start : Consumer and Document Type */
		if (!isConsumerCodeValid(consumerCode, documentType)) {
			/* Update Trace Request */
			updateTraceComment(
					MosipErrorConstants.MOSIP_INVALID_CONSUMER_CODE_OR_DOCUMENT_TYPE,
					moiTraceRequest);
			updateTraceComment(
					INVALID_REQUEST,
					moiTraceRequest);
			updateTraceRequest(
					MosipErrorConstants.MOSIP_INVALID_CONSUMER_CODE_OR_DOCUMENT_TYPE,
					moiTraceRequest,false);
			return MosipErrorConstants.MOSIP_INVALID_CONSUMER_CODE_OR_DOCUMENT_TYPE;
		}
		/* End : Consumer and Document Type */

		/* Start : Validating Document */
		String documentValidation = MosipDocumentValidator
				.isDocumentValid(file,moiTraceRequest);
		if (Validator.isNotNull(documentValidation)) {
			/* Update Trace Request */
			updateTraceComment(
					INVALID_REQUEST,
					moiTraceRequest);
			updateTraceRequest(documentValidation, moiTraceRequest,false);
			return documentValidation;
		}
		/* End : Validating Document */

		/* Start : Validating Authority */
		if (!MosipAuthorizationValidator.isRequestAuthorized(moduleType,
				requestedOperation,moiTraceRequest)) {
			/* Update Trace Request */
			updateTraceComment(
					INVALID_REQUEST,
					moiTraceRequest);
			updateTraceRequest(
					MosipErrorConstants.MOSIP_AUTHORIZATION_LEVEL_MESSAGE,
					moiTraceRequest,false);
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
					moiTraceRequest,false);
			return MosipErrorConstants.MOSIP_INVALID_PREVIOUS_MODULE_TYPE_OR_IDENTIFIER;
		}else if(!MosipPhase.getPreviousPhaseOptions().contains(previousModuleType)) {
			updateTraceComment(
					"Treating Request as Invalid ",
					moiTraceRequest);
			updateTraceRequest(
					MosipErrorConstants.MOSIP_INVALID_PREVIOUS_MODULE_TYPE_OR_IDENTIFIER,
					moiTraceRequest,false);
		}
		
		switch (moduleType) {
			case MosipPhase.PRE_REGISTRATION_PHASE :
				/*
				 * Its First Entry point for any Document and No Previous Module
				 * and Identifier is applicable
				 */
				updateTraceComment(
						"Assuming 1st Entry point is Pre registration with Pre Reg ID "
								+ identifier,
						moiTraceRequest);
				if (!previousModuleType.equals(MosipPhase.NO_PREVIOUS_MODULE)
						|| !previousIdentifier
								.equals(MosipPhase.NO_PREVIOUS_IDENTIFIER)) {
					updateTraceRequest(
							MosipErrorConstants.MOSIP_INVALID_PREVIOUS_MODULE_TYPE_OR_IDENTIFIER,
							moiTraceRequest,false);
					return MosipErrorConstants.MOSIP_INVALID_PREVIOUS_MODULE_TYPE_OR_IDENTIFIER;
				}
				updateTraceComment(
						IDENTIFIER_PARAM_CORRECT,
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
								moiTraceRequest,false);
						return "No Previous Module Should have No Previous Identifier, Please make sure parameters are correct";
					}

					updateTraceComment(
							IDENTIFIER_PARAM_CORRECT,
							moiTraceRequest);
					
					/*End Use case 1*/
				}else {
					/*Start Use case 2 : When end user directly comes to Pre Registration then move to Registration phase*/
					updateTraceComment(
							"Assuming Pre registration Exist for Registration ID "
									+ identifier +" and Pre Registration ID "+previousIdentifier,
							moiTraceRequest);
					
					if(!previousModuleType.equals(MosipPhase.PRE_REGISTRATION_PHASE)) {
						updateTraceRequest(
								"Invalid Previous Module :"+previousModuleType,
								moiTraceRequest,false);
						return "Invalid Previous Module :"+previousModuleType;
					}
					
					if(!previousIdentifier.equals(MosipPhase.NO_PREVIOUS_IDENTIFIER) || !previousIdentifier.equals(MosipPhase.NOT_APPLICABLE)) {
						updateTraceRequest(
								"Invalid Previous Identifier :"+previousIdentifier,
								moiTraceRequest,false);
						return "Invalid Previous Identifier :"+previousIdentifier;
					}
					
					updateTraceComment(
							IDENTIFIER_PARAM_CORRECT,
							moiTraceRequest);
					
					return null;
				}			
			case MosipPhase.FREEZED_PHASE :
				if(!previousModuleType.equals(MosipPhase.REGISTRATION_PHASE)) {
					updateTraceRequest(
							"Invalid Previous Module :"+previousModuleType,
							moiTraceRequest,false);
					return "Invalid Previous Module :"+previousModuleType;
				}
				
				if(!previousIdentifier.equals(MosipPhase.NO_PREVIOUS_IDENTIFIER) || !previousIdentifier.equals(MosipPhase.NOT_APPLICABLE)) {
					updateTraceRequest(
							"Invalid Previous Identifier :"+previousIdentifier,
							moiTraceRequest,false);
					return "Invalid Previous Identifier :"+previousIdentifier;
				}
				updateTraceComment(
						IDENTIFIER_PARAM_CORRECT,
						moiTraceRequest);
			return null;
			case MosipPhase.PORTAL_FOR_AGENT :
				if(!previousModuleType.equals(MosipPhase.NOT_APPLICABLE) || !previousIdentifier.equals(MosipPhase.NOT_APPLICABLE)) {
					updateTraceRequest(
							"Previous Module Type and Previous Identifier is not applicable for Module Type"+MosipPhase.PORTAL_FOR_AGENT,
							moiTraceRequest,false);
					return "Previous Module Type and Previous Identifier is not applicable for Module Type"+MosipPhase.PORTAL_FOR_AGENT;
				}
				updateTraceComment(
						IDENTIFIER_PARAM_CORRECT,
						moiTraceRequest);
				return null;	
			case MosipPhase.PORTAL_FOR_RESIDENT :
				if(!previousModuleType.equals(MosipPhase.NOT_APPLICABLE) || !previousIdentifier.equals(MosipPhase.NOT_APPLICABLE)) {
					updateTraceRequest(
							"Previous Module Type and Previous Identifier is not applicable for Module Type"+MosipPhase.PORTAL_FOR_RESIDENT,
							moiTraceRequest,false);
					return "Previous Module Type and Previous Identifier is not applicable for Module Type"+MosipPhase.PORTAL_FOR_RESIDENT;
				}
				updateTraceComment(
						IDENTIFIER_PARAM_CORRECT,
						moiTraceRequest);
				return null;
			default :
				return "Error";
		}
	}

	
	/**
	 * This method is used to analyse ID Mapper
	 *
	 * @param IdentifierNumber
	 * @param moduleType : 
	 */
	public static Map<String,String> validateIDMapper(long groupId, long companyId,long userId,String identifierNumber,String moduleType,
			String previousIdentifier, String documentType,
			String previousModule, MOITraceRequest moiTraceRequest) {

		Map<String, String> resultMap = new HashMap<String, String>();

		/*
		 * Checking if Any Entry Exist with IdentifierNumber and moduleType
		 */
		MOIIdMapper moiIdMapper = checkAvailableMapping(identifierNumber,
				moduleType);;
		updateTraceComment("{ ID Mapper Start === ", moiTraceRequest);
		updateTraceComment("IdentifierNumber : " + identifierNumber,
				moiTraceRequest);
		updateTraceComment("moduleType : " + moduleType, moiTraceRequest);
		updateTraceComment("previousIdentifier : " + previousIdentifier,
				moiTraceRequest);
		updateTraceComment("previousModule : " + previousModule,
				moiTraceRequest);

		if (moduleType.equals(MosipPhase.PRE_REGISTRATION_PHASE)) {

			if (Validator.isNull(moiIdMapper)) {
				updateTraceComment(
						"Request is raised for the First time as No Mapper Exist",
						moiTraceRequest);
				try {
					moiIdMapper = MOIIdMapperLocalServiceUtil.addMOIIdMapper(
							groupId, companyId, moduleType, documentType,
							identifierNumber,
							CounterLocalServiceUtil
									.increment(MOIIdMapper.class.getName()),
							null, 1, null, new Date(), String.valueOf(userId));

					updateTraceComment(
							" Added new IDMapper for Pre Registration Phase Resource Id :"
									+ moiIdMapper.getResourceId(),
							moiTraceRequest);
				} catch (PortalException e) {
					resultMap.put(MosipConstants.ERROR,
							MosipErrorConstants.IDENTIFIER_UNABLE_TO_PROCESS_MAPPING
									.replace(
											MosipConstants.TRACE_REFERNCE_NUMBER_DYNAMIC_PARAMETER,
											String.valueOf(moiTraceRequest
													.getRequestId())));
					_log.error(e);
					return resultMap;
				}
			} else {
				/* Entry already available in MOIMapper */
				updateTraceComment(
						"Found existing Pre Registration in IDMapper with Resource ID "
								+ moiIdMapper.getResourceId(),
						moiTraceRequest);
			}

		} else if (moduleType.equals(MosipPhase.REGISTRATION_PHASE)) {
			/*
			 * Registration Phase has 2 use cases , 1st : When end user directly
			 * comes to Registration phase i.e. No Pre Registration. 2nd : When
			 * end user directly comes to Pre Registration then move to
			 * Registration phase.
			 */
			if (previousModule.equals(MosipPhase.NO_PREVIOUS_MODULE)) {
				/*
				 * Start Use case 1 : When end user directly comes to
				 * Registration phase i.e. No Pre Registration
				 */

				updateTraceComment(
						"Assuming No Pre registration Exist for Registration ID "
								+ identifierNumber
								+ " So checking if ID Mapper has any content ",
						moiTraceRequest);
				/*
				 * Checking if Any Entry Exist with IdentifierNumber and
				 * moduleType
				 */
				moiIdMapper = checkAvailableMapping(identifierNumber,
						moduleType);

				if (Validator.isNull(moiIdMapper)) {
					updateTraceComment(
							"Request is raised for the First time in Registration Phase (No Mapper Exist) So adding a new One",
							moiTraceRequest);
					try {
						moiIdMapper = MOIIdMapperLocalServiceUtil
								.addMOIIdMapper(groupId, companyId, moduleType,
										documentType, identifierNumber,
										CounterLocalServiceUtil.increment(
												MOIIdMapper.class.getName()),
										null, 1, null, new Date(),
										String.valueOf(userId));
						updateTraceComment(
								" Added new IDMapper for Registration Phase Resource Id :"
										+ moiIdMapper.getResourceId(),
								moiTraceRequest);
					} catch (PortalException e) {
						_log.error(e);
					}

					/* End Use case 1 */
				} else {
					/* Entry already available in MOIMapper */
					updateTraceComment(
							"Found existing Registration in IDMapper wit Resource ID "
									+ moiIdMapper.getResourceId(),
							moiTraceRequest);
				}

			} else if (previousModule
					.equals(MosipPhase.PRE_REGISTRATION_PHASE)) {
				/*
				 * Start Use case 2 : When end user directly comes to Pre
				 * Registration then move to Registration phase
				 */
				updateTraceComment(
						"Assuming Pre registration Exist for Registration ID "
								+ identifierNumber + " and Pre Registration ID "
								+ previousIdentifier,
						moiTraceRequest);

				/* Registration ID is coming for the first time, Checking if */
				if (Validator.isNull(moiIdMapper)) {
					updateTraceComment(
							"Registration ID coming for the first time because IDMapper not available for Registration ID "
									+ identifierNumber
									+ " Start Checking if Pre Registration Exist ? ",
							moiTraceRequest);

					MOIIdMapper previousIDMaper = checkAvailableMapping(
							previousIdentifier, previousModule);
					if (Validator.isNull(previousIDMaper)) {
						updateTraceComment(
								" NO, Pre Registration does not exist with Pre Reg ID "
										+ previousIdentifier
										+ " THIS IS UNEXPECTED ",
								moiTraceRequest);

						resultMap.put(MosipConstants.ERROR,
								MosipErrorConstants.PRE_REGISTRATION_ID_DOESNT_EXIST
										.replace(
												MosipConstants.TRACE_REFERNCE_NUMBER_DYNAMIC_PARAMETER,
												String.valueOf(moiTraceRequest
														.getRequestId())));
						return resultMap;
					} else {
						updateTraceComment(
								" YES, Pre Registration exist with Pre Reg ID , which is EXPECTED, PRE REG ID"
										+ previousIdentifier,
								moiTraceRequest);

						updateTraceComment(
								" Adding Registration Number to MOIMapper with Registration ID "
										+ identifierNumber + "Resource ID :"
										+ previousIDMaper.getResourceId(),
								moiTraceRequest);

						try {
							moiIdMapper = MOIIdMapperLocalServiceUtil
									.addMOIIdMapper(groupId, companyId,
											moduleType, documentType,
											identifierNumber,
											previousIDMaper.getResourceId(),
											null, 1, null, new Date(),
											String.valueOf(userId));

							updateTraceComment(
									" Added new Registration Number for Registration Number:"
											+ moiIdMapper.getRegistrationId()
											+ " And resource ID "
											+ moiIdMapper.getResourceId(),
									moiTraceRequest);

							updateTraceComment(
									"Making pre Registration Phase Inactive",
									moiTraceRequest);

							previousIDMaper.setActiveState(0);
							previousIDMaper.setUpdateDate(new Date());
							MOIIdMapperLocalServiceUtil
									.updateMOIIdMapper(moiIdMapper);

							resultMap.put(MosipConstants.SUCCESS,
									MosipErrorConstants.ADD_REGISTRATION_NUMBER);

							return resultMap;

						} catch (PortalException e) {
							_log.error(e);
						}
					}
				} else {
					updateTraceComment(
							"ID Mapper is not null, which means Registration Exist in ID Mapper",
							moiTraceRequest);
				}

				return null;
			}

			/*
			 * Start Use case 2 : When end user directly comes to Pre
			 * Registration then move to Registration phase
			 */
			updateTraceComment(
					"Registration phase but not executed any if else condition"
							+ identifierNumber + " and Pre Registration ID "
							+ previousIdentifier + ":: Previous Module :"
							+ previousModule,
					moiTraceRequest);

		} else if (moduleType.equals(MosipPhase.FREEZED_PHASE)) {

			if (previousModule.equals(MosipPhase.REGISTRATION_PHASE)) {

				/* IDCS ID is coming for the first time */
				if (Validator.isNull(moiIdMapper)) {
					updateTraceComment(
							"IDCS ID coming for the first time because IDMapper not available for IDCS ID "
									+ identifierNumber
									+ " Start Checking if Registration ID Exist ? ",
							moiTraceRequest);

					MOIIdMapper previousIDMaper = checkAvailableMapping(
							previousIdentifier, previousModule);
					if (Validator.isNull(moiIdMapper)) {
						updateTraceComment(
								" NO, Registration does not exist with Reg ID "
										+ previousIdentifier
										+ " THIS IS UNEXPECTED ",
								moiTraceRequest);
						resultMap.put(MosipConstants.ERROR,
								MosipErrorConstants.REGISTRATION_ID_DOESNT_EXIST
										.replace(
												MosipConstants.TRACE_REFERNCE_NUMBER_DYNAMIC_PARAMETER,
												String.valueOf(moiTraceRequest
														.getRequestId())));
						return resultMap;
					} else {
						updateTraceComment(
								" YES, Registration exist with Reg ID , which is EXPECTED REG ID "
										+ previousIdentifier,
								moiTraceRequest);

						updateTraceComment(
								" Adding IDCS Number to MOIMapper with IDCS ID "
										+ identifierNumber + "Resource ID :"
										+ previousIDMaper.getResourceId(),
								moiTraceRequest);

						try {
							moiIdMapper = MOIIdMapperLocalServiceUtil
									.addMOIIdMapper(groupId, companyId,
											moduleType, documentType,
											identifierNumber,
											previousIDMaper.getResourceId(),
											null, 1, null, new Date(),
											String.valueOf(userId));

							updateTraceComment(
									" Added new IDCS Number for IDCS Number :"
											+ moiIdMapper.getRegistrationId()
											+ " And resource ID "
											+ moiIdMapper.getResourceId(),
									moiTraceRequest);

							updateTraceComment(
									"Making Registration Phase Inactive",
									moiTraceRequest);

							previousIDMaper.setActiveState(0);
							previousIDMaper.setUpdateDate(new Date());
							MOIIdMapperLocalServiceUtil
									.updateMOIIdMapper(moiIdMapper);

							resultMap.put(MosipConstants.SUCCESS,
									MosipErrorConstants.ADD_IDCS_NUMBER);

							return resultMap;

						} catch (PortalException e) {
							_log.error(e);
						}
					}
				} else {
					updateTraceComment(
							"ID Mapper is not null, which means IDCS Exist in ID Mapper",
							moiTraceRequest);
				}
			} else {
				updateTraceComment(
						"Unusual Request because Freezed Phase only expects Previous phase as REGISTRATION_PHASE but here Previous phase is "
								+ previousModule,
						moiTraceRequest);

				resultMap.put(MosipConstants.ERROR,
						MosipErrorConstants.IDENTIFIER_UNABLE_TO_PROCESS_MAPPING
								.replace(
										MosipConstants.TRACE_REFERNCE_NUMBER_DYNAMIC_PARAMETER,
										String.valueOf(moiTraceRequest
												.getRequestId())));
				return resultMap;
			}

		}
		updateTraceComment(" ==== ID Mapper End } ", moiTraceRequest);

		return null;
	}
	
	/*
	 * 
	 */
	/**
	 * This method is used to check if Any Entry Exist with IdentifierNumber and moduleType
	 *
	 * @param identifierNumber
	 * @param moduleType
	 * @return :
	 */
	private static MOIIdMapper checkAvailableMapping(String identifierNumber,
			String moduleType) {

		return MOIIdMapperLocalServiceUtil
				.findByRegistrationIdCurrentState(identifierNumber, moduleType);
	}
	
	public static final String IDENTIFIER_PARAM_CORRECT="Identifier Parameters are correct";
	/*
	 * This method is used to concatinate comment section of MOITraceRequest
	 *
	 * @param comment
	 * @param traceRequest : 
	 */
	public static void updateTraceComment(String comment,
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
			MOITraceRequest moiTraceRequest,boolean requestValid) {

		if (Validator.isNotNull(moiTraceRequest)) {
			moiTraceRequest.setRequestResult(result);
			moiTraceRequest.setRequestResultDate(new Date());
			moiTraceRequest.setRequestValid(requestValid);
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
