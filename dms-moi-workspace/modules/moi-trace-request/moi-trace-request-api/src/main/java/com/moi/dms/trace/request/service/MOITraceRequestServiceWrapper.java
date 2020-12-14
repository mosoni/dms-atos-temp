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
 * Provides a wrapper for {@link MOITraceRequestService}.
 *
 * @author Brian Wing Shun Chan
 * @see MOITraceRequestService
 * @generated
 */
public class MOITraceRequestServiceWrapper
	implements MOITraceRequestService, ServiceWrapper<MOITraceRequestService> {

	public MOITraceRequestServiceWrapper(
		MOITraceRequestService moiTraceRequestService) {

		_moiTraceRequestService = moiTraceRequestService;
	}

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
	@Override
	public com.moi.dms.trace.request.model.MOITraceRequest addMOITraceRequest(
			String requestedBy, java.util.Date requestIncomingDate,
			String requestedConsumerCode, String requestedConsumerName,
			String requestedOperation, String requestedDocumentType,
			Boolean requestValid, String requestResult,
			java.util.Date requestResultDate)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _moiTraceRequestService.addMOITraceRequest(
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
	@Override
	public com.moi.dms.trace.request.model.MOITraceRequest
			deleteMOITraceRequest(long requestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _moiTraceRequestService.deleteMOITraceRequest(requestId);
	}

	/**
	 * Finder method for all MOITraceRequests.
	 *
	 * @return List<MOITraceRequest>
	 */
	@Override
	public java.util.List<com.moi.dms.trace.request.model.MOITraceRequest>
		getAllMOITraceRequests() {

		return _moiTraceRequestService.getAllMOITraceRequests();
	}

	/**
	 * Remote service to get MOITraceRequest by id.
	 *
	 * @param requestId
	 * @return MOITraceRequest
	 * @throws PortalException
	 */
	@Override
	public com.moi.dms.trace.request.model.MOITraceRequest getMOITraceRequest(
			long requestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _moiTraceRequestService.getMOITraceRequest(requestId);
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

		return _moiTraceRequestService.getMOITraceRequestBySearchCriteria(
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
	@Override
	public java.util.List<com.moi.dms.trace.request.model.MOITraceRequest>
		getMOITraceRequestBySearchCriteria(
			String keywords, String fromDate, String toDate, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.moi.dms.trace.request.model.MOITraceRequest>
					orderByComparator) {

		return _moiTraceRequestService.getMOITraceRequestBySearchCriteria(
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
	@Override
	public long getMOITraceRequestCountBySearchCriteria(
		String keywords, String fromDate, String toDate) {

		return _moiTraceRequestService.getMOITraceRequestCountBySearchCriteria(
			keywords, fromDate, toDate);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _moiTraceRequestService.getOSGiServiceIdentifier();
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
	@Override
	public com.moi.dms.trace.request.model.MOITraceRequest
			updateMOITraceRequest(
				long requestId, String requestedBy,
				java.util.Date requestIncomingDate,
				String requestedConsumerCode, String requestedConsumerName,
				String requestedOperation, String requestedDocumentType,
				Boolean requestValid, String requestResult,
				java.util.Date requestResultDate)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _moiTraceRequestService.updateMOITraceRequest(
			requestId, requestedBy, requestIncomingDate, requestedConsumerCode,
			requestedConsumerName, requestedOperation, requestedDocumentType,
			requestValid, requestResult, requestResultDate);
	}

	@Override
	public MOITraceRequestService getWrappedService() {
		return _moiTraceRequestService;
	}

	@Override
	public void setWrappedService(
		MOITraceRequestService moiTraceRequestService) {

		_moiTraceRequestService = moiTraceRequestService;
	}

	private MOITraceRequestService _moiTraceRequestService;

}