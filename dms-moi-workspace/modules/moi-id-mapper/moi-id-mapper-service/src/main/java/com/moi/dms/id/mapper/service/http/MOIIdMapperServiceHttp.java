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

package com.moi.dms.id.mapper.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import com.moi.dms.id.mapper.service.MOIIdMapperServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>MOIIdMapperServiceUtil</code> service
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
 * @see MOIIdMapperServiceSoap
 * @generated
 */
public class MOIIdMapperServiceHttp {

	public static com.moi.dms.id.mapper.model.MOIIdMapper addMOIIdMapper(
			HttpPrincipal httpPrincipal, long groupId, long companyId,
			String mosipCurrentState, String mosipDocumentType,
			String registrationId, long resourceId, String documentTitle,
			int activeState, String fileEntryId, java.util.Date updateDate,
			String updatedBy)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				MOIIdMapperServiceUtil.class, "addMOIIdMapper",
				_addMOIIdMapperParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, companyId, mosipCurrentState,
				mosipDocumentType, registrationId, resourceId, documentTitle,
				activeState, fileEntryId, updateDate, updatedBy);

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

			return (com.moi.dms.id.mapper.model.MOIIdMapper)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.moi.dms.id.mapper.model.MOIIdMapper updateMOIIdMapper(
			HttpPrincipal httpPrincipal, long mapperId, long groupId,
			long companyId, String mosipCurrentState, String mosipDocumentType,
			String registrationId, long resourceId, String documentTitle,
			int activeState, String fileEntryId, java.util.Date updateDate,
			String updatedBy)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				MOIIdMapperServiceUtil.class, "updateMOIIdMapper",
				_updateMOIIdMapperParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, mapperId, groupId, companyId, mosipCurrentState,
				mosipDocumentType, registrationId, resourceId, documentTitle,
				activeState, fileEntryId, updateDate, updatedBy);

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

			return (com.moi.dms.id.mapper.model.MOIIdMapper)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.moi.dms.id.mapper.model.MOIIdMapper
			updateMOIIdMapperState(
				HttpPrincipal httpPrincipal, long mapperId, int activeState,
				java.util.Date updateDate, String updatedBy)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				MOIIdMapperServiceUtil.class, "updateMOIIdMapperState",
				_updateMOIIdMapperStateParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, mapperId, activeState, updateDate, updatedBy);

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

			return (com.moi.dms.id.mapper.model.MOIIdMapper)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		getAllMOIIdMappers(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				MOIIdMapperServiceUtil.class, "getAllMOIIdMappers",
				_getAllMOIIdMappersParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		findByMapperId(HttpPrincipal httpPrincipal, Long mapperId) {

		try {
			MethodKey methodKey = new MethodKey(
				MOIIdMapperServiceUtil.class, "findByMapperId",
				_findByMapperIdParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, mapperId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		findByMosipDocumentType(
			HttpPrincipal httpPrincipal, String mosipDocumentType) {

		try {
			MethodKey methodKey = new MethodKey(
				MOIIdMapperServiceUtil.class, "findByMosipDocumentType",
				_findByMosipDocumentTypeParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, mosipDocumentType);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		findByRegistrationId(
			HttpPrincipal httpPrincipal, String registrationId) {

		try {
			MethodKey methodKey = new MethodKey(
				MOIIdMapperServiceUtil.class, "findByRegistrationId",
				_findByRegistrationIdParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, registrationId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		findByResourceId(HttpPrincipal httpPrincipal, long resourceId) {

		try {
			MethodKey methodKey = new MethodKey(
				MOIIdMapperServiceUtil.class, "findByResourceId",
				_findByResourceIdParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, resourceId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		findByDocumentTitle(HttpPrincipal httpPrincipal, String documentTitle) {

		try {
			MethodKey methodKey = new MethodKey(
				MOIIdMapperServiceUtil.class, "findByDocumentTitle",
				_findByDocumentTitleParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, documentTitle);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		findByFileEntryId(HttpPrincipal httpPrincipal, String fileEntryId) {

		try {
			MethodKey methodKey = new MethodKey(
				MOIIdMapperServiceUtil.class, "findByFileEntryId",
				_findByFileEntryIdParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, fileEntryId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		findByUpdateDate(
			HttpPrincipal httpPrincipal, java.util.Date updateDate) {

		try {
			MethodKey methodKey = new MethodKey(
				MOIIdMapperServiceUtil.class, "findByUpdateDate",
				_findByUpdateDateParameterTypes10);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, updateDate);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		findByUpdatedBy(HttpPrincipal httpPrincipal, String updatedBy) {

		try {
			MethodKey methodKey = new MethodKey(
				MOIIdMapperServiceUtil.class, "findByUpdatedBy",
				_findByUpdatedByParameterTypes11);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, updatedBy);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		MOIIdMapperServiceHttp.class);

	private static final Class<?>[] _addMOIIdMapperParameterTypes0 =
		new Class[] {
			long.class, long.class, String.class, String.class, String.class,
			long.class, String.class, int.class, String.class,
			java.util.Date.class, String.class
		};
	private static final Class<?>[] _updateMOIIdMapperParameterTypes1 =
		new Class[] {
			long.class, long.class, long.class, String.class, String.class,
			String.class, long.class, String.class, int.class, String.class,
			java.util.Date.class, String.class
		};
	private static final Class<?>[] _updateMOIIdMapperStateParameterTypes2 =
		new Class[] {long.class, int.class, java.util.Date.class, String.class};
	private static final Class<?>[] _getAllMOIIdMappersParameterTypes3 =
		new Class[] {};
	private static final Class<?>[] _findByMapperIdParameterTypes4 =
		new Class[] {Long.class};
	private static final Class<?>[] _findByMosipDocumentTypeParameterTypes5 =
		new Class[] {String.class};
	private static final Class<?>[] _findByRegistrationIdParameterTypes6 =
		new Class[] {String.class};
	private static final Class<?>[] _findByResourceIdParameterTypes7 =
		new Class[] {long.class};
	private static final Class<?>[] _findByDocumentTitleParameterTypes8 =
		new Class[] {String.class};
	private static final Class<?>[] _findByFileEntryIdParameterTypes9 =
		new Class[] {String.class};
	private static final Class<?>[] _findByUpdateDateParameterTypes10 =
		new Class[] {java.util.Date.class};
	private static final Class<?>[] _findByUpdatedByParameterTypes11 =
		new Class[] {String.class};

}