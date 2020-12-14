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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.moi.dms.consumer.registration.exception.NoSuchConsumerRegistrationException;
import com.moi.dms.consumer.registration.model.ConsumerRegistration;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the consumer registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerRegistrationUtil
 * @generated
 */
@ProviderType
public interface ConsumerRegistrationPersistence
	extends BasePersistence<ConsumerRegistration> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ConsumerRegistrationUtil} to access the consumer registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the consumer registrations where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @return the matching consumer registrations
	 */
	public java.util.List<ConsumerRegistration> findByConsumerId(
		String consumerId);

	/**
	 * Returns a range of all the consumer registrations where consumerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param consumerId the consumer ID
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @return the range of matching consumer registrations
	 */
	public java.util.List<ConsumerRegistration> findByConsumerId(
		String consumerId, int start, int end);

	/**
	 * Returns an ordered range of all the consumer registrations where consumerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param consumerId the consumer ID
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching consumer registrations
	 */
	public java.util.List<ConsumerRegistration> findByConsumerId(
		String consumerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConsumerRegistration>
			orderByComparator);

	/**
	 * Returns an ordered range of all the consumer registrations where consumerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param consumerId the consumer ID
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching consumer registrations
	 */
	public java.util.List<ConsumerRegistration> findByConsumerId(
		String consumerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConsumerRegistration>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first consumer registration in the ordered set where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer registration
	 * @throws NoSuchConsumerRegistrationException if a matching consumer registration could not be found
	 */
	public ConsumerRegistration findByConsumerId_First(
			String consumerId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConsumerRegistration> orderByComparator)
		throws NoSuchConsumerRegistrationException;

	/**
	 * Returns the first consumer registration in the ordered set where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer registration, or <code>null</code> if a matching consumer registration could not be found
	 */
	public ConsumerRegistration fetchByConsumerId_First(
		String consumerId,
		com.liferay.portal.kernel.util.OrderByComparator<ConsumerRegistration>
			orderByComparator);

	/**
	 * Returns the last consumer registration in the ordered set where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer registration
	 * @throws NoSuchConsumerRegistrationException if a matching consumer registration could not be found
	 */
	public ConsumerRegistration findByConsumerId_Last(
			String consumerId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConsumerRegistration> orderByComparator)
		throws NoSuchConsumerRegistrationException;

	/**
	 * Returns the last consumer registration in the ordered set where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer registration, or <code>null</code> if a matching consumer registration could not be found
	 */
	public ConsumerRegistration fetchByConsumerId_Last(
		String consumerId,
		com.liferay.portal.kernel.util.OrderByComparator<ConsumerRegistration>
			orderByComparator);

	/**
	 * Returns the consumer registrations before and after the current consumer registration in the ordered set where consumerId = &#63;.
	 *
	 * @param registrationId the primary key of the current consumer registration
	 * @param consumerId the consumer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next consumer registration
	 * @throws NoSuchConsumerRegistrationException if a consumer registration with the primary key could not be found
	 */
	public ConsumerRegistration[] findByConsumerId_PrevAndNext(
			long registrationId, String consumerId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConsumerRegistration> orderByComparator)
		throws NoSuchConsumerRegistrationException;

	/**
	 * Removes all the consumer registrations where consumerId = &#63; from the database.
	 *
	 * @param consumerId the consumer ID
	 */
	public void removeByConsumerId(String consumerId);

	/**
	 * Returns the number of consumer registrations where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @return the number of matching consumer registrations
	 */
	public int countByConsumerId(String consumerId);

	/**
	 * Returns all the consumer registrations where consumerName = &#63;.
	 *
	 * @param consumerName the consumer name
	 * @return the matching consumer registrations
	 */
	public java.util.List<ConsumerRegistration> findByConsumerName(
		String consumerName);

	/**
	 * Returns a range of all the consumer registrations where consumerName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param consumerName the consumer name
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @return the range of matching consumer registrations
	 */
	public java.util.List<ConsumerRegistration> findByConsumerName(
		String consumerName, int start, int end);

	/**
	 * Returns an ordered range of all the consumer registrations where consumerName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param consumerName the consumer name
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching consumer registrations
	 */
	public java.util.List<ConsumerRegistration> findByConsumerName(
		String consumerName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConsumerRegistration>
			orderByComparator);

	/**
	 * Returns an ordered range of all the consumer registrations where consumerName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param consumerName the consumer name
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching consumer registrations
	 */
	public java.util.List<ConsumerRegistration> findByConsumerName(
		String consumerName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConsumerRegistration>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first consumer registration in the ordered set where consumerName = &#63;.
	 *
	 * @param consumerName the consumer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer registration
	 * @throws NoSuchConsumerRegistrationException if a matching consumer registration could not be found
	 */
	public ConsumerRegistration findByConsumerName_First(
			String consumerName,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConsumerRegistration> orderByComparator)
		throws NoSuchConsumerRegistrationException;

	/**
	 * Returns the first consumer registration in the ordered set where consumerName = &#63;.
	 *
	 * @param consumerName the consumer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer registration, or <code>null</code> if a matching consumer registration could not be found
	 */
	public ConsumerRegistration fetchByConsumerName_First(
		String consumerName,
		com.liferay.portal.kernel.util.OrderByComparator<ConsumerRegistration>
			orderByComparator);

	/**
	 * Returns the last consumer registration in the ordered set where consumerName = &#63;.
	 *
	 * @param consumerName the consumer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer registration
	 * @throws NoSuchConsumerRegistrationException if a matching consumer registration could not be found
	 */
	public ConsumerRegistration findByConsumerName_Last(
			String consumerName,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConsumerRegistration> orderByComparator)
		throws NoSuchConsumerRegistrationException;

	/**
	 * Returns the last consumer registration in the ordered set where consumerName = &#63;.
	 *
	 * @param consumerName the consumer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer registration, or <code>null</code> if a matching consumer registration could not be found
	 */
	public ConsumerRegistration fetchByConsumerName_Last(
		String consumerName,
		com.liferay.portal.kernel.util.OrderByComparator<ConsumerRegistration>
			orderByComparator);

	/**
	 * Returns the consumer registrations before and after the current consumer registration in the ordered set where consumerName = &#63;.
	 *
	 * @param registrationId the primary key of the current consumer registration
	 * @param consumerName the consumer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next consumer registration
	 * @throws NoSuchConsumerRegistrationException if a consumer registration with the primary key could not be found
	 */
	public ConsumerRegistration[] findByConsumerName_PrevAndNext(
			long registrationId, String consumerName,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConsumerRegistration> orderByComparator)
		throws NoSuchConsumerRegistrationException;

	/**
	 * Removes all the consumer registrations where consumerName = &#63; from the database.
	 *
	 * @param consumerName the consumer name
	 */
	public void removeByConsumerName(String consumerName);

	/**
	 * Returns the number of consumer registrations where consumerName = &#63;.
	 *
	 * @param consumerName the consumer name
	 * @return the number of matching consumer registrations
	 */
	public int countByConsumerName(String consumerName);

	/**
	 * Returns all the consumer registrations where supportedDocumentType = &#63;.
	 *
	 * @param supportedDocumentType the supported document type
	 * @return the matching consumer registrations
	 */
	public java.util.List<ConsumerRegistration> findBySupportedDocumentType(
		String supportedDocumentType);

	/**
	 * Returns a range of all the consumer registrations where supportedDocumentType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param supportedDocumentType the supported document type
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @return the range of matching consumer registrations
	 */
	public java.util.List<ConsumerRegistration> findBySupportedDocumentType(
		String supportedDocumentType, int start, int end);

	/**
	 * Returns an ordered range of all the consumer registrations where supportedDocumentType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param supportedDocumentType the supported document type
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching consumer registrations
	 */
	public java.util.List<ConsumerRegistration> findBySupportedDocumentType(
		String supportedDocumentType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConsumerRegistration>
			orderByComparator);

	/**
	 * Returns an ordered range of all the consumer registrations where supportedDocumentType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param supportedDocumentType the supported document type
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching consumer registrations
	 */
	public java.util.List<ConsumerRegistration> findBySupportedDocumentType(
		String supportedDocumentType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConsumerRegistration>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first consumer registration in the ordered set where supportedDocumentType = &#63;.
	 *
	 * @param supportedDocumentType the supported document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer registration
	 * @throws NoSuchConsumerRegistrationException if a matching consumer registration could not be found
	 */
	public ConsumerRegistration findBySupportedDocumentType_First(
			String supportedDocumentType,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConsumerRegistration> orderByComparator)
		throws NoSuchConsumerRegistrationException;

	/**
	 * Returns the first consumer registration in the ordered set where supportedDocumentType = &#63;.
	 *
	 * @param supportedDocumentType the supported document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer registration, or <code>null</code> if a matching consumer registration could not be found
	 */
	public ConsumerRegistration fetchBySupportedDocumentType_First(
		String supportedDocumentType,
		com.liferay.portal.kernel.util.OrderByComparator<ConsumerRegistration>
			orderByComparator);

	/**
	 * Returns the last consumer registration in the ordered set where supportedDocumentType = &#63;.
	 *
	 * @param supportedDocumentType the supported document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer registration
	 * @throws NoSuchConsumerRegistrationException if a matching consumer registration could not be found
	 */
	public ConsumerRegistration findBySupportedDocumentType_Last(
			String supportedDocumentType,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConsumerRegistration> orderByComparator)
		throws NoSuchConsumerRegistrationException;

	/**
	 * Returns the last consumer registration in the ordered set where supportedDocumentType = &#63;.
	 *
	 * @param supportedDocumentType the supported document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer registration, or <code>null</code> if a matching consumer registration could not be found
	 */
	public ConsumerRegistration fetchBySupportedDocumentType_Last(
		String supportedDocumentType,
		com.liferay.portal.kernel.util.OrderByComparator<ConsumerRegistration>
			orderByComparator);

	/**
	 * Returns the consumer registrations before and after the current consumer registration in the ordered set where supportedDocumentType = &#63;.
	 *
	 * @param registrationId the primary key of the current consumer registration
	 * @param supportedDocumentType the supported document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next consumer registration
	 * @throws NoSuchConsumerRegistrationException if a consumer registration with the primary key could not be found
	 */
	public ConsumerRegistration[] findBySupportedDocumentType_PrevAndNext(
			long registrationId, String supportedDocumentType,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConsumerRegistration> orderByComparator)
		throws NoSuchConsumerRegistrationException;

	/**
	 * Removes all the consumer registrations where supportedDocumentType = &#63; from the database.
	 *
	 * @param supportedDocumentType the supported document type
	 */
	public void removeBySupportedDocumentType(String supportedDocumentType);

	/**
	 * Returns the number of consumer registrations where supportedDocumentType = &#63;.
	 *
	 * @param supportedDocumentType the supported document type
	 * @return the number of matching consumer registrations
	 */
	public int countBySupportedDocumentType(String supportedDocumentType);

	/**
	 * Returns all the consumer registrations where consumerStatus = &#63;.
	 *
	 * @param consumerStatus the consumer status
	 * @return the matching consumer registrations
	 */
	public java.util.List<ConsumerRegistration> findByConsumerStatus(
		String consumerStatus);

	/**
	 * Returns a range of all the consumer registrations where consumerStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param consumerStatus the consumer status
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @return the range of matching consumer registrations
	 */
	public java.util.List<ConsumerRegistration> findByConsumerStatus(
		String consumerStatus, int start, int end);

	/**
	 * Returns an ordered range of all the consumer registrations where consumerStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param consumerStatus the consumer status
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching consumer registrations
	 */
	public java.util.List<ConsumerRegistration> findByConsumerStatus(
		String consumerStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConsumerRegistration>
			orderByComparator);

	/**
	 * Returns an ordered range of all the consumer registrations where consumerStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param consumerStatus the consumer status
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching consumer registrations
	 */
	public java.util.List<ConsumerRegistration> findByConsumerStatus(
		String consumerStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConsumerRegistration>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first consumer registration in the ordered set where consumerStatus = &#63;.
	 *
	 * @param consumerStatus the consumer status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer registration
	 * @throws NoSuchConsumerRegistrationException if a matching consumer registration could not be found
	 */
	public ConsumerRegistration findByConsumerStatus_First(
			String consumerStatus,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConsumerRegistration> orderByComparator)
		throws NoSuchConsumerRegistrationException;

	/**
	 * Returns the first consumer registration in the ordered set where consumerStatus = &#63;.
	 *
	 * @param consumerStatus the consumer status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer registration, or <code>null</code> if a matching consumer registration could not be found
	 */
	public ConsumerRegistration fetchByConsumerStatus_First(
		String consumerStatus,
		com.liferay.portal.kernel.util.OrderByComparator<ConsumerRegistration>
			orderByComparator);

	/**
	 * Returns the last consumer registration in the ordered set where consumerStatus = &#63;.
	 *
	 * @param consumerStatus the consumer status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer registration
	 * @throws NoSuchConsumerRegistrationException if a matching consumer registration could not be found
	 */
	public ConsumerRegistration findByConsumerStatus_Last(
			String consumerStatus,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConsumerRegistration> orderByComparator)
		throws NoSuchConsumerRegistrationException;

	/**
	 * Returns the last consumer registration in the ordered set where consumerStatus = &#63;.
	 *
	 * @param consumerStatus the consumer status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer registration, or <code>null</code> if a matching consumer registration could not be found
	 */
	public ConsumerRegistration fetchByConsumerStatus_Last(
		String consumerStatus,
		com.liferay.portal.kernel.util.OrderByComparator<ConsumerRegistration>
			orderByComparator);

	/**
	 * Returns the consumer registrations before and after the current consumer registration in the ordered set where consumerStatus = &#63;.
	 *
	 * @param registrationId the primary key of the current consumer registration
	 * @param consumerStatus the consumer status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next consumer registration
	 * @throws NoSuchConsumerRegistrationException if a consumer registration with the primary key could not be found
	 */
	public ConsumerRegistration[] findByConsumerStatus_PrevAndNext(
			long registrationId, String consumerStatus,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConsumerRegistration> orderByComparator)
		throws NoSuchConsumerRegistrationException;

	/**
	 * Removes all the consumer registrations where consumerStatus = &#63; from the database.
	 *
	 * @param consumerStatus the consumer status
	 */
	public void removeByConsumerStatus(String consumerStatus);

	/**
	 * Returns the number of consumer registrations where consumerStatus = &#63;.
	 *
	 * @param consumerStatus the consumer status
	 * @return the number of matching consumer registrations
	 */
	public int countByConsumerStatus(String consumerStatus);

	/**
	 * Caches the consumer registration in the entity cache if it is enabled.
	 *
	 * @param consumerRegistration the consumer registration
	 */
	public void cacheResult(ConsumerRegistration consumerRegistration);

	/**
	 * Caches the consumer registrations in the entity cache if it is enabled.
	 *
	 * @param consumerRegistrations the consumer registrations
	 */
	public void cacheResult(
		java.util.List<ConsumerRegistration> consumerRegistrations);

	/**
	 * Creates a new consumer registration with the primary key. Does not add the consumer registration to the database.
	 *
	 * @param registrationId the primary key for the new consumer registration
	 * @return the new consumer registration
	 */
	public ConsumerRegistration create(long registrationId);

	/**
	 * Removes the consumer registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param registrationId the primary key of the consumer registration
	 * @return the consumer registration that was removed
	 * @throws NoSuchConsumerRegistrationException if a consumer registration with the primary key could not be found
	 */
	public ConsumerRegistration remove(long registrationId)
		throws NoSuchConsumerRegistrationException;

	public ConsumerRegistration updateImpl(
		ConsumerRegistration consumerRegistration);

	/**
	 * Returns the consumer registration with the primary key or throws a <code>NoSuchConsumerRegistrationException</code> if it could not be found.
	 *
	 * @param registrationId the primary key of the consumer registration
	 * @return the consumer registration
	 * @throws NoSuchConsumerRegistrationException if a consumer registration with the primary key could not be found
	 */
	public ConsumerRegistration findByPrimaryKey(long registrationId)
		throws NoSuchConsumerRegistrationException;

	/**
	 * Returns the consumer registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param registrationId the primary key of the consumer registration
	 * @return the consumer registration, or <code>null</code> if a consumer registration with the primary key could not be found
	 */
	public ConsumerRegistration fetchByPrimaryKey(long registrationId);

	/**
	 * Returns all the consumer registrations.
	 *
	 * @return the consumer registrations
	 */
	public java.util.List<ConsumerRegistration> findAll();

	/**
	 * Returns a range of all the consumer registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @return the range of consumer registrations
	 */
	public java.util.List<ConsumerRegistration> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the consumer registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of consumer registrations
	 */
	public java.util.List<ConsumerRegistration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConsumerRegistration>
			orderByComparator);

	/**
	 * Returns an ordered range of all the consumer registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of consumer registrations
	 */
	public java.util.List<ConsumerRegistration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConsumerRegistration>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the consumer registrations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of consumer registrations.
	 *
	 * @return the number of consumer registrations
	 */
	public int countAll();

}