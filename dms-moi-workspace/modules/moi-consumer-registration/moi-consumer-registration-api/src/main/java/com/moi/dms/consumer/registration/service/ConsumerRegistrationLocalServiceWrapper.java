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
 * Provides a wrapper for {@link ConsumerRegistrationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerRegistrationLocalService
 * @generated
 */
public class ConsumerRegistrationLocalServiceWrapper
	implements ConsumerRegistrationLocalService,
			   ServiceWrapper<ConsumerRegistrationLocalService> {

	public ConsumerRegistrationLocalServiceWrapper(
		ConsumerRegistrationLocalService consumerRegistrationLocalService) {

		_consumerRegistrationLocalService = consumerRegistrationLocalService;
	}

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
	@Override
	public com.moi.dms.consumer.registration.model.ConsumerRegistration
		addConsumerRegistration(
			com.moi.dms.consumer.registration.model.ConsumerRegistration
				consumerRegistration) {

		return _consumerRegistrationLocalService.addConsumerRegistration(
			consumerRegistration);
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
	@Override
	public com.moi.dms.consumer.registration.model.ConsumerRegistration
			addConsumerRegistration(
				String consumerName, String consumerId,
				java.util.Map<java.util.Locale, String> descriptionMap,
				String supportedDocumentType, String consumerStatus)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _consumerRegistrationLocalService.addConsumerRegistration(
			consumerName, consumerId, descriptionMap, supportedDocumentType,
			consumerStatus);
	}

	/**
	 * Creates a new consumer registration with the primary key. Does not add the consumer registration to the database.
	 *
	 * @param registrationId the primary key for the new consumer registration
	 * @return the new consumer registration
	 */
	@Override
	public com.moi.dms.consumer.registration.model.ConsumerRegistration
		createConsumerRegistration(long registrationId) {

		return _consumerRegistrationLocalService.createConsumerRegistration(
			registrationId);
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
	@Override
	public com.moi.dms.consumer.registration.model.ConsumerRegistration
		deleteConsumerRegistration(
			com.moi.dms.consumer.registration.model.ConsumerRegistration
				consumerRegistration) {

		return _consumerRegistrationLocalService.deleteConsumerRegistration(
			consumerRegistration);
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
	@Override
	public com.moi.dms.consumer.registration.model.ConsumerRegistration
			deleteConsumerRegistration(long registrationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _consumerRegistrationLocalService.deleteConsumerRegistration(
			registrationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _consumerRegistrationLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _consumerRegistrationLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _consumerRegistrationLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _consumerRegistrationLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _consumerRegistrationLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _consumerRegistrationLocalService.dynamicQueryCount(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _consumerRegistrationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.moi.dms.consumer.registration.model.ConsumerRegistration
		fetchConsumerRegistration(long registrationId) {

		return _consumerRegistrationLocalService.fetchConsumerRegistration(
			registrationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _consumerRegistrationLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List
		<com.moi.dms.consumer.registration.model.ConsumerRegistration>
			getAllConsumerRegistrations() {

		return _consumerRegistrationLocalService.getAllConsumerRegistrations();
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

		return _consumerRegistrationLocalService.getConsumerRegistration(
			registrationId);
	}

	@Override
	public java.util.List
		<com.moi.dms.consumer.registration.model.ConsumerRegistration>
			getConsumerRegistrationByConsumerId(String consumerId) {

		return _consumerRegistrationLocalService.
			getConsumerRegistrationByConsumerId(consumerId);
	}

	@Override
	public java.util.List
		<com.moi.dms.consumer.registration.model.ConsumerRegistration>
			getConsumerRegistrationByConsumerId(
				String consumerId, int start, int end) {

		return _consumerRegistrationLocalService.
			getConsumerRegistrationByConsumerId(consumerId, start, end);
	}

	@Override
	public java.util.List
		<com.moi.dms.consumer.registration.model.ConsumerRegistration>
			getConsumerRegistrationByConsumerId(
				String consumerId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.moi.dms.consumer.registration.model.
						ConsumerRegistration> orderByComparator) {

		return _consumerRegistrationLocalService.
			getConsumerRegistrationByConsumerId(
				consumerId, start, end, orderByComparator);
	}

	@Override
	public java.util.List
		<com.moi.dms.consumer.registration.model.ConsumerRegistration>
			getConsumerRegistrationByKeywords(
				String keywords, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.moi.dms.consumer.registration.model.
						ConsumerRegistration> orderByComparator) {

		return _consumerRegistrationLocalService.
			getConsumerRegistrationByKeywords(
				keywords, start, end, orderByComparator);
	}

	@Override
	public long getConsumerRegistrationCountByKeywords(String keywords) {
		return _consumerRegistrationLocalService.
			getConsumerRegistrationCountByKeywords(keywords);
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
	@Override
	public java.util.List
		<com.moi.dms.consumer.registration.model.ConsumerRegistration>
			getConsumerRegistrations(int start, int end) {

		return _consumerRegistrationLocalService.getConsumerRegistrations(
			start, end);
	}

	/**
	 * Returns the number of consumer registrations.
	 *
	 * @return the number of consumer registrations
	 */
	@Override
	public int getConsumerRegistrationsCount() {
		return _consumerRegistrationLocalService.
			getConsumerRegistrationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _consumerRegistrationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _consumerRegistrationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _consumerRegistrationLocalService.getPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.moi.dms.consumer.registration.model.ConsumerRegistration
		updateConsumerRegistration(
			com.moi.dms.consumer.registration.model.ConsumerRegistration
				consumerRegistration) {

		return _consumerRegistrationLocalService.updateConsumerRegistration(
			consumerRegistration);
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
	@Override
	public com.moi.dms.consumer.registration.model.ConsumerRegistration
			updateConsumerRegistration(
				long consumerRegistrationId, String consumerName,
				String consumerId,
				java.util.Map<java.util.Locale, String> descriptionMap,
				String supportedDocumentType, String consumerStatus)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _consumerRegistrationLocalService.updateConsumerRegistration(
			consumerRegistrationId, consumerName, consumerId, descriptionMap,
			supportedDocumentType, consumerStatus);
	}

	@Override
	public ConsumerRegistrationLocalService getWrappedService() {
		return _consumerRegistrationLocalService;
	}

	@Override
	public void setWrappedService(
		ConsumerRegistrationLocalService consumerRegistrationLocalService) {

		_consumerRegistrationLocalService = consumerRegistrationLocalService;
	}

	private ConsumerRegistrationLocalService _consumerRegistrationLocalService;

}