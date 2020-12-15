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

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.moi.dms.id.mapper.model.MOIIdMapper;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for MOIIdMapper. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see MOIIdMapperLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface MOIIdMapperLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.moi.dms.id.mapper.service.impl.MOIIdMapperLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the moi ID mapper local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link MOIIdMapperLocalServiceUtil} if injection and service tracking are not available.
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
	 * Adds the moi ID mapper to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MOIIdMapperLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param moiIdMapper the moi ID mapper
	 * @return the moi ID mapper that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public MOIIdMapper addMOIIdMapper(MOIIdMapper moiIdMapper);

	/**
	 * Creates a new moi ID mapper with the primary key. Does not add the moi ID mapper to the database.
	 *
	 * @param mapperId the primary key for the new moi ID mapper
	 * @return the new moi ID mapper
	 */
	@Transactional(enabled = false)
	public MOIIdMapper createMOIIdMapper(long mapperId);

	/**
	 * Deletes the moi ID mapper with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MOIIdMapperLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mapperId the primary key of the moi ID mapper
	 * @return the moi ID mapper that was removed
	 * @throws PortalException if a moi ID mapper with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public MOIIdMapper deleteMOIIdMapper(long mapperId) throws PortalException;

	/**
	 * Deletes the moi ID mapper from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MOIIdMapperLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param moiIdMapper the moi ID mapper
	 * @return the moi ID mapper that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public MOIIdMapper deleteMOIIdMapper(MOIIdMapper moiIdMapper);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.moi.dms.id.mapper.model.impl.MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.moi.dms.id.mapper.model.impl.MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MOIIdMapper fetchMOIIdMapper(long mapperId);

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

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Finder method for all MOIIdMapper.
	 *
	 * @return List<MOIIdMapper>
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MOIIdMapper> getAllMOIIdMappers();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the moi ID mapper with the primary key.
	 *
	 * @param mapperId the primary key of the moi ID mapper
	 * @return the moi ID mapper
	 * @throws PortalException if a moi ID mapper with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MOIIdMapper getMOIIdMapper(long mapperId) throws PortalException;

	/**
	 * Returns a range of all the moi ID mappers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.moi.dms.id.mapper.model.impl.MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of moi ID mappers
	 * @param end the upper bound of the range of moi ID mappers (not inclusive)
	 * @return the range of moi ID mappers
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MOIIdMapper> getMOIIdMappers(int start, int end);

	/**
	 * Returns the number of moi ID mappers.
	 *
	 * @return the number of moi ID mappers
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMOIIdMappersCount();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	 * Updates the moi ID mapper in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MOIIdMapperLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param moiIdMapper the moi ID mapper
	 * @return the moi ID mapper that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public MOIIdMapper updateMOIIdMapper(MOIIdMapper moiIdMapper);

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