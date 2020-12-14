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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.moi.dms.trace.request.model.MOITraceRequest;

import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for MOITraceRequest. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see MOITraceRequestServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface MOITraceRequestService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.moi.dms.trace.request.service.impl.MOITraceRequestServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the moi trace request remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link MOITraceRequestServiceUtil} if injection and service tracking are not available.
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
	public MOITraceRequest addMOITraceRequest(
			String requestedBy, Date requestIncomingDate,
			String requestedConsumerCode, String requestedConsumerName,
			String requestedOperation, String requestedDocumentType,
			Boolean requestValid, String requestResult, Date requestResultDate)
		throws PortalException;

	/**
	 * Remote service to delete MOITraceRequest.
	 *
	 * @param requestId
	 * @return MOITraceRequest
	 * @throws PortalException
	 */
	public MOITraceRequest deleteMOITraceRequest(long requestId)
		throws PortalException;

	/**
	 * Finder method for all MOITraceRequests.
	 *
	 * @return List<MOITraceRequest>
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MOITraceRequest> getAllMOITraceRequests();

	/**
	 * Remote service to get MOITraceRequest by id.
	 *
	 * @param requestId
	 * @return MOITraceRequest
	 * @throws PortalException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MOITraceRequest getMOITraceRequest(long requestId)
		throws PortalException;

	/**
	 * Finder method for MOITraceRequest by Search criteria.
	 *
	 * @param keywords
	 * @param fromDate
	 * @param toDate
	 * @return List<MOITraceRequest>
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MOITraceRequest> getMOITraceRequestBySearchCriteria(
		String keywords, String fromDate, String toDate);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MOITraceRequest> getMOITraceRequestBySearchCriteria(
		String keywords, String fromDate, String toDate, int start, int end,
		OrderByComparator<MOITraceRequest> orderByComparator);

	/**
	 * Remote service to fetch MOITraceRequest Count.
	 *
	 * @param keywords
	 * @param fromDate
	 * @param toDate
	 * @return long
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getMOITraceRequestCountBySearchCriteria(
		String keywords, String fromDate, String toDate);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

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
	public MOITraceRequest updateMOITraceRequest(
			long requestId, String requestedBy, Date requestIncomingDate,
			String requestedConsumerCode, String requestedConsumerName,
			String requestedOperation, String requestedDocumentType,
			Boolean requestValid, String requestResult, Date requestResultDate)
		throws PortalException;

}