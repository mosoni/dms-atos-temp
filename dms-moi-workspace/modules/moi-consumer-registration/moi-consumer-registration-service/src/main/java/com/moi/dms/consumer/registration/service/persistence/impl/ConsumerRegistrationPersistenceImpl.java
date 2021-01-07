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

package com.moi.dms.consumer.registration.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.moi.dms.consumer.registration.exception.NoSuchConsumerRegistrationException;
import com.moi.dms.consumer.registration.model.ConsumerRegistration;
import com.moi.dms.consumer.registration.model.impl.ConsumerRegistrationImpl;
import com.moi.dms.consumer.registration.model.impl.ConsumerRegistrationModelImpl;
import com.moi.dms.consumer.registration.service.persistence.ConsumerRegistrationPersistence;
import com.moi.dms.consumer.registration.service.persistence.impl.constants.dmsPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the consumer registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ConsumerRegistrationPersistence.class)
public class ConsumerRegistrationPersistenceImpl
	extends BasePersistenceImpl<ConsumerRegistration>
	implements ConsumerRegistrationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ConsumerRegistrationUtil</code> to access the consumer registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ConsumerRegistrationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByConsumerId;
	private FinderPath _finderPathWithoutPaginationFindByConsumerId;
	private FinderPath _finderPathCountByConsumerId;

	/**
	 * Returns all the consumer registrations where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @return the matching consumer registrations
	 */
	@Override
	public List<ConsumerRegistration> findByConsumerId(String consumerId) {
		return findByConsumerId(
			consumerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ConsumerRegistration> findByConsumerId(
		String consumerId, int start, int end) {

		return findByConsumerId(consumerId, start, end, null);
	}

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
	@Override
	public List<ConsumerRegistration> findByConsumerId(
		String consumerId, int start, int end,
		OrderByComparator<ConsumerRegistration> orderByComparator) {

		return findByConsumerId(
			consumerId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<ConsumerRegistration> findByConsumerId(
		String consumerId, int start, int end,
		OrderByComparator<ConsumerRegistration> orderByComparator,
		boolean useFinderCache) {

		consumerId = Objects.toString(consumerId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByConsumerId;
				finderArgs = new Object[] {consumerId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByConsumerId;
			finderArgs = new Object[] {
				consumerId, start, end, orderByComparator
			};
		}

		List<ConsumerRegistration> list = null;

		if (useFinderCache) {
			list = (List<ConsumerRegistration>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ConsumerRegistration consumerRegistration : list) {
					if (!consumerId.equals(
							consumerRegistration.getConsumerId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CONSUMERREGISTRATION_WHERE);

			boolean bindConsumerId = false;

			if (consumerId.isEmpty()) {
				sb.append(_FINDER_COLUMN_CONSUMERID_CONSUMERID_3);
			}
			else {
				bindConsumerId = true;

				sb.append(_FINDER_COLUMN_CONSUMERID_CONSUMERID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ConsumerRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindConsumerId) {
					queryPos.add(consumerId);
				}

				list = (List<ConsumerRegistration>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first consumer registration in the ordered set where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer registration
	 * @throws NoSuchConsumerRegistrationException if a matching consumer registration could not be found
	 */
	@Override
	public ConsumerRegistration findByConsumerId_First(
			String consumerId,
			OrderByComparator<ConsumerRegistration> orderByComparator)
		throws NoSuchConsumerRegistrationException {

		ConsumerRegistration consumerRegistration = fetchByConsumerId_First(
			consumerId, orderByComparator);

		if (consumerRegistration != null) {
			return consumerRegistration;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("consumerId=");
		sb.append(consumerId);

		sb.append("}");

		throw new NoSuchConsumerRegistrationException(sb.toString());
	}

	/**
	 * Returns the first consumer registration in the ordered set where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer registration, or <code>null</code> if a matching consumer registration could not be found
	 */
	@Override
	public ConsumerRegistration fetchByConsumerId_First(
		String consumerId,
		OrderByComparator<ConsumerRegistration> orderByComparator) {

		List<ConsumerRegistration> list = findByConsumerId(
			consumerId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last consumer registration in the ordered set where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer registration
	 * @throws NoSuchConsumerRegistrationException if a matching consumer registration could not be found
	 */
	@Override
	public ConsumerRegistration findByConsumerId_Last(
			String consumerId,
			OrderByComparator<ConsumerRegistration> orderByComparator)
		throws NoSuchConsumerRegistrationException {

		ConsumerRegistration consumerRegistration = fetchByConsumerId_Last(
			consumerId, orderByComparator);

		if (consumerRegistration != null) {
			return consumerRegistration;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("consumerId=");
		sb.append(consumerId);

		sb.append("}");

		throw new NoSuchConsumerRegistrationException(sb.toString());
	}

	/**
	 * Returns the last consumer registration in the ordered set where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer registration, or <code>null</code> if a matching consumer registration could not be found
	 */
	@Override
	public ConsumerRegistration fetchByConsumerId_Last(
		String consumerId,
		OrderByComparator<ConsumerRegistration> orderByComparator) {

		int count = countByConsumerId(consumerId);

		if (count == 0) {
			return null;
		}

		List<ConsumerRegistration> list = findByConsumerId(
			consumerId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ConsumerRegistration[] findByConsumerId_PrevAndNext(
			long registrationId, String consumerId,
			OrderByComparator<ConsumerRegistration> orderByComparator)
		throws NoSuchConsumerRegistrationException {

		consumerId = Objects.toString(consumerId, "");

		ConsumerRegistration consumerRegistration = findByPrimaryKey(
			registrationId);

		Session session = null;

		try {
			session = openSession();

			ConsumerRegistration[] array = new ConsumerRegistrationImpl[3];

			array[0] = getByConsumerId_PrevAndNext(
				session, consumerRegistration, consumerId, orderByComparator,
				true);

			array[1] = consumerRegistration;

			array[2] = getByConsumerId_PrevAndNext(
				session, consumerRegistration, consumerId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ConsumerRegistration getByConsumerId_PrevAndNext(
		Session session, ConsumerRegistration consumerRegistration,
		String consumerId,
		OrderByComparator<ConsumerRegistration> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CONSUMERREGISTRATION_WHERE);

		boolean bindConsumerId = false;

		if (consumerId.isEmpty()) {
			sb.append(_FINDER_COLUMN_CONSUMERID_CONSUMERID_3);
		}
		else {
			bindConsumerId = true;

			sb.append(_FINDER_COLUMN_CONSUMERID_CONSUMERID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ConsumerRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindConsumerId) {
			queryPos.add(consumerId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						consumerRegistration)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ConsumerRegistration> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the consumer registrations where consumerId = &#63; from the database.
	 *
	 * @param consumerId the consumer ID
	 */
	@Override
	public void removeByConsumerId(String consumerId) {
		for (ConsumerRegistration consumerRegistration :
				findByConsumerId(
					consumerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(consumerRegistration);
		}
	}

	/**
	 * Returns the number of consumer registrations where consumerId = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @return the number of matching consumer registrations
	 */
	@Override
	public int countByConsumerId(String consumerId) {
		consumerId = Objects.toString(consumerId, "");

		FinderPath finderPath = _finderPathCountByConsumerId;

		Object[] finderArgs = new Object[] {consumerId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CONSUMERREGISTRATION_WHERE);

			boolean bindConsumerId = false;

			if (consumerId.isEmpty()) {
				sb.append(_FINDER_COLUMN_CONSUMERID_CONSUMERID_3);
			}
			else {
				bindConsumerId = true;

				sb.append(_FINDER_COLUMN_CONSUMERID_CONSUMERID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindConsumerId) {
					queryPos.add(consumerId);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CONSUMERID_CONSUMERID_2 =
		"consumerRegistration.consumerId = ?";

	private static final String _FINDER_COLUMN_CONSUMERID_CONSUMERID_3 =
		"(consumerRegistration.consumerId IS NULL OR consumerRegistration.consumerId = '')";

	private FinderPath _finderPathFetchByConsumerIdSupportedDocumentType;
	private FinderPath _finderPathCountByConsumerIdSupportedDocumentType;

	/**
	 * Returns the consumer registration where consumerId = &#63; and supportedDocumentType = &#63; or throws a <code>NoSuchConsumerRegistrationException</code> if it could not be found.
	 *
	 * @param consumerId the consumer ID
	 * @param supportedDocumentType the supported document type
	 * @return the matching consumer registration
	 * @throws NoSuchConsumerRegistrationException if a matching consumer registration could not be found
	 */
	@Override
	public ConsumerRegistration findByConsumerIdSupportedDocumentType(
			String consumerId, String supportedDocumentType)
		throws NoSuchConsumerRegistrationException {

		ConsumerRegistration consumerRegistration =
			fetchByConsumerIdSupportedDocumentType(
				consumerId, supportedDocumentType);

		if (consumerRegistration == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("consumerId=");
			sb.append(consumerId);

			sb.append(", supportedDocumentType=");
			sb.append(supportedDocumentType);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchConsumerRegistrationException(sb.toString());
		}

		return consumerRegistration;
	}

	/**
	 * Returns the consumer registration where consumerId = &#63; and supportedDocumentType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param consumerId the consumer ID
	 * @param supportedDocumentType the supported document type
	 * @return the matching consumer registration, or <code>null</code> if a matching consumer registration could not be found
	 */
	@Override
	public ConsumerRegistration fetchByConsumerIdSupportedDocumentType(
		String consumerId, String supportedDocumentType) {

		return fetchByConsumerIdSupportedDocumentType(
			consumerId, supportedDocumentType, true);
	}

	/**
	 * Returns the consumer registration where consumerId = &#63; and supportedDocumentType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param consumerId the consumer ID
	 * @param supportedDocumentType the supported document type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching consumer registration, or <code>null</code> if a matching consumer registration could not be found
	 */
	@Override
	public ConsumerRegistration fetchByConsumerIdSupportedDocumentType(
		String consumerId, String supportedDocumentType,
		boolean useFinderCache) {

		consumerId = Objects.toString(consumerId, "");
		supportedDocumentType = Objects.toString(supportedDocumentType, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {consumerId, supportedDocumentType};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByConsumerIdSupportedDocumentType, finderArgs,
				this);
		}

		if (result instanceof ConsumerRegistration) {
			ConsumerRegistration consumerRegistration =
				(ConsumerRegistration)result;

			if (!Objects.equals(
					consumerId, consumerRegistration.getConsumerId()) ||
				!Objects.equals(
					supportedDocumentType,
					consumerRegistration.getSupportedDocumentType())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CONSUMERREGISTRATION_WHERE);

			boolean bindConsumerId = false;

			if (consumerId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_CONSUMERIDSUPPORTEDDOCUMENTTYPE_CONSUMERID_3);
			}
			else {
				bindConsumerId = true;

				sb.append(
					_FINDER_COLUMN_CONSUMERIDSUPPORTEDDOCUMENTTYPE_CONSUMERID_2);
			}

			boolean bindSupportedDocumentType = false;

			if (supportedDocumentType.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_CONSUMERIDSUPPORTEDDOCUMENTTYPE_SUPPORTEDDOCUMENTTYPE_3);
			}
			else {
				bindSupportedDocumentType = true;

				sb.append(
					_FINDER_COLUMN_CONSUMERIDSUPPORTEDDOCUMENTTYPE_SUPPORTEDDOCUMENTTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindConsumerId) {
					queryPos.add(consumerId);
				}

				if (bindSupportedDocumentType) {
					queryPos.add(supportedDocumentType);
				}

				List<ConsumerRegistration> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByConsumerIdSupportedDocumentType,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									consumerId, supportedDocumentType
								};
							}

							_log.warn(
								"ConsumerRegistrationPersistenceImpl.fetchByConsumerIdSupportedDocumentType(String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ConsumerRegistration consumerRegistration = list.get(0);

					result = consumerRegistration;

					cacheResult(consumerRegistration);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByConsumerIdSupportedDocumentType,
						finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ConsumerRegistration)result;
		}
	}

	/**
	 * Removes the consumer registration where consumerId = &#63; and supportedDocumentType = &#63; from the database.
	 *
	 * @param consumerId the consumer ID
	 * @param supportedDocumentType the supported document type
	 * @return the consumer registration that was removed
	 */
	@Override
	public ConsumerRegistration removeByConsumerIdSupportedDocumentType(
			String consumerId, String supportedDocumentType)
		throws NoSuchConsumerRegistrationException {

		ConsumerRegistration consumerRegistration =
			findByConsumerIdSupportedDocumentType(
				consumerId, supportedDocumentType);

		return remove(consumerRegistration);
	}

	/**
	 * Returns the number of consumer registrations where consumerId = &#63; and supportedDocumentType = &#63;.
	 *
	 * @param consumerId the consumer ID
	 * @param supportedDocumentType the supported document type
	 * @return the number of matching consumer registrations
	 */
	@Override
	public int countByConsumerIdSupportedDocumentType(
		String consumerId, String supportedDocumentType) {

		consumerId = Objects.toString(consumerId, "");
		supportedDocumentType = Objects.toString(supportedDocumentType, "");

		FinderPath finderPath =
			_finderPathCountByConsumerIdSupportedDocumentType;

		Object[] finderArgs = new Object[] {consumerId, supportedDocumentType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CONSUMERREGISTRATION_WHERE);

			boolean bindConsumerId = false;

			if (consumerId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_CONSUMERIDSUPPORTEDDOCUMENTTYPE_CONSUMERID_3);
			}
			else {
				bindConsumerId = true;

				sb.append(
					_FINDER_COLUMN_CONSUMERIDSUPPORTEDDOCUMENTTYPE_CONSUMERID_2);
			}

			boolean bindSupportedDocumentType = false;

			if (supportedDocumentType.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_CONSUMERIDSUPPORTEDDOCUMENTTYPE_SUPPORTEDDOCUMENTTYPE_3);
			}
			else {
				bindSupportedDocumentType = true;

				sb.append(
					_FINDER_COLUMN_CONSUMERIDSUPPORTEDDOCUMENTTYPE_SUPPORTEDDOCUMENTTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindConsumerId) {
					queryPos.add(consumerId);
				}

				if (bindSupportedDocumentType) {
					queryPos.add(supportedDocumentType);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_CONSUMERIDSUPPORTEDDOCUMENTTYPE_CONSUMERID_2 =
			"consumerRegistration.consumerId = ? AND ";

	private static final String
		_FINDER_COLUMN_CONSUMERIDSUPPORTEDDOCUMENTTYPE_CONSUMERID_3 =
			"(consumerRegistration.consumerId IS NULL OR consumerRegistration.consumerId = '') AND ";

	private static final String
		_FINDER_COLUMN_CONSUMERIDSUPPORTEDDOCUMENTTYPE_SUPPORTEDDOCUMENTTYPE_2 =
			"consumerRegistration.supportedDocumentType = ?";

	private static final String
		_FINDER_COLUMN_CONSUMERIDSUPPORTEDDOCUMENTTYPE_SUPPORTEDDOCUMENTTYPE_3 =
			"(consumerRegistration.supportedDocumentType IS NULL OR consumerRegistration.supportedDocumentType = '')";

	private FinderPath
		_finderPathWithPaginationFindByConsumerNameSupportedDocumentType;
	private FinderPath
		_finderPathWithoutPaginationFindByConsumerNameSupportedDocumentType;
	private FinderPath _finderPathCountByConsumerNameSupportedDocumentType;

	/**
	 * Returns all the consumer registrations where consumerName = &#63; and supportedDocumentType = &#63;.
	 *
	 * @param consumerName the consumer name
	 * @param supportedDocumentType the supported document type
	 * @return the matching consumer registrations
	 */
	@Override
	public List<ConsumerRegistration> findByConsumerNameSupportedDocumentType(
		String consumerName, String supportedDocumentType) {

		return findByConsumerNameSupportedDocumentType(
			consumerName, supportedDocumentType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the consumer registrations where consumerName = &#63; and supportedDocumentType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param consumerName the consumer name
	 * @param supportedDocumentType the supported document type
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @return the range of matching consumer registrations
	 */
	@Override
	public List<ConsumerRegistration> findByConsumerNameSupportedDocumentType(
		String consumerName, String supportedDocumentType, int start, int end) {

		return findByConsumerNameSupportedDocumentType(
			consumerName, supportedDocumentType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the consumer registrations where consumerName = &#63; and supportedDocumentType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param consumerName the consumer name
	 * @param supportedDocumentType the supported document type
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching consumer registrations
	 */
	@Override
	public List<ConsumerRegistration> findByConsumerNameSupportedDocumentType(
		String consumerName, String supportedDocumentType, int start, int end,
		OrderByComparator<ConsumerRegistration> orderByComparator) {

		return findByConsumerNameSupportedDocumentType(
			consumerName, supportedDocumentType, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the consumer registrations where consumerName = &#63; and supportedDocumentType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConsumerRegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param consumerName the consumer name
	 * @param supportedDocumentType the supported document type
	 * @param start the lower bound of the range of consumer registrations
	 * @param end the upper bound of the range of consumer registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching consumer registrations
	 */
	@Override
	public List<ConsumerRegistration> findByConsumerNameSupportedDocumentType(
		String consumerName, String supportedDocumentType, int start, int end,
		OrderByComparator<ConsumerRegistration> orderByComparator,
		boolean useFinderCache) {

		consumerName = Objects.toString(consumerName, "");
		supportedDocumentType = Objects.toString(supportedDocumentType, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByConsumerNameSupportedDocumentType;
				finderArgs = new Object[] {consumerName, supportedDocumentType};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByConsumerNameSupportedDocumentType;
			finderArgs = new Object[] {
				consumerName, supportedDocumentType, start, end,
				orderByComparator
			};
		}

		List<ConsumerRegistration> list = null;

		if (useFinderCache) {
			list = (List<ConsumerRegistration>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ConsumerRegistration consumerRegistration : list) {
					if (!consumerName.equals(
							consumerRegistration.getConsumerName()) ||
						!supportedDocumentType.equals(
							consumerRegistration.getSupportedDocumentType())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_CONSUMERREGISTRATION_WHERE);

			boolean bindConsumerName = false;

			if (consumerName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_CONSUMERNAMESUPPORTEDDOCUMENTTYPE_CONSUMERNAME_3);
			}
			else {
				bindConsumerName = true;

				sb.append(
					_FINDER_COLUMN_CONSUMERNAMESUPPORTEDDOCUMENTTYPE_CONSUMERNAME_2);
			}

			boolean bindSupportedDocumentType = false;

			if (supportedDocumentType.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_CONSUMERNAMESUPPORTEDDOCUMENTTYPE_SUPPORTEDDOCUMENTTYPE_3);
			}
			else {
				bindSupportedDocumentType = true;

				sb.append(
					_FINDER_COLUMN_CONSUMERNAMESUPPORTEDDOCUMENTTYPE_SUPPORTEDDOCUMENTTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ConsumerRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindConsumerName) {
					queryPos.add(consumerName);
				}

				if (bindSupportedDocumentType) {
					queryPos.add(supportedDocumentType);
				}

				list = (List<ConsumerRegistration>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first consumer registration in the ordered set where consumerName = &#63; and supportedDocumentType = &#63;.
	 *
	 * @param consumerName the consumer name
	 * @param supportedDocumentType the supported document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer registration
	 * @throws NoSuchConsumerRegistrationException if a matching consumer registration could not be found
	 */
	@Override
	public ConsumerRegistration findByConsumerNameSupportedDocumentType_First(
			String consumerName, String supportedDocumentType,
			OrderByComparator<ConsumerRegistration> orderByComparator)
		throws NoSuchConsumerRegistrationException {

		ConsumerRegistration consumerRegistration =
			fetchByConsumerNameSupportedDocumentType_First(
				consumerName, supportedDocumentType, orderByComparator);

		if (consumerRegistration != null) {
			return consumerRegistration;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("consumerName=");
		sb.append(consumerName);

		sb.append(", supportedDocumentType=");
		sb.append(supportedDocumentType);

		sb.append("}");

		throw new NoSuchConsumerRegistrationException(sb.toString());
	}

	/**
	 * Returns the first consumer registration in the ordered set where consumerName = &#63; and supportedDocumentType = &#63;.
	 *
	 * @param consumerName the consumer name
	 * @param supportedDocumentType the supported document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer registration, or <code>null</code> if a matching consumer registration could not be found
	 */
	@Override
	public ConsumerRegistration fetchByConsumerNameSupportedDocumentType_First(
		String consumerName, String supportedDocumentType,
		OrderByComparator<ConsumerRegistration> orderByComparator) {

		List<ConsumerRegistration> list =
			findByConsumerNameSupportedDocumentType(
				consumerName, supportedDocumentType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last consumer registration in the ordered set where consumerName = &#63; and supportedDocumentType = &#63;.
	 *
	 * @param consumerName the consumer name
	 * @param supportedDocumentType the supported document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer registration
	 * @throws NoSuchConsumerRegistrationException if a matching consumer registration could not be found
	 */
	@Override
	public ConsumerRegistration findByConsumerNameSupportedDocumentType_Last(
			String consumerName, String supportedDocumentType,
			OrderByComparator<ConsumerRegistration> orderByComparator)
		throws NoSuchConsumerRegistrationException {

		ConsumerRegistration consumerRegistration =
			fetchByConsumerNameSupportedDocumentType_Last(
				consumerName, supportedDocumentType, orderByComparator);

		if (consumerRegistration != null) {
			return consumerRegistration;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("consumerName=");
		sb.append(consumerName);

		sb.append(", supportedDocumentType=");
		sb.append(supportedDocumentType);

		sb.append("}");

		throw new NoSuchConsumerRegistrationException(sb.toString());
	}

	/**
	 * Returns the last consumer registration in the ordered set where consumerName = &#63; and supportedDocumentType = &#63;.
	 *
	 * @param consumerName the consumer name
	 * @param supportedDocumentType the supported document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer registration, or <code>null</code> if a matching consumer registration could not be found
	 */
	@Override
	public ConsumerRegistration fetchByConsumerNameSupportedDocumentType_Last(
		String consumerName, String supportedDocumentType,
		OrderByComparator<ConsumerRegistration> orderByComparator) {

		int count = countByConsumerNameSupportedDocumentType(
			consumerName, supportedDocumentType);

		if (count == 0) {
			return null;
		}

		List<ConsumerRegistration> list =
			findByConsumerNameSupportedDocumentType(
				consumerName, supportedDocumentType, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the consumer registrations before and after the current consumer registration in the ordered set where consumerName = &#63; and supportedDocumentType = &#63;.
	 *
	 * @param registrationId the primary key of the current consumer registration
	 * @param consumerName the consumer name
	 * @param supportedDocumentType the supported document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next consumer registration
	 * @throws NoSuchConsumerRegistrationException if a consumer registration with the primary key could not be found
	 */
	@Override
	public ConsumerRegistration[]
			findByConsumerNameSupportedDocumentType_PrevAndNext(
				long registrationId, String consumerName,
				String supportedDocumentType,
				OrderByComparator<ConsumerRegistration> orderByComparator)
		throws NoSuchConsumerRegistrationException {

		consumerName = Objects.toString(consumerName, "");
		supportedDocumentType = Objects.toString(supportedDocumentType, "");

		ConsumerRegistration consumerRegistration = findByPrimaryKey(
			registrationId);

		Session session = null;

		try {
			session = openSession();

			ConsumerRegistration[] array = new ConsumerRegistrationImpl[3];

			array[0] = getByConsumerNameSupportedDocumentType_PrevAndNext(
				session, consumerRegistration, consumerName,
				supportedDocumentType, orderByComparator, true);

			array[1] = consumerRegistration;

			array[2] = getByConsumerNameSupportedDocumentType_PrevAndNext(
				session, consumerRegistration, consumerName,
				supportedDocumentType, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ConsumerRegistration
		getByConsumerNameSupportedDocumentType_PrevAndNext(
			Session session, ConsumerRegistration consumerRegistration,
			String consumerName, String supportedDocumentType,
			OrderByComparator<ConsumerRegistration> orderByComparator,
			boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CONSUMERREGISTRATION_WHERE);

		boolean bindConsumerName = false;

		if (consumerName.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_CONSUMERNAMESUPPORTEDDOCUMENTTYPE_CONSUMERNAME_3);
		}
		else {
			bindConsumerName = true;

			sb.append(
				_FINDER_COLUMN_CONSUMERNAMESUPPORTEDDOCUMENTTYPE_CONSUMERNAME_2);
		}

		boolean bindSupportedDocumentType = false;

		if (supportedDocumentType.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_CONSUMERNAMESUPPORTEDDOCUMENTTYPE_SUPPORTEDDOCUMENTTYPE_3);
		}
		else {
			bindSupportedDocumentType = true;

			sb.append(
				_FINDER_COLUMN_CONSUMERNAMESUPPORTEDDOCUMENTTYPE_SUPPORTEDDOCUMENTTYPE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ConsumerRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindConsumerName) {
			queryPos.add(consumerName);
		}

		if (bindSupportedDocumentType) {
			queryPos.add(supportedDocumentType);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						consumerRegistration)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ConsumerRegistration> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the consumer registrations where consumerName = &#63; and supportedDocumentType = &#63; from the database.
	 *
	 * @param consumerName the consumer name
	 * @param supportedDocumentType the supported document type
	 */
	@Override
	public void removeByConsumerNameSupportedDocumentType(
		String consumerName, String supportedDocumentType) {

		for (ConsumerRegistration consumerRegistration :
				findByConsumerNameSupportedDocumentType(
					consumerName, supportedDocumentType, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(consumerRegistration);
		}
	}

	/**
	 * Returns the number of consumer registrations where consumerName = &#63; and supportedDocumentType = &#63;.
	 *
	 * @param consumerName the consumer name
	 * @param supportedDocumentType the supported document type
	 * @return the number of matching consumer registrations
	 */
	@Override
	public int countByConsumerNameSupportedDocumentType(
		String consumerName, String supportedDocumentType) {

		consumerName = Objects.toString(consumerName, "");
		supportedDocumentType = Objects.toString(supportedDocumentType, "");

		FinderPath finderPath =
			_finderPathCountByConsumerNameSupportedDocumentType;

		Object[] finderArgs = new Object[] {
			consumerName, supportedDocumentType
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CONSUMERREGISTRATION_WHERE);

			boolean bindConsumerName = false;

			if (consumerName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_CONSUMERNAMESUPPORTEDDOCUMENTTYPE_CONSUMERNAME_3);
			}
			else {
				bindConsumerName = true;

				sb.append(
					_FINDER_COLUMN_CONSUMERNAMESUPPORTEDDOCUMENTTYPE_CONSUMERNAME_2);
			}

			boolean bindSupportedDocumentType = false;

			if (supportedDocumentType.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_CONSUMERNAMESUPPORTEDDOCUMENTTYPE_SUPPORTEDDOCUMENTTYPE_3);
			}
			else {
				bindSupportedDocumentType = true;

				sb.append(
					_FINDER_COLUMN_CONSUMERNAMESUPPORTEDDOCUMENTTYPE_SUPPORTEDDOCUMENTTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindConsumerName) {
					queryPos.add(consumerName);
				}

				if (bindSupportedDocumentType) {
					queryPos.add(supportedDocumentType);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_CONSUMERNAMESUPPORTEDDOCUMENTTYPE_CONSUMERNAME_2 =
			"consumerRegistration.consumerName = ? AND ";

	private static final String
		_FINDER_COLUMN_CONSUMERNAMESUPPORTEDDOCUMENTTYPE_CONSUMERNAME_3 =
			"(consumerRegistration.consumerName IS NULL OR consumerRegistration.consumerName = '') AND ";

	private static final String
		_FINDER_COLUMN_CONSUMERNAMESUPPORTEDDOCUMENTTYPE_SUPPORTEDDOCUMENTTYPE_2 =
			"consumerRegistration.supportedDocumentType = ?";

	private static final String
		_FINDER_COLUMN_CONSUMERNAMESUPPORTEDDOCUMENTTYPE_SUPPORTEDDOCUMENTTYPE_3 =
			"(consumerRegistration.supportedDocumentType IS NULL OR consumerRegistration.supportedDocumentType = '')";

	private FinderPath _finderPathWithPaginationFindByConsumerName;
	private FinderPath _finderPathWithoutPaginationFindByConsumerName;
	private FinderPath _finderPathCountByConsumerName;

	/**
	 * Returns all the consumer registrations where consumerName = &#63;.
	 *
	 * @param consumerName the consumer name
	 * @return the matching consumer registrations
	 */
	@Override
	public List<ConsumerRegistration> findByConsumerName(String consumerName) {
		return findByConsumerName(
			consumerName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ConsumerRegistration> findByConsumerName(
		String consumerName, int start, int end) {

		return findByConsumerName(consumerName, start, end, null);
	}

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
	@Override
	public List<ConsumerRegistration> findByConsumerName(
		String consumerName, int start, int end,
		OrderByComparator<ConsumerRegistration> orderByComparator) {

		return findByConsumerName(
			consumerName, start, end, orderByComparator, true);
	}

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
	@Override
	public List<ConsumerRegistration> findByConsumerName(
		String consumerName, int start, int end,
		OrderByComparator<ConsumerRegistration> orderByComparator,
		boolean useFinderCache) {

		consumerName = Objects.toString(consumerName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByConsumerName;
				finderArgs = new Object[] {consumerName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByConsumerName;
			finderArgs = new Object[] {
				consumerName, start, end, orderByComparator
			};
		}

		List<ConsumerRegistration> list = null;

		if (useFinderCache) {
			list = (List<ConsumerRegistration>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ConsumerRegistration consumerRegistration : list) {
					if (!consumerName.equals(
							consumerRegistration.getConsumerName())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CONSUMERREGISTRATION_WHERE);

			boolean bindConsumerName = false;

			if (consumerName.isEmpty()) {
				sb.append(_FINDER_COLUMN_CONSUMERNAME_CONSUMERNAME_3);
			}
			else {
				bindConsumerName = true;

				sb.append(_FINDER_COLUMN_CONSUMERNAME_CONSUMERNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ConsumerRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindConsumerName) {
					queryPos.add(consumerName);
				}

				list = (List<ConsumerRegistration>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first consumer registration in the ordered set where consumerName = &#63;.
	 *
	 * @param consumerName the consumer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer registration
	 * @throws NoSuchConsumerRegistrationException if a matching consumer registration could not be found
	 */
	@Override
	public ConsumerRegistration findByConsumerName_First(
			String consumerName,
			OrderByComparator<ConsumerRegistration> orderByComparator)
		throws NoSuchConsumerRegistrationException {

		ConsumerRegistration consumerRegistration = fetchByConsumerName_First(
			consumerName, orderByComparator);

		if (consumerRegistration != null) {
			return consumerRegistration;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("consumerName=");
		sb.append(consumerName);

		sb.append("}");

		throw new NoSuchConsumerRegistrationException(sb.toString());
	}

	/**
	 * Returns the first consumer registration in the ordered set where consumerName = &#63;.
	 *
	 * @param consumerName the consumer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer registration, or <code>null</code> if a matching consumer registration could not be found
	 */
	@Override
	public ConsumerRegistration fetchByConsumerName_First(
		String consumerName,
		OrderByComparator<ConsumerRegistration> orderByComparator) {

		List<ConsumerRegistration> list = findByConsumerName(
			consumerName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last consumer registration in the ordered set where consumerName = &#63;.
	 *
	 * @param consumerName the consumer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer registration
	 * @throws NoSuchConsumerRegistrationException if a matching consumer registration could not be found
	 */
	@Override
	public ConsumerRegistration findByConsumerName_Last(
			String consumerName,
			OrderByComparator<ConsumerRegistration> orderByComparator)
		throws NoSuchConsumerRegistrationException {

		ConsumerRegistration consumerRegistration = fetchByConsumerName_Last(
			consumerName, orderByComparator);

		if (consumerRegistration != null) {
			return consumerRegistration;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("consumerName=");
		sb.append(consumerName);

		sb.append("}");

		throw new NoSuchConsumerRegistrationException(sb.toString());
	}

	/**
	 * Returns the last consumer registration in the ordered set where consumerName = &#63;.
	 *
	 * @param consumerName the consumer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer registration, or <code>null</code> if a matching consumer registration could not be found
	 */
	@Override
	public ConsumerRegistration fetchByConsumerName_Last(
		String consumerName,
		OrderByComparator<ConsumerRegistration> orderByComparator) {

		int count = countByConsumerName(consumerName);

		if (count == 0) {
			return null;
		}

		List<ConsumerRegistration> list = findByConsumerName(
			consumerName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ConsumerRegistration[] findByConsumerName_PrevAndNext(
			long registrationId, String consumerName,
			OrderByComparator<ConsumerRegistration> orderByComparator)
		throws NoSuchConsumerRegistrationException {

		consumerName = Objects.toString(consumerName, "");

		ConsumerRegistration consumerRegistration = findByPrimaryKey(
			registrationId);

		Session session = null;

		try {
			session = openSession();

			ConsumerRegistration[] array = new ConsumerRegistrationImpl[3];

			array[0] = getByConsumerName_PrevAndNext(
				session, consumerRegistration, consumerName, orderByComparator,
				true);

			array[1] = consumerRegistration;

			array[2] = getByConsumerName_PrevAndNext(
				session, consumerRegistration, consumerName, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ConsumerRegistration getByConsumerName_PrevAndNext(
		Session session, ConsumerRegistration consumerRegistration,
		String consumerName,
		OrderByComparator<ConsumerRegistration> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CONSUMERREGISTRATION_WHERE);

		boolean bindConsumerName = false;

		if (consumerName.isEmpty()) {
			sb.append(_FINDER_COLUMN_CONSUMERNAME_CONSUMERNAME_3);
		}
		else {
			bindConsumerName = true;

			sb.append(_FINDER_COLUMN_CONSUMERNAME_CONSUMERNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ConsumerRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindConsumerName) {
			queryPos.add(consumerName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						consumerRegistration)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ConsumerRegistration> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the consumer registrations where consumerName = &#63; from the database.
	 *
	 * @param consumerName the consumer name
	 */
	@Override
	public void removeByConsumerName(String consumerName) {
		for (ConsumerRegistration consumerRegistration :
				findByConsumerName(
					consumerName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(consumerRegistration);
		}
	}

	/**
	 * Returns the number of consumer registrations where consumerName = &#63;.
	 *
	 * @param consumerName the consumer name
	 * @return the number of matching consumer registrations
	 */
	@Override
	public int countByConsumerName(String consumerName) {
		consumerName = Objects.toString(consumerName, "");

		FinderPath finderPath = _finderPathCountByConsumerName;

		Object[] finderArgs = new Object[] {consumerName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CONSUMERREGISTRATION_WHERE);

			boolean bindConsumerName = false;

			if (consumerName.isEmpty()) {
				sb.append(_FINDER_COLUMN_CONSUMERNAME_CONSUMERNAME_3);
			}
			else {
				bindConsumerName = true;

				sb.append(_FINDER_COLUMN_CONSUMERNAME_CONSUMERNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindConsumerName) {
					queryPos.add(consumerName);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CONSUMERNAME_CONSUMERNAME_2 =
		"consumerRegistration.consumerName = ?";

	private static final String _FINDER_COLUMN_CONSUMERNAME_CONSUMERNAME_3 =
		"(consumerRegistration.consumerName IS NULL OR consumerRegistration.consumerName = '')";

	private FinderPath _finderPathWithPaginationFindBySupportedDocumentType;
	private FinderPath _finderPathWithoutPaginationFindBySupportedDocumentType;
	private FinderPath _finderPathCountBySupportedDocumentType;

	/**
	 * Returns all the consumer registrations where supportedDocumentType = &#63;.
	 *
	 * @param supportedDocumentType the supported document type
	 * @return the matching consumer registrations
	 */
	@Override
	public List<ConsumerRegistration> findBySupportedDocumentType(
		String supportedDocumentType) {

		return findBySupportedDocumentType(
			supportedDocumentType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ConsumerRegistration> findBySupportedDocumentType(
		String supportedDocumentType, int start, int end) {

		return findBySupportedDocumentType(
			supportedDocumentType, start, end, null);
	}

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
	@Override
	public List<ConsumerRegistration> findBySupportedDocumentType(
		String supportedDocumentType, int start, int end,
		OrderByComparator<ConsumerRegistration> orderByComparator) {

		return findBySupportedDocumentType(
			supportedDocumentType, start, end, orderByComparator, true);
	}

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
	@Override
	public List<ConsumerRegistration> findBySupportedDocumentType(
		String supportedDocumentType, int start, int end,
		OrderByComparator<ConsumerRegistration> orderByComparator,
		boolean useFinderCache) {

		supportedDocumentType = Objects.toString(supportedDocumentType, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBySupportedDocumentType;
				finderArgs = new Object[] {supportedDocumentType};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySupportedDocumentType;
			finderArgs = new Object[] {
				supportedDocumentType, start, end, orderByComparator
			};
		}

		List<ConsumerRegistration> list = null;

		if (useFinderCache) {
			list = (List<ConsumerRegistration>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ConsumerRegistration consumerRegistration : list) {
					if (!supportedDocumentType.equals(
							consumerRegistration.getSupportedDocumentType())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CONSUMERREGISTRATION_WHERE);

			boolean bindSupportedDocumentType = false;

			if (supportedDocumentType.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_SUPPORTEDDOCUMENTTYPE_SUPPORTEDDOCUMENTTYPE_3);
			}
			else {
				bindSupportedDocumentType = true;

				sb.append(
					_FINDER_COLUMN_SUPPORTEDDOCUMENTTYPE_SUPPORTEDDOCUMENTTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ConsumerRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSupportedDocumentType) {
					queryPos.add(supportedDocumentType);
				}

				list = (List<ConsumerRegistration>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first consumer registration in the ordered set where supportedDocumentType = &#63;.
	 *
	 * @param supportedDocumentType the supported document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer registration
	 * @throws NoSuchConsumerRegistrationException if a matching consumer registration could not be found
	 */
	@Override
	public ConsumerRegistration findBySupportedDocumentType_First(
			String supportedDocumentType,
			OrderByComparator<ConsumerRegistration> orderByComparator)
		throws NoSuchConsumerRegistrationException {

		ConsumerRegistration consumerRegistration =
			fetchBySupportedDocumentType_First(
				supportedDocumentType, orderByComparator);

		if (consumerRegistration != null) {
			return consumerRegistration;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("supportedDocumentType=");
		sb.append(supportedDocumentType);

		sb.append("}");

		throw new NoSuchConsumerRegistrationException(sb.toString());
	}

	/**
	 * Returns the first consumer registration in the ordered set where supportedDocumentType = &#63;.
	 *
	 * @param supportedDocumentType the supported document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer registration, or <code>null</code> if a matching consumer registration could not be found
	 */
	@Override
	public ConsumerRegistration fetchBySupportedDocumentType_First(
		String supportedDocumentType,
		OrderByComparator<ConsumerRegistration> orderByComparator) {

		List<ConsumerRegistration> list = findBySupportedDocumentType(
			supportedDocumentType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last consumer registration in the ordered set where supportedDocumentType = &#63;.
	 *
	 * @param supportedDocumentType the supported document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer registration
	 * @throws NoSuchConsumerRegistrationException if a matching consumer registration could not be found
	 */
	@Override
	public ConsumerRegistration findBySupportedDocumentType_Last(
			String supportedDocumentType,
			OrderByComparator<ConsumerRegistration> orderByComparator)
		throws NoSuchConsumerRegistrationException {

		ConsumerRegistration consumerRegistration =
			fetchBySupportedDocumentType_Last(
				supportedDocumentType, orderByComparator);

		if (consumerRegistration != null) {
			return consumerRegistration;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("supportedDocumentType=");
		sb.append(supportedDocumentType);

		sb.append("}");

		throw new NoSuchConsumerRegistrationException(sb.toString());
	}

	/**
	 * Returns the last consumer registration in the ordered set where supportedDocumentType = &#63;.
	 *
	 * @param supportedDocumentType the supported document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer registration, or <code>null</code> if a matching consumer registration could not be found
	 */
	@Override
	public ConsumerRegistration fetchBySupportedDocumentType_Last(
		String supportedDocumentType,
		OrderByComparator<ConsumerRegistration> orderByComparator) {

		int count = countBySupportedDocumentType(supportedDocumentType);

		if (count == 0) {
			return null;
		}

		List<ConsumerRegistration> list = findBySupportedDocumentType(
			supportedDocumentType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ConsumerRegistration[] findBySupportedDocumentType_PrevAndNext(
			long registrationId, String supportedDocumentType,
			OrderByComparator<ConsumerRegistration> orderByComparator)
		throws NoSuchConsumerRegistrationException {

		supportedDocumentType = Objects.toString(supportedDocumentType, "");

		ConsumerRegistration consumerRegistration = findByPrimaryKey(
			registrationId);

		Session session = null;

		try {
			session = openSession();

			ConsumerRegistration[] array = new ConsumerRegistrationImpl[3];

			array[0] = getBySupportedDocumentType_PrevAndNext(
				session, consumerRegistration, supportedDocumentType,
				orderByComparator, true);

			array[1] = consumerRegistration;

			array[2] = getBySupportedDocumentType_PrevAndNext(
				session, consumerRegistration, supportedDocumentType,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ConsumerRegistration getBySupportedDocumentType_PrevAndNext(
		Session session, ConsumerRegistration consumerRegistration,
		String supportedDocumentType,
		OrderByComparator<ConsumerRegistration> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CONSUMERREGISTRATION_WHERE);

		boolean bindSupportedDocumentType = false;

		if (supportedDocumentType.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_SUPPORTEDDOCUMENTTYPE_SUPPORTEDDOCUMENTTYPE_3);
		}
		else {
			bindSupportedDocumentType = true;

			sb.append(
				_FINDER_COLUMN_SUPPORTEDDOCUMENTTYPE_SUPPORTEDDOCUMENTTYPE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ConsumerRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindSupportedDocumentType) {
			queryPos.add(supportedDocumentType);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						consumerRegistration)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ConsumerRegistration> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the consumer registrations where supportedDocumentType = &#63; from the database.
	 *
	 * @param supportedDocumentType the supported document type
	 */
	@Override
	public void removeBySupportedDocumentType(String supportedDocumentType) {
		for (ConsumerRegistration consumerRegistration :
				findBySupportedDocumentType(
					supportedDocumentType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(consumerRegistration);
		}
	}

	/**
	 * Returns the number of consumer registrations where supportedDocumentType = &#63;.
	 *
	 * @param supportedDocumentType the supported document type
	 * @return the number of matching consumer registrations
	 */
	@Override
	public int countBySupportedDocumentType(String supportedDocumentType) {
		supportedDocumentType = Objects.toString(supportedDocumentType, "");

		FinderPath finderPath = _finderPathCountBySupportedDocumentType;

		Object[] finderArgs = new Object[] {supportedDocumentType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CONSUMERREGISTRATION_WHERE);

			boolean bindSupportedDocumentType = false;

			if (supportedDocumentType.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_SUPPORTEDDOCUMENTTYPE_SUPPORTEDDOCUMENTTYPE_3);
			}
			else {
				bindSupportedDocumentType = true;

				sb.append(
					_FINDER_COLUMN_SUPPORTEDDOCUMENTTYPE_SUPPORTEDDOCUMENTTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSupportedDocumentType) {
					queryPos.add(supportedDocumentType);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_SUPPORTEDDOCUMENTTYPE_SUPPORTEDDOCUMENTTYPE_2 =
			"consumerRegistration.supportedDocumentType = ?";

	private static final String
		_FINDER_COLUMN_SUPPORTEDDOCUMENTTYPE_SUPPORTEDDOCUMENTTYPE_3 =
			"(consumerRegistration.supportedDocumentType IS NULL OR consumerRegistration.supportedDocumentType = '')";

	private FinderPath _finderPathWithPaginationFindByConsumerStatus;
	private FinderPath _finderPathWithoutPaginationFindByConsumerStatus;
	private FinderPath _finderPathCountByConsumerStatus;

	/**
	 * Returns all the consumer registrations where consumerStatus = &#63;.
	 *
	 * @param consumerStatus the consumer status
	 * @return the matching consumer registrations
	 */
	@Override
	public List<ConsumerRegistration> findByConsumerStatus(
		String consumerStatus) {

		return findByConsumerStatus(
			consumerStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ConsumerRegistration> findByConsumerStatus(
		String consumerStatus, int start, int end) {

		return findByConsumerStatus(consumerStatus, start, end, null);
	}

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
	@Override
	public List<ConsumerRegistration> findByConsumerStatus(
		String consumerStatus, int start, int end,
		OrderByComparator<ConsumerRegistration> orderByComparator) {

		return findByConsumerStatus(
			consumerStatus, start, end, orderByComparator, true);
	}

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
	@Override
	public List<ConsumerRegistration> findByConsumerStatus(
		String consumerStatus, int start, int end,
		OrderByComparator<ConsumerRegistration> orderByComparator,
		boolean useFinderCache) {

		consumerStatus = Objects.toString(consumerStatus, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByConsumerStatus;
				finderArgs = new Object[] {consumerStatus};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByConsumerStatus;
			finderArgs = new Object[] {
				consumerStatus, start, end, orderByComparator
			};
		}

		List<ConsumerRegistration> list = null;

		if (useFinderCache) {
			list = (List<ConsumerRegistration>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ConsumerRegistration consumerRegistration : list) {
					if (!consumerStatus.equals(
							consumerRegistration.getConsumerStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CONSUMERREGISTRATION_WHERE);

			boolean bindConsumerStatus = false;

			if (consumerStatus.isEmpty()) {
				sb.append(_FINDER_COLUMN_CONSUMERSTATUS_CONSUMERSTATUS_3);
			}
			else {
				bindConsumerStatus = true;

				sb.append(_FINDER_COLUMN_CONSUMERSTATUS_CONSUMERSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ConsumerRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindConsumerStatus) {
					queryPos.add(consumerStatus);
				}

				list = (List<ConsumerRegistration>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first consumer registration in the ordered set where consumerStatus = &#63;.
	 *
	 * @param consumerStatus the consumer status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer registration
	 * @throws NoSuchConsumerRegistrationException if a matching consumer registration could not be found
	 */
	@Override
	public ConsumerRegistration findByConsumerStatus_First(
			String consumerStatus,
			OrderByComparator<ConsumerRegistration> orderByComparator)
		throws NoSuchConsumerRegistrationException {

		ConsumerRegistration consumerRegistration = fetchByConsumerStatus_First(
			consumerStatus, orderByComparator);

		if (consumerRegistration != null) {
			return consumerRegistration;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("consumerStatus=");
		sb.append(consumerStatus);

		sb.append("}");

		throw new NoSuchConsumerRegistrationException(sb.toString());
	}

	/**
	 * Returns the first consumer registration in the ordered set where consumerStatus = &#63;.
	 *
	 * @param consumerStatus the consumer status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consumer registration, or <code>null</code> if a matching consumer registration could not be found
	 */
	@Override
	public ConsumerRegistration fetchByConsumerStatus_First(
		String consumerStatus,
		OrderByComparator<ConsumerRegistration> orderByComparator) {

		List<ConsumerRegistration> list = findByConsumerStatus(
			consumerStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last consumer registration in the ordered set where consumerStatus = &#63;.
	 *
	 * @param consumerStatus the consumer status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer registration
	 * @throws NoSuchConsumerRegistrationException if a matching consumer registration could not be found
	 */
	@Override
	public ConsumerRegistration findByConsumerStatus_Last(
			String consumerStatus,
			OrderByComparator<ConsumerRegistration> orderByComparator)
		throws NoSuchConsumerRegistrationException {

		ConsumerRegistration consumerRegistration = fetchByConsumerStatus_Last(
			consumerStatus, orderByComparator);

		if (consumerRegistration != null) {
			return consumerRegistration;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("consumerStatus=");
		sb.append(consumerStatus);

		sb.append("}");

		throw new NoSuchConsumerRegistrationException(sb.toString());
	}

	/**
	 * Returns the last consumer registration in the ordered set where consumerStatus = &#63;.
	 *
	 * @param consumerStatus the consumer status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consumer registration, or <code>null</code> if a matching consumer registration could not be found
	 */
	@Override
	public ConsumerRegistration fetchByConsumerStatus_Last(
		String consumerStatus,
		OrderByComparator<ConsumerRegistration> orderByComparator) {

		int count = countByConsumerStatus(consumerStatus);

		if (count == 0) {
			return null;
		}

		List<ConsumerRegistration> list = findByConsumerStatus(
			consumerStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ConsumerRegistration[] findByConsumerStatus_PrevAndNext(
			long registrationId, String consumerStatus,
			OrderByComparator<ConsumerRegistration> orderByComparator)
		throws NoSuchConsumerRegistrationException {

		consumerStatus = Objects.toString(consumerStatus, "");

		ConsumerRegistration consumerRegistration = findByPrimaryKey(
			registrationId);

		Session session = null;

		try {
			session = openSession();

			ConsumerRegistration[] array = new ConsumerRegistrationImpl[3];

			array[0] = getByConsumerStatus_PrevAndNext(
				session, consumerRegistration, consumerStatus,
				orderByComparator, true);

			array[1] = consumerRegistration;

			array[2] = getByConsumerStatus_PrevAndNext(
				session, consumerRegistration, consumerStatus,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ConsumerRegistration getByConsumerStatus_PrevAndNext(
		Session session, ConsumerRegistration consumerRegistration,
		String consumerStatus,
		OrderByComparator<ConsumerRegistration> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CONSUMERREGISTRATION_WHERE);

		boolean bindConsumerStatus = false;

		if (consumerStatus.isEmpty()) {
			sb.append(_FINDER_COLUMN_CONSUMERSTATUS_CONSUMERSTATUS_3);
		}
		else {
			bindConsumerStatus = true;

			sb.append(_FINDER_COLUMN_CONSUMERSTATUS_CONSUMERSTATUS_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ConsumerRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindConsumerStatus) {
			queryPos.add(consumerStatus);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						consumerRegistration)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ConsumerRegistration> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the consumer registrations where consumerStatus = &#63; from the database.
	 *
	 * @param consumerStatus the consumer status
	 */
	@Override
	public void removeByConsumerStatus(String consumerStatus) {
		for (ConsumerRegistration consumerRegistration :
				findByConsumerStatus(
					consumerStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(consumerRegistration);
		}
	}

	/**
	 * Returns the number of consumer registrations where consumerStatus = &#63;.
	 *
	 * @param consumerStatus the consumer status
	 * @return the number of matching consumer registrations
	 */
	@Override
	public int countByConsumerStatus(String consumerStatus) {
		consumerStatus = Objects.toString(consumerStatus, "");

		FinderPath finderPath = _finderPathCountByConsumerStatus;

		Object[] finderArgs = new Object[] {consumerStatus};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CONSUMERREGISTRATION_WHERE);

			boolean bindConsumerStatus = false;

			if (consumerStatus.isEmpty()) {
				sb.append(_FINDER_COLUMN_CONSUMERSTATUS_CONSUMERSTATUS_3);
			}
			else {
				bindConsumerStatus = true;

				sb.append(_FINDER_COLUMN_CONSUMERSTATUS_CONSUMERSTATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindConsumerStatus) {
					queryPos.add(consumerStatus);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CONSUMERSTATUS_CONSUMERSTATUS_2 =
		"consumerRegistration.consumerStatus = ?";

	private static final String _FINDER_COLUMN_CONSUMERSTATUS_CONSUMERSTATUS_3 =
		"(consumerRegistration.consumerStatus IS NULL OR consumerRegistration.consumerStatus = '')";

	public ConsumerRegistrationPersistenceImpl() {
		setModelClass(ConsumerRegistration.class);

		setModelImplClass(ConsumerRegistrationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the consumer registration in the entity cache if it is enabled.
	 *
	 * @param consumerRegistration the consumer registration
	 */
	@Override
	public void cacheResult(ConsumerRegistration consumerRegistration) {
		entityCache.putResult(
			entityCacheEnabled, ConsumerRegistrationImpl.class,
			consumerRegistration.getPrimaryKey(), consumerRegistration);

		finderCache.putResult(
			_finderPathFetchByConsumerIdSupportedDocumentType,
			new Object[] {
				consumerRegistration.getConsumerId(),
				consumerRegistration.getSupportedDocumentType()
			},
			consumerRegistration);

		consumerRegistration.resetOriginalValues();
	}

	/**
	 * Caches the consumer registrations in the entity cache if it is enabled.
	 *
	 * @param consumerRegistrations the consumer registrations
	 */
	@Override
	public void cacheResult(List<ConsumerRegistration> consumerRegistrations) {
		for (ConsumerRegistration consumerRegistration :
				consumerRegistrations) {

			if (entityCache.getResult(
					entityCacheEnabled, ConsumerRegistrationImpl.class,
					consumerRegistration.getPrimaryKey()) == null) {

				cacheResult(consumerRegistration);
			}
			else {
				consumerRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all consumer registrations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ConsumerRegistrationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the consumer registration.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ConsumerRegistration consumerRegistration) {
		entityCache.removeResult(
			entityCacheEnabled, ConsumerRegistrationImpl.class,
			consumerRegistration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(ConsumerRegistrationModelImpl)consumerRegistration, true);
	}

	@Override
	public void clearCache(List<ConsumerRegistration> consumerRegistrations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ConsumerRegistration consumerRegistration :
				consumerRegistrations) {

			entityCache.removeResult(
				entityCacheEnabled, ConsumerRegistrationImpl.class,
				consumerRegistration.getPrimaryKey());

			clearUniqueFindersCache(
				(ConsumerRegistrationModelImpl)consumerRegistration, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, ConsumerRegistrationImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ConsumerRegistrationModelImpl consumerRegistrationModelImpl) {

		Object[] args = new Object[] {
			consumerRegistrationModelImpl.getConsumerId(),
			consumerRegistrationModelImpl.getSupportedDocumentType()
		};

		finderCache.putResult(
			_finderPathCountByConsumerIdSupportedDocumentType, args,
			Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByConsumerIdSupportedDocumentType, args,
			consumerRegistrationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ConsumerRegistrationModelImpl consumerRegistrationModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				consumerRegistrationModelImpl.getConsumerId(),
				consumerRegistrationModelImpl.getSupportedDocumentType()
			};

			finderCache.removeResult(
				_finderPathCountByConsumerIdSupportedDocumentType, args);
			finderCache.removeResult(
				_finderPathFetchByConsumerIdSupportedDocumentType, args);
		}

		if ((consumerRegistrationModelImpl.getColumnBitmask() &
			 _finderPathFetchByConsumerIdSupportedDocumentType.
				 getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				consumerRegistrationModelImpl.getOriginalConsumerId(),
				consumerRegistrationModelImpl.getOriginalSupportedDocumentType()
			};

			finderCache.removeResult(
				_finderPathCountByConsumerIdSupportedDocumentType, args);
			finderCache.removeResult(
				_finderPathFetchByConsumerIdSupportedDocumentType, args);
		}
	}

	/**
	 * Creates a new consumer registration with the primary key. Does not add the consumer registration to the database.
	 *
	 * @param registrationId the primary key for the new consumer registration
	 * @return the new consumer registration
	 */
	@Override
	public ConsumerRegistration create(long registrationId) {
		ConsumerRegistration consumerRegistration =
			new ConsumerRegistrationImpl();

		consumerRegistration.setNew(true);
		consumerRegistration.setPrimaryKey(registrationId);

		return consumerRegistration;
	}

	/**
	 * Removes the consumer registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param registrationId the primary key of the consumer registration
	 * @return the consumer registration that was removed
	 * @throws NoSuchConsumerRegistrationException if a consumer registration with the primary key could not be found
	 */
	@Override
	public ConsumerRegistration remove(long registrationId)
		throws NoSuchConsumerRegistrationException {

		return remove((Serializable)registrationId);
	}

	/**
	 * Removes the consumer registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the consumer registration
	 * @return the consumer registration that was removed
	 * @throws NoSuchConsumerRegistrationException if a consumer registration with the primary key could not be found
	 */
	@Override
	public ConsumerRegistration remove(Serializable primaryKey)
		throws NoSuchConsumerRegistrationException {

		Session session = null;

		try {
			session = openSession();

			ConsumerRegistration consumerRegistration =
				(ConsumerRegistration)session.get(
					ConsumerRegistrationImpl.class, primaryKey);

			if (consumerRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchConsumerRegistrationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(consumerRegistration);
		}
		catch (NoSuchConsumerRegistrationException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ConsumerRegistration removeImpl(
		ConsumerRegistration consumerRegistration) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(consumerRegistration)) {
				consumerRegistration = (ConsumerRegistration)session.get(
					ConsumerRegistrationImpl.class,
					consumerRegistration.getPrimaryKeyObj());
			}

			if (consumerRegistration != null) {
				session.delete(consumerRegistration);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (consumerRegistration != null) {
			clearCache(consumerRegistration);
		}

		return consumerRegistration;
	}

	@Override
	public ConsumerRegistration updateImpl(
		ConsumerRegistration consumerRegistration) {

		boolean isNew = consumerRegistration.isNew();

		if (!(consumerRegistration instanceof ConsumerRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(consumerRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					consumerRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in consumerRegistration proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ConsumerRegistration implementation " +
					consumerRegistration.getClass());
		}

		ConsumerRegistrationModelImpl consumerRegistrationModelImpl =
			(ConsumerRegistrationModelImpl)consumerRegistration;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(consumerRegistration);

				consumerRegistration.setNew(false);
			}
			else {
				consumerRegistration = (ConsumerRegistration)session.merge(
					consumerRegistration);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				consumerRegistrationModelImpl.getConsumerId()
			};

			finderCache.removeResult(_finderPathCountByConsumerId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByConsumerId, args);

			args = new Object[] {
				consumerRegistrationModelImpl.getConsumerName(),
				consumerRegistrationModelImpl.getSupportedDocumentType()
			};

			finderCache.removeResult(
				_finderPathCountByConsumerNameSupportedDocumentType, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByConsumerNameSupportedDocumentType,
				args);

			args = new Object[] {
				consumerRegistrationModelImpl.getConsumerName()
			};

			finderCache.removeResult(_finderPathCountByConsumerName, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByConsumerName, args);

			args = new Object[] {
				consumerRegistrationModelImpl.getSupportedDocumentType()
			};

			finderCache.removeResult(
				_finderPathCountBySupportedDocumentType, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBySupportedDocumentType, args);

			args = new Object[] {
				consumerRegistrationModelImpl.getConsumerStatus()
			};

			finderCache.removeResult(_finderPathCountByConsumerStatus, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByConsumerStatus, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((consumerRegistrationModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByConsumerId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					consumerRegistrationModelImpl.getOriginalConsumerId()
				};

				finderCache.removeResult(_finderPathCountByConsumerId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByConsumerId, args);

				args = new Object[] {
					consumerRegistrationModelImpl.getConsumerId()
				};

				finderCache.removeResult(_finderPathCountByConsumerId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByConsumerId, args);
			}

			if ((consumerRegistrationModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByConsumerNameSupportedDocumentType.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					consumerRegistrationModelImpl.getOriginalConsumerName(),
					consumerRegistrationModelImpl.
						getOriginalSupportedDocumentType()
				};

				finderCache.removeResult(
					_finderPathCountByConsumerNameSupportedDocumentType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByConsumerNameSupportedDocumentType,
					args);

				args = new Object[] {
					consumerRegistrationModelImpl.getConsumerName(),
					consumerRegistrationModelImpl.getSupportedDocumentType()
				};

				finderCache.removeResult(
					_finderPathCountByConsumerNameSupportedDocumentType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByConsumerNameSupportedDocumentType,
					args);
			}

			if ((consumerRegistrationModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByConsumerName.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					consumerRegistrationModelImpl.getOriginalConsumerName()
				};

				finderCache.removeResult(_finderPathCountByConsumerName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByConsumerName, args);

				args = new Object[] {
					consumerRegistrationModelImpl.getConsumerName()
				};

				finderCache.removeResult(_finderPathCountByConsumerName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByConsumerName, args);
			}

			if ((consumerRegistrationModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBySupportedDocumentType.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					consumerRegistrationModelImpl.
						getOriginalSupportedDocumentType()
				};

				finderCache.removeResult(
					_finderPathCountBySupportedDocumentType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySupportedDocumentType,
					args);

				args = new Object[] {
					consumerRegistrationModelImpl.getSupportedDocumentType()
				};

				finderCache.removeResult(
					_finderPathCountBySupportedDocumentType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySupportedDocumentType,
					args);
			}

			if ((consumerRegistrationModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByConsumerStatus.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					consumerRegistrationModelImpl.getOriginalConsumerStatus()
				};

				finderCache.removeResult(
					_finderPathCountByConsumerStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByConsumerStatus, args);

				args = new Object[] {
					consumerRegistrationModelImpl.getConsumerStatus()
				};

				finderCache.removeResult(
					_finderPathCountByConsumerStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByConsumerStatus, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, ConsumerRegistrationImpl.class,
			consumerRegistration.getPrimaryKey(), consumerRegistration, false);

		clearUniqueFindersCache(consumerRegistrationModelImpl, false);
		cacheUniqueFindersCache(consumerRegistrationModelImpl);

		consumerRegistration.resetOriginalValues();

		return consumerRegistration;
	}

	/**
	 * Returns the consumer registration with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the consumer registration
	 * @return the consumer registration
	 * @throws NoSuchConsumerRegistrationException if a consumer registration with the primary key could not be found
	 */
	@Override
	public ConsumerRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchConsumerRegistrationException {

		ConsumerRegistration consumerRegistration = fetchByPrimaryKey(
			primaryKey);

		if (consumerRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchConsumerRegistrationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return consumerRegistration;
	}

	/**
	 * Returns the consumer registration with the primary key or throws a <code>NoSuchConsumerRegistrationException</code> if it could not be found.
	 *
	 * @param registrationId the primary key of the consumer registration
	 * @return the consumer registration
	 * @throws NoSuchConsumerRegistrationException if a consumer registration with the primary key could not be found
	 */
	@Override
	public ConsumerRegistration findByPrimaryKey(long registrationId)
		throws NoSuchConsumerRegistrationException {

		return findByPrimaryKey((Serializable)registrationId);
	}

	/**
	 * Returns the consumer registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param registrationId the primary key of the consumer registration
	 * @return the consumer registration, or <code>null</code> if a consumer registration with the primary key could not be found
	 */
	@Override
	public ConsumerRegistration fetchByPrimaryKey(long registrationId) {
		return fetchByPrimaryKey((Serializable)registrationId);
	}

	/**
	 * Returns all the consumer registrations.
	 *
	 * @return the consumer registrations
	 */
	@Override
	public List<ConsumerRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ConsumerRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<ConsumerRegistration> findAll(
		int start, int end,
		OrderByComparator<ConsumerRegistration> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<ConsumerRegistration> findAll(
		int start, int end,
		OrderByComparator<ConsumerRegistration> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<ConsumerRegistration> list = null;

		if (useFinderCache) {
			list = (List<ConsumerRegistration>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CONSUMERREGISTRATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CONSUMERREGISTRATION;

				sql = sql.concat(ConsumerRegistrationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ConsumerRegistration>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the consumer registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ConsumerRegistration consumerRegistration : findAll()) {
			remove(consumerRegistration);
		}
	}

	/**
	 * Returns the number of consumer registrations.
	 *
	 * @return the number of consumer registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_CONSUMERREGISTRATION);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "registrationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CONSUMERREGISTRATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ConsumerRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the consumer registration persistence.
	 */
	@Activate
	public void activate() {
		ConsumerRegistrationModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ConsumerRegistrationModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			ConsumerRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			ConsumerRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByConsumerId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			ConsumerRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByConsumerId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByConsumerId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			ConsumerRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByConsumerId",
			new String[] {String.class.getName()},
			ConsumerRegistrationModelImpl.CONSUMERID_COLUMN_BITMASK);

		_finderPathCountByConsumerId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByConsumerId",
			new String[] {String.class.getName()});

		_finderPathFetchByConsumerIdSupportedDocumentType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			ConsumerRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByConsumerIdSupportedDocumentType",
			new String[] {String.class.getName(), String.class.getName()},
			ConsumerRegistrationModelImpl.CONSUMERID_COLUMN_BITMASK |
			ConsumerRegistrationModelImpl.SUPPORTEDDOCUMENTTYPE_COLUMN_BITMASK);

		_finderPathCountByConsumerIdSupportedDocumentType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByConsumerIdSupportedDocumentType",
			new String[] {String.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByConsumerNameSupportedDocumentType =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				ConsumerRegistrationImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByConsumerNameSupportedDocumentType",
				new String[] {
					String.class.getName(), String.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByConsumerNameSupportedDocumentType =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				ConsumerRegistrationImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByConsumerNameSupportedDocumentType",
				new String[] {String.class.getName(), String.class.getName()},
				ConsumerRegistrationModelImpl.CONSUMERNAME_COLUMN_BITMASK |
				ConsumerRegistrationModelImpl.
					SUPPORTEDDOCUMENTTYPE_COLUMN_BITMASK |
				ConsumerRegistrationModelImpl.CONSUMERID_COLUMN_BITMASK);

		_finderPathCountByConsumerNameSupportedDocumentType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByConsumerNameSupportedDocumentType",
			new String[] {String.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByConsumerName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			ConsumerRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByConsumerName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByConsumerName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			ConsumerRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByConsumerName",
			new String[] {String.class.getName()},
			ConsumerRegistrationModelImpl.CONSUMERNAME_COLUMN_BITMASK |
			ConsumerRegistrationModelImpl.CONSUMERID_COLUMN_BITMASK);

		_finderPathCountByConsumerName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByConsumerName",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindBySupportedDocumentType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			ConsumerRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBySupportedDocumentType",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBySupportedDocumentType =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				ConsumerRegistrationImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBySupportedDocumentType",
				new String[] {String.class.getName()},
				ConsumerRegistrationModelImpl.
					SUPPORTEDDOCUMENTTYPE_COLUMN_BITMASK |
				ConsumerRegistrationModelImpl.CONSUMERID_COLUMN_BITMASK);

		_finderPathCountBySupportedDocumentType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySupportedDocumentType",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByConsumerStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			ConsumerRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByConsumerStatus",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByConsumerStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			ConsumerRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByConsumerStatus",
			new String[] {String.class.getName()},
			ConsumerRegistrationModelImpl.CONSUMERSTATUS_COLUMN_BITMASK |
			ConsumerRegistrationModelImpl.CONSUMERID_COLUMN_BITMASK);

		_finderPathCountByConsumerStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByConsumerStatus",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ConsumerRegistrationImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = dmsPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.moi.dms.consumer.registration.model.ConsumerRegistration"),
			true);
	}

	@Override
	@Reference(
		target = dmsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = dmsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CONSUMERREGISTRATION =
		"SELECT consumerRegistration FROM ConsumerRegistration consumerRegistration";

	private static final String _SQL_SELECT_CONSUMERREGISTRATION_WHERE =
		"SELECT consumerRegistration FROM ConsumerRegistration consumerRegistration WHERE ";

	private static final String _SQL_COUNT_CONSUMERREGISTRATION =
		"SELECT COUNT(consumerRegistration) FROM ConsumerRegistration consumerRegistration";

	private static final String _SQL_COUNT_CONSUMERREGISTRATION_WHERE =
		"SELECT COUNT(consumerRegistration) FROM ConsumerRegistration consumerRegistration WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"consumerRegistration.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ConsumerRegistration exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ConsumerRegistration exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ConsumerRegistrationPersistenceImpl.class);

	static {
		try {
			Class.forName(dmsPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}