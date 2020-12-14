package com.moi.dms.consumer.registration.util.validator;

import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.Validator;
import com.moi.dms.consumer.registration.exception.ConsumerRegistrationValidationException;
import com.moi.dms.consumer.registration.model.ConsumerRegistration;
import com.moi.dms.consumer.registration.validator.ConsumerRegistrationValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true, 
	service = ConsumerRegistrationValidator.class
)
public class ConsumerRegistrationValidatorImpl
		implements ConsumerRegistrationValidator {

	/**
	 * Validates Consumer values and throws
	 * {ConsumerRegistrationValidationException} if the Consumer values are not
	 * valid.
	 * 
	 * @param descriptionMap
	 * @throws ConsumerRegistrationValidationException
	 */
	public void validate(long consumerRegistrationId, String consumerId,
			String consumerName, String supportedDocumentTypes,
			List<ConsumerRegistration> existingConsumerRegistrations)
			throws ConsumerRegistrationValidationException {

		List<String> errors = new ArrayList<String>();

		if (!isConsumerValid(consumerRegistrationId, consumerId, consumerName, supportedDocumentTypes,
				existingConsumerRegistrations, errors)) {
			throw new ConsumerRegistrationValidationException(errors);
		}
	}

	/**
	 * Returns <code>true</code> if the given fields are valid for an consumer.
	 * 
	 * @param descriptionMap
	 * @param errors
	 * @return boolean <code>true</code> if consumer is valid, otherwise
	 *         <code>false</code>
	 */
	private boolean isConsumerValid(final long consumerRegistrationId,
			final String consumerId, final String consumerName,
			final String supportedDocumentTypes,
			final List<ConsumerRegistration> existingConsumerRegistrations,
			final List<String> errors) {

		boolean result = true;
		result &= isConsumerDetailValid(consumerRegistrationId, consumerId,
				consumerName, supportedDocumentTypes, existingConsumerRegistrations, errors);
		// result &= isDescriptionValid(descriptionMap, errors);
		return result;
	}

	private boolean isConsumerDetailValid(final long consumerRegistrationId,
			final String consumerId, final String consumerName, String supportedDocumentTypes,
			final List<ConsumerRegistration> existingConsumerRegistrations,
			final List<String> errors) {

		boolean result = true;
		if (consumerRegistrationId <= 0) {
			for (ConsumerRegistration existingConsumer : existingConsumerRegistrations) {
				if (existingConsumer.getConsumerId().equals(consumerId)) {
					if(!existingConsumer.getConsumerName().equals(consumerName)) {
						errors.add("consumerIdInvalid");
						result = false;
						break;
					}
				}
				
				if (existingConsumer.getConsumerName().equals(consumerName)) {
					if(!existingConsumer.getConsumerId().equals(consumerId)) {
						errors.add("consumerNameInvalid");
						result = false;
						break;
					}
				}

				if (existingConsumer.getConsumerName().equals(consumerName)
						&& existingConsumer.getConsumerId().equals(consumerId)
						&& existingConsumer.getSupportedDocumentType()
								.equals(supportedDocumentTypes)
						&& existingConsumer
								.getRegistrationId() != consumerRegistrationId) {
					errors.add("documentTypeExists");
					result = false;
					break;
				}
			}
		} else {
			for (ConsumerRegistration existingConsumer : existingConsumerRegistrations) {
				if (existingConsumer.getConsumerId().equals(consumerId)
						&& existingConsumer
								.getRegistrationId() != consumerRegistrationId) {
					if (!existingConsumer.getConsumerName()
							.equals(consumerName)) {
						errors.add("consumerIdInvalid");
						result = false;
						break;
					}
				}

				if (existingConsumer.getConsumerName().equals(consumerName)
						&& existingConsumer
								.getRegistrationId() != consumerRegistrationId) {
					if (!existingConsumer.getConsumerId().equals(consumerId)) {
						errors.add("consumerNameInvalid");
						result = false;
						break;
					}
				}

				if (existingConsumer.getConsumerName().equals(consumerName)
						&& existingConsumer.getConsumerId().equals(consumerId)
						&& existingConsumer.getSupportedDocumentType()
								.equals(supportedDocumentTypes)
						&& existingConsumer
								.getRegistrationId() != consumerRegistrationId) {
					errors.add("documentTypeExists");
					result = false;
					break;
				}
			}
		}
		return result;
	}

	/**
	 * Returns <code>true</code> if description is valid for an consumer. If
	 * not valid, an error message is added to the errors list.
	 * 
	 * @param descriptionMap
	 * @param errors
	 * @return boolean <code>true</code> if description is valid, otherwise
	 *         <code>false</code>
	 */
	private boolean isDescriptionValid(final Map<Locale, String> descriptionMap,
			final List<String> errors) {

		boolean result = true;

		// Verify the map has something
		if (MapUtil.isEmpty(descriptionMap)) {
			System.out.println("Is Empty");
			errors.add("consumerDescriptionEmpty");
			result = false;
		} else {
			System.out.println("Is Not Empty");
			// Get the default locale
			Locale defaultLocale = LocaleUtil.getSiteDefault();
			System.out.println("defaultLocale: " + defaultLocale + "::" + descriptionMap.get(defaultLocale));
			if ((Validator.isBlank(descriptionMap.get(defaultLocale)))) {
				errors.add("consumerDescriptionEmpty");
				result = false;
			}
		}
		return result;
	}
}
