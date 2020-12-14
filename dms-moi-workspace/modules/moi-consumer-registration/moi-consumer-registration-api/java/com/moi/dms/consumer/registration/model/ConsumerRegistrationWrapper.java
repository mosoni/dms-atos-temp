/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.moi.dms.consumer.registration.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link ConsumerRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerRegistration
 * @generated
 */
@ProviderType
public class ConsumerRegistrationWrapper
	extends BaseModelWrapper<ConsumerRegistration>
	implements ConsumerRegistration, ModelWrapper<ConsumerRegistration> {

	public ConsumerRegistrationWrapper(
		ConsumerRegistration consumerRegistration) {

		super(consumerRegistration);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("registrationId", getRegistrationId());
		attributes.put("consumerId", getConsumerId());
		attributes.put("consumerName", getConsumerName());
		attributes.put("consumerDescription", getConsumerDescription());
		attributes.put("supportedDocumentType", getSupportedDocumentType());
		attributes.put("consumerStatus", getConsumerStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long registrationId = (Long)attributes.get("registrationId");

		if (registrationId != null) {
			setRegistrationId(registrationId);
		}

		String consumerId = (String)attributes.get("consumerId");

		if (consumerId != null) {
			setConsumerId(consumerId);
		}

		String consumerName = (String)attributes.get("consumerName");

		if (consumerName != null) {
			setConsumerName(consumerName);
		}

		String consumerDescription = (String)attributes.get(
			"consumerDescription");

		if (consumerDescription != null) {
			setConsumerDescription(consumerDescription);
		}

		String supportedDocumentType = (String)attributes.get(
			"supportedDocumentType");

		if (supportedDocumentType != null) {
			setSupportedDocumentType(supportedDocumentType);
		}

		String consumerStatus = (String)attributes.get("consumerStatus");

		if (consumerStatus != null) {
			setConsumerStatus(consumerStatus);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the consumer description of this consumer registration.
	 *
	 * @return the consumer description of this consumer registration
	 */
	@Override
	public String getConsumerDescription() {
		return model.getConsumerDescription();
	}

	/**
	 * Returns the localized consumer description of this consumer registration in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized consumer description of this consumer registration
	 */
	@Override
	public String getConsumerDescription(java.util.Locale locale) {
		return model.getConsumerDescription(locale);
	}

	/**
	 * Returns the localized consumer description of this consumer registration in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized consumer description of this consumer registration. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getConsumerDescription(
		java.util.Locale locale, boolean useDefault) {

		return model.getConsumerDescription(locale, useDefault);
	}

	/**
	 * Returns the localized consumer description of this consumer registration in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized consumer description of this consumer registration
	 */
	@Override
	public String getConsumerDescription(String languageId) {
		return model.getConsumerDescription(languageId);
	}

	/**
	 * Returns the localized consumer description of this consumer registration in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized consumer description of this consumer registration
	 */
	@Override
	public String getConsumerDescription(
		String languageId, boolean useDefault) {

		return model.getConsumerDescription(languageId, useDefault);
	}

	@Override
	public String getConsumerDescriptionCurrentLanguageId() {
		return model.getConsumerDescriptionCurrentLanguageId();
	}

	@Override
	public String getConsumerDescriptionCurrentValue() {
		return model.getConsumerDescriptionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized consumer descriptions of this consumer registration.
	 *
	 * @return the locales and localized consumer descriptions of this consumer registration
	 */
	@Override
	public Map<java.util.Locale, String> getConsumerDescriptionMap() {
		return model.getConsumerDescriptionMap();
	}

	/**
	 * Returns the consumer ID of this consumer registration.
	 *
	 * @return the consumer ID of this consumer registration
	 */
	@Override
	public String getConsumerId() {
		return model.getConsumerId();
	}

	/**
	 * Returns the consumer name of this consumer registration.
	 *
	 * @return the consumer name of this consumer registration
	 */
	@Override
	public String getConsumerName() {
		return model.getConsumerName();
	}

	/**
	 * Returns the consumer status of this consumer registration.
	 *
	 * @return the consumer status of this consumer registration
	 */
	@Override
	public String getConsumerStatus() {
		return model.getConsumerStatus();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the primary key of this consumer registration.
	 *
	 * @return the primary key of this consumer registration
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the registration ID of this consumer registration.
	 *
	 * @return the registration ID of this consumer registration
	 */
	@Override
	public long getRegistrationId() {
		return model.getRegistrationId();
	}

	/**
	 * Returns the supported document type of this consumer registration.
	 *
	 * @return the supported document type of this consumer registration
	 */
	@Override
	public String getSupportedDocumentType() {
		return model.getSupportedDocumentType();
	}

	@Override
	public void persist() {
		model.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
			java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	/**
	 * Sets the consumer description of this consumer registration.
	 *
	 * @param consumerDescription the consumer description of this consumer registration
	 */
	@Override
	public void setConsumerDescription(String consumerDescription) {
		model.setConsumerDescription(consumerDescription);
	}

	/**
	 * Sets the localized consumer description of this consumer registration in the language.
	 *
	 * @param consumerDescription the localized consumer description of this consumer registration
	 * @param locale the locale of the language
	 */
	@Override
	public void setConsumerDescription(
		String consumerDescription, java.util.Locale locale) {

		model.setConsumerDescription(consumerDescription, locale);
	}

	/**
	 * Sets the localized consumer description of this consumer registration in the language, and sets the default locale.
	 *
	 * @param consumerDescription the localized consumer description of this consumer registration
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setConsumerDescription(
		String consumerDescription, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setConsumerDescription(
			consumerDescription, locale, defaultLocale);
	}

	@Override
	public void setConsumerDescriptionCurrentLanguageId(String languageId) {
		model.setConsumerDescriptionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized consumer descriptions of this consumer registration from the map of locales and localized consumer descriptions.
	 *
	 * @param consumerDescriptionMap the locales and localized consumer descriptions of this consumer registration
	 */
	@Override
	public void setConsumerDescriptionMap(
		Map<java.util.Locale, String> consumerDescriptionMap) {

		model.setConsumerDescriptionMap(consumerDescriptionMap);
	}

	/**
	 * Sets the localized consumer descriptions of this consumer registration from the map of locales and localized consumer descriptions, and sets the default locale.
	 *
	 * @param consumerDescriptionMap the locales and localized consumer descriptions of this consumer registration
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setConsumerDescriptionMap(
		Map<java.util.Locale, String> consumerDescriptionMap,
		java.util.Locale defaultLocale) {

		model.setConsumerDescriptionMap(consumerDescriptionMap, defaultLocale);
	}

	/**
	 * Sets the consumer ID of this consumer registration.
	 *
	 * @param consumerId the consumer ID of this consumer registration
	 */
	@Override
	public void setConsumerId(String consumerId) {
		model.setConsumerId(consumerId);
	}

	/**
	 * Sets the consumer name of this consumer registration.
	 *
	 * @param consumerName the consumer name of this consumer registration
	 */
	@Override
	public void setConsumerName(String consumerName) {
		model.setConsumerName(consumerName);
	}

	/**
	 * Sets the consumer status of this consumer registration.
	 *
	 * @param consumerStatus the consumer status of this consumer registration
	 */
	@Override
	public void setConsumerStatus(String consumerStatus) {
		model.setConsumerStatus(consumerStatus);
	}

	/**
	 * Sets the primary key of this consumer registration.
	 *
	 * @param primaryKey the primary key of this consumer registration
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the registration ID of this consumer registration.
	 *
	 * @param registrationId the registration ID of this consumer registration
	 */
	@Override
	public void setRegistrationId(long registrationId) {
		model.setRegistrationId(registrationId);
	}

	/**
	 * Sets the supported document type of this consumer registration.
	 *
	 * @param supportedDocumentType the supported document type of this consumer registration
	 */
	@Override
	public void setSupportedDocumentType(String supportedDocumentType) {
		model.setSupportedDocumentType(supportedDocumentType);
	}

	@Override
	protected ConsumerRegistrationWrapper wrap(
		ConsumerRegistration consumerRegistration) {

		return new ConsumerRegistrationWrapper(consumerRegistration);
	}

}