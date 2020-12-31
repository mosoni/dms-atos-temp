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

package com.moi.dms.consumer.registration.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ConsumerRegistrationService}.
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerRegistrationService
 * @generated
 */
public class ConsumerRegistrationServiceWrapper
	implements ConsumerRegistrationService,
			   ServiceWrapper<ConsumerRegistrationService> {

	public ConsumerRegistrationServiceWrapper(
		ConsumerRegistrationService consumerRegistrationService) {

		_consumerRegistrationService = consumerRegistrationService;
	}

	/**
	 * Remote service to add new consumer registration.
	 *
	 * @param consumerName
	 * @param consumerId
	 * @param descriptionMap
	 * @param supportedDocumentType
	 * @param consumerStatus
	 * @return ConsumerRegistration
	 * @throws PortalException
	 */
	@Override
	public com.moi.dms.consumer.registration.model.ConsumerRegistration
			addConsumerRegistration(
				String consumerName, String consumerId,
				java.util.Map<java.util.Locale, String> descriptionMap,
				String supportedDocumentType, String consumerStatus)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _consumerRegistrationService.addConsumerRegistration(
			consumerName, consumerId, descriptionMap, supportedDocumentType,
			consumerStatus);
	}

	/**
	 * Delete the consumer registration with the primary key.
	 *
	 * @param registrationId the primary key of the consumer registration
	 * @return the consumer registration
	 * @throws PortalException if a consumer registration with the primary key could not be found
	 */
	@Override
	public com.moi.dms.consumer.registration.model.ConsumerRegistration
			deleteConsumerRegistration(long registrationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _consumerRegistrationService.deleteConsumerRegistration(
			registrationId);
	}

	/**
	 * Returns all the consumer registrations
	 *
	 * @param consumerId
	 * @return the consumer registration
	 * @throws PortalException
	 */
	@Override
	public java.util.List
		<com.moi.dms.consumer.registration.model.ConsumerRegistration>
			getAllConsumerRegistrations() {

		return _consumerRegistrationService.getAllConsumerRegistrations();
	}

	/**
	 * Returns the consumer registration with the primary key.
	 *
	 * @param registrationId the primary key of the consumer registration
	 * @return the consumer registration
	 * @throws PortalException if a consumer registration with the primary key could not be found
	 */
	@Override
	public com.moi.dms.consumer.registration.model.ConsumerRegistration
			getConsumerRegistration(long registrationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _consumerRegistrationService.getConsumerRegistration(
			registrationId);
	}

	/**
	 * Returns the consumer registration with the Consumer Id.
	 *
	 * @param consumerId
	 * @return the consumer registration
	 * @throws PortalException
	 */
	@Override
	public java.util.List
		<com.moi.dms.consumer.registration.model.ConsumerRegistration>
			getConsumerRegistrationByConsumerId(String consumerId) {

		return _consumerRegistrationService.getConsumerRegistrationByConsumerId(
			consumerId);
	}

	/**
	 * Returns the consumer registrations with keywords.
	 *
	 * @param keywords
	 * @param start
	 * @param end
	 * @param orderByComparator
	 * @return List<ConsumerRegistration>
	 */
	@Override
	public java.util.List
		<com.moi.dms.consumer.registration.model.ConsumerRegistration>
			getConsumerRegistrationByKeywords(
				String keywords, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.moi.dms.consumer.registration.model.
						ConsumerRegistration> orderByComparator) {

		return _consumerRegistrationService.getConsumerRegistrationByKeywords(
			keywords, start, end, orderByComparator);
	}

	/**
	 * Returns the consumer registrations count with keywords.
	 *
	 * @param keywords
	 * @return long
	 */
	@Override
	public long getConsumerRegistrationCountByKeywords(String keywords) {
		return _consumerRegistrationService.
			getConsumerRegistrationCountByKeywords(keywords);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _consumerRegistrationService.getOSGiServiceIdentifier();
	}

	/**
	 * Remote service to update consumer registration.
	 *
	 * @param consumerRegistrationId
	 * @param consumerName
	 * @param consumerId
	 * @param descriptionMap
	 * @param supportedDocumentType
	 * @param consumerStatus
	 * @return ConsumerRegistration
	 * @throws PortalException
	 */
	@Override
	public com.moi.dms.consumer.registration.model.ConsumerRegistration
			updateConsumerRegistration(
				long consumerRegistrationId, String consumerName,
				String consumerId,
				java.util.Map<java.util.Locale, String> descriptionMap,
				String supportedDocumentType, String consumerStatus)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _consumerRegistrationService.updateConsumerRegistration(
			consumerRegistrationId, consumerName, consumerId, descriptionMap,
			supportedDocumentType, consumerStatus);
	}

	@Override
	public ConsumerRegistrationService getWrappedService() {
		return _consumerRegistrationService;
	}

	@Override
	public void setWrappedService(
		ConsumerRegistrationService consumerRegistrationService) {

		_consumerRegistrationService = consumerRegistrationService;
	}

	private ConsumerRegistrationService _consumerRegistrationService;

}