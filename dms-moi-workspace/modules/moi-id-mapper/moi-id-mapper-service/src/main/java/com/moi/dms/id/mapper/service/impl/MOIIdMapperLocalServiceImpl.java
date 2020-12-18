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
import com.moi.dms.id.mapper.service.base.MOIIdMapperLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the moi ID mapper local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.moi.dms.id.mapper.service.MOIIdMapperLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MOIIdMapperLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.moi.dms.id.mapper.model.MOIIdMapper",
	service = AopService.class
)
public class MOIIdMapperLocalServiceImpl
	extends MOIIdMapperLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.moi.dms.id.mapper.service.MOIIdMapperLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.moi.dms.id.mapper.service.MOIIdMapperLocalServiceUtil</code>.
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

		// Generate primary key for the MOIIdMapper.
		long mapperId = counterLocalService
				.increment(MOIIdMapper.class.getName());

		// Create MOIIdMapper.
		MOIIdMapper idMapper = createMOIIdMapper(mapperId);

		// Populate fields.
		idMapper.setGroupId(groupId);
		idMapper.setCompanyId(companyId);
		idMapper.setMosipCurrentState(mosipCurrentState);
		idMapper.setMosipDocumentType(mosipDocumentType);
		idMapper.setRegistrationId(registrationId);
		idMapper.setResourceId(resourceId);
		idMapper.setDocumentTitle(documentTitle);
		idMapper.setActiveState(activeState);
		idMapper.setFileEntryId(fileEntryId);
		idMapper.setUpdateDate(updateDate);
		idMapper.setUpdatedBy(updatedBy);

		// Persist MOIIdMapper to database.
		return super.addMOIIdMapper(idMapper);
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

		// Get the MOI ID Mapper by id.
		MOIIdMapper idMapper = getMOIIdMapper(mapperId);

		// Set updated fields.
		idMapper.setGroupId(groupId);
		idMapper.setCompanyId(companyId);
		idMapper.setMosipCurrentState(mosipCurrentState);
		idMapper.setMosipDocumentType(mosipDocumentType);
		idMapper.setRegistrationId(registrationId);
		idMapper.setResourceId(resourceId);
		idMapper.setDocumentTitle(documentTitle);
		idMapper.setActiveState(activeState);
		idMapper.setFileEntryId(fileEntryId);
		idMapper.setUpdateDate(updateDate);
		idMapper.setUpdatedBy(updatedBy);

		// Persist MOI Id Mapper to database.
		return super.updateMOIIdMapper(idMapper);
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

		// Get the MOI ID Mapper by id.
		MOIIdMapper idMapper = getMOIIdMapper(mapperId);

		// Set updated fields.
		idMapper.setActiveState(activeState);
		idMapper.setUpdateDate(updateDate);
		idMapper.setUpdatedBy(updatedBy);

		// Persist MOI Id Mapper to database.
		return super.updateMOIIdMapper(idMapper);
	}

	/**
	 * Finder method for all MOIIdMapper.
	 * 
	 * @return List<MOIIdMapper>
	 */
	public List<MOIIdMapper> getAllMOIIdMappers() {
		return moiIdMapperPersistence.findAll();
	}

	/**
	 * Finder method for MOIIdMapper by mapperId.
	 * 
	 * @return List<MOIIdMapper>
	 */
	public List<MOIIdMapper> findByMapperId(Long mapperId) {
		return moiIdMapperPersistence.findByMapperId(mapperId);
	}

	/**
	 * Finder method for MOIIdMapper by mosipDocumentType.
	 * 
	 * @return List<MOIIdMapper>
	 */
	public List<MOIIdMapper> findByMosipDocumentType(String mosipDocumentType) {
		return moiIdMapperPersistence
				.findByMosipDocumentType(mosipDocumentType);
	}

	/**
	 * Finder method for MOIIdMapper by registrationId.
	 * 
	 * @return List<MOIIdMapper>
	 */
	public List<MOIIdMapper> findByRegistrationId(String registrationId) {
		return moiIdMapperPersistence.findByRegistrationId(registrationId);
	}

	/**
	 * Finder method for MOIIdMapper by resourceId.
	 * 
	 * @return List<MOIIdMapper>
	 */
	public List<MOIIdMapper> findByResourceId(long resourceId) {
		return moiIdMapperPersistence.findByResourceId(resourceId);
	}

	/**
	 * Finder method for MOIIdMapper by documentTitle.
	 * 
	 * @return List<MOIIdMapper>
	 */
	public List<MOIIdMapper> findByDocumentTitle(String documentTitle) {
		return moiIdMapperPersistence.findByDocumentTitle(documentTitle);
	}

	/**
	 * Finder method for MOIIdMapper by fileEntryId.
	 * 
	 * @return List<MOIIdMapper>
	 */
	public List<MOIIdMapper> findByFileEntryId(String fileEntryId) {
		return moiIdMapperPersistence.findByFileEntryId(fileEntryId);
	}

	/**
	 * Finder method for MOIIdMapper by updateDate.
	 * 
	 * @return List<MOIIdMapper>
	 */
	public List<MOIIdMapper> findByUpdateDate(Date updateDate) {
		return moiIdMapperPersistence.findByUpdateDate(updateDate);
	}

	/**
	 * Finder method for MOIIdMapper by updatedBy.
	 * 
	 * @return List<MOIIdMapper>
	 */
	public List<MOIIdMapper> findByUpdatedBy(String updatedBy) {
		return moiIdMapperPersistence.findByUpdatedBy(updatedBy);
	}

	/**
	 * Method overridden as this method is not supported.
	 * 
	 * @param moiIdMapper
	 */
	@Override
	public MOIIdMapper addMOIIdMapper(MOIIdMapper moiIdMapper) {
		throw new UnsupportedOperationException("Method not supported.");
	}

	/**
	 * Method overridden as this method is not supported.
	 * 
	 * @param moiIdMapper
	 */
	@Override
	public MOIIdMapper updateMOIIdMapper(MOIIdMapper moiIdMapper) {
		throw new UnsupportedOperationException("Method not supported.");
	}
}