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

package com.moi.dms.audit.service.persistence.impl;

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

import com.moi.dms.audit.exception.NoSuchMOIAuditException;
import com.moi.dms.audit.model.MOIAudit;
import com.moi.dms.audit.model.impl.MOIAuditImpl;
import com.moi.dms.audit.model.impl.MOIAuditModelImpl;
import com.moi.dms.audit.service.persistence.MOIAuditPersistence;
import com.moi.dms.audit.service.persistence.impl.constants.moiauditPersistenceConstants;

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
 * The persistence implementation for the moi audit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = MOIAuditPersistence.class)
public class MOIAuditPersistenceImpl
	extends BasePersistenceImpl<MOIAudit> implements MOIAuditPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MOIAuditUtil</code> to access the moi audit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MOIAuditImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByAuditId;
	private FinderPath _finderPathWithoutPaginationFindByAuditId;
	private FinderPath _finderPathCountByAuditId;

	/**
	 * Returns all the moi audits where auditId = &#63;.
	 *
	 * @param auditId the audit ID
	 * @return the matching moi audits
	 */
	@Override
	public List<MOIAudit> findByAuditId(long auditId) {
		return findByAuditId(
			auditId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the moi audits where auditId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIAuditModelImpl</code>.
	 * </p>
	 *
	 * @param auditId the audit ID
	 * @param start the lower bound of the range of moi audits
	 * @param end the upper bound of the range of moi audits (not inclusive)
	 * @return the range of matching moi audits
	 */
	@Override
	public List<MOIAudit> findByAuditId(long auditId, int start, int end) {
		return findByAuditId(auditId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the moi audits where auditId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIAuditModelImpl</code>.
	 * </p>
	 *
	 * @param auditId the audit ID
	 * @param start the lower bound of the range of moi audits
	 * @param end the upper bound of the range of moi audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi audits
	 */
	@Override
	public List<MOIAudit> findByAuditId(
		long auditId, int start, int end,
		OrderByComparator<MOIAudit> orderByComparator) {

		return findByAuditId(auditId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the moi audits where auditId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIAuditModelImpl</code>.
	 * </p>
	 *
	 * @param auditId the audit ID
	 * @param start the lower bound of the range of moi audits
	 * @param end the upper bound of the range of moi audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi audits
	 */
	@Override
	public List<MOIAudit> findByAuditId(
		long auditId, int start, int end,
		OrderByComparator<MOIAudit> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAuditId;
				finderArgs = new Object[] {auditId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAuditId;
			finderArgs = new Object[] {auditId, start, end, orderByComparator};
		}

		List<MOIAudit> list = null;

		if (useFinderCache) {
			list = (List<MOIAudit>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOIAudit moiAudit : list) {
					if (auditId != moiAudit.getAuditId()) {
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

			sb.append(_SQL_SELECT_MOIAUDIT_WHERE);

			sb.append(_FINDER_COLUMN_AUDITID_AUDITID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOIAuditModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(auditId);

				list = (List<MOIAudit>)QueryUtil.list(
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
	 * Returns the first moi audit in the ordered set where auditId = &#63;.
	 *
	 * @param auditId the audit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	@Override
	public MOIAudit findByAuditId_First(
			long auditId, OrderByComparator<MOIAudit> orderByComparator)
		throws NoSuchMOIAuditException {

		MOIAudit moiAudit = fetchByAuditId_First(auditId, orderByComparator);

		if (moiAudit != null) {
			return moiAudit;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("auditId=");
		sb.append(auditId);

		sb.append("}");

		throw new NoSuchMOIAuditException(sb.toString());
	}

	/**
	 * Returns the first moi audit in the ordered set where auditId = &#63;.
	 *
	 * @param auditId the audit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	@Override
	public MOIAudit fetchByAuditId_First(
		long auditId, OrderByComparator<MOIAudit> orderByComparator) {

		List<MOIAudit> list = findByAuditId(auditId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi audit in the ordered set where auditId = &#63;.
	 *
	 * @param auditId the audit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	@Override
	public MOIAudit findByAuditId_Last(
			long auditId, OrderByComparator<MOIAudit> orderByComparator)
		throws NoSuchMOIAuditException {

		MOIAudit moiAudit = fetchByAuditId_Last(auditId, orderByComparator);

		if (moiAudit != null) {
			return moiAudit;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("auditId=");
		sb.append(auditId);

		sb.append("}");

		throw new NoSuchMOIAuditException(sb.toString());
	}

	/**
	 * Returns the last moi audit in the ordered set where auditId = &#63;.
	 *
	 * @param auditId the audit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	@Override
	public MOIAudit fetchByAuditId_Last(
		long auditId, OrderByComparator<MOIAudit> orderByComparator) {

		int count = countByAuditId(auditId);

		if (count == 0) {
			return null;
		}

		List<MOIAudit> list = findByAuditId(
			auditId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the moi audits where auditId = &#63; from the database.
	 *
	 * @param auditId the audit ID
	 */
	@Override
	public void removeByAuditId(long auditId) {
		for (MOIAudit moiAudit :
				findByAuditId(
					auditId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(moiAudit);
		}
	}

	/**
	 * Returns the number of moi audits where auditId = &#63;.
	 *
	 * @param auditId the audit ID
	 * @return the number of matching moi audits
	 */
	@Override
	public int countByAuditId(long auditId) {
		FinderPath finderPath = _finderPathCountByAuditId;

		Object[] finderArgs = new Object[] {auditId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOIAUDIT_WHERE);

			sb.append(_FINDER_COLUMN_AUDITID_AUDITID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(auditId);

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

	private static final String _FINDER_COLUMN_AUDITID_AUDITID_2 =
		"moiAudit.auditId = ?";

	private FinderPath _finderPathWithPaginationFindByActionPerformedBy;
	private FinderPath _finderPathWithoutPaginationFindByActionPerformedBy;
	private FinderPath _finderPathCountByActionPerformedBy;

	/**
	 * Returns all the moi audits where actionPerformedBy = &#63;.
	 *
	 * @param actionPerformedBy the action performed by
	 * @return the matching moi audits
	 */
	@Override
	public List<MOIAudit> findByActionPerformedBy(String actionPerformedBy) {
		return findByActionPerformedBy(
			actionPerformedBy, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the moi audits where actionPerformedBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIAuditModelImpl</code>.
	 * </p>
	 *
	 * @param actionPerformedBy the action performed by
	 * @param start the lower bound of the range of moi audits
	 * @param end the upper bound of the range of moi audits (not inclusive)
	 * @return the range of matching moi audits
	 */
	@Override
	public List<MOIAudit> findByActionPerformedBy(
		String actionPerformedBy, int start, int end) {

		return findByActionPerformedBy(actionPerformedBy, start, end, null);
	}

	/**
	 * Returns an ordered range of all the moi audits where actionPerformedBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIAuditModelImpl</code>.
	 * </p>
	 *
	 * @param actionPerformedBy the action performed by
	 * @param start the lower bound of the range of moi audits
	 * @param end the upper bound of the range of moi audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi audits
	 */
	@Override
	public List<MOIAudit> findByActionPerformedBy(
		String actionPerformedBy, int start, int end,
		OrderByComparator<MOIAudit> orderByComparator) {

		return findByActionPerformedBy(
			actionPerformedBy, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the moi audits where actionPerformedBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIAuditModelImpl</code>.
	 * </p>
	 *
	 * @param actionPerformedBy the action performed by
	 * @param start the lower bound of the range of moi audits
	 * @param end the upper bound of the range of moi audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi audits
	 */
	@Override
	public List<MOIAudit> findByActionPerformedBy(
		String actionPerformedBy, int start, int end,
		OrderByComparator<MOIAudit> orderByComparator, boolean useFinderCache) {

		actionPerformedBy = Objects.toString(actionPerformedBy, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByActionPerformedBy;
				finderArgs = new Object[] {actionPerformedBy};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByActionPerformedBy;
			finderArgs = new Object[] {
				actionPerformedBy, start, end, orderByComparator
			};
		}

		List<MOIAudit> list = null;

		if (useFinderCache) {
			list = (List<MOIAudit>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOIAudit moiAudit : list) {
					if (!actionPerformedBy.equals(
							moiAudit.getActionPerformedBy())) {

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

			sb.append(_SQL_SELECT_MOIAUDIT_WHERE);

			boolean bindActionPerformedBy = false;

			if (actionPerformedBy.isEmpty()) {
				sb.append(_FINDER_COLUMN_ACTIONPERFORMEDBY_ACTIONPERFORMEDBY_3);
			}
			else {
				bindActionPerformedBy = true;

				sb.append(_FINDER_COLUMN_ACTIONPERFORMEDBY_ACTIONPERFORMEDBY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOIAuditModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindActionPerformedBy) {
					queryPos.add(actionPerformedBy);
				}

				list = (List<MOIAudit>)QueryUtil.list(
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
	 * Returns the first moi audit in the ordered set where actionPerformedBy = &#63;.
	 *
	 * @param actionPerformedBy the action performed by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	@Override
	public MOIAudit findByActionPerformedBy_First(
			String actionPerformedBy,
			OrderByComparator<MOIAudit> orderByComparator)
		throws NoSuchMOIAuditException {

		MOIAudit moiAudit = fetchByActionPerformedBy_First(
			actionPerformedBy, orderByComparator);

		if (moiAudit != null) {
			return moiAudit;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("actionPerformedBy=");
		sb.append(actionPerformedBy);

		sb.append("}");

		throw new NoSuchMOIAuditException(sb.toString());
	}

	/**
	 * Returns the first moi audit in the ordered set where actionPerformedBy = &#63;.
	 *
	 * @param actionPerformedBy the action performed by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	@Override
	public MOIAudit fetchByActionPerformedBy_First(
		String actionPerformedBy,
		OrderByComparator<MOIAudit> orderByComparator) {

		List<MOIAudit> list = findByActionPerformedBy(
			actionPerformedBy, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi audit in the ordered set where actionPerformedBy = &#63;.
	 *
	 * @param actionPerformedBy the action performed by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	@Override
	public MOIAudit findByActionPerformedBy_Last(
			String actionPerformedBy,
			OrderByComparator<MOIAudit> orderByComparator)
		throws NoSuchMOIAuditException {

		MOIAudit moiAudit = fetchByActionPerformedBy_Last(
			actionPerformedBy, orderByComparator);

		if (moiAudit != null) {
			return moiAudit;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("actionPerformedBy=");
		sb.append(actionPerformedBy);

		sb.append("}");

		throw new NoSuchMOIAuditException(sb.toString());
	}

	/**
	 * Returns the last moi audit in the ordered set where actionPerformedBy = &#63;.
	 *
	 * @param actionPerformedBy the action performed by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	@Override
	public MOIAudit fetchByActionPerformedBy_Last(
		String actionPerformedBy,
		OrderByComparator<MOIAudit> orderByComparator) {

		int count = countByActionPerformedBy(actionPerformedBy);

		if (count == 0) {
			return null;
		}

		List<MOIAudit> list = findByActionPerformedBy(
			actionPerformedBy, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the moi audits before and after the current moi audit in the ordered set where actionPerformedBy = &#63;.
	 *
	 * @param auditId the primary key of the current moi audit
	 * @param actionPerformedBy the action performed by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi audit
	 * @throws NoSuchMOIAuditException if a moi audit with the primary key could not be found
	 */
	@Override
	public MOIAudit[] findByActionPerformedBy_PrevAndNext(
			long auditId, String actionPerformedBy,
			OrderByComparator<MOIAudit> orderByComparator)
		throws NoSuchMOIAuditException {

		actionPerformedBy = Objects.toString(actionPerformedBy, "");

		MOIAudit moiAudit = findByPrimaryKey(auditId);

		Session session = null;

		try {
			session = openSession();

			MOIAudit[] array = new MOIAuditImpl[3];

			array[0] = getByActionPerformedBy_PrevAndNext(
				session, moiAudit, actionPerformedBy, orderByComparator, true);

			array[1] = moiAudit;

			array[2] = getByActionPerformedBy_PrevAndNext(
				session, moiAudit, actionPerformedBy, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MOIAudit getByActionPerformedBy_PrevAndNext(
		Session session, MOIAudit moiAudit, String actionPerformedBy,
		OrderByComparator<MOIAudit> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MOIAUDIT_WHERE);

		boolean bindActionPerformedBy = false;

		if (actionPerformedBy.isEmpty()) {
			sb.append(_FINDER_COLUMN_ACTIONPERFORMEDBY_ACTIONPERFORMEDBY_3);
		}
		else {
			bindActionPerformedBy = true;

			sb.append(_FINDER_COLUMN_ACTIONPERFORMEDBY_ACTIONPERFORMEDBY_2);
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
			sb.append(MOIAuditModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindActionPerformedBy) {
			queryPos.add(actionPerformedBy);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(moiAudit)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MOIAudit> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the moi audits where actionPerformedBy = &#63; from the database.
	 *
	 * @param actionPerformedBy the action performed by
	 */
	@Override
	public void removeByActionPerformedBy(String actionPerformedBy) {
		for (MOIAudit moiAudit :
				findByActionPerformedBy(
					actionPerformedBy, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(moiAudit);
		}
	}

	/**
	 * Returns the number of moi audits where actionPerformedBy = &#63;.
	 *
	 * @param actionPerformedBy the action performed by
	 * @return the number of matching moi audits
	 */
	@Override
	public int countByActionPerformedBy(String actionPerformedBy) {
		actionPerformedBy = Objects.toString(actionPerformedBy, "");

		FinderPath finderPath = _finderPathCountByActionPerformedBy;

		Object[] finderArgs = new Object[] {actionPerformedBy};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOIAUDIT_WHERE);

			boolean bindActionPerformedBy = false;

			if (actionPerformedBy.isEmpty()) {
				sb.append(_FINDER_COLUMN_ACTIONPERFORMEDBY_ACTIONPERFORMEDBY_3);
			}
			else {
				bindActionPerformedBy = true;

				sb.append(_FINDER_COLUMN_ACTIONPERFORMEDBY_ACTIONPERFORMEDBY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindActionPerformedBy) {
					queryPos.add(actionPerformedBy);
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
		_FINDER_COLUMN_ACTIONPERFORMEDBY_ACTIONPERFORMEDBY_2 =
			"moiAudit.actionPerformedBy = ?";

	private static final String
		_FINDER_COLUMN_ACTIONPERFORMEDBY_ACTIONPERFORMEDBY_3 =
			"(moiAudit.actionPerformedBy IS NULL OR moiAudit.actionPerformedBy = '')";

	private FinderPath _finderPathWithPaginationFindByAtionPerformedDate;
	private FinderPath _finderPathWithoutPaginationFindByAtionPerformedDate;
	private FinderPath _finderPathCountByAtionPerformedDate;

	/**
	 * Returns all the moi audits where actionPerformedDate = &#63;.
	 *
	 * @param actionPerformedDate the action performed date
	 * @return the matching moi audits
	 */
	@Override
	public List<MOIAudit> findByAtionPerformedDate(Date actionPerformedDate) {
		return findByAtionPerformedDate(
			actionPerformedDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the moi audits where actionPerformedDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIAuditModelImpl</code>.
	 * </p>
	 *
	 * @param actionPerformedDate the action performed date
	 * @param start the lower bound of the range of moi audits
	 * @param end the upper bound of the range of moi audits (not inclusive)
	 * @return the range of matching moi audits
	 */
	@Override
	public List<MOIAudit> findByAtionPerformedDate(
		Date actionPerformedDate, int start, int end) {

		return findByAtionPerformedDate(actionPerformedDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the moi audits where actionPerformedDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIAuditModelImpl</code>.
	 * </p>
	 *
	 * @param actionPerformedDate the action performed date
	 * @param start the lower bound of the range of moi audits
	 * @param end the upper bound of the range of moi audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi audits
	 */
	@Override
	public List<MOIAudit> findByAtionPerformedDate(
		Date actionPerformedDate, int start, int end,
		OrderByComparator<MOIAudit> orderByComparator) {

		return findByAtionPerformedDate(
			actionPerformedDate, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the moi audits where actionPerformedDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIAuditModelImpl</code>.
	 * </p>
	 *
	 * @param actionPerformedDate the action performed date
	 * @param start the lower bound of the range of moi audits
	 * @param end the upper bound of the range of moi audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi audits
	 */
	@Override
	public List<MOIAudit> findByAtionPerformedDate(
		Date actionPerformedDate, int start, int end,
		OrderByComparator<MOIAudit> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByAtionPerformedDate;
				finderArgs = new Object[] {_getTime(actionPerformedDate)};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAtionPerformedDate;
			finderArgs = new Object[] {
				_getTime(actionPerformedDate), start, end, orderByComparator
			};
		}

		List<MOIAudit> list = null;

		if (useFinderCache) {
			list = (List<MOIAudit>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOIAudit moiAudit : list) {
					if (!Objects.equals(
							actionPerformedDate,
							moiAudit.getActionPerformedDate())) {

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

			sb.append(_SQL_SELECT_MOIAUDIT_WHERE);

			boolean bindActionPerformedDate = false;

			if (actionPerformedDate == null) {
				sb.append(
					_FINDER_COLUMN_ATIONPERFORMEDDATE_ACTIONPERFORMEDDATE_1);
			}
			else {
				bindActionPerformedDate = true;

				sb.append(
					_FINDER_COLUMN_ATIONPERFORMEDDATE_ACTIONPERFORMEDDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOIAuditModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindActionPerformedDate) {
					queryPos.add(new Timestamp(actionPerformedDate.getTime()));
				}

				list = (List<MOIAudit>)QueryUtil.list(
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
	 * Returns the first moi audit in the ordered set where actionPerformedDate = &#63;.
	 *
	 * @param actionPerformedDate the action performed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	@Override
	public MOIAudit findByAtionPerformedDate_First(
			Date actionPerformedDate,
			OrderByComparator<MOIAudit> orderByComparator)
		throws NoSuchMOIAuditException {

		MOIAudit moiAudit = fetchByAtionPerformedDate_First(
			actionPerformedDate, orderByComparator);

		if (moiAudit != null) {
			return moiAudit;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("actionPerformedDate=");
		sb.append(actionPerformedDate);

		sb.append("}");

		throw new NoSuchMOIAuditException(sb.toString());
	}

	/**
	 * Returns the first moi audit in the ordered set where actionPerformedDate = &#63;.
	 *
	 * @param actionPerformedDate the action performed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	@Override
	public MOIAudit fetchByAtionPerformedDate_First(
		Date actionPerformedDate,
		OrderByComparator<MOIAudit> orderByComparator) {

		List<MOIAudit> list = findByAtionPerformedDate(
			actionPerformedDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi audit in the ordered set where actionPerformedDate = &#63;.
	 *
	 * @param actionPerformedDate the action performed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	@Override
	public MOIAudit findByAtionPerformedDate_Last(
			Date actionPerformedDate,
			OrderByComparator<MOIAudit> orderByComparator)
		throws NoSuchMOIAuditException {

		MOIAudit moiAudit = fetchByAtionPerformedDate_Last(
			actionPerformedDate, orderByComparator);

		if (moiAudit != null) {
			return moiAudit;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("actionPerformedDate=");
		sb.append(actionPerformedDate);

		sb.append("}");

		throw new NoSuchMOIAuditException(sb.toString());
	}

	/**
	 * Returns the last moi audit in the ordered set where actionPerformedDate = &#63;.
	 *
	 * @param actionPerformedDate the action performed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	@Override
	public MOIAudit fetchByAtionPerformedDate_Last(
		Date actionPerformedDate,
		OrderByComparator<MOIAudit> orderByComparator) {

		int count = countByAtionPerformedDate(actionPerformedDate);

		if (count == 0) {
			return null;
		}

		List<MOIAudit> list = findByAtionPerformedDate(
			actionPerformedDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the moi audits before and after the current moi audit in the ordered set where actionPerformedDate = &#63;.
	 *
	 * @param auditId the primary key of the current moi audit
	 * @param actionPerformedDate the action performed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi audit
	 * @throws NoSuchMOIAuditException if a moi audit with the primary key could not be found
	 */
	@Override
	public MOIAudit[] findByAtionPerformedDate_PrevAndNext(
			long auditId, Date actionPerformedDate,
			OrderByComparator<MOIAudit> orderByComparator)
		throws NoSuchMOIAuditException {

		MOIAudit moiAudit = findByPrimaryKey(auditId);

		Session session = null;

		try {
			session = openSession();

			MOIAudit[] array = new MOIAuditImpl[3];

			array[0] = getByAtionPerformedDate_PrevAndNext(
				session, moiAudit, actionPerformedDate, orderByComparator,
				true);

			array[1] = moiAudit;

			array[2] = getByAtionPerformedDate_PrevAndNext(
				session, moiAudit, actionPerformedDate, orderByComparator,
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

	protected MOIAudit getByAtionPerformedDate_PrevAndNext(
		Session session, MOIAudit moiAudit, Date actionPerformedDate,
		OrderByComparator<MOIAudit> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MOIAUDIT_WHERE);

		boolean bindActionPerformedDate = false;

		if (actionPerformedDate == null) {
			sb.append(_FINDER_COLUMN_ATIONPERFORMEDDATE_ACTIONPERFORMEDDATE_1);
		}
		else {
			bindActionPerformedDate = true;

			sb.append(_FINDER_COLUMN_ATIONPERFORMEDDATE_ACTIONPERFORMEDDATE_2);
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
			sb.append(MOIAuditModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindActionPerformedDate) {
			queryPos.add(new Timestamp(actionPerformedDate.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(moiAudit)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MOIAudit> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the moi audits where actionPerformedDate = &#63; from the database.
	 *
	 * @param actionPerformedDate the action performed date
	 */
	@Override
	public void removeByAtionPerformedDate(Date actionPerformedDate) {
		for (MOIAudit moiAudit :
				findByAtionPerformedDate(
					actionPerformedDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(moiAudit);
		}
	}

	/**
	 * Returns the number of moi audits where actionPerformedDate = &#63;.
	 *
	 * @param actionPerformedDate the action performed date
	 * @return the number of matching moi audits
	 */
	@Override
	public int countByAtionPerformedDate(Date actionPerformedDate) {
		FinderPath finderPath = _finderPathCountByAtionPerformedDate;

		Object[] finderArgs = new Object[] {_getTime(actionPerformedDate)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOIAUDIT_WHERE);

			boolean bindActionPerformedDate = false;

			if (actionPerformedDate == null) {
				sb.append(
					_FINDER_COLUMN_ATIONPERFORMEDDATE_ACTIONPERFORMEDDATE_1);
			}
			else {
				bindActionPerformedDate = true;

				sb.append(
					_FINDER_COLUMN_ATIONPERFORMEDDATE_ACTIONPERFORMEDDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindActionPerformedDate) {
					queryPos.add(new Timestamp(actionPerformedDate.getTime()));
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
		_FINDER_COLUMN_ATIONPERFORMEDDATE_ACTIONPERFORMEDDATE_1 =
			"moiAudit.actionPerformedDate IS NULL";

	private static final String
		_FINDER_COLUMN_ATIONPERFORMEDDATE_ACTIONPERFORMEDDATE_2 =
			"moiAudit.actionPerformedDate = ?";

	private FinderPath _finderPathWithPaginationFindByActionStatus;
	private FinderPath _finderPathWithoutPaginationFindByActionStatus;
	private FinderPath _finderPathCountByActionStatus;

	/**
	 * Returns all the moi audits where actionStatus = &#63;.
	 *
	 * @param actionStatus the action status
	 * @return the matching moi audits
	 */
	@Override
	public List<MOIAudit> findByActionStatus(String actionStatus) {
		return findByActionStatus(
			actionStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the moi audits where actionStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIAuditModelImpl</code>.
	 * </p>
	 *
	 * @param actionStatus the action status
	 * @param start the lower bound of the range of moi audits
	 * @param end the upper bound of the range of moi audits (not inclusive)
	 * @return the range of matching moi audits
	 */
	@Override
	public List<MOIAudit> findByActionStatus(
		String actionStatus, int start, int end) {

		return findByActionStatus(actionStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the moi audits where actionStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIAuditModelImpl</code>.
	 * </p>
	 *
	 * @param actionStatus the action status
	 * @param start the lower bound of the range of moi audits
	 * @param end the upper bound of the range of moi audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi audits
	 */
	@Override
	public List<MOIAudit> findByActionStatus(
		String actionStatus, int start, int end,
		OrderByComparator<MOIAudit> orderByComparator) {

		return findByActionStatus(
			actionStatus, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the moi audits where actionStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIAuditModelImpl</code>.
	 * </p>
	 *
	 * @param actionStatus the action status
	 * @param start the lower bound of the range of moi audits
	 * @param end the upper bound of the range of moi audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi audits
	 */
	@Override
	public List<MOIAudit> findByActionStatus(
		String actionStatus, int start, int end,
		OrderByComparator<MOIAudit> orderByComparator, boolean useFinderCache) {

		actionStatus = Objects.toString(actionStatus, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByActionStatus;
				finderArgs = new Object[] {actionStatus};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByActionStatus;
			finderArgs = new Object[] {
				actionStatus, start, end, orderByComparator
			};
		}

		List<MOIAudit> list = null;

		if (useFinderCache) {
			list = (List<MOIAudit>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOIAudit moiAudit : list) {
					if (!actionStatus.equals(moiAudit.getActionStatus())) {
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

			sb.append(_SQL_SELECT_MOIAUDIT_WHERE);

			boolean bindActionStatus = false;

			if (actionStatus.isEmpty()) {
				sb.append(_FINDER_COLUMN_ACTIONSTATUS_ACTIONSTATUS_3);
			}
			else {
				bindActionStatus = true;

				sb.append(_FINDER_COLUMN_ACTIONSTATUS_ACTIONSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOIAuditModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindActionStatus) {
					queryPos.add(actionStatus);
				}

				list = (List<MOIAudit>)QueryUtil.list(
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
	 * Returns the first moi audit in the ordered set where actionStatus = &#63;.
	 *
	 * @param actionStatus the action status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	@Override
	public MOIAudit findByActionStatus_First(
			String actionStatus, OrderByComparator<MOIAudit> orderByComparator)
		throws NoSuchMOIAuditException {

		MOIAudit moiAudit = fetchByActionStatus_First(
			actionStatus, orderByComparator);

		if (moiAudit != null) {
			return moiAudit;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("actionStatus=");
		sb.append(actionStatus);

		sb.append("}");

		throw new NoSuchMOIAuditException(sb.toString());
	}

	/**
	 * Returns the first moi audit in the ordered set where actionStatus = &#63;.
	 *
	 * @param actionStatus the action status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	@Override
	public MOIAudit fetchByActionStatus_First(
		String actionStatus, OrderByComparator<MOIAudit> orderByComparator) {

		List<MOIAudit> list = findByActionStatus(
			actionStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi audit in the ordered set where actionStatus = &#63;.
	 *
	 * @param actionStatus the action status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	@Override
	public MOIAudit findByActionStatus_Last(
			String actionStatus, OrderByComparator<MOIAudit> orderByComparator)
		throws NoSuchMOIAuditException {

		MOIAudit moiAudit = fetchByActionStatus_Last(
			actionStatus, orderByComparator);

		if (moiAudit != null) {
			return moiAudit;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("actionStatus=");
		sb.append(actionStatus);

		sb.append("}");

		throw new NoSuchMOIAuditException(sb.toString());
	}

	/**
	 * Returns the last moi audit in the ordered set where actionStatus = &#63;.
	 *
	 * @param actionStatus the action status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	@Override
	public MOIAudit fetchByActionStatus_Last(
		String actionStatus, OrderByComparator<MOIAudit> orderByComparator) {

		int count = countByActionStatus(actionStatus);

		if (count == 0) {
			return null;
		}

		List<MOIAudit> list = findByActionStatus(
			actionStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the moi audits before and after the current moi audit in the ordered set where actionStatus = &#63;.
	 *
	 * @param auditId the primary key of the current moi audit
	 * @param actionStatus the action status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi audit
	 * @throws NoSuchMOIAuditException if a moi audit with the primary key could not be found
	 */
	@Override
	public MOIAudit[] findByActionStatus_PrevAndNext(
			long auditId, String actionStatus,
			OrderByComparator<MOIAudit> orderByComparator)
		throws NoSuchMOIAuditException {

		actionStatus = Objects.toString(actionStatus, "");

		MOIAudit moiAudit = findByPrimaryKey(auditId);

		Session session = null;

		try {
			session = openSession();

			MOIAudit[] array = new MOIAuditImpl[3];

			array[0] = getByActionStatus_PrevAndNext(
				session, moiAudit, actionStatus, orderByComparator, true);

			array[1] = moiAudit;

			array[2] = getByActionStatus_PrevAndNext(
				session, moiAudit, actionStatus, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MOIAudit getByActionStatus_PrevAndNext(
		Session session, MOIAudit moiAudit, String actionStatus,
		OrderByComparator<MOIAudit> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MOIAUDIT_WHERE);

		boolean bindActionStatus = false;

		if (actionStatus.isEmpty()) {
			sb.append(_FINDER_COLUMN_ACTIONSTATUS_ACTIONSTATUS_3);
		}
		else {
			bindActionStatus = true;

			sb.append(_FINDER_COLUMN_ACTIONSTATUS_ACTIONSTATUS_2);
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
			sb.append(MOIAuditModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindActionStatus) {
			queryPos.add(actionStatus);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(moiAudit)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MOIAudit> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the moi audits where actionStatus = &#63; from the database.
	 *
	 * @param actionStatus the action status
	 */
	@Override
	public void removeByActionStatus(String actionStatus) {
		for (MOIAudit moiAudit :
				findByActionStatus(
					actionStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(moiAudit);
		}
	}

	/**
	 * Returns the number of moi audits where actionStatus = &#63;.
	 *
	 * @param actionStatus the action status
	 * @return the number of matching moi audits
	 */
	@Override
	public int countByActionStatus(String actionStatus) {
		actionStatus = Objects.toString(actionStatus, "");

		FinderPath finderPath = _finderPathCountByActionStatus;

		Object[] finderArgs = new Object[] {actionStatus};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOIAUDIT_WHERE);

			boolean bindActionStatus = false;

			if (actionStatus.isEmpty()) {
				sb.append(_FINDER_COLUMN_ACTIONSTATUS_ACTIONSTATUS_3);
			}
			else {
				bindActionStatus = true;

				sb.append(_FINDER_COLUMN_ACTIONSTATUS_ACTIONSTATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindActionStatus) {
					queryPos.add(actionStatus);
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

	private static final String _FINDER_COLUMN_ACTIONSTATUS_ACTIONSTATUS_2 =
		"moiAudit.actionStatus = ?";

	private static final String _FINDER_COLUMN_ACTIONSTATUS_ACTIONSTATUS_3 =
		"(moiAudit.actionStatus IS NULL OR moiAudit.actionStatus = '')";

	private FinderPath _finderPathWithPaginationFindByActionDescription;
	private FinderPath _finderPathWithoutPaginationFindByActionDescription;
	private FinderPath _finderPathCountByActionDescription;

	/**
	 * Returns all the moi audits where actionDescription = &#63;.
	 *
	 * @param actionDescription the action description
	 * @return the matching moi audits
	 */
	@Override
	public List<MOIAudit> findByActionDescription(String actionDescription) {
		return findByActionDescription(
			actionDescription, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the moi audits where actionDescription = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIAuditModelImpl</code>.
	 * </p>
	 *
	 * @param actionDescription the action description
	 * @param start the lower bound of the range of moi audits
	 * @param end the upper bound of the range of moi audits (not inclusive)
	 * @return the range of matching moi audits
	 */
	@Override
	public List<MOIAudit> findByActionDescription(
		String actionDescription, int start, int end) {

		return findByActionDescription(actionDescription, start, end, null);
	}

	/**
	 * Returns an ordered range of all the moi audits where actionDescription = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIAuditModelImpl</code>.
	 * </p>
	 *
	 * @param actionDescription the action description
	 * @param start the lower bound of the range of moi audits
	 * @param end the upper bound of the range of moi audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi audits
	 */
	@Override
	public List<MOIAudit> findByActionDescription(
		String actionDescription, int start, int end,
		OrderByComparator<MOIAudit> orderByComparator) {

		return findByActionDescription(
			actionDescription, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the moi audits where actionDescription = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIAuditModelImpl</code>.
	 * </p>
	 *
	 * @param actionDescription the action description
	 * @param start the lower bound of the range of moi audits
	 * @param end the upper bound of the range of moi audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi audits
	 */
	@Override
	public List<MOIAudit> findByActionDescription(
		String actionDescription, int start, int end,
		OrderByComparator<MOIAudit> orderByComparator, boolean useFinderCache) {

		actionDescription = Objects.toString(actionDescription, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByActionDescription;
				finderArgs = new Object[] {actionDescription};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByActionDescription;
			finderArgs = new Object[] {
				actionDescription, start, end, orderByComparator
			};
		}

		List<MOIAudit> list = null;

		if (useFinderCache) {
			list = (List<MOIAudit>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOIAudit moiAudit : list) {
					if (!actionDescription.equals(
							moiAudit.getActionDescription())) {

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

			sb.append(_SQL_SELECT_MOIAUDIT_WHERE);

			boolean bindActionDescription = false;

			if (actionDescription.isEmpty()) {
				sb.append(_FINDER_COLUMN_ACTIONDESCRIPTION_ACTIONDESCRIPTION_3);
			}
			else {
				bindActionDescription = true;

				sb.append(_FINDER_COLUMN_ACTIONDESCRIPTION_ACTIONDESCRIPTION_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOIAuditModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindActionDescription) {
					queryPos.add(actionDescription);
				}

				list = (List<MOIAudit>)QueryUtil.list(
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
	 * Returns the first moi audit in the ordered set where actionDescription = &#63;.
	 *
	 * @param actionDescription the action description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	@Override
	public MOIAudit findByActionDescription_First(
			String actionDescription,
			OrderByComparator<MOIAudit> orderByComparator)
		throws NoSuchMOIAuditException {

		MOIAudit moiAudit = fetchByActionDescription_First(
			actionDescription, orderByComparator);

		if (moiAudit != null) {
			return moiAudit;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("actionDescription=");
		sb.append(actionDescription);

		sb.append("}");

		throw new NoSuchMOIAuditException(sb.toString());
	}

	/**
	 * Returns the first moi audit in the ordered set where actionDescription = &#63;.
	 *
	 * @param actionDescription the action description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	@Override
	public MOIAudit fetchByActionDescription_First(
		String actionDescription,
		OrderByComparator<MOIAudit> orderByComparator) {

		List<MOIAudit> list = findByActionDescription(
			actionDescription, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi audit in the ordered set where actionDescription = &#63;.
	 *
	 * @param actionDescription the action description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	@Override
	public MOIAudit findByActionDescription_Last(
			String actionDescription,
			OrderByComparator<MOIAudit> orderByComparator)
		throws NoSuchMOIAuditException {

		MOIAudit moiAudit = fetchByActionDescription_Last(
			actionDescription, orderByComparator);

		if (moiAudit != null) {
			return moiAudit;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("actionDescription=");
		sb.append(actionDescription);

		sb.append("}");

		throw new NoSuchMOIAuditException(sb.toString());
	}

	/**
	 * Returns the last moi audit in the ordered set where actionDescription = &#63;.
	 *
	 * @param actionDescription the action description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	@Override
	public MOIAudit fetchByActionDescription_Last(
		String actionDescription,
		OrderByComparator<MOIAudit> orderByComparator) {

		int count = countByActionDescription(actionDescription);

		if (count == 0) {
			return null;
		}

		List<MOIAudit> list = findByActionDescription(
			actionDescription, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the moi audits before and after the current moi audit in the ordered set where actionDescription = &#63;.
	 *
	 * @param auditId the primary key of the current moi audit
	 * @param actionDescription the action description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi audit
	 * @throws NoSuchMOIAuditException if a moi audit with the primary key could not be found
	 */
	@Override
	public MOIAudit[] findByActionDescription_PrevAndNext(
			long auditId, String actionDescription,
			OrderByComparator<MOIAudit> orderByComparator)
		throws NoSuchMOIAuditException {

		actionDescription = Objects.toString(actionDescription, "");

		MOIAudit moiAudit = findByPrimaryKey(auditId);

		Session session = null;

		try {
			session = openSession();

			MOIAudit[] array = new MOIAuditImpl[3];

			array[0] = getByActionDescription_PrevAndNext(
				session, moiAudit, actionDescription, orderByComparator, true);

			array[1] = moiAudit;

			array[2] = getByActionDescription_PrevAndNext(
				session, moiAudit, actionDescription, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MOIAudit getByActionDescription_PrevAndNext(
		Session session, MOIAudit moiAudit, String actionDescription,
		OrderByComparator<MOIAudit> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MOIAUDIT_WHERE);

		boolean bindActionDescription = false;

		if (actionDescription.isEmpty()) {
			sb.append(_FINDER_COLUMN_ACTIONDESCRIPTION_ACTIONDESCRIPTION_3);
		}
		else {
			bindActionDescription = true;

			sb.append(_FINDER_COLUMN_ACTIONDESCRIPTION_ACTIONDESCRIPTION_2);
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
			sb.append(MOIAuditModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindActionDescription) {
			queryPos.add(actionDescription);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(moiAudit)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MOIAudit> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the moi audits where actionDescription = &#63; from the database.
	 *
	 * @param actionDescription the action description
	 */
	@Override
	public void removeByActionDescription(String actionDescription) {
		for (MOIAudit moiAudit :
				findByActionDescription(
					actionDescription, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(moiAudit);
		}
	}

	/**
	 * Returns the number of moi audits where actionDescription = &#63;.
	 *
	 * @param actionDescription the action description
	 * @return the number of matching moi audits
	 */
	@Override
	public int countByActionDescription(String actionDescription) {
		actionDescription = Objects.toString(actionDescription, "");

		FinderPath finderPath = _finderPathCountByActionDescription;

		Object[] finderArgs = new Object[] {actionDescription};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOIAUDIT_WHERE);

			boolean bindActionDescription = false;

			if (actionDescription.isEmpty()) {
				sb.append(_FINDER_COLUMN_ACTIONDESCRIPTION_ACTIONDESCRIPTION_3);
			}
			else {
				bindActionDescription = true;

				sb.append(_FINDER_COLUMN_ACTIONDESCRIPTION_ACTIONDESCRIPTION_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindActionDescription) {
					queryPos.add(actionDescription);
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
		_FINDER_COLUMN_ACTIONDESCRIPTION_ACTIONDESCRIPTION_2 =
			"moiAudit.actionDescription = ?";

	private static final String
		_FINDER_COLUMN_ACTIONDESCRIPTION_ACTIONDESCRIPTION_3 =
			"(moiAudit.actionDescription IS NULL OR moiAudit.actionDescription = '')";

	private FinderPath _finderPathWithPaginationFindByActionConsumer;
	private FinderPath _finderPathWithoutPaginationFindByActionConsumer;
	private FinderPath _finderPathCountByActionConsumer;

	/**
	 * Returns all the moi audits where actionConsumer = &#63;.
	 *
	 * @param actionConsumer the action consumer
	 * @return the matching moi audits
	 */
	@Override
	public List<MOIAudit> findByActionConsumer(String actionConsumer) {
		return findByActionConsumer(
			actionConsumer, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the moi audits where actionConsumer = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIAuditModelImpl</code>.
	 * </p>
	 *
	 * @param actionConsumer the action consumer
	 * @param start the lower bound of the range of moi audits
	 * @param end the upper bound of the range of moi audits (not inclusive)
	 * @return the range of matching moi audits
	 */
	@Override
	public List<MOIAudit> findByActionConsumer(
		String actionConsumer, int start, int end) {

		return findByActionConsumer(actionConsumer, start, end, null);
	}

	/**
	 * Returns an ordered range of all the moi audits where actionConsumer = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIAuditModelImpl</code>.
	 * </p>
	 *
	 * @param actionConsumer the action consumer
	 * @param start the lower bound of the range of moi audits
	 * @param end the upper bound of the range of moi audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi audits
	 */
	@Override
	public List<MOIAudit> findByActionConsumer(
		String actionConsumer, int start, int end,
		OrderByComparator<MOIAudit> orderByComparator) {

		return findByActionConsumer(
			actionConsumer, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the moi audits where actionConsumer = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIAuditModelImpl</code>.
	 * </p>
	 *
	 * @param actionConsumer the action consumer
	 * @param start the lower bound of the range of moi audits
	 * @param end the upper bound of the range of moi audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi audits
	 */
	@Override
	public List<MOIAudit> findByActionConsumer(
		String actionConsumer, int start, int end,
		OrderByComparator<MOIAudit> orderByComparator, boolean useFinderCache) {

		actionConsumer = Objects.toString(actionConsumer, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByActionConsumer;
				finderArgs = new Object[] {actionConsumer};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByActionConsumer;
			finderArgs = new Object[] {
				actionConsumer, start, end, orderByComparator
			};
		}

		List<MOIAudit> list = null;

		if (useFinderCache) {
			list = (List<MOIAudit>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOIAudit moiAudit : list) {
					if (!actionConsumer.equals(moiAudit.getActionConsumer())) {
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

			sb.append(_SQL_SELECT_MOIAUDIT_WHERE);

			boolean bindActionConsumer = false;

			if (actionConsumer.isEmpty()) {
				sb.append(_FINDER_COLUMN_ACTIONCONSUMER_ACTIONCONSUMER_3);
			}
			else {
				bindActionConsumer = true;

				sb.append(_FINDER_COLUMN_ACTIONCONSUMER_ACTIONCONSUMER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOIAuditModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindActionConsumer) {
					queryPos.add(actionConsumer);
				}

				list = (List<MOIAudit>)QueryUtil.list(
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
	 * Returns the first moi audit in the ordered set where actionConsumer = &#63;.
	 *
	 * @param actionConsumer the action consumer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	@Override
	public MOIAudit findByActionConsumer_First(
			String actionConsumer,
			OrderByComparator<MOIAudit> orderByComparator)
		throws NoSuchMOIAuditException {

		MOIAudit moiAudit = fetchByActionConsumer_First(
			actionConsumer, orderByComparator);

		if (moiAudit != null) {
			return moiAudit;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("actionConsumer=");
		sb.append(actionConsumer);

		sb.append("}");

		throw new NoSuchMOIAuditException(sb.toString());
	}

	/**
	 * Returns the first moi audit in the ordered set where actionConsumer = &#63;.
	 *
	 * @param actionConsumer the action consumer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	@Override
	public MOIAudit fetchByActionConsumer_First(
		String actionConsumer, OrderByComparator<MOIAudit> orderByComparator) {

		List<MOIAudit> list = findByActionConsumer(
			actionConsumer, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi audit in the ordered set where actionConsumer = &#63;.
	 *
	 * @param actionConsumer the action consumer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	@Override
	public MOIAudit findByActionConsumer_Last(
			String actionConsumer,
			OrderByComparator<MOIAudit> orderByComparator)
		throws NoSuchMOIAuditException {

		MOIAudit moiAudit = fetchByActionConsumer_Last(
			actionConsumer, orderByComparator);

		if (moiAudit != null) {
			return moiAudit;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("actionConsumer=");
		sb.append(actionConsumer);

		sb.append("}");

		throw new NoSuchMOIAuditException(sb.toString());
	}

	/**
	 * Returns the last moi audit in the ordered set where actionConsumer = &#63;.
	 *
	 * @param actionConsumer the action consumer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	@Override
	public MOIAudit fetchByActionConsumer_Last(
		String actionConsumer, OrderByComparator<MOIAudit> orderByComparator) {

		int count = countByActionConsumer(actionConsumer);

		if (count == 0) {
			return null;
		}

		List<MOIAudit> list = findByActionConsumer(
			actionConsumer, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the moi audits before and after the current moi audit in the ordered set where actionConsumer = &#63;.
	 *
	 * @param auditId the primary key of the current moi audit
	 * @param actionConsumer the action consumer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi audit
	 * @throws NoSuchMOIAuditException if a moi audit with the primary key could not be found
	 */
	@Override
	public MOIAudit[] findByActionConsumer_PrevAndNext(
			long auditId, String actionConsumer,
			OrderByComparator<MOIAudit> orderByComparator)
		throws NoSuchMOIAuditException {

		actionConsumer = Objects.toString(actionConsumer, "");

		MOIAudit moiAudit = findByPrimaryKey(auditId);

		Session session = null;

		try {
			session = openSession();

			MOIAudit[] array = new MOIAuditImpl[3];

			array[0] = getByActionConsumer_PrevAndNext(
				session, moiAudit, actionConsumer, orderByComparator, true);

			array[1] = moiAudit;

			array[2] = getByActionConsumer_PrevAndNext(
				session, moiAudit, actionConsumer, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MOIAudit getByActionConsumer_PrevAndNext(
		Session session, MOIAudit moiAudit, String actionConsumer,
		OrderByComparator<MOIAudit> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MOIAUDIT_WHERE);

		boolean bindActionConsumer = false;

		if (actionConsumer.isEmpty()) {
			sb.append(_FINDER_COLUMN_ACTIONCONSUMER_ACTIONCONSUMER_3);
		}
		else {
			bindActionConsumer = true;

			sb.append(_FINDER_COLUMN_ACTIONCONSUMER_ACTIONCONSUMER_2);
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
			sb.append(MOIAuditModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindActionConsumer) {
			queryPos.add(actionConsumer);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(moiAudit)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MOIAudit> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the moi audits where actionConsumer = &#63; from the database.
	 *
	 * @param actionConsumer the action consumer
	 */
	@Override
	public void removeByActionConsumer(String actionConsumer) {
		for (MOIAudit moiAudit :
				findByActionConsumer(
					actionConsumer, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(moiAudit);
		}
	}

	/**
	 * Returns the number of moi audits where actionConsumer = &#63;.
	 *
	 * @param actionConsumer the action consumer
	 * @return the number of matching moi audits
	 */
	@Override
	public int countByActionConsumer(String actionConsumer) {
		actionConsumer = Objects.toString(actionConsumer, "");

		FinderPath finderPath = _finderPathCountByActionConsumer;

		Object[] finderArgs = new Object[] {actionConsumer};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOIAUDIT_WHERE);

			boolean bindActionConsumer = false;

			if (actionConsumer.isEmpty()) {
				sb.append(_FINDER_COLUMN_ACTIONCONSUMER_ACTIONCONSUMER_3);
			}
			else {
				bindActionConsumer = true;

				sb.append(_FINDER_COLUMN_ACTIONCONSUMER_ACTIONCONSUMER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindActionConsumer) {
					queryPos.add(actionConsumer);
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

	private static final String _FINDER_COLUMN_ACTIONCONSUMER_ACTIONCONSUMER_2 =
		"moiAudit.actionConsumer = ?";

	private static final String _FINDER_COLUMN_ACTIONCONSUMER_ACTIONCONSUMER_3 =
		"(moiAudit.actionConsumer IS NULL OR moiAudit.actionConsumer = '')";

	public MOIAuditPersistenceImpl() {
		setModelClass(MOIAudit.class);

		setModelImplClass(MOIAuditImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the moi audit in the entity cache if it is enabled.
	 *
	 * @param moiAudit the moi audit
	 */
	@Override
	public void cacheResult(MOIAudit moiAudit) {
		entityCache.putResult(
			entityCacheEnabled, MOIAuditImpl.class, moiAudit.getPrimaryKey(),
			moiAudit);

		moiAudit.resetOriginalValues();
	}

	/**
	 * Caches the moi audits in the entity cache if it is enabled.
	 *
	 * @param moiAudits the moi audits
	 */
	@Override
	public void cacheResult(List<MOIAudit> moiAudits) {
		for (MOIAudit moiAudit : moiAudits) {
			if (entityCache.getResult(
					entityCacheEnabled, MOIAuditImpl.class,
					moiAudit.getPrimaryKey()) == null) {

				cacheResult(moiAudit);
			}
			else {
				moiAudit.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all moi audits.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MOIAuditImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the moi audit.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MOIAudit moiAudit) {
		entityCache.removeResult(
			entityCacheEnabled, MOIAuditImpl.class, moiAudit.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MOIAudit> moiAudits) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MOIAudit moiAudit : moiAudits) {
			entityCache.removeResult(
				entityCacheEnabled, MOIAuditImpl.class,
				moiAudit.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, MOIAuditImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new moi audit with the primary key. Does not add the moi audit to the database.
	 *
	 * @param auditId the primary key for the new moi audit
	 * @return the new moi audit
	 */
	@Override
	public MOIAudit create(long auditId) {
		MOIAudit moiAudit = new MOIAuditImpl();

		moiAudit.setNew(true);
		moiAudit.setPrimaryKey(auditId);

		return moiAudit;
	}

	/**
	 * Removes the moi audit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param auditId the primary key of the moi audit
	 * @return the moi audit that was removed
	 * @throws NoSuchMOIAuditException if a moi audit with the primary key could not be found
	 */
	@Override
	public MOIAudit remove(long auditId) throws NoSuchMOIAuditException {
		return remove((Serializable)auditId);
	}

	/**
	 * Removes the moi audit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the moi audit
	 * @return the moi audit that was removed
	 * @throws NoSuchMOIAuditException if a moi audit with the primary key could not be found
	 */
	@Override
	public MOIAudit remove(Serializable primaryKey)
		throws NoSuchMOIAuditException {

		Session session = null;

		try {
			session = openSession();

			MOIAudit moiAudit = (MOIAudit)session.get(
				MOIAuditImpl.class, primaryKey);

			if (moiAudit == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMOIAuditException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(moiAudit);
		}
		catch (NoSuchMOIAuditException noSuchEntityException) {
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
	protected MOIAudit removeImpl(MOIAudit moiAudit) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(moiAudit)) {
				moiAudit = (MOIAudit)session.get(
					MOIAuditImpl.class, moiAudit.getPrimaryKeyObj());
			}

			if (moiAudit != null) {
				session.delete(moiAudit);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (moiAudit != null) {
			clearCache(moiAudit);
		}

		return moiAudit;
	}

	@Override
	public MOIAudit updateImpl(MOIAudit moiAudit) {
		boolean isNew = moiAudit.isNew();

		if (!(moiAudit instanceof MOIAuditModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(moiAudit.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(moiAudit);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in moiAudit proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MOIAudit implementation " +
					moiAudit.getClass());
		}

		MOIAuditModelImpl moiAuditModelImpl = (MOIAuditModelImpl)moiAudit;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(moiAudit);

				moiAudit.setNew(false);
			}
			else {
				moiAudit = (MOIAudit)session.merge(moiAudit);
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
			Object[] args = new Object[] {moiAuditModelImpl.getAuditId()};

			finderCache.removeResult(_finderPathCountByAuditId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByAuditId, args);

			args = new Object[] {moiAuditModelImpl.getActionPerformedBy()};

			finderCache.removeResult(_finderPathCountByActionPerformedBy, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByActionPerformedBy, args);

			args = new Object[] {moiAuditModelImpl.getActionPerformedDate()};

			finderCache.removeResult(
				_finderPathCountByAtionPerformedDate, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByAtionPerformedDate, args);

			args = new Object[] {moiAuditModelImpl.getActionStatus()};

			finderCache.removeResult(_finderPathCountByActionStatus, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByActionStatus, args);

			args = new Object[] {moiAuditModelImpl.getActionDescription()};

			finderCache.removeResult(_finderPathCountByActionDescription, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByActionDescription, args);

			args = new Object[] {moiAuditModelImpl.getActionConsumer()};

			finderCache.removeResult(_finderPathCountByActionConsumer, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByActionConsumer, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((moiAuditModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByAuditId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					moiAuditModelImpl.getOriginalAuditId()
				};

				finderCache.removeResult(_finderPathCountByAuditId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAuditId, args);

				args = new Object[] {moiAuditModelImpl.getAuditId()};

				finderCache.removeResult(_finderPathCountByAuditId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAuditId, args);
			}

			if ((moiAuditModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByActionPerformedBy.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					moiAuditModelImpl.getOriginalActionPerformedBy()
				};

				finderCache.removeResult(
					_finderPathCountByActionPerformedBy, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByActionPerformedBy, args);

				args = new Object[] {moiAuditModelImpl.getActionPerformedBy()};

				finderCache.removeResult(
					_finderPathCountByActionPerformedBy, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByActionPerformedBy, args);
			}

			if ((moiAuditModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByAtionPerformedDate.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					moiAuditModelImpl.getOriginalActionPerformedDate()
				};

				finderCache.removeResult(
					_finderPathCountByAtionPerformedDate, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAtionPerformedDate, args);

				args = new Object[] {
					moiAuditModelImpl.getActionPerformedDate()
				};

				finderCache.removeResult(
					_finderPathCountByAtionPerformedDate, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAtionPerformedDate, args);
			}

			if ((moiAuditModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByActionStatus.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					moiAuditModelImpl.getOriginalActionStatus()
				};

				finderCache.removeResult(_finderPathCountByActionStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByActionStatus, args);

				args = new Object[] {moiAuditModelImpl.getActionStatus()};

				finderCache.removeResult(_finderPathCountByActionStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByActionStatus, args);
			}

			if ((moiAuditModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByActionDescription.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					moiAuditModelImpl.getOriginalActionDescription()
				};

				finderCache.removeResult(
					_finderPathCountByActionDescription, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByActionDescription, args);

				args = new Object[] {moiAuditModelImpl.getActionDescription()};

				finderCache.removeResult(
					_finderPathCountByActionDescription, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByActionDescription, args);
			}

			if ((moiAuditModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByActionConsumer.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					moiAuditModelImpl.getOriginalActionConsumer()
				};

				finderCache.removeResult(
					_finderPathCountByActionConsumer, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByActionConsumer, args);

				args = new Object[] {moiAuditModelImpl.getActionConsumer()};

				finderCache.removeResult(
					_finderPathCountByActionConsumer, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByActionConsumer, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, MOIAuditImpl.class, moiAudit.getPrimaryKey(),
			moiAudit, false);

		moiAudit.resetOriginalValues();

		return moiAudit;
	}

	/**
	 * Returns the moi audit with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the moi audit
	 * @return the moi audit
	 * @throws NoSuchMOIAuditException if a moi audit with the primary key could not be found
	 */
	@Override
	public MOIAudit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMOIAuditException {

		MOIAudit moiAudit = fetchByPrimaryKey(primaryKey);

		if (moiAudit == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMOIAuditException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return moiAudit;
	}

	/**
	 * Returns the moi audit with the primary key or throws a <code>NoSuchMOIAuditException</code> if it could not be found.
	 *
	 * @param auditId the primary key of the moi audit
	 * @return the moi audit
	 * @throws NoSuchMOIAuditException if a moi audit with the primary key could not be found
	 */
	@Override
	public MOIAudit findByPrimaryKey(long auditId)
		throws NoSuchMOIAuditException {

		return findByPrimaryKey((Serializable)auditId);
	}

	/**
	 * Returns the moi audit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param auditId the primary key of the moi audit
	 * @return the moi audit, or <code>null</code> if a moi audit with the primary key could not be found
	 */
	@Override
	public MOIAudit fetchByPrimaryKey(long auditId) {
		return fetchByPrimaryKey((Serializable)auditId);
	}

	/**
	 * Returns all the moi audits.
	 *
	 * @return the moi audits
	 */
	@Override
	public List<MOIAudit> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the moi audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIAuditModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of moi audits
	 * @param end the upper bound of the range of moi audits (not inclusive)
	 * @return the range of moi audits
	 */
	@Override
	public List<MOIAudit> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the moi audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIAuditModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of moi audits
	 * @param end the upper bound of the range of moi audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of moi audits
	 */
	@Override
	public List<MOIAudit> findAll(
		int start, int end, OrderByComparator<MOIAudit> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the moi audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIAuditModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of moi audits
	 * @param end the upper bound of the range of moi audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of moi audits
	 */
	@Override
	public List<MOIAudit> findAll(
		int start, int end, OrderByComparator<MOIAudit> orderByComparator,
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

		List<MOIAudit> list = null;

		if (useFinderCache) {
			list = (List<MOIAudit>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MOIAUDIT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MOIAUDIT;

				sql = sql.concat(MOIAuditModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MOIAudit>)QueryUtil.list(
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
	 * Removes all the moi audits from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MOIAudit moiAudit : findAll()) {
			remove(moiAudit);
		}
	}

	/**
	 * Returns the number of moi audits.
	 *
	 * @return the number of moi audits
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MOIAUDIT);

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
		return "auditId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MOIAUDIT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MOIAuditModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the moi audit persistence.
	 */
	@Activate
	public void activate() {
		MOIAuditModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		MOIAuditModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByAuditId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAuditId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByAuditId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAuditId",
			new String[] {Long.class.getName()},
			MOIAuditModelImpl.AUDITID_COLUMN_BITMASK);

		_finderPathCountByAuditId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAuditId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByActionPerformedBy = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActionPerformedBy",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByActionPerformedBy = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByActionPerformedBy", new String[] {String.class.getName()},
			MOIAuditModelImpl.ACTIONPERFORMEDBY_COLUMN_BITMASK);

		_finderPathCountByActionPerformedBy = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByActionPerformedBy", new String[] {String.class.getName()});

		_finderPathWithPaginationFindByAtionPerformedDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAtionPerformedDate",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByAtionPerformedDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAtionPerformedDate", new String[] {Date.class.getName()},
			MOIAuditModelImpl.ACTIONPERFORMEDDATE_COLUMN_BITMASK);

		_finderPathCountByAtionPerformedDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAtionPerformedDate", new String[] {Date.class.getName()});

		_finderPathWithPaginationFindByActionStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActionStatus",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByActionStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActionStatus",
			new String[] {String.class.getName()},
			MOIAuditModelImpl.ACTIONSTATUS_COLUMN_BITMASK);

		_finderPathCountByActionStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByActionStatus",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByActionDescription = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActionDescription",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByActionDescription = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByActionDescription", new String[] {String.class.getName()},
			MOIAuditModelImpl.ACTIONDESCRIPTION_COLUMN_BITMASK);

		_finderPathCountByActionDescription = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByActionDescription", new String[] {String.class.getName()});

		_finderPathWithPaginationFindByActionConsumer = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActionConsumer",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByActionConsumer = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActionConsumer",
			new String[] {String.class.getName()},
			MOIAuditModelImpl.ACTIONCONSUMER_COLUMN_BITMASK);

		_finderPathCountByActionConsumer = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByActionConsumer",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(MOIAuditImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = moiauditPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.moi.dms.audit.model.MOIAudit"),
			true);
	}

	@Override
	@Reference(
		target = moiauditPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = moiauditPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_MOIAUDIT =
		"SELECT moiAudit FROM MOIAudit moiAudit";

	private static final String _SQL_SELECT_MOIAUDIT_WHERE =
		"SELECT moiAudit FROM MOIAudit moiAudit WHERE ";

	private static final String _SQL_COUNT_MOIAUDIT =
		"SELECT COUNT(moiAudit) FROM MOIAudit moiAudit";

	private static final String _SQL_COUNT_MOIAUDIT_WHERE =
		"SELECT COUNT(moiAudit) FROM MOIAudit moiAudit WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "moiAudit.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MOIAudit exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MOIAudit exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MOIAuditPersistenceImpl.class);

	static {
		try {
			Class.forName(moiauditPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}