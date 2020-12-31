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
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.moi.dms.consumer.registration.model.ConsumerRegistration;
import com.moi.dms.consumer.registration.service.base.ConsumerRegistrationLocalServiceBaseImpl;
import com.moi.dms.consumer.registration.validator.ConsumerRegistrationValidator;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the consumer registration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.moi.dms.consumer.registration.service.ConsumerRegistrationLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerRegistrationLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.moi.dms.consumer.registration.model.ConsumerRegistration",
	service = AopService.class
)
public class ConsumerRegistrationLocalServiceImpl
	extends ConsumerRegistrationLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.moi.dms.consumer.registration.service.ConsumerRegistrationLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.moi.dms.consumer.registration.service.ConsumerRegistrationLocalServiceUtil</code>.
	 * 
	 * 
	 */

	/**
	 * Local service to add new consumer registration.
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

		List<ConsumerRegistration> existingConsumerRegistrations = getAllConsumerRegistrations();
		_consumerRegistrationentValidator.validate(0, consumerId, consumerName,
				supportedDocumentType, existingConsumerRegistrations);

		// Generate primary key for the Consumer Registration.
		long consumerRegistrationId = counterLocalService
				.increment(ConsumerRegistration.class.getName());

		// Create Consumer Registration. This doesn't yet persist the entity.
		ConsumerRegistration consumerRegistration = createConsumerRegistration(
				consumerRegistrationId);

		// Populate fields.
		consumerRegistration.setConsumerName(consumerName);
		consumerRegistration.setConsumerId(consumerId);
		consumerRegistration.setConsumerDescriptionMap(descriptionMap);
		consumerRegistration.setSupportedDocumentType(supportedDocumentType);
		consumerRegistration.setConsumerStatus(consumerStatus);

		// Persist Consumer Registration to database.
		ConsumerRegistration consumer = super.addConsumerRegistration(
				consumerRegistration);
		return consumer;
	}

	/**
	 * Local service to update consumer registration.
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
			String consumerStatus) throws PortalException {

		List<ConsumerRegistration> existingConsumerRegistrations = getAllConsumerRegistrations();
		_consumerRegistrationentValidator.validate(consumerRegistrationId,
				consumerId, consumerName, supportedDocumentType,
				existingConsumerRegistrations);

		// Get the Consumer Registration by id.
		ConsumerRegistration consumerRegistration = getConsumerRegistration(
				consumerRegistrationId);

		// Set updated fields and modification date.
		consumerRegistration.setConsumerName(consumerName);
		consumerRegistration.setConsumerId(consumerId);
		consumerRegistration.setConsumerDescriptionMap(descriptionMap);
		consumerRegistration.setSupportedDocumentType(supportedDocumentType);
		consumerRegistration.setConsumerStatus(consumerStatus);

		// Persist Consumer Registration to database.
		return super.updateConsumerRegistration(consumerRegistration);
	}

	/**
	 * Returns the consumer registration with the Consumer Id.
	 *
	 * @param consumerId
	 * @return List<ConsumerRegistration>
	 */
	public List<ConsumerRegistration> getConsumerRegistrationByConsumerId(
			String consumerId) {
		return consumerRegistrationPersistence.findByConsumerId(consumerId);
	}

	/**
	 * Returns the consumer registration with the Consumer Id.
	 *
	 * @param consumerId
	 * @param start
	 * @param end
	 * @return the consumer registration
	 */
	public List<ConsumerRegistration> getConsumerRegistrationByConsumerId(
			String consumerId, int start, int end) {
		return consumerRegistrationPersistence.findByConsumerId(consumerId,
				start, end);
	}

	/**
	 * Returns the consumer registration with the Consumer Id.
	 *
	 * @param consumerId
	 * @param start
	 * @param end
	 * @param orderByComparator
	 * @return List<ConsumerRegistration>
	 */
	public List<ConsumerRegistration> getConsumerRegistrationByConsumerId(
			String consumerId, int start, int end,
			OrderByComparator<ConsumerRegistration> orderByComparator) {
		return consumerRegistrationPersistence.findByConsumerId(consumerId,
				start, end, orderByComparator);
	}

	/**
	 * Returns all the consumer registrations
	 *
	 * @param consumerId
	 * @return List<ConsumerRegistration>
	 */
	public List<ConsumerRegistration> getAllConsumerRegistrations() {
		return consumerRegistrationPersistence.findAll();
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

		return consumerRegistrationLocalService.dynamicQuery(
				getKeywordSearchDynamicQuery(keywords), start, end,
				orderByComparator);
	}

	/**
	 * Returns the consumer registrations with keywords.
	 * 
	 * @param keywords
	 * @return long
	 */
	public long getConsumerRegistrationCountByKeywords(String keywords) {
		return consumerRegistrationLocalService
				.dynamicQueryCount(getKeywordSearchDynamicQuery(keywords));
	}

	/**
	 * Returns the dynamic query to fetch consumer registrations with keywords.
	 * 
	 * @param keywords
	 * @return DynamicQuery
	 */
	private DynamicQuery getKeywordSearchDynamicQuery(String keywords) {

		DynamicQuery dynamicQuery = dynamicQuery();
		if (Validator.isNotNull(keywords)) {
			Disjunction disjunctionQuery = RestrictionsFactoryUtil
					.disjunction();
			disjunctionQuery.add(RestrictionsFactoryUtil
					.like("supportedDocumentType", "%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil.like("consumerName",
					"%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil
					.like("consumerDescription", "%" + keywords + "%"));
			dynamicQuery.add(disjunctionQuery);
		}
		return dynamicQuery;
	}

	/**
	 * This method returns count with respect to ConsumerId/Consumer Code
	 * and Document Type
	 *
	 * @param consumerId
	 * @param documentType
	 * @return : count
	 */
	public long countByConsumerIdDocumentType(String consumerId,
			String documentType) {
		return consumerRegistrationPersistence.countByConsumerIdSupportedDocumentType(
				consumerId, documentType);

	}
	@Override
	public ConsumerRegistration addConsumerRegistration(
			ConsumerRegistration consumerRegistration) {
		throw new UnsupportedOperationException("Not supported.");
	}

	@Override
	public ConsumerRegistration updateConsumerRegistration(
			ConsumerRegistration consumerRegistration) {
		throw new UnsupportedOperationException("Not supported.");
	}

	@Reference
	ConsumerRegistrationValidator _consumerRegistrationentValidator;
}