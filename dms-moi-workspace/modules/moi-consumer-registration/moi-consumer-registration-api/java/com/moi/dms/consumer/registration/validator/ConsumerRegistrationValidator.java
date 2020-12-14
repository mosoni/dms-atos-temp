package com.moi.dms.consumer.registration.validator;

import com.moi.dms.consumer.registration.exception.ConsumerRegistrationValidationException;
import com.moi.dms.consumer.registration.model.ConsumerRegistration;

import java.util.List;

public interface ConsumerRegistrationValidator {

	/**
	 * Validates an Assignment
	 * 
	 * @param descriptionMap
	 * @throws AssignmentValidationException
	 */
	public void validate(long consumerRegistrationId, String consumerId, String consumerName,
			String supportedDocumentTypes, List<ConsumerRegistration> existingConsumerRegistrations)
			throws ConsumerRegistrationValidationException;
}