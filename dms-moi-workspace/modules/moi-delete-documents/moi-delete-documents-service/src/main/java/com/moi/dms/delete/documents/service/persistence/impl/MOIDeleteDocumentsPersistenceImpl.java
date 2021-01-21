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

package com.moi.dms.delete.documents.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;

import com.moi.dms.delete.documents.exception.NoSuchMOIDeleteDocumentsException;
import com.moi.dms.delete.documents.model.MOIDeleteDocuments;
import com.moi.dms.delete.documents.model.impl.MOIDeleteDocumentsImpl;
import com.moi.dms.delete.documents.model.impl.MOIDeleteDocumentsModelImpl;
import com.moi.dms.delete.documents.service.persistence.MOIDeleteDocumentsPersistence;
import com.moi.dms.delete.documents.service.persistence.impl.constants.moiddPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the moi delete documents service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = MOIDeleteDocumentsPersistence.class)
public class MOIDeleteDocumentsPersistenceImpl
	extends BasePersistenceImpl<MOIDeleteDocuments>
	implements MOIDeleteDocumentsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MOIDeleteDocumentsUtil</code> to access the moi delete documents persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MOIDeleteDocumentsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByDocumentId;
	private FinderPath _finderPathWithoutPaginationFindByDocumentId;
	private FinderPath _finderPathCountByDocumentId;

	/**
	 * Returns all the moi delete documentses where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @return the matching moi delete documentses
	 */
	@Override
	public List<MOIDeleteDocuments> findByDocumentId(long documentId) {
		return findByDocumentId(
			documentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MOIDeleteDocuments> findByDocumentId(
		long documentId, int start, int end) {

		return findByDocumentId(documentId, start, end, null);
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
	@Override
	public List<MOIDeleteDocuments> findByDocumentId(
		long documentId, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return findByDocumentId(
			documentId, start, end, orderByComparator, true);
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
	@Override
	public List<MOIDeleteDocuments> findByDocumentId(
		long documentId, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDocumentId;
				finderArgs = new Object[] {documentId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDocumentId;
			finderArgs = new Object[] {
				documentId, start, end, orderByComparator
			};
		}

		List<MOIDeleteDocuments> list = null;

		if (useFinderCache) {
			list = (List<MOIDeleteDocuments>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOIDeleteDocuments moiDeleteDocuments : list) {
					if (documentId != moiDeleteDocuments.getDocumentId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_MOIDELETEDOCUMENTS_WHERE);

			sb.append(_FINDER_COLUMN_DOCUMENTID_DOCUMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOIDeleteDocumentsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(documentId);

				list = (List<MOIDeleteDocuments>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first moi delete documents in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments findByDocumentId_First(
			long documentId,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws NoSuchMOIDeleteDocumentsException {

		MOIDeleteDocuments moiDeleteDocuments = fetchByDocumentId_First(
			documentId, orderByComparator);

		if (moiDeleteDocuments != null) {
			return moiDeleteDocuments;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("documentId=");
		sb.append(documentId);

		sb.append("}");

		throw new NoSuchMOIDeleteDocumentsException(sb.toString());
	}

	/**
	 * Returns the first moi delete documents in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments fetchByDocumentId_First(
		long documentId,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		List<MOIDeleteDocuments> list = findByDocumentId(
			documentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi delete documents in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments findByDocumentId_Last(
			long documentId,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws NoSuchMOIDeleteDocumentsException {

		MOIDeleteDocuments moiDeleteDocuments = fetchByDocumentId_Last(
			documentId, orderByComparator);

		if (moiDeleteDocuments != null) {
			return moiDeleteDocuments;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("documentId=");
		sb.append(documentId);

		sb.append("}");

		throw new NoSuchMOIDeleteDocumentsException(sb.toString());
	}

	/**
	 * Returns the last moi delete documents in the ordered set where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments fetchByDocumentId_Last(
		long documentId,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		int count = countByDocumentId(documentId);

		if (count == 0) {
			return null;
		}

		List<MOIDeleteDocuments> list = findByDocumentId(
			documentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the moi delete documentses where documentId = &#63; from the database.
	 *
	 * @param documentId the document ID
	 */
	@Override
	public void removeByDocumentId(long documentId) {
		for (MOIDeleteDocuments moiDeleteDocuments :
				findByDocumentId(
					documentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(moiDeleteDocuments);
		}
	}

	/**
	 * Returns the number of moi delete documentses where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @return the number of matching moi delete documentses
	 */
	@Override
	public int countByDocumentId(long documentId) {
		FinderPath finderPath = _finderPathCountByDocumentId;

		Object[] finderArgs = new Object[] {documentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOIDELETEDOCUMENTS_WHERE);

			sb.append(_FINDER_COLUMN_DOCUMENTID_DOCUMENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(documentId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DOCUMENTID_DOCUMENTID_2 =
		"moiDeleteDocuments.documentId = ?";

	private FinderPath _finderPathWithPaginationFindByFileEntryId;
	private FinderPath _finderPathWithoutPaginationFindByFileEntryId;
	private FinderPath _finderPathCountByFileEntryId;

	/**
	 * Returns all the moi delete documentses where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @return the matching moi delete documentses
	 */
	@Override
	public List<MOIDeleteDocuments> findByFileEntryId(long fileEntryId) {
		return findByFileEntryId(
			fileEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MOIDeleteDocuments> findByFileEntryId(
		long fileEntryId, int start, int end) {

		return findByFileEntryId(fileEntryId, start, end, null);
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
	@Override
	public List<MOIDeleteDocuments> findByFileEntryId(
		long fileEntryId, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return findByFileEntryId(
			fileEntryId, start, end, orderByComparator, true);
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
	@Override
	public List<MOIDeleteDocuments> findByFileEntryId(
		long fileEntryId, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFileEntryId;
				finderArgs = new Object[] {fileEntryId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFileEntryId;
			finderArgs = new Object[] {
				fileEntryId, start, end, orderByComparator
			};
		}

		List<MOIDeleteDocuments> list = null;

		if (useFinderCache) {
			list = (List<MOIDeleteDocuments>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOIDeleteDocuments moiDeleteDocuments : list) {
					if (fileEntryId != moiDeleteDocuments.getFileEntryId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_MOIDELETEDOCUMENTS_WHERE);

			sb.append(_FINDER_COLUMN_FILEENTRYID_FILEENTRYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOIDeleteDocumentsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fileEntryId);

				list = (List<MOIDeleteDocuments>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first moi delete documents in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments findByFileEntryId_First(
			long fileEntryId,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws NoSuchMOIDeleteDocumentsException {

		MOIDeleteDocuments moiDeleteDocuments = fetchByFileEntryId_First(
			fileEntryId, orderByComparator);

		if (moiDeleteDocuments != null) {
			return moiDeleteDocuments;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fileEntryId=");
		sb.append(fileEntryId);

		sb.append("}");

		throw new NoSuchMOIDeleteDocumentsException(sb.toString());
	}

	/**
	 * Returns the first moi delete documents in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments fetchByFileEntryId_First(
		long fileEntryId,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		List<MOIDeleteDocuments> list = findByFileEntryId(
			fileEntryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi delete documents in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments findByFileEntryId_Last(
			long fileEntryId,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws NoSuchMOIDeleteDocumentsException {

		MOIDeleteDocuments moiDeleteDocuments = fetchByFileEntryId_Last(
			fileEntryId, orderByComparator);

		if (moiDeleteDocuments != null) {
			return moiDeleteDocuments;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fileEntryId=");
		sb.append(fileEntryId);

		sb.append("}");

		throw new NoSuchMOIDeleteDocumentsException(sb.toString());
	}

	/**
	 * Returns the last moi delete documents in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments fetchByFileEntryId_Last(
		long fileEntryId,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		int count = countByFileEntryId(fileEntryId);

		if (count == 0) {
			return null;
		}

		List<MOIDeleteDocuments> list = findByFileEntryId(
			fileEntryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MOIDeleteDocuments[] findByFileEntryId_PrevAndNext(
			long documentId, long fileEntryId,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws NoSuchMOIDeleteDocumentsException {

		MOIDeleteDocuments moiDeleteDocuments = findByPrimaryKey(documentId);

		Session session = null;

		try {
			session = openSession();

			MOIDeleteDocuments[] array = new MOIDeleteDocumentsImpl[3];

			array[0] = getByFileEntryId_PrevAndNext(
				session, moiDeleteDocuments, fileEntryId, orderByComparator,
				true);

			array[1] = moiDeleteDocuments;

			array[2] = getByFileEntryId_PrevAndNext(
				session, moiDeleteDocuments, fileEntryId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MOIDeleteDocuments getByFileEntryId_PrevAndNext(
		Session session, MOIDeleteDocuments moiDeleteDocuments,
		long fileEntryId,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MOIDELETEDOCUMENTS_WHERE);

		sb.append(_FINDER_COLUMN_FILEENTRYID_FILEENTRYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MOIDeleteDocumentsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(fileEntryId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						moiDeleteDocuments)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MOIDeleteDocuments> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the moi delete documentses where fileEntryId = &#63; from the database.
	 *
	 * @param fileEntryId the file entry ID
	 */
	@Override
	public void removeByFileEntryId(long fileEntryId) {
		for (MOIDeleteDocuments moiDeleteDocuments :
				findByFileEntryId(
					fileEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(moiDeleteDocuments);
		}
	}

	/**
	 * Returns the number of moi delete documentses where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @return the number of matching moi delete documentses
	 */
	@Override
	public int countByFileEntryId(long fileEntryId) {
		FinderPath finderPath = _finderPathCountByFileEntryId;

		Object[] finderArgs = new Object[] {fileEntryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOIDELETEDOCUMENTS_WHERE);

			sb.append(_FINDER_COLUMN_FILEENTRYID_FILEENTRYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fileEntryId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FILEENTRYID_FILEENTRYID_2 =
		"moiDeleteDocuments.fileEntryId = ?";

	private FinderPath _finderPathWithPaginationFindByFileEntryName;
	private FinderPath _finderPathWithoutPaginationFindByFileEntryName;
	private FinderPath _finderPathCountByFileEntryName;

	/**
	 * Returns all the moi delete documentses where fileEntryName = &#63;.
	 *
	 * @param fileEntryName the file entry name
	 * @return the matching moi delete documentses
	 */
	@Override
	public List<MOIDeleteDocuments> findByFileEntryName(String fileEntryName) {
		return findByFileEntryName(
			fileEntryName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MOIDeleteDocuments> findByFileEntryName(
		String fileEntryName, int start, int end) {

		return findByFileEntryName(fileEntryName, start, end, null);
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
	@Override
	public List<MOIDeleteDocuments> findByFileEntryName(
		String fileEntryName, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return findByFileEntryName(
			fileEntryName, start, end, orderByComparator, true);
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
	@Override
	public List<MOIDeleteDocuments> findByFileEntryName(
		String fileEntryName, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean useFinderCache) {

		fileEntryName = Objects.toString(fileEntryName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFileEntryName;
				finderArgs = new Object[] {fileEntryName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFileEntryName;
			finderArgs = new Object[] {
				fileEntryName, start, end, orderByComparator
			};
		}

		List<MOIDeleteDocuments> list = null;

		if (useFinderCache) {
			list = (List<MOIDeleteDocuments>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOIDeleteDocuments moiDeleteDocuments : list) {
					if (!fileEntryName.equals(
							moiDeleteDocuments.getFileEntryName())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_MOIDELETEDOCUMENTS_WHERE);

			boolean bindFileEntryName = false;

			if (fileEntryName.isEmpty()) {
				sb.append(_FINDER_COLUMN_FILEENTRYNAME_FILEENTRYNAME_3);
			}
			else {
				bindFileEntryName = true;

				sb.append(_FINDER_COLUMN_FILEENTRYNAME_FILEENTRYNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOIDeleteDocumentsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFileEntryName) {
					queryPos.add(fileEntryName);
				}

				list = (List<MOIDeleteDocuments>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first moi delete documents in the ordered set where fileEntryName = &#63;.
	 *
	 * @param fileEntryName the file entry name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments findByFileEntryName_First(
			String fileEntryName,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws NoSuchMOIDeleteDocumentsException {

		MOIDeleteDocuments moiDeleteDocuments = fetchByFileEntryName_First(
			fileEntryName, orderByComparator);

		if (moiDeleteDocuments != null) {
			return moiDeleteDocuments;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fileEntryName=");
		sb.append(fileEntryName);

		sb.append("}");

		throw new NoSuchMOIDeleteDocumentsException(sb.toString());
	}

	/**
	 * Returns the first moi delete documents in the ordered set where fileEntryName = &#63;.
	 *
	 * @param fileEntryName the file entry name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments fetchByFileEntryName_First(
		String fileEntryName,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		List<MOIDeleteDocuments> list = findByFileEntryName(
			fileEntryName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi delete documents in the ordered set where fileEntryName = &#63;.
	 *
	 * @param fileEntryName the file entry name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments findByFileEntryName_Last(
			String fileEntryName,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws NoSuchMOIDeleteDocumentsException {

		MOIDeleteDocuments moiDeleteDocuments = fetchByFileEntryName_Last(
			fileEntryName, orderByComparator);

		if (moiDeleteDocuments != null) {
			return moiDeleteDocuments;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fileEntryName=");
		sb.append(fileEntryName);

		sb.append("}");

		throw new NoSuchMOIDeleteDocumentsException(sb.toString());
	}

	/**
	 * Returns the last moi delete documents in the ordered set where fileEntryName = &#63;.
	 *
	 * @param fileEntryName the file entry name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments fetchByFileEntryName_Last(
		String fileEntryName,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		int count = countByFileEntryName(fileEntryName);

		if (count == 0) {
			return null;
		}

		List<MOIDeleteDocuments> list = findByFileEntryName(
			fileEntryName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MOIDeleteDocuments[] findByFileEntryName_PrevAndNext(
			long documentId, String fileEntryName,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws NoSuchMOIDeleteDocumentsException {

		fileEntryName = Objects.toString(fileEntryName, "");

		MOIDeleteDocuments moiDeleteDocuments = findByPrimaryKey(documentId);

		Session session = null;

		try {
			session = openSession();

			MOIDeleteDocuments[] array = new MOIDeleteDocumentsImpl[3];

			array[0] = getByFileEntryName_PrevAndNext(
				session, moiDeleteDocuments, fileEntryName, orderByComparator,
				true);

			array[1] = moiDeleteDocuments;

			array[2] = getByFileEntryName_PrevAndNext(
				session, moiDeleteDocuments, fileEntryName, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MOIDeleteDocuments getByFileEntryName_PrevAndNext(
		Session session, MOIDeleteDocuments moiDeleteDocuments,
		String fileEntryName,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MOIDELETEDOCUMENTS_WHERE);

		boolean bindFileEntryName = false;

		if (fileEntryName.isEmpty()) {
			sb.append(_FINDER_COLUMN_FILEENTRYNAME_FILEENTRYNAME_3);
		}
		else {
			bindFileEntryName = true;

			sb.append(_FINDER_COLUMN_FILEENTRYNAME_FILEENTRYNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MOIDeleteDocumentsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindFileEntryName) {
			queryPos.add(fileEntryName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						moiDeleteDocuments)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MOIDeleteDocuments> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the moi delete documentses where fileEntryName = &#63; from the database.
	 *
	 * @param fileEntryName the file entry name
	 */
	@Override
	public void removeByFileEntryName(String fileEntryName) {
		for (MOIDeleteDocuments moiDeleteDocuments :
				findByFileEntryName(
					fileEntryName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(moiDeleteDocuments);
		}
	}

	/**
	 * Returns the number of moi delete documentses where fileEntryName = &#63;.
	 *
	 * @param fileEntryName the file entry name
	 * @return the number of matching moi delete documentses
	 */
	@Override
	public int countByFileEntryName(String fileEntryName) {
		fileEntryName = Objects.toString(fileEntryName, "");

		FinderPath finderPath = _finderPathCountByFileEntryName;

		Object[] finderArgs = new Object[] {fileEntryName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOIDELETEDOCUMENTS_WHERE);

			boolean bindFileEntryName = false;

			if (fileEntryName.isEmpty()) {
				sb.append(_FINDER_COLUMN_FILEENTRYNAME_FILEENTRYNAME_3);
			}
			else {
				bindFileEntryName = true;

				sb.append(_FINDER_COLUMN_FILEENTRYNAME_FILEENTRYNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFileEntryName) {
					queryPos.add(fileEntryName);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FILEENTRYNAME_FILEENTRYNAME_2 =
		"moiDeleteDocuments.fileEntryName = ?";

	private static final String _FINDER_COLUMN_FILEENTRYNAME_FILEENTRYNAME_3 =
		"(moiDeleteDocuments.fileEntryName IS NULL OR moiDeleteDocuments.fileEntryName = '')";

	private FinderPath _finderPathWithPaginationFindByConsumerCode;
	private FinderPath _finderPathWithoutPaginationFindByConsumerCode;
	private FinderPath _finderPathCountByConsumerCode;

	/**
	 * Returns all the moi delete documentses where consumerCode = &#63;.
	 *
	 * @param consumerCode the consumer code
	 * @return the matching moi delete documentses
	 */
	@Override
	public List<MOIDeleteDocuments> findByConsumerCode(String consumerCode) {
		return findByConsumerCode(
			consumerCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MOIDeleteDocuments> findByConsumerCode(
		String consumerCode, int start, int end) {

		return findByConsumerCode(consumerCode, start, end, null);
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
	@Override
	public List<MOIDeleteDocuments> findByConsumerCode(
		String consumerCode, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return findByConsumerCode(
			consumerCode, start, end, orderByComparator, true);
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
	@Override
	public List<MOIDeleteDocuments> findByConsumerCode(
		String consumerCode, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean useFinderCache) {

		consumerCode = Objects.toString(consumerCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByConsumerCode;
				finderArgs = new Object[] {consumerCode};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByConsumerCode;
			finderArgs = new Object[] {
				consumerCode, start, end, orderByComparator
			};
		}

		List<MOIDeleteDocuments> list = null;

		if (useFinderCache) {
			list = (List<MOIDeleteDocuments>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOIDeleteDocuments moiDeleteDocuments : list) {
					if (!consumerCode.equals(
							moiDeleteDocuments.getConsumerCode())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_MOIDELETEDOCUMENTS_WHERE);

			boolean bindConsumerCode = false;

			if (consumerCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_CONSUMERCODE_CONSUMERCODE_3);
			}
			else {
				bindConsumerCode = true;

				sb.append(_FINDER_COLUMN_CONSUMERCODE_CONSUMERCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOIDeleteDocumentsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindConsumerCode) {
					queryPos.add(consumerCode);
				}

				list = (List<MOIDeleteDocuments>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first moi delete documents in the ordered set where consumerCode = &#63;.
	 *
	 * @param consumerCode the consumer code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments findByConsumerCode_First(
			String consumerCode,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws NoSuchMOIDeleteDocumentsException {

		MOIDeleteDocuments moiDeleteDocuments = fetchByConsumerCode_First(
			consumerCode, orderByComparator);

		if (moiDeleteDocuments != null) {
			return moiDeleteDocuments;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("consumerCode=");
		sb.append(consumerCode);

		sb.append("}");

		throw new NoSuchMOIDeleteDocumentsException(sb.toString());
	}

	/**
	 * Returns the first moi delete documents in the ordered set where consumerCode = &#63;.
	 *
	 * @param consumerCode the consumer code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments fetchByConsumerCode_First(
		String consumerCode,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		List<MOIDeleteDocuments> list = findByConsumerCode(
			consumerCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi delete documents in the ordered set where consumerCode = &#63;.
	 *
	 * @param consumerCode the consumer code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments findByConsumerCode_Last(
			String consumerCode,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws NoSuchMOIDeleteDocumentsException {

		MOIDeleteDocuments moiDeleteDocuments = fetchByConsumerCode_Last(
			consumerCode, orderByComparator);

		if (moiDeleteDocuments != null) {
			return moiDeleteDocuments;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("consumerCode=");
		sb.append(consumerCode);

		sb.append("}");

		throw new NoSuchMOIDeleteDocumentsException(sb.toString());
	}

	/**
	 * Returns the last moi delete documents in the ordered set where consumerCode = &#63;.
	 *
	 * @param consumerCode the consumer code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments fetchByConsumerCode_Last(
		String consumerCode,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		int count = countByConsumerCode(consumerCode);

		if (count == 0) {
			return null;
		}

		List<MOIDeleteDocuments> list = findByConsumerCode(
			consumerCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MOIDeleteDocuments[] findByConsumerCode_PrevAndNext(
			long documentId, String consumerCode,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws NoSuchMOIDeleteDocumentsException {

		consumerCode = Objects.toString(consumerCode, "");

		MOIDeleteDocuments moiDeleteDocuments = findByPrimaryKey(documentId);

		Session session = null;

		try {
			session = openSession();

			MOIDeleteDocuments[] array = new MOIDeleteDocumentsImpl[3];

			array[0] = getByConsumerCode_PrevAndNext(
				session, moiDeleteDocuments, consumerCode, orderByComparator,
				true);

			array[1] = moiDeleteDocuments;

			array[2] = getByConsumerCode_PrevAndNext(
				session, moiDeleteDocuments, consumerCode, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MOIDeleteDocuments getByConsumerCode_PrevAndNext(
		Session session, MOIDeleteDocuments moiDeleteDocuments,
		String consumerCode,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MOIDELETEDOCUMENTS_WHERE);

		boolean bindConsumerCode = false;

		if (consumerCode.isEmpty()) {
			sb.append(_FINDER_COLUMN_CONSUMERCODE_CONSUMERCODE_3);
		}
		else {
			bindConsumerCode = true;

			sb.append(_FINDER_COLUMN_CONSUMERCODE_CONSUMERCODE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MOIDeleteDocumentsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindConsumerCode) {
			queryPos.add(consumerCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						moiDeleteDocuments)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MOIDeleteDocuments> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the moi delete documentses where consumerCode = &#63; from the database.
	 *
	 * @param consumerCode the consumer code
	 */
	@Override
	public void removeByConsumerCode(String consumerCode) {
		for (MOIDeleteDocuments moiDeleteDocuments :
				findByConsumerCode(
					consumerCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(moiDeleteDocuments);
		}
	}

	/**
	 * Returns the number of moi delete documentses where consumerCode = &#63;.
	 *
	 * @param consumerCode the consumer code
	 * @return the number of matching moi delete documentses
	 */
	@Override
	public int countByConsumerCode(String consumerCode) {
		consumerCode = Objects.toString(consumerCode, "");

		FinderPath finderPath = _finderPathCountByConsumerCode;

		Object[] finderArgs = new Object[] {consumerCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOIDELETEDOCUMENTS_WHERE);

			boolean bindConsumerCode = false;

			if (consumerCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_CONSUMERCODE_CONSUMERCODE_3);
			}
			else {
				bindConsumerCode = true;

				sb.append(_FINDER_COLUMN_CONSUMERCODE_CONSUMERCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindConsumerCode) {
					queryPos.add(consumerCode);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CONSUMERCODE_CONSUMERCODE_2 =
		"moiDeleteDocuments.consumerCode = ?";

	private static final String _FINDER_COLUMN_CONSUMERCODE_CONSUMERCODE_3 =
		"(moiDeleteDocuments.consumerCode IS NULL OR moiDeleteDocuments.consumerCode = '')";

	private FinderPath _finderPathWithPaginationFindByModuleType;
	private FinderPath _finderPathWithoutPaginationFindByModuleType;
	private FinderPath _finderPathCountByModuleType;

	/**
	 * Returns all the moi delete documentses where moduleType = &#63;.
	 *
	 * @param moduleType the module type
	 * @return the matching moi delete documentses
	 */
	@Override
	public List<MOIDeleteDocuments> findByModuleType(String moduleType) {
		return findByModuleType(
			moduleType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MOIDeleteDocuments> findByModuleType(
		String moduleType, int start, int end) {

		return findByModuleType(moduleType, start, end, null);
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
	@Override
	public List<MOIDeleteDocuments> findByModuleType(
		String moduleType, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return findByModuleType(
			moduleType, start, end, orderByComparator, true);
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
	@Override
	public List<MOIDeleteDocuments> findByModuleType(
		String moduleType, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean useFinderCache) {

		moduleType = Objects.toString(moduleType, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByModuleType;
				finderArgs = new Object[] {moduleType};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByModuleType;
			finderArgs = new Object[] {
				moduleType, start, end, orderByComparator
			};
		}

		List<MOIDeleteDocuments> list = null;

		if (useFinderCache) {
			list = (List<MOIDeleteDocuments>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOIDeleteDocuments moiDeleteDocuments : list) {
					if (!moduleType.equals(
							moiDeleteDocuments.getModuleType())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_MOIDELETEDOCUMENTS_WHERE);

			boolean bindModuleType = false;

			if (moduleType.isEmpty()) {
				sb.append(_FINDER_COLUMN_MODULETYPE_MODULETYPE_3);
			}
			else {
				bindModuleType = true;

				sb.append(_FINDER_COLUMN_MODULETYPE_MODULETYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOIDeleteDocumentsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindModuleType) {
					queryPos.add(moduleType);
				}

				list = (List<MOIDeleteDocuments>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first moi delete documents in the ordered set where moduleType = &#63;.
	 *
	 * @param moduleType the module type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments findByModuleType_First(
			String moduleType,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws NoSuchMOIDeleteDocumentsException {

		MOIDeleteDocuments moiDeleteDocuments = fetchByModuleType_First(
			moduleType, orderByComparator);

		if (moiDeleteDocuments != null) {
			return moiDeleteDocuments;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("moduleType=");
		sb.append(moduleType);

		sb.append("}");

		throw new NoSuchMOIDeleteDocumentsException(sb.toString());
	}

	/**
	 * Returns the first moi delete documents in the ordered set where moduleType = &#63;.
	 *
	 * @param moduleType the module type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments fetchByModuleType_First(
		String moduleType,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		List<MOIDeleteDocuments> list = findByModuleType(
			moduleType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi delete documents in the ordered set where moduleType = &#63;.
	 *
	 * @param moduleType the module type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments findByModuleType_Last(
			String moduleType,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws NoSuchMOIDeleteDocumentsException {

		MOIDeleteDocuments moiDeleteDocuments = fetchByModuleType_Last(
			moduleType, orderByComparator);

		if (moiDeleteDocuments != null) {
			return moiDeleteDocuments;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("moduleType=");
		sb.append(moduleType);

		sb.append("}");

		throw new NoSuchMOIDeleteDocumentsException(sb.toString());
	}

	/**
	 * Returns the last moi delete documents in the ordered set where moduleType = &#63;.
	 *
	 * @param moduleType the module type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments fetchByModuleType_Last(
		String moduleType,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		int count = countByModuleType(moduleType);

		if (count == 0) {
			return null;
		}

		List<MOIDeleteDocuments> list = findByModuleType(
			moduleType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MOIDeleteDocuments[] findByModuleType_PrevAndNext(
			long documentId, String moduleType,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws NoSuchMOIDeleteDocumentsException {

		moduleType = Objects.toString(moduleType, "");

		MOIDeleteDocuments moiDeleteDocuments = findByPrimaryKey(documentId);

		Session session = null;

		try {
			session = openSession();

			MOIDeleteDocuments[] array = new MOIDeleteDocumentsImpl[3];

			array[0] = getByModuleType_PrevAndNext(
				session, moiDeleteDocuments, moduleType, orderByComparator,
				true);

			array[1] = moiDeleteDocuments;

			array[2] = getByModuleType_PrevAndNext(
				session, moiDeleteDocuments, moduleType, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MOIDeleteDocuments getByModuleType_PrevAndNext(
		Session session, MOIDeleteDocuments moiDeleteDocuments,
		String moduleType,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MOIDELETEDOCUMENTS_WHERE);

		boolean bindModuleType = false;

		if (moduleType.isEmpty()) {
			sb.append(_FINDER_COLUMN_MODULETYPE_MODULETYPE_3);
		}
		else {
			bindModuleType = true;

			sb.append(_FINDER_COLUMN_MODULETYPE_MODULETYPE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MOIDeleteDocumentsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindModuleType) {
			queryPos.add(moduleType);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						moiDeleteDocuments)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MOIDeleteDocuments> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the moi delete documentses where moduleType = &#63; from the database.
	 *
	 * @param moduleType the module type
	 */
	@Override
	public void removeByModuleType(String moduleType) {
		for (MOIDeleteDocuments moiDeleteDocuments :
				findByModuleType(
					moduleType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(moiDeleteDocuments);
		}
	}

	/**
	 * Returns the number of moi delete documentses where moduleType = &#63;.
	 *
	 * @param moduleType the module type
	 * @return the number of matching moi delete documentses
	 */
	@Override
	public int countByModuleType(String moduleType) {
		moduleType = Objects.toString(moduleType, "");

		FinderPath finderPath = _finderPathCountByModuleType;

		Object[] finderArgs = new Object[] {moduleType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOIDELETEDOCUMENTS_WHERE);

			boolean bindModuleType = false;

			if (moduleType.isEmpty()) {
				sb.append(_FINDER_COLUMN_MODULETYPE_MODULETYPE_3);
			}
			else {
				bindModuleType = true;

				sb.append(_FINDER_COLUMN_MODULETYPE_MODULETYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindModuleType) {
					queryPos.add(moduleType);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_MODULETYPE_MODULETYPE_2 =
		"moiDeleteDocuments.moduleType = ?";

	private static final String _FINDER_COLUMN_MODULETYPE_MODULETYPE_3 =
		"(moiDeleteDocuments.moduleType IS NULL OR moiDeleteDocuments.moduleType = '')";

	private FinderPath _finderPathWithPaginationFindByUploadedBy;
	private FinderPath _finderPathWithoutPaginationFindByUploadedBy;
	private FinderPath _finderPathCountByUploadedBy;

	/**
	 * Returns all the moi delete documentses where uploadedBy = &#63;.
	 *
	 * @param uploadedBy the uploaded by
	 * @return the matching moi delete documentses
	 */
	@Override
	public List<MOIDeleteDocuments> findByUploadedBy(String uploadedBy) {
		return findByUploadedBy(
			uploadedBy, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MOIDeleteDocuments> findByUploadedBy(
		String uploadedBy, int start, int end) {

		return findByUploadedBy(uploadedBy, start, end, null);
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
	@Override
	public List<MOIDeleteDocuments> findByUploadedBy(
		String uploadedBy, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return findByUploadedBy(
			uploadedBy, start, end, orderByComparator, true);
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
	@Override
	public List<MOIDeleteDocuments> findByUploadedBy(
		String uploadedBy, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean useFinderCache) {

		uploadedBy = Objects.toString(uploadedBy, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUploadedBy;
				finderArgs = new Object[] {uploadedBy};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUploadedBy;
			finderArgs = new Object[] {
				uploadedBy, start, end, orderByComparator
			};
		}

		List<MOIDeleteDocuments> list = null;

		if (useFinderCache) {
			list = (List<MOIDeleteDocuments>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOIDeleteDocuments moiDeleteDocuments : list) {
					if (!uploadedBy.equals(
							moiDeleteDocuments.getUploadedBy())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_MOIDELETEDOCUMENTS_WHERE);

			boolean bindUploadedBy = false;

			if (uploadedBy.isEmpty()) {
				sb.append(_FINDER_COLUMN_UPLOADEDBY_UPLOADEDBY_3);
			}
			else {
				bindUploadedBy = true;

				sb.append(_FINDER_COLUMN_UPLOADEDBY_UPLOADEDBY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOIDeleteDocumentsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUploadedBy) {
					queryPos.add(uploadedBy);
				}

				list = (List<MOIDeleteDocuments>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first moi delete documents in the ordered set where uploadedBy = &#63;.
	 *
	 * @param uploadedBy the uploaded by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments findByUploadedBy_First(
			String uploadedBy,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws NoSuchMOIDeleteDocumentsException {

		MOIDeleteDocuments moiDeleteDocuments = fetchByUploadedBy_First(
			uploadedBy, orderByComparator);

		if (moiDeleteDocuments != null) {
			return moiDeleteDocuments;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uploadedBy=");
		sb.append(uploadedBy);

		sb.append("}");

		throw new NoSuchMOIDeleteDocumentsException(sb.toString());
	}

	/**
	 * Returns the first moi delete documents in the ordered set where uploadedBy = &#63;.
	 *
	 * @param uploadedBy the uploaded by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments fetchByUploadedBy_First(
		String uploadedBy,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		List<MOIDeleteDocuments> list = findByUploadedBy(
			uploadedBy, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi delete documents in the ordered set where uploadedBy = &#63;.
	 *
	 * @param uploadedBy the uploaded by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments findByUploadedBy_Last(
			String uploadedBy,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws NoSuchMOIDeleteDocumentsException {

		MOIDeleteDocuments moiDeleteDocuments = fetchByUploadedBy_Last(
			uploadedBy, orderByComparator);

		if (moiDeleteDocuments != null) {
			return moiDeleteDocuments;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uploadedBy=");
		sb.append(uploadedBy);

		sb.append("}");

		throw new NoSuchMOIDeleteDocumentsException(sb.toString());
	}

	/**
	 * Returns the last moi delete documents in the ordered set where uploadedBy = &#63;.
	 *
	 * @param uploadedBy the uploaded by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments fetchByUploadedBy_Last(
		String uploadedBy,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		int count = countByUploadedBy(uploadedBy);

		if (count == 0) {
			return null;
		}

		List<MOIDeleteDocuments> list = findByUploadedBy(
			uploadedBy, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MOIDeleteDocuments[] findByUploadedBy_PrevAndNext(
			long documentId, String uploadedBy,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws NoSuchMOIDeleteDocumentsException {

		uploadedBy = Objects.toString(uploadedBy, "");

		MOIDeleteDocuments moiDeleteDocuments = findByPrimaryKey(documentId);

		Session session = null;

		try {
			session = openSession();

			MOIDeleteDocuments[] array = new MOIDeleteDocumentsImpl[3];

			array[0] = getByUploadedBy_PrevAndNext(
				session, moiDeleteDocuments, uploadedBy, orderByComparator,
				true);

			array[1] = moiDeleteDocuments;

			array[2] = getByUploadedBy_PrevAndNext(
				session, moiDeleteDocuments, uploadedBy, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MOIDeleteDocuments getByUploadedBy_PrevAndNext(
		Session session, MOIDeleteDocuments moiDeleteDocuments,
		String uploadedBy,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MOIDELETEDOCUMENTS_WHERE);

		boolean bindUploadedBy = false;

		if (uploadedBy.isEmpty()) {
			sb.append(_FINDER_COLUMN_UPLOADEDBY_UPLOADEDBY_3);
		}
		else {
			bindUploadedBy = true;

			sb.append(_FINDER_COLUMN_UPLOADEDBY_UPLOADEDBY_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MOIDeleteDocumentsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUploadedBy) {
			queryPos.add(uploadedBy);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						moiDeleteDocuments)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MOIDeleteDocuments> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the moi delete documentses where uploadedBy = &#63; from the database.
	 *
	 * @param uploadedBy the uploaded by
	 */
	@Override
	public void removeByUploadedBy(String uploadedBy) {
		for (MOIDeleteDocuments moiDeleteDocuments :
				findByUploadedBy(
					uploadedBy, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(moiDeleteDocuments);
		}
	}

	/**
	 * Returns the number of moi delete documentses where uploadedBy = &#63;.
	 *
	 * @param uploadedBy the uploaded by
	 * @return the number of matching moi delete documentses
	 */
	@Override
	public int countByUploadedBy(String uploadedBy) {
		uploadedBy = Objects.toString(uploadedBy, "");

		FinderPath finderPath = _finderPathCountByUploadedBy;

		Object[] finderArgs = new Object[] {uploadedBy};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOIDELETEDOCUMENTS_WHERE);

			boolean bindUploadedBy = false;

			if (uploadedBy.isEmpty()) {
				sb.append(_FINDER_COLUMN_UPLOADEDBY_UPLOADEDBY_3);
			}
			else {
				bindUploadedBy = true;

				sb.append(_FINDER_COLUMN_UPLOADEDBY_UPLOADEDBY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUploadedBy) {
					queryPos.add(uploadedBy);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UPLOADEDBY_UPLOADEDBY_2 =
		"moiDeleteDocuments.uploadedBy = ?";

	private static final String _FINDER_COLUMN_UPLOADEDBY_UPLOADEDBY_3 =
		"(moiDeleteDocuments.uploadedBy IS NULL OR moiDeleteDocuments.uploadedBy = '')";

	private FinderPath _finderPathWithPaginationFindByUploadedDate;
	private FinderPath _finderPathWithoutPaginationFindByUploadedDate;
	private FinderPath _finderPathCountByUploadedDate;

	/**
	 * Returns all the moi delete documentses where uploadedDate = &#63;.
	 *
	 * @param uploadedDate the uploaded date
	 * @return the matching moi delete documentses
	 */
	@Override
	public List<MOIDeleteDocuments> findByUploadedDate(Date uploadedDate) {
		return findByUploadedDate(
			uploadedDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MOIDeleteDocuments> findByUploadedDate(
		Date uploadedDate, int start, int end) {

		return findByUploadedDate(uploadedDate, start, end, null);
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
	@Override
	public List<MOIDeleteDocuments> findByUploadedDate(
		Date uploadedDate, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return findByUploadedDate(
			uploadedDate, start, end, orderByComparator, true);
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
	@Override
	public List<MOIDeleteDocuments> findByUploadedDate(
		Date uploadedDate, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUploadedDate;
				finderArgs = new Object[] {_getTime(uploadedDate)};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUploadedDate;
			finderArgs = new Object[] {
				_getTime(uploadedDate), start, end, orderByComparator
			};
		}

		List<MOIDeleteDocuments> list = null;

		if (useFinderCache) {
			list = (List<MOIDeleteDocuments>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOIDeleteDocuments moiDeleteDocuments : list) {
					if (!Objects.equals(
							uploadedDate,
							moiDeleteDocuments.getUploadedDate())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_MOIDELETEDOCUMENTS_WHERE);

			boolean bindUploadedDate = false;

			if (uploadedDate == null) {
				sb.append(_FINDER_COLUMN_UPLOADEDDATE_UPLOADEDDATE_1);
			}
			else {
				bindUploadedDate = true;

				sb.append(_FINDER_COLUMN_UPLOADEDDATE_UPLOADEDDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOIDeleteDocumentsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUploadedDate) {
					queryPos.add(new Timestamp(uploadedDate.getTime()));
				}

				list = (List<MOIDeleteDocuments>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first moi delete documents in the ordered set where uploadedDate = &#63;.
	 *
	 * @param uploadedDate the uploaded date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments findByUploadedDate_First(
			Date uploadedDate,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws NoSuchMOIDeleteDocumentsException {

		MOIDeleteDocuments moiDeleteDocuments = fetchByUploadedDate_First(
			uploadedDate, orderByComparator);

		if (moiDeleteDocuments != null) {
			return moiDeleteDocuments;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uploadedDate=");
		sb.append(uploadedDate);

		sb.append("}");

		throw new NoSuchMOIDeleteDocumentsException(sb.toString());
	}

	/**
	 * Returns the first moi delete documents in the ordered set where uploadedDate = &#63;.
	 *
	 * @param uploadedDate the uploaded date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments fetchByUploadedDate_First(
		Date uploadedDate,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		List<MOIDeleteDocuments> list = findByUploadedDate(
			uploadedDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi delete documents in the ordered set where uploadedDate = &#63;.
	 *
	 * @param uploadedDate the uploaded date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments findByUploadedDate_Last(
			Date uploadedDate,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws NoSuchMOIDeleteDocumentsException {

		MOIDeleteDocuments moiDeleteDocuments = fetchByUploadedDate_Last(
			uploadedDate, orderByComparator);

		if (moiDeleteDocuments != null) {
			return moiDeleteDocuments;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uploadedDate=");
		sb.append(uploadedDate);

		sb.append("}");

		throw new NoSuchMOIDeleteDocumentsException(sb.toString());
	}

	/**
	 * Returns the last moi delete documents in the ordered set where uploadedDate = &#63;.
	 *
	 * @param uploadedDate the uploaded date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments fetchByUploadedDate_Last(
		Date uploadedDate,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		int count = countByUploadedDate(uploadedDate);

		if (count == 0) {
			return null;
		}

		List<MOIDeleteDocuments> list = findByUploadedDate(
			uploadedDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MOIDeleteDocuments[] findByUploadedDate_PrevAndNext(
			long documentId, Date uploadedDate,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws NoSuchMOIDeleteDocumentsException {

		MOIDeleteDocuments moiDeleteDocuments = findByPrimaryKey(documentId);

		Session session = null;

		try {
			session = openSession();

			MOIDeleteDocuments[] array = new MOIDeleteDocumentsImpl[3];

			array[0] = getByUploadedDate_PrevAndNext(
				session, moiDeleteDocuments, uploadedDate, orderByComparator,
				true);

			array[1] = moiDeleteDocuments;

			array[2] = getByUploadedDate_PrevAndNext(
				session, moiDeleteDocuments, uploadedDate, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MOIDeleteDocuments getByUploadedDate_PrevAndNext(
		Session session, MOIDeleteDocuments moiDeleteDocuments,
		Date uploadedDate,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MOIDELETEDOCUMENTS_WHERE);

		boolean bindUploadedDate = false;

		if (uploadedDate == null) {
			sb.append(_FINDER_COLUMN_UPLOADEDDATE_UPLOADEDDATE_1);
		}
		else {
			bindUploadedDate = true;

			sb.append(_FINDER_COLUMN_UPLOADEDDATE_UPLOADEDDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MOIDeleteDocumentsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUploadedDate) {
			queryPos.add(new Timestamp(uploadedDate.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						moiDeleteDocuments)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MOIDeleteDocuments> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the moi delete documentses where uploadedDate = &#63; from the database.
	 *
	 * @param uploadedDate the uploaded date
	 */
	@Override
	public void removeByUploadedDate(Date uploadedDate) {
		for (MOIDeleteDocuments moiDeleteDocuments :
				findByUploadedDate(
					uploadedDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(moiDeleteDocuments);
		}
	}

	/**
	 * Returns the number of moi delete documentses where uploadedDate = &#63;.
	 *
	 * @param uploadedDate the uploaded date
	 * @return the number of matching moi delete documentses
	 */
	@Override
	public int countByUploadedDate(Date uploadedDate) {
		FinderPath finderPath = _finderPathCountByUploadedDate;

		Object[] finderArgs = new Object[] {_getTime(uploadedDate)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOIDELETEDOCUMENTS_WHERE);

			boolean bindUploadedDate = false;

			if (uploadedDate == null) {
				sb.append(_FINDER_COLUMN_UPLOADEDDATE_UPLOADEDDATE_1);
			}
			else {
				bindUploadedDate = true;

				sb.append(_FINDER_COLUMN_UPLOADEDDATE_UPLOADEDDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUploadedDate) {
					queryPos.add(new Timestamp(uploadedDate.getTime()));
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UPLOADEDDATE_UPLOADEDDATE_1 =
		"moiDeleteDocuments.uploadedDate IS NULL";

	private static final String _FINDER_COLUMN_UPLOADEDDATE_UPLOADEDDATE_2 =
		"moiDeleteDocuments.uploadedDate = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the moi delete documentses where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching moi delete documentses
	 */
	@Override
	public List<MOIDeleteDocuments> findByStatus(String status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MOIDeleteDocuments> findByStatus(
		String status, int start, int end) {

		return findByStatus(status, start, end, null);
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
	@Override
	public List<MOIDeleteDocuments> findByStatus(
		String status, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
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
	@Override
	public List<MOIDeleteDocuments> findByStatus(
		String status, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean useFinderCache) {

		status = Objects.toString(status, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatus;
				finderArgs = new Object[] {status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatus;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<MOIDeleteDocuments> list = null;

		if (useFinderCache) {
			list = (List<MOIDeleteDocuments>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOIDeleteDocuments moiDeleteDocuments : list) {
					if (!status.equals(moiDeleteDocuments.getStatus())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_MOIDELETEDOCUMENTS_WHERE);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_STATUS_STATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOIDeleteDocumentsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStatus) {
					queryPos.add(status);
				}

				list = (List<MOIDeleteDocuments>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first moi delete documents in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments findByStatus_First(
			String status,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws NoSuchMOIDeleteDocumentsException {

		MOIDeleteDocuments moiDeleteDocuments = fetchByStatus_First(
			status, orderByComparator);

		if (moiDeleteDocuments != null) {
			return moiDeleteDocuments;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchMOIDeleteDocumentsException(sb.toString());
	}

	/**
	 * Returns the first moi delete documents in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments fetchByStatus_First(
		String status,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		List<MOIDeleteDocuments> list = findByStatus(
			status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi delete documents in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments findByStatus_Last(
			String status,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws NoSuchMOIDeleteDocumentsException {

		MOIDeleteDocuments moiDeleteDocuments = fetchByStatus_Last(
			status, orderByComparator);

		if (moiDeleteDocuments != null) {
			return moiDeleteDocuments;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchMOIDeleteDocumentsException(sb.toString());
	}

	/**
	 * Returns the last moi delete documents in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments fetchByStatus_Last(
		String status,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<MOIDeleteDocuments> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MOIDeleteDocuments[] findByStatus_PrevAndNext(
			long documentId, String status,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws NoSuchMOIDeleteDocumentsException {

		status = Objects.toString(status, "");

		MOIDeleteDocuments moiDeleteDocuments = findByPrimaryKey(documentId);

		Session session = null;

		try {
			session = openSession();

			MOIDeleteDocuments[] array = new MOIDeleteDocumentsImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, moiDeleteDocuments, status, orderByComparator, true);

			array[1] = moiDeleteDocuments;

			array[2] = getByStatus_PrevAndNext(
				session, moiDeleteDocuments, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MOIDeleteDocuments getByStatus_PrevAndNext(
		Session session, MOIDeleteDocuments moiDeleteDocuments, String status,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MOIDELETEDOCUMENTS_WHERE);

		boolean bindStatus = false;

		if (status.isEmpty()) {
			sb.append(_FINDER_COLUMN_STATUS_STATUS_3);
		}
		else {
			bindStatus = true;

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MOIDeleteDocumentsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindStatus) {
			queryPos.add(status);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						moiDeleteDocuments)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MOIDeleteDocuments> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the moi delete documentses where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(String status) {
		for (MOIDeleteDocuments moiDeleteDocuments :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(moiDeleteDocuments);
		}
	}

	/**
	 * Returns the number of moi delete documentses where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching moi delete documentses
	 */
	@Override
	public int countByStatus(String status) {
		status = Objects.toString(status, "");

		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOIDELETEDOCUMENTS_WHERE);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_STATUS_STATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStatus) {
					queryPos.add(status);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"moiDeleteDocuments.status = ?";

	private static final String _FINDER_COLUMN_STATUS_STATUS_3 =
		"(moiDeleteDocuments.status IS NULL OR moiDeleteDocuments.status = '')";

	private FinderPath _finderPathWithPaginationFindByUpdatedBy;
	private FinderPath _finderPathWithoutPaginationFindByUpdatedBy;
	private FinderPath _finderPathCountByUpdatedBy;

	/**
	 * Returns all the moi delete documentses where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @return the matching moi delete documentses
	 */
	@Override
	public List<MOIDeleteDocuments> findByUpdatedBy(String updatedBy) {
		return findByUpdatedBy(
			updatedBy, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MOIDeleteDocuments> findByUpdatedBy(
		String updatedBy, int start, int end) {

		return findByUpdatedBy(updatedBy, start, end, null);
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
	@Override
	public List<MOIDeleteDocuments> findByUpdatedBy(
		String updatedBy, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return findByUpdatedBy(updatedBy, start, end, orderByComparator, true);
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
	@Override
	public List<MOIDeleteDocuments> findByUpdatedBy(
		String updatedBy, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean useFinderCache) {

		updatedBy = Objects.toString(updatedBy, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUpdatedBy;
				finderArgs = new Object[] {updatedBy};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUpdatedBy;
			finderArgs = new Object[] {
				updatedBy, start, end, orderByComparator
			};
		}

		List<MOIDeleteDocuments> list = null;

		if (useFinderCache) {
			list = (List<MOIDeleteDocuments>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOIDeleteDocuments moiDeleteDocuments : list) {
					if (!updatedBy.equals(moiDeleteDocuments.getUpdatedBy())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_MOIDELETEDOCUMENTS_WHERE);

			boolean bindUpdatedBy = false;

			if (updatedBy.isEmpty()) {
				sb.append(_FINDER_COLUMN_UPDATEDBY_UPDATEDBY_3);
			}
			else {
				bindUpdatedBy = true;

				sb.append(_FINDER_COLUMN_UPDATEDBY_UPDATEDBY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOIDeleteDocumentsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUpdatedBy) {
					queryPos.add(updatedBy);
				}

				list = (List<MOIDeleteDocuments>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first moi delete documents in the ordered set where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments findByUpdatedBy_First(
			String updatedBy,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws NoSuchMOIDeleteDocumentsException {

		MOIDeleteDocuments moiDeleteDocuments = fetchByUpdatedBy_First(
			updatedBy, orderByComparator);

		if (moiDeleteDocuments != null) {
			return moiDeleteDocuments;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("updatedBy=");
		sb.append(updatedBy);

		sb.append("}");

		throw new NoSuchMOIDeleteDocumentsException(sb.toString());
	}

	/**
	 * Returns the first moi delete documents in the ordered set where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments fetchByUpdatedBy_First(
		String updatedBy,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		List<MOIDeleteDocuments> list = findByUpdatedBy(
			updatedBy, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi delete documents in the ordered set where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments findByUpdatedBy_Last(
			String updatedBy,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws NoSuchMOIDeleteDocumentsException {

		MOIDeleteDocuments moiDeleteDocuments = fetchByUpdatedBy_Last(
			updatedBy, orderByComparator);

		if (moiDeleteDocuments != null) {
			return moiDeleteDocuments;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("updatedBy=");
		sb.append(updatedBy);

		sb.append("}");

		throw new NoSuchMOIDeleteDocumentsException(sb.toString());
	}

	/**
	 * Returns the last moi delete documents in the ordered set where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments fetchByUpdatedBy_Last(
		String updatedBy,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		int count = countByUpdatedBy(updatedBy);

		if (count == 0) {
			return null;
		}

		List<MOIDeleteDocuments> list = findByUpdatedBy(
			updatedBy, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MOIDeleteDocuments[] findByUpdatedBy_PrevAndNext(
			long documentId, String updatedBy,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws NoSuchMOIDeleteDocumentsException {

		updatedBy = Objects.toString(updatedBy, "");

		MOIDeleteDocuments moiDeleteDocuments = findByPrimaryKey(documentId);

		Session session = null;

		try {
			session = openSession();

			MOIDeleteDocuments[] array = new MOIDeleteDocumentsImpl[3];

			array[0] = getByUpdatedBy_PrevAndNext(
				session, moiDeleteDocuments, updatedBy, orderByComparator,
				true);

			array[1] = moiDeleteDocuments;

			array[2] = getByUpdatedBy_PrevAndNext(
				session, moiDeleteDocuments, updatedBy, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MOIDeleteDocuments getByUpdatedBy_PrevAndNext(
		Session session, MOIDeleteDocuments moiDeleteDocuments,
		String updatedBy,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MOIDELETEDOCUMENTS_WHERE);

		boolean bindUpdatedBy = false;

		if (updatedBy.isEmpty()) {
			sb.append(_FINDER_COLUMN_UPDATEDBY_UPDATEDBY_3);
		}
		else {
			bindUpdatedBy = true;

			sb.append(_FINDER_COLUMN_UPDATEDBY_UPDATEDBY_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MOIDeleteDocumentsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUpdatedBy) {
			queryPos.add(updatedBy);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						moiDeleteDocuments)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MOIDeleteDocuments> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the moi delete documentses where updatedBy = &#63; from the database.
	 *
	 * @param updatedBy the updated by
	 */
	@Override
	public void removeByUpdatedBy(String updatedBy) {
		for (MOIDeleteDocuments moiDeleteDocuments :
				findByUpdatedBy(
					updatedBy, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(moiDeleteDocuments);
		}
	}

	/**
	 * Returns the number of moi delete documentses where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @return the number of matching moi delete documentses
	 */
	@Override
	public int countByUpdatedBy(String updatedBy) {
		updatedBy = Objects.toString(updatedBy, "");

		FinderPath finderPath = _finderPathCountByUpdatedBy;

		Object[] finderArgs = new Object[] {updatedBy};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOIDELETEDOCUMENTS_WHERE);

			boolean bindUpdatedBy = false;

			if (updatedBy.isEmpty()) {
				sb.append(_FINDER_COLUMN_UPDATEDBY_UPDATEDBY_3);
			}
			else {
				bindUpdatedBy = true;

				sb.append(_FINDER_COLUMN_UPDATEDBY_UPDATEDBY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUpdatedBy) {
					queryPos.add(updatedBy);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UPDATEDBY_UPDATEDBY_2 =
		"moiDeleteDocuments.updatedBy = ?";

	private static final String _FINDER_COLUMN_UPDATEDBY_UPDATEDBY_3 =
		"(moiDeleteDocuments.updatedBy IS NULL OR moiDeleteDocuments.updatedBy = '')";

	private FinderPath _finderPathWithPaginationFindByUpdatedDate;
	private FinderPath _finderPathWithoutPaginationFindByUpdatedDate;
	private FinderPath _finderPathCountByUpdatedDate;

	/**
	 * Returns all the moi delete documentses where updatedDate = &#63;.
	 *
	 * @param updatedDate the updated date
	 * @return the matching moi delete documentses
	 */
	@Override
	public List<MOIDeleteDocuments> findByUpdatedDate(Date updatedDate) {
		return findByUpdatedDate(
			updatedDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MOIDeleteDocuments> findByUpdatedDate(
		Date updatedDate, int start, int end) {

		return findByUpdatedDate(updatedDate, start, end, null);
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
	@Override
	public List<MOIDeleteDocuments> findByUpdatedDate(
		Date updatedDate, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return findByUpdatedDate(
			updatedDate, start, end, orderByComparator, true);
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
	@Override
	public List<MOIDeleteDocuments> findByUpdatedDate(
		Date updatedDate, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUpdatedDate;
				finderArgs = new Object[] {_getTime(updatedDate)};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUpdatedDate;
			finderArgs = new Object[] {
				_getTime(updatedDate), start, end, orderByComparator
			};
		}

		List<MOIDeleteDocuments> list = null;

		if (useFinderCache) {
			list = (List<MOIDeleteDocuments>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOIDeleteDocuments moiDeleteDocuments : list) {
					if (!Objects.equals(
							updatedDate, moiDeleteDocuments.getUpdatedDate())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_MOIDELETEDOCUMENTS_WHERE);

			boolean bindUpdatedDate = false;

			if (updatedDate == null) {
				sb.append(_FINDER_COLUMN_UPDATEDDATE_UPDATEDDATE_1);
			}
			else {
				bindUpdatedDate = true;

				sb.append(_FINDER_COLUMN_UPDATEDDATE_UPDATEDDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOIDeleteDocumentsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUpdatedDate) {
					queryPos.add(new Timestamp(updatedDate.getTime()));
				}

				list = (List<MOIDeleteDocuments>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first moi delete documents in the ordered set where updatedDate = &#63;.
	 *
	 * @param updatedDate the updated date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments findByUpdatedDate_First(
			Date updatedDate,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws NoSuchMOIDeleteDocumentsException {

		MOIDeleteDocuments moiDeleteDocuments = fetchByUpdatedDate_First(
			updatedDate, orderByComparator);

		if (moiDeleteDocuments != null) {
			return moiDeleteDocuments;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("updatedDate=");
		sb.append(updatedDate);

		sb.append("}");

		throw new NoSuchMOIDeleteDocumentsException(sb.toString());
	}

	/**
	 * Returns the first moi delete documents in the ordered set where updatedDate = &#63;.
	 *
	 * @param updatedDate the updated date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments fetchByUpdatedDate_First(
		Date updatedDate,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		List<MOIDeleteDocuments> list = findByUpdatedDate(
			updatedDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi delete documents in the ordered set where updatedDate = &#63;.
	 *
	 * @param updatedDate the updated date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments findByUpdatedDate_Last(
			Date updatedDate,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws NoSuchMOIDeleteDocumentsException {

		MOIDeleteDocuments moiDeleteDocuments = fetchByUpdatedDate_Last(
			updatedDate, orderByComparator);

		if (moiDeleteDocuments != null) {
			return moiDeleteDocuments;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("updatedDate=");
		sb.append(updatedDate);

		sb.append("}");

		throw new NoSuchMOIDeleteDocumentsException(sb.toString());
	}

	/**
	 * Returns the last moi delete documents in the ordered set where updatedDate = &#63;.
	 *
	 * @param updatedDate the updated date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments fetchByUpdatedDate_Last(
		Date updatedDate,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		int count = countByUpdatedDate(updatedDate);

		if (count == 0) {
			return null;
		}

		List<MOIDeleteDocuments> list = findByUpdatedDate(
			updatedDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MOIDeleteDocuments[] findByUpdatedDate_PrevAndNext(
			long documentId, Date updatedDate,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws NoSuchMOIDeleteDocumentsException {

		MOIDeleteDocuments moiDeleteDocuments = findByPrimaryKey(documentId);

		Session session = null;

		try {
			session = openSession();

			MOIDeleteDocuments[] array = new MOIDeleteDocumentsImpl[3];

			array[0] = getByUpdatedDate_PrevAndNext(
				session, moiDeleteDocuments, updatedDate, orderByComparator,
				true);

			array[1] = moiDeleteDocuments;

			array[2] = getByUpdatedDate_PrevAndNext(
				session, moiDeleteDocuments, updatedDate, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MOIDeleteDocuments getByUpdatedDate_PrevAndNext(
		Session session, MOIDeleteDocuments moiDeleteDocuments,
		Date updatedDate,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MOIDELETEDOCUMENTS_WHERE);

		boolean bindUpdatedDate = false;

		if (updatedDate == null) {
			sb.append(_FINDER_COLUMN_UPDATEDDATE_UPDATEDDATE_1);
		}
		else {
			bindUpdatedDate = true;

			sb.append(_FINDER_COLUMN_UPDATEDDATE_UPDATEDDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MOIDeleteDocumentsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUpdatedDate) {
			queryPos.add(new Timestamp(updatedDate.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						moiDeleteDocuments)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MOIDeleteDocuments> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the moi delete documentses where updatedDate = &#63; from the database.
	 *
	 * @param updatedDate the updated date
	 */
	@Override
	public void removeByUpdatedDate(Date updatedDate) {
		for (MOIDeleteDocuments moiDeleteDocuments :
				findByUpdatedDate(
					updatedDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(moiDeleteDocuments);
		}
	}

	/**
	 * Returns the number of moi delete documentses where updatedDate = &#63;.
	 *
	 * @param updatedDate the updated date
	 * @return the number of matching moi delete documentses
	 */
	@Override
	public int countByUpdatedDate(Date updatedDate) {
		FinderPath finderPath = _finderPathCountByUpdatedDate;

		Object[] finderArgs = new Object[] {_getTime(updatedDate)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOIDELETEDOCUMENTS_WHERE);

			boolean bindUpdatedDate = false;

			if (updatedDate == null) {
				sb.append(_FINDER_COLUMN_UPDATEDDATE_UPDATEDDATE_1);
			}
			else {
				bindUpdatedDate = true;

				sb.append(_FINDER_COLUMN_UPDATEDDATE_UPDATEDDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUpdatedDate) {
					queryPos.add(new Timestamp(updatedDate.getTime()));
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UPDATEDDATE_UPDATEDDATE_1 =
		"moiDeleteDocuments.updatedDate IS NULL";

	private static final String _FINDER_COLUMN_UPDATEDDATE_UPDATEDDATE_2 =
		"moiDeleteDocuments.updatedDate = ?";

	private FinderPath _finderPathWithPaginationFindByPendingIdentifiers;
	private FinderPath _finderPathWithoutPaginationFindByPendingIdentifiers;
	private FinderPath _finderPathCountByPendingIdentifiers;

	/**
	 * Returns all the moi delete documentses where pendingIdentifiers = &#63;.
	 *
	 * @param pendingIdentifiers the pending identifiers
	 * @return the matching moi delete documentses
	 */
	@Override
	public List<MOIDeleteDocuments> findByPendingIdentifiers(
		String pendingIdentifiers) {

		return findByPendingIdentifiers(
			pendingIdentifiers, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MOIDeleteDocuments> findByPendingIdentifiers(
		String pendingIdentifiers, int start, int end) {

		return findByPendingIdentifiers(pendingIdentifiers, start, end, null);
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
	@Override
	public List<MOIDeleteDocuments> findByPendingIdentifiers(
		String pendingIdentifiers, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return findByPendingIdentifiers(
			pendingIdentifiers, start, end, orderByComparator, true);
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
	@Override
	public List<MOIDeleteDocuments> findByPendingIdentifiers(
		String pendingIdentifiers, int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean useFinderCache) {

		pendingIdentifiers = Objects.toString(pendingIdentifiers, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByPendingIdentifiers;
				finderArgs = new Object[] {pendingIdentifiers};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPendingIdentifiers;
			finderArgs = new Object[] {
				pendingIdentifiers, start, end, orderByComparator
			};
		}

		List<MOIDeleteDocuments> list = null;

		if (useFinderCache) {
			list = (List<MOIDeleteDocuments>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOIDeleteDocuments moiDeleteDocuments : list) {
					if (!pendingIdentifiers.equals(
							moiDeleteDocuments.getPendingIdentifiers())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_MOIDELETEDOCUMENTS_WHERE);

			boolean bindPendingIdentifiers = false;

			if (pendingIdentifiers.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PENDINGIDENTIFIERS_PENDINGIDENTIFIERS_3);
			}
			else {
				bindPendingIdentifiers = true;

				sb.append(
					_FINDER_COLUMN_PENDINGIDENTIFIERS_PENDINGIDENTIFIERS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOIDeleteDocumentsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPendingIdentifiers) {
					queryPos.add(pendingIdentifiers);
				}

				list = (List<MOIDeleteDocuments>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first moi delete documents in the ordered set where pendingIdentifiers = &#63;.
	 *
	 * @param pendingIdentifiers the pending identifiers
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments findByPendingIdentifiers_First(
			String pendingIdentifiers,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws NoSuchMOIDeleteDocumentsException {

		MOIDeleteDocuments moiDeleteDocuments = fetchByPendingIdentifiers_First(
			pendingIdentifiers, orderByComparator);

		if (moiDeleteDocuments != null) {
			return moiDeleteDocuments;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("pendingIdentifiers=");
		sb.append(pendingIdentifiers);

		sb.append("}");

		throw new NoSuchMOIDeleteDocumentsException(sb.toString());
	}

	/**
	 * Returns the first moi delete documents in the ordered set where pendingIdentifiers = &#63;.
	 *
	 * @param pendingIdentifiers the pending identifiers
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments fetchByPendingIdentifiers_First(
		String pendingIdentifiers,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		List<MOIDeleteDocuments> list = findByPendingIdentifiers(
			pendingIdentifiers, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi delete documents in the ordered set where pendingIdentifiers = &#63;.
	 *
	 * @param pendingIdentifiers the pending identifiers
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments findByPendingIdentifiers_Last(
			String pendingIdentifiers,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws NoSuchMOIDeleteDocumentsException {

		MOIDeleteDocuments moiDeleteDocuments = fetchByPendingIdentifiers_Last(
			pendingIdentifiers, orderByComparator);

		if (moiDeleteDocuments != null) {
			return moiDeleteDocuments;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("pendingIdentifiers=");
		sb.append(pendingIdentifiers);

		sb.append("}");

		throw new NoSuchMOIDeleteDocumentsException(sb.toString());
	}

	/**
	 * Returns the last moi delete documents in the ordered set where pendingIdentifiers = &#63;.
	 *
	 * @param pendingIdentifiers the pending identifiers
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi delete documents, or <code>null</code> if a matching moi delete documents could not be found
	 */
	@Override
	public MOIDeleteDocuments fetchByPendingIdentifiers_Last(
		String pendingIdentifiers,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		int count = countByPendingIdentifiers(pendingIdentifiers);

		if (count == 0) {
			return null;
		}

		List<MOIDeleteDocuments> list = findByPendingIdentifiers(
			pendingIdentifiers, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MOIDeleteDocuments[] findByPendingIdentifiers_PrevAndNext(
			long documentId, String pendingIdentifiers,
			OrderByComparator<MOIDeleteDocuments> orderByComparator)
		throws NoSuchMOIDeleteDocumentsException {

		pendingIdentifiers = Objects.toString(pendingIdentifiers, "");

		MOIDeleteDocuments moiDeleteDocuments = findByPrimaryKey(documentId);

		Session session = null;

		try {
			session = openSession();

			MOIDeleteDocuments[] array = new MOIDeleteDocumentsImpl[3];

			array[0] = getByPendingIdentifiers_PrevAndNext(
				session, moiDeleteDocuments, pendingIdentifiers,
				orderByComparator, true);

			array[1] = moiDeleteDocuments;

			array[2] = getByPendingIdentifiers_PrevAndNext(
				session, moiDeleteDocuments, pendingIdentifiers,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MOIDeleteDocuments getByPendingIdentifiers_PrevAndNext(
		Session session, MOIDeleteDocuments moiDeleteDocuments,
		String pendingIdentifiers,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MOIDELETEDOCUMENTS_WHERE);

		boolean bindPendingIdentifiers = false;

		if (pendingIdentifiers.isEmpty()) {
			sb.append(_FINDER_COLUMN_PENDINGIDENTIFIERS_PENDINGIDENTIFIERS_3);
		}
		else {
			bindPendingIdentifiers = true;

			sb.append(_FINDER_COLUMN_PENDINGIDENTIFIERS_PENDINGIDENTIFIERS_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MOIDeleteDocumentsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPendingIdentifiers) {
			queryPos.add(pendingIdentifiers);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						moiDeleteDocuments)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MOIDeleteDocuments> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the moi delete documentses where pendingIdentifiers = &#63; from the database.
	 *
	 * @param pendingIdentifiers the pending identifiers
	 */
	@Override
	public void removeByPendingIdentifiers(String pendingIdentifiers) {
		for (MOIDeleteDocuments moiDeleteDocuments :
				findByPendingIdentifiers(
					pendingIdentifiers, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(moiDeleteDocuments);
		}
	}

	/**
	 * Returns the number of moi delete documentses where pendingIdentifiers = &#63;.
	 *
	 * @param pendingIdentifiers the pending identifiers
	 * @return the number of matching moi delete documentses
	 */
	@Override
	public int countByPendingIdentifiers(String pendingIdentifiers) {
		pendingIdentifiers = Objects.toString(pendingIdentifiers, "");

		FinderPath finderPath = _finderPathCountByPendingIdentifiers;

		Object[] finderArgs = new Object[] {pendingIdentifiers};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOIDELETEDOCUMENTS_WHERE);

			boolean bindPendingIdentifiers = false;

			if (pendingIdentifiers.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PENDINGIDENTIFIERS_PENDINGIDENTIFIERS_3);
			}
			else {
				bindPendingIdentifiers = true;

				sb.append(
					_FINDER_COLUMN_PENDINGIDENTIFIERS_PENDINGIDENTIFIERS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPendingIdentifiers) {
					queryPos.add(pendingIdentifiers);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_PENDINGIDENTIFIERS_PENDINGIDENTIFIERS_2 =
			"moiDeleteDocuments.pendingIdentifiers = ?";

	private static final String
		_FINDER_COLUMN_PENDINGIDENTIFIERS_PENDINGIDENTIFIERS_3 =
			"(moiDeleteDocuments.pendingIdentifiers IS NULL OR moiDeleteDocuments.pendingIdentifiers = '')";

	public MOIDeleteDocumentsPersistenceImpl() {
		setModelClass(MOIDeleteDocuments.class);

		setModelImplClass(MOIDeleteDocumentsImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the moi delete documents in the entity cache if it is enabled.
	 *
	 * @param moiDeleteDocuments the moi delete documents
	 */
	@Override
	public void cacheResult(MOIDeleteDocuments moiDeleteDocuments) {
		entityCache.putResult(
			entityCacheEnabled, MOIDeleteDocumentsImpl.class,
			moiDeleteDocuments.getPrimaryKey(), moiDeleteDocuments);

		moiDeleteDocuments.resetOriginalValues();
	}

	/**
	 * Caches the moi delete documentses in the entity cache if it is enabled.
	 *
	 * @param moiDeleteDocumentses the moi delete documentses
	 */
	@Override
	public void cacheResult(List<MOIDeleteDocuments> moiDeleteDocumentses) {
		for (MOIDeleteDocuments moiDeleteDocuments : moiDeleteDocumentses) {
			if (entityCache.getResult(
					entityCacheEnabled, MOIDeleteDocumentsImpl.class,
					moiDeleteDocuments.getPrimaryKey()) == null) {

				cacheResult(moiDeleteDocuments);
			}
			else {
				moiDeleteDocuments.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all moi delete documentses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MOIDeleteDocumentsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the moi delete documents.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MOIDeleteDocuments moiDeleteDocuments) {
		entityCache.removeResult(
			entityCacheEnabled, MOIDeleteDocumentsImpl.class,
			moiDeleteDocuments.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MOIDeleteDocuments> moiDeleteDocumentses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MOIDeleteDocuments moiDeleteDocuments : moiDeleteDocumentses) {
			entityCache.removeResult(
				entityCacheEnabled, MOIDeleteDocumentsImpl.class,
				moiDeleteDocuments.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, MOIDeleteDocumentsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new moi delete documents with the primary key. Does not add the moi delete documents to the database.
	 *
	 * @param documentId the primary key for the new moi delete documents
	 * @return the new moi delete documents
	 */
	@Override
	public MOIDeleteDocuments create(long documentId) {
		MOIDeleteDocuments moiDeleteDocuments = new MOIDeleteDocumentsImpl();

		moiDeleteDocuments.setNew(true);
		moiDeleteDocuments.setPrimaryKey(documentId);

		return moiDeleteDocuments;
	}

	/**
	 * Removes the moi delete documents with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentId the primary key of the moi delete documents
	 * @return the moi delete documents that was removed
	 * @throws NoSuchMOIDeleteDocumentsException if a moi delete documents with the primary key could not be found
	 */
	@Override
	public MOIDeleteDocuments remove(long documentId)
		throws NoSuchMOIDeleteDocumentsException {

		return remove((Serializable)documentId);
	}

	/**
	 * Removes the moi delete documents with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the moi delete documents
	 * @return the moi delete documents that was removed
	 * @throws NoSuchMOIDeleteDocumentsException if a moi delete documents with the primary key could not be found
	 */
	@Override
	public MOIDeleteDocuments remove(Serializable primaryKey)
		throws NoSuchMOIDeleteDocumentsException {

		Session session = null;

		try {
			session = openSession();

			MOIDeleteDocuments moiDeleteDocuments =
				(MOIDeleteDocuments)session.get(
					MOIDeleteDocumentsImpl.class, primaryKey);

			if (moiDeleteDocuments == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMOIDeleteDocumentsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(moiDeleteDocuments);
		}
		catch (NoSuchMOIDeleteDocumentsException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected MOIDeleteDocuments removeImpl(
		MOIDeleteDocuments moiDeleteDocuments) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(moiDeleteDocuments)) {
				moiDeleteDocuments = (MOIDeleteDocuments)session.get(
					MOIDeleteDocumentsImpl.class,
					moiDeleteDocuments.getPrimaryKeyObj());
			}

			if (moiDeleteDocuments != null) {
				session.delete(moiDeleteDocuments);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (moiDeleteDocuments != null) {
			clearCache(moiDeleteDocuments);
		}

		return moiDeleteDocuments;
	}

	@Override
	public MOIDeleteDocuments updateImpl(
		MOIDeleteDocuments moiDeleteDocuments) {

		boolean isNew = moiDeleteDocuments.isNew();

		if (!(moiDeleteDocuments instanceof MOIDeleteDocumentsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(moiDeleteDocuments.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					moiDeleteDocuments);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in moiDeleteDocuments proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MOIDeleteDocuments implementation " +
					moiDeleteDocuments.getClass());
		}

		MOIDeleteDocumentsModelImpl moiDeleteDocumentsModelImpl =
			(MOIDeleteDocumentsModelImpl)moiDeleteDocuments;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(moiDeleteDocuments);

				moiDeleteDocuments.setNew(false);
			}
			else {
				moiDeleteDocuments = (MOIDeleteDocuments)session.merge(
					moiDeleteDocuments);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				moiDeleteDocumentsModelImpl.getDocumentId()
			};

			finderCache.removeResult(_finderPathCountByDocumentId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDocumentId, args);

			args = new Object[] {moiDeleteDocumentsModelImpl.getFileEntryId()};

			finderCache.removeResult(_finderPathCountByFileEntryId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFileEntryId, args);

			args = new Object[] {
				moiDeleteDocumentsModelImpl.getFileEntryName()
			};

			finderCache.removeResult(_finderPathCountByFileEntryName, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFileEntryName, args);

			args = new Object[] {moiDeleteDocumentsModelImpl.getConsumerCode()};

			finderCache.removeResult(_finderPathCountByConsumerCode, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByConsumerCode, args);

			args = new Object[] {moiDeleteDocumentsModelImpl.getModuleType()};

			finderCache.removeResult(_finderPathCountByModuleType, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByModuleType, args);

			args = new Object[] {moiDeleteDocumentsModelImpl.getUploadedBy()};

			finderCache.removeResult(_finderPathCountByUploadedBy, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUploadedBy, args);

			args = new Object[] {moiDeleteDocumentsModelImpl.getUploadedDate()};

			finderCache.removeResult(_finderPathCountByUploadedDate, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUploadedDate, args);

			args = new Object[] {moiDeleteDocumentsModelImpl.getStatus()};

			finderCache.removeResult(_finderPathCountByStatus, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByStatus, args);

			args = new Object[] {moiDeleteDocumentsModelImpl.getUpdatedBy()};

			finderCache.removeResult(_finderPathCountByUpdatedBy, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUpdatedBy, args);

			args = new Object[] {moiDeleteDocumentsModelImpl.getUpdatedDate()};

			finderCache.removeResult(_finderPathCountByUpdatedDate, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUpdatedDate, args);

			args = new Object[] {
				moiDeleteDocumentsModelImpl.getPendingIdentifiers()
			};

			finderCache.removeResult(
				_finderPathCountByPendingIdentifiers, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByPendingIdentifiers, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((moiDeleteDocumentsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDocumentId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					moiDeleteDocumentsModelImpl.getOriginalDocumentId()
				};

				finderCache.removeResult(_finderPathCountByDocumentId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocumentId, args);

				args = new Object[] {
					moiDeleteDocumentsModelImpl.getDocumentId()
				};

				finderCache.removeResult(_finderPathCountByDocumentId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocumentId, args);
			}

			if ((moiDeleteDocumentsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFileEntryId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					moiDeleteDocumentsModelImpl.getOriginalFileEntryId()
				};

				finderCache.removeResult(_finderPathCountByFileEntryId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFileEntryId, args);

				args = new Object[] {
					moiDeleteDocumentsModelImpl.getFileEntryId()
				};

				finderCache.removeResult(_finderPathCountByFileEntryId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFileEntryId, args);
			}

			if ((moiDeleteDocumentsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFileEntryName.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					moiDeleteDocumentsModelImpl.getOriginalFileEntryName()
				};

				finderCache.removeResult(_finderPathCountByFileEntryName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFileEntryName, args);

				args = new Object[] {
					moiDeleteDocumentsModelImpl.getFileEntryName()
				};

				finderCache.removeResult(_finderPathCountByFileEntryName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFileEntryName, args);
			}

			if ((moiDeleteDocumentsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByConsumerCode.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					moiDeleteDocumentsModelImpl.getOriginalConsumerCode()
				};

				finderCache.removeResult(_finderPathCountByConsumerCode, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByConsumerCode, args);

				args = new Object[] {
					moiDeleteDocumentsModelImpl.getConsumerCode()
				};

				finderCache.removeResult(_finderPathCountByConsumerCode, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByConsumerCode, args);
			}

			if ((moiDeleteDocumentsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByModuleType.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					moiDeleteDocumentsModelImpl.getOriginalModuleType()
				};

				finderCache.removeResult(_finderPathCountByModuleType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByModuleType, args);

				args = new Object[] {
					moiDeleteDocumentsModelImpl.getModuleType()
				};

				finderCache.removeResult(_finderPathCountByModuleType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByModuleType, args);
			}

			if ((moiDeleteDocumentsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUploadedBy.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					moiDeleteDocumentsModelImpl.getOriginalUploadedBy()
				};

				finderCache.removeResult(_finderPathCountByUploadedBy, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUploadedBy, args);

				args = new Object[] {
					moiDeleteDocumentsModelImpl.getUploadedBy()
				};

				finderCache.removeResult(_finderPathCountByUploadedBy, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUploadedBy, args);
			}

			if ((moiDeleteDocumentsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUploadedDate.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					moiDeleteDocumentsModelImpl.getOriginalUploadedDate()
				};

				finderCache.removeResult(_finderPathCountByUploadedDate, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUploadedDate, args);

				args = new Object[] {
					moiDeleteDocumentsModelImpl.getUploadedDate()
				};

				finderCache.removeResult(_finderPathCountByUploadedDate, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUploadedDate, args);
			}

			if ((moiDeleteDocumentsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByStatus.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					moiDeleteDocumentsModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatus, args);

				args = new Object[] {moiDeleteDocumentsModelImpl.getStatus()};

				finderCache.removeResult(_finderPathCountByStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatus, args);
			}

			if ((moiDeleteDocumentsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUpdatedBy.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					moiDeleteDocumentsModelImpl.getOriginalUpdatedBy()
				};

				finderCache.removeResult(_finderPathCountByUpdatedBy, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUpdatedBy, args);

				args = new Object[] {
					moiDeleteDocumentsModelImpl.getUpdatedBy()
				};

				finderCache.removeResult(_finderPathCountByUpdatedBy, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUpdatedBy, args);
			}

			if ((moiDeleteDocumentsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUpdatedDate.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					moiDeleteDocumentsModelImpl.getOriginalUpdatedDate()
				};

				finderCache.removeResult(_finderPathCountByUpdatedDate, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUpdatedDate, args);

				args = new Object[] {
					moiDeleteDocumentsModelImpl.getUpdatedDate()
				};

				finderCache.removeResult(_finderPathCountByUpdatedDate, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUpdatedDate, args);
			}

			if ((moiDeleteDocumentsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByPendingIdentifiers.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					moiDeleteDocumentsModelImpl.getOriginalPendingIdentifiers()
				};

				finderCache.removeResult(
					_finderPathCountByPendingIdentifiers, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByPendingIdentifiers, args);

				args = new Object[] {
					moiDeleteDocumentsModelImpl.getPendingIdentifiers()
				};

				finderCache.removeResult(
					_finderPathCountByPendingIdentifiers, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByPendingIdentifiers, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, MOIDeleteDocumentsImpl.class,
			moiDeleteDocuments.getPrimaryKey(), moiDeleteDocuments, false);

		moiDeleteDocuments.resetOriginalValues();

		return moiDeleteDocuments;
	}

	/**
	 * Returns the moi delete documents with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the moi delete documents
	 * @return the moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a moi delete documents with the primary key could not be found
	 */
	@Override
	public MOIDeleteDocuments findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMOIDeleteDocumentsException {

		MOIDeleteDocuments moiDeleteDocuments = fetchByPrimaryKey(primaryKey);

		if (moiDeleteDocuments == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMOIDeleteDocumentsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return moiDeleteDocuments;
	}

	/**
	 * Returns the moi delete documents with the primary key or throws a <code>NoSuchMOIDeleteDocumentsException</code> if it could not be found.
	 *
	 * @param documentId the primary key of the moi delete documents
	 * @return the moi delete documents
	 * @throws NoSuchMOIDeleteDocumentsException if a moi delete documents with the primary key could not be found
	 */
	@Override
	public MOIDeleteDocuments findByPrimaryKey(long documentId)
		throws NoSuchMOIDeleteDocumentsException {

		return findByPrimaryKey((Serializable)documentId);
	}

	/**
	 * Returns the moi delete documents with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param documentId the primary key of the moi delete documents
	 * @return the moi delete documents, or <code>null</code> if a moi delete documents with the primary key could not be found
	 */
	@Override
	public MOIDeleteDocuments fetchByPrimaryKey(long documentId) {
		return fetchByPrimaryKey((Serializable)documentId);
	}

	/**
	 * Returns all the moi delete documentses.
	 *
	 * @return the moi delete documentses
	 */
	@Override
	public List<MOIDeleteDocuments> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MOIDeleteDocuments> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<MOIDeleteDocuments> findAll(
		int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<MOIDeleteDocuments> findAll(
		int start, int end,
		OrderByComparator<MOIDeleteDocuments> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<MOIDeleteDocuments> list = null;

		if (useFinderCache) {
			list = (List<MOIDeleteDocuments>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MOIDELETEDOCUMENTS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MOIDELETEDOCUMENTS;

				sql = sql.concat(MOIDeleteDocumentsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MOIDeleteDocuments>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the moi delete documentses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MOIDeleteDocuments moiDeleteDocuments : findAll()) {
			remove(moiDeleteDocuments);
		}
	}

	/**
	 * Returns the number of moi delete documentses.
	 *
	 * @return the number of moi delete documentses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_MOIDELETEDOCUMENTS);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "documentId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MOIDELETEDOCUMENTS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MOIDeleteDocumentsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the moi delete documents persistence.
	 */
	@Activate
	public void activate() {
		MOIDeleteDocumentsModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		MOIDeleteDocumentsModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			MOIDeleteDocumentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			MOIDeleteDocumentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByDocumentId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			MOIDeleteDocumentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDocumentId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDocumentId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			MOIDeleteDocumentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDocumentId",
			new String[] {Long.class.getName()},
			MOIDeleteDocumentsModelImpl.DOCUMENTID_COLUMN_BITMASK);

		_finderPathCountByDocumentId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDocumentId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByFileEntryId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			MOIDeleteDocumentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFileEntryId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFileEntryId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			MOIDeleteDocumentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFileEntryId",
			new String[] {Long.class.getName()},
			MOIDeleteDocumentsModelImpl.FILEENTRYID_COLUMN_BITMASK);

		_finderPathCountByFileEntryId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFileEntryId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByFileEntryName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			MOIDeleteDocumentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFileEntryName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFileEntryName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			MOIDeleteDocumentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFileEntryName",
			new String[] {String.class.getName()},
			MOIDeleteDocumentsModelImpl.FILEENTRYNAME_COLUMN_BITMASK);

		_finderPathCountByFileEntryName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFileEntryName",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByConsumerCode = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			MOIDeleteDocumentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByConsumerCode",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByConsumerCode = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			MOIDeleteDocumentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByConsumerCode",
			new String[] {String.class.getName()},
			MOIDeleteDocumentsModelImpl.CONSUMERCODE_COLUMN_BITMASK);

		_finderPathCountByConsumerCode = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByConsumerCode",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByModuleType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			MOIDeleteDocumentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByModuleType",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByModuleType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			MOIDeleteDocumentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByModuleType",
			new String[] {String.class.getName()},
			MOIDeleteDocumentsModelImpl.MODULETYPE_COLUMN_BITMASK);

		_finderPathCountByModuleType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByModuleType",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByUploadedBy = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			MOIDeleteDocumentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUploadedBy",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUploadedBy = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			MOIDeleteDocumentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUploadedBy",
			new String[] {String.class.getName()},
			MOIDeleteDocumentsModelImpl.UPLOADEDBY_COLUMN_BITMASK);

		_finderPathCountByUploadedBy = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUploadedBy",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByUploadedDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			MOIDeleteDocumentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUploadedDate",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUploadedDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			MOIDeleteDocumentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUploadedDate",
			new String[] {Date.class.getName()},
			MOIDeleteDocumentsModelImpl.UPLOADEDDATE_COLUMN_BITMASK);

		_finderPathCountByUploadedDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUploadedDate",
			new String[] {Date.class.getName()});

		_finderPathWithPaginationFindByStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			MOIDeleteDocumentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			MOIDeleteDocumentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {String.class.getName()},
			MOIDeleteDocumentsModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByUpdatedBy = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			MOIDeleteDocumentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUpdatedBy",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUpdatedBy = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			MOIDeleteDocumentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUpdatedBy",
			new String[] {String.class.getName()},
			MOIDeleteDocumentsModelImpl.UPDATEDBY_COLUMN_BITMASK);

		_finderPathCountByUpdatedBy = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUpdatedBy",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByUpdatedDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			MOIDeleteDocumentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUpdatedDate",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUpdatedDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			MOIDeleteDocumentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUpdatedDate",
			new String[] {Date.class.getName()},
			MOIDeleteDocumentsModelImpl.UPDATEDDATE_COLUMN_BITMASK);

		_finderPathCountByUpdatedDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUpdatedDate",
			new String[] {Date.class.getName()});

		_finderPathWithPaginationFindByPendingIdentifiers = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			MOIDeleteDocumentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPendingIdentifiers",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByPendingIdentifiers = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			MOIDeleteDocumentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPendingIdentifiers", new String[] {String.class.getName()},
			MOIDeleteDocumentsModelImpl.PENDINGIDENTIFIERS_COLUMN_BITMASK);

		_finderPathCountByPendingIdentifiers = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPendingIdentifiers", new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(MOIDeleteDocumentsImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = moiddPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		entityCacheEnabled = false;
		finderCacheEnabled = false;

		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.moi.dms.delete.documents.model.MOIDeleteDocuments"),
			true);
	}

	@Override
	@Reference(
		target = moiddPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = moiddPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_MOIDELETEDOCUMENTS =
		"SELECT moiDeleteDocuments FROM MOIDeleteDocuments moiDeleteDocuments";

	private static final String _SQL_SELECT_MOIDELETEDOCUMENTS_WHERE =
		"SELECT moiDeleteDocuments FROM MOIDeleteDocuments moiDeleteDocuments WHERE ";

	private static final String _SQL_COUNT_MOIDELETEDOCUMENTS =
		"SELECT COUNT(moiDeleteDocuments) FROM MOIDeleteDocuments moiDeleteDocuments";

	private static final String _SQL_COUNT_MOIDELETEDOCUMENTS_WHERE =
		"SELECT COUNT(moiDeleteDocuments) FROM MOIDeleteDocuments moiDeleteDocuments WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "moiDeleteDocuments.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MOIDeleteDocuments exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MOIDeleteDocuments exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MOIDeleteDocumentsPersistenceImpl.class);

	static {
		try {
			Class.forName(moiddPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}