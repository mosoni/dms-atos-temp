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

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.moi.dms.consumer.registration.model.ConsumerRegistration;

import java.io.Serializable;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for ConsumerRegistration. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerRegistrationLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ConsumerRegistrationLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.moi.dms.consumer.registration.service.impl.ConsumerRegistrationLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the consumer registration local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ConsumerRegistrationLocalServiceUtil} if injection and service tracking are not available.
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
	@Indexable(type = IndexableType.REINDEX)
	public ConsumerRegistration addConsumerRegistration(
		ConsumerRegistration consumerRegistration);

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
	public ConsumerRegistration addConsumerRegistration(
			String consumerName, String consumerId,
			Map<Locale, String> descriptionMap, String supportedDocumentType,
			String consumerStatus)
		throws PortalException;

	/**
	 * This method returns count with respect to ConsumerId/Consumer Code
	 * and Document Type
	 *
	 * @param consumerId
	 * @param documentType
	 * @return : count
	 */
	public long countByConsumerIdDocumentType(
		String consumerId, String documentType);

	/**
	 * Creates a new consumer registration with the primary key. Does not add the consumer registration to the database.
	 *
	 * @param registrationId the primary key for the new consumer registration
	 * @return the new consumer registration
	 */
	@Transactional(enabled = false)
	public ConsumerRegistration createConsumerRegistration(long registrationId);

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
	@Indexable(type = IndexableType.DELETE)
	public ConsumerRegistration deleteConsumerRegistration(
		ConsumerRegistration consumerRegistration);

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
	@Indexable(type = IndexableType.DELETE)
	public ConsumerRegistration deleteConsumerRegistration(long registrationId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ConsumerRegistration fetchConsumerRegistration(long registrationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns all the consumer registrations
	 *
	 * @param consumerId
	 * @return List<ConsumerRegistration>
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ConsumerRegistration> getAllConsumerRegistrations();

	/**
	 * Returns the consumer registration with the primary key.
	 *
	 * @param registrationId the primary key of the consumer registration
	 * @return the consumer registration
	 * @throws PortalException if a consumer registration with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ConsumerRegistration getConsumerRegistration(long registrationId)
		throws PortalException;

	/**
	 * Returns the consumer registration with the Consumer Id.
	 *
	 * @param consumerId
	 * @return List<ConsumerRegistration>
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ConsumerRegistration> getConsumerRegistrationByConsumerId(
		String consumerId);

	/**
	 * Returns the consumer registration with the Consumer Id.
	 *
	 * @param consumerId
	 * @param start
	 * @param end
	 * @return the consumer registration
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ConsumerRegistration> getConsumerRegistrationByConsumerId(
		String consumerId, int start, int end);

	/**
	 * Returns the consumer registration with the Consumer Id.
	 *
	 * @param consumerId
	 * @param start
	 * @param end
	 * @param orderByComparator
	 * @return List<ConsumerRegistration>
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ConsumerRegistration> getConsumerRegistrationByConsumerId(
		String consumerId, int start, int end,
		OrderByComparator<ConsumerRegistration> orderByComparator);

	/**
	 * Returns the consumer registrations with keywords.
	 *
	 * @param keywords
	 * @param start
	 * @param end
	 * @param orderByComparator
	 * @return List<ConsumerRegistration>
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ConsumerRegistration> getConsumerRegistrationByKeywords(
		String keywords, int start, int end,
		OrderByComparator<ConsumerRegistration> orderByComparator);

	/**
	 * Returns the consumer registrations with keywords.
	 *
	 * @param keywords
	 * @return long
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getConsumerRegistrationCountByKeywords(String keywords);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ConsumerRegistration> getConsumerRegistrations(
		int start, int end);

	/**
	 * Returns the number of consumer registrations.
	 *
	 * @return the number of consumer registrations
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getConsumerRegistrationsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	@Indexable(type = IndexableType.REINDEX)
	public ConsumerRegistration updateConsumerRegistration(
		ConsumerRegistration consumerRegistration);

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
			String consumerStatus)
		throws PortalException;

}