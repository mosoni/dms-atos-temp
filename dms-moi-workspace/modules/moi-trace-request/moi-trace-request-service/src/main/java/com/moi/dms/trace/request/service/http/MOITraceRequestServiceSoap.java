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

package com.moi.dms.trace.request.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.moi.dms.trace.request.service.MOITraceRequestServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>MOITraceRequestServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.moi.dms.trace.request.model.MOITraceRequestSoap</code>. If the method in the
 * service utility returns a
 * <code>com.moi.dms.trace.request.model.MOITraceRequest</code>, that is translated to a
 * <code>com.moi.dms.trace.request.model.MOITraceRequestSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MOITraceRequestServiceHttp
 * @generated
 */
public class MOITraceRequestServiceSoap {

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
	public static com.moi.dms.trace.request.model.MOITraceRequestSoap
			addMOITraceRequest(
				String requestedBy, java.util.Date requestIncomingDate,
				String requestedConsumerCode, String requestedConsumerName,
				String requestedOperation, String requestedDocumentType,
				Boolean requestValid, String requestResult,
				java.util.Date requestResultDate)
		throws RemoteException {

		try {
			com.moi.dms.trace.request.model.MOITraceRequest returnValue =
				MOITraceRequestServiceUtil.addMOITraceRequest(
					requestedBy, requestIncomingDate, requestedConsumerCode,
					requestedConsumerName, requestedOperation,
					requestedDocumentType, requestValid, requestResult,
					requestResultDate);

			return com.moi.dms.trace.request.model.MOITraceRequestSoap.
				toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
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
	public static com.moi.dms.trace.request.model.MOITraceRequestSoap
			updateMOITraceRequest(
				long requestId, String requestedBy,
				java.util.Date requestIncomingDate,
				String requestedConsumerCode, String requestedConsumerName,
				String requestedOperation, String requestedDocumentType,
				Boolean requestValid, String requestResult,
				java.util.Date requestResultDate)
		throws RemoteException {

		try {
			com.moi.dms.trace.request.model.MOITraceRequest returnValue =
				MOITraceRequestServiceUtil.updateMOITraceRequest(
					requestId, requestedBy, requestIncomingDate,
					requestedConsumerCode, requestedConsumerName,
					requestedOperation, requestedDocumentType, requestValid,
					requestResult, requestResultDate);

			return com.moi.dms.trace.request.model.MOITraceRequestSoap.
				toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Remote service to delete MOITraceRequest.
	 *
	 * @param requestId
	 * @return MOITraceRequest
	 * @throws PortalException
	 */
	public static com.moi.dms.trace.request.model.MOITraceRequestSoap
			deleteMOITraceRequest(long requestId)
		throws RemoteException {

		try {
			com.moi.dms.trace.request.model.MOITraceRequest returnValue =
				MOITraceRequestServiceUtil.deleteMOITraceRequest(requestId);

			return com.moi.dms.trace.request.model.MOITraceRequestSoap.
				toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Remote service to get MOITraceRequest by id.
	 *
	 * @param requestId
	 * @return MOITraceRequest
	 * @throws PortalException
	 */
	public static com.moi.dms.trace.request.model.MOITraceRequestSoap
			getMOITraceRequest(long requestId)
		throws RemoteException {

		try {
			com.moi.dms.trace.request.model.MOITraceRequest returnValue =
				MOITraceRequestServiceUtil.getMOITraceRequest(requestId);

			return com.moi.dms.trace.request.model.MOITraceRequestSoap.
				toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
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
	public static com.moi.dms.trace.request.model.MOITraceRequestSoap[]
			getMOITraceRequestBySearchCriteria(
				String keywords, String fromDate, String toDate, int start,
				int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.moi.dms.trace.request.model.MOITraceRequest>
						orderByComparator)
		throws RemoteException {

		try {
			java.util.List<com.moi.dms.trace.request.model.MOITraceRequest>
				returnValue =
					MOITraceRequestServiceUtil.
						getMOITraceRequestBySearchCriteria(
							keywords, fromDate, toDate, start, end,
							orderByComparator);

			return com.moi.dms.trace.request.model.MOITraceRequestSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Finder method for MOITraceRequest by Search criteria.
	 *
	 * @param keywords
	 * @param fromDate
	 * @param toDate
	 * @return List<MOITraceRequest>
	 */
	public static com.moi.dms.trace.request.model.MOITraceRequestSoap[]
			getMOITraceRequestBySearchCriteria(
				String keywords, String fromDate, String toDate)
		throws RemoteException {

		try {
			java.util.List<com.moi.dms.trace.request.model.MOITraceRequest>
				returnValue =
					MOITraceRequestServiceUtil.
						getMOITraceRequestBySearchCriteria(
							keywords, fromDate, toDate);

			return com.moi.dms.trace.request.model.MOITraceRequestSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
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
			String keywords, String fromDate, String toDate)
		throws RemoteException {

		try {
			long returnValue =
				MOITraceRequestServiceUtil.
					getMOITraceRequestCountBySearchCriteria(
						keywords, fromDate, toDate);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Finder method for all MOITraceRequests.
	 *
	 * @return List<MOITraceRequest>
	 */
	public static com.moi.dms.trace.request.model.MOITraceRequestSoap[]
			getAllMOITraceRequests()
		throws RemoteException {

		try {
			java.util.List<com.moi.dms.trace.request.model.MOITraceRequest>
				returnValue =
					MOITraceRequestServiceUtil.getAllMOITraceRequests();

			return com.moi.dms.trace.request.model.MOITraceRequestSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		MOITraceRequestServiceSoap.class);

}