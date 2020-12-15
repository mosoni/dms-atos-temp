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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import com.moi.dms.id.mapper.model.MOIIdMapper;

import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for MOIIdMapper. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see MOIIdMapperServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface MOIIdMapperService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.moi.dms.id.mapper.service.impl.MOIIdMapperServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the moi ID mapper remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link MOIIdMapperServiceUtil} if injection and service tracking are not available.
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
	public MOIIdMapper addMOIIdMapper(
			long groupId, long companyId, String mosipCurrentState,
			String mosipDocumentType, String registrationId, long resourceId,
			String documentTitle, int activeState, String fileEntryId,
			Date updateDate, String updatedBy)
		throws PortalException;

	/**
	 * Finder method for MOIIdMapper by documentTitle.
	 *
	 * @return List<MOIIdMapper>
	 */
	public List<MOIIdMapper> findByDocumentTitle(String documentTitle);

	/**
	 * Finder method for MOIIdMapper by fileEntryId.
	 *
	 * @return List<MOIIdMapper>
	 */
	public List<MOIIdMapper> findByFileEntryId(String fileEntryId);

	/**
	 * Finder method for MOIIdMapper by mapperId.
	 *
	 * @return List<MOIIdMapper>
	 */
	public List<MOIIdMapper> findByMapperId(Long mapperId);

	/**
	 * Finder method for MOIIdMapper by mosipDocumentType.
	 *
	 * @return List<MOIIdMapper>
	 */
	public List<MOIIdMapper> findByMosipDocumentType(String mosipDocumentType);

	/**
	 * Finder method for MOIIdMapper by registrationId.
	 *
	 * @return List<MOIIdMapper>
	 */
	public List<MOIIdMapper> findByRegistrationId(String registrationId);

	/**
	 * Finder method for MOIIdMapper by resourceId.
	 *
	 * @return List<MOIIdMapper>
	 */
	public List<MOIIdMapper> findByResourceId(long resourceId);

	/**
	 * Finder method for MOIIdMapper by updateDate.
	 *
	 * @return List<MOIIdMapper>
	 */
	public List<MOIIdMapper> findByUpdateDate(Date updateDate);

	/**
	 * Finder method for MOIIdMapper by updatedBy.
	 *
	 * @return List<MOIIdMapper>
	 */
	public List<MOIIdMapper> findByUpdatedBy(String updatedBy);

	/**
	 * Finder method for all MOIIdMapper.
	 *
	 * @return List<MOIIdMapper>
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MOIIdMapper> getAllMOIIdMappers();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

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
	public MOIIdMapper updateMOIIdMapper(
			long mapperId, long groupId, long companyId,
			String mosipCurrentState, String mosipDocumentType,
			String registrationId, long resourceId, String documentTitle,
			int activeState, String fileEntryId, Date updateDate,
			String updatedBy)
		throws PortalException;

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
	public MOIIdMapper updateMOIIdMapperState(
			long mapperId, int activeState, Date updateDate, String updatedBy)
		throws PortalException;

}