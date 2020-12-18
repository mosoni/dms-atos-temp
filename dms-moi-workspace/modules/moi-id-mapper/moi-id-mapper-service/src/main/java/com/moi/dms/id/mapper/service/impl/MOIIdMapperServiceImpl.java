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

package com.moi.dms.id.mapper.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.moi.dms.id.mapper.model.MOIIdMapper;
import com.moi.dms.id.mapper.service.base.MOIIdMapperServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the moi ID mapper remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.moi.dms.id.mapper.service.MOIIdMapperService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MOIIdMapperServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=moiidm",
		"json.web.service.context.path=MOIIdMapper"
	},
	service = AopService.class
)
public class MOIIdMapperServiceImpl extends MOIIdMapperServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.moi.dms.id.mapper.service.MOIIdMapperServiceUtil</code> to access the moi ID mapper remote service.
	 */

	/**
	 *
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
	public MOIIdMapper addMOIIdMapper(long groupId, long companyId,
			String mosipCurrentState, String mosipDocumentType,
			String registrationId, long resourceId, String documentTitle,
			int activeState, String fileEntryId, Date updateDate,
			String updatedBy) throws PortalException {

		return moiIdMapperLocalService.addMOIIdMapper(groupId, companyId,
				mosipCurrentState, mosipDocumentType, registrationId,
				resourceId, documentTitle, activeState, fileEntryId, updateDate,
				updatedBy);
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
	public MOIIdMapper updateMOIIdMapper(long mapperId, long groupId,
			long companyId, String mosipCurrentState, String mosipDocumentType,
			String registrationId, long resourceId, String documentTitle,
			int activeState, String fileEntryId, Date updateDate,
			String updatedBy) throws PortalException {

		return moiIdMapperLocalService.updateMOIIdMapper(mapperId, groupId,
				companyId, mosipCurrentState, mosipDocumentType, registrationId,
				resourceId, documentTitle, activeState, fileEntryId, updateDate,
				updatedBy);
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
	public MOIIdMapper updateMOIIdMapperState(long mapperId, int activeState,
			Date updateDate, String updatedBy) throws PortalException {

		return moiIdMapperLocalService.updateMOIIdMapperState(mapperId,
				activeState, updateDate, updatedBy);
	}

	/**
	 * Finder method for all MOIIdMapper.
	 * 
	 * @return List<MOIIdMapper>
	 */
	public List<MOIIdMapper> getAllMOIIdMappers() {
		return moiIdMapperLocalService.getAllMOIIdMappers();
	}

	/**
	 * Finder method for MOIIdMapper by mapperId.
	 * 
	 * @return List<MOIIdMapper>
	 */
	public List<MOIIdMapper> findByMapperId(Long mapperId) {
		return moiIdMapperLocalService.findByMapperId(mapperId);
	}

	/**
	 * Finder method for MOIIdMapper by mosipDocumentType.
	 * 
	 * @return List<MOIIdMapper>
	 */
	public List<MOIIdMapper> findByMosipDocumentType(String mosipDocumentType) {
		return moiIdMapperLocalService
				.findByMosipDocumentType(mosipDocumentType);
	}

	/**
	 * Finder method for MOIIdMapper by registrationId.
	 * 
	 * @return List<MOIIdMapper>
	 */
	public List<MOIIdMapper> findByRegistrationId(String registrationId) {
		return moiIdMapperLocalService.findByRegistrationId(registrationId);
	}

	/**
	 * Finder method for MOIIdMapper by resourceId.
	 * 
	 * @return List<MOIIdMapper>
	 */
	public List<MOIIdMapper> findByResourceId(long resourceId) {
		return moiIdMapperLocalService.findByResourceId(resourceId);
	}

	/**
	 * Finder method for MOIIdMapper by documentTitle.
	 * 
	 * @return List<MOIIdMapper>
	 */
	public List<MOIIdMapper> findByDocumentTitle(String documentTitle) {
		return moiIdMapperLocalService.findByDocumentTitle(documentTitle);
	}

	/**
	 * Finder method for MOIIdMapper by fileEntryId.
	 * 
	 * @return List<MOIIdMapper>
	 */
	public List<MOIIdMapper> findByFileEntryId(String fileEntryId) {
		return moiIdMapperLocalService.findByFileEntryId(fileEntryId);
	}

	/**
	 * Finder method for MOIIdMapper by updateDate.
	 * 
	 * @return List<MOIIdMapper>
	 */
	public List<MOIIdMapper> findByUpdateDate(Date updateDate) {
		return moiIdMapperLocalService.findByUpdateDate(updateDate);
	}

	/**
	 * Finder method for MOIIdMapper by updatedBy.
	 * 
	 * @return List<MOIIdMapper>
	 */
	public List<MOIIdMapper> findByUpdatedBy(String updatedBy) {
		return moiIdMapperLocalService.findByUpdatedBy(updatedBy);
	}
}