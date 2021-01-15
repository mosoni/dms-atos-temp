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
 * Provides a wrapper for {@link MOIIdMapperLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MOIIdMapperLocalService
 * @generated
 */
public class MOIIdMapperLocalServiceWrapper
	implements MOIIdMapperLocalService,
			   ServiceWrapper<MOIIdMapperLocalService> {

	public MOIIdMapperLocalServiceWrapper(
		MOIIdMapperLocalService moiIdMapperLocalService) {

		_moiIdMapperLocalService = moiIdMapperLocalService;
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

		return _moiIdMapperLocalService.addMOIIdMapper(
			groupId, companyId, mosipCurrentState, mosipDocumentType,
			registrationId, resourceId, documentTitle, activeState, fileEntryId,
			updateDate, updatedBy);
	}

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
	@Override
	public com.moi.dms.id.mapper.model.MOIIdMapper addMOIIdMapper(
		com.moi.dms.id.mapper.model.MOIIdMapper moiIdMapper) {

		return _moiIdMapperLocalService.addMOIIdMapper(moiIdMapper);
	}

	/**
	 * Creates a new moi ID mapper with the primary key. Does not add the moi ID mapper to the database.
	 *
	 * @param mapperId the primary key for the new moi ID mapper
	 * @return the new moi ID mapper
	 */
	@Override
	public com.moi.dms.id.mapper.model.MOIIdMapper createMOIIdMapper(
		long mapperId) {

		return _moiIdMapperLocalService.createMOIIdMapper(mapperId);
	}

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
	@Override
	public com.moi.dms.id.mapper.model.MOIIdMapper deleteMOIIdMapper(
			long mapperId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _moiIdMapperLocalService.deleteMOIIdMapper(mapperId);
	}

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
	@Override
	public com.moi.dms.id.mapper.model.MOIIdMapper deleteMOIIdMapper(
		com.moi.dms.id.mapper.model.MOIIdMapper moiIdMapper) {

		return _moiIdMapperLocalService.deleteMOIIdMapper(moiIdMapper);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _moiIdMapperLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _moiIdMapperLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _moiIdMapperLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _moiIdMapperLocalService.dynamicQuery(dynamicQuery, start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _moiIdMapperLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _moiIdMapperLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _moiIdMapperLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.moi.dms.id.mapper.model.MOIIdMapper fetchMOIIdMapper(
		long mapperId) {

		return _moiIdMapperLocalService.fetchMOIIdMapper(mapperId);
	}

	/**
	 * Finder method for MOIIdMapper by documentTitle.
	 *
	 * @return List<MOIIdMapper>
	 */
	@Override
	public java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		findByDocumentTitle(String documentTitle) {

		return _moiIdMapperLocalService.findByDocumentTitle(documentTitle);
	}

	/**
	 * Finder method for MOIIdMapper by fileEntryId.
	 *
	 * @return List<MOIIdMapper>
	 */
	@Override
	public java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		findByFileEntryId(String fileEntryId) {

		return _moiIdMapperLocalService.findByFileEntryId(fileEntryId);
	}

	/**
	 * Finder method for MOIIdMapper by mapperId.
	 *
	 * @return List<MOIIdMapper>
	 */
	@Override
	public java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		findByMapperId(Long mapperId) {

		return _moiIdMapperLocalService.findByMapperId(mapperId);
	}

	/**
	 * Finder method for MOIIdMapper by mosipDocumentType.
	 *
	 * @return List<MOIIdMapper>
	 */
	@Override
	public java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		findByMosipDocumentType(String mosipDocumentType) {

		return _moiIdMapperLocalService.findByMosipDocumentType(
			mosipDocumentType);
	}

	/**
	 * Finder method for MOIIdMapper by registrationId.
	 *
	 * @return List<MOIIdMapper>
	 */
	@Override
	public java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		findByRegistrationId(String registrationId) {

		return _moiIdMapperLocalService.findByRegistrationId(registrationId);
	}

	/**
	 * Finder method for MOIIdMapper by registrationId.
	 *
	 * @return List<MOIIdMapper>
	 */
	@Override
	public com.moi.dms.id.mapper.model.MOIIdMapper
		findByRegistrationIdCurrentState(
			String registrationId, String currentState) {

		return _moiIdMapperLocalService.findByRegistrationIdCurrentState(
			registrationId, currentState);
	}

	/**
	 * Finder method for MOIIdMapper by resourceId.
	 *
	 * @return List<MOIIdMapper>
	 */
	@Override
	public java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		findByResourceId(long resourceId) {

		return _moiIdMapperLocalService.findByResourceId(resourceId);
	}

	/**
	 * Finder method for MOIIdMapper by updateDate.
	 *
	 * @return List<MOIIdMapper>
	 */
	@Override
	public java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		findByUpdateDate(java.util.Date updateDate) {

		return _moiIdMapperLocalService.findByUpdateDate(updateDate);
	}

	/**
	 * Finder method for MOIIdMapper by updatedBy.
	 *
	 * @return List<MOIIdMapper>
	 */
	@Override
	public java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		findByUpdatedBy(String updatedBy) {

		return _moiIdMapperLocalService.findByUpdatedBy(updatedBy);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _moiIdMapperLocalService.getActionableDynamicQuery();
	}

	/**
	 * Finder method for all MOIIdMapper.
	 *
	 * @return List<MOIIdMapper>
	 */
	@Override
	public java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		getAllMOIIdMappers() {

		return _moiIdMapperLocalService.getAllMOIIdMappers();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _moiIdMapperLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the moi ID mapper with the primary key.
	 *
	 * @param mapperId the primary key of the moi ID mapper
	 * @return the moi ID mapper
	 * @throws PortalException if a moi ID mapper with the primary key could not be found
	 */
	@Override
	public com.moi.dms.id.mapper.model.MOIIdMapper getMOIIdMapper(long mapperId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _moiIdMapperLocalService.getMOIIdMapper(mapperId);
	}

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
	@Override
	public java.util.List<com.moi.dms.id.mapper.model.MOIIdMapper>
		getMOIIdMappers(int start, int end) {

		return _moiIdMapperLocalService.getMOIIdMappers(start, end);
	}

	/**
	 * Returns the number of moi ID mappers.
	 *
	 * @return the number of moi ID mappers
	 */
	@Override
	public int getMOIIdMappersCount() {
		return _moiIdMapperLocalService.getMOIIdMappersCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _moiIdMapperLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _moiIdMapperLocalService.getPersistedModel(primaryKeyObj);
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

		return _moiIdMapperLocalService.updateMOIIdMapper(
			mapperId, groupId, companyId, mosipCurrentState, mosipDocumentType,
			registrationId, resourceId, documentTitle, activeState, fileEntryId,
			updateDate, updatedBy);
	}

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
	@Override
	public com.moi.dms.id.mapper.model.MOIIdMapper updateMOIIdMapper(
		com.moi.dms.id.mapper.model.MOIIdMapper moiIdMapper) {

		return _moiIdMapperLocalService.updateMOIIdMapper(moiIdMapper);
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

		return _moiIdMapperLocalService.updateMOIIdMapperState(
			mapperId, activeState, updateDate, updatedBy);
	}

	@Override
	public MOIIdMapperLocalService getWrappedService() {
		return _moiIdMapperLocalService;
	}

	@Override
	public void setWrappedService(
		MOIIdMapperLocalService moiIdMapperLocalService) {

		_moiIdMapperLocalService = moiIdMapperLocalService;
	}

	private MOIIdMapperLocalService _moiIdMapperLocalService;

}