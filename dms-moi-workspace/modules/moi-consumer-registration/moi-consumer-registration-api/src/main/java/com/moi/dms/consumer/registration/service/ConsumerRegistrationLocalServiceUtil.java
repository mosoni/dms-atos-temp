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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for ConsumerRegistration. This utility wraps
 * <code>com.moi.dms.consumer.registration.service.impl.ConsumerRegistrationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerRegistrationLocalService
 * @generated
 */
public class ConsumerRegistrationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.moi.dms.consumer.registration.service.impl.ConsumerRegistrationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the consumer registration to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConsumerRegistrationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param consumerRegistration the consumer registration
	 * @return the consumer registration that was added
	 */
	public static com.moi.dms.consumer.registration.model.ConsumerRegistration
		addConsumerRegistration(
			com.moi.dms.consumer.registration.model.ConsumerRegistration
				consumerRegistration) {

		return getService().addConsumerRegistration(consumerRegistration);
	}

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
	public static com.moi.dms.consumer.registration.model.ConsumerRegistration
			addConsumerRegistration(
				String consumerName, String consumerId,
				java.util.Map<java.util.Locale, String> descriptionMap,
				String supportedDocumentType, String consumerStatus)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addConsumerRegistration(
			consumerName, consumerId, descriptionMap, supportedDocumentType,
			consumerStatus);
	}

	/**
	 * Creates a new consumer registration with the primary key. Does not add the consumer registration to the database.
	 *
	 * @param registrationId the primary key for the new consumer registration
	 * @return the new consumer registration
	 */
	public static com.moi.dms.consumer.registration.model.ConsumerRegistration
		createConsumerRegistration(long registrationId) {

		return getService().createConsumerRegistration(registrationId);
	}

	/**
	 * Deletes the consumer registration from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConsumerRegistrationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param consumerRegistration the consumer registration
	 * @return the consumer registration that was removed
	 */
	public static com.moi.dms.consumer.registration.model.ConsumerRegistration
		deleteConsumerRegistration(
			com.moi.dms.consumer.registration.model.ConsumerRegistration
				consumerRegistration) {

		return getService().deleteConsumerRegistration(consumerRegistration);
	}

	/**
	 * Deletes the consumer registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConsumerRegistrationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param registrationId the primary key of the consumer registration
	 * @return the consumer registration that was removed
	 * @throws PortalException if a consumer registration with the primary key could not be found
	 */
	public static com.moi.dms.consumer.registration.model.ConsumerRegistration
			deleteConsumerRegistration(long registrationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteConsumerRegistration(registrationId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.moi.dms.consumer.registration.model.impl.ConsumerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.moi.dms.consumer.registration.model.impl.ConsumerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.moi.dms.consumer.registration.model.ConsumerRegistration
		fetchConsumerRegistration(long registrationId) {

		return getService().fetchConsumerRegistration(registrationId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List
		<com.moi.dms.consumer.registration.model.ConsumerRegistration>
			getAllConsumerRegistrations() {

		return getService().getAllConsumerRegistrations();
	}

	/**
	 * Returns the consumer registration with the primary key.
	 *
	 * @param registrationId the primary key of the consumer registration
	 * @return the consumer registration
	 * @throws PortalException if a consumer registration with the primary key could not be found
	 */
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
			getConsumerRegistrationByConsumerId(
				String consumerId, int start, int end) {

		return getService().getConsumerRegistrationByConsumerId(
			consumerId, start, end);
	}

	public static java.util.List
		<com.moi.dms.consumer.registration.model.ConsumerRegistration>
			getConsumerRegistrationByConsumerId(
				String consumerId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.moi.dms.consumer.registration.model.
						ConsumerRegistration> orderByComparator) {

		return getService().getConsumerRegistrationByConsumerId(
			consumerId, start, end, orderByComparator);
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
	 * Returns a range of all the consumer registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.moi.dms.consumer.registration.model.impl.ConsumerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @return the range of consumer registrations
	 */
	public static java.util.List
		<com.moi.dms.consumer.registration.model.ConsumerRegistration>
			getConsumerRegistrations(int start, int end) {

		return getService().getConsumerRegistrations(start, end);
	}

	/**
	 * Returns the number of consumer registrations.
	 *
	 * @return the number of consumer registrations
	 */
	public static int getConsumerRegistrationsCount() {
		return getService().getConsumerRegistrationsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the consumer registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConsumerRegistrationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param consumerRegistration the consumer registration
	 * @return the consumer registration that was updated
	 */
	public static com.moi.dms.consumer.registration.model.ConsumerRegistration
		updateConsumerRegistration(
			com.moi.dms.consumer.registration.model.ConsumerRegistration
				consumerRegistration) {

		return getService().updateConsumerRegistration(consumerRegistration);
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
	public static com.moi.dms.consumer.registration.model.ConsumerRegistration
			updateConsumerRegistration(
				long consumerRegistrationId, String consumerName,
				String consumerId,
				java.util.Map<java.util.Locale, String> descriptionMap,
				String supportedDocumentType, String consumerStatus)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateConsumerRegistration(
			consumerRegistrationId, consumerName, consumerId, descriptionMap,
			supportedDocumentType, consumerStatus);
	}

	public static ConsumerRegistrationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ConsumerRegistrationLocalService, ConsumerRegistrationLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ConsumerRegistrationLocalService.class);

		ServiceTracker
			<ConsumerRegistrationLocalService, ConsumerRegistrationLocalService>
				serviceTracker =
					new ServiceTracker
						<ConsumerRegistrationLocalService,
						 ConsumerRegistrationLocalService>(
							 bundle.getBundleContext(),
							 ConsumerRegistrationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}