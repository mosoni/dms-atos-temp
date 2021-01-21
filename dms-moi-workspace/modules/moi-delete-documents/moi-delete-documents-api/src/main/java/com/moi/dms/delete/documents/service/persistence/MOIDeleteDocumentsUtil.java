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

package com.moi.dms.delete.documents.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.moi.dms.delete.documents.model.MOIDeleteDocuments;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the moi delete documents service. This utility wraps <code>com.moi.dms.delete.documents.service.persistence.impl.MOIDeleteDocumentsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MOIDeleteDocumentsPersistence
 * @generated
 */
public class MOIDeleteDocumentsUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(MOIDeleteDocuments moiDeleteDocuments) {
		getPersistence().clearCache(moiDeleteDocuments);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, MOIDeleteDocuments> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MOIDeleteDocuments> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MOIDeleteDocuments> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MOIDeleteDocuments> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MOIDeleteDocuments update(
		MOIDeleteDocuments moiDeleteDocuments) {

		return getPersistence().update(moiDeleteDocuments);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MOIDeleteDocuments update(
		MOIDeleteDocuments moiDeleteDocuments, ServiceContext serviceContext) {

		return getPersistence().update(moiDeleteDocuments, serviceContext);
	}

	/**
	 * Returns all the moi delete documentses where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @return the matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByDocumentId(long documentId) {
		return getPersistence().findByDocumentId(documentId);
	}

	/**
	 * Returns a range of all the moi delete documentses where documentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param documentId the document ID
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @return the range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByDocumentId(
		long documentId, int start, int end) {

		return getPersistence().findByDocumentId(documentId, start, end);
	}

	/**
	 * Returns an ordered range of all the moi delete documentses where documentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param documentId the document ID
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByDocumentId(
		long documentId, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().findByDocumentId(
			documentId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the moi delete documentses where documentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param documentId the document ID
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByDocumentId(
		long documentId, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDocumentId(
			documentId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first moi delete documents in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments findByDocumentId_First(
			long documentId,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByDocumentId_First(
			documentId, orderByComparator);
	}

	/**
	 * Returns the first moi delete documents in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments fetchByDocumentId_First(
		long documentId,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().fetchByDocumentId_First(
			documentId, orderByComparator);
	}

	/**
	 * Returns the last moi delete documents in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments findByDocumentId_Last(
			long documentId,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByDocumentId_Last(
			documentId, orderByComparator);
	}

	/**
	 * Returns the last moi delete documents in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments fetchByDocumentId_Last(
		long documentId,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().fetchByDocumentId_Last(
			documentId, orderByComparator);
	}

	/**
	 * Removes all the moi delete documentses where documentId = &#63; from the database.
	 *
	 * @param documentId the document ID
	 */
	public static void removeByDocumentId(long documentId) {
		getPersistence().removeByDocumentId(documentId);
	}

	/**
	 * Returns the number of moi delete documentses where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @return the number of matching moi delete documentses
	 */
	public static int countByDocumentId(long documentId) {
		return getPersistence().countByDocumentId(documentId);
	}

	/**
	 * Returns all the moi delete documentses where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @return the matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByFileEntryId(long fileEntryId) {
		return getPersistence().findByFileEntryId(fileEntryId);
	}

	/**
	 * Returns a range of all the moi delete documentses where fileEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param fileEntryId the file entry ID
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @return the range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByFileEntryId(
		long fileEntryId, int start, int end) {

		return getPersistence().findByFileEntryId(fileEntryId, start, end);
	}

	/**
	 * Returns an ordered range of all the moi delete documentses where fileEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param fileEntryId the file entry ID
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByFileEntryId(
		long fileEntryId, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().findByFileEntryId(
			fileEntryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the moi delete documentses where fileEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param fileEntryId the file entry ID
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByFileEntryId(
		long fileEntryId, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFileEntryId(
			fileEntryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first moi delete documents in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments findByFileEntryId_First(
			long fileEntryId,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByFileEntryId_First(
			fileEntryId, orderByComparator);
	}

	/**
	 * Returns the first moi delete documents in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments fetchByFileEntryId_First(
		long fileEntryId,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().fetchByFileEntryId_First(
			fileEntryId, orderByComparator);
	}

	/**
	 * Returns the last moi delete documents in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments findByFileEntryId_Last(
			long fileEntryId,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByFileEntryId_Last(
			fileEntryId, orderByComparator);
	}

	/**
	 * Returns the last moi delete documents in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments fetchByFileEntryId_Last(
		long fileEntryId,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().fetchByFileEntryId_Last(
			fileEntryId, orderByComparator);
	}

	/**
	 * Returns the moi delete documentses before and after the current moi delete documents in the ordered set where fileEntryId = &#63;.
	 *
	 * @param documentId the primary key of the current moi delete documents
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a moi delete documents with the primary key could not be found
	 */
	public static MOIDeleteDocuments[] findByFileEntryId_PrevAndNext(
			long documentId, long fileEntryId,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByFileEntryId_PrevAndNext(
			documentId, fileEntryId, orderByComparator);
	}

	/**
	 * Removes all the moi delete documentses where fileEntryId = &#63; from the database.
	 *
	 * @param fileEntryId the file entry ID
	 */
	public static void removeByFileEntryId(long fileEntryId) {
		getPersistence().removeByFileEntryId(fileEntryId);
	}

	/**
	 * Returns the number of moi delete documentses where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @return the number of matching moi delete documentses
	 */
	public static int countByFileEntryId(long fileEntryId) {
		return getPersistence().countByFileEntryId(fileEntryId);
	}

	/**
	 * Returns all the moi delete documentses where fileEntryName = &#63;.
	 *
	 * @param fileEntryName the file entry name
	 * @return the matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByFileEntryName(
		String fileEntryName) {

		return getPersistence().findByFileEntryName(fileEntryName);
	}

	/**
	 * Returns a range of all the moi delete documentses where fileEntryName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param fileEntryName the file entry name
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @return the range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByFileEntryName(
		String fileEntryName, int start, int end) {

		return getPersistence().findByFileEntryName(fileEntryName, start, end);
	}

	/**
	 * Returns an ordered range of all the moi delete documentses where fileEntryName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param fileEntryName the file entry name
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByFileEntryName(
		String fileEntryName, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().findByFileEntryName(
			fileEntryName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the moi delete documentses where fileEntryName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param fileEntryName the file entry name
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByFileEntryName(
		String fileEntryName, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFileEntryName(
			fileEntryName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first moi delete documents in the ordered set where fileEntryName = &#63;.
	 *
	 * @param fileEntryName the file entry name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments findByFileEntryName_First(
			String fileEntryName,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByFileEntryName_First(
			fileEntryName, orderByComparator);
	}

	/**
	 * Returns the first moi delete documents in the ordered set where fileEntryName = &#63;.
	 *
	 * @param fileEntryName the file entry name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments fetchByFileEntryName_First(
		String fileEntryName,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().fetchByFileEntryName_First(
			fileEntryName, orderByComparator);
	}

	/**
	 * Returns the last moi delete documents in the ordered set where fileEntryName = &#63;.
	 *
	 * @param fileEntryName the file entry name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments findByFileEntryName_Last(
			String fileEntryName,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByFileEntryName_Last(
			fileEntryName, orderByComparator);
	}

	/**
	 * Returns the last moi delete documents in the ordered set where fileEntryName = &#63;.
	 *
	 * @param fileEntryName the file entry name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments fetchByFileEntryName_Last(
		String fileEntryName,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().fetchByFileEntryName_Last(
			fileEntryName, orderByComparator);
	}

	/**
	 * Returns the moi delete documentses before and after the current moi delete documents in the ordered set where fileEntryName = &#63;.
	 *
	 * @param documentId the primary key of the current moi delete documents
	 * @param fileEntryName the file entry name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a moi delete documents with the primary key could not be found
	 */
	public static MOIDeleteDocuments[] findByFileEntryName_PrevAndNext(
			long documentId, String fileEntryName,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByFileEntryName_PrevAndNext(
			documentId, fileEntryName, orderByComparator);
	}

	/**
	 * Removes all the moi delete documentses where fileEntryName = &#63; from the database.
	 *
	 * @param fileEntryName the file entry name
	 */
	public static void removeByFileEntryName(String fileEntryName) {
		getPersistence().removeByFileEntryName(fileEntryName);
	}

	/**
	 * Returns the number of moi delete documentses where fileEntryName = &#63;.
	 *
	 * @param fileEntryName the file entry name
	 * @return the number of matching moi delete documentses
	 */
	public static int countByFileEntryName(String fileEntryName) {
		return getPersistence().countByFileEntryName(fileEntryName);
	}

	/**
	 * Returns all the moi delete documentses where consumerCode = &#63;.
	 *
	 * @param consumerCode the consumer code
	 * @return the matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByConsumerCode(
		String consumerCode) {

		return getPersistence().findByConsumerCode(consumerCode);
	}

	/**
	 * Returns a range of all the moi delete documentses where consumerCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param consumerCode the consumer code
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @return the range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByConsumerCode(
		String consumerCode, int start, int end) {

		return getPersistence().findByConsumerCode(consumerCode, start, end);
	}

	/**
	 * Returns an ordered range of all the moi delete documentses where consumerCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param consumerCode the consumer code
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByConsumerCode(
		String consumerCode, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().findByConsumerCode(
			consumerCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the moi delete documentses where consumerCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param consumerCode the consumer code
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByConsumerCode(
		String consumerCode, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByConsumerCode(
			consumerCode, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first moi delete documents in the ordered set where consumerCode = &#63;.
	 *
	 * @param consumerCode the consumer code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments findByConsumerCode_First(
			String consumerCode,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByConsumerCode_First(
			consumerCode, orderByComparator);
	}

	/**
	 * Returns the first moi delete documents in the ordered set where consumerCode = &#63;.
	 *
	 * @param consumerCode the consumer code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments fetchByConsumerCode_First(
		String consumerCode,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().fetchByConsumerCode_First(
			consumerCode, orderByComparator);
	}

	/**
	 * Returns the last moi delete documents in the ordered set where consumerCode = &#63;.
	 *
	 * @param consumerCode the consumer code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments findByConsumerCode_Last(
			String consumerCode,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByConsumerCode_Last(
			consumerCode, orderByComparator);
	}

	/**
	 * Returns the last moi delete documents in the ordered set where consumerCode = &#63;.
	 *
	 * @param consumerCode the consumer code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments fetchByConsumerCode_Last(
		String consumerCode,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().fetchByConsumerCode_Last(
			consumerCode, orderByComparator);
	}

	/**
	 * Returns the moi delete documentses before and after the current moi delete documents in the ordered set where consumerCode = &#63;.
	 *
	 * @param documentId the primary key of the current moi delete documents
	 * @param consumerCode the consumer code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a moi delete documents with the primary key could not be found
	 */
	public static MOIDeleteDocuments[] findByConsumerCode_PrevAndNext(
			long documentId, String consumerCode,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByConsumerCode_PrevAndNext(
			documentId, consumerCode, orderByComparator);
	}

	/**
	 * Removes all the moi delete documentses where consumerCode = &#63; from the database.
	 *
	 * @param consumerCode the consumer code
	 */
	public static void removeByConsumerCode(String consumerCode) {
		getPersistence().removeByConsumerCode(consumerCode);
	}

	/**
	 * Returns the number of moi delete documentses where consumerCode = &#63;.
	 *
	 * @param consumerCode the consumer code
	 * @return the number of matching moi delete documentses
	 */
	public static int countByConsumerCode(String consumerCode) {
		return getPersistence().countByConsumerCode(consumerCode);
	}

	/**
	 * Returns all the moi delete documentses where moduleType = &#63;.
	 *
	 * @param moduleType the module type
	 * @return the matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByModuleType(String moduleType) {
		return getPersistence().findByModuleType(moduleType);
	}

	/**
	 * Returns a range of all the moi delete documentses where moduleType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param moduleType the module type
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @return the range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByModuleType(
		String moduleType, int start, int end) {

		return getPersistence().findByModuleType(moduleType, start, end);
	}

	/**
	 * Returns an ordered range of all the moi delete documentses where moduleType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param moduleType the module type
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByModuleType(
		String moduleType, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().findByModuleType(
			moduleType, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the moi delete documentses where moduleType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param moduleType the module type
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByModuleType(
		String moduleType, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByModuleType(
			moduleType, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first moi delete documents in the ordered set where moduleType = &#63;.
	 *
	 * @param moduleType the module type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments findByModuleType_First(
			String moduleType,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByModuleType_First(
			moduleType, orderByComparator);
	}

	/**
	 * Returns the first moi delete documents in the ordered set where moduleType = &#63;.
	 *
	 * @param moduleType the module type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments fetchByModuleType_First(
		String moduleType,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().fetchByModuleType_First(
			moduleType, orderByComparator);
	}

	/**
	 * Returns the last moi delete documents in the ordered set where moduleType = &#63;.
	 *
	 * @param moduleType the module type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments findByModuleType_Last(
			String moduleType,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByModuleType_Last(
			moduleType, orderByComparator);
	}

	/**
	 * Returns the last moi delete documents in the ordered set where moduleType = &#63;.
	 *
	 * @param moduleType the module type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments fetchByModuleType_Last(
		String moduleType,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().fetchByModuleType_Last(
			moduleType, orderByComparator);
	}

	/**
	 * Returns the moi delete documentses before and after the current moi delete documents in the ordered set where moduleType = &#63;.
	 *
	 * @param documentId the primary key of the current moi delete documents
	 * @param moduleType the module type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a moi delete documents with the primary key could not be found
	 */
	public static MOIDeleteDocuments[] findByModuleType_PrevAndNext(
			long documentId, String moduleType,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByModuleType_PrevAndNext(
			documentId, moduleType, orderByComparator);
	}

	/**
	 * Removes all the moi delete documentses where moduleType = &#63; from the database.
	 *
	 * @param moduleType the module type
	 */
	public static void removeByModuleType(String moduleType) {
		getPersistence().removeByModuleType(moduleType);
	}

	/**
	 * Returns the number of moi delete documentses where moduleType = &#63;.
	 *
	 * @param moduleType the module type
	 * @return the number of matching moi delete documentses
	 */
	public static int countByModuleType(String moduleType) {
		return getPersistence().countByModuleType(moduleType);
	}

	/**
	 * Returns all the moi delete documentses where uploadedBy = &#63;.
	 *
	 * @param uploadedBy the uploaded by
	 * @return the matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByUploadedBy(String uploadedBy) {
		return getPersistence().findByUploadedBy(uploadedBy);
	}

	/**
	 * Returns a range of all the moi delete documentses where uploadedBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param uploadedBy the uploaded by
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @return the range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByUploadedBy(
		String uploadedBy, int start, int end) {

		return getPersistence().findByUploadedBy(uploadedBy, start, end);
	}

	/**
	 * Returns an ordered range of all the moi delete documentses where uploadedBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param uploadedBy the uploaded by
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByUploadedBy(
		String uploadedBy, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().findByUploadedBy(
			uploadedBy, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the moi delete documentses where uploadedBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param uploadedBy the uploaded by
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByUploadedBy(
		String uploadedBy, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUploadedBy(
			uploadedBy, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first moi delete documents in the ordered set where uploadedBy = &#63;.
	 *
	 * @param uploadedBy the uploaded by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments findByUploadedBy_First(
			String uploadedBy,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByUploadedBy_First(
			uploadedBy, orderByComparator);
	}

	/**
	 * Returns the first moi delete documents in the ordered set where uploadedBy = &#63;.
	 *
	 * @param uploadedBy the uploaded by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments fetchByUploadedBy_First(
		String uploadedBy,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().fetchByUploadedBy_First(
			uploadedBy, orderByComparator);
	}

	/**
	 * Returns the last moi delete documents in the ordered set where uploadedBy = &#63;.
	 *
	 * @param uploadedBy the uploaded by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments findByUploadedBy_Last(
			String uploadedBy,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByUploadedBy_Last(
			uploadedBy, orderByComparator);
	}

	/**
	 * Returns the last moi delete documents in the ordered set where uploadedBy = &#63;.
	 *
	 * @param uploadedBy the uploaded by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments fetchByUploadedBy_Last(
		String uploadedBy,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().fetchByUploadedBy_Last(
			uploadedBy, orderByComparator);
	}

	/**
	 * Returns the moi delete documentses before and after the current moi delete documents in the ordered set where uploadedBy = &#63;.
	 *
	 * @param documentId the primary key of the current moi delete documents
	 * @param uploadedBy the uploaded by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a moi delete documents with the primary key could not be found
	 */
	public static MOIDeleteDocuments[] findByUploadedBy_PrevAndNext(
			long documentId, String uploadedBy,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByUploadedBy_PrevAndNext(
			documentId, uploadedBy, orderByComparator);
	}

	/**
	 * Removes all the moi delete documentses where uploadedBy = &#63; from the database.
	 *
	 * @param uploadedBy the uploaded by
	 */
	public static void removeByUploadedBy(String uploadedBy) {
		getPersistence().removeByUploadedBy(uploadedBy);
	}

	/**
	 * Returns the number of moi delete documentses where uploadedBy = &#63;.
	 *
	 * @param uploadedBy the uploaded by
	 * @return the number of matching moi delete documentses
	 */
	public static int countByUploadedBy(String uploadedBy) {
		return getPersistence().countByUploadedBy(uploadedBy);
	}

	/**
	 * Returns all the moi delete documentses where uploadedDate = &#63;.
	 *
	 * @param uploadedDate the uploaded date
	 * @return the matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByUploadedDate(
		Date uploadedDate) {

		return getPersistence().findByUploadedDate(uploadedDate);
	}

	/**
	 * Returns a range of all the moi delete documentses where uploadedDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param uploadedDate the uploaded date
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @return the range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByUploadedDate(
		Date uploadedDate, int start, int end) {

		return getPersistence().findByUploadedDate(uploadedDate, start, end);
	}

	/**
	 * Returns an ordered range of all the moi delete documentses where uploadedDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param uploadedDate the uploaded date
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByUploadedDate(
		Date uploadedDate, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().findByUploadedDate(
			uploadedDate, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the moi delete documentses where uploadedDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param uploadedDate the uploaded date
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByUploadedDate(
		Date uploadedDate, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUploadedDate(
			uploadedDate, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first moi delete documents in the ordered set where uploadedDate = &#63;.
	 *
	 * @param uploadedDate the uploaded date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments findByUploadedDate_First(
			Date uploadedDate,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByUploadedDate_First(
			uploadedDate, orderByComparator);
	}

	/**
	 * Returns the first moi delete documents in the ordered set where uploadedDate = &#63;.
	 *
	 * @param uploadedDate the uploaded date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments fetchByUploadedDate_First(
		Date uploadedDate,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().fetchByUploadedDate_First(
			uploadedDate, orderByComparator);
	}

	/**
	 * Returns the last moi delete documents in the ordered set where uploadedDate = &#63;.
	 *
	 * @param uploadedDate the uploaded date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments findByUploadedDate_Last(
			Date uploadedDate,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByUploadedDate_Last(
			uploadedDate, orderByComparator);
	}

	/**
	 * Returns the last moi delete documents in the ordered set where uploadedDate = &#63;.
	 *
	 * @param uploadedDate the uploaded date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments fetchByUploadedDate_Last(
		Date uploadedDate,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().fetchByUploadedDate_Last(
			uploadedDate, orderByComparator);
	}

	/**
	 * Returns the moi delete documentses before and after the current moi delete documents in the ordered set where uploadedDate = &#63;.
	 *
	 * @param documentId the primary key of the current moi delete documents
	 * @param uploadedDate the uploaded date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a moi delete documents with the primary key could not be found
	 */
	public static MOIDeleteDocuments[] findByUploadedDate_PrevAndNext(
			long documentId, Date uploadedDate,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByUploadedDate_PrevAndNext(
			documentId, uploadedDate, orderByComparator);
	}

	/**
	 * Removes all the moi delete documentses where uploadedDate = &#63; from the database.
	 *
	 * @param uploadedDate the uploaded date
	 */
	public static void removeByUploadedDate(Date uploadedDate) {
		getPersistence().removeByUploadedDate(uploadedDate);
	}

	/**
	 * Returns the number of moi delete documentses where uploadedDate = &#63;.
	 *
	 * @param uploadedDate the uploaded date
	 * @return the number of matching moi delete documentses
	 */
	public static int countByUploadedDate(Date uploadedDate) {
		return getPersistence().countByUploadedDate(uploadedDate);
	}

	/**
	 * Returns all the moi delete documentses where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByStatus(String status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the moi delete documentses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @return the range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByStatus(
		String status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the moi delete documentses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByStatus(
		String status, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the moi delete documentses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByStatus(
		String status, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first moi delete documents in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments findByStatus_First(
			String status,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first moi delete documents in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments fetchByStatus_First(
		String status,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last moi delete documents in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments findByStatus_Last(
			String status,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last moi delete documents in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments fetchByStatus_Last(
		String status,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the moi delete documentses before and after the current moi delete documents in the ordered set where status = &#63;.
	 *
	 * @param documentId the primary key of the current moi delete documents
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a moi delete documents with the primary key could not be found
	 */
	public static MOIDeleteDocuments[] findByStatus_PrevAndNext(
			long documentId, String status,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByStatus_PrevAndNext(
			documentId, status, orderByComparator);
	}

	/**
	 * Removes all the moi delete documentses where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(String status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of moi delete documentses where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching moi delete documentses
	 */
	public static int countByStatus(String status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the moi delete documentses where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @return the matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByUpdatedBy(String updatedBy) {
		return getPersistence().findByUpdatedBy(updatedBy);
	}

	/**
	 * Returns a range of all the moi delete documentses where updatedBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param updatedBy the updated by
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @return the range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByUpdatedBy(
		String updatedBy, int start, int end) {

		return getPersistence().findByUpdatedBy(updatedBy, start, end);
	}

	/**
	 * Returns an ordered range of all the moi delete documentses where updatedBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param updatedBy the updated by
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByUpdatedBy(
		String updatedBy, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().findByUpdatedBy(
			updatedBy, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the moi delete documentses where updatedBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param updatedBy the updated by
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByUpdatedBy(
		String updatedBy, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUpdatedBy(
			updatedBy, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first moi delete documents in the ordered set where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments findByUpdatedBy_First(
			String updatedBy,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByUpdatedBy_First(
			updatedBy, orderByComparator);
	}

	/**
	 * Returns the first moi delete documents in the ordered set where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments fetchByUpdatedBy_First(
		String updatedBy,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().fetchByUpdatedBy_First(
			updatedBy, orderByComparator);
	}

	/**
	 * Returns the last moi delete documents in the ordered set where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments findByUpdatedBy_Last(
			String updatedBy,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByUpdatedBy_Last(
			updatedBy, orderByComparator);
	}

	/**
	 * Returns the last moi delete documents in the ordered set where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments fetchByUpdatedBy_Last(
		String updatedBy,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().fetchByUpdatedBy_Last(
			updatedBy, orderByComparator);
	}

	/**
	 * Returns the moi delete documentses before and after the current moi delete documents in the ordered set where updatedBy = &#63;.
	 *
	 * @param documentId the primary key of the current moi delete documents
	 * @param updatedBy the updated by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a moi delete documents with the primary key could not be found
	 */
	public static MOIDeleteDocuments[] findByUpdatedBy_PrevAndNext(
			long documentId, String updatedBy,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByUpdatedBy_PrevAndNext(
			documentId, updatedBy, orderByComparator);
	}

	/**
	 * Removes all the moi delete documentses where updatedBy = &#63; from the database.
	 *
	 * @param updatedBy the updated by
	 */
	public static void removeByUpdatedBy(String updatedBy) {
		getPersistence().removeByUpdatedBy(updatedBy);
	}

	/**
	 * Returns the number of moi delete documentses where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @return the number of matching moi delete documentses
	 */
	public static int countByUpdatedBy(String updatedBy) {
		return getPersistence().countByUpdatedBy(updatedBy);
	}

	/**
	 * Returns all the moi delete documentses where updatedDate = &#63;.
	 *
	 * @param updatedDate the updated date
	 * @return the matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByUpdatedDate(Date updatedDate) {
		return getPersistence().findByUpdatedDate(updatedDate);
	}

	/**
	 * Returns a range of all the moi delete documentses where updatedDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param updatedDate the updated date
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @return the range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByUpdatedDate(
		Date updatedDate, int start, int end) {

		return getPersistence().findByUpdatedDate(updatedDate, start, end);
	}

	/**
	 * Returns an ordered range of all the moi delete documentses where updatedDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param updatedDate the updated date
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByUpdatedDate(
		Date updatedDate, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().findByUpdatedDate(
			updatedDate, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the moi delete documentses where updatedDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param updatedDate the updated date
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByUpdatedDate(
		Date updatedDate, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUpdatedDate(
			updatedDate, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first moi delete documents in the ordered set where updatedDate = &#63;.
	 *
	 * @param updatedDate the updated date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments findByUpdatedDate_First(
			Date updatedDate,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByUpdatedDate_First(
			updatedDate, orderByComparator);
	}

	/**
	 * Returns the first moi delete documents in the ordered set where updatedDate = &#63;.
	 *
	 * @param updatedDate the updated date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments fetchByUpdatedDate_First(
		Date updatedDate,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().fetchByUpdatedDate_First(
			updatedDate, orderByComparator);
	}

	/**
	 * Returns the last moi delete documents in the ordered set where updatedDate = &#63;.
	 *
	 * @param updatedDate the updated date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments findByUpdatedDate_Last(
			Date updatedDate,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByUpdatedDate_Last(
			updatedDate, orderByComparator);
	}

	/**
	 * Returns the last moi delete documents in the ordered set where updatedDate = &#63;.
	 *
	 * @param updatedDate the updated date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments fetchByUpdatedDate_Last(
		Date updatedDate,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().fetchByUpdatedDate_Last(
			updatedDate, orderByComparator);
	}

	/**
	 * Returns the moi delete documentses before and after the current moi delete documents in the ordered set where updatedDate = &#63;.
	 *
	 * @param documentId the primary key of the current moi delete documents
	 * @param updatedDate the updated date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a moi delete documents with the primary key could not be found
	 */
	public static MOIDeleteDocuments[] findByUpdatedDate_PrevAndNext(
			long documentId, Date updatedDate,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByUpdatedDate_PrevAndNext(
			documentId, updatedDate, orderByComparator);
	}

	/**
	 * Removes all the moi delete documentses where updatedDate = &#63; from the database.
	 *
	 * @param updatedDate the updated date
	 */
	public static void removeByUpdatedDate(Date updatedDate) {
		getPersistence().removeByUpdatedDate(updatedDate);
	}

	/**
	 * Returns the number of moi delete documentses where updatedDate = &#63;.
	 *
	 * @param updatedDate the updated date
	 * @return the number of matching moi delete documentses
	 */
	public static int countByUpdatedDate(Date updatedDate) {
		return getPersistence().countByUpdatedDate(updatedDate);
	}

	/**
	 * Returns all the moi delete documentses where pendingIdentifiers = &#63;.
	 *
	 * @param pendingIdentifiers the pending identifiers
	 * @return the matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByPendingIdentifiers(
		String pendingIdentifiers) {

		return getPersistence().findByPendingIdentifiers(pendingIdentifiers);
	}

	/**
	 * Returns a range of all the moi delete documentses where pendingIdentifiers = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param pendingIdentifiers the pending identifiers
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @return the range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByPendingIdentifiers(
		String pendingIdentifiers, int start, int end) {

		return getPersistence().findByPendingIdentifiers(
			pendingIdentifiers, start, end);
	}

	/**
	 * Returns an ordered range of all the moi delete documentses where pendingIdentifiers = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param pendingIdentifiers the pending identifiers
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByPendingIdentifiers(
		String pendingIdentifiers, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().findByPendingIdentifiers(
			pendingIdentifiers, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the moi delete documentses where pendingIdentifiers = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param pendingIdentifiers the pending identifiers
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findByPendingIdentifiers(
		String pendingIdentifiers, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPendingIdentifiers(
			pendingIdentifiers, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first moi delete documents in the ordered set where pendingIdentifiers = &#63;.
	 *
	 * @param pendingIdentifiers the pending identifiers
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments findByPendingIdentifiers_First(
			String pendingIdentifiers,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByPendingIdentifiers_First(
			pendingIdentifiers, orderByComparator);
	}

	/**
	 * Returns the first moi delete documents in the ordered set where pendingIdentifiers = &#63;.
	 *
	 * @param pendingIdentifiers the pending identifiers
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments fetchByPendingIdentifiers_First(
		String pendingIdentifiers,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().fetchByPendingIdentifiers_First(
			pendingIdentifiers, orderByComparator);
	}

	/**
	 * Returns the last moi delete documents in the ordered set where pendingIdentifiers = &#63;.
	 *
	 * @param pendingIdentifiers the pending identifiers
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments findByPendingIdentifiers_Last(
			String pendingIdentifiers,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByPendingIdentifiers_Last(
			pendingIdentifiers, orderByComparator);
	}

	/**
	 * Returns the last moi delete documents in the ordered set where pendingIdentifiers = &#63;.
	 *
	 * @param pendingIdentifiers the pending identifiers
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public static MOIDeleteDocuments fetchByPendingIdentifiers_Last(
		String pendingIdentifiers,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().fetchByPendingIdentifiers_Last(
			pendingIdentifiers, orderByComparator);
	}

	/**
	 * Returns the moi delete documentses before and after the current moi delete documents in the ordered set where pendingIdentifiers = &#63;.
	 *
	 * @param documentId the primary key of the current moi delete documents
	 * @param pendingIdentifiers the pending identifiers
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a moi delete documents with the primary key could not be found
	 */
	public static MOIDeleteDocuments[] findByPendingIdentifiers_PrevAndNext(
			long documentId, String pendingIdentifiers,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByPendingIdentifiers_PrevAndNext(
			documentId, pendingIdentifiers, orderByComparator);
	}

	/**
	 * Removes all the moi delete documentses where pendingIdentifiers = &#63; from the database.
	 *
	 * @param pendingIdentifiers the pending identifiers
	 */
	public static void removeByPendingIdentifiers(String pendingIdentifiers) {
		getPersistence().removeByPendingIdentifiers(pendingIdentifiers);
	}

	/**
	 * Returns the number of moi delete documentses where pendingIdentifiers = &#63;.
	 *
	 * @param pendingIdentifiers the pending identifiers
	 * @return the number of matching moi delete documentses
	 */
	public static int countByPendingIdentifiers(String pendingIdentifiers) {
		return getPersistence().countByPendingIdentifiers(pendingIdentifiers);
	}

	/**
	 * Caches the moi delete documents in the entity cache if it is enabled.
	 *
	 * @param moiDeleteDocuments the moi delete documents
	 */
	public static void cacheResult(MOIDeleteDocuments moiDeleteDocuments) {
		getPersistence().cacheResult(moiDeleteDocuments);
	}

	/**
	 * Caches the moi delete documentses in the entity cache if it is enabled.
	 *
	 * @param moiDeleteDocumentses the moi delete documentses
	 */
	public static void cacheResult(
		List<MOIDeleteDocuments> moiDeleteDocumentses) {

		getPersistence().cacheResult(moiDeleteDocumentses);
	}

	/**
	 * Creates a new moi delete documents with the primary key. Does not add the moi delete documents to the database.
	 *
	 * @param documentId the primary key for the new moi delete documents
	 * @return the new moi delete documents
	 */
	public static MOIDeleteDocuments create(long documentId) {
		return getPersistence().create(documentId);
	}

	/**
	 * Removes the moi delete documents with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentId the primary key of the moi delete documents
	 * @return the moi delete documents that was removed
	 * @throws NoSuchMOIDeleteDocumentsException if a moi delete documents with the primary key could not be found
	 */
	public static MOIDeleteDocuments remove(long documentId)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().remove(documentId);
	}

	public static MOIDeleteDocuments updateImpl(
		MOIDeleteDocuments moiDeleteDocuments) {

		return getPersistence().updateImpl(moiDeleteDocuments);
	}

	/**
	 * Returns the moi delete documents with the primary key or throws a <code>NoSuchMOIDeleteDocumentsException</code> if it could not be found.
	 *
	 * @param documentId the primary key of the moi delete documents
	 * @return the moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a moi delete documents with the primary key could not be found
	 */
	public static MOIDeleteDocuments findByPrimaryKey(long documentId)
		throws com.moi.dms.delete.documents.exception.
			NoSuchMOIDeleteDocumentsException {

		return getPersistence().findByPrimaryKey(documentId);
	}

	/**
	 * Returns the moi delete documents with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param documentId the primary key of the moi delete documents
	 * @return the moi delete documents, or <code>null</code> if a moi delete documents with the primary key could not be found
	 */
	public static MOIDeleteDocuments fetchByPrimaryKey(long documentId) {
		return getPersistence().fetchByPrimaryKey(documentId);
	}

	/**
	 * Returns all the moi delete documentses.
	 *
	 * @return the moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the moi delete documentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @return the range of moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the moi delete documentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findAll(
		int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the moi delete documentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIDeleteDocumentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of moi delete documentses
	 * @param end the upper bound of the range of moi delete documentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of moi delete documentses
	 */
	public static List<MOIDeleteDocuments> findAll(
		int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the moi delete documentses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of moi delete documentses.
	 *
	 * @return the number of moi delete documentses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MOIDeleteDocumentsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<MOIDeleteDocumentsPersistence, MOIDeleteDocumentsPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			MOIDeleteDocumentsPersistence.class);

		ServiceTracker
			<MOIDeleteDocumentsPersistence, MOIDeleteDocumentsPersistence>
				serviceTracker =
					new ServiceTracker
						<MOIDeleteDocumentsPersistence,
						 MOIDeleteDocumentsPersistence>(
							 bundle.getBundleContext(),
							 MOIDeleteDocumentsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}