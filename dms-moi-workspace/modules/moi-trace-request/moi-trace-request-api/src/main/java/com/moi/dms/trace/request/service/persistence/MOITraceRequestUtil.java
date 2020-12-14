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

package com.moi.dms.trace.request.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.moi.dms.trace.request.model.MOITraceRequest;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the moi trace request service. This utility wraps <code>com.moi.dms.trace.request.service.persistence.impl.MOITraceRequestPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MOITraceRequestPersistence
 * @generated
 */
public class MOITraceRequestUtil {

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
	public static void clearCache(MOITraceRequest moiTraceRequest) {
		getPersistence().clearCache(moiTraceRequest);
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
	public static Map<Serializable, MOITraceRequest> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MOITraceRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MOITraceRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MOITraceRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MOITraceRequest update(MOITraceRequest moiTraceRequest) {
		return getPersistence().update(moiTraceRequest);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MOITraceRequest update(
		MOITraceRequest moiTraceRequest, ServiceContext serviceContext) {

		return getPersistence().update(moiTraceRequest, serviceContext);
	}

	/**
	 * Returns all the moi trace requests where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @return the matching moi trace requests
	 */
	public static List<MOITraceRequest> findByRequestId(long requestId) {
		return getPersistence().findByRequestId(requestId);
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
	public static List<MOITraceRequest> findByRequestId(
		long requestId, int start, int end) {

		return getPersistence().findByRequestId(requestId, start, end);
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
	public static List<MOITraceRequest> findByRequestId(
		long requestId, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return getPersistence().findByRequestId(
			requestId, start, end, orderByComparator);
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
	public static List<MOITraceRequest> findByRequestId(
		long requestId, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRequestId(
			requestId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first moi trace request in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	public static MOITraceRequest findByRequestId_First(
			long requestId,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws com.moi.dms.trace.request.exception.
			NoSuchMOITraceRequestException {

		return getPersistence().findByRequestId_First(
			requestId, orderByComparator);
	}

	/**
	 * Returns the first moi trace request in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	public static MOITraceRequest fetchByRequestId_First(
		long requestId, OrderByComparator<MOITraceRequest> orderByComparator) {

		return getPersistence().fetchByRequestId_First(
			requestId, orderByComparator);
	}

	/**
	 * Returns the last moi trace request in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	public static MOITraceRequest findByRequestId_Last(
			long requestId,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws com.moi.dms.trace.request.exception.
			NoSuchMOITraceRequestException {

		return getPersistence().findByRequestId_Last(
			requestId, orderByComparator);
	}

	/**
	 * Returns the last moi trace request in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	public static MOITraceRequest fetchByRequestId_Last(
		long requestId, OrderByComparator<MOITraceRequest> orderByComparator) {

		return getPersistence().fetchByRequestId_Last(
			requestId, orderByComparator);
	}

	/**
	 * Removes all the moi trace requests where requestId = &#63; from the database.
	 *
	 * @param requestId the request ID
	 */
	public static void removeByRequestId(long requestId) {
		getPersistence().removeByRequestId(requestId);
	}

	/**
	 * Returns the number of moi trace requests where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @return the number of matching moi trace requests
	 */
	public static int countByRequestId(long requestId) {
		return getPersistence().countByRequestId(requestId);
	}

	/**
	 * Returns all the moi trace requests where requestedBy = &#63;.
	 *
	 * @param requestedBy the requested by
	 * @return the matching moi trace requests
	 */
	public static List<MOITraceRequest> findByRequestedBy(String requestedBy) {
		return getPersistence().findByRequestedBy(requestedBy);
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
	public static List<MOITraceRequest> findByRequestedBy(
		String requestedBy, int start, int end) {

		return getPersistence().findByRequestedBy(requestedBy, start, end);
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
	public static List<MOITraceRequest> findByRequestedBy(
		String requestedBy, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return getPersistence().findByRequestedBy(
			requestedBy, start, end, orderByComparator);
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
	public static List<MOITraceRequest> findByRequestedBy(
		String requestedBy, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRequestedBy(
			requestedBy, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first moi trace request in the ordered set where requestedBy = &#63;.
	 *
	 * @param requestedBy the requested by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	public static MOITraceRequest findByRequestedBy_First(
			String requestedBy,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws com.moi.dms.trace.request.exception.
			NoSuchMOITraceRequestException {

		return getPersistence().findByRequestedBy_First(
			requestedBy, orderByComparator);
	}

	/**
	 * Returns the first moi trace request in the ordered set where requestedBy = &#63;.
	 *
	 * @param requestedBy the requested by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	public static MOITraceRequest fetchByRequestedBy_First(
		String requestedBy,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return getPersistence().fetchByRequestedBy_First(
			requestedBy, orderByComparator);
	}

	/**
	 * Returns the last moi trace request in the ordered set where requestedBy = &#63;.
	 *
	 * @param requestedBy the requested by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	public static MOITraceRequest findByRequestedBy_Last(
			String requestedBy,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws com.moi.dms.trace.request.exception.
			NoSuchMOITraceRequestException {

		return getPersistence().findByRequestedBy_Last(
			requestedBy, orderByComparator);
	}

	/**
	 * Returns the last moi trace request in the ordered set where requestedBy = &#63;.
	 *
	 * @param requestedBy the requested by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	public static MOITraceRequest fetchByRequestedBy_Last(
		String requestedBy,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return getPersistence().fetchByRequestedBy_Last(
			requestedBy, orderByComparator);
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
	public static MOITraceRequest[] findByRequestedBy_PrevAndNext(
			long requestId, String requestedBy,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws com.moi.dms.trace.request.exception.
			NoSuchMOITraceRequestException {

		return getPersistence().findByRequestedBy_PrevAndNext(
			requestId, requestedBy, orderByComparator);
	}

	/**
	 * Removes all the moi trace requests where requestedBy = &#63; from the database.
	 *
	 * @param requestedBy the requested by
	 */
	public static void removeByRequestedBy(String requestedBy) {
		getPersistence().removeByRequestedBy(requestedBy);
	}

	/**
	 * Returns the number of moi trace requests where requestedBy = &#63;.
	 *
	 * @param requestedBy the requested by
	 * @return the number of matching moi trace requests
	 */
	public static int countByRequestedBy(String requestedBy) {
		return getPersistence().countByRequestedBy(requestedBy);
	}

	/**
	 * Returns all the moi trace requests where requestIncomingDate = &#63;.
	 *
	 * @param requestIncomingDate the request incoming date
	 * @return the matching moi trace requests
	 */
	public static List<MOITraceRequest> findByRequestIncomingDate(
		Date requestIncomingDate) {

		return getPersistence().findByRequestIncomingDate(requestIncomingDate);
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
	public static List<MOITraceRequest> findByRequestIncomingDate(
		Date requestIncomingDate, int start, int end) {

		return getPersistence().findByRequestIncomingDate(
			requestIncomingDate, start, end);
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
	public static List<MOITraceRequest> findByRequestIncomingDate(
		Date requestIncomingDate, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return getPersistence().findByRequestIncomingDate(
			requestIncomingDate, start, end, orderByComparator);
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
	public static List<MOITraceRequest> findByRequestIncomingDate(
		Date requestIncomingDate, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRequestIncomingDate(
			requestIncomingDate, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first moi trace request in the ordered set where requestIncomingDate = &#63;.
	 *
	 * @param requestIncomingDate the request incoming date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	public static MOITraceRequest findByRequestIncomingDate_First(
			Date requestIncomingDate,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws com.moi.dms.trace.request.exception.
			NoSuchMOITraceRequestException {

		return getPersistence().findByRequestIncomingDate_First(
			requestIncomingDate, orderByComparator);
	}

	/**
	 * Returns the first moi trace request in the ordered set where requestIncomingDate = &#63;.
	 *
	 * @param requestIncomingDate the request incoming date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	public static MOITraceRequest fetchByRequestIncomingDate_First(
		Date requestIncomingDate,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return getPersistence().fetchByRequestIncomingDate_First(
			requestIncomingDate, orderByComparator);
	}

	/**
	 * Returns the last moi trace request in the ordered set where requestIncomingDate = &#63;.
	 *
	 * @param requestIncomingDate the request incoming date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	public static MOITraceRequest findByRequestIncomingDate_Last(
			Date requestIncomingDate,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws com.moi.dms.trace.request.exception.
			NoSuchMOITraceRequestException {

		return getPersistence().findByRequestIncomingDate_Last(
			requestIncomingDate, orderByComparator);
	}

	/**
	 * Returns the last moi trace request in the ordered set where requestIncomingDate = &#63;.
	 *
	 * @param requestIncomingDate the request incoming date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	public static MOITraceRequest fetchByRequestIncomingDate_Last(
		Date requestIncomingDate,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return getPersistence().fetchByRequestIncomingDate_Last(
			requestIncomingDate, orderByComparator);
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
	public static MOITraceRequest[] findByRequestIncomingDate_PrevAndNext(
			long requestId, Date requestIncomingDate,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws com.moi.dms.trace.request.exception.
			NoSuchMOITraceRequestException {

		return getPersistence().findByRequestIncomingDate_PrevAndNext(
			requestId, requestIncomingDate, orderByComparator);
	}

	/**
	 * Removes all the moi trace requests where requestIncomingDate = &#63; from the database.
	 *
	 * @param requestIncomingDate the request incoming date
	 */
	public static void removeByRequestIncomingDate(Date requestIncomingDate) {
		getPersistence().removeByRequestIncomingDate(requestIncomingDate);
	}

	/**
	 * Returns the number of moi trace requests where requestIncomingDate = &#63;.
	 *
	 * @param requestIncomingDate the request incoming date
	 * @return the number of matching moi trace requests
	 */
	public static int countByRequestIncomingDate(Date requestIncomingDate) {
		return getPersistence().countByRequestIncomingDate(requestIncomingDate);
	}

	/**
	 * Returns all the moi trace requests where requestedConsumerCode = &#63;.
	 *
	 * @param requestedConsumerCode the requested consumer code
	 * @return the matching moi trace requests
	 */
	public static List<MOITraceRequest> findByRequestedConsumerCode(
		String requestedConsumerCode) {

		return getPersistence().findByRequestedConsumerCode(
			requestedConsumerCode);
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
	public static List<MOITraceRequest> findByRequestedConsumerCode(
		String requestedConsumerCode, int start, int end) {

		return getPersistence().findByRequestedConsumerCode(
			requestedConsumerCode, start, end);
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
	public static List<MOITraceRequest> findByRequestedConsumerCode(
		String requestedConsumerCode, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return getPersistence().findByRequestedConsumerCode(
			requestedConsumerCode, start, end, orderByComparator);
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
	public static List<MOITraceRequest> findByRequestedConsumerCode(
		String requestedConsumerCode, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRequestedConsumerCode(
			requestedConsumerCode, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first moi trace request in the ordered set where requestedConsumerCode = &#63;.
	 *
	 * @param requestedConsumerCode the requested consumer code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	public static MOITraceRequest findByRequestedConsumerCode_First(
			String requestedConsumerCode,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws com.moi.dms.trace.request.exception.
			NoSuchMOITraceRequestException {

		return getPersistence().findByRequestedConsumerCode_First(
			requestedConsumerCode, orderByComparator);
	}

	/**
	 * Returns the first moi trace request in the ordered set where requestedConsumerCode = &#63;.
	 *
	 * @param requestedConsumerCode the requested consumer code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	public static MOITraceRequest fetchByRequestedConsumerCode_First(
		String requestedConsumerCode,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return getPersistence().fetchByRequestedConsumerCode_First(
			requestedConsumerCode, orderByComparator);
	}

	/**
	 * Returns the last moi trace request in the ordered set where requestedConsumerCode = &#63;.
	 *
	 * @param requestedConsumerCode the requested consumer code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	public static MOITraceRequest findByRequestedConsumerCode_Last(
			String requestedConsumerCode,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws com.moi.dms.trace.request.exception.
			NoSuchMOITraceRequestException {

		return getPersistence().findByRequestedConsumerCode_Last(
			requestedConsumerCode, orderByComparator);
	}

	/**
	 * Returns the last moi trace request in the ordered set where requestedConsumerCode = &#63;.
	 *
	 * @param requestedConsumerCode the requested consumer code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	public static MOITraceRequest fetchByRequestedConsumerCode_Last(
		String requestedConsumerCode,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return getPersistence().fetchByRequestedConsumerCode_Last(
			requestedConsumerCode, orderByComparator);
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
	public static MOITraceRequest[] findByRequestedConsumerCode_PrevAndNext(
			long requestId, String requestedConsumerCode,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws com.moi.dms.trace.request.exception.
			NoSuchMOITraceRequestException {

		return getPersistence().findByRequestedConsumerCode_PrevAndNext(
			requestId, requestedConsumerCode, orderByComparator);
	}

	/**
	 * Removes all the moi trace requests where requestedConsumerCode = &#63; from the database.
	 *
	 * @param requestedConsumerCode the requested consumer code
	 */
	public static void removeByRequestedConsumerCode(
		String requestedConsumerCode) {

		getPersistence().removeByRequestedConsumerCode(requestedConsumerCode);
	}

	/**
	 * Returns the number of moi trace requests where requestedConsumerCode = &#63;.
	 *
	 * @param requestedConsumerCode the requested consumer code
	 * @return the number of matching moi trace requests
	 */
	public static int countByRequestedConsumerCode(
		String requestedConsumerCode) {

		return getPersistence().countByRequestedConsumerCode(
			requestedConsumerCode);
	}

	/**
	 * Returns all the moi trace requests where requestedConsumerName = &#63;.
	 *
	 * @param requestedConsumerName the requested consumer name
	 * @return the matching moi trace requests
	 */
	public static List<MOITraceRequest> findByRequestedConsumerName(
		String requestedConsumerName) {

		return getPersistence().findByRequestedConsumerName(
			requestedConsumerName);
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
	public static List<MOITraceRequest> findByRequestedConsumerName(
		String requestedConsumerName, int start, int end) {

		return getPersistence().findByRequestedConsumerName(
			requestedConsumerName, start, end);
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
	public static List<MOITraceRequest> findByRequestedConsumerName(
		String requestedConsumerName, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return getPersistence().findByRequestedConsumerName(
			requestedConsumerName, start, end, orderByComparator);
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
	public static List<MOITraceRequest> findByRequestedConsumerName(
		String requestedConsumerName, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRequestedConsumerName(
			requestedConsumerName, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first moi trace request in the ordered set where requestedConsumerName = &#63;.
	 *
	 * @param requestedConsumerName the requested consumer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	public static MOITraceRequest findByRequestedConsumerName_First(
			String requestedConsumerName,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws com.moi.dms.trace.request.exception.
			NoSuchMOITraceRequestException {

		return getPersistence().findByRequestedConsumerName_First(
			requestedConsumerName, orderByComparator);
	}

	/**
	 * Returns the first moi trace request in the ordered set where requestedConsumerName = &#63;.
	 *
	 * @param requestedConsumerName the requested consumer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	public static MOITraceRequest fetchByRequestedConsumerName_First(
		String requestedConsumerName,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return getPersistence().fetchByRequestedConsumerName_First(
			requestedConsumerName, orderByComparator);
	}

	/**
	 * Returns the last moi trace request in the ordered set where requestedConsumerName = &#63;.
	 *
	 * @param requestedConsumerName the requested consumer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	public static MOITraceRequest findByRequestedConsumerName_Last(
			String requestedConsumerName,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws com.moi.dms.trace.request.exception.
			NoSuchMOITraceRequestException {

		return getPersistence().findByRequestedConsumerName_Last(
			requestedConsumerName, orderByComparator);
	}

	/**
	 * Returns the last moi trace request in the ordered set where requestedConsumerName = &#63;.
	 *
	 * @param requestedConsumerName the requested consumer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	public static MOITraceRequest fetchByRequestedConsumerName_Last(
		String requestedConsumerName,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return getPersistence().fetchByRequestedConsumerName_Last(
			requestedConsumerName, orderByComparator);
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
	public static MOITraceRequest[] findByRequestedConsumerName_PrevAndNext(
			long requestId, String requestedConsumerName,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws com.moi.dms.trace.request.exception.
			NoSuchMOITraceRequestException {

		return getPersistence().findByRequestedConsumerName_PrevAndNext(
			requestId, requestedConsumerName, orderByComparator);
	}

	/**
	 * Removes all the moi trace requests where requestedConsumerName = &#63; from the database.
	 *
	 * @param requestedConsumerName the requested consumer name
	 */
	public static void removeByRequestedConsumerName(
		String requestedConsumerName) {

		getPersistence().removeByRequestedConsumerName(requestedConsumerName);
	}

	/**
	 * Returns the number of moi trace requests where requestedConsumerName = &#63;.
	 *
	 * @param requestedConsumerName the requested consumer name
	 * @return the number of matching moi trace requests
	 */
	public static int countByRequestedConsumerName(
		String requestedConsumerName) {

		return getPersistence().countByRequestedConsumerName(
			requestedConsumerName);
	}

	/**
	 * Returns all the moi trace requests where requestedOperation = &#63;.
	 *
	 * @param requestedOperation the requested operation
	 * @return the matching moi trace requests
	 */
	public static List<MOITraceRequest> findByRequestedOperation(
		String requestedOperation) {

		return getPersistence().findByRequestedOperation(requestedOperation);
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
	public static List<MOITraceRequest> findByRequestedOperation(
		String requestedOperation, int start, int end) {

		return getPersistence().findByRequestedOperation(
			requestedOperation, start, end);
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
	public static List<MOITraceRequest> findByRequestedOperation(
		String requestedOperation, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return getPersistence().findByRequestedOperation(
			requestedOperation, start, end, orderByComparator);
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
	public static List<MOITraceRequest> findByRequestedOperation(
		String requestedOperation, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRequestedOperation(
			requestedOperation, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first moi trace request in the ordered set where requestedOperation = &#63;.
	 *
	 * @param requestedOperation the requested operation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	public static MOITraceRequest findByRequestedOperation_First(
			String requestedOperation,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws com.moi.dms.trace.request.exception.
			NoSuchMOITraceRequestException {

		return getPersistence().findByRequestedOperation_First(
			requestedOperation, orderByComparator);
	}

	/**
	 * Returns the first moi trace request in the ordered set where requestedOperation = &#63;.
	 *
	 * @param requestedOperation the requested operation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	public static MOITraceRequest fetchByRequestedOperation_First(
		String requestedOperation,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return getPersistence().fetchByRequestedOperation_First(
			requestedOperation, orderByComparator);
	}

	/**
	 * Returns the last moi trace request in the ordered set where requestedOperation = &#63;.
	 *
	 * @param requestedOperation the requested operation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	public static MOITraceRequest findByRequestedOperation_Last(
			String requestedOperation,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws com.moi.dms.trace.request.exception.
			NoSuchMOITraceRequestException {

		return getPersistence().findByRequestedOperation_Last(
			requestedOperation, orderByComparator);
	}

	/**
	 * Returns the last moi trace request in the ordered set where requestedOperation = &#63;.
	 *
	 * @param requestedOperation the requested operation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	public static MOITraceRequest fetchByRequestedOperation_Last(
		String requestedOperation,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return getPersistence().fetchByRequestedOperation_Last(
			requestedOperation, orderByComparator);
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
	public static MOITraceRequest[] findByRequestedOperation_PrevAndNext(
			long requestId, String requestedOperation,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws com.moi.dms.trace.request.exception.
			NoSuchMOITraceRequestException {

		return getPersistence().findByRequestedOperation_PrevAndNext(
			requestId, requestedOperation, orderByComparator);
	}

	/**
	 * Removes all the moi trace requests where requestedOperation = &#63; from the database.
	 *
	 * @param requestedOperation the requested operation
	 */
	public static void removeByRequestedOperation(String requestedOperation) {
		getPersistence().removeByRequestedOperation(requestedOperation);
	}

	/**
	 * Returns the number of moi trace requests where requestedOperation = &#63;.
	 *
	 * @param requestedOperation the requested operation
	 * @return the number of matching moi trace requests
	 */
	public static int countByRequestedOperation(String requestedOperation) {
		return getPersistence().countByRequestedOperation(requestedOperation);
	}

	/**
	 * Returns all the moi trace requests where requestResult = &#63;.
	 *
	 * @param requestResult the request result
	 * @return the matching moi trace requests
	 */
	public static List<MOITraceRequest> findByRequestResult(
		String requestResult) {

		return getPersistence().findByRequestResult(requestResult);
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
	public static List<MOITraceRequest> findByRequestResult(
		String requestResult, int start, int end) {

		return getPersistence().findByRequestResult(requestResult, start, end);
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
	public static List<MOITraceRequest> findByRequestResult(
		String requestResult, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return getPersistence().findByRequestResult(
			requestResult, start, end, orderByComparator);
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
	public static List<MOITraceRequest> findByRequestResult(
		String requestResult, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRequestResult(
			requestResult, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first moi trace request in the ordered set where requestResult = &#63;.
	 *
	 * @param requestResult the request result
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	public static MOITraceRequest findByRequestResult_First(
			String requestResult,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws com.moi.dms.trace.request.exception.
			NoSuchMOITraceRequestException {

		return getPersistence().findByRequestResult_First(
			requestResult, orderByComparator);
	}

	/**
	 * Returns the first moi trace request in the ordered set where requestResult = &#63;.
	 *
	 * @param requestResult the request result
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	public static MOITraceRequest fetchByRequestResult_First(
		String requestResult,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return getPersistence().fetchByRequestResult_First(
			requestResult, orderByComparator);
	}

	/**
	 * Returns the last moi trace request in the ordered set where requestResult = &#63;.
	 *
	 * @param requestResult the request result
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	public static MOITraceRequest findByRequestResult_Last(
			String requestResult,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws com.moi.dms.trace.request.exception.
			NoSuchMOITraceRequestException {

		return getPersistence().findByRequestResult_Last(
			requestResult, orderByComparator);
	}

	/**
	 * Returns the last moi trace request in the ordered set where requestResult = &#63;.
	 *
	 * @param requestResult the request result
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	public static MOITraceRequest fetchByRequestResult_Last(
		String requestResult,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return getPersistence().fetchByRequestResult_Last(
			requestResult, orderByComparator);
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
	public static MOITraceRequest[] findByRequestResult_PrevAndNext(
			long requestId, String requestResult,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws com.moi.dms.trace.request.exception.
			NoSuchMOITraceRequestException {

		return getPersistence().findByRequestResult_PrevAndNext(
			requestId, requestResult, orderByComparator);
	}

	/**
	 * Removes all the moi trace requests where requestResult = &#63; from the database.
	 *
	 * @param requestResult the request result
	 */
	public static void removeByRequestResult(String requestResult) {
		getPersistence().removeByRequestResult(requestResult);
	}

	/**
	 * Returns the number of moi trace requests where requestResult = &#63;.
	 *
	 * @param requestResult the request result
	 * @return the number of matching moi trace requests
	 */
	public static int countByRequestResult(String requestResult) {
		return getPersistence().countByRequestResult(requestResult);
	}

	/**
	 * Returns all the moi trace requests where requestResultDate = &#63;.
	 *
	 * @param requestResultDate the request result date
	 * @return the matching moi trace requests
	 */
	public static List<MOITraceRequest> findByRequestResultDate(
		Date requestResultDate) {

		return getPersistence().findByRequestResultDate(requestResultDate);
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
	public static List<MOITraceRequest> findByRequestResultDate(
		Date requestResultDate, int start, int end) {

		return getPersistence().findByRequestResultDate(
			requestResultDate, start, end);
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
	public static List<MOITraceRequest> findByRequestResultDate(
		Date requestResultDate, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return getPersistence().findByRequestResultDate(
			requestResultDate, start, end, orderByComparator);
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
	public static List<MOITraceRequest> findByRequestResultDate(
		Date requestResultDate, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRequestResultDate(
			requestResultDate, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first moi trace request in the ordered set where requestResultDate = &#63;.
	 *
	 * @param requestResultDate the request result date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	public static MOITraceRequest findByRequestResultDate_First(
			Date requestResultDate,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws com.moi.dms.trace.request.exception.
			NoSuchMOITraceRequestException {

		return getPersistence().findByRequestResultDate_First(
			requestResultDate, orderByComparator);
	}

	/**
	 * Returns the first moi trace request in the ordered set where requestResultDate = &#63;.
	 *
	 * @param requestResultDate the request result date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	public static MOITraceRequest fetchByRequestResultDate_First(
		Date requestResultDate,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return getPersistence().fetchByRequestResultDate_First(
			requestResultDate, orderByComparator);
	}

	/**
	 * Returns the last moi trace request in the ordered set where requestResultDate = &#63;.
	 *
	 * @param requestResultDate the request result date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	public static MOITraceRequest findByRequestResultDate_Last(
			Date requestResultDate,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws com.moi.dms.trace.request.exception.
			NoSuchMOITraceRequestException {

		return getPersistence().findByRequestResultDate_Last(
			requestResultDate, orderByComparator);
	}

	/**
	 * Returns the last moi trace request in the ordered set where requestResultDate = &#63;.
	 *
	 * @param requestResultDate the request result date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	public static MOITraceRequest fetchByRequestResultDate_Last(
		Date requestResultDate,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return getPersistence().fetchByRequestResultDate_Last(
			requestResultDate, orderByComparator);
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
	public static MOITraceRequest[] findByRequestResultDate_PrevAndNext(
			long requestId, Date requestResultDate,
			OrderByComparator<MOITraceRequest> orderByComparator)
		throws com.moi.dms.trace.request.exception.
			NoSuchMOITraceRequestException {

		return getPersistence().findByRequestResultDate_PrevAndNext(
			requestId, requestResultDate, orderByComparator);
	}

	/**
	 * Removes all the moi trace requests where requestResultDate = &#63; from the database.
	 *
	 * @param requestResultDate the request result date
	 */
	public static void removeByRequestResultDate(Date requestResultDate) {
		getPersistence().removeByRequestResultDate(requestResultDate);
	}

	/**
	 * Returns the number of moi trace requests where requestResultDate = &#63;.
	 *
	 * @param requestResultDate the request result date
	 * @return the number of matching moi trace requests
	 */
	public static int countByRequestResultDate(Date requestResultDate) {
		return getPersistence().countByRequestResultDate(requestResultDate);
	}

	/**
	 * Caches the moi trace request in the entity cache if it is enabled.
	 *
	 * @param moiTraceRequest the moi trace request
	 */
	public static void cacheResult(MOITraceRequest moiTraceRequest) {
		getPersistence().cacheResult(moiTraceRequest);
	}

	/**
	 * Caches the moi trace requests in the entity cache if it is enabled.
	 *
	 * @param moiTraceRequests the moi trace requests
	 */
	public static void cacheResult(List<MOITraceRequest> moiTraceRequests) {
		getPersistence().cacheResult(moiTraceRequests);
	}

	/**
	 * Creates a new moi trace request with the primary key. Does not add the moi trace request to the database.
	 *
	 * @param requestId the primary key for the new moi trace request
	 * @return the new moi trace request
	 */
	public static MOITraceRequest create(long requestId) {
		return getPersistence().create(requestId);
	}

	/**
	 * Removes the moi trace request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param requestId the primary key of the moi trace request
	 * @return the moi trace request that was removed
	 * @throws NoSuchMOITraceRequestException if a moi trace request with the primary key could not be found
	 */
	public static MOITraceRequest remove(long requestId)
		throws com.moi.dms.trace.request.exception.
			NoSuchMOITraceRequestException {

		return getPersistence().remove(requestId);
	}

	public static MOITraceRequest updateImpl(MOITraceRequest moiTraceRequest) {
		return getPersistence().updateImpl(moiTraceRequest);
	}

	/**
	 * Returns the moi trace request with the primary key or throws a <code>NoSuchMOITraceRequestException</code> if it could not be found.
	 *
	 * @param requestId the primary key of the moi trace request
	 * @return the moi trace request
	 * @throws NoSuchMOITraceRequestException if a moi trace request with the primary key could not be found
	 */
	public static MOITraceRequest findByPrimaryKey(long requestId)
		throws com.moi.dms.trace.request.exception.
			NoSuchMOITraceRequestException {

		return getPersistence().findByPrimaryKey(requestId);
	}

	/**
	 * Returns the moi trace request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param requestId the primary key of the moi trace request
	 * @return the moi trace request, or <code>null</code> if a moi trace request with the primary key could not be found
	 */
	public static MOITraceRequest fetchByPrimaryKey(long requestId) {
		return getPersistence().fetchByPrimaryKey(requestId);
	}

	/**
	 * Returns all the moi trace requests.
	 *
	 * @return the moi trace requests
	 */
	public static List<MOITraceRequest> findAll() {
		return getPersistence().findAll();
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
	public static List<MOITraceRequest> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<MOITraceRequest> findAll(
		int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<MOITraceRequest> findAll(
		int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the moi trace requests from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of moi trace requests.
	 *
	 * @return the number of moi trace requests
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MOITraceRequestPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<MOITraceRequestPersistence, MOITraceRequestPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			MOITraceRequestPersistence.class);

		ServiceTracker<MOITraceRequestPersistence, MOITraceRequestPersistence>
			serviceTracker =
				new ServiceTracker
					<MOITraceRequestPersistence, MOITraceRequestPersistence>(
						bundle.getBundleContext(),
						MOITraceRequestPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}