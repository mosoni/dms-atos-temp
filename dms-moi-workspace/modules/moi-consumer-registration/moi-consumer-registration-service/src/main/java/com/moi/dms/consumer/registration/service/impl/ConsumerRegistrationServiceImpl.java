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

package com.moi.dms.consumer.registration.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.moi.dms.consumer.registration.model.ConsumerRegistration;
import com.moi.dms.consumer.registration.service.base.ConsumerRegistrationServiceBaseImpl;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the consumer registration remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.moi.dms.consumer.registration.service.ConsumerRegistrationService</code>
 * interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerRegistrationServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=dms",
		"json.web.service.context.path=ConsumerRegistration"
	},
	service = AopService.class
)
public class ConsumerRegistrationServiceImpl
	extends ConsumerRegistrationServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.moi.dms.consumer.registration.service.ConsumerRegistrationServiceUtil</code> to access the consumer registration remote service.
	 */

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
	public ConsumerRegistration addConsumerRegistration(String consumerName,
			String consumerId, Map<Locale, String> descriptionMap,
			String supportedDocumentType, String consumerStatus)
			throws PortalException {

		return consumerRegistrationLocalService.addConsumerRegistration(
				consumerName, consumerId, descriptionMap, supportedDocumentType,
				consumerStatus);
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
	public ConsumerRegistration updateConsumerRegistration(
			long consumerRegistrationId, String consumerName, String consumerId,
			Map<Locale, String> descriptionMap, String supportedDocumentType,
			String consumerStatus)
			throws PortalException {

		return consumerRegistrationLocalService.updateConsumerRegistration(
				consumerRegistrationId, consumerName, consumerId,
				descriptionMap, supportedDocumentType, consumerStatus);
	}

	/**
	 * Delete the consumer registration with the primary key.
	 *
	 * @param registrationId the primary key of the consumer registration
	 * @return the consumer registration
	 * @throws PortalException if a consumer registration with the primary key could not be found
	 */
	public ConsumerRegistration deleteConsumerRegistration(long registrationId)
			throws PortalException {

		ConsumerRegistration consumerRegistration = consumerRegistrationLocalService
				.getConsumerRegistration(registrationId);

		return consumerRegistrationLocalService
				.deleteConsumerRegistration(consumerRegistration);
	}

	/**
	 * Returns the consumer registration with the primary key.
	 *
	 * @param registrationId the primary key of the consumer registration
	 * @return the consumer registration
	 * @throws PortalException if a consumer registration with the primary key could not be found
	 */
	public ConsumerRegistration getConsumerRegistration(long registrationId)
			throws PortalException {

		ConsumerRegistration consumerRegistration = consumerRegistrationLocalService
				.getConsumerRegistration(registrationId);

		return consumerRegistration;
	}

	/**
	 * Returns the consumer registration with the Consumer Id.
	 *
	 * @param consumerId
	 * @return the consumer registration
	 * @throws PortalException
	 */
	public List<ConsumerRegistration> getConsumerRegistrationByConsumerId(
			String consumerId) {
		return consumerRegistrationLocalService
				.getConsumerRegistrationByConsumerId(consumerId);
	}

	/**
	 * Returns all the consumer registrations
	 *
	 * @param consumerId
	 * @return the consumer registration
	 * @throws PortalException
	 */
	public List<ConsumerRegistration> getAllConsumerRegistrations() {
		return consumerRegistrationLocalService.getAllConsumerRegistrations();
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
	public List<ConsumerRegistration> getConsumerRegistrationByKeywords(
			String keywords, int start, int end,
			OrderByComparator<ConsumerRegistration> orderByComparator) {

		return consumerRegistrationLocalService
				.getConsumerRegistrationByKeywords(keywords, start, end,
						orderByComparator);
	}

	/**
	 * Returns the consumer registrations count with keywords.
	 * 
	 * @param keywords
	 * @return long
	 */
	public long getConsumerRegistrationCountByKeywords(String keywords) {
		return consumerRegistrationLocalService
				.getConsumerRegistrationCountByKeywords(keywords);
	}
}