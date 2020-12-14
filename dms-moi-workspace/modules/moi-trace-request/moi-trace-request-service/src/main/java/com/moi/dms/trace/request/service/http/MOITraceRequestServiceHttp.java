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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import com.moi.dms.trace.request.service.MOITraceRequestServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>MOITraceRequestServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MOITraceRequestServiceSoap
 * @generated
 */
public class MOITraceRequestServiceHttp {

	public static com.moi.dms.trace.request.model.MOITraceRequest
			addMOITraceRequest(
				HttpPrincipal httpPrincipal, String requestedBy,
				java.util.Date requestIncomingDate,
				String requestedConsumerCode, String requestedConsumerName,
				String requestedOperation, String requestedDocumentType,
				Boolean requestValid, String requestResult,
				java.util.Date requestResultDate)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				MOITraceRequestServiceUtil.class, "addMOITraceRequest",
				_addMOITraceRequestParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, requestedBy, requestIncomingDate,
				requestedConsumerCode, requestedConsumerName,
				requestedOperation, requestedDocumentType, requestValid,
				requestResult, requestResultDate);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.moi.dms.trace.request.model.MOITraceRequest)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.moi.dms.trace.request.model.MOITraceRequest
			updateMOITraceRequest(
				HttpPrincipal httpPrincipal, long requestId, String requestedBy,
				java.util.Date requestIncomingDate,
				String requestedConsumerCode, String requestedConsumerName,
				String requestedOperation, String requestedDocumentType,
				Boolean requestValid, String requestResult,
				java.util.Date requestResultDate)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				MOITraceRequestServiceUtil.class, "updateMOITraceRequest",
				_updateMOITraceRequestParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, requestId, requestedBy, requestIncomingDate,
				requestedConsumerCode, requestedConsumerName,
				requestedOperation, requestedDocumentType, requestValid,
				requestResult, requestResultDate);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.moi.dms.trace.request.model.MOITraceRequest)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.moi.dms.trace.request.model.MOITraceRequest
			deleteMOITraceRequest(HttpPrincipal httpPrincipal, long requestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				MOITraceRequestServiceUtil.class, "deleteMOITraceRequest",
				_deleteMOITraceRequestParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, requestId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.moi.dms.trace.request.model.MOITraceRequest)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.moi.dms.trace.request.model.MOITraceRequest
			getMOITraceRequest(HttpPrincipal httpPrincipal, long requestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				MOITraceRequestServiceUtil.class, "getMOITraceRequest",
				_getMOITraceRequestParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, requestId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.moi.dms.trace.request.model.MOITraceRequest)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.moi.dms.trace.request.model.MOITraceRequest>
			getMOITraceRequestBySearchCriteria(
				HttpPrincipal httpPrincipal, String keywords, String fromDate,
				String toDate, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.moi.dms.trace.request.model.MOITraceRequest>
						orderByComparator) {

		try {
			MethodKey methodKey = new MethodKey(
				MOITraceRequestServiceUtil.class,
				"getMOITraceRequestBySearchCriteria",
				_getMOITraceRequestBySearchCriteriaParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, keywords, fromDate, toDate, start, end,
				orderByComparator);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.moi.dms.trace.request.model.MOITraceRequest>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.moi.dms.trace.request.model.MOITraceRequest>
			getMOITraceRequestBySearchCriteria(
				HttpPrincipal httpPrincipal, String keywords, String fromDate,
				String toDate) {

		try {
			MethodKey methodKey = new MethodKey(
				MOITraceRequestServiceUtil.class,
				"getMOITraceRequestBySearchCriteria",
				_getMOITraceRequestBySearchCriteriaParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, keywords, fromDate, toDate);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.moi.dms.trace.request.model.MOITraceRequest>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static long getMOITraceRequestCountBySearchCriteria(
		HttpPrincipal httpPrincipal, String keywords, String fromDate,
		String toDate) {

		try {
			MethodKey methodKey = new MethodKey(
				MOITraceRequestServiceUtil.class,
				"getMOITraceRequestCountBySearchCriteria",
				_getMOITraceRequestCountBySearchCriteriaParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, keywords, fromDate, toDate);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Long)returnObj).longValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.moi.dms.trace.request.model.MOITraceRequest>
			getAllMOITraceRequests(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				MOITraceRequestServiceUtil.class, "getAllMOITraceRequests",
				_getAllMOITraceRequestsParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.moi.dms.trace.request.model.MOITraceRequest>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		MOITraceRequestServiceHttp.class);

	private static final Class<?>[] _addMOITraceRequestParameterTypes0 =
		new Class[] {
			String.class, java.util.Date.class, String.class, String.class,
			String.class, String.class, Boolean.class, String.class,
			java.util.Date.class
		};
	private static final Class<?>[] _updateMOITraceRequestParameterTypes1 =
		new Class[] {
			long.class, String.class, java.util.Date.class, String.class,
			String.class, String.class, String.class, Boolean.class,
			String.class, java.util.Date.class
		};
	private static final Class<?>[] _deleteMOITraceRequestParameterTypes2 =
		new Class[] {long.class};
	private static final Class<?>[] _getMOITraceRequestParameterTypes3 =
		new Class[] {long.class};
	private static final Class<?>[]
		_getMOITraceRequestBySearchCriteriaParameterTypes4 = new Class[] {
			String.class, String.class, String.class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[]
		_getMOITraceRequestBySearchCriteriaParameterTypes5 = new Class[] {
			String.class, String.class, String.class
		};
	private static final Class<?>[]
		_getMOITraceRequestCountBySearchCriteriaParameterTypes6 = new Class[] {
			String.class, String.class, String.class
		};
	private static final Class<?>[] _getAllMOITraceRequestsParameterTypes7 =
		new Class[] {};

}