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

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for ConsumerRegistration. This utility wraps
 * <code>com.moi.dms.consumer.registration.service.impl.ConsumerRegistrationServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerRegistrationService
 * @generated
 */
@ProviderType
public class ConsumerRegistrationServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.moi.dms.consumer.registration.service.impl.ConsumerRegistrationServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.moi.dms.consumer.registration.model.ConsumerRegistration
			addConsumerRegistration(
				String consumerName, String consumerId,
				java.util.Map<java.util.Locale, String> descriptionMap,
				String supportedDocumentType, String consumerStatus,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addConsumerRegistration(
			consumerName, consumerId, descriptionMap, supportedDocumentType,
			consumerStatus, serviceContext);
	}

	public static com.moi.dms.consumer.registration.model.ConsumerRegistration
			deleteConsumerRegistration(long registrationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteConsumerRegistration(registrationId);
	}

	public static java.util.List
		<com.moi.dms.consumer.registration.model.ConsumerRegistration>
			getAllConsumerRegistrations() {

		return getService().getAllConsumerRegistrations();
	}

	public static com.moi.dms.consumer.registration.model.ConsumerRegistration
			getConsumerRegistration(long registrationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getConsumerRegistration(registrationId);
	}

	public static java.util.List
		<com.moi.dms.consumer.registration.model.ConsumerRegistration>
			getConsumerRegistrationByConsumerId(String consumerId) {

		return getService().getConsumerRegistrationByConsumerId(consumerId);
	}

	public static java.util.List
		<com.moi.dms.consumer.registration.model.ConsumerRegistration>
			getConsumerRegistrationByKeywords(
				String keywords, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.moi.dms.consumer.registration.model.
						ConsumerRegistration> orderByComparator) {

		return getService().getConsumerRegistrationByKeywords(
			keywords, start, end, orderByComparator);
	}

	public static long getConsumerRegistrationCountByKeywords(String keywords) {
		return getService().getConsumerRegistrationCountByKeywords(keywords);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.moi.dms.consumer.registration.model.ConsumerRegistration
			updateConsumerRegistration(
				long consumerRegistrationId, String consumerName,
				String consumerId,
				java.util.Map<java.util.Locale, String> descriptionMap,
				String supportedDocumentType, String consumerStatus,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateConsumerRegistration(
			consumerRegistrationId, consumerName, consumerId, descriptionMap,
			supportedDocumentType, consumerStatus, serviceContext);
	}

	public static ConsumerRegistrationService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ConsumerRegistrationService, ConsumerRegistrationService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ConsumerRegistrationService.class);

		ServiceTracker<ConsumerRegistrationService, ConsumerRegistrationService>
			serviceTracker =
				new ServiceTracker
					<ConsumerRegistrationService, ConsumerRegistrationService>(
						bundle.getBundleContext(),
						ConsumerRegistrationService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}