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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MOIIdMapperService}.
 *
 * @author Brian Wing Shun Chan
 * @see MOIIdMapperService
 * @generated
 */
public class MOIIdMapperServiceWrapper
	implements MOIIdMapperService, ServiceWrapper<MOIIdMapperService> {

	public MOIIdMapperServiceWrapper(MOIIdMapperService moiIdMapperService) {
		_moiIdMapperService = moiIdMapperService;
	}

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
	@Override
	public com.moi.dms.id.mapper.model.MOIIdMapper addMOIIdMapper(
			long groupId, long companyId, String mosipCurrentState,
			String mosipDocumentType, String registrationId, long resourceId,
			String documentTitle, int activeState, String fileEntryId,
			java.util.Date updateDate, String updatedBy)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _moiIdMapperService.addMOIIdMapper(
			groupId, companyId, mosipCurrentState, mosipDocumentType,
			registrationId, resourceId, documentTitle, activeState, fileEntryId,
			updateDate, updatedBy);
	}

	/**
	 * Finder method for MOIIdMapper by documentTitle.
	 *
	 * @return List<MOIIdMapper>
	 */
	@Override
	public java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		findByDocumentTitle(String documentTitle) {

		return _moiIdMapperService.findByDocumentTitle(documentTitle);
	}

	/**
	 * Finder method for MOIIdMapper by fileEntryId.
	 *
	 * @return List<MOIIdMapper>
	 */
	@Override
	public java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		findByFileEntryId(String fileEntryId) {

		return _moiIdMapperService.findByFileEntryId(fileEntryId);
	}

	/**
	 * Finder method for MOIIdMapper by mapperId.
	 *
	 * @return List<MOIIdMapper>
	 */
	@Override
	public java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		findByMapperId(Long mapperId) {

		return _moiIdMapperService.findByMapperId(mapperId);
	}

	/**
	 * Finder method for MOIIdMapper by mosipDocumentType.
	 *
	 * @return List<MOIIdMapper>
	 */
	@Override
	public java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		findByMosipDocumentType(String mosipDocumentType) {

		return _moiIdMapperService.findByMosipDocumentType(mosipDocumentType);
	}

	/**
	 * Finder method for MOIIdMapper by resourceId.
	 *
	 * @return List<MOIIdMapper>
	 */
	@Override
	public java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		findByResourceId(long resourceId) {

		return _moiIdMapperService.findByResourceId(resourceId);
	}

	/**
	 * Finder method for MOIIdMapper by updateDate.
	 *
	 * @return List<MOIIdMapper>
	 */
	@Override
	public java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		findByUpdateDate(java.util.Date updateDate) {

		return _moiIdMapperService.findByUpdateDate(updateDate);
	}

	/**
	 * Finder method for MOIIdMapper by updatedBy.
	 *
	 * @return List<MOIIdMapper>
	 */
	@Override
	public java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		findByUpdatedBy(String updatedBy) {

		return _moiIdMapperService.findByUpdatedBy(updatedBy);
	}

	/**
	 * Finder method for all MOIIdMapper.
	 *
	 * @return List<MOIIdMapper>
	 */
	@Override
	public java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		getAllMOIIdMappers() {

		return _moiIdMapperService.getAllMOIIdMappers();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _moiIdMapperService.getOSGiServiceIdentifier();
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
	@Override
	public com.moi.dms.id.mapper.model.MOIIdMapper updateMOIIdMapper(
			long mapperId, long groupId, long companyId,
			String mosipCurrentState, String mosipDocumentType,
			String registrationId, long resourceId, String documentTitle,
			int activeState, String fileEntryId, java.util.Date updateDate,
			String updatedBy)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _moiIdMapperService.updateMOIIdMapper(
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
	@Override
	public com.moi.dms.id.mapper.model.MOIIdMapper updateMOIIdMapperState(
			long mapperId, int activeState, java.util.Date updateDate,
			String updatedBy)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _moiIdMapperService.updateMOIIdMapperState(
			mapperId, activeState, updateDate, updatedBy);
	}

	@Override
	public MOIIdMapperService getWrappedService() {
		return _moiIdMapperService;
	}

	@Override
	public void setWrappedService(MOIIdMapperService moiIdMapperService) {
		_moiIdMapperService = moiIdMapperService;
	}

	private MOIIdMapperService _moiIdMapperService;

}