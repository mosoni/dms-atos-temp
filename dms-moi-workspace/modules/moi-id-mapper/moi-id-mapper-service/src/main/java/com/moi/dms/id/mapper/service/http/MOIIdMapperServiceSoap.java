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

import com.moi.dms.id.mapper.service.MOIIdMapperServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>MOIIdMapperServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.moi.dms.id.mapper.model.MOIIdMapperSoap</code>. If the method in the
 * service utility returns a
 * <code>com.moi.dms.id.mapper.model.MOIIdMapper</code>, that is translated to a
 * <code>com.moi.dms.id.mapper.model.MOIIdMapperSoap</code>. Methods that SOAP
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
 * @see MOIIdMapperServiceHttp
 * @generated
 */
public class MOIIdMapperServiceSoap {

	/**
	 * Overloaded method to create new MOIIdMapper entry. This method should be
	 * used instead of the original method.
	 *
	 * @param groupId
	 * @param companyId
	 * @param mosipCurrentState
	 * @param mosipDocumentType
	 * @param registrationId
	 * @param resourceId
	 * @param documentTitle
	 * @param activeState
	 * @param fileEntryId
	 * @param updateDate
	 * @param updatedBy
	 * @return MOIIdMapper
	 * @throws PortalException
	 */
	public static com.moi.dms.id.mapper.model.MOIIdMapperSoap addMOIIdMapper(
			long groupId, long companyId, String mosipCurrentState,
			String mosipDocumentType, String registrationId, long resourceId,
			String documentTitle, int activeState, String fileEntryId,
			java.util.Date updateDate, String updatedBy)
		throws RemoteException {

		try {
			com.moi.dms.id.mapper.model.MOIIdMapper returnValue =
				MOIIdMapperServiceUtil.addMOIIdMapper(
					groupId, companyId, mosipCurrentState, mosipDocumentType,
					registrationId, resourceId, documentTitle, activeState,
					fileEntryId, updateDate, updatedBy);

			return com.moi.dms.id.mapper.model.MOIIdMapperSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Overloaded method to update existing MOIIdMapper entry. This method
	 * should be used instead of the original method.
	 *
	 * @param mapperId
	 * @param groupId
	 * @param companyId
	 * @param mosipCurrentState
	 * @param mosipDocumentType
	 * @param registrationId
	 * @param resourceId
	 * @param documentTitle
	 * @param activeState
	 * @param fileEntryId
	 * @param updateDate
	 * @param updatedBy
	 * @return MOIIdMapper
	 * @throws PortalException
	 */
	public static com.moi.dms.id.mapper.model.MOIIdMapperSoap updateMOIIdMapper(
			long mapperId, long groupId, long companyId,
			String mosipCurrentState, String mosipDocumentType,
			String registrationId, long resourceId, String documentTitle,
			int activeState, String fileEntryId, java.util.Date updateDate,
			String updatedBy)
		throws RemoteException {

		try {
			com.moi.dms.id.mapper.model.MOIIdMapper returnValue =
				MOIIdMapperServiceUtil.updateMOIIdMapper(
					mapperId, groupId, companyId, mosipCurrentState,
					mosipDocumentType, registrationId, resourceId,
					documentTitle, activeState, fileEntryId, updateDate,
					updatedBy);

			return com.moi.dms.id.mapper.model.MOIIdMapperSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Method to update ActiveState of existing MOIIdMapper entry.
	 *
	 * @param mapperId
	 * @param activeState
	 * @param updateDate
	 * @param updatedBy
	 * @return MOIIdMapper
	 * @throws PortalException
	 */
	public static com.moi.dms.id.mapper.model.MOIIdMapperSoap
			updateMOIIdMapperState(
				long mapperId, int activeState, java.util.Date updateDate,
				String updatedBy)
		throws RemoteException {

		try {
			com.moi.dms.id.mapper.model.MOIIdMapper returnValue =
				MOIIdMapperServiceUtil.updateMOIIdMapperState(
					mapperId, activeState, updateDate, updatedBy);

			return com.moi.dms.id.mapper.model.MOIIdMapperSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Finder method for all MOIIdMapper.
	 *
	 * @return List<MOIIdMapper>
	 */
	public static com.moi.dms.id.mapper.model.MOIIdMapperSoap[]
			getAllMOIIdMappers()
		throws RemoteException {

		try {
			java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
				returnValue = MOIIdMapperServiceUtil.getAllMOIIdMappers();

			return com.moi.dms.id.mapper.model.MOIIdMapperSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Finder method for MOIIdMapper by mapperId.
	 *
	 * @return List<MOIIdMapper>
	 */
	public static com.moi.dms.id.mapper.model.MOIIdMapperSoap[] findByMapperId(
			Long mapperId)
		throws RemoteException {

		try {
			java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
				returnValue = MOIIdMapperServiceUtil.findByMapperId(mapperId);

			return com.moi.dms.id.mapper.model.MOIIdMapperSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Finder method for MOIIdMapper by mosipDocumentType.
	 *
	 * @return List<MOIIdMapper>
	 */
	public static com.moi.dms.id.mapper.model.MOIIdMapperSoap[]
			findByMosipDocumentType(String mosipDocumentType)
		throws RemoteException {

		try {
			java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
				returnValue = MOIIdMapperServiceUtil.findByMosipDocumentType(
					mosipDocumentType);

			return com.moi.dms.id.mapper.model.MOIIdMapperSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Finder method for MOIIdMapper by registrationId.
	 *
	 * @return List<MOIIdMapper>
	 */
	public static com.moi.dms.id.mapper.model.MOIIdMapperSoap[]
			findByRegistrationId(String registrationId)
		throws RemoteException {

		try {
			java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
				returnValue = MOIIdMapperServiceUtil.findByRegistrationId(
					registrationId);

			return com.moi.dms.id.mapper.model.MOIIdMapperSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Finder method for MOIIdMapper by resourceId.
	 *
	 * @return List<MOIIdMapper>
	 */
	public static com.moi.dms.id.mapper.model.MOIIdMapperSoap[]
			findByResourceId(long resourceId)
		throws RemoteException {

		try {
			java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
				returnValue = MOIIdMapperServiceUtil.findByResourceId(
					resourceId);

			return com.moi.dms.id.mapper.model.MOIIdMapperSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Finder method for MOIIdMapper by documentTitle.
	 *
	 * @return List<MOIIdMapper>
	 */
	public static com.moi.dms.id.mapper.model.MOIIdMapperSoap[]
			findByDocumentTitle(String documentTitle)
		throws RemoteException {

		try {
			java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
				returnValue = MOIIdMapperServiceUtil.findByDocumentTitle(
					documentTitle);

			return com.moi.dms.id.mapper.model.MOIIdMapperSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Finder method for MOIIdMapper by fileEntryId.
	 *
	 * @return List<MOIIdMapper>
	 */
	public static com.moi.dms.id.mapper.model.MOIIdMapperSoap[]
			findByFileEntryId(String fileEntryId)
		throws RemoteException {

		try {
			java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
				returnValue = MOIIdMapperServiceUtil.findByFileEntryId(
					fileEntryId);

			return com.moi.dms.id.mapper.model.MOIIdMapperSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Finder method for MOIIdMapper by updateDate.
	 *
	 * @return List<MOIIdMapper>
	 */
	public static com.moi.dms.id.mapper.model.MOIIdMapperSoap[]
			findByUpdateDate(java.util.Date updateDate)
		throws RemoteException {

		try {
			java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
				returnValue = MOIIdMapperServiceUtil.findByUpdateDate(
					updateDate);

			return com.moi.dms.id.mapper.model.MOIIdMapperSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Finder method for MOIIdMapper by updatedBy.
	 *
	 * @return List<MOIIdMapper>
	 */
	public static com.moi.dms.id.mapper.model.MOIIdMapperSoap[] findByUpdatedBy(
			String updatedBy)
		throws RemoteException {

		try {
			java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
				returnValue = MOIIdMapperServiceUtil.findByUpdatedBy(updatedBy);

			return com.moi.dms.id.mapper.model.MOIIdMapperSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		MOIIdMapperServiceSoap.class);

}