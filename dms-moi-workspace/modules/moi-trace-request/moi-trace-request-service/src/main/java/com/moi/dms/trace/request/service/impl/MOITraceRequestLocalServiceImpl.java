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
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.moi.dms.trace.request.model.MOITraceRequest;
import com.moi.dms.trace.request.service.base.MOITraceRequestLocalServiceBaseImpl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the moi trace request local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.moi.dms.trace.request.service.MOITraceRequestLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MOITraceRequestLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.moi.dms.trace.request.model.MOITraceRequest",
	service = AopService.class
)
public class MOITraceRequestLocalServiceImpl
	extends MOITraceRequestLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.moi.dms.trace.request.service.MOITraceRequestLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.moi.dms.trace.request.service.MOITraceRequestLocalServiceUtil</code>.
	 */

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
	 * @return MOITraceRequest
	 * @throws PortalException
	 */
	public MOITraceRequest addMOITraceRequest(String requestedBy,
			Date requestIncomingDate, String requestedConsumerCode,
			String requestedConsumerName, String requestedOperation,
			String requestedDocumentType, Boolean requestValid,
			String requestResult, Date requestResultDate)
			throws PortalException {

		// Generate primary key for the MOITraceRequest.
		long requestId = counterLocalService
				.increment(MOITraceRequest.class.getName());

		// Create MOITraceRequest. This doesn't yet persist the entity.
		MOITraceRequest traceRequest = createMOITraceRequest(requestId);

		// Populate fields.
		traceRequest.setRequestedBy(requestedBy);
		traceRequest.setRequestIncomingDate(requestIncomingDate);
		traceRequest.setRequestedConsumerCode(requestedConsumerCode);
		traceRequest.setRequestedConsumerName(requestedConsumerName);
		traceRequest.setRequestedOperation(requestedOperation);
		traceRequest.setRequestedDocumentType(requestedDocumentType);
		traceRequest.setRequestValid(requestValid);
		traceRequest.setRequestResult(requestResult);
		traceRequest.setRequestResultDate(requestResultDate);

		// Persist MOITraceRequest to database.
		return super.addMOITraceRequest(traceRequest);
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
	 * @return MOITraceRequest
	 * @throws PortalException
	 */
	public MOITraceRequest updateMOITraceRequest(long requestId,
			String requestedBy, Date requestIncomingDate,
			String requestedConsumerCode, String requestedConsumerName,
			String requestedOperation, String requestedDocumentType,
			Boolean requestValid, String requestResult, Date requestResultDate)
			throws PortalException {

		// Get the MOI Trace Request by id.
		MOITraceRequest traceRequest = getMOITraceRequest(requestId);

		// Set updated fields and modification date.
		traceRequest.setRequestedBy(requestedBy);
		traceRequest.setRequestIncomingDate(requestIncomingDate);
		traceRequest.setRequestedConsumerCode(requestedConsumerCode);
		traceRequest.setRequestedConsumerName(requestedConsumerName);
		traceRequest.setRequestedOperation(requestedOperation);
		traceRequest.setRequestedDocumentType(requestedDocumentType);
		traceRequest.setRequestValid(requestValid);
		traceRequest.setRequestResult(requestResult);
		traceRequest.setRequestResultDate(requestResultDate);

		// Persist MOI Trace Request to database.
		return super.updateMOITraceRequest(traceRequest);
	}

	/**
	 * Finder method for MOITraceRequest.
	 * 
	 * @return List<MOITraceRequest>
	 */
	public List<MOITraceRequest> getMOITraceRequestByRequestId(Long requestId) {
		return moiTraceRequestPersistence.findByRequestId(requestId);
	}

	/**
	 * Finder method for MOITraceRequest.
	 * 
	 * @param requestId
	 * @param start
	 * @param end
	 * 
	 * @return List<MOITraceRequest>
	 */
	public List<MOITraceRequest> getMOITraceRequestByRequestId(Long requestId,
			int start, int end) {
		return moiTraceRequestPersistence.findByRequestId(requestId, start,
				end);
	}

	/**
	 * Finder method for all MOITraceRequests.
	 * 
	 * @return List<MOITraceRequest>
	 */
	public List<MOITraceRequest> getAllMOITraceRequests() {
		return moiTraceRequestPersistence.findAll();
	}

	/**
	 * Method for finding MOITraceRequest object using dynamic query.
	 * 
	 * @param keywords
	 * @param fromDate
	 * @param toDate
	 * 
	 * @return DynamicQuery
	 */
	private DynamicQuery getSearchDynamicQuery(String keywords, String fromDate,
			String toDate) {
		DynamicQuery dynamicQuery = dynamicQuery();
		Disjunction disjunctionQuery = RestrictionsFactoryUtil.disjunction();
		if (Validator.isNotNull(keywords)) {
			disjunctionQuery.add(RestrictionsFactoryUtil.like("requestedBy",
					"%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil
					.like("requestedConsumerCode", "%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil
					.like("requestedConsumerName", "%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil
					.like("requestedOperation", "%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil
					.like("requestedDocumentType", "%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil.like("requestResult",
					"%" + keywords + "%"));
		}

		if (Validator.isNotNull(fromDate) && Validator.isNotNull(toDate)) {
			DateTimeFormatter dateFormatter = DateTimeFormatter
					.ofPattern("yyyy-MM-dd HH:mm:ss");
			Date fromDateObj = Date
					.from(LocalDateTime.parse(fromDate, dateFormatter)
							.atZone(ZoneId.systemDefault()).toInstant());
			Date toDateObj = Date
					.from(LocalDateTime.parse(toDate, dateFormatter)
							.atZone(ZoneId.systemDefault()).toInstant());
			disjunctionQuery.add(RestrictionsFactoryUtil
					.between("requestIncomingDate", fromDateObj, toDateObj));
		}

		dynamicQuery.add(disjunctionQuery);
		return dynamicQuery;
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
	 * 
	 * @return List<MOITraceRequest>
	 */
	public List<MOITraceRequest> getMOITraceRequestBySearchCriteria(
			String keywords, String fromDate, String toDate, int start, int end,
			OrderByComparator<MOITraceRequest> orderByComparator) {

		return dynamicQuery(getSearchDynamicQuery(keywords, fromDate, toDate),
				start, end, orderByComparator);
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

		List<MOITraceRequest> traceRequests = dynamicQuery(
				getSearchDynamicQuery(keywords, fromDate, toDate));
		return traceRequests;
	}

	/**
	 * Get MOITraceRequest Count.
	 * 
	 * @param keywords
	 * @param fromDate
	 * @param toDate
	 * 
	 * @return long
	 */
	public long getMOITraceRequestCountBySearchCriteria(String keywords,
			String fromDate, String toDate) {
		return dynamicQueryCount(
				getSearchDynamicQuery(keywords, fromDate, toDate));
	}

	/**
	 * Method overridden as this method is not supported.
	 * 
	 * @param moiTraceRequest
	 */
	@Override
	public MOITraceRequest addMOITraceRequest(
			MOITraceRequest moiTraceRequest) {
		throw new UnsupportedOperationException("Method not supported.");
	}

	/**
	 * Method overridden as this method is not supported.
	 * 
	 * @param moiTraceRequest
	 */
	@Override
	public MOITraceRequest updateMOITraceRequest(
			MOITraceRequest moiTraceRequest) {
		throw new UnsupportedOperationException("Method not supported.");
	}
}