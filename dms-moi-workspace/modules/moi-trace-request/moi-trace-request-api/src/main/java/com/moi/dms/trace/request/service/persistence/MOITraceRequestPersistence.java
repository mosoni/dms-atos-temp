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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.moi.dms.trace.request.exception.NoSuchMOITraceRequestException;
import com.moi.dms.trace.request.model.MOITraceRequest;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the moi trace request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MOITraceRequestUtil
 * @generated
 */
@ProviderType
public interface MOITraceRequestPersistence
	extends BasePersistence<MOITraceRequest> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MOITraceRequestUtil} to access the moi trace request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the moi trace requests where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @return the matching moi trace requests
	 */
	public java.util.List<MOITraceRequest> findByRequestId(long requestId);

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
	public java.util.List<MOITraceRequest> findByRequestId(
		long requestId, int start, int end);

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
	public java.util.List<MOITraceRequest> findByRequestId(
		long requestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator);

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
	public java.util.List<MOITraceRequest> findByRequestId(
		long requestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi trace request in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	public MOITraceRequest findByRequestId_First(
			long requestId,
			com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
				orderByComparator)
		throws NoSuchMOITraceRequestException;

	/**
	 * Returns the first moi trace request in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	public MOITraceRequest fetchByRequestId_First(
		long requestId,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator);

	/**
	 * Returns the last moi trace request in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	public MOITraceRequest findByRequestId_Last(
			long requestId,
			com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
				orderByComparator)
		throws NoSuchMOITraceRequestException;

	/**
	 * Returns the last moi trace request in the ordered set where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	public MOITraceRequest fetchByRequestId_Last(
		long requestId,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator);

	/**
	 * Removes all the moi trace requests where requestId = &#63; from the database.
	 *
	 * @param requestId the request ID
	 */
	public void removeByRequestId(long requestId);

	/**
	 * Returns the number of moi trace requests where requestId = &#63;.
	 *
	 * @param requestId the request ID
	 * @return the number of matching moi trace requests
	 */
	public int countByRequestId(long requestId);

	/**
	 * Returns all the moi trace requests where requestedBy = &#63;.
	 *
	 * @param requestedBy the requested by
	 * @return the matching moi trace requests
	 */
	public java.util.List<MOITraceRequest> findByRequestedBy(
		String requestedBy);

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
	public java.util.List<MOITraceRequest> findByRequestedBy(
		String requestedBy, int start, int end);

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
	public java.util.List<MOITraceRequest> findByRequestedBy(
		String requestedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator);

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
	public java.util.List<MOITraceRequest> findByRequestedBy(
		String requestedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi trace request in the ordered set where requestedBy = &#63;.
	 *
	 * @param requestedBy the requested by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	public MOITraceRequest findByRequestedBy_First(
			String requestedBy,
			com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
				orderByComparator)
		throws NoSuchMOITraceRequestException;

	/**
	 * Returns the first moi trace request in the ordered set where requestedBy = &#63;.
	 *
	 * @param requestedBy the requested by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	public MOITraceRequest fetchByRequestedBy_First(
		String requestedBy,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator);

	/**
	 * Returns the last moi trace request in the ordered set where requestedBy = &#63;.
	 *
	 * @param requestedBy the requested by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	public MOITraceRequest findByRequestedBy_Last(
			String requestedBy,
			com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
				orderByComparator)
		throws NoSuchMOITraceRequestException;

	/**
	 * Returns the last moi trace request in the ordered set where requestedBy = &#63;.
	 *
	 * @param requestedBy the requested by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	public MOITraceRequest fetchByRequestedBy_Last(
		String requestedBy,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator);

	/**
	 * Returns the moi trace requests before and after the current moi trace request in the ordered set where requestedBy = &#63;.
	 *
	 * @param requestId the primary key of the current moi trace request
	 * @param requestedBy the requested by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi trace request
	 * @throws NoSuchMOITraceRequestException if a moi trace request with the primary key could not be found
	 */
	public MOITraceRequest[] findByRequestedBy_PrevAndNext(
			long requestId, String requestedBy,
			com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
				orderByComparator)
		throws NoSuchMOITraceRequestException;

	/**
	 * Removes all the moi trace requests where requestedBy = &#63; from the database.
	 *
	 * @param requestedBy the requested by
	 */
	public void removeByRequestedBy(String requestedBy);

	/**
	 * Returns the number of moi trace requests where requestedBy = &#63;.
	 *
	 * @param requestedBy the requested by
	 * @return the number of matching moi trace requests
	 */
	public int countByRequestedBy(String requestedBy);

	/**
	 * Returns all the moi trace requests where requestIncomingDate = &#63;.
	 *
	 * @param requestIncomingDate the request incoming date
	 * @return the matching moi trace requests
	 */
	public java.util.List<MOITraceRequest> findByRequestIncomingDate(
		Date requestIncomingDate);

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
	public java.util.List<MOITraceRequest> findByRequestIncomingDate(
		Date requestIncomingDate, int start, int end);

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
	public java.util.List<MOITraceRequest> findByRequestIncomingDate(
		Date requestIncomingDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator);

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
	public java.util.List<MOITraceRequest> findByRequestIncomingDate(
		Date requestIncomingDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi trace request in the ordered set where requestIncomingDate = &#63;.
	 *
	 * @param requestIncomingDate the request incoming date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	public MOITraceRequest findByRequestIncomingDate_First(
			Date requestIncomingDate,
			com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
				orderByComparator)
		throws NoSuchMOITraceRequestException;

	/**
	 * Returns the first moi trace request in the ordered set where requestIncomingDate = &#63;.
	 *
	 * @param requestIncomingDate the request incoming date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	public MOITraceRequest fetchByRequestIncomingDate_First(
		Date requestIncomingDate,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator);

	/**
	 * Returns the last moi trace request in the ordered set where requestIncomingDate = &#63;.
	 *
	 * @param requestIncomingDate the request incoming date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	public MOITraceRequest findByRequestIncomingDate_Last(
			Date requestIncomingDate,
			com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
				orderByComparator)
		throws NoSuchMOITraceRequestException;

	/**
	 * Returns the last moi trace request in the ordered set where requestIncomingDate = &#63;.
	 *
	 * @param requestIncomingDate the request incoming date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	public MOITraceRequest fetchByRequestIncomingDate_Last(
		Date requestIncomingDate,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator);

	/**
	 * Returns the moi trace requests before and after the current moi trace request in the ordered set where requestIncomingDate = &#63;.
	 *
	 * @param requestId the primary key of the current moi trace request
	 * @param requestIncomingDate the request incoming date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi trace request
	 * @throws NoSuchMOITraceRequestException if a moi trace request with the primary key could not be found
	 */
	public MOITraceRequest[] findByRequestIncomingDate_PrevAndNext(
			long requestId, Date requestIncomingDate,
			com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
				orderByComparator)
		throws NoSuchMOITraceRequestException;

	/**
	 * Removes all the moi trace requests where requestIncomingDate = &#63; from the database.
	 *
	 * @param requestIncomingDate the request incoming date
	 */
	public void removeByRequestIncomingDate(Date requestIncomingDate);

	/**
	 * Returns the number of moi trace requests where requestIncomingDate = &#63;.
	 *
	 * @param requestIncomingDate the request incoming date
	 * @return the number of matching moi trace requests
	 */
	public int countByRequestIncomingDate(Date requestIncomingDate);

	/**
	 * Returns all the moi trace requests where requestedConsumerCode = &#63;.
	 *
	 * @param requestedConsumerCode the requested consumer code
	 * @return the matching moi trace requests
	 */
	public java.util.List<MOITraceRequest> findByRequestedConsumerCode(
		String requestedConsumerCode);

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
	public java.util.List<MOITraceRequest> findByRequestedConsumerCode(
		String requestedConsumerCode, int start, int end);

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
	public java.util.List<MOITraceRequest> findByRequestedConsumerCode(
		String requestedConsumerCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator);

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
	public java.util.List<MOITraceRequest> findByRequestedConsumerCode(
		String requestedConsumerCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi trace request in the ordered set where requestedConsumerCode = &#63;.
	 *
	 * @param requestedConsumerCode the requested consumer code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	public MOITraceRequest findByRequestedConsumerCode_First(
			String requestedConsumerCode,
			com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
				orderByComparator)
		throws NoSuchMOITraceRequestException;

	/**
	 * Returns the first moi trace request in the ordered set where requestedConsumerCode = &#63;.
	 *
	 * @param requestedConsumerCode the requested consumer code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	public MOITraceRequest fetchByRequestedConsumerCode_First(
		String requestedConsumerCode,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator);

	/**
	 * Returns the last moi trace request in the ordered set where requestedConsumerCode = &#63;.
	 *
	 * @param requestedConsumerCode the requested consumer code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	public MOITraceRequest findByRequestedConsumerCode_Last(
			String requestedConsumerCode,
			com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
				orderByComparator)
		throws NoSuchMOITraceRequestException;

	/**
	 * Returns the last moi trace request in the ordered set where requestedConsumerCode = &#63;.
	 *
	 * @param requestedConsumerCode the requested consumer code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	public MOITraceRequest fetchByRequestedConsumerCode_Last(
		String requestedConsumerCode,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator);

	/**
	 * Returns the moi trace requests before and after the current moi trace request in the ordered set where requestedConsumerCode = &#63;.
	 *
	 * @param requestId the primary key of the current moi trace request
	 * @param requestedConsumerCode the requested consumer code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi trace request
	 * @throws NoSuchMOITraceRequestException if a moi trace request with the primary key could not be found
	 */
	public MOITraceRequest[] findByRequestedConsumerCode_PrevAndNext(
			long requestId, String requestedConsumerCode,
			com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
				orderByComparator)
		throws NoSuchMOITraceRequestException;

	/**
	 * Removes all the moi trace requests where requestedConsumerCode = &#63; from the database.
	 *
	 * @param requestedConsumerCode the requested consumer code
	 */
	public void removeByRequestedConsumerCode(String requestedConsumerCode);

	/**
	 * Returns the number of moi trace requests where requestedConsumerCode = &#63;.
	 *
	 * @param requestedConsumerCode the requested consumer code
	 * @return the number of matching moi trace requests
	 */
	public int countByRequestedConsumerCode(String requestedConsumerCode);

	/**
	 * Returns all the moi trace requests where requestedConsumerName = &#63;.
	 *
	 * @param requestedConsumerName the requested consumer name
	 * @return the matching moi trace requests
	 */
	public java.util.List<MOITraceRequest> findByRequestedConsumerName(
		String requestedConsumerName);

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
	public java.util.List<MOITraceRequest> findByRequestedConsumerName(
		String requestedConsumerName, int start, int end);

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
	public java.util.List<MOITraceRequest> findByRequestedConsumerName(
		String requestedConsumerName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator);

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
	public java.util.List<MOITraceRequest> findByRequestedConsumerName(
		String requestedConsumerName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi trace request in the ordered set where requestedConsumerName = &#63;.
	 *
	 * @param requestedConsumerName the requested consumer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	public MOITraceRequest findByRequestedConsumerName_First(
			String requestedConsumerName,
			com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
				orderByComparator)
		throws NoSuchMOITraceRequestException;

	/**
	 * Returns the first moi trace request in the ordered set where requestedConsumerName = &#63;.
	 *
	 * @param requestedConsumerName the requested consumer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	public MOITraceRequest fetchByRequestedConsumerName_First(
		String requestedConsumerName,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator);

	/**
	 * Returns the last moi trace request in the ordered set where requestedConsumerName = &#63;.
	 *
	 * @param requestedConsumerName the requested consumer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	public MOITraceRequest findByRequestedConsumerName_Last(
			String requestedConsumerName,
			com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
				orderByComparator)
		throws NoSuchMOITraceRequestException;

	/**
	 * Returns the last moi trace request in the ordered set where requestedConsumerName = &#63;.
	 *
	 * @param requestedConsumerName the requested consumer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	public MOITraceRequest fetchByRequestedConsumerName_Last(
		String requestedConsumerName,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator);

	/**
	 * Returns the moi trace requests before and after the current moi trace request in the ordered set where requestedConsumerName = &#63;.
	 *
	 * @param requestId the primary key of the current moi trace request
	 * @param requestedConsumerName the requested consumer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi trace request
	 * @throws NoSuchMOITraceRequestException if a moi trace request with the primary key could not be found
	 */
	public MOITraceRequest[] findByRequestedConsumerName_PrevAndNext(
			long requestId, String requestedConsumerName,
			com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
				orderByComparator)
		throws NoSuchMOITraceRequestException;

	/**
	 * Removes all the moi trace requests where requestedConsumerName = &#63; from the database.
	 *
	 * @param requestedConsumerName the requested consumer name
	 */
	public void removeByRequestedConsumerName(String requestedConsumerName);

	/**
	 * Returns the number of moi trace requests where requestedConsumerName = &#63;.
	 *
	 * @param requestedConsumerName the requested consumer name
	 * @return the number of matching moi trace requests
	 */
	public int countByRequestedConsumerName(String requestedConsumerName);

	/**
	 * Returns all the moi trace requests where requestedOperation = &#63;.
	 *
	 * @param requestedOperation the requested operation
	 * @return the matching moi trace requests
	 */
	public java.util.List<MOITraceRequest> findByRequestedOperation(
		String requestedOperation);

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
	public java.util.List<MOITraceRequest> findByRequestedOperation(
		String requestedOperation, int start, int end);

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
	public java.util.List<MOITraceRequest> findByRequestedOperation(
		String requestedOperation, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator);

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
	public java.util.List<MOITraceRequest> findByRequestedOperation(
		String requestedOperation, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi trace request in the ordered set where requestedOperation = &#63;.
	 *
	 * @param requestedOperation the requested operation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	public MOITraceRequest findByRequestedOperation_First(
			String requestedOperation,
			com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
				orderByComparator)
		throws NoSuchMOITraceRequestException;

	/**
	 * Returns the first moi trace request in the ordered set where requestedOperation = &#63;.
	 *
	 * @param requestedOperation the requested operation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	public MOITraceRequest fetchByRequestedOperation_First(
		String requestedOperation,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator);

	/**
	 * Returns the last moi trace request in the ordered set where requestedOperation = &#63;.
	 *
	 * @param requestedOperation the requested operation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	public MOITraceRequest findByRequestedOperation_Last(
			String requestedOperation,
			com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
				orderByComparator)
		throws NoSuchMOITraceRequestException;

	/**
	 * Returns the last moi trace request in the ordered set where requestedOperation = &#63;.
	 *
	 * @param requestedOperation the requested operation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	public MOITraceRequest fetchByRequestedOperation_Last(
		String requestedOperation,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator);

	/**
	 * Returns the moi trace requests before and after the current moi trace request in the ordered set where requestedOperation = &#63;.
	 *
	 * @param requestId the primary key of the current moi trace request
	 * @param requestedOperation the requested operation
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi trace request
	 * @throws NoSuchMOITraceRequestException if a moi trace request with the primary key could not be found
	 */
	public MOITraceRequest[] findByRequestedOperation_PrevAndNext(
			long requestId, String requestedOperation,
			com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
				orderByComparator)
		throws NoSuchMOITraceRequestException;

	/**
	 * Removes all the moi trace requests where requestedOperation = &#63; from the database.
	 *
	 * @param requestedOperation the requested operation
	 */
	public void removeByRequestedOperation(String requestedOperation);

	/**
	 * Returns the number of moi trace requests where requestedOperation = &#63;.
	 *
	 * @param requestedOperation the requested operation
	 * @return the number of matching moi trace requests
	 */
	public int countByRequestedOperation(String requestedOperation);

	/**
	 * Returns all the moi trace requests where requestResult = &#63;.
	 *
	 * @param requestResult the request result
	 * @return the matching moi trace requests
	 */
	public java.util.List<MOITraceRequest> findByRequestResult(
		String requestResult);

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
	public java.util.List<MOITraceRequest> findByRequestResult(
		String requestResult, int start, int end);

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
	public java.util.List<MOITraceRequest> findByRequestResult(
		String requestResult, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator);

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
	public java.util.List<MOITraceRequest> findByRequestResult(
		String requestResult, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi trace request in the ordered set where requestResult = &#63;.
	 *
	 * @param requestResult the request result
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	public MOITraceRequest findByRequestResult_First(
			String requestResult,
			com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
				orderByComparator)
		throws NoSuchMOITraceRequestException;

	/**
	 * Returns the first moi trace request in the ordered set where requestResult = &#63;.
	 *
	 * @param requestResult the request result
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	public MOITraceRequest fetchByRequestResult_First(
		String requestResult,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator);

	/**
	 * Returns the last moi trace request in the ordered set where requestResult = &#63;.
	 *
	 * @param requestResult the request result
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	public MOITraceRequest findByRequestResult_Last(
			String requestResult,
			com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
				orderByComparator)
		throws NoSuchMOITraceRequestException;

	/**
	 * Returns the last moi trace request in the ordered set where requestResult = &#63;.
	 *
	 * @param requestResult the request result
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	public MOITraceRequest fetchByRequestResult_Last(
		String requestResult,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator);

	/**
	 * Returns the moi trace requests before and after the current moi trace request in the ordered set where requestResult = &#63;.
	 *
	 * @param requestId the primary key of the current moi trace request
	 * @param requestResult the request result
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi trace request
	 * @throws NoSuchMOITraceRequestException if a moi trace request with the primary key could not be found
	 */
	public MOITraceRequest[] findByRequestResult_PrevAndNext(
			long requestId, String requestResult,
			com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
				orderByComparator)
		throws NoSuchMOITraceRequestException;

	/**
	 * Removes all the moi trace requests where requestResult = &#63; from the database.
	 *
	 * @param requestResult the request result
	 */
	public void removeByRequestResult(String requestResult);

	/**
	 * Returns the number of moi trace requests where requestResult = &#63;.
	 *
	 * @param requestResult the request result
	 * @return the number of matching moi trace requests
	 */
	public int countByRequestResult(String requestResult);

	/**
	 * Returns all the moi trace requests where requestResultDate = &#63;.
	 *
	 * @param requestResultDate the request result date
	 * @return the matching moi trace requests
	 */
	public java.util.List<MOITraceRequest> findByRequestResultDate(
		Date requestResultDate);

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
	public java.util.List<MOITraceRequest> findByRequestResultDate(
		Date requestResultDate, int start, int end);

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
	public java.util.List<MOITraceRequest> findByRequestResultDate(
		Date requestResultDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator);

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
	public java.util.List<MOITraceRequest> findByRequestResultDate(
		Date requestResultDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi trace request in the ordered set where requestResultDate = &#63;.
	 *
	 * @param requestResultDate the request result date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	public MOITraceRequest findByRequestResultDate_First(
			Date requestResultDate,
			com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
				orderByComparator)
		throws NoSuchMOITraceRequestException;

	/**
	 * Returns the first moi trace request in the ordered set where requestResultDate = &#63;.
	 *
	 * @param requestResultDate the request result date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	public MOITraceRequest fetchByRequestResultDate_First(
		Date requestResultDate,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator);

	/**
	 * Returns the last moi trace request in the ordered set where requestResultDate = &#63;.
	 *
	 * @param requestResultDate the request result date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request
	 * @throws NoSuchMOITraceRequestException if a matching moi trace request could not be found
	 */
	public MOITraceRequest findByRequestResultDate_Last(
			Date requestResultDate,
			com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
				orderByComparator)
		throws NoSuchMOITraceRequestException;

	/**
	 * Returns the last moi trace request in the ordered set where requestResultDate = &#63;.
	 *
	 * @param requestResultDate the request result date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi trace request, or <code>null</code> if a matching moi trace request could not be found
	 */
	public MOITraceRequest fetchByRequestResultDate_Last(
		Date requestResultDate,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator);

	/**
	 * Returns the moi trace requests before and after the current moi trace request in the ordered set where requestResultDate = &#63;.
	 *
	 * @param requestId the primary key of the current moi trace request
	 * @param requestResultDate the request result date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi trace request
	 * @throws NoSuchMOITraceRequestException if a moi trace request with the primary key could not be found
	 */
	public MOITraceRequest[] findByRequestResultDate_PrevAndNext(
			long requestId, Date requestResultDate,
			com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
				orderByComparator)
		throws NoSuchMOITraceRequestException;

	/**
	 * Removes all the moi trace requests where requestResultDate = &#63; from the database.
	 *
	 * @param requestResultDate the request result date
	 */
	public void removeByRequestResultDate(Date requestResultDate);

	/**
	 * Returns the number of moi trace requests where requestResultDate = &#63;.
	 *
	 * @param requestResultDate the request result date
	 * @return the number of matching moi trace requests
	 */
	public int countByRequestResultDate(Date requestResultDate);

	/**
	 * Caches the moi trace request in the entity cache if it is enabled.
	 *
	 * @param moiTraceRequest the moi trace request
	 */
	public void cacheResult(MOITraceRequest moiTraceRequest);

	/**
	 * Caches the moi trace requests in the entity cache if it is enabled.
	 *
	 * @param moiTraceRequests the moi trace requests
	 */
	public void cacheResult(java.util.List<MOITraceRequest> moiTraceRequests);

	/**
	 * Creates a new moi trace request with the primary key. Does not add the moi trace request to the database.
	 *
	 * @param requestId the primary key for the new moi trace request
	 * @return the new moi trace request
	 */
	public MOITraceRequest create(long requestId);

	/**
	 * Removes the moi trace request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param requestId the primary key of the moi trace request
	 * @return the moi trace request that was removed
	 * @throws NoSuchMOITraceRequestException if a moi trace request with the primary key could not be found
	 */
	public MOITraceRequest remove(long requestId)
		throws NoSuchMOITraceRequestException;

	public MOITraceRequest updateImpl(MOITraceRequest moiTraceRequest);

	/**
	 * Returns the moi trace request with the primary key or throws a <code>NoSuchMOITraceRequestException</code> if it could not be found.
	 *
	 * @param requestId the primary key of the moi trace request
	 * @return the moi trace request
	 * @throws NoSuchMOITraceRequestException if a moi trace request with the primary key could not be found
	 */
	public MOITraceRequest findByPrimaryKey(long requestId)
		throws NoSuchMOITraceRequestException;

	/**
	 * Returns the moi trace request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param requestId the primary key of the moi trace request
	 * @return the moi trace request, or <code>null</code> if a moi trace request with the primary key could not be found
	 */
	public MOITraceRequest fetchByPrimaryKey(long requestId);

	/**
	 * Returns all the moi trace requests.
	 *
	 * @return the moi trace requests
	 */
	public java.util.List<MOITraceRequest> findAll();

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
	public java.util.List<MOITraceRequest> findAll(int start, int end);

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
	public java.util.List<MOITraceRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator);

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
	public java.util.List<MOITraceRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOITraceRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the moi trace requests from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of moi trace requests.
	 *
	 * @return the number of moi trace requests
	 */
	public int countAll();

}