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

package com.moi.dms.consumer.registration.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import com.moi.dms.consumer.registration.service.ConsumerRegistrationServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>ConsumerRegistrationServiceUtil</code> service
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
 * @see ConsumerRegistrationServiceSoap
 * @generated
 */
public class ConsumerRegistrationServiceHttp {

	public static com.moi.dms.consumer.registration.model.ConsumerRegistration
			addConsumerRegistration(
				HttpPrincipal httpPrincipal, String consumerName,
				String consumerId,
				java.util.Map<java.util.Locale, String> descriptionMap,
				String supportedDocumentType, String consumerStatus)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ConsumerRegistrationServiceUtil.class,
				"addConsumerRegistration",
				_addConsumerRegistrationParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, consumerName, consumerId, descriptionMap,
				supportedDocumentType, consumerStatus);

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

			return (com.moi.dms.consumer.registration.model.
				ConsumerRegistration)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.moi.dms.consumer.registration.model.ConsumerRegistration
			updateConsumerRegistration(
				HttpPrincipal httpPrincipal, long consumerRegistrationId,
				String consumerName, String consumerId,
				java.util.Map<java.util.Locale, String> descriptionMap,
				String supportedDocumentType, String consumerStatus)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ConsumerRegistrationServiceUtil.class,
				"updateConsumerRegistration",
				_updateConsumerRegistrationParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, consumerRegistrationId, consumerName, consumerId,
				descriptionMap, supportedDocumentType, consumerStatus);

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

			return (com.moi.dms.consumer.registration.model.
				ConsumerRegistration)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.moi.dms.consumer.registration.model.ConsumerRegistration
			deleteConsumerRegistration(
				HttpPrincipal httpPrincipal, long registrationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ConsumerRegistrationServiceUtil.class,
				"deleteConsumerRegistration",
				_deleteConsumerRegistrationParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, registrationId);

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

			return (com.moi.dms.consumer.registration.model.
				ConsumerRegistration)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.moi.dms.consumer.registration.model.ConsumerRegistration
			getConsumerRegistration(
				HttpPrincipal httpPrincipal, long registrationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ConsumerRegistrationServiceUtil.class,
				"getConsumerRegistration",
				_getConsumerRegistrationParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, registrationId);

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

			return (com.moi.dms.consumer.registration.model.
				ConsumerRegistration)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.moi.dms.consumer.registration.model.ConsumerRegistration>
			getConsumerRegistrationByConsumerId(
				HttpPrincipal httpPrincipal, String consumerId) {

		try {
			MethodKey methodKey = new MethodKey(
				ConsumerRegistrationServiceUtil.class,
				"getConsumerRegistrationByConsumerId",
				_getConsumerRegistrationByConsumerIdParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, consumerId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.moi.dms.consumer.registration.model.ConsumerRegistration>)
					returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.moi.dms.consumer.registration.model.ConsumerRegistration>
			getAllConsumerRegistrations(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				ConsumerRegistrationServiceUtil.class,
				"getAllConsumerRegistrations",
				_getAllConsumerRegistrationsParameterTypes5);

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
				<com.moi.dms.consumer.registration.model.ConsumerRegistration>)
					returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.moi.dms.consumer.registration.model.ConsumerRegistration>
			getConsumerRegistrationByKeywords(
				HttpPrincipal httpPrincipal, String keywords, int start,
				int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.moi.dms.consumer.registration.model.
						ConsumerRegistration> orderByComparator) {

		try {
			MethodKey methodKey = new MethodKey(
				ConsumerRegistrationServiceUtil.class,
				"getConsumerRegistrationByKeywords",
				_getConsumerRegistrationByKeywordsParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, keywords, start, end, orderByComparator);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.moi.dms.consumer.registration.model.ConsumerRegistration>)
					returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static long getConsumerRegistrationCountByKeywords(
		HttpPrincipal httpPrincipal, String keywords) {

		try {
			MethodKey methodKey = new MethodKey(
				ConsumerRegistrationServiceUtil.class,
				"getConsumerRegistrationCountByKeywords",
				_getConsumerRegistrationCountByKeywordsParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, keywords);

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

	private static Log _log = LogFactoryUtil.getLog(
		ConsumerRegistrationServiceHttp.class);

	private static final Class<?>[] _addConsumerRegistrationParameterTypes0 =
		new Class[] {
			String.class, String.class, java.util.Map.class, String.class,
			String.class
		};
	private static final Class<?>[] _updateConsumerRegistrationParameterTypes1 =
		new Class[] {
			long.class, String.class, String.class, java.util.Map.class,
			String.class, String.class
		};
	private static final Class<?>[] _deleteConsumerRegistrationParameterTypes2 =
		new Class[] {long.class};
	private static final Class<?>[] _getConsumerRegistrationParameterTypes3 =
		new Class[] {long.class};
	private static final Class<?>[]
		_getConsumerRegistrationByConsumerIdParameterTypes4 = new Class[] {
			String.class
		};
	private static final Class<?>[]
		_getAllConsumerRegistrationsParameterTypes5 = new Class[] {};
	private static final Class<?>[]
		_getConsumerRegistrationByKeywordsParameterTypes6 = new Class[] {
			String.class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[]
		_getConsumerRegistrationCountByKeywordsParameterTypes7 = new Class[] {
			String.class
		};

}