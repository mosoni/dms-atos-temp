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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MOITraceRequestLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MOITraceRequestLocalService
 * @generated
 */
public class MOITraceRequestLocalServiceWrapper
	implements MOITraceRequestLocalService,
			   ServiceWrapper<MOITraceRequestLocalService> {

	public MOITraceRequestLocalServiceWrapper(
		MOITraceRequestLocalService moiTraceRequestLocalService) {

		_moiTraceRequestLocalService = moiTraceRequestLocalService;
	}

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
	@Override
	public com.moi.dms.trace.request.model.MOITraceRequest addMOITraceRequest(
		com.moi.dms.trace.request.model.MOITraceRequest moiTraceRequest) {

		return _moiTraceRequestLocalService.addMOITraceRequest(moiTraceRequest);
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
	 */
	@Override
	public com.moi.dms.trace.request.model.MOITraceRequest addMOITraceRequest(
		String requestedBy, java.util.Date requestIncomingDate,
		String requestedConsumerCode, String requestedConsumerName,
		String requestedOperation, String requestedDocumentType,
		Boolean requestValid, String requestResult,
		java.util.Date requestResultDate, String requestComment) {

		return _moiTraceRequestLocalService.addMOITraceRequest(
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
	@Override
	public com.moi.dms.trace.request.model.MOITraceRequest
		createMOITraceRequest(long requestId) {

		return _moiTraceRequestLocalService.createMOITraceRequest(requestId);
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
	@Override
	public com.moi.dms.trace.request.model.MOITraceRequest
			deleteMOITraceRequest(long requestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _moiTraceRequestLocalService.deleteMOITraceRequest(requestId);
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
	@Override
	public com.moi.dms.trace.request.model.MOITraceRequest
		deleteMOITraceRequest(
			com.moi.dms.trace.request.model.MOITraceRequest moiTraceRequest) {

		return _moiTraceRequestLocalService.deleteMOITraceRequest(
			moiTraceRequest);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _moiTraceRequestLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _moiTraceRequestLocalService.dynamicQuery();
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

		return _moiTraceRequestLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _moiTraceRequestLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _moiTraceRequestLocalService.dynamicQuery(
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

		return _moiTraceRequestLocalService.dynamicQueryCount(dynamicQuery);
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

		return _moiTraceRequestLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.moi.dms.trace.request.model.MOITraceRequest fetchMOITraceRequest(
		long requestId) {

		return _moiTraceRequestLocalService.fetchMOITraceRequest(requestId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _moiTraceRequestLocalService.getActionableDynamicQuery();
	}

	/**
	 * Finder method for all MOITraceRequests.
	 *
	 * @return List<MOITraceRequest>
	 */
	@Override
	public java.util.List<com.moi.dms.trace.request.model.MOITraceRequest>
		getAllMOITraceRequests() {

		return _moiTraceRequestLocalService.getAllMOITraceRequests();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _moiTraceRequestLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the moi trace request with the primary key.
	 *
	 * @param requestId the primary key of the moi trace request
	 * @return the moi trace request
	 * @throws PortalException if a moi trace request with the primary key could not be found
	 */
	@Override
	public com.moi.dms.trace.request.model.MOITraceRequest getMOITraceRequest(
			long requestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _moiTraceRequestLocalService.getMOITraceRequest(requestId);
	}

	/**
	 * Finder method for MOITraceRequest.
	 *
	 * @return List<MOITraceRequest>
	 */
	@Override
	public java.util.List<com.moi.dms.trace.request.model.MOITraceRequest>
		getMOITraceRequestByRequestId(Long requestId) {

		return _moiTraceRequestLocalService.getMOITraceRequestByRequestId(
			requestId);
	}

	/**
	 * Finder method for MOITraceRequest.
	 *
	 * @param requestId
	 * @param start
	 * @param end
	 * @return List<MOITraceRequest>
	 */
	@Override
	public java.util.List<com.moi.dms.trace.request.model.MOITraceRequest>
		getMOITraceRequestByRequestId(Long requestId, int start, int end) {

		return _moiTraceRequestLocalService.getMOITraceRequestByRequestId(
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
	@Override
	public java.util.List<com.moi.dms.trace.request.model.MOITraceRequest>
		getMOITraceRequestBySearchCriteria(
			String keywords, String fromDate, String toDate) {

		return _moiTraceRequestLocalService.getMOITraceRequestBySearchCriteria(
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
	@Override
	public java.util.List<com.moi.dms.trace.request.model.MOITraceRequest>
		getMOITraceRequestBySearchCriteria(
			String keywords, String fromDate, String toDate, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.moi.dms.trace.request.model.MOITraceRequest>
					orderByComparator) {

		return _moiTraceRequestLocalService.getMOITraceRequestBySearchCriteria(
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
	@Override
	public long getMOITraceRequestCountBySearchCriteria(
		String keywords, String fromDate, String toDate) {

		return _moiTraceRequestLocalService.
			getMOITraceRequestCountBySearchCriteria(keywords, fromDate, toDate);
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
	@Override
	public java.util.List<com.moi.dms.trace.request.model.MOITraceRequest>
		getMOITraceRequests(int start, int end) {

		return _moiTraceRequestLocalService.getMOITraceRequests(start, end);
	}

	/**
	 * Returns the number of moi trace requests.
	 *
	 * @return the number of moi trace requests
	 */
	@Override
	public int getMOITraceRequestsCount() {
		return _moiTraceRequestLocalService.getMOITraceRequestsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _moiTraceRequestLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _moiTraceRequestLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.moi.dms.trace.request.model.MOITraceRequest
			updateMOITraceRequest(
				long requestId, String requestedBy,
				java.util.Date requestIncomingDate,
				String requestedConsumerCode, String requestedConsumerName,
				String requestedOperation, String requestedDocumentType,
				Boolean requestValid, String requestResult,
				java.util.Date requestResultDate, String requestComment)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _moiTraceRequestLocalService.updateMOITraceRequest(
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
	@Override
	public com.moi.dms.trace.request.model.MOITraceRequest
		updateMOITraceRequest(
			com.moi.dms.trace.request.model.MOITraceRequest moiTraceRequest) {

		return _moiTraceRequestLocalService.updateMOITraceRequest(
			moiTraceRequest);
	}

	@Override
	public MOITraceRequestLocalService getWrappedService() {
		return _moiTraceRequestLocalService;
	}

	@Override
	public void setWrappedService(
		MOITraceRequestLocalService moiTraceRequestLocalService) {

		_moiTraceRequestLocalService = moiTraceRequestLocalService;
	}

	private MOITraceRequestLocalService _moiTraceRequestLocalService;

}