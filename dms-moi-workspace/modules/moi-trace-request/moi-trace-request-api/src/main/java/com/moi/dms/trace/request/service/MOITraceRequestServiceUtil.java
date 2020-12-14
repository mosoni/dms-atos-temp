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

package com.moi.dms.trace.request.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for MOITraceRequest. This utility wraps
 * <code>com.moi.dms.trace.request.service.impl.MOITraceRequestServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see MOITraceRequestService
 * @generated
 */
public class MOITraceRequestServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.moi.dms.trace.request.service.impl.MOITraceRequestServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Remote service to add MOITraceRequest.
	 *
	 * @param requestedBy
	 * @param requestIncomingDate
	 * @param requestedConsumerCode
	 * @param requestedConsumerName
	 * @param requestedOperation
	 * @param requestedDocumentType
	 * @param requestValid
	 * @param requestResult
	 * @param requestResultDate
	 * @return MOITraceRequest
	 * @throws PortalException
	 */
	public static com.moi.dms.trace.request.model.MOITraceRequest
			addMOITraceRequest(
				String requestedBy, java.util.Date requestIncomingDate,
				String requestedConsumerCode, String requestedConsumerName,
				String requestedOperation, String requestedDocumentType,
				Boolean requestValid, String requestResult,
				java.util.Date requestResultDate)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addMOITraceRequest(
			requestedBy, requestIncomingDate, requestedConsumerCode,
			requestedConsumerName, requestedOperation, requestedDocumentType,
			requestValid, requestResult, requestResultDate);
	}

	/**
	 * Remote service to delete MOITraceRequest.
	 *
	 * @param requestId
	 * @return MOITraceRequest
	 * @throws PortalException
	 */
	public static com.moi.dms.trace.request.model.MOITraceRequest
			deleteMOITraceRequest(long requestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteMOITraceRequest(requestId);
	}

	/**
	 * Finder method for all MOITraceRequests.
	 *
	 * @return List<MOITraceRequest>
	 */
	public static java.util.List
		<com.moi.dms.trace.request.model.MOITraceRequest>
			getAllMOITraceRequests() {

		return getService().getAllMOITraceRequests();
	}

	/**
	 * Remote service to get MOITraceRequest by id.
	 *
	 * @param requestId
	 * @return MOITraceRequest
	 * @throws PortalException
	 */
	public static com.moi.dms.trace.request.model.MOITraceRequest
			getMOITraceRequest(long requestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getMOITraceRequest(requestId);
	}

	/**
	 * Finder method for MOITraceRequest by Search criteria.
	 *
	 * @param keywords
	 * @param fromDate
	 * @param toDate
	 * @return List<MOITraceRequest>
	 */
	public static java.util.List
		<com.moi.dms.trace.request.model.MOITraceRequest>
			getMOITraceRequestBySearchCriteria(
				String keywords, String fromDate, String toDate) {

		return getService().getMOITraceRequestBySearchCriteria(
			keywords, fromDate, toDate);
	}

	/**
	 * Remote service to fetch MOITraceRequest using keywords
	 *
	 * @param keywords
	 * @param fromDate
	 * @param toDate
	 * @param start
	 * @param end
	 * @param orderByComparator
	 * @return List<MOITraceRequest>
	 */
	public static java.util.List
		<com.moi.dms.trace.request.model.MOITraceRequest>
			getMOITraceRequestBySearchCriteria(
				String keywords, String fromDate, String toDate, int start,
				int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.moi.dms.trace.request.model.MOITraceRequest>
						orderByComparator) {

		return getService().getMOITraceRequestBySearchCriteria(
			keywords, fromDate, toDate, start, end, orderByComparator);
	}

	/**
	 * Remote service to fetch MOITraceRequest Count.
	 *
	 * @param keywords
	 * @param fromDate
	 * @param toDate
	 * @return long
	 */
	public static long getMOITraceRequestCountBySearchCriteria(
		String keywords, String fromDate, String toDate) {

		return getService().getMOITraceRequestCountBySearchCriteria(
			keywords, fromDate, toDate);
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
	 * Remote service to update MOITraceRequest.
	 *
	 * @param requestId
	 * @param requestedBy
	 * @param requestIncomingDate
	 * @param requestedConsumerCode
	 * @param requestedConsumerName
	 * @param requestedOperation
	 * @param requestedDocumentType
	 * @param requestValid
	 * @param requestResult
	 * @param requestResultDate
	 * @return MOITraceRequest
	 * @throws PortalException
	 */
	public static com.moi.dms.trace.request.model.MOITraceRequest
			updateMOITraceRequest(
				long requestId, String requestedBy,
				java.util.Date requestIncomingDate,
				String requestedConsumerCode, String requestedConsumerName,
				String requestedOperation, String requestedDocumentType,
				Boolean requestValid, String requestResult,
				java.util.Date requestResultDate)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateMOITraceRequest(
			requestId, requestedBy, requestIncomingDate, requestedConsumerCode,
			requestedConsumerName, requestedOperation, requestedDocumentType,
			requestValid, requestResult, requestResultDate);
	}

	public static MOITraceRequestService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<MOITraceRequestService, MOITraceRequestService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MOITraceRequestService.class);

		ServiceTracker<MOITraceRequestService, MOITraceRequestService>
			serviceTracker =
				new ServiceTracker
					<MOITraceRequestService, MOITraceRequestService>(
						bundle.getBundleContext(), MOITraceRequestService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}