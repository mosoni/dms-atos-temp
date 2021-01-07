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
 * Provides the local service utility for MOITraceRequest. This utility wraps
 * <code>com.moi.dms.trace.request.service.impl.MOITraceRequestLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MOITraceRequestLocalService
 * @generated
 */
public class MOITraceRequestLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.moi.dms.trace.request.service.impl.MOITraceRequestLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the moi trace request to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MOITraceRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param moiTraceRequest the moi trace request
	 * @return the moi trace request that was added
	 */
	public static com.moi.dms.trace.request.model.MOITraceRequest
		addMOITraceRequest(
			com.moi.dms.trace.request.model.MOITraceRequest moiTraceRequest) {

		return getService().addMOITraceRequest(moiTraceRequest);
	}

	/**
	 * Overloaded method to create new MOITraceRequest entry. This method should
	 * be used instead of the original method.
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
	 * @param requestComment
	 * @return MOITraceRequest
	 * @throws PortalException
	 */
	public static com.moi.dms.trace.request.model.MOITraceRequest
			addMOITraceRequest(
				String requestedBy, java.util.Date requestIncomingDate,
				String requestedConsumerCode, String requestedConsumerName,
				String requestedOperation, String requestedDocumentType,
				Boolean requestValid, String requestResult,
				java.util.Date requestResultDate, String requestComment)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addMOITraceRequest(
			requestedBy, requestIncomingDate, requestedConsumerCode,
			requestedConsumerName, requestedOperation, requestedDocumentType,
			requestValid, requestResult, requestResultDate, requestComment);
	}

	/**
	 * Creates a new moi trace request with the primary key. Does not add the moi trace request to the database.
	 *
	 * @param requestId the primary key for the new moi trace request
	 * @return the new moi trace request
	 */
	public static com.moi.dms.trace.request.model.MOITraceRequest
		createMOITraceRequest(long requestId) {

		return getService().createMOITraceRequest(requestId);
	}

	/**
	 * Deletes the moi trace request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MOITraceRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param requestId the primary key of the moi trace request
	 * @return the moi trace request that was removed
	 * @throws PortalException if a moi trace request with the primary key could not be found
	 */
	public static com.moi.dms.trace.request.model.MOITraceRequest
			deleteMOITraceRequest(long requestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteMOITraceRequest(requestId);
	}

	/**
	 * Deletes the moi trace request from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MOITraceRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param moiTraceRequest the moi trace request
	 * @return the moi trace request that was removed
	 */
	public static com.moi.dms.trace.request.model.MOITraceRequest
		deleteMOITraceRequest(
			com.moi.dms.trace.request.model.MOITraceRequest moiTraceRequest) {

		return getService().deleteMOITraceRequest(moiTraceRequest);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.moi.dms.trace.request.model.impl.MOITraceRequestModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.moi.dms.trace.request.model.impl.MOITraceRequestModelImpl</code>.
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

	public static com.moi.dms.trace.request.model.MOITraceRequest
		fetchMOITraceRequest(long requestId) {

		return getService().fetchMOITraceRequest(requestId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the moi trace request with the primary key.
	 *
	 * @param requestId the primary key of the moi trace request
	 * @return the moi trace request
	 * @throws PortalException if a moi trace request with the primary key could not be found
	 */
	public static com.moi.dms.trace.request.model.MOITraceRequest
			getMOITraceRequest(long requestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getMOITraceRequest(requestId);
	}

	/**
	 * Finder method for MOITraceRequest.
	 *
	 * @return List<MOITraceRequest>
	 */
	public static java.util.List
		<com.moi.dms.trace.request.model.MOITraceRequest>
			getMOITraceRequestByRequestId(Long requestId) {

		return getService().getMOITraceRequestByRequestId(requestId);
	}

	/**
	 * Finder method for MOITraceRequest.
	 *
	 * @param requestId
	 * @param start
	 * @param end
	 * @return List<MOITraceRequest>
	 */
	public static java.util.List
		<com.moi.dms.trace.request.model.MOITraceRequest>
			getMOITraceRequestByRequestId(Long requestId, int start, int end) {

		return getService().getMOITraceRequestByRequestId(
			requestId, start, end);
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
	 * Finder method for MOITraceRequest by Search criteria.
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
	 * Get MOITraceRequest Count.
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
	 * Returns a range of all the moi trace requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.moi.dms.trace.request.model.impl.MOITraceRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of moi trace requests
	 * @param end the upper bound of the range of moi trace requests (not inclusive)
	 * @return the range of moi trace requests
	 */
	public static java.util.List
		<com.moi.dms.trace.request.model.MOITraceRequest> getMOITraceRequests(
			int start, int end) {

		return getService().getMOITraceRequests(start, end);
	}

	/**
	 * Returns the number of moi trace requests.
	 *
	 * @return the number of moi trace requests
	 */
	public static int getMOITraceRequestsCount() {
		return getService().getMOITraceRequestsCount();
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
	 * Overloaded method to update existing MOITraceRequest entry. This method
	 * should be used instead of the original method.
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
	 * @param requestComment
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
				java.util.Date requestResultDate, String requestComment)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateMOITraceRequest(
			requestId, requestedBy, requestIncomingDate, requestedConsumerCode,
			requestedConsumerName, requestedOperation, requestedDocumentType,
			requestValid, requestResult, requestResultDate, requestComment);
	}

	/**
	 * Updates the moi trace request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MOITraceRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param moiTraceRequest the moi trace request
	 * @return the moi trace request that was updated
	 */
	public static com.moi.dms.trace.request.model.MOITraceRequest
		updateMOITraceRequest(
			com.moi.dms.trace.request.model.MOITraceRequest moiTraceRequest) {

		return getService().updateMOITraceRequest(moiTraceRequest);
	}

	public static MOITraceRequestLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<MOITraceRequestLocalService, MOITraceRequestLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			MOITraceRequestLocalService.class);

		ServiceTracker<MOITraceRequestLocalService, MOITraceRequestLocalService>
			serviceTracker =
				new ServiceTracker
					<MOITraceRequestLocalService, MOITraceRequestLocalService>(
						bundle.getBundleContext(),
						MOITraceRequestLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}