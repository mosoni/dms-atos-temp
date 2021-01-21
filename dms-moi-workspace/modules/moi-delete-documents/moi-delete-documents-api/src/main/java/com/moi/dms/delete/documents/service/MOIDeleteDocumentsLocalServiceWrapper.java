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

package com.moi.dms.delete.documents.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MOIDeleteDocumentsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MOIDeleteDocumentsLocalService
 * @generated
 */
public class MOIDeleteDocumentsLocalServiceWrapper
	implements MOIDeleteDocumentsLocalService,
			   ServiceWrapper<MOIDeleteDocumentsLocalService> {

	public MOIDeleteDocumentsLocalServiceWrapper(
		MOIDeleteDocumentsLocalService moiDeleteDocumentsLocalService) {

		_moiDeleteDocumentsLocalService = moiDeleteDocumentsLocalService;
	}

	/**
	 * Overloaded method to create new MOIDeleteDocuments entry. This method
	 * should be used instead of the original method.
	 *
	 * @param fileEntryId
	 * @param fileEntryName
	 * @param consumerCode
	 * @param moduleType
	 * @param uploadedBy
	 * @param uploadedDate
	 * @param status
	 * @param comments
	 * @param updatedBy
	 * @param updatedDate
	 * @param pendingIdentifiers
	 * @return MOIDeleteDocuments
	 */
	@Override
	public com.moi.dms.delete.documents.model.MOIDeleteDocuments
		addMOIDeleteDocuments(
			long fileEntryId, String fileEntryName, String consumerCode,
			String moduleType, String uploadedBy, java.util.Date uploadedDate,
			String status, String comments, String updatedBy,
			java.util.Date updatedDate, String pendingIdentifiers) {

		return _moiDeleteDocumentsLocalService.addMOIDeleteDocuments(
			fileEntryId, fileEntryName, consumerCode, moduleType, uploadedBy,
			uploadedDate, status, comments, updatedBy, updatedDate,
			pendingIdentifiers);
	}

	/**
	 * Adds the moi delete documents to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MOIDeleteDocumentsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param moiDeleteDocuments the moi delete documents
	 * @return the moi delete documents that was added
	 */
	@Override
	public com.moi.dms.delete.documents.model.MOIDeleteDocuments
		addMOIDeleteDocuments(
			com.moi.dms.delete.documents.model.MOIDeleteDocuments
				moiDeleteDocuments) {

		return _moiDeleteDocumentsLocalService.addMOIDeleteDocuments(
			moiDeleteDocuments);
	}

	/**
	 * Creates a new moi delete documents with the primary key. Does not add the moi delete documents to the database.
	 *
	 * @param documentId the primary key for the new moi delete documents
	 * @return the new moi delete documents
	 */
	@Override
	public com.moi.dms.delete.documents.model.MOIDeleteDocuments
		createMOIDeleteDocuments(long documentId) {

		return _moiDeleteDocumentsLocalService.createMOIDeleteDocuments(
			documentId);
	}

	/**
	 * Deletes the moi delete documents with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MOIDeleteDocumentsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param documentId the primary key of the moi delete documents
	 * @return the moi delete documents that was removed
	 * @throws PortalException if a moi delete documents with the primary key could not be found
	 */
	@Override
	public com.moi.dms.delete.documents.model.MOIDeleteDocuments
			deleteMOIDeleteDocuments(long documentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _moiDeleteDocumentsLocalService.deleteMOIDeleteDocuments(
			documentId);
	}

	/**
	 * Deletes the moi delete documents from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MOIDeleteDocumentsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param moiDeleteDocuments the moi delete documents
	 * @return the moi delete documents that was removed
	 */
	@Override
	public com.moi.dms.delete.documents.model.MOIDeleteDocuments
		deleteMOIDeleteDocuments(
			com.moi.dms.delete.documents.model.MOIDeleteDocuments
				moiDeleteDocuments) {

		return _moiDeleteDocumentsLocalService.deleteMOIDeleteDocuments(
			moiDeleteDocuments);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _moiDeleteDocumentsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _moiDeleteDocumentsLocalService.dynamicQuery();
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

		return _moiDeleteDocumentsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.moi.dms.delete.documents.model.impl.MOIDeleteDocumentsModelImpl</code>.
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

		return _moiDeleteDocumentsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.moi.dms.delete.documents.model.impl.MOIDeleteDocumentsModelImpl</code>.
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

		return _moiDeleteDocumentsLocalService.dynamicQuery(
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

		return _moiDeleteDocumentsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _moiDeleteDocumentsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.moi.dms.delete.documents.model.MOIDeleteDocuments
		fetchMOIDeleteDocuments(long documentId) {

		return _moiDeleteDocumentsLocalService.fetchMOIDeleteDocuments(
			documentId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _moiDeleteDocumentsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Finder method for all MOIDeleteDocuments.
	 *
	 * @return List<MOIDeleteDocuments>
	 */
	@Override
	public java.util.List<com.moi.dms.delete.documents.model.MOIDeleteDocuments>
		getAllDeleteDocuments() {

		return _moiDeleteDocumentsLocalService.getAllDeleteDocuments();
	}

	/**
	 * Finder method for MOIDeleteDocuments.
	 *
	 * @param documentId
	 * @return List<MOIDeleteDocuments>
	 */
	@Override
	public java.util.List<com.moi.dms.delete.documents.model.MOIDeleteDocuments>
		getDeleteDocumentsByDocumentId(Long documentId) {

		return _moiDeleteDocumentsLocalService.getDeleteDocumentsByDocumentId(
			documentId);
	}

	/**
	 * Finder method for MOIDeleteDocuments.
	 *
	 * @param documentId
	 * @param start
	 * @param end
	 * @return List<MOIDeleteDocuments>
	 */
	@Override
	public java.util.List<com.moi.dms.delete.documents.model.MOIDeleteDocuments>
		getDeleteDocumentsByDocumentId(Long documentId, int start, int end) {

		return _moiDeleteDocumentsLocalService.getDeleteDocumentsByDocumentId(
			documentId, start, end);
	}

	/**
	 * Returns the MOIDeleteDocuments with keywords.
	 *
	 * @param keywords
	 * @param start
	 * @param end
	 * @param orderByComparator
	 * @return List<MOIDeleteDocuments>
	 */
	@Override
	public java.util.List<com.moi.dms.delete.documents.model.MOIDeleteDocuments>
		getDeleteDocumentsByKeywords(
			String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.moi.dms.delete.documents.model.MOIDeleteDocuments>
					orderByComparator) {

		return _moiDeleteDocumentsLocalService.getDeleteDocumentsByKeywords(
			keywords, start, end, orderByComparator);
	}

	/**
	 * Finder method for MOIDeleteDocuments.
	 *
	 * @param status
	 * @return List<MOIDeleteDocuments>
	 */
	@Override
	public java.util.List<com.moi.dms.delete.documents.model.MOIDeleteDocuments>
		getDeleteDocumentsByStatus(java.util.List<String> multipleStatus) {

		return _moiDeleteDocumentsLocalService.getDeleteDocumentsByStatus(
			multipleStatus);
	}

	/**
	 * Finder method for MOIDeleteDocuments.
	 *
	 * @param status
	 * @return List<MOIDeleteDocuments>
	 */
	@Override
	public java.util.List<com.moi.dms.delete.documents.model.MOIDeleteDocuments>
		getDeleteDocumentsByStatus(String status) {

		return _moiDeleteDocumentsLocalService.getDeleteDocumentsByStatus(
			status);
	}

	/**
	 * Returns the MOIDeleteDocuments count with keywords.
	 *
	 * @param keywords
	 * @return long
	 */
	@Override
	public long getDeleteDocumentsCountByKeywords(String keywords) {
		return _moiDeleteDocumentsLocalService.
			getDeleteDocumentsCountByKeywords(keywords);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _moiDeleteDocumentsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the moi delete documents with the primary key.
	 *
	 * @param documentId the primary key of the moi delete documents
	 * @return the moi delete documents
	 * @throws PortalException if a moi delete documents with the primary key could not be found
	 */
	@Override
	public com.moi.dms.delete.documents.model.MOIDeleteDocuments
			getMOIDeleteDocuments(long documentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _moiDeleteDocumentsLocalService.getMOIDeleteDocuments(
			documentId);
	}

	/**
	 * Returns a range of all the moi delete documentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.moi.dms.delete.documents.model.impl.MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @return the range of moi delete documentses
	 */
	@Override
	public java.util.List<com.moi.dms.delete.documents.model.MOIDeleteDocuments>
		getMOIDeleteDocumentses(int start, int end) {

		return _moiDeleteDocumentsLocalService.getMOIDeleteDocumentses(
			start, end);
	}

	/**
	 * Returns the number of moi delete documentses.
	 *
	 * @return the number of moi delete documentses
	 */
	@Override
	public int getMOIDeleteDocumentsesCount() {
		return _moiDeleteDocumentsLocalService.getMOIDeleteDocumentsesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _moiDeleteDocumentsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _moiDeleteDocumentsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Overloaded method to update existing MOIDeleteDocuments entry. This
	 * method should be used instead of the original method.
	 *
	 * @param documentId
	 * @param fileEntryId
	 * @param fileEntryName
	 * @param consumerCode
	 * @param moduleType
	 * @param uploadedBy
	 * @param uploadedDate
	 * @param status
	 * @param comments
	 * @param updatedBy
	 * @param updatedDate
	 * @param pendingIdentifiers
	 * @return MOIDeleteDocuments
	 * @throws PortalException
	 */
	@Override
	public com.moi.dms.delete.documents.model.MOIDeleteDocuments
			updateMOIDeleteDocuments(
				long documentId, long fileEntryId, String fileEntryName,
				String consumerCode, String moduleType, String uploadedBy,
				java.util.Date uploadedDate, String status, String comments,
				String updatedBy, java.util.Date updatedDate,
				String pendingIdentifiers)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _moiDeleteDocumentsLocalService.updateMOIDeleteDocuments(
			documentId, fileEntryId, fileEntryName, consumerCode, moduleType,
			uploadedBy, uploadedDate, status, comments, updatedBy, updatedDate,
			pendingIdentifiers);
	}

	/**
	 * Updates the moi delete documents in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MOIDeleteDocumentsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param moiDeleteDocuments the moi delete documents
	 * @return the moi delete documents that was updated
	 */
	@Override
	public com.moi.dms.delete.documents.model.MOIDeleteDocuments
		updateMOIDeleteDocuments(
			com.moi.dms.delete.documents.model.MOIDeleteDocuments
				moiDeleteDocuments) {

		return _moiDeleteDocumentsLocalService.updateMOIDeleteDocuments(
			moiDeleteDocuments);
	}

	@Override
	public MOIDeleteDocumentsLocalService getWrappedService() {
		return _moiDeleteDocumentsLocalService;
	}

	@Override
	public void setWrappedService(
		MOIDeleteDocumentsLocalService moiDeleteDocumentsLocalService) {

		_moiDeleteDocumentsLocalService = moiDeleteDocumentsLocalService;
	}

	private MOIDeleteDocumentsLocalService _moiDeleteDocumentsLocalService;

}