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

package com.moi.dms.id.mapper.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for MOIIdMapper. This utility wraps
 * <code>com.moi.dms.id.mapper.service.impl.MOIIdMapperServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see MOIIdMapperService
 * @generated
 */
public class MOIIdMapperServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.moi.dms.id.mapper.service.impl.MOIIdMapperServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static com.moi.dms.id.mapper.model.MOIIdMapper addMOIIdMapper(
			long groupId, long companyId, String mosipCurrentState,
			String mosipDocumentType, String registrationId, long resourceId,
			String documentTitle, int activeState, String fileEntryId,
			java.util.Date updateDate, String updatedBy)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addMOIIdMapper(
			groupId, companyId, mosipCurrentState, mosipDocumentType,
			registrationId, resourceId, documentTitle, activeState, fileEntryId,
			updateDate, updatedBy);
	}

	/**
	 * Finder method for MOIIdMapper by documentTitle.
	 *
	 * @return List<MOIIdMapper>
	 */
	public static java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		findByDocumentTitle(String documentTitle) {

		return getService().findByDocumentTitle(documentTitle);
	}

	/**
	 * Finder method for MOIIdMapper by fileEntryId.
	 *
	 * @return List<MOIIdMapper>
	 */
	public static java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		findByFileEntryId(String fileEntryId) {

		return getService().findByFileEntryId(fileEntryId);
	}

	/**
	 * Finder method for MOIIdMapper by mapperId.
	 *
	 * @return List<MOIIdMapper>
	 */
	public static java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		findByMapperId(Long mapperId) {

		return getService().findByMapperId(mapperId);
	}

	/**
	 * Finder method for MOIIdMapper by mosipDocumentType.
	 *
	 * @return List<MOIIdMapper>
	 */
	public static java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		findByMosipDocumentType(String mosipDocumentType) {

		return getService().findByMosipDocumentType(mosipDocumentType);
	}

	/**
	 * Finder method for MOIIdMapper by resourceId.
	 *
	 * @return List<MOIIdMapper>
	 */
	public static java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		findByResourceId(long resourceId) {

		return getService().findByResourceId(resourceId);
	}

	/**
	 * Finder method for MOIIdMapper by updateDate.
	 *
	 * @return List<MOIIdMapper>
	 */
	public static java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		findByUpdateDate(java.util.Date updateDate) {

		return getService().findByUpdateDate(updateDate);
	}

	/**
	 * Finder method for MOIIdMapper by updatedBy.
	 *
	 * @return List<MOIIdMapper>
	 */
	public static java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		findByUpdatedBy(String updatedBy) {

		return getService().findByUpdatedBy(updatedBy);
	}

	/**
	 * Finder method for all MOIIdMapper.
	 *
	 * @return List<MOIIdMapper>
	 */
	public static java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		getAllMOIIdMappers() {

		return getService().getAllMOIIdMappers();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
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
	public static com.moi.dms.id.mapper.model.MOIIdMapper updateMOIIdMapper(
			long mapperId, long groupId, long companyId,
			String mosipCurrentState, String mosipDocumentType,
			String registrationId, long resourceId, String documentTitle,
			int activeState, String fileEntryId, java.util.Date updateDate,
			String updatedBy)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateMOIIdMapper(
			mapperId, groupId, companyId, mosipCurrentState, mosipDocumentType,
			registrationId, resourceId, documentTitle, activeState, fileEntryId,
			updateDate, updatedBy);
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
	public static com.moi.dms.id.mapper.model.MOIIdMapper
			updateMOIIdMapperState(
				long mapperId, int activeState, java.util.Date updateDate,
				String updatedBy)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateMOIIdMapperState(
			mapperId, activeState, updateDate, updatedBy);
	}

	public static MOIIdMapperService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MOIIdMapperService, MOIIdMapperService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MOIIdMapperService.class);

		ServiceTracker<MOIIdMapperService, MOIIdMapperService> serviceTracker =
			new ServiceTracker<MOIIdMapperService, MOIIdMapperService>(
				bundle.getBundleContext(), MOIIdMapperService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}