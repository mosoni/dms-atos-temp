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

package com.moi.dms.trace.request.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.moi.dms.trace.request.model.MOITraceRequest;
import com.moi.dms.trace.request.service.base.MOITraceRequestServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the moi trace request remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.moi.dms.trace.request.service.MOITraceRequestService</code>
 * interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MOITraceRequestServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=dms",
		"json.web.service.context.path=MOITraceRequest"
	},
	service = AopService.class
)
public class MOITraceRequestServiceImpl extends MOITraceRequestServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.moi.dms.trace.request.service.MOITraceRequestServiceUtil</code> to access the moi trace request remote service.
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
	public MOITraceRequest addMOITraceRequest(String requestedBy,
			Date requestIncomingDate, String requestedConsumerCode,
			String requestedConsumerName, String requestedOperation,
			String requestedDocumentType, Boolean requestValid,
			String requestResult, Date requestResultDate)
			throws PortalException {

		return moiTraceRequestLocalService.addMOITraceRequest(requestedBy,
				requestIncomingDate, requestedConsumerCode,
				requestedConsumerName, requestedOperation,
				requestedDocumentType, requestValid, requestResult,
				requestResultDate);
	}

	/**
	 * Remote service to update MOITraceRequest.
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
	public MOITraceRequest updateMOITraceRequest(long requestId,
			String requestedBy, Date requestIncomingDate,
			String requestedConsumerCode, String requestedConsumerName,
			String requestedOperation, String requestedDocumentType,
			Boolean requestValid, String requestResult, Date requestResultDate)
			throws PortalException {

		return moiTraceRequestLocalService.updateMOITraceRequest(requestId,
				requestedBy, requestIncomingDate, requestedConsumerCode,
				requestedConsumerName, requestedOperation,
				requestedDocumentType, requestValid, requestResult,
				requestResultDate);
	}

	/**
	 * Remote service to delete MOITraceRequest.
	 * @param requestId
	 * @return MOITraceRequest
	 * @throws PortalException
	 */
	public MOITraceRequest deleteMOITraceRequest(long requestId)
			throws PortalException {

		MOITraceRequest traceRequest = moiTraceRequestLocalService
				.getMOITraceRequest(requestId);

		return moiTraceRequestLocalService.deleteMOITraceRequest(traceRequest);
	}

	/**
	 * Remote service to get MOITraceRequest by id.
	 * @param requestId
	 * @return MOITraceRequest
	 * @throws PortalException
	 */
	public MOITraceRequest getMOITraceRequest(long requestId)
			throws PortalException {

		MOITraceRequest traceRequest = moiTraceRequestLocalService
				.getMOITraceRequest(requestId);

		return traceRequest;
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
	public List<MOITraceRequest> getMOITraceRequestBySearchCriteria(
			String keywords, String fromDate, String toDate, int start, int end,
			OrderByComparator<MOITraceRequest> orderByComparator) {

		return moiTraceRequestLocalService.getMOITraceRequestBySearchCriteria(
				keywords, fromDate, toDate, start, end, orderByComparator);
	}

	/**
	 * Finder method for MOITraceRequest by Search criteria.
	 * 
	 * @param keywords
	 * @param fromDate
	 * @param toDate
	 * 
	 * @return List<MOITraceRequest>
	 */
	public List<MOITraceRequest> getMOITraceRequestBySearchCriteria(
			String keywords, String fromDate, String toDate) {

		return moiTraceRequestLocalService
				.getMOITraceRequestBySearchCriteria(keywords, fromDate, toDate);
	}

	/**
	 * Remote service to fetch MOITraceRequest Count.
	 * 
	 * @param keywords
	 * @param fromDate
	 * @param toDate
	 * @return long
	 */
	public long getMOITraceRequestCountBySearchCriteria(String keywords,
			String fromDate, String toDate) {

		return moiTraceRequestLocalService
				.getMOITraceRequestCountBySearchCriteria(keywords, fromDate,
						toDate);
	}

	/**
	 * Finder method for all MOITraceRequests.
	 * 
	 * @return List<MOITraceRequest>
	 */
	public List<MOITraceRequest> getAllMOITraceRequests() {
		return moiTraceRequestLocalService.getAllMOITraceRequests();
	}
}