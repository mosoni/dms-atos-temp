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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.moi.dms.delete.documents.exception.NoSuchMOIDeleteDocumentsException;
import com.moi.dms.delete.documents.model.MOIDeleteDocuments;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the moi delete documents service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MOIDeleteDocumentsUtil
 * @generated
 */
@ProviderType
public interface MOIDeleteDocumentsPersistence
	extends BasePersistence<MOIDeleteDocuments> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MOIDeleteDocumentsUtil} to access the moi delete documents persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the moi delete documentses where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @return the matching moi delete documentses
	 */
	public java.util.List<MOIDeleteDocuments> findByDocumentId(long documentId);

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
	public java.util.List<MOIDeleteDocuments> findByDocumentId(
		long documentId, int start, int end);

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
	public java.util.List<MOIDeleteDocuments> findByDocumentId(
		long documentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

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
	public java.util.List<MOIDeleteDocuments> findByDocumentId(
		long documentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi delete documents in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments findByDocumentId_First(
			long documentId,
			com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
				orderByComparator)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Returns the first moi delete documents in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments fetchByDocumentId_First(
		long documentId,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

	/**
	 * Returns the last moi delete documents in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments findByDocumentId_Last(
			long documentId,
			com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
				orderByComparator)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Returns the last moi delete documents in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments fetchByDocumentId_Last(
		long documentId,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

	/**
	 * Removes all the moi delete documentses where documentId = &#63; from the database.
	 *
	 * @param documentId the document ID
	 */
	public void removeByDocumentId(long documentId);

	/**
	 * Returns the number of moi delete documentses where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @return the number of matching moi delete documentses
	 */
	public int countByDocumentId(long documentId);

	/**
	 * Returns all the moi delete documentses where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @return the matching moi delete documentses
	 */
	public java.util.List<MOIDeleteDocuments> findByFileEntryId(
		long fileEntryId);

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
	public java.util.List<MOIDeleteDocuments> findByFileEntryId(
		long fileEntryId, int start, int end);

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
	public java.util.List<MOIDeleteDocuments> findByFileEntryId(
		long fileEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

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
	public java.util.List<MOIDeleteDocuments> findByFileEntryId(
		long fileEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi delete documents in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments findByFileEntryId_First(
			long fileEntryId,
			com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
				orderByComparator)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Returns the first moi delete documents in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments fetchByFileEntryId_First(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

	/**
	 * Returns the last moi delete documents in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments findByFileEntryId_Last(
			long fileEntryId,
			com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
				orderByComparator)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Returns the last moi delete documents in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments fetchByFileEntryId_Last(
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

	/**
	 * Returns the moi delete documentses before and after the current moi delete documents in the ordered set where fileEntryId = &#63;.
	 *
	 * @param documentId the primary key of the current moi delete documents
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a moi delete documents with the primary key could not be found
	 */
	public MOIDeleteDocuments[] findByFileEntryId_PrevAndNext(
			long documentId, long fileEntryId,
			com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
				orderByComparator)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Removes all the moi delete documentses where fileEntryId = &#63; from the database.
	 *
	 * @param fileEntryId the file entry ID
	 */
	public void removeByFileEntryId(long fileEntryId);

	/**
	 * Returns the number of moi delete documentses where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @return the number of matching moi delete documentses
	 */
	public int countByFileEntryId(long fileEntryId);

	/**
	 * Returns all the moi delete documentses where fileEntryName = &#63;.
	 *
	 * @param fileEntryName the file entry name
	 * @return the matching moi delete documentses
	 */
	public java.util.List<MOIDeleteDocuments> findByFileEntryName(
		String fileEntryName);

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
	public java.util.List<MOIDeleteDocuments> findByFileEntryName(
		String fileEntryName, int start, int end);

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
	public java.util.List<MOIDeleteDocuments> findByFileEntryName(
		String fileEntryName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

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
	public java.util.List<MOIDeleteDocuments> findByFileEntryName(
		String fileEntryName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi delete documents in the ordered set where fileEntryName = &#63;.
	 *
	 * @param fileEntryName the file entry name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments findByFileEntryName_First(
			String fileEntryName,
			com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
				orderByComparator)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Returns the first moi delete documents in the ordered set where fileEntryName = &#63;.
	 *
	 * @param fileEntryName the file entry name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments fetchByFileEntryName_First(
		String fileEntryName,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

	/**
	 * Returns the last moi delete documents in the ordered set where fileEntryName = &#63;.
	 *
	 * @param fileEntryName the file entry name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments findByFileEntryName_Last(
			String fileEntryName,
			com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
				orderByComparator)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Returns the last moi delete documents in the ordered set where fileEntryName = &#63;.
	 *
	 * @param fileEntryName the file entry name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments fetchByFileEntryName_Last(
		String fileEntryName,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

	/**
	 * Returns the moi delete documentses before and after the current moi delete documents in the ordered set where fileEntryName = &#63;.
	 *
	 * @param documentId the primary key of the current moi delete documents
	 * @param fileEntryName the file entry name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a moi delete documents with the primary key could not be found
	 */
	public MOIDeleteDocuments[] findByFileEntryName_PrevAndNext(
			long documentId, String fileEntryName,
			com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
				orderByComparator)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Removes all the moi delete documentses where fileEntryName = &#63; from the database.
	 *
	 * @param fileEntryName the file entry name
	 */
	public void removeByFileEntryName(String fileEntryName);

	/**
	 * Returns the number of moi delete documentses where fileEntryName = &#63;.
	 *
	 * @param fileEntryName the file entry name
	 * @return the number of matching moi delete documentses
	 */
	public int countByFileEntryName(String fileEntryName);

	/**
	 * Returns all the moi delete documentses where consumerCode = &#63;.
	 *
	 * @param consumerCode the consumer code
	 * @return the matching moi delete documentses
	 */
	public java.util.List<MOIDeleteDocuments> findByConsumerCode(
		String consumerCode);

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
	public java.util.List<MOIDeleteDocuments> findByConsumerCode(
		String consumerCode, int start, int end);

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
	public java.util.List<MOIDeleteDocuments> findByConsumerCode(
		String consumerCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

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
	public java.util.List<MOIDeleteDocuments> findByConsumerCode(
		String consumerCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi delete documents in the ordered set where consumerCode = &#63;.
	 *
	 * @param consumerCode the consumer code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments findByConsumerCode_First(
			String consumerCode,
			com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
				orderByComparator)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Returns the first moi delete documents in the ordered set where consumerCode = &#63;.
	 *
	 * @param consumerCode the consumer code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments fetchByConsumerCode_First(
		String consumerCode,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

	/**
	 * Returns the last moi delete documents in the ordered set where consumerCode = &#63;.
	 *
	 * @param consumerCode the consumer code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments findByConsumerCode_Last(
			String consumerCode,
			com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
				orderByComparator)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Returns the last moi delete documents in the ordered set where consumerCode = &#63;.
	 *
	 * @param consumerCode the consumer code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments fetchByConsumerCode_Last(
		String consumerCode,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

	/**
	 * Returns the moi delete documentses before and after the current moi delete documents in the ordered set where consumerCode = &#63;.
	 *
	 * @param documentId the primary key of the current moi delete documents
	 * @param consumerCode the consumer code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a moi delete documents with the primary key could not be found
	 */
	public MOIDeleteDocuments[] findByConsumerCode_PrevAndNext(
			long documentId, String consumerCode,
			com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
				orderByComparator)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Removes all the moi delete documentses where consumerCode = &#63; from the database.
	 *
	 * @param consumerCode the consumer code
	 */
	public void removeByConsumerCode(String consumerCode);

	/**
	 * Returns the number of moi delete documentses where consumerCode = &#63;.
	 *
	 * @param consumerCode the consumer code
	 * @return the number of matching moi delete documentses
	 */
	public int countByConsumerCode(String consumerCode);

	/**
	 * Returns all the moi delete documentses where moduleType = &#63;.
	 *
	 * @param moduleType the module type
	 * @return the matching moi delete documentses
	 */
	public java.util.List<MOIDeleteDocuments> findByModuleType(
		String moduleType);

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
	public java.util.List<MOIDeleteDocuments> findByModuleType(
		String moduleType, int start, int end);

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
	public java.util.List<MOIDeleteDocuments> findByModuleType(
		String moduleType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

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
	public java.util.List<MOIDeleteDocuments> findByModuleType(
		String moduleType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi delete documents in the ordered set where moduleType = &#63;.
	 *
	 * @param moduleType the module type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments findByModuleType_First(
			String moduleType,
			com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
				orderByComparator)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Returns the first moi delete documents in the ordered set where moduleType = &#63;.
	 *
	 * @param moduleType the module type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments fetchByModuleType_First(
		String moduleType,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

	/**
	 * Returns the last moi delete documents in the ordered set where moduleType = &#63;.
	 *
	 * @param moduleType the module type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments findByModuleType_Last(
			String moduleType,
			com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
				orderByComparator)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Returns the last moi delete documents in the ordered set where moduleType = &#63;.
	 *
	 * @param moduleType the module type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments fetchByModuleType_Last(
		String moduleType,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

	/**
	 * Returns the moi delete documentses before and after the current moi delete documents in the ordered set where moduleType = &#63;.
	 *
	 * @param documentId the primary key of the current moi delete documents
	 * @param moduleType the module type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a moi delete documents with the primary key could not be found
	 */
	public MOIDeleteDocuments[] findByModuleType_PrevAndNext(
			long documentId, String moduleType,
			com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
				orderByComparator)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Removes all the moi delete documentses where moduleType = &#63; from the database.
	 *
	 * @param moduleType the module type
	 */
	public void removeByModuleType(String moduleType);

	/**
	 * Returns the number of moi delete documentses where moduleType = &#63;.
	 *
	 * @param moduleType the module type
	 * @return the number of matching moi delete documentses
	 */
	public int countByModuleType(String moduleType);

	/**
	 * Returns all the moi delete documentses where uploadedBy = &#63;.
	 *
	 * @param uploadedBy the uploaded by
	 * @return the matching moi delete documentses
	 */
	public java.util.List<MOIDeleteDocuments> findByUploadedBy(
		String uploadedBy);

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
	public java.util.List<MOIDeleteDocuments> findByUploadedBy(
		String uploadedBy, int start, int end);

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
	public java.util.List<MOIDeleteDocuments> findByUploadedBy(
		String uploadedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

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
	public java.util.List<MOIDeleteDocuments> findByUploadedBy(
		String uploadedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi delete documents in the ordered set where uploadedBy = &#63;.
	 *
	 * @param uploadedBy the uploaded by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments findByUploadedBy_First(
			String uploadedBy,
			com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
				orderByComparator)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Returns the first moi delete documents in the ordered set where uploadedBy = &#63;.
	 *
	 * @param uploadedBy the uploaded by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments fetchByUploadedBy_First(
		String uploadedBy,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

	/**
	 * Returns the last moi delete documents in the ordered set where uploadedBy = &#63;.
	 *
	 * @param uploadedBy the uploaded by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments findByUploadedBy_Last(
			String uploadedBy,
			com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
				orderByComparator)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Returns the last moi delete documents in the ordered set where uploadedBy = &#63;.
	 *
	 * @param uploadedBy the uploaded by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments fetchByUploadedBy_Last(
		String uploadedBy,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

	/**
	 * Returns the moi delete documentses before and after the current moi delete documents in the ordered set where uploadedBy = &#63;.
	 *
	 * @param documentId the primary key of the current moi delete documents
	 * @param uploadedBy the uploaded by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a moi delete documents with the primary key could not be found
	 */
	public MOIDeleteDocuments[] findByUploadedBy_PrevAndNext(
			long documentId, String uploadedBy,
			com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
				orderByComparator)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Removes all the moi delete documentses where uploadedBy = &#63; from the database.
	 *
	 * @param uploadedBy the uploaded by
	 */
	public void removeByUploadedBy(String uploadedBy);

	/**
	 * Returns the number of moi delete documentses where uploadedBy = &#63;.
	 *
	 * @param uploadedBy the uploaded by
	 * @return the number of matching moi delete documentses
	 */
	public int countByUploadedBy(String uploadedBy);

	/**
	 * Returns all the moi delete documentses where uploadedDate = &#63;.
	 *
	 * @param uploadedDate the uploaded date
	 * @return the matching moi delete documentses
	 */
	public java.util.List<MOIDeleteDocuments> findByUploadedDate(
		Date uploadedDate);

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
	public java.util.List<MOIDeleteDocuments> findByUploadedDate(
		Date uploadedDate, int start, int end);

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
	public java.util.List<MOIDeleteDocuments> findByUploadedDate(
		Date uploadedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

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
	public java.util.List<MOIDeleteDocuments> findByUploadedDate(
		Date uploadedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi delete documents in the ordered set where uploadedDate = &#63;.
	 *
	 * @param uploadedDate the uploaded date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments findByUploadedDate_First(
			Date uploadedDate,
			com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
				orderByComparator)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Returns the first moi delete documents in the ordered set where uploadedDate = &#63;.
	 *
	 * @param uploadedDate the uploaded date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments fetchByUploadedDate_First(
		Date uploadedDate,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

	/**
	 * Returns the last moi delete documents in the ordered set where uploadedDate = &#63;.
	 *
	 * @param uploadedDate the uploaded date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments findByUploadedDate_Last(
			Date uploadedDate,
			com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
				orderByComparator)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Returns the last moi delete documents in the ordered set where uploadedDate = &#63;.
	 *
	 * @param uploadedDate the uploaded date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments fetchByUploadedDate_Last(
		Date uploadedDate,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

	/**
	 * Returns the moi delete documentses before and after the current moi delete documents in the ordered set where uploadedDate = &#63;.
	 *
	 * @param documentId the primary key of the current moi delete documents
	 * @param uploadedDate the uploaded date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a moi delete documents with the primary key could not be found
	 */
	public MOIDeleteDocuments[] findByUploadedDate_PrevAndNext(
			long documentId, Date uploadedDate,
			com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
				orderByComparator)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Removes all the moi delete documentses where uploadedDate = &#63; from the database.
	 *
	 * @param uploadedDate the uploaded date
	 */
	public void removeByUploadedDate(Date uploadedDate);

	/**
	 * Returns the number of moi delete documentses where uploadedDate = &#63;.
	 *
	 * @param uploadedDate the uploaded date
	 * @return the number of matching moi delete documentses
	 */
	public int countByUploadedDate(Date uploadedDate);

	/**
	 * Returns all the moi delete documentses where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching moi delete documentses
	 */
	public java.util.List<MOIDeleteDocuments> findByStatus(String status);

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
	public java.util.List<MOIDeleteDocuments> findByStatus(
		String status, int start, int end);

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
	public java.util.List<MOIDeleteDocuments> findByStatus(
		String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

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
	public java.util.List<MOIDeleteDocuments> findByStatus(
		String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi delete documents in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments findByStatus_First(
			String status,
			com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
				orderByComparator)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Returns the first moi delete documents in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments fetchByStatus_First(
		String status,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

	/**
	 * Returns the last moi delete documents in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments findByStatus_Last(
			String status,
			com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
				orderByComparator)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Returns the last moi delete documents in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments fetchByStatus_Last(
		String status,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

	/**
	 * Returns the moi delete documentses before and after the current moi delete documents in the ordered set where status = &#63;.
	 *
	 * @param documentId the primary key of the current moi delete documents
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a moi delete documents with the primary key could not be found
	 */
	public MOIDeleteDocuments[] findByStatus_PrevAndNext(
			long documentId, String status,
			com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
				orderByComparator)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Removes all the moi delete documentses where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(String status);

	/**
	 * Returns the number of moi delete documentses where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching moi delete documentses
	 */
	public int countByStatus(String status);

	/**
	 * Returns all the moi delete documentses where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @return the matching moi delete documentses
	 */
	public java.util.List<MOIDeleteDocuments> findByUpdatedBy(String updatedBy);

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
	public java.util.List<MOIDeleteDocuments> findByUpdatedBy(
		String updatedBy, int start, int end);

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
	public java.util.List<MOIDeleteDocuments> findByUpdatedBy(
		String updatedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

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
	public java.util.List<MOIDeleteDocuments> findByUpdatedBy(
		String updatedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi delete documents in the ordered set where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments findByUpdatedBy_First(
			String updatedBy,
			com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
				orderByComparator)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Returns the first moi delete documents in the ordered set where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments fetchByUpdatedBy_First(
		String updatedBy,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

	/**
	 * Returns the last moi delete documents in the ordered set where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments findByUpdatedBy_Last(
			String updatedBy,
			com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
				orderByComparator)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Returns the last moi delete documents in the ordered set where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments fetchByUpdatedBy_Last(
		String updatedBy,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

	/**
	 * Returns the moi delete documentses before and after the current moi delete documents in the ordered set where updatedBy = &#63;.
	 *
	 * @param documentId the primary key of the current moi delete documents
	 * @param updatedBy the updated by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a moi delete documents with the primary key could not be found
	 */
	public MOIDeleteDocuments[] findByUpdatedBy_PrevAndNext(
			long documentId, String updatedBy,
			com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
				orderByComparator)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Removes all the moi delete documentses where updatedBy = &#63; from the database.
	 *
	 * @param updatedBy the updated by
	 */
	public void removeByUpdatedBy(String updatedBy);

	/**
	 * Returns the number of moi delete documentses where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @return the number of matching moi delete documentses
	 */
	public int countByUpdatedBy(String updatedBy);

	/**
	 * Returns all the moi delete documentses where updatedDate = &#63;.
	 *
	 * @param updatedDate the updated date
	 * @return the matching moi delete documentses
	 */
	public java.util.List<MOIDeleteDocuments> findByUpdatedDate(
		Date updatedDate);

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
	public java.util.List<MOIDeleteDocuments> findByUpdatedDate(
		Date updatedDate, int start, int end);

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
	public java.util.List<MOIDeleteDocuments> findByUpdatedDate(
		Date updatedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

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
	public java.util.List<MOIDeleteDocuments> findByUpdatedDate(
		Date updatedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi delete documents in the ordered set where updatedDate = &#63;.
	 *
	 * @param updatedDate the updated date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments findByUpdatedDate_First(
			Date updatedDate,
			com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
				orderByComparator)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Returns the first moi delete documents in the ordered set where updatedDate = &#63;.
	 *
	 * @param updatedDate the updated date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments fetchByUpdatedDate_First(
		Date updatedDate,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

	/**
	 * Returns the last moi delete documents in the ordered set where updatedDate = &#63;.
	 *
	 * @param updatedDate the updated date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments findByUpdatedDate_Last(
			Date updatedDate,
			com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
				orderByComparator)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Returns the last moi delete documents in the ordered set where updatedDate = &#63;.
	 *
	 * @param updatedDate the updated date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments fetchByUpdatedDate_Last(
		Date updatedDate,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

	/**
	 * Returns the moi delete documentses before and after the current moi delete documents in the ordered set where updatedDate = &#63;.
	 *
	 * @param documentId the primary key of the current moi delete documents
	 * @param updatedDate the updated date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a moi delete documents with the primary key could not be found
	 */
	public MOIDeleteDocuments[] findByUpdatedDate_PrevAndNext(
			long documentId, Date updatedDate,
			com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
				orderByComparator)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Removes all the moi delete documentses where updatedDate = &#63; from the database.
	 *
	 * @param updatedDate the updated date
	 */
	public void removeByUpdatedDate(Date updatedDate);

	/**
	 * Returns the number of moi delete documentses where updatedDate = &#63;.
	 *
	 * @param updatedDate the updated date
	 * @return the number of matching moi delete documentses
	 */
	public int countByUpdatedDate(Date updatedDate);

	/**
	 * Returns all the moi delete documentses where pendingIdentifiers = &#63;.
	 *
	 * @param pendingIdentifiers the pending identifiers
	 * @return the matching moi delete documentses
	 */
	public java.util.List<MOIDeleteDocuments> findByPendingIdentifiers(
		String pendingIdentifiers);

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
	public java.util.List<MOIDeleteDocuments> findByPendingIdentifiers(
		String pendingIdentifiers, int start, int end);

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
	public java.util.List<MOIDeleteDocuments> findByPendingIdentifiers(
		String pendingIdentifiers, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

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
	public java.util.List<MOIDeleteDocuments> findByPendingIdentifiers(
		String pendingIdentifiers, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi delete documents in the ordered set where pendingIdentifiers = &#63;.
	 *
	 * @param pendingIdentifiers the pending identifiers
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments findByPendingIdentifiers_First(
			String pendingIdentifiers,
			com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
				orderByComparator)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Returns the first moi delete documents in the ordered set where pendingIdentifiers = &#63;.
	 *
	 * @param pendingIdentifiers the pending identifiers
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments fetchByPendingIdentifiers_First(
		String pendingIdentifiers,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

	/**
	 * Returns the last moi delete documents in the ordered set where pendingIdentifiers = &#63;.
	 *
	 * @param pendingIdentifiers the pending identifiers
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments findByPendingIdentifiers_Last(
			String pendingIdentifiers,
			com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
				orderByComparator)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Returns the last moi delete documents in the ordered set where pendingIdentifiers = &#63;.
	 *
	 * @param pendingIdentifiers the pending identifiers
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	public MOIDeleteDocuments fetchByPendingIdentifiers_Last(
		String pendingIdentifiers,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

	/**
	 * Returns the moi delete documentses before and after the current moi delete documents in the ordered set where pendingIdentifiers = &#63;.
	 *
	 * @param documentId the primary key of the current moi delete documents
	 * @param pendingIdentifiers the pending identifiers
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a moi delete documents with the primary key could not be found
	 */
	public MOIDeleteDocuments[] findByPendingIdentifiers_PrevAndNext(
			long documentId, String pendingIdentifiers,
			com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
				orderByComparator)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Removes all the moi delete documentses where pendingIdentifiers = &#63; from the database.
	 *
	 * @param pendingIdentifiers the pending identifiers
	 */
	public void removeByPendingIdentifiers(String pendingIdentifiers);

	/**
	 * Returns the number of moi delete documentses where pendingIdentifiers = &#63;.
	 *
	 * @param pendingIdentifiers the pending identifiers
	 * @return the number of matching moi delete documentses
	 */
	public int countByPendingIdentifiers(String pendingIdentifiers);

	/**
	 * Caches the moi delete documents in the entity cache if it is enabled.
	 *
	 * @param moiDeleteDocuments the moi delete documents
	 */
	public void cacheResult(MOIDeleteDocuments moiDeleteDocuments);

	/**
	 * Caches the moi delete documentses in the entity cache if it is enabled.
	 *
	 * @param moiDeleteDocumentses the moi delete documentses
	 */
	public void cacheResult(
		java.util.List<MOIDeleteDocuments> moiDeleteDocumentses);

	/**
	 * Creates a new moi delete documents with the primary key. Does not add the moi delete documents to the database.
	 *
	 * @param documentId the primary key for the new moi delete documents
	 * @return the new moi delete documents
	 */
	public MOIDeleteDocuments create(long documentId);

	/**
	 * Removes the moi delete documents with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentId the primary key of the moi delete documents
	 * @return the moi delete documents that was removed
	 * @throws NoSuchMOIDeleteDocumentsException if a moi delete documents with the primary key could not be found
	 */
	public MOIDeleteDocuments remove(long documentId)
		throws NoSuchMOIDeleteDocumentsException;

	public MOIDeleteDocuments updateImpl(MOIDeleteDocuments moiDeleteDocuments);

	/**
	 * Returns the moi delete documents with the primary key or throws a <code>NoSuchMOIDeleteDocumentsException</code> if it could not be found.
	 *
	 * @param documentId the primary key of the moi delete documents
	 * @return the moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a moi delete documents with the primary key could not be found
	 */
	public MOIDeleteDocuments findByPrimaryKey(long documentId)
		throws NoSuchMOIDeleteDocumentsException;

	/**
	 * Returns the moi delete documents with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param documentId the primary key of the moi delete documents
	 * @return the moi delete documents, or <code>null</code> if a moi delete documents with the primary key could not be found
	 */
	public MOIDeleteDocuments fetchByPrimaryKey(long documentId);

	/**
	 * Returns all the moi delete documentses.
	 *
	 * @return the moi delete documentses
	 */
	public java.util.List<MOIDeleteDocuments> findAll();

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
	public java.util.List<MOIDeleteDocuments> findAll(int start, int end);

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
	public java.util.List<MOIDeleteDocuments> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator);

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
	public java.util.List<MOIDeleteDocuments> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIDeleteDocuments>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the moi delete documentses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of moi delete documentses.
	 *
	 * @return the number of moi delete documentses
	 */
	public int countAll();

}