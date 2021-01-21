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

import com.moi.dms.delete.documents.model.MOIDeleteDocuments;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for MOIDeleteDocuments. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see MOIDeleteDocumentsLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface MOIDeleteDocumentsLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.moi.dms.delete.documents.service.impl.MOIDeleteDocumentsLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the moi delete documents local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link MOIDeleteDocumentsLocalServiceUtil} if injection and service tracking are not available.
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
	public MOIDeleteDocuments addMOIDeleteDocuments(
		long fileEntryId, String fileEntryName, String consumerCode,
		String moduleType, String uploadedBy, Date uploadedDate, String status,
		String comments, String updatedBy, Date updatedDate,
		String pendingIdentifiers);

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
	@Indexable(type = IndexableType.REINDEX)
	public MOIDeleteDocuments addMOIDeleteDocuments(
		MOIDeleteDocuments moiDeleteDocuments);

	/**
	 * Creates a new moi delete documents with the primary key. Does not add the moi delete documents to the database.
	 *
	 * @param documentId the primary key for the new moi delete documents
	 * @return the new moi delete documents
	 */
	@Transactional(enabled = false)
	public MOIDeleteDocuments createMOIDeleteDocuments(long documentId);

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
	@Indexable(type = IndexableType.DELETE)
	public MOIDeleteDocuments deleteMOIDeleteDocuments(long documentId)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public MOIDeleteDocuments deleteMOIDeleteDocuments(
		MOIDeleteDocuments moiDeleteDocuments);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.moi.dms.delete.documents.model.impl.MOIDeleteDocumentsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.moi.dms.delete.documents.model.impl.MOIDeleteDocumentsModelImpl</code>.
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
	public MOIDeleteDocuments fetchMOIDeleteDocuments(long documentId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Finder method for all MOIDeleteDocuments.
	 *
	 * @return List<MOIDeleteDocuments>
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MOIDeleteDocuments> getAllDeleteDocuments();

	/**
	 * Finder method for MOIDeleteDocuments.
	 *
	 * @param documentId
	 * @return List<MOIDeleteDocuments>
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MOIDeleteDocuments> getDeleteDocumentsByDocumentId(
		Long documentId);

	/**
	 * Finder method for MOIDeleteDocuments.
	 *
	 * @param documentId
	 * @param start
	 * @param end
	 * @return List<MOIDeleteDocuments>
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MOIDeleteDocuments> getDeleteDocumentsByDocumentId(
		Long documentId, int start, int end);

	/**
	 * Returns the MOIDeleteDocuments with keywords.
	 *
	 * @param keywords
	 * @param start
	 * @param end
	 * @param orderByComparator
	 * @return List<MOIDeleteDocuments>
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MOIDeleteDocuments> getDeleteDocumentsByKeywords(
		String keywords, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator);

	/**
	 * Finder method for MOIDeleteDocuments.
	 *
	 * @param status
	 * @return List<MOIDeleteDocuments>
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MOIDeleteDocuments> getDeleteDocumentsByStatus(
		List<String> multipleStatus);

	/**
	 * Finder method for MOIDeleteDocuments.
	 *
	 * @param status
	 * @return List<MOIDeleteDocuments>
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MOIDeleteDocuments> getDeleteDocumentsByStatus(String status);

	/**
	 * Returns the MOIDeleteDocuments count with keywords.
	 *
	 * @param keywords
	 * @return long
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getDeleteDocumentsCountByKeywords(String keywords);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the moi delete documents with the primary key.
	 *
	 * @param documentId the primary key of the moi delete documents
	 * @return the moi delete documents
	 * @throws PortalException if a moi delete documents with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MOIDeleteDocuments getMOIDeleteDocuments(long documentId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MOIDeleteDocuments> getMOIDeleteDocumentses(int start, int end);

	/**
	 * Returns the number of moi delete documentses.
	 *
	 * @return the number of moi delete documentses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMOIDeleteDocumentsesCount();

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
	public MOIDeleteDocuments updateMOIDeleteDocuments(
			long documentId, long fileEntryId, String fileEntryName,
			String consumerCode, String moduleType, String uploadedBy,
			Date uploadedDate, String status, String comments, String updatedBy,
			Date updatedDate, String pendingIdentifiers)
		throws PortalException;

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
	@Indexable(type = IndexableType.REINDEX)
	public MOIDeleteDocuments updateMOIDeleteDocuments(
		MOIDeleteDocuments moiDeleteDocuments);

}