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

package com.moi.dms.consumer.registration.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.moi.dms.consumer.registration.model.ConsumerRegistration;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the consumer registration service. This utility wraps <code>com.moi.dms.consumer.registration.service.persistence.impl.ConsumerRegistrationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerRegistrationPersistence
 * @generated
 */
@ProviderType
public class ConsumerRegistrationUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ConsumerRegistration consumerRegistration) {
		getPersistence().clearCache(consumerRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, ConsumerRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ConsumerRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ConsumerRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ConsumerRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ConsumerRegistration> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ConsumerRegistration update(
		ConsumerRegistration consumerRegistration) {

		return getPersistence().update(consumerRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ConsumerRegistration update(
		ConsumerRegistration consumerRegistration,
		ServiceContext serviceContext) {

		return getPersistence().update(consumerRegistration, serviceContext);
	}

	/**
	 * Returns all the consumer registrations where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @return the matching consumer registrations
	 */
	public static List<ConsumerRegistration> findByConsumerId(
		String consumerId) {

		return getPersistence().findByConsumerId(consumerId);
	}

	/**
	 * Returns a range of all the consumer registrations where consumerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param consumerId the consumer ID
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @return the range of matching consumer registrations
	 */
	public static List<ConsumerRegistration> findByConsumerId(
		String consumerId, int start, int end) {

		return getPersistence().findByConsumerId(consumerId, start, end);
	}

	/**
	 * Returns an ordered range of all the consumer registrations where consumerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByConsumerId(String, int, int, OrderByComparator)}
	 * @param consumerId the consumer ID
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching consumer registrations
	 */
	@Deprecated
	public static List<ConsumerRegistration> findByConsumerId(
		String consumerId, int start, int end,
		OrderByComparator<ConsumerRegistration> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByConsumerId(
			consumerId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the consumer registrations where consumerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param consumerId the consumer ID
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching consumer registrations
	 */
	public static List<ConsumerRegistration> findByConsumerId(
		String consumerId, int start, int end,
		OrderByComparator<ConsumerRegistration> orderByComparator) {

		return getPersistence().findByConsumerId(
			consumerId, start, end, orderByComparator);
	}

	/**
	 * Returns the first consumer registration in the ordered set where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer registration
	 * @throws NoSuchConsumerRegistrationException if a matching consumer registration could not be found
	 */
	public static ConsumerRegistration findByConsumerId_First(
			String consumerId,
			OrderByComparator<ConsumerRegistration> orderByComparator)
		throws com.moi.dms.consumer.registration.exception.
			NoSuchConsumerRegistrationException {

		return getPersistence().findByConsumerId_First(
			consumerId, orderByComparator);
	}

	/**
	 * Returns the first consumer registration in the ordered set where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer registration, or <code>null</code> if a matching consumer registration could not be found
	 */
	public static ConsumerRegistration fetchByConsumerId_First(
		String consumerId,
		OrderByComparator<ConsumerRegistration> orderByComparator) {

		return getPersistence().fetchByConsumerId_First(
			consumerId, orderByComparator);
	}

	/**
	 * Returns the last consumer registration in the ordered set where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer registration
	 * @throws NoSuchConsumerRegistrationException if a matching consumer registration could not be found
	 */
	public static ConsumerRegistration findByConsumerId_Last(
			String consumerId,
			OrderByComparator<ConsumerRegistration> orderByComparator)
		throws com.moi.dms.consumer.registration.exception.
			NoSuchConsumerRegistrationException {

		return getPersistence().findByConsumerId_Last(
			consumerId, orderByComparator);
	}

	/**
	 * Returns the last consumer registration in the ordered set where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer registration, or <code>null</code> if a matching consumer registration could not be found
	 */
	public static ConsumerRegistration fetchByConsumerId_Last(
		String consumerId,
		OrderByComparator<ConsumerRegistration> orderByComparator) {

		return getPersistence().fetchByConsumerId_Last(
			consumerId, orderByComparator);
	}

	/**
	 * Returns the consumer registrations before and after the current consumer registration in the ordered set where consumerId = &#63;.
	 *
	 * @param registrationId the primary key of the current consumer registration
	 * @param consumerId the consumer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next consumer registration
	 * @throws NoSuchConsumerRegistrationException if a consumer registration with the primary key could not be found
	 */
	public static ConsumerRegistration[] findByConsumerId_PrevAndNext(
			long registrationId, String consumerId,
			OrderByComparator<ConsumerRegistration> orderByComparator)
		throws com.moi.dms.consumer.registration.exception.
			NoSuchConsumerRegistrationException {

		return getPersistence().findByConsumerId_PrevAndNext(
			registrationId, consumerId, orderByComparator);
	}

	/**
	 * Removes all the consumer registrations where consumerId = &#63; from the database.
	 *
	 * @param consumerId the consumer ID
	 */
	public static void removeByConsumerId(String consumerId) {
		getPersistence().removeByConsumerId(consumerId);
	}

	/**
	 * Returns the number of consumer registrations where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @return the number of matching consumer registrations
	 */
	public static int countByConsumerId(String consumerId) {
		return getPersistence().countByConsumerId(consumerId);
	}

	/**
	 * Returns all the consumer registrations where consumerName = &#63;.
	 *
	 * @param consumerName the consumer name
	 * @return the matching consumer registrations
	 */
	public static List<ConsumerRegistration> findByConsumerName(
		String consumerName) {

		return getPersistence().findByConsumerName(consumerName);
	}

	/**
	 * Returns a range of all the consumer registrations where consumerName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param consumerName the consumer name
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @return the range of matching consumer registrations
	 */
	public static List<ConsumerRegistration> findByConsumerName(
		String consumerName, int start, int end) {

		return getPersistence().findByConsumerName(consumerName, start, end);
	}

	/**
	 * Returns an ordered range of all the consumer registrations where consumerName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByConsumerName(String, int, int, OrderByComparator)}
	 * @param consumerName the consumer name
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching consumer registrations
	 */
	@Deprecated
	public static List<ConsumerRegistration> findByConsumerName(
		String consumerName, int start, int end,
		OrderByComparator<ConsumerRegistration> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByConsumerName(
			consumerName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the consumer registrations where consumerName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param consumerName the consumer name
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching consumer registrations
	 */
	public static List<ConsumerRegistration> findByConsumerName(
		String consumerName, int start, int end,
		OrderByComparator<ConsumerRegistration> orderByComparator) {

		return getPersistence().findByConsumerName(
			consumerName, start, end, orderByComparator);
	}

	/**
	 * Returns the first consumer registration in the ordered set where consumerName = &#63;.
	 *
	 * @param consumerName the consumer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer registration
	 * @throws NoSuchConsumerRegistrationException if a matching consumer registration could not be found
	 */
	public static ConsumerRegistration findByConsumerName_First(
			String consumerName,
			OrderByComparator<ConsumerRegistration> orderByComparator)
		throws com.moi.dms.consumer.registration.exception.
			NoSuchConsumerRegistrationException {

		return getPersistence().findByConsumerName_First(
			consumerName, orderByComparator);
	}

	/**
	 * Returns the first consumer registration in the ordered set where consumerName = &#63;.
	 *
	 * @param consumerName the consumer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer registration, or <code>null</code> if a matching consumer registration could not be found
	 */
	public static ConsumerRegistration fetchByConsumerName_First(
		String consumerName,
		OrderByComparator<ConsumerRegistration> orderByComparator) {

		return getPersistence().fetchByConsumerName_First(
			consumerName, orderByComparator);
	}

	/**
	 * Returns the last consumer registration in the ordered set where consumerName = &#63;.
	 *
	 * @param consumerName the consumer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer registration
	 * @throws NoSuchConsumerRegistrationException if a matching consumer registration could not be found
	 */
	public static ConsumerRegistration findByConsumerName_Last(
			String consumerName,
			OrderByComparator<ConsumerRegistration> orderByComparator)
		throws com.moi.dms.consumer.registration.exception.
			NoSuchConsumerRegistrationException {

		return getPersistence().findByConsumerName_Last(
			consumerName, orderByComparator);
	}

	/**
	 * Returns the last consumer registration in the ordered set where consumerName = &#63;.
	 *
	 * @param consumerName the consumer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer registration, or <code>null</code> if a matching consumer registration could not be found
	 */
	public static ConsumerRegistration fetchByConsumerName_Last(
		String consumerName,
		OrderByComparator<ConsumerRegistration> orderByComparator) {

		return getPersistence().fetchByConsumerName_Last(
			consumerName, orderByComparator);
	}

	/**
	 * Returns the consumer registrations before and after the current consumer registration in the ordered set where consumerName = &#63;.
	 *
	 * @param registrationId the primary key of the current consumer registration
	 * @param consumerName the consumer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next consumer registration
	 * @throws NoSuchConsumerRegistrationException if a consumer registration with the primary key could not be found
	 */
	public static ConsumerRegistration[] findByConsumerName_PrevAndNext(
			long registrationId, String consumerName,
			OrderByComparator<ConsumerRegistration> orderByComparator)
		throws com.moi.dms.consumer.registration.exception.
			NoSuchConsumerRegistrationException {

		return getPersistence().findByConsumerName_PrevAndNext(
			registrationId, consumerName, orderByComparator);
	}

	/**
	 * Removes all the consumer registrations where consumerName = &#63; from the database.
	 *
	 * @param consumerName the consumer name
	 */
	public static void removeByConsumerName(String consumerName) {
		getPersistence().removeByConsumerName(consumerName);
	}

	/**
	 * Returns the number of consumer registrations where consumerName = &#63;.
	 *
	 * @param consumerName the consumer name
	 * @return the number of matching consumer registrations
	 */
	public static int countByConsumerName(String consumerName) {
		return getPersistence().countByConsumerName(consumerName);
	}

	/**
	 * Returns all the consumer registrations where supportedDocumentType = &#63;.
	 *
	 * @param supportedDocumentType the supported document type
	 * @return the matching consumer registrations
	 */
	public static List<ConsumerRegistration> findBySupportedDocumentType(
		String supportedDocumentType) {

		return getPersistence().findBySupportedDocumentType(
			supportedDocumentType);
	}

	/**
	 * Returns a range of all the consumer registrations where supportedDocumentType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param supportedDocumentType the supported document type
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @return the range of matching consumer registrations
	 */
	public static List<ConsumerRegistration> findBySupportedDocumentType(
		String supportedDocumentType, int start, int end) {

		return getPersistence().findBySupportedDocumentType(
			supportedDocumentType, start, end);
	}

	/**
	 * Returns an ordered range of all the consumer registrations where supportedDocumentType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findBySupportedDocumentType(String, int, int, OrderByComparator)}
	 * @param supportedDocumentType the supported document type
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching consumer registrations
	 */
	@Deprecated
	public static List<ConsumerRegistration> findBySupportedDocumentType(
		String supportedDocumentType, int start, int end,
		OrderByComparator<ConsumerRegistration> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySupportedDocumentType(
			supportedDocumentType, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns an ordered range of all the consumer registrations where supportedDocumentType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param supportedDocumentType the supported document type
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching consumer registrations
	 */
	public static List<ConsumerRegistration> findBySupportedDocumentType(
		String supportedDocumentType, int start, int end,
		OrderByComparator<ConsumerRegistration> orderByComparator) {

		return getPersistence().findBySupportedDocumentType(
			supportedDocumentType, start, end, orderByComparator);
	}

	/**
	 * Returns the first consumer registration in the ordered set where supportedDocumentType = &#63;.
	 *
	 * @param supportedDocumentType the supported document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer registration
	 * @throws NoSuchConsumerRegistrationException if a matching consumer registration could not be found
	 */
	public static ConsumerRegistration findBySupportedDocumentType_First(
			String supportedDocumentType,
			OrderByComparator<ConsumerRegistration> orderByComparator)
		throws com.moi.dms.consumer.registration.exception.
			NoSuchConsumerRegistrationException {

		return getPersistence().findBySupportedDocumentType_First(
			supportedDocumentType, orderByComparator);
	}

	/**
	 * Returns the first consumer registration in the ordered set where supportedDocumentType = &#63;.
	 *
	 * @param supportedDocumentType the supported document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer registration, or <code>null</code> if a matching consumer registration could not be found
	 */
	public static ConsumerRegistration fetchBySupportedDocumentType_First(
		String supportedDocumentType,
		OrderByComparator<ConsumerRegistration> orderByComparator) {

		return getPersistence().fetchBySupportedDocumentType_First(
			supportedDocumentType, orderByComparator);
	}

	/**
	 * Returns the last consumer registration in the ordered set where supportedDocumentType = &#63;.
	 *
	 * @param supportedDocumentType the supported document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer registration
	 * @throws NoSuchConsumerRegistrationException if a matching consumer registration could not be found
	 */
	public static ConsumerRegistration findBySupportedDocumentType_Last(
			String supportedDocumentType,
			OrderByComparator<ConsumerRegistration> orderByComparator)
		throws com.moi.dms.consumer.registration.exception.
			NoSuchConsumerRegistrationException {

		return getPersistence().findBySupportedDocumentType_Last(
			supportedDocumentType, orderByComparator);
	}

	/**
	 * Returns the last consumer registration in the ordered set where supportedDocumentType = &#63;.
	 *
	 * @param supportedDocumentType the supported document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer registration, or <code>null</code> if a matching consumer registration could not be found
	 */
	public static ConsumerRegistration fetchBySupportedDocumentType_Last(
		String supportedDocumentType,
		OrderByComparator<ConsumerRegistration> orderByComparator) {

		return getPersistence().fetchBySupportedDocumentType_Last(
			supportedDocumentType, orderByComparator);
	}

	/**
	 * Returns the consumer registrations before and after the current consumer registration in the ordered set where supportedDocumentType = &#63;.
	 *
	 * @param registrationId the primary key of the current consumer registration
	 * @param supportedDocumentType the supported document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next consumer registration
	 * @throws NoSuchConsumerRegistrationException if a consumer registration with the primary key could not be found
	 */
	public static ConsumerRegistration[]
			findBySupportedDocumentType_PrevAndNext(
				long registrationId, String supportedDocumentType,
				OrderByComparator<ConsumerRegistration> orderByComparator)
		throws com.moi.dms.consumer.registration.exception.
			NoSuchConsumerRegistrationException {

		return getPersistence().findBySupportedDocumentType_PrevAndNext(
			registrationId, supportedDocumentType, orderByComparator);
	}

	/**
	 * Removes all the consumer registrations where supportedDocumentType = &#63; from the database.
	 *
	 * @param supportedDocumentType the supported document type
	 */
	public static void removeBySupportedDocumentType(
		String supportedDocumentType) {

		getPersistence().removeBySupportedDocumentType(supportedDocumentType);
	}

	/**
	 * Returns the number of consumer registrations where supportedDocumentType = &#63;.
	 *
	 * @param supportedDocumentType the supported document type
	 * @return the number of matching consumer registrations
	 */
	public static int countBySupportedDocumentType(
		String supportedDocumentType) {

		return getPersistence().countBySupportedDocumentType(
			supportedDocumentType);
	}

	/**
	 * Returns all the consumer registrations where consumerStatus = &#63;.
	 *
	 * @param consumerStatus the consumer status
	 * @return the matching consumer registrations
	 */
	public static List<ConsumerRegistration> findByConsumerStatus(
		String consumerStatus) {

		return getPersistence().findByConsumerStatus(consumerStatus);
	}

	/**
	 * Returns a range of all the consumer registrations where consumerStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param consumerStatus the consumer status
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @return the range of matching consumer registrations
	 */
	public static List<ConsumerRegistration> findByConsumerStatus(
		String consumerStatus, int start, int end) {

		return getPersistence().findByConsumerStatus(
			consumerStatus, start, end);
	}

	/**
	 * Returns an ordered range of all the consumer registrations where consumerStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByConsumerStatus(String, int, int, OrderByComparator)}
	 * @param consumerStatus the consumer status
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching consumer registrations
	 */
	@Deprecated
	public static List<ConsumerRegistration> findByConsumerStatus(
		String consumerStatus, int start, int end,
		OrderByComparator<ConsumerRegistration> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByConsumerStatus(
			consumerStatus, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the consumer registrations where consumerStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param consumerStatus the consumer status
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching consumer registrations
	 */
	public static List<ConsumerRegistration> findByConsumerStatus(
		String consumerStatus, int start, int end,
		OrderByComparator<ConsumerRegistration> orderByComparator) {

		return getPersistence().findByConsumerStatus(
			consumerStatus, start, end, orderByComparator);
	}

	/**
	 * Returns the first consumer registration in the ordered set where consumerStatus = &#63;.
	 *
	 * @param consumerStatus the consumer status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer registration
	 * @throws NoSuchConsumerRegistrationException if a matching consumer registration could not be found
	 */
	public static ConsumerRegistration findByConsumerStatus_First(
			String consumerStatus,
			OrderByComparator<ConsumerRegistration> orderByComparator)
		throws com.moi.dms.consumer.registration.exception.
			NoSuchConsumerRegistrationException {

		return getPersistence().findByConsumerStatus_First(
			consumerStatus, orderByComparator);
	}

	/**
	 * Returns the first consumer registration in the ordered set where consumerStatus = &#63;.
	 *
	 * @param consumerStatus the consumer status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer registration, or <code>null</code> if a matching consumer registration could not be found
	 */
	public static ConsumerRegistration fetchByConsumerStatus_First(
		String consumerStatus,
		OrderByComparator<ConsumerRegistration> orderByComparator) {

		return getPersistence().fetchByConsumerStatus_First(
			consumerStatus, orderByComparator);
	}

	/**
	 * Returns the last consumer registration in the ordered set where consumerStatus = &#63;.
	 *
	 * @param consumerStatus the consumer status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer registration
	 * @throws NoSuchConsumerRegistrationException if a matching consumer registration could not be found
	 */
	public static ConsumerRegistration findByConsumerStatus_Last(
			String consumerStatus,
			OrderByComparator<ConsumerRegistration> orderByComparator)
		throws com.moi.dms.consumer.registration.exception.
			NoSuchConsumerRegistrationException {

		return getPersistence().findByConsumerStatus_Last(
			consumerStatus, orderByComparator);
	}

	/**
	 * Returns the last consumer registration in the ordered set where consumerStatus = &#63;.
	 *
	 * @param consumerStatus the consumer status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer registration, or <code>null</code> if a matching consumer registration could not be found
	 */
	public static ConsumerRegistration fetchByConsumerStatus_Last(
		String consumerStatus,
		OrderByComparator<ConsumerRegistration> orderByComparator) {

		return getPersistence().fetchByConsumerStatus_Last(
			consumerStatus, orderByComparator);
	}

	/**
	 * Returns the consumer registrations before and after the current consumer registration in the ordered set where consumerStatus = &#63;.
	 *
	 * @param registrationId the primary key of the current consumer registration
	 * @param consumerStatus the consumer status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next consumer registration
	 * @throws NoSuchConsumerRegistrationException if a consumer registration with the primary key could not be found
	 */
	public static ConsumerRegistration[] findByConsumerStatus_PrevAndNext(
			long registrationId, String consumerStatus,
			OrderByComparator<ConsumerRegistration> orderByComparator)
		throws com.moi.dms.consumer.registration.exception.
			NoSuchConsumerRegistrationException {

		return getPersistence().findByConsumerStatus_PrevAndNext(
			registrationId, consumerStatus, orderByComparator);
	}

	/**
	 * Removes all the consumer registrations where consumerStatus = &#63; from the database.
	 *
	 * @param consumerStatus the consumer status
	 */
	public static void removeByConsumerStatus(String consumerStatus) {
		getPersistence().removeByConsumerStatus(consumerStatus);
	}

	/**
	 * Returns the number of consumer registrations where consumerStatus = &#63;.
	 *
	 * @param consumerStatus the consumer status
	 * @return the number of matching consumer registrations
	 */
	public static int countByConsumerStatus(String consumerStatus) {
		return getPersistence().countByConsumerStatus(consumerStatus);
	}

	/**
	 * Caches the consumer registration in the entity cache if it is enabled.
	 *
	 * @param consumerRegistration the consumer registration
	 */
	public static void cacheResult(ConsumerRegistration consumerRegistration) {
		getPersistence().cacheResult(consumerRegistration);
	}

	/**
	 * Caches the consumer registrations in the entity cache if it is enabled.
	 *
	 * @param consumerRegistrations the consumer registrations
	 */
	public static void cacheResult(
		List<ConsumerRegistration> consumerRegistrations) {

		getPersistence().cacheResult(consumerRegistrations);
	}

	/**
	 * Creates a new consumer registration with the primary key. Does not add the consumer registration to the database.
	 *
	 * @param registrationId the primary key for the new consumer registration
	 * @return the new consumer registration
	 */
	public static ConsumerRegistration create(long registrationId) {
		return getPersistence().create(registrationId);
	}

	/**
	 * Removes the consumer registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param registrationId the primary key of the consumer registration
	 * @return the consumer registration that was removed
	 * @throws NoSuchConsumerRegistrationException if a consumer registration with the primary key could not be found
	 */
	public static ConsumerRegistration remove(long registrationId)
		throws com.moi.dms.consumer.registration.exception.
			NoSuchConsumerRegistrationException {

		return getPersistence().remove(registrationId);
	}

	public static ConsumerRegistration updateImpl(
		ConsumerRegistration consumerRegistration) {

		return getPersistence().updateImpl(consumerRegistration);
	}

	/**
	 * Returns the consumer registration with the primary key or throws a <code>NoSuchConsumerRegistrationException</code> if it could not be found.
	 *
	 * @param registrationId the primary key of the consumer registration
	 * @return the consumer registration
	 * @throws NoSuchConsumerRegistrationException if a consumer registration with the primary key could not be found
	 */
	public static ConsumerRegistration findByPrimaryKey(long registrationId)
		throws com.moi.dms.consumer.registration.exception.
			NoSuchConsumerRegistrationException {

		return getPersistence().findByPrimaryKey(registrationId);
	}

	/**
	 * Returns the consumer registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param registrationId the primary key of the consumer registration
	 * @return the consumer registration, or <code>null</code> if a consumer registration with the primary key could not be found
	 */
	public static ConsumerRegistration fetchByPrimaryKey(long registrationId) {
		return getPersistence().fetchByPrimaryKey(registrationId);
	}

	/**
	 * Returns all the consumer registrations.
	 *
	 * @return the consumer registrations
	 */
	public static List<ConsumerRegistration> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the consumer registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @return the range of consumer registrations
	 */
	public static List<ConsumerRegistration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the consumer registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of consumer registrations
	 */
	@Deprecated
	public static List<ConsumerRegistration> findAll(
		int start, int end,
		OrderByComparator<ConsumerRegistration> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the consumer registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of consumer registrations
	 */
	public static List<ConsumerRegistration> findAll(
		int start, int end,
		OrderByComparator<ConsumerRegistration> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the consumer registrations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of consumer registrations.
	 *
	 * @return the number of consumer registrations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ConsumerRegistrationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ConsumerRegistrationPersistence, ConsumerRegistrationPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ConsumerRegistrationPersistence.class);

		ServiceTracker
			<ConsumerRegistrationPersistence, ConsumerRegistrationPersistence>
				serviceTracker =
					new ServiceTracker
						<ConsumerRegistrationPersistence,
						 ConsumerRegistrationPersistence>(
							 bundle.getBundleContext(),
							 ConsumerRegistrationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}