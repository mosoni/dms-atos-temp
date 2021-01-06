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

package com.moi.dms.trace.request.service.persistence.impl;

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
import com.liferay.portal.kernel.util.SetUtil;

import com.moi.dms.trace.request.exception.NoSuchMOITraceRequestException;
import com.moi.dms.trace.request.model.MOITraceRequest;
import com.moi.dms.trace.request.model.impl.MOITraceRequestImpl;
import com.moi.dms.trace.request.model.impl.MOITraceRequestModelImpl;
import com.moi.dms.trace.request.service.persistence.MOITraceRequestPersistence;
import com.moi.dms.trace.request.service.persistence.impl.constants.moitrPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Date;
import java.util.HashMap;
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
 * The persistence implementation for the moi trace request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = MOITraceRequestPersistence.class)
public class MOITraceRequestPersistenceImpl
	extends BasePersistenceImpl<MOITraceRequest>
	implements MOITraceRequestPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MOITraceRequestUtil</code> to access the moi trace request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MOITraceRequestImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByRequestId;
	private FinderPath _finderPathWithoutPaginationFindByRequestId;
	private FinderPath _finderPathCountByRequestId;

	/**
	 * Returns all the moi trace requests where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @return the matching moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findByRequestId(long requestId) {
		return findByRequestId(
			requestId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the moi trace requests where requestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOITraceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param requestId the request ID
	 * @param start the lower bound of the range of moi trace requests
	 * @param end the upper bound of the range of moi trace requests (not inclusive)
	 * @return the range of matching moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findByRequestId(
		long requestId, int start, int end) {

		return findByRequestId(requestId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the moi trace requests where requestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOITraceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param requestId the request ID
	 * @param start the lower bound of the range of moi trace requests
	 * @param end the upper bound of the range of moi trace requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findByRequestId(
		long requestId, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return findByRequestId(requestId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the moi trace requests where requestId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOITraceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param requestId the request ID
	 * @param start the lower bound of the range of moi trace requests
	 * @param end the upper bound of the range of moi trace requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findByRequestId(
		long requestId, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByRequestId;
				finderArgs = new Object[] {requestId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByRequestId;
			finderArgs = new Object[] {
				requestId, start, end, orderByComparator
			};
		}

		List<MOITraceRequest> list = null;

		if (useFinderCache) {
			list = (List<MOITraceRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOITraceRequest moiTraceRequest : list) {
					if (requestId != moiTraceRequest.getRequestId()) {
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

			sb.append(_SQL_SELECT_MOITRACEREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_REQUESTID_REQUESTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOITraceRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(requestId);

				list = (List<MOITraceRequest>)QueryUtil.list(
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
	 * Returns the first moi trace request in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	@Override
	public MOITraceRequest findByRequestId_First(
			long requestId,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws NoSuchMOITraceRequestException {

		MOITraceRequest moiTraceRequest = fetchByRequestId_First(
			requestId, orderByComparator);

		if (moiTraceRequest != null) {
			return moiTraceRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("requestId=");
		sb.append(requestId);

		sb.append("}");

		throw new NoSuchMOITraceRequestException(sb.toString());
	}

	/**
	 * Returns the first moi trace request in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	@Override
	public MOITraceRequest fetchByRequestId_First(
		long requestId, OrderByComparator<MOITraceRequest> orderByComparator) {

		List<MOITraceRequest> list = findByRequestId(
			requestId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi trace request in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	@Override
	public MOITraceRequest findByRequestId_Last(
			long requestId,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws NoSuchMOITraceRequestException {

		MOITraceRequest moiTraceRequest = fetchByRequestId_Last(
			requestId, orderByComparator);

		if (moiTraceRequest != null) {
			return moiTraceRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("requestId=");
		sb.append(requestId);

		sb.append("}");

		throw new NoSuchMOITraceRequestException(sb.toString());
	}

	/**
	 * Returns the last moi trace request in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	@Override
	public MOITraceRequest fetchByRequestId_Last(
		long requestId, OrderByComparator<MOITraceRequest> orderByComparator) {

		int count = countByRequestId(requestId);

		if (count == 0) {
			return null;
		}

		List<MOITraceRequest> list = findByRequestId(
			requestId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the moi trace requests where requestId = &#63; from the database.
	 *
	 * @param requestId the request ID
	 */
	@Override
	public void removeByRequestId(long requestId) {
		for (MOITraceRequest moiTraceRequest :
				findByRequestId(
					requestId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(moiTraceRequest);
		}
	}

	/**
	 * Returns the number of moi trace requests where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @return the number of matching moi trace requests
	 */
	@Override
	public int countByRequestId(long requestId) {
		FinderPath finderPath = _finderPathCountByRequestId;

		Object[] finderArgs = new Object[] {requestId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOITRACEREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_REQUESTID_REQUESTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(requestId);

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

	private static final String _FINDER_COLUMN_REQUESTID_REQUESTID_2 =
		"moiTraceRequest.requestId = ?";

	private FinderPath _finderPathWithPaginationFindByRequestedBy;
	private FinderPath _finderPathWithoutPaginationFindByRequestedBy;
	private FinderPath _finderPathCountByRequestedBy;

	/**
	 * Returns all the moi trace requests where requestedBy = &#63;.
	 *
	 * @param requestedBy the requested by
	 * @return the matching moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findByRequestedBy(String requestedBy) {
		return findByRequestedBy(
			requestedBy, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the moi trace requests where requestedBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOITraceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param requestedBy the requested by
	 * @param start the lower bound of the range of moi trace requests
	 * @param end the upper bound of the range of moi trace requests (not inclusive)
	 * @return the range of matching moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findByRequestedBy(
		String requestedBy, int start, int end) {

		return findByRequestedBy(requestedBy, start, end, null);
	}

	/**
	 * Returns an ordered range of all the moi trace requests where requestedBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOITraceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param requestedBy the requested by
	 * @param start the lower bound of the range of moi trace requests
	 * @param end the upper bound of the range of moi trace requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findByRequestedBy(
		String requestedBy, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return findByRequestedBy(
			requestedBy, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the moi trace requests where requestedBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOITraceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param requestedBy the requested by
	 * @param start the lower bound of the range of moi trace requests
	 * @param end the upper bound of the range of moi trace requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findByRequestedBy(
		String requestedBy, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator,
		boolean useFinderCache) {

		requestedBy = Objects.toString(requestedBy, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByRequestedBy;
				finderArgs = new Object[] {requestedBy};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByRequestedBy;
			finderArgs = new Object[] {
				requestedBy, start, end, orderByComparator
			};
		}

		List<MOITraceRequest> list = null;

		if (useFinderCache) {
			list = (List<MOITraceRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOITraceRequest moiTraceRequest : list) {
					if (!requestedBy.equals(moiTraceRequest.getRequestedBy())) {
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

			sb.append(_SQL_SELECT_MOITRACEREQUEST_WHERE);

			boolean bindRequestedBy = false;

			if (requestedBy.isEmpty()) {
				sb.append(_FINDER_COLUMN_REQUESTEDBY_REQUESTEDBY_3);
			}
			else {
				bindRequestedBy = true;

				sb.append(_FINDER_COLUMN_REQUESTEDBY_REQUESTEDBY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOITraceRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRequestedBy) {
					queryPos.add(requestedBy);
				}

				list = (List<MOITraceRequest>)QueryUtil.list(
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
	 * Returns the first moi trace request in the ordered set where requestedBy = &#63;.
	 *
	 * @param requestedBy the requested by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	@Override
	public MOITraceRequest findByRequestedBy_First(
			String requestedBy,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws NoSuchMOITraceRequestException {

		MOITraceRequest moiTraceRequest = fetchByRequestedBy_First(
			requestedBy, orderByComparator);

		if (moiTraceRequest != null) {
			return moiTraceRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("requestedBy=");
		sb.append(requestedBy);

		sb.append("}");

		throw new NoSuchMOITraceRequestException(sb.toString());
	}

	/**
	 * Returns the first moi trace request in the ordered set where requestedBy = &#63;.
	 *
	 * @param requestedBy the requested by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	@Override
	public MOITraceRequest fetchByRequestedBy_First(
		String requestedBy,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		List<MOITraceRequest> list = findByRequestedBy(
			requestedBy, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi trace request in the ordered set where requestedBy = &#63;.
	 *
	 * @param requestedBy the requested by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	@Override
	public MOITraceRequest findByRequestedBy_Last(
			String requestedBy,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws NoSuchMOITraceRequestException {

		MOITraceRequest moiTraceRequest = fetchByRequestedBy_Last(
			requestedBy, orderByComparator);

		if (moiTraceRequest != null) {
			return moiTraceRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("requestedBy=");
		sb.append(requestedBy);

		sb.append("}");

		throw new NoSuchMOITraceRequestException(sb.toString());
	}

	/**
	 * Returns the last moi trace request in the ordered set where requestedBy = &#63;.
	 *
	 * @param requestedBy the requested by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	@Override
	public MOITraceRequest fetchByRequestedBy_Last(
		String requestedBy,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		int count = countByRequestedBy(requestedBy);

		if (count == 0) {
			return null;
		}

		List<MOITraceRequest> list = findByRequestedBy(
			requestedBy, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the moi trace requests before and after the current moi trace request in the ordered set where requestedBy = &#63;.
	 *
	 * @param requestId the primary key of the current moi trace request
	 * @param requestedBy the requested by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi trace request
	 * @throws NoSuchMOITraceRequestException if a moi trace request with the primary key could not be found
	 */
	@Override
	public MOITraceRequest[] findByRequestedBy_PrevAndNext(
			long requestId, String requestedBy,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws NoSuchMOITraceRequestException {

		requestedBy = Objects.toString(requestedBy, "");

		MOITraceRequest moiTraceRequest = findByPrimaryKey(requestId);

		Session session = null;

		try {
			session = openSession();

			MOITraceRequest[] array = new MOITraceRequestImpl[3];

			array[0] = getByRequestedBy_PrevAndNext(
				session, moiTraceRequest, requestedBy, orderByComparator, true);

			array[1] = moiTraceRequest;

			array[2] = getByRequestedBy_PrevAndNext(
				session, moiTraceRequest, requestedBy, orderByComparator,
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

	protected MOITraceRequest getByRequestedBy_PrevAndNext(
		Session session, MOITraceRequest moiTraceRequest, String requestedBy,
		OrderByComparator<MOITraceRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_MOITRACEREQUEST_WHERE);

		boolean bindRequestedBy = false;

		if (requestedBy.isEmpty()) {
			sb.append(_FINDER_COLUMN_REQUESTEDBY_REQUESTEDBY_3);
		}
		else {
			bindRequestedBy = true;

			sb.append(_FINDER_COLUMN_REQUESTEDBY_REQUESTEDBY_2);
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
			sb.append(MOITraceRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindRequestedBy) {
			queryPos.add(requestedBy);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						moiTraceRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MOITraceRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the moi trace requests where requestedBy = &#63; from the database.
	 *
	 * @param requestedBy the requested by
	 */
	@Override
	public void removeByRequestedBy(String requestedBy) {
		for (MOITraceRequest moiTraceRequest :
				findByRequestedBy(
					requestedBy, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(moiTraceRequest);
		}
	}

	/**
	 * Returns the number of moi trace requests where requestedBy = &#63;.
	 *
	 * @param requestedBy the requested by
	 * @return the number of matching moi trace requests
	 */
	@Override
	public int countByRequestedBy(String requestedBy) {
		requestedBy = Objects.toString(requestedBy, "");

		FinderPath finderPath = _finderPathCountByRequestedBy;

		Object[] finderArgs = new Object[] {requestedBy};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOITRACEREQUEST_WHERE);

			boolean bindRequestedBy = false;

			if (requestedBy.isEmpty()) {
				sb.append(_FINDER_COLUMN_REQUESTEDBY_REQUESTEDBY_3);
			}
			else {
				bindRequestedBy = true;

				sb.append(_FINDER_COLUMN_REQUESTEDBY_REQUESTEDBY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRequestedBy) {
					queryPos.add(requestedBy);
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

	private static final String _FINDER_COLUMN_REQUESTEDBY_REQUESTEDBY_2 =
		"moiTraceRequest.requestedBy = ?";

	private static final String _FINDER_COLUMN_REQUESTEDBY_REQUESTEDBY_3 =
		"(moiTraceRequest.requestedBy IS NULL OR moiTraceRequest.requestedBy = '')";

	private FinderPath _finderPathWithPaginationFindByRequestIncomingDate;
	private FinderPath _finderPathWithoutPaginationFindByRequestIncomingDate;
	private FinderPath _finderPathCountByRequestIncomingDate;

	/**
	 * Returns all the moi trace requests where requestIncomingDate = &#63;.
	 *
	 * @param requestIncomingDate the request incoming date
	 * @return the matching moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findByRequestIncomingDate(
		Date requestIncomingDate) {

		return findByRequestIncomingDate(
			requestIncomingDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the moi trace requests where requestIncomingDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOITraceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param requestIncomingDate the request incoming date
	 * @param start the lower bound of the range of moi trace requests
	 * @param end the upper bound of the range of moi trace requests (not inclusive)
	 * @return the range of matching moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findByRequestIncomingDate(
		Date requestIncomingDate, int start, int end) {

		return findByRequestIncomingDate(requestIncomingDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the moi trace requests where requestIncomingDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOITraceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param requestIncomingDate the request incoming date
	 * @param start the lower bound of the range of moi trace requests
	 * @param end the upper bound of the range of moi trace requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findByRequestIncomingDate(
		Date requestIncomingDate, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return findByRequestIncomingDate(
			requestIncomingDate, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the moi trace requests where requestIncomingDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOITraceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param requestIncomingDate the request incoming date
	 * @param start the lower bound of the range of moi trace requests
	 * @param end the upper bound of the range of moi trace requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findByRequestIncomingDate(
		Date requestIncomingDate, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByRequestIncomingDate;
				finderArgs = new Object[] {_getTime(requestIncomingDate)};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByRequestIncomingDate;
			finderArgs = new Object[] {
				_getTime(requestIncomingDate), start, end, orderByComparator
			};
		}

		List<MOITraceRequest> list = null;

		if (useFinderCache) {
			list = (List<MOITraceRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOITraceRequest moiTraceRequest : list) {
					if (!Objects.equals(
							requestIncomingDate,
							moiTraceRequest.getRequestIncomingDate())) {

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

			sb.append(_SQL_SELECT_MOITRACEREQUEST_WHERE);

			boolean bindRequestIncomingDate = false;

			if (requestIncomingDate == null) {
				sb.append(
					_FINDER_COLUMN_REQUESTINCOMINGDATE_REQUESTINCOMINGDATE_1);
			}
			else {
				bindRequestIncomingDate = true;

				sb.append(
					_FINDER_COLUMN_REQUESTINCOMINGDATE_REQUESTINCOMINGDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOITraceRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRequestIncomingDate) {
					queryPos.add(new Timestamp(requestIncomingDate.getTime()));
				}

				list = (List<MOITraceRequest>)QueryUtil.list(
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
	 * Returns the first moi trace request in the ordered set where requestIncomingDate = &#63;.
	 *
	 * @param requestIncomingDate the request incoming date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	@Override
	public MOITraceRequest findByRequestIncomingDate_First(
			Date requestIncomingDate,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws NoSuchMOITraceRequestException {

		MOITraceRequest moiTraceRequest = fetchByRequestIncomingDate_First(
			requestIncomingDate, orderByComparator);

		if (moiTraceRequest != null) {
			return moiTraceRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("requestIncomingDate=");
		sb.append(requestIncomingDate);

		sb.append("}");

		throw new NoSuchMOITraceRequestException(sb.toString());
	}

	/**
	 * Returns the first moi trace request in the ordered set where requestIncomingDate = &#63;.
	 *
	 * @param requestIncomingDate the request incoming date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	@Override
	public MOITraceRequest fetchByRequestIncomingDate_First(
		Date requestIncomingDate,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		List<MOITraceRequest> list = findByRequestIncomingDate(
			requestIncomingDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi trace request in the ordered set where requestIncomingDate = &#63;.
	 *
	 * @param requestIncomingDate the request incoming date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	@Override
	public MOITraceRequest findByRequestIncomingDate_Last(
			Date requestIncomingDate,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws NoSuchMOITraceRequestException {

		MOITraceRequest moiTraceRequest = fetchByRequestIncomingDate_Last(
			requestIncomingDate, orderByComparator);

		if (moiTraceRequest != null) {
			return moiTraceRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("requestIncomingDate=");
		sb.append(requestIncomingDate);

		sb.append("}");

		throw new NoSuchMOITraceRequestException(sb.toString());
	}

	/**
	 * Returns the last moi trace request in the ordered set where requestIncomingDate = &#63;.
	 *
	 * @param requestIncomingDate the request incoming date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	@Override
	public MOITraceRequest fetchByRequestIncomingDate_Last(
		Date requestIncomingDate,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		int count = countByRequestIncomingDate(requestIncomingDate);

		if (count == 0) {
			return null;
		}

		List<MOITraceRequest> list = findByRequestIncomingDate(
			requestIncomingDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the moi trace requests before and after the current moi trace request in the ordered set where requestIncomingDate = &#63;.
	 *
	 * @param requestId the primary key of the current moi trace request
	 * @param requestIncomingDate the request incoming date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi trace request
	 * @throws NoSuchMOITraceRequestException if a moi trace request with the primary key could not be found
	 */
	@Override
	public MOITraceRequest[] findByRequestIncomingDate_PrevAndNext(
			long requestId, Date requestIncomingDate,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws NoSuchMOITraceRequestException {

		MOITraceRequest moiTraceRequest = findByPrimaryKey(requestId);

		Session session = null;

		try {
			session = openSession();

			MOITraceRequest[] array = new MOITraceRequestImpl[3];

			array[0] = getByRequestIncomingDate_PrevAndNext(
				session, moiTraceRequest, requestIncomingDate,
				orderByComparator, true);

			array[1] = moiTraceRequest;

			array[2] = getByRequestIncomingDate_PrevAndNext(
				session, moiTraceRequest, requestIncomingDate,
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

	protected MOITraceRequest getByRequestIncomingDate_PrevAndNext(
		Session session, MOITraceRequest moiTraceRequest,
		Date requestIncomingDate,
		OrderByComparator<MOITraceRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_MOITRACEREQUEST_WHERE);

		boolean bindRequestIncomingDate = false;

		if (requestIncomingDate == null) {
			sb.append(_FINDER_COLUMN_REQUESTINCOMINGDATE_REQUESTINCOMINGDATE_1);
		}
		else {
			bindRequestIncomingDate = true;

			sb.append(_FINDER_COLUMN_REQUESTINCOMINGDATE_REQUESTINCOMINGDATE_2);
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
			sb.append(MOITraceRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindRequestIncomingDate) {
			queryPos.add(new Timestamp(requestIncomingDate.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						moiTraceRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MOITraceRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the moi trace requests where requestIncomingDate = &#63; from the database.
	 *
	 * @param requestIncomingDate the request incoming date
	 */
	@Override
	public void removeByRequestIncomingDate(Date requestIncomingDate) {
		for (MOITraceRequest moiTraceRequest :
				findByRequestIncomingDate(
					requestIncomingDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(moiTraceRequest);
		}
	}

	/**
	 * Returns the number of moi trace requests where requestIncomingDate = &#63;.
	 *
	 * @param requestIncomingDate the request incoming date
	 * @return the number of matching moi trace requests
	 */
	@Override
	public int countByRequestIncomingDate(Date requestIncomingDate) {
		FinderPath finderPath = _finderPathCountByRequestIncomingDate;

		Object[] finderArgs = new Object[] {_getTime(requestIncomingDate)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOITRACEREQUEST_WHERE);

			boolean bindRequestIncomingDate = false;

			if (requestIncomingDate == null) {
				sb.append(
					_FINDER_COLUMN_REQUESTINCOMINGDATE_REQUESTINCOMINGDATE_1);
			}
			else {
				bindRequestIncomingDate = true;

				sb.append(
					_FINDER_COLUMN_REQUESTINCOMINGDATE_REQUESTINCOMINGDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRequestIncomingDate) {
					queryPos.add(new Timestamp(requestIncomingDate.getTime()));
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
		_FINDER_COLUMN_REQUESTINCOMINGDATE_REQUESTINCOMINGDATE_1 =
			"moiTraceRequest.requestIncomingDate IS NULL";

	private static final String
		_FINDER_COLUMN_REQUESTINCOMINGDATE_REQUESTINCOMINGDATE_2 =
			"moiTraceRequest.requestIncomingDate = ?";

	private FinderPath _finderPathWithPaginationFindByRequestedConsumerCode;
	private FinderPath _finderPathWithoutPaginationFindByRequestedConsumerCode;
	private FinderPath _finderPathCountByRequestedConsumerCode;

	/**
	 * Returns all the moi trace requests where requestedConsumerCode = &#63;.
	 *
	 * @param requestedConsumerCode the requested consumer code
	 * @return the matching moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findByRequestedConsumerCode(
		String requestedConsumerCode) {

		return findByRequestedConsumerCode(
			requestedConsumerCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the moi trace requests where requestedConsumerCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOITraceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param requestedConsumerCode the requested consumer code
	 * @param start the lower bound of the range of moi trace requests
	 * @param end the upper bound of the range of moi trace requests (not inclusive)
	 * @return the range of matching moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findByRequestedConsumerCode(
		String requestedConsumerCode, int start, int end) {

		return findByRequestedConsumerCode(
			requestedConsumerCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the moi trace requests where requestedConsumerCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOITraceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param requestedConsumerCode the requested consumer code
	 * @param start the lower bound of the range of moi trace requests
	 * @param end the upper bound of the range of moi trace requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findByRequestedConsumerCode(
		String requestedConsumerCode, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return findByRequestedConsumerCode(
			requestedConsumerCode, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the moi trace requests where requestedConsumerCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOITraceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param requestedConsumerCode the requested consumer code
	 * @param start the lower bound of the range of moi trace requests
	 * @param end the upper bound of the range of moi trace requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findByRequestedConsumerCode(
		String requestedConsumerCode, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator,
		boolean useFinderCache) {

		requestedConsumerCode = Objects.toString(requestedConsumerCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByRequestedConsumerCode;
				finderArgs = new Object[] {requestedConsumerCode};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByRequestedConsumerCode;
			finderArgs = new Object[] {
				requestedConsumerCode, start, end, orderByComparator
			};
		}

		List<MOITraceRequest> list = null;

		if (useFinderCache) {
			list = (List<MOITraceRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOITraceRequest moiTraceRequest : list) {
					if (!requestedConsumerCode.equals(
							moiTraceRequest.getRequestedConsumerCode())) {

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

			sb.append(_SQL_SELECT_MOITRACEREQUEST_WHERE);

			boolean bindRequestedConsumerCode = false;

			if (requestedConsumerCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_REQUESTEDCONSUMERCODE_REQUESTEDCONSUMERCODE_3);
			}
			else {
				bindRequestedConsumerCode = true;

				sb.append(
					_FINDER_COLUMN_REQUESTEDCONSUMERCODE_REQUESTEDCONSUMERCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOITraceRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRequestedConsumerCode) {
					queryPos.add(requestedConsumerCode);
				}

				list = (List<MOITraceRequest>)QueryUtil.list(
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
	 * Returns the first moi trace request in the ordered set where requestedConsumerCode = &#63;.
	 *
	 * @param requestedConsumerCode the requested consumer code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	@Override
	public MOITraceRequest findByRequestedConsumerCode_First(
			String requestedConsumerCode,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws NoSuchMOITraceRequestException {

		MOITraceRequest moiTraceRequest = fetchByRequestedConsumerCode_First(
			requestedConsumerCode, orderByComparator);

		if (moiTraceRequest != null) {
			return moiTraceRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("requestedConsumerCode=");
		sb.append(requestedConsumerCode);

		sb.append("}");

		throw new NoSuchMOITraceRequestException(sb.toString());
	}

	/**
	 * Returns the first moi trace request in the ordered set where requestedConsumerCode = &#63;.
	 *
	 * @param requestedConsumerCode the requested consumer code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	@Override
	public MOITraceRequest fetchByRequestedConsumerCode_First(
		String requestedConsumerCode,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		List<MOITraceRequest> list = findByRequestedConsumerCode(
			requestedConsumerCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi trace request in the ordered set where requestedConsumerCode = &#63;.
	 *
	 * @param requestedConsumerCode the requested consumer code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	@Override
	public MOITraceRequest findByRequestedConsumerCode_Last(
			String requestedConsumerCode,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws NoSuchMOITraceRequestException {

		MOITraceRequest moiTraceRequest = fetchByRequestedConsumerCode_Last(
			requestedConsumerCode, orderByComparator);

		if (moiTraceRequest != null) {
			return moiTraceRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("requestedConsumerCode=");
		sb.append(requestedConsumerCode);

		sb.append("}");

		throw new NoSuchMOITraceRequestException(sb.toString());
	}

	/**
	 * Returns the last moi trace request in the ordered set where requestedConsumerCode = &#63;.
	 *
	 * @param requestedConsumerCode the requested consumer code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	@Override
	public MOITraceRequest fetchByRequestedConsumerCode_Last(
		String requestedConsumerCode,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		int count = countByRequestedConsumerCode(requestedConsumerCode);

		if (count == 0) {
			return null;
		}

		List<MOITraceRequest> list = findByRequestedConsumerCode(
			requestedConsumerCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the moi trace requests before and after the current moi trace request in the ordered set where requestedConsumerCode = &#63;.
	 *
	 * @param requestId the primary key of the current moi trace request
	 * @param requestedConsumerCode the requested consumer code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi trace request
	 * @throws NoSuchMOITraceRequestException if a moi trace request with the primary key could not be found
	 */
	@Override
	public MOITraceRequest[] findByRequestedConsumerCode_PrevAndNext(
			long requestId, String requestedConsumerCode,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws NoSuchMOITraceRequestException {

		requestedConsumerCode = Objects.toString(requestedConsumerCode, "");

		MOITraceRequest moiTraceRequest = findByPrimaryKey(requestId);

		Session session = null;

		try {
			session = openSession();

			MOITraceRequest[] array = new MOITraceRequestImpl[3];

			array[0] = getByRequestedConsumerCode_PrevAndNext(
				session, moiTraceRequest, requestedConsumerCode,
				orderByComparator, true);

			array[1] = moiTraceRequest;

			array[2] = getByRequestedConsumerCode_PrevAndNext(
				session, moiTraceRequest, requestedConsumerCode,
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

	protected MOITraceRequest getByRequestedConsumerCode_PrevAndNext(
		Session session, MOITraceRequest moiTraceRequest,
		String requestedConsumerCode,
		OrderByComparator<MOITraceRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_MOITRACEREQUEST_WHERE);

		boolean bindRequestedConsumerCode = false;

		if (requestedConsumerCode.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_REQUESTEDCONSUMERCODE_REQUESTEDCONSUMERCODE_3);
		}
		else {
			bindRequestedConsumerCode = true;

			sb.append(
				_FINDER_COLUMN_REQUESTEDCONSUMERCODE_REQUESTEDCONSUMERCODE_2);
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
			sb.append(MOITraceRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindRequestedConsumerCode) {
			queryPos.add(requestedConsumerCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						moiTraceRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MOITraceRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the moi trace requests where requestedConsumerCode = &#63; from the database.
	 *
	 * @param requestedConsumerCode the requested consumer code
	 */
	@Override
	public void removeByRequestedConsumerCode(String requestedConsumerCode) {
		for (MOITraceRequest moiTraceRequest :
				findByRequestedConsumerCode(
					requestedConsumerCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(moiTraceRequest);
		}
	}

	/**
	 * Returns the number of moi trace requests where requestedConsumerCode = &#63;.
	 *
	 * @param requestedConsumerCode the requested consumer code
	 * @return the number of matching moi trace requests
	 */
	@Override
	public int countByRequestedConsumerCode(String requestedConsumerCode) {
		requestedConsumerCode = Objects.toString(requestedConsumerCode, "");

		FinderPath finderPath = _finderPathCountByRequestedConsumerCode;

		Object[] finderArgs = new Object[] {requestedConsumerCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOITRACEREQUEST_WHERE);

			boolean bindRequestedConsumerCode = false;

			if (requestedConsumerCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_REQUESTEDCONSUMERCODE_REQUESTEDCONSUMERCODE_3);
			}
			else {
				bindRequestedConsumerCode = true;

				sb.append(
					_FINDER_COLUMN_REQUESTEDCONSUMERCODE_REQUESTEDCONSUMERCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRequestedConsumerCode) {
					queryPos.add(requestedConsumerCode);
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
		_FINDER_COLUMN_REQUESTEDCONSUMERCODE_REQUESTEDCONSUMERCODE_2 =
			"moiTraceRequest.requestedConsumerCode = ?";

	private static final String
		_FINDER_COLUMN_REQUESTEDCONSUMERCODE_REQUESTEDCONSUMERCODE_3 =
			"(moiTraceRequest.requestedConsumerCode IS NULL OR moiTraceRequest.requestedConsumerCode = '')";

	private FinderPath _finderPathWithPaginationFindByRequestedConsumerName;
	private FinderPath _finderPathWithoutPaginationFindByRequestedConsumerName;
	private FinderPath _finderPathCountByRequestedConsumerName;

	/**
	 * Returns all the moi trace requests where requestedConsumerName = &#63;.
	 *
	 * @param requestedConsumerName the requested consumer name
	 * @return the matching moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findByRequestedConsumerName(
		String requestedConsumerName) {

		return findByRequestedConsumerName(
			requestedConsumerName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the moi trace requests where requestedConsumerName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOITraceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param requestedConsumerName the requested consumer name
	 * @param start the lower bound of the range of moi trace requests
	 * @param end the upper bound of the range of moi trace requests (not inclusive)
	 * @return the range of matching moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findByRequestedConsumerName(
		String requestedConsumerName, int start, int end) {

		return findByRequestedConsumerName(
			requestedConsumerName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the moi trace requests where requestedConsumerName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOITraceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param requestedConsumerName the requested consumer name
	 * @param start the lower bound of the range of moi trace requests
	 * @param end the upper bound of the range of moi trace requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findByRequestedConsumerName(
		String requestedConsumerName, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return findByRequestedConsumerName(
			requestedConsumerName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the moi trace requests where requestedConsumerName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOITraceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param requestedConsumerName the requested consumer name
	 * @param start the lower bound of the range of moi trace requests
	 * @param end the upper bound of the range of moi trace requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findByRequestedConsumerName(
		String requestedConsumerName, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator,
		boolean useFinderCache) {

		requestedConsumerName = Objects.toString(requestedConsumerName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByRequestedConsumerName;
				finderArgs = new Object[] {requestedConsumerName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByRequestedConsumerName;
			finderArgs = new Object[] {
				requestedConsumerName, start, end, orderByComparator
			};
		}

		List<MOITraceRequest> list = null;

		if (useFinderCache) {
			list = (List<MOITraceRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOITraceRequest moiTraceRequest : list) {
					if (!requestedConsumerName.equals(
							moiTraceRequest.getRequestedConsumerName())) {

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

			sb.append(_SQL_SELECT_MOITRACEREQUEST_WHERE);

			boolean bindRequestedConsumerName = false;

			if (requestedConsumerName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_REQUESTEDCONSUMERNAME_REQUESTEDCONSUMERNAME_3);
			}
			else {
				bindRequestedConsumerName = true;

				sb.append(
					_FINDER_COLUMN_REQUESTEDCONSUMERNAME_REQUESTEDCONSUMERNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOITraceRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRequestedConsumerName) {
					queryPos.add(requestedConsumerName);
				}

				list = (List<MOITraceRequest>)QueryUtil.list(
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
	 * Returns the first moi trace request in the ordered set where requestedConsumerName = &#63;.
	 *
	 * @param requestedConsumerName the requested consumer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	@Override
	public MOITraceRequest findByRequestedConsumerName_First(
			String requestedConsumerName,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws NoSuchMOITraceRequestException {

		MOITraceRequest moiTraceRequest = fetchByRequestedConsumerName_First(
			requestedConsumerName, orderByComparator);

		if (moiTraceRequest != null) {
			return moiTraceRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("requestedConsumerName=");
		sb.append(requestedConsumerName);

		sb.append("}");

		throw new NoSuchMOITraceRequestException(sb.toString());
	}

	/**
	 * Returns the first moi trace request in the ordered set where requestedConsumerName = &#63;.
	 *
	 * @param requestedConsumerName the requested consumer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	@Override
	public MOITraceRequest fetchByRequestedConsumerName_First(
		String requestedConsumerName,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		List<MOITraceRequest> list = findByRequestedConsumerName(
			requestedConsumerName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi trace request in the ordered set where requestedConsumerName = &#63;.
	 *
	 * @param requestedConsumerName the requested consumer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	@Override
	public MOITraceRequest findByRequestedConsumerName_Last(
			String requestedConsumerName,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws NoSuchMOITraceRequestException {

		MOITraceRequest moiTraceRequest = fetchByRequestedConsumerName_Last(
			requestedConsumerName, orderByComparator);

		if (moiTraceRequest != null) {
			return moiTraceRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("requestedConsumerName=");
		sb.append(requestedConsumerName);

		sb.append("}");

		throw new NoSuchMOITraceRequestException(sb.toString());
	}

	/**
	 * Returns the last moi trace request in the ordered set where requestedConsumerName = &#63;.
	 *
	 * @param requestedConsumerName the requested consumer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	@Override
	public MOITraceRequest fetchByRequestedConsumerName_Last(
		String requestedConsumerName,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		int count = countByRequestedConsumerName(requestedConsumerName);

		if (count == 0) {
			return null;
		}

		List<MOITraceRequest> list = findByRequestedConsumerName(
			requestedConsumerName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the moi trace requests before and after the current moi trace request in the ordered set where requestedConsumerName = &#63;.
	 *
	 * @param requestId the primary key of the current moi trace request
	 * @param requestedConsumerName the requested consumer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi trace request
	 * @throws NoSuchMOITraceRequestException if a moi trace request with the primary key could not be found
	 */
	@Override
	public MOITraceRequest[] findByRequestedConsumerName_PrevAndNext(
			long requestId, String requestedConsumerName,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws NoSuchMOITraceRequestException {

		requestedConsumerName = Objects.toString(requestedConsumerName, "");

		MOITraceRequest moiTraceRequest = findByPrimaryKey(requestId);

		Session session = null;

		try {
			session = openSession();

			MOITraceRequest[] array = new MOITraceRequestImpl[3];

			array[0] = getByRequestedConsumerName_PrevAndNext(
				session, moiTraceRequest, requestedConsumerName,
				orderByComparator, true);

			array[1] = moiTraceRequest;

			array[2] = getByRequestedConsumerName_PrevAndNext(
				session, moiTraceRequest, requestedConsumerName,
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

	protected MOITraceRequest getByRequestedConsumerName_PrevAndNext(
		Session session, MOITraceRequest moiTraceRequest,
		String requestedConsumerName,
		OrderByComparator<MOITraceRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_MOITRACEREQUEST_WHERE);

		boolean bindRequestedConsumerName = false;

		if (requestedConsumerName.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_REQUESTEDCONSUMERNAME_REQUESTEDCONSUMERNAME_3);
		}
		else {
			bindRequestedConsumerName = true;

			sb.append(
				_FINDER_COLUMN_REQUESTEDCONSUMERNAME_REQUESTEDCONSUMERNAME_2);
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
			sb.append(MOITraceRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindRequestedConsumerName) {
			queryPos.add(requestedConsumerName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						moiTraceRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MOITraceRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the moi trace requests where requestedConsumerName = &#63; from the database.
	 *
	 * @param requestedConsumerName the requested consumer name
	 */
	@Override
	public void removeByRequestedConsumerName(String requestedConsumerName) {
		for (MOITraceRequest moiTraceRequest :
				findByRequestedConsumerName(
					requestedConsumerName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(moiTraceRequest);
		}
	}

	/**
	 * Returns the number of moi trace requests where requestedConsumerName = &#63;.
	 *
	 * @param requestedConsumerName the requested consumer name
	 * @return the number of matching moi trace requests
	 */
	@Override
	public int countByRequestedConsumerName(String requestedConsumerName) {
		requestedConsumerName = Objects.toString(requestedConsumerName, "");

		FinderPath finderPath = _finderPathCountByRequestedConsumerName;

		Object[] finderArgs = new Object[] {requestedConsumerName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOITRACEREQUEST_WHERE);

			boolean bindRequestedConsumerName = false;

			if (requestedConsumerName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_REQUESTEDCONSUMERNAME_REQUESTEDCONSUMERNAME_3);
			}
			else {
				bindRequestedConsumerName = true;

				sb.append(
					_FINDER_COLUMN_REQUESTEDCONSUMERNAME_REQUESTEDCONSUMERNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRequestedConsumerName) {
					queryPos.add(requestedConsumerName);
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
		_FINDER_COLUMN_REQUESTEDCONSUMERNAME_REQUESTEDCONSUMERNAME_2 =
			"moiTraceRequest.requestedConsumerName = ?";

	private static final String
		_FINDER_COLUMN_REQUESTEDCONSUMERNAME_REQUESTEDCONSUMERNAME_3 =
			"(moiTraceRequest.requestedConsumerName IS NULL OR moiTraceRequest.requestedConsumerName = '')";

	private FinderPath _finderPathWithPaginationFindByRequestedOperation;
	private FinderPath _finderPathWithoutPaginationFindByRequestedOperation;
	private FinderPath _finderPathCountByRequestedOperation;

	/**
	 * Returns all the moi trace requests where requestedOperation = &#63;.
	 *
	 * @param requestedOperation the requested operation
	 * @return the matching moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findByRequestedOperation(
		String requestedOperation) {

		return findByRequestedOperation(
			requestedOperation, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the moi trace requests where requestedOperation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOITraceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param requestedOperation the requested operation
	 * @param start the lower bound of the range of moi trace requests
	 * @param end the upper bound of the range of moi trace requests (not inclusive)
	 * @return the range of matching moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findByRequestedOperation(
		String requestedOperation, int start, int end) {

		return findByRequestedOperation(requestedOperation, start, end, null);
	}

	/**
	 * Returns an ordered range of all the moi trace requests where requestedOperation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOITraceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param requestedOperation the requested operation
	 * @param start the lower bound of the range of moi trace requests
	 * @param end the upper bound of the range of moi trace requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findByRequestedOperation(
		String requestedOperation, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return findByRequestedOperation(
			requestedOperation, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the moi trace requests where requestedOperation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOITraceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param requestedOperation the requested operation
	 * @param start the lower bound of the range of moi trace requests
	 * @param end the upper bound of the range of moi trace requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findByRequestedOperation(
		String requestedOperation, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator,
		boolean useFinderCache) {

		requestedOperation = Objects.toString(requestedOperation, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByRequestedOperation;
				finderArgs = new Object[] {requestedOperation};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByRequestedOperation;
			finderArgs = new Object[] {
				requestedOperation, start, end, orderByComparator
			};
		}

		List<MOITraceRequest> list = null;

		if (useFinderCache) {
			list = (List<MOITraceRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOITraceRequest moiTraceRequest : list) {
					if (!requestedOperation.equals(
							moiTraceRequest.getRequestedOperation())) {

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

			sb.append(_SQL_SELECT_MOITRACEREQUEST_WHERE);

			boolean bindRequestedOperation = false;

			if (requestedOperation.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_REQUESTEDOPERATION_REQUESTEDOPERATION_3);
			}
			else {
				bindRequestedOperation = true;

				sb.append(
					_FINDER_COLUMN_REQUESTEDOPERATION_REQUESTEDOPERATION_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOITraceRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRequestedOperation) {
					queryPos.add(requestedOperation);
				}

				list = (List<MOITraceRequest>)QueryUtil.list(
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
	 * Returns the first moi trace request in the ordered set where requestedOperation = &#63;.
	 *
	 * @param requestedOperation the requested operation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	@Override
	public MOITraceRequest findByRequestedOperation_First(
			String requestedOperation,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws NoSuchMOITraceRequestException {

		MOITraceRequest moiTraceRequest = fetchByRequestedOperation_First(
			requestedOperation, orderByComparator);

		if (moiTraceRequest != null) {
			return moiTraceRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("requestedOperation=");
		sb.append(requestedOperation);

		sb.append("}");

		throw new NoSuchMOITraceRequestException(sb.toString());
	}

	/**
	 * Returns the first moi trace request in the ordered set where requestedOperation = &#63;.
	 *
	 * @param requestedOperation the requested operation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	@Override
	public MOITraceRequest fetchByRequestedOperation_First(
		String requestedOperation,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		List<MOITraceRequest> list = findByRequestedOperation(
			requestedOperation, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi trace request in the ordered set where requestedOperation = &#63;.
	 *
	 * @param requestedOperation the requested operation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	@Override
	public MOITraceRequest findByRequestedOperation_Last(
			String requestedOperation,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws NoSuchMOITraceRequestException {

		MOITraceRequest moiTraceRequest = fetchByRequestedOperation_Last(
			requestedOperation, orderByComparator);

		if (moiTraceRequest != null) {
			return moiTraceRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("requestedOperation=");
		sb.append(requestedOperation);

		sb.append("}");

		throw new NoSuchMOITraceRequestException(sb.toString());
	}

	/**
	 * Returns the last moi trace request in the ordered set where requestedOperation = &#63;.
	 *
	 * @param requestedOperation the requested operation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	@Override
	public MOITraceRequest fetchByRequestedOperation_Last(
		String requestedOperation,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		int count = countByRequestedOperation(requestedOperation);

		if (count == 0) {
			return null;
		}

		List<MOITraceRequest> list = findByRequestedOperation(
			requestedOperation, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the moi trace requests before and after the current moi trace request in the ordered set where requestedOperation = &#63;.
	 *
	 * @param requestId the primary key of the current moi trace request
	 * @param requestedOperation the requested operation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi trace request
	 * @throws NoSuchMOITraceRequestException if a moi trace request with the primary key could not be found
	 */
	@Override
	public MOITraceRequest[] findByRequestedOperation_PrevAndNext(
			long requestId, String requestedOperation,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws NoSuchMOITraceRequestException {

		requestedOperation = Objects.toString(requestedOperation, "");

		MOITraceRequest moiTraceRequest = findByPrimaryKey(requestId);

		Session session = null;

		try {
			session = openSession();

			MOITraceRequest[] array = new MOITraceRequestImpl[3];

			array[0] = getByRequestedOperation_PrevAndNext(
				session, moiTraceRequest, requestedOperation, orderByComparator,
				true);

			array[1] = moiTraceRequest;

			array[2] = getByRequestedOperation_PrevAndNext(
				session, moiTraceRequest, requestedOperation, orderByComparator,
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

	protected MOITraceRequest getByRequestedOperation_PrevAndNext(
		Session session, MOITraceRequest moiTraceRequest,
		String requestedOperation,
		OrderByComparator<MOITraceRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_MOITRACEREQUEST_WHERE);

		boolean bindRequestedOperation = false;

		if (requestedOperation.isEmpty()) {
			sb.append(_FINDER_COLUMN_REQUESTEDOPERATION_REQUESTEDOPERATION_3);
		}
		else {
			bindRequestedOperation = true;

			sb.append(_FINDER_COLUMN_REQUESTEDOPERATION_REQUESTEDOPERATION_2);
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
			sb.append(MOITraceRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindRequestedOperation) {
			queryPos.add(requestedOperation);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						moiTraceRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MOITraceRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the moi trace requests where requestedOperation = &#63; from the database.
	 *
	 * @param requestedOperation the requested operation
	 */
	@Override
	public void removeByRequestedOperation(String requestedOperation) {
		for (MOITraceRequest moiTraceRequest :
				findByRequestedOperation(
					requestedOperation, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(moiTraceRequest);
		}
	}

	/**
	 * Returns the number of moi trace requests where requestedOperation = &#63;.
	 *
	 * @param requestedOperation the requested operation
	 * @return the number of matching moi trace requests
	 */
	@Override
	public int countByRequestedOperation(String requestedOperation) {
		requestedOperation = Objects.toString(requestedOperation, "");

		FinderPath finderPath = _finderPathCountByRequestedOperation;

		Object[] finderArgs = new Object[] {requestedOperation};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOITRACEREQUEST_WHERE);

			boolean bindRequestedOperation = false;

			if (requestedOperation.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_REQUESTEDOPERATION_REQUESTEDOPERATION_3);
			}
			else {
				bindRequestedOperation = true;

				sb.append(
					_FINDER_COLUMN_REQUESTEDOPERATION_REQUESTEDOPERATION_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRequestedOperation) {
					queryPos.add(requestedOperation);
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
		_FINDER_COLUMN_REQUESTEDOPERATION_REQUESTEDOPERATION_2 =
			"moiTraceRequest.requestedOperation = ?";

	private static final String
		_FINDER_COLUMN_REQUESTEDOPERATION_REQUESTEDOPERATION_3 =
			"(moiTraceRequest.requestedOperation IS NULL OR moiTraceRequest.requestedOperation = '')";

	private FinderPath _finderPathWithPaginationFindByRequestResult;
	private FinderPath _finderPathWithoutPaginationFindByRequestResult;
	private FinderPath _finderPathCountByRequestResult;

	/**
	 * Returns all the moi trace requests where requestResult = &#63;.
	 *
	 * @param requestResult the request result
	 * @return the matching moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findByRequestResult(String requestResult) {
		return findByRequestResult(
			requestResult, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the moi trace requests where requestResult = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOITraceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param requestResult the request result
	 * @param start the lower bound of the range of moi trace requests
	 * @param end the upper bound of the range of moi trace requests (not inclusive)
	 * @return the range of matching moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findByRequestResult(
		String requestResult, int start, int end) {

		return findByRequestResult(requestResult, start, end, null);
	}

	/**
	 * Returns an ordered range of all the moi trace requests where requestResult = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOITraceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param requestResult the request result
	 * @param start the lower bound of the range of moi trace requests
	 * @param end the upper bound of the range of moi trace requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findByRequestResult(
		String requestResult, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return findByRequestResult(
			requestResult, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the moi trace requests where requestResult = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOITraceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param requestResult the request result
	 * @param start the lower bound of the range of moi trace requests
	 * @param end the upper bound of the range of moi trace requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findByRequestResult(
		String requestResult, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator,
		boolean useFinderCache) {

		requestResult = Objects.toString(requestResult, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByRequestResult;
				finderArgs = new Object[] {requestResult};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByRequestResult;
			finderArgs = new Object[] {
				requestResult, start, end, orderByComparator
			};
		}

		List<MOITraceRequest> list = null;

		if (useFinderCache) {
			list = (List<MOITraceRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOITraceRequest moiTraceRequest : list) {
					if (!requestResult.equals(
							moiTraceRequest.getRequestResult())) {

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

			sb.append(_SQL_SELECT_MOITRACEREQUEST_WHERE);

			boolean bindRequestResult = false;

			if (requestResult.isEmpty()) {
				sb.append(_FINDER_COLUMN_REQUESTRESULT_REQUESTRESULT_3);
			}
			else {
				bindRequestResult = true;

				sb.append(_FINDER_COLUMN_REQUESTRESULT_REQUESTRESULT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOITraceRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRequestResult) {
					queryPos.add(requestResult);
				}

				list = (List<MOITraceRequest>)QueryUtil.list(
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
	 * Returns the first moi trace request in the ordered set where requestResult = &#63;.
	 *
	 * @param requestResult the request result
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	@Override
	public MOITraceRequest findByRequestResult_First(
			String requestResult,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws NoSuchMOITraceRequestException {

		MOITraceRequest moiTraceRequest = fetchByRequestResult_First(
			requestResult, orderByComparator);

		if (moiTraceRequest != null) {
			return moiTraceRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("requestResult=");
		sb.append(requestResult);

		sb.append("}");

		throw new NoSuchMOITraceRequestException(sb.toString());
	}

	/**
	 * Returns the first moi trace request in the ordered set where requestResult = &#63;.
	 *
	 * @param requestResult the request result
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	@Override
	public MOITraceRequest fetchByRequestResult_First(
		String requestResult,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		List<MOITraceRequest> list = findByRequestResult(
			requestResult, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi trace request in the ordered set where requestResult = &#63;.
	 *
	 * @param requestResult the request result
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	@Override
	public MOITraceRequest findByRequestResult_Last(
			String requestResult,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws NoSuchMOITraceRequestException {

		MOITraceRequest moiTraceRequest = fetchByRequestResult_Last(
			requestResult, orderByComparator);

		if (moiTraceRequest != null) {
			return moiTraceRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("requestResult=");
		sb.append(requestResult);

		sb.append("}");

		throw new NoSuchMOITraceRequestException(sb.toString());
	}

	/**
	 * Returns the last moi trace request in the ordered set where requestResult = &#63;.
	 *
	 * @param requestResult the request result
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	@Override
	public MOITraceRequest fetchByRequestResult_Last(
		String requestResult,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		int count = countByRequestResult(requestResult);

		if (count == 0) {
			return null;
		}

		List<MOITraceRequest> list = findByRequestResult(
			requestResult, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the moi trace requests before and after the current moi trace request in the ordered set where requestResult = &#63;.
	 *
	 * @param requestId the primary key of the current moi trace request
	 * @param requestResult the request result
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi trace request
	 * @throws NoSuchMOITraceRequestException if a moi trace request with the primary key could not be found
	 */
	@Override
	public MOITraceRequest[] findByRequestResult_PrevAndNext(
			long requestId, String requestResult,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws NoSuchMOITraceRequestException {

		requestResult = Objects.toString(requestResult, "");

		MOITraceRequest moiTraceRequest = findByPrimaryKey(requestId);

		Session session = null;

		try {
			session = openSession();

			MOITraceRequest[] array = new MOITraceRequestImpl[3];

			array[0] = getByRequestResult_PrevAndNext(
				session, moiTraceRequest, requestResult, orderByComparator,
				true);

			array[1] = moiTraceRequest;

			array[2] = getByRequestResult_PrevAndNext(
				session, moiTraceRequest, requestResult, orderByComparator,
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

	protected MOITraceRequest getByRequestResult_PrevAndNext(
		Session session, MOITraceRequest moiTraceRequest, String requestResult,
		OrderByComparator<MOITraceRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_MOITRACEREQUEST_WHERE);

		boolean bindRequestResult = false;

		if (requestResult.isEmpty()) {
			sb.append(_FINDER_COLUMN_REQUESTRESULT_REQUESTRESULT_3);
		}
		else {
			bindRequestResult = true;

			sb.append(_FINDER_COLUMN_REQUESTRESULT_REQUESTRESULT_2);
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
			sb.append(MOITraceRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindRequestResult) {
			queryPos.add(requestResult);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						moiTraceRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MOITraceRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the moi trace requests where requestResult = &#63; from the database.
	 *
	 * @param requestResult the request result
	 */
	@Override
	public void removeByRequestResult(String requestResult) {
		for (MOITraceRequest moiTraceRequest :
				findByRequestResult(
					requestResult, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(moiTraceRequest);
		}
	}

	/**
	 * Returns the number of moi trace requests where requestResult = &#63;.
	 *
	 * @param requestResult the request result
	 * @return the number of matching moi trace requests
	 */
	@Override
	public int countByRequestResult(String requestResult) {
		requestResult = Objects.toString(requestResult, "");

		FinderPath finderPath = _finderPathCountByRequestResult;

		Object[] finderArgs = new Object[] {requestResult};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOITRACEREQUEST_WHERE);

			boolean bindRequestResult = false;

			if (requestResult.isEmpty()) {
				sb.append(_FINDER_COLUMN_REQUESTRESULT_REQUESTRESULT_3);
			}
			else {
				bindRequestResult = true;

				sb.append(_FINDER_COLUMN_REQUESTRESULT_REQUESTRESULT_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRequestResult) {
					queryPos.add(requestResult);
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

	private static final String _FINDER_COLUMN_REQUESTRESULT_REQUESTRESULT_2 =
		"moiTraceRequest.requestResult = ?";

	private static final String _FINDER_COLUMN_REQUESTRESULT_REQUESTRESULT_3 =
		"(moiTraceRequest.requestResult IS NULL OR moiTraceRequest.requestResult = '')";

	private FinderPath _finderPathWithPaginationFindByRequestResultDate;
	private FinderPath _finderPathWithoutPaginationFindByRequestResultDate;
	private FinderPath _finderPathCountByRequestResultDate;

	/**
	 * Returns all the moi trace requests where requestResultDate = &#63;.
	 *
	 * @param requestResultDate the request result date
	 * @return the matching moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findByRequestResultDate(
		Date requestResultDate) {

		return findByRequestResultDate(
			requestResultDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the moi trace requests where requestResultDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOITraceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param requestResultDate the request result date
	 * @param start the lower bound of the range of moi trace requests
	 * @param end the upper bound of the range of moi trace requests (not inclusive)
	 * @return the range of matching moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findByRequestResultDate(
		Date requestResultDate, int start, int end) {

		return findByRequestResultDate(requestResultDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the moi trace requests where requestResultDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOITraceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param requestResultDate the request result date
	 * @param start the lower bound of the range of moi trace requests
	 * @param end the upper bound of the range of moi trace requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findByRequestResultDate(
		Date requestResultDate, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return findByRequestResultDate(
			requestResultDate, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the moi trace requests where requestResultDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOITraceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param requestResultDate the request result date
	 * @param start the lower bound of the range of moi trace requests
	 * @param end the upper bound of the range of moi trace requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findByRequestResultDate(
		Date requestResultDate, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByRequestResultDate;
				finderArgs = new Object[] {_getTime(requestResultDate)};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByRequestResultDate;
			finderArgs = new Object[] {
				_getTime(requestResultDate), start, end, orderByComparator
			};
		}

		List<MOITraceRequest> list = null;

		if (useFinderCache) {
			list = (List<MOITraceRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOITraceRequest moiTraceRequest : list) {
					if (!Objects.equals(
							requestResultDate,
							moiTraceRequest.getRequestResultDate())) {

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

			sb.append(_SQL_SELECT_MOITRACEREQUEST_WHERE);

			boolean bindRequestResultDate = false;

			if (requestResultDate == null) {
				sb.append(_FINDER_COLUMN_REQUESTRESULTDATE_REQUESTRESULTDATE_1);
			}
			else {
				bindRequestResultDate = true;

				sb.append(_FINDER_COLUMN_REQUESTRESULTDATE_REQUESTRESULTDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOITraceRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRequestResultDate) {
					queryPos.add(new Timestamp(requestResultDate.getTime()));
				}

				list = (List<MOITraceRequest>)QueryUtil.list(
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
	 * Returns the first moi trace request in the ordered set where requestResultDate = &#63;.
	 *
	 * @param requestResultDate the request result date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	@Override
	public MOITraceRequest findByRequestResultDate_First(
			Date requestResultDate,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws NoSuchMOITraceRequestException {

		MOITraceRequest moiTraceRequest = fetchByRequestResultDate_First(
			requestResultDate, orderByComparator);

		if (moiTraceRequest != null) {
			return moiTraceRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("requestResultDate=");
		sb.append(requestResultDate);

		sb.append("}");

		throw new NoSuchMOITraceRequestException(sb.toString());
	}

	/**
	 * Returns the first moi trace request in the ordered set where requestResultDate = &#63;.
	 *
	 * @param requestResultDate the request result date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	@Override
	public MOITraceRequest fetchByRequestResultDate_First(
		Date requestResultDate,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		List<MOITraceRequest> list = findByRequestResultDate(
			requestResultDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi trace request in the ordered set where requestResultDate = &#63;.
	 *
	 * @param requestResultDate the request result date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	@Override
	public MOITraceRequest findByRequestResultDate_Last(
			Date requestResultDate,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws NoSuchMOITraceRequestException {

		MOITraceRequest moiTraceRequest = fetchByRequestResultDate_Last(
			requestResultDate, orderByComparator);

		if (moiTraceRequest != null) {
			return moiTraceRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("requestResultDate=");
		sb.append(requestResultDate);

		sb.append("}");

		throw new NoSuchMOITraceRequestException(sb.toString());
	}

	/**
	 * Returns the last moi trace request in the ordered set where requestResultDate = &#63;.
	 *
	 * @param requestResultDate the request result date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	@Override
	public MOITraceRequest fetchByRequestResultDate_Last(
		Date requestResultDate,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		int count = countByRequestResultDate(requestResultDate);

		if (count == 0) {
			return null;
		}

		List<MOITraceRequest> list = findByRequestResultDate(
			requestResultDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the moi trace requests before and after the current moi trace request in the ordered set where requestResultDate = &#63;.
	 *
	 * @param requestId the primary key of the current moi trace request
	 * @param requestResultDate the request result date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi trace request
	 * @throws NoSuchMOITraceRequestException if a moi trace request with the primary key could not be found
	 */
	@Override
	public MOITraceRequest[] findByRequestResultDate_PrevAndNext(
			long requestId, Date requestResultDate,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws NoSuchMOITraceRequestException {

		MOITraceRequest moiTraceRequest = findByPrimaryKey(requestId);

		Session session = null;

		try {
			session = openSession();

			MOITraceRequest[] array = new MOITraceRequestImpl[3];

			array[0] = getByRequestResultDate_PrevAndNext(
				session, moiTraceRequest, requestResultDate, orderByComparator,
				true);

			array[1] = moiTraceRequest;

			array[2] = getByRequestResultDate_PrevAndNext(
				session, moiTraceRequest, requestResultDate, orderByComparator,
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

	protected MOITraceRequest getByRequestResultDate_PrevAndNext(
		Session session, MOITraceRequest moiTraceRequest,
		Date requestResultDate,
		OrderByComparator<MOITraceRequest> orderByComparator,
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

		sb.append(_SQL_SELECT_MOITRACEREQUEST_WHERE);

		boolean bindRequestResultDate = false;

		if (requestResultDate == null) {
			sb.append(_FINDER_COLUMN_REQUESTRESULTDATE_REQUESTRESULTDATE_1);
		}
		else {
			bindRequestResultDate = true;

			sb.append(_FINDER_COLUMN_REQUESTRESULTDATE_REQUESTRESULTDATE_2);
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
			sb.append(MOITraceRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindRequestResultDate) {
			queryPos.add(new Timestamp(requestResultDate.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						moiTraceRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MOITraceRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the moi trace requests where requestResultDate = &#63; from the database.
	 *
	 * @param requestResultDate the request result date
	 */
	@Override
	public void removeByRequestResultDate(Date requestResultDate) {
		for (MOITraceRequest moiTraceRequest :
				findByRequestResultDate(
					requestResultDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(moiTraceRequest);
		}
	}

	/**
	 * Returns the number of moi trace requests where requestResultDate = &#63;.
	 *
	 * @param requestResultDate the request result date
	 * @return the number of matching moi trace requests
	 */
	@Override
	public int countByRequestResultDate(Date requestResultDate) {
		FinderPath finderPath = _finderPathCountByRequestResultDate;

		Object[] finderArgs = new Object[] {_getTime(requestResultDate)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOITRACEREQUEST_WHERE);

			boolean bindRequestResultDate = false;

			if (requestResultDate == null) {
				sb.append(_FINDER_COLUMN_REQUESTRESULTDATE_REQUESTRESULTDATE_1);
			}
			else {
				bindRequestResultDate = true;

				sb.append(_FINDER_COLUMN_REQUESTRESULTDATE_REQUESTRESULTDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRequestResultDate) {
					queryPos.add(new Timestamp(requestResultDate.getTime()));
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
		_FINDER_COLUMN_REQUESTRESULTDATE_REQUESTRESULTDATE_1 =
			"moiTraceRequest.requestResultDate IS NULL";

	private static final String
		_FINDER_COLUMN_REQUESTRESULTDATE_REQUESTRESULTDATE_2 =
			"moiTraceRequest.requestResultDate = ?";

	public MOITraceRequestPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("comment", "comment_");

		setDBColumnNames(dbColumnNames);

		setModelClass(MOITraceRequest.class);

		setModelImplClass(MOITraceRequestImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the moi trace request in the entity cache if it is enabled.
	 *
	 * @param moiTraceRequest the moi trace request
	 */
	@Override
	public void cacheResult(MOITraceRequest moiTraceRequest) {
		entityCache.putResult(
			entityCacheEnabled, MOITraceRequestImpl.class,
			moiTraceRequest.getPrimaryKey(), moiTraceRequest);

		moiTraceRequest.resetOriginalValues();
	}

	/**
	 * Caches the moi trace requests in the entity cache if it is enabled.
	 *
	 * @param moiTraceRequests the moi trace requests
	 */
	@Override
	public void cacheResult(List<MOITraceRequest> moiTraceRequests) {
		for (MOITraceRequest moiTraceRequest : moiTraceRequests) {
			if (entityCache.getResult(
					entityCacheEnabled, MOITraceRequestImpl.class,
					moiTraceRequest.getPrimaryKey()) == null) {

				cacheResult(moiTraceRequest);
			}
			else {
				moiTraceRequest.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all moi trace requests.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MOITraceRequestImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the moi trace request.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MOITraceRequest moiTraceRequest) {
		entityCache.removeResult(
			entityCacheEnabled, MOITraceRequestImpl.class,
			moiTraceRequest.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MOITraceRequest> moiTraceRequests) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MOITraceRequest moiTraceRequest : moiTraceRequests) {
			entityCache.removeResult(
				entityCacheEnabled, MOITraceRequestImpl.class,
				moiTraceRequest.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, MOITraceRequestImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new moi trace request with the primary key. Does not add the moi trace request to the database.
	 *
	 * @param requestId the primary key for the new moi trace request
	 * @return the new moi trace request
	 */
	@Override
	public MOITraceRequest create(long requestId) {
		MOITraceRequest moiTraceRequest = new MOITraceRequestImpl();

		moiTraceRequest.setNew(true);
		moiTraceRequest.setPrimaryKey(requestId);

		return moiTraceRequest;
	}

	/**
	 * Removes the moi trace request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param requestId the primary key of the moi trace request
	 * @return the moi trace request that was removed
	 * @throws NoSuchMOITraceRequestException if a moi trace request with the primary key could not be found
	 */
	@Override
	public MOITraceRequest remove(long requestId)
		throws NoSuchMOITraceRequestException {

		return remove((Serializable)requestId);
	}

	/**
	 * Removes the moi trace request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the moi trace request
	 * @return the moi trace request that was removed
	 * @throws NoSuchMOITraceRequestException if a moi trace request with the primary key could not be found
	 */
	@Override
	public MOITraceRequest remove(Serializable primaryKey)
		throws NoSuchMOITraceRequestException {

		Session session = null;

		try {
			session = openSession();

			MOITraceRequest moiTraceRequest = (MOITraceRequest)session.get(
				MOITraceRequestImpl.class, primaryKey);

			if (moiTraceRequest == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMOITraceRequestException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(moiTraceRequest);
		}
		catch (NoSuchMOITraceRequestException noSuchEntityException) {
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
	protected MOITraceRequest removeImpl(MOITraceRequest moiTraceRequest) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(moiTraceRequest)) {
				moiTraceRequest = (MOITraceRequest)session.get(
					MOITraceRequestImpl.class,
					moiTraceRequest.getPrimaryKeyObj());
			}

			if (moiTraceRequest != null) {
				session.delete(moiTraceRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (moiTraceRequest != null) {
			clearCache(moiTraceRequest);
		}

		return moiTraceRequest;
	}

	@Override
	public MOITraceRequest updateImpl(MOITraceRequest moiTraceRequest) {
		boolean isNew = moiTraceRequest.isNew();

		if (!(moiTraceRequest instanceof MOITraceRequestModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(moiTraceRequest.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					moiTraceRequest);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in moiTraceRequest proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MOITraceRequest implementation " +
					moiTraceRequest.getClass());
		}

		MOITraceRequestModelImpl moiTraceRequestModelImpl =
			(MOITraceRequestModelImpl)moiTraceRequest;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(moiTraceRequest);

				moiTraceRequest.setNew(false);
			}
			else {
				moiTraceRequest = (MOITraceRequest)session.merge(
					moiTraceRequest);
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
				moiTraceRequestModelImpl.getRequestId()
			};

			finderCache.removeResult(_finderPathCountByRequestId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByRequestId, args);

			args = new Object[] {moiTraceRequestModelImpl.getRequestedBy()};

			finderCache.removeResult(_finderPathCountByRequestedBy, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByRequestedBy, args);

			args = new Object[] {
				moiTraceRequestModelImpl.getRequestIncomingDate()
			};

			finderCache.removeResult(
				_finderPathCountByRequestIncomingDate, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByRequestIncomingDate, args);

			args = new Object[] {
				moiTraceRequestModelImpl.getRequestedConsumerCode()
			};

			finderCache.removeResult(
				_finderPathCountByRequestedConsumerCode, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByRequestedConsumerCode, args);

			args = new Object[] {
				moiTraceRequestModelImpl.getRequestedConsumerName()
			};

			finderCache.removeResult(
				_finderPathCountByRequestedConsumerName, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByRequestedConsumerName, args);

			args = new Object[] {
				moiTraceRequestModelImpl.getRequestedOperation()
			};

			finderCache.removeResult(
				_finderPathCountByRequestedOperation, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByRequestedOperation, args);

			args = new Object[] {moiTraceRequestModelImpl.getRequestResult()};

			finderCache.removeResult(_finderPathCountByRequestResult, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByRequestResult, args);

			args = new Object[] {
				moiTraceRequestModelImpl.getRequestResultDate()
			};

			finderCache.removeResult(_finderPathCountByRequestResultDate, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByRequestResultDate, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((moiTraceRequestModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByRequestId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					moiTraceRequestModelImpl.getOriginalRequestId()
				};

				finderCache.removeResult(_finderPathCountByRequestId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRequestId, args);

				args = new Object[] {moiTraceRequestModelImpl.getRequestId()};

				finderCache.removeResult(_finderPathCountByRequestId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRequestId, args);
			}

			if ((moiTraceRequestModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByRequestedBy.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					moiTraceRequestModelImpl.getOriginalRequestedBy()
				};

				finderCache.removeResult(_finderPathCountByRequestedBy, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRequestedBy, args);

				args = new Object[] {moiTraceRequestModelImpl.getRequestedBy()};

				finderCache.removeResult(_finderPathCountByRequestedBy, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRequestedBy, args);
			}

			if ((moiTraceRequestModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByRequestIncomingDate.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					moiTraceRequestModelImpl.getOriginalRequestIncomingDate()
				};

				finderCache.removeResult(
					_finderPathCountByRequestIncomingDate, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRequestIncomingDate,
					args);

				args = new Object[] {
					moiTraceRequestModelImpl.getRequestIncomingDate()
				};

				finderCache.removeResult(
					_finderPathCountByRequestIncomingDate, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRequestIncomingDate,
					args);
			}

			if ((moiTraceRequestModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByRequestedConsumerCode.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					moiTraceRequestModelImpl.getOriginalRequestedConsumerCode()
				};

				finderCache.removeResult(
					_finderPathCountByRequestedConsumerCode, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRequestedConsumerCode,
					args);

				args = new Object[] {
					moiTraceRequestModelImpl.getRequestedConsumerCode()
				};

				finderCache.removeResult(
					_finderPathCountByRequestedConsumerCode, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRequestedConsumerCode,
					args);
			}

			if ((moiTraceRequestModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByRequestedConsumerName.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					moiTraceRequestModelImpl.getOriginalRequestedConsumerName()
				};

				finderCache.removeResult(
					_finderPathCountByRequestedConsumerName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRequestedConsumerName,
					args);

				args = new Object[] {
					moiTraceRequestModelImpl.getRequestedConsumerName()
				};

				finderCache.removeResult(
					_finderPathCountByRequestedConsumerName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRequestedConsumerName,
					args);
			}

			if ((moiTraceRequestModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByRequestedOperation.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					moiTraceRequestModelImpl.getOriginalRequestedOperation()
				};

				finderCache.removeResult(
					_finderPathCountByRequestedOperation, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRequestedOperation, args);

				args = new Object[] {
					moiTraceRequestModelImpl.getRequestedOperation()
				};

				finderCache.removeResult(
					_finderPathCountByRequestedOperation, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRequestedOperation, args);
			}

			if ((moiTraceRequestModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByRequestResult.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					moiTraceRequestModelImpl.getOriginalRequestResult()
				};

				finderCache.removeResult(_finderPathCountByRequestResult, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRequestResult, args);

				args = new Object[] {
					moiTraceRequestModelImpl.getRequestResult()
				};

				finderCache.removeResult(_finderPathCountByRequestResult, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRequestResult, args);
			}

			if ((moiTraceRequestModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByRequestResultDate.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					moiTraceRequestModelImpl.getOriginalRequestResultDate()
				};

				finderCache.removeResult(
					_finderPathCountByRequestResultDate, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRequestResultDate, args);

				args = new Object[] {
					moiTraceRequestModelImpl.getRequestResultDate()
				};

				finderCache.removeResult(
					_finderPathCountByRequestResultDate, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRequestResultDate, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, MOITraceRequestImpl.class,
			moiTraceRequest.getPrimaryKey(), moiTraceRequest, false);

		moiTraceRequest.resetOriginalValues();

		return moiTraceRequest;
	}

	/**
	 * Returns the moi trace request with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the moi trace request
	 * @return the moi trace request
	 * @throws NoSuchMOITraceRequestException if a moi trace request with the primary key could not be found
	 */
	@Override
	public MOITraceRequest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMOITraceRequestException {

		MOITraceRequest moiTraceRequest = fetchByPrimaryKey(primaryKey);

		if (moiTraceRequest == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMOITraceRequestException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return moiTraceRequest;
	}

	/**
	 * Returns the moi trace request with the primary key or throws a <code>NoSuchMOITraceRequestException</code> if it could not be found.
	 *
	 * @param requestId the primary key of the moi trace request
	 * @return the moi trace request
	 * @throws NoSuchMOITraceRequestException if a moi trace request with the primary key could not be found
	 */
	@Override
	public MOITraceRequest findByPrimaryKey(long requestId)
		throws NoSuchMOITraceRequestException {

		return findByPrimaryKey((Serializable)requestId);
	}

	/**
	 * Returns the moi trace request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param requestId the primary key of the moi trace request
	 * @return the moi trace request, or <code>null</code> if a moi trace request with the primary key could not be found
	 */
	@Override
	public MOITraceRequest fetchByPrimaryKey(long requestId) {
		return fetchByPrimaryKey((Serializable)requestId);
	}

	/**
	 * Returns all the moi trace requests.
	 *
	 * @return the moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the moi trace requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOITraceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of moi trace requests
	 * @param end the upper bound of the range of moi trace requests (not inclusive)
	 * @return the range of moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the moi trace requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOITraceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of moi trace requests
	 * @param end the upper bound of the range of moi trace requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findAll(
		int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the moi trace requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOITraceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of moi trace requests
	 * @param end the upper bound of the range of moi trace requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of moi trace requests
	 */
	@Override
	public List<MOITraceRequest> findAll(
		int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator,
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

		List<MOITraceRequest> list = null;

		if (useFinderCache) {
			list = (List<MOITraceRequest>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MOITRACEREQUEST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MOITRACEREQUEST;

				sql = sql.concat(MOITraceRequestModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MOITraceRequest>)QueryUtil.list(
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
	 * Removes all the moi trace requests from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MOITraceRequest moiTraceRequest : findAll()) {
			remove(moiTraceRequest);
		}
	}

	/**
	 * Returns the number of moi trace requests.
	 *
	 * @return the number of moi trace requests
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MOITRACEREQUEST);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "requestId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MOITRACEREQUEST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MOITraceRequestModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the moi trace request persistence.
	 */
	@Activate
	public void activate() {
		MOITraceRequestModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		MOITraceRequestModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOITraceRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOITraceRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByRequestId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOITraceRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRequestId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByRequestId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOITraceRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRequestId",
			new String[] {Long.class.getName()},
			MOITraceRequestModelImpl.REQUESTID_COLUMN_BITMASK);

		_finderPathCountByRequestId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRequestId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByRequestedBy = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOITraceRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRequestedBy",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByRequestedBy = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOITraceRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRequestedBy",
			new String[] {String.class.getName()},
			MOITraceRequestModelImpl.REQUESTEDBY_COLUMN_BITMASK);

		_finderPathCountByRequestedBy = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRequestedBy",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByRequestIncomingDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOITraceRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRequestIncomingDate",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByRequestIncomingDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOITraceRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByRequestIncomingDate", new String[] {Date.class.getName()},
			MOITraceRequestModelImpl.REQUESTINCOMINGDATE_COLUMN_BITMASK);

		_finderPathCountByRequestIncomingDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRequestIncomingDate", new String[] {Date.class.getName()});

		_finderPathWithPaginationFindByRequestedConsumerCode = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOITraceRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByRequestedConsumerCode",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByRequestedConsumerCode =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				MOITraceRequestImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByRequestedConsumerCode",
				new String[] {String.class.getName()},
				MOITraceRequestModelImpl.REQUESTEDCONSUMERCODE_COLUMN_BITMASK);

		_finderPathCountByRequestedConsumerCode = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRequestedConsumerCode",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByRequestedConsumerName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOITraceRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByRequestedConsumerName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByRequestedConsumerName =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				MOITraceRequestImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByRequestedConsumerName",
				new String[] {String.class.getName()},
				MOITraceRequestModelImpl.REQUESTEDCONSUMERNAME_COLUMN_BITMASK);

		_finderPathCountByRequestedConsumerName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRequestedConsumerName",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByRequestedOperation = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOITraceRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRequestedOperation",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByRequestedOperation = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOITraceRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByRequestedOperation", new String[] {String.class.getName()},
			MOITraceRequestModelImpl.REQUESTEDOPERATION_COLUMN_BITMASK);

		_finderPathCountByRequestedOperation = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRequestedOperation", new String[] {String.class.getName()});

		_finderPathWithPaginationFindByRequestResult = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOITraceRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRequestResult",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByRequestResult = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOITraceRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRequestResult",
			new String[] {String.class.getName()},
			MOITraceRequestModelImpl.REQUESTRESULT_COLUMN_BITMASK);

		_finderPathCountByRequestResult = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRequestResult",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByRequestResultDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOITraceRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRequestResultDate",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByRequestResultDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOITraceRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByRequestResultDate", new String[] {Date.class.getName()},
			MOITraceRequestModelImpl.REQUESTRESULTDATE_COLUMN_BITMASK);

		_finderPathCountByRequestResultDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRequestResultDate", new String[] {Date.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(MOITraceRequestImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = moitrPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.moi.dms.trace.request.model.MOITraceRequest"),
			true);
	}

	@Override
	@Reference(
		target = moitrPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = moitrPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_MOITRACEREQUEST =
		"SELECT moiTraceRequest FROM MOITraceRequest moiTraceRequest";

	private static final String _SQL_SELECT_MOITRACEREQUEST_WHERE =
		"SELECT moiTraceRequest FROM MOITraceRequest moiTraceRequest WHERE ";

	private static final String _SQL_COUNT_MOITRACEREQUEST =
		"SELECT COUNT(moiTraceRequest) FROM MOITraceRequest moiTraceRequest";

	private static final String _SQL_COUNT_MOITRACEREQUEST_WHERE =
		"SELECT COUNT(moiTraceRequest) FROM MOITraceRequest moiTraceRequest WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "moiTraceRequest.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MOITraceRequest exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MOITraceRequest exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MOITraceRequestPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"comment"});

	static {
		try {
			Class.forName(moitrPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}