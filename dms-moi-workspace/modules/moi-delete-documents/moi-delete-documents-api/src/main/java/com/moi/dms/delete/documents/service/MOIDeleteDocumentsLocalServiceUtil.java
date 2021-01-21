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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for MOIDeleteDocuments. This utility wraps
 * <code>com.moi.dms.delete.documents.service.impl.MOIDeleteDocumentsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MOIDeleteDocumentsLocalService
 * @generated
 */
public class MOIDeleteDocumentsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.moi.dms.delete.documents.service.impl.MOIDeleteDocumentsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static com.moi.dms.delete.documents.model.MOIDeleteDocuments
		addMOIDeleteDocuments(
			long fileEntryId, String fileEntryName, String consumerCode,
			String moduleType, String uploadedBy, java.util.Date uploadedDate,
			String status, String comments, String updatedBy,
			java.util.Date updatedDate, String pendingIdentifiers) {

		return getService().addMOIDeleteDocuments(
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
	public static com.moi.dms.delete.documents.model.MOIDeleteDocuments
		addMOIDeleteDocuments(
			com.moi.dms.delete.documents.model.MOIDeleteDocuments
				moiDeleteDocuments) {

		return getService().addMOIDeleteDocuments(moiDeleteDocuments);
	}

	/**
	 * Creates a new moi delete documents with the primary key. Does not add the moi delete documents to the database.
	 *
	 * @param documentId the primary key for the new moi delete documents
	 * @return the new moi delete documents
	 */
	public static com.moi.dms.delete.documents.model.MOIDeleteDocuments
		createMOIDeleteDocuments(long documentId) {

		return getService().createMOIDeleteDocuments(documentId);
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
	public static com.moi.dms.delete.documents.model.MOIDeleteDocuments
			deleteMOIDeleteDocuments(long documentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteMOIDeleteDocuments(documentId);
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
	public static com.moi.dms.delete.documents.model.MOIDeleteDocuments
		deleteMOIDeleteDocuments(
			com.moi.dms.delete.documents.model.MOIDeleteDocuments
				moiDeleteDocuments) {

		return getService().deleteMOIDeleteDocuments(moiDeleteDocuments);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.moi.dms.delete.documents.model.MOIDeleteDocuments
		fetchMOIDeleteDocuments(long documentId) {

		return getService().fetchMOIDeleteDocuments(documentId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Finder method for all MOIDeleteDocuments.
	 *
	 * @return List<MOIDeleteDocuments>
	 */
	public static java.util.List
		<com.moi.dms.delete.documents.model.MOIDeleteDocuments>
			getAllDeleteDocuments() {

		return getService().getAllDeleteDocuments();
	}

	/**
	 * Finder method for MOIDeleteDocuments.
	 *
	 * @param documentId
	 * @return List<MOIDeleteDocuments>
	 */
	public static java.util.List
		<com.moi.dms.delete.documents.model.MOIDeleteDocuments>
			getDeleteDocumentsByDocumentId(Long documentId) {

		return getService().getDeleteDocumentsByDocumentId(documentId);
	}

	/**
	 * Finder method for MOIDeleteDocuments.
	 *
	 * @param documentId
	 * @param start
	 * @param end
	 * @return List<MOIDeleteDocuments>
	 */
	public static java.util.List
		<com.moi.dms.delete.documents.model.MOIDeleteDocuments>
			getDeleteDocumentsByDocumentId(
				Long documentId, int start, int end) {

		return getService().getDeleteDocumentsByDocumentId(
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
	public static java.util.List
		<com.moi.dms.delete.documents.model.MOIDeleteDocuments>
			getDeleteDocumentsByKeywords(
				String keywords, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.moi.dms.delete.documents.model.MOIDeleteDocuments>
						orderByComparator) {

		return getService().getDeleteDocumentsByKeywords(
			keywords, start, end, orderByComparator);
	}

	/**
	 * Finder method for MOIDeleteDocuments.
	 *
	 * @param status
	 * @return List<MOIDeleteDocuments>
	 */
	public static java.util.List
		<com.moi.dms.delete.documents.model.MOIDeleteDocuments>
			getDeleteDocumentsByStatus(java.util.List<String> multipleStatus) {

		return getService().getDeleteDocumentsByStatus(multipleStatus);
	}

	/**
	 * Finder method for MOIDeleteDocuments.
	 *
	 * @param status
	 * @return List<MOIDeleteDocuments>
	 */
	public static java.util.List
		<com.moi.dms.delete.documents.model.MOIDeleteDocuments>
			getDeleteDocumentsByStatus(String status) {

		return getService().getDeleteDocumentsByStatus(status);
	}

	/**
	 * Returns the MOIDeleteDocuments count with keywords.
	 *
	 * @param keywords
	 * @return long
	 */
	public static long getDeleteDocumentsCountByKeywords(String keywords) {
		return getService().getDeleteDocumentsCountByKeywords(keywords);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the moi delete documents with the primary key.
	 *
	 * @param documentId the primary key of the moi delete documents
	 * @return the moi delete documents
	 * @throws PortalException if a moi delete documents with the primary key could not be found
	 */
	public static com.moi.dms.delete.documents.model.MOIDeleteDocuments
			getMOIDeleteDocuments(long documentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getMOIDeleteDocuments(documentId);
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
	public static java.util.List
		<com.moi.dms.delete.documents.model.MOIDeleteDocuments>
			getMOIDeleteDocumentses(int start, int end) {

		return getService().getMOIDeleteDocumentses(start, end);
	}

	/**
	 * Returns the number of moi delete documentses.
	 *
	 * @return the number of moi delete documentses
	 */
	public static int getMOIDeleteDocumentsesCount() {
		return getService().getMOIDeleteDocumentsesCount();
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
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
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
	public static com.moi.dms.delete.documents.model.MOIDeleteDocuments
			updateMOIDeleteDocuments(
				long documentId, long fileEntryId, String fileEntryName,
				String consumerCode, String moduleType, String uploadedBy,
				java.util.Date uploadedDate, String status, String comments,
				String updatedBy, java.util.Date updatedDate,
				String pendingIdentifiers)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateMOIDeleteDocuments(
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
	public static com.moi.dms.delete.documents.model.MOIDeleteDocuments
		updateMOIDeleteDocuments(
			com.moi.dms.delete.documents.model.MOIDeleteDocuments
				moiDeleteDocuments) {

		return getService().updateMOIDeleteDocuments(moiDeleteDocuments);
	}

	public static MOIDeleteDocumentsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<MOIDeleteDocumentsLocalService, MOIDeleteDocumentsLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			MOIDeleteDocumentsLocalService.class);

		ServiceTracker
			<MOIDeleteDocumentsLocalService, MOIDeleteDocumentsLocalService>
				serviceTracker =
					new ServiceTracker
						<MOIDeleteDocumentsLocalService,
						 MOIDeleteDocumentsLocalService>(
							 bundle.getBundleContext(),
							 MOIDeleteDocumentsLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}