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

package com.moi.dms.audit.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.moi.dms.audit.model.MOIAudit;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the moi audit service. This utility wraps <code>com.moi.dms.audit.service.persistence.impl.MOIAuditPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MOIAuditPersistence
 * @generated
 */
public class MOIAuditUtil {

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
	public static void clearCache(MOIAudit moiAudit) {
		getPersistence().clearCache(moiAudit);
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
	public static Map<Serializable, MOIAudit> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MOIAudit> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MOIAudit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MOIAudit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MOIAudit> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MOIAudit update(MOIAudit moiAudit) {
		return getPersistence().update(moiAudit);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MOIAudit update(
		MOIAudit moiAudit, ServiceContext serviceContext) {

		return getPersistence().update(moiAudit, serviceContext);
	}

	/**
	 * Returns all the moi audits where auditId = &#63;.
	 *
	 * @param auditId the audit ID
	 * @return the matching moi audits
	 */
	public static List<MOIAudit> findByAuditId(long auditId) {
		return getPersistence().findByAuditId(auditId);
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
	public static List<MOIAudit> findByAuditId(
		long auditId, int start, int end) {

		return getPersistence().findByAuditId(auditId, start, end);
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
	public static List<MOIAudit> findByAuditId(
		long auditId, int start, int end,
		OrderByComparator<MOIAudit> orderByComparator) {

		return getPersistence().findByAuditId(
			auditId, start, end, orderByComparator);
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
	public static List<MOIAudit> findByAuditId(
		long auditId, int start, int end,
		OrderByComparator<MOIAudit> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByAuditId(
			auditId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first moi audit in the ordered set where auditId = &#63;.
	 *
	 * @param auditId the audit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	public static MOIAudit findByAuditId_First(
			long auditId, OrderByComparator<MOIAudit> orderByComparator)
		throws com.moi.dms.audit.exception.NoSuchMOIAuditException {

		return getPersistence().findByAuditId_First(auditId, orderByComparator);
	}

	/**
	 * Returns the first moi audit in the ordered set where auditId = &#63;.
	 *
	 * @param auditId the audit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	public static MOIAudit fetchByAuditId_First(
		long auditId, OrderByComparator<MOIAudit> orderByComparator) {

		return getPersistence().fetchByAuditId_First(
			auditId, orderByComparator);
	}

	/**
	 * Returns the last moi audit in the ordered set where auditId = &#63;.
	 *
	 * @param auditId the audit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	public static MOIAudit findByAuditId_Last(
			long auditId, OrderByComparator<MOIAudit> orderByComparator)
		throws com.moi.dms.audit.exception.NoSuchMOIAuditException {

		return getPersistence().findByAuditId_Last(auditId, orderByComparator);
	}

	/**
	 * Returns the last moi audit in the ordered set where auditId = &#63;.
	 *
	 * @param auditId the audit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	public static MOIAudit fetchByAuditId_Last(
		long auditId, OrderByComparator<MOIAudit> orderByComparator) {

		return getPersistence().fetchByAuditId_Last(auditId, orderByComparator);
	}

	/**
	 * Removes all the moi audits where auditId = &#63; from the database.
	 *
	 * @param auditId the audit ID
	 */
	public static void removeByAuditId(long auditId) {
		getPersistence().removeByAuditId(auditId);
	}

	/**
	 * Returns the number of moi audits where auditId = &#63;.
	 *
	 * @param auditId the audit ID
	 * @return the number of matching moi audits
	 */
	public static int countByAuditId(long auditId) {
		return getPersistence().countByAuditId(auditId);
	}

	/**
	 * Returns all the moi audits where actionPerformedBy = &#63;.
	 *
	 * @param actionPerformedBy the action performed by
	 * @return the matching moi audits
	 */
	public static List<MOIAudit> findByActionPerformedBy(
		String actionPerformedBy) {

		return getPersistence().findByActionPerformedBy(actionPerformedBy);
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
	public static List<MOIAudit> findByActionPerformedBy(
		String actionPerformedBy, int start, int end) {

		return getPersistence().findByActionPerformedBy(
			actionPerformedBy, start, end);
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
	public static List<MOIAudit> findByActionPerformedBy(
		String actionPerformedBy, int start, int end,
		OrderByComparator<MOIAudit> orderByComparator) {

		return getPersistence().findByActionPerformedBy(
			actionPerformedBy, start, end, orderByComparator);
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
	public static List<MOIAudit> findByActionPerformedBy(
		String actionPerformedBy, int start, int end,
		OrderByComparator<MOIAudit> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByActionPerformedBy(
			actionPerformedBy, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first moi audit in the ordered set where actionPerformedBy = &#63;.
	 *
	 * @param actionPerformedBy the action performed by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	public static MOIAudit findByActionPerformedBy_First(
			String actionPerformedBy,
			OrderByComparator<MOIAudit> orderByComparator)
		throws com.moi.dms.audit.exception.NoSuchMOIAuditException {

		return getPersistence().findByActionPerformedBy_First(
			actionPerformedBy, orderByComparator);
	}

	/**
	 * Returns the first moi audit in the ordered set where actionPerformedBy = &#63;.
	 *
	 * @param actionPerformedBy the action performed by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	public static MOIAudit fetchByActionPerformedBy_First(
		String actionPerformedBy,
		OrderByComparator<MOIAudit> orderByComparator) {

		return getPersistence().fetchByActionPerformedBy_First(
			actionPerformedBy, orderByComparator);
	}

	/**
	 * Returns the last moi audit in the ordered set where actionPerformedBy = &#63;.
	 *
	 * @param actionPerformedBy the action performed by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	public static MOIAudit findByActionPerformedBy_Last(
			String actionPerformedBy,
			OrderByComparator<MOIAudit> orderByComparator)
		throws com.moi.dms.audit.exception.NoSuchMOIAuditException {

		return getPersistence().findByActionPerformedBy_Last(
			actionPerformedBy, orderByComparator);
	}

	/**
	 * Returns the last moi audit in the ordered set where actionPerformedBy = &#63;.
	 *
	 * @param actionPerformedBy the action performed by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	public static MOIAudit fetchByActionPerformedBy_Last(
		String actionPerformedBy,
		OrderByComparator<MOIAudit> orderByComparator) {

		return getPersistence().fetchByActionPerformedBy_Last(
			actionPerformedBy, orderByComparator);
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
	public static MOIAudit[] findByActionPerformedBy_PrevAndNext(
			long auditId, String actionPerformedBy,
			OrderByComparator<MOIAudit> orderByComparator)
		throws com.moi.dms.audit.exception.NoSuchMOIAuditException {

		return getPersistence().findByActionPerformedBy_PrevAndNext(
			auditId, actionPerformedBy, orderByComparator);
	}

	/**
	 * Removes all the moi audits where actionPerformedBy = &#63; from the database.
	 *
	 * @param actionPerformedBy the action performed by
	 */
	public static void removeByActionPerformedBy(String actionPerformedBy) {
		getPersistence().removeByActionPerformedBy(actionPerformedBy);
	}

	/**
	 * Returns the number of moi audits where actionPerformedBy = &#63;.
	 *
	 * @param actionPerformedBy the action performed by
	 * @return the number of matching moi audits
	 */
	public static int countByActionPerformedBy(String actionPerformedBy) {
		return getPersistence().countByActionPerformedBy(actionPerformedBy);
	}

	/**
	 * Returns all the moi audits where actionPerformedDate = &#63;.
	 *
	 * @param actionPerformedDate the action performed date
	 * @return the matching moi audits
	 */
	public static List<MOIAudit> findByAtionPerformedDate(
		Date actionPerformedDate) {

		return getPersistence().findByAtionPerformedDate(actionPerformedDate);
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
	public static List<MOIAudit> findByAtionPerformedDate(
		Date actionPerformedDate, int start, int end) {

		return getPersistence().findByAtionPerformedDate(
			actionPerformedDate, start, end);
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
	public static List<MOIAudit> findByAtionPerformedDate(
		Date actionPerformedDate, int start, int end,
		OrderByComparator<MOIAudit> orderByComparator) {

		return getPersistence().findByAtionPerformedDate(
			actionPerformedDate, start, end, orderByComparator);
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
	public static List<MOIAudit> findByAtionPerformedDate(
		Date actionPerformedDate, int start, int end,
		OrderByComparator<MOIAudit> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByAtionPerformedDate(
			actionPerformedDate, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first moi audit in the ordered set where actionPerformedDate = &#63;.
	 *
	 * @param actionPerformedDate the action performed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	public static MOIAudit findByAtionPerformedDate_First(
			Date actionPerformedDate,
			OrderByComparator<MOIAudit> orderByComparator)
		throws com.moi.dms.audit.exception.NoSuchMOIAuditException {

		return getPersistence().findByAtionPerformedDate_First(
			actionPerformedDate, orderByComparator);
	}

	/**
	 * Returns the first moi audit in the ordered set where actionPerformedDate = &#63;.
	 *
	 * @param actionPerformedDate the action performed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	public static MOIAudit fetchByAtionPerformedDate_First(
		Date actionPerformedDate,
		OrderByComparator<MOIAudit> orderByComparator) {

		return getPersistence().fetchByAtionPerformedDate_First(
			actionPerformedDate, orderByComparator);
	}

	/**
	 * Returns the last moi audit in the ordered set where actionPerformedDate = &#63;.
	 *
	 * @param actionPerformedDate the action performed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	public static MOIAudit findByAtionPerformedDate_Last(
			Date actionPerformedDate,
			OrderByComparator<MOIAudit> orderByComparator)
		throws com.moi.dms.audit.exception.NoSuchMOIAuditException {

		return getPersistence().findByAtionPerformedDate_Last(
			actionPerformedDate, orderByComparator);
	}

	/**
	 * Returns the last moi audit in the ordered set where actionPerformedDate = &#63;.
	 *
	 * @param actionPerformedDate the action performed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	public static MOIAudit fetchByAtionPerformedDate_Last(
		Date actionPerformedDate,
		OrderByComparator<MOIAudit> orderByComparator) {

		return getPersistence().fetchByAtionPerformedDate_Last(
			actionPerformedDate, orderByComparator);
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
	public static MOIAudit[] findByAtionPerformedDate_PrevAndNext(
			long auditId, Date actionPerformedDate,
			OrderByComparator<MOIAudit> orderByComparator)
		throws com.moi.dms.audit.exception.NoSuchMOIAuditException {

		return getPersistence().findByAtionPerformedDate_PrevAndNext(
			auditId, actionPerformedDate, orderByComparator);
	}

	/**
	 * Removes all the moi audits where actionPerformedDate = &#63; from the database.
	 *
	 * @param actionPerformedDate the action performed date
	 */
	public static void removeByAtionPerformedDate(Date actionPerformedDate) {
		getPersistence().removeByAtionPerformedDate(actionPerformedDate);
	}

	/**
	 * Returns the number of moi audits where actionPerformedDate = &#63;.
	 *
	 * @param actionPerformedDate the action performed date
	 * @return the number of matching moi audits
	 */
	public static int countByAtionPerformedDate(Date actionPerformedDate) {
		return getPersistence().countByAtionPerformedDate(actionPerformedDate);
	}

	/**
	 * Returns all the moi audits where actionStatus = &#63;.
	 *
	 * @param actionStatus the action status
	 * @return the matching moi audits
	 */
	public static List<MOIAudit> findByActionStatus(String actionStatus) {
		return getPersistence().findByActionStatus(actionStatus);
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
	public static List<MOIAudit> findByActionStatus(
		String actionStatus, int start, int end) {

		return getPersistence().findByActionStatus(actionStatus, start, end);
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
	public static List<MOIAudit> findByActionStatus(
		String actionStatus, int start, int end,
		OrderByComparator<MOIAudit> orderByComparator) {

		return getPersistence().findByActionStatus(
			actionStatus, start, end, orderByComparator);
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
	public static List<MOIAudit> findByActionStatus(
		String actionStatus, int start, int end,
		OrderByComparator<MOIAudit> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByActionStatus(
			actionStatus, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first moi audit in the ordered set where actionStatus = &#63;.
	 *
	 * @param actionStatus the action status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	public static MOIAudit findByActionStatus_First(
			String actionStatus, OrderByComparator<MOIAudit> orderByComparator)
		throws com.moi.dms.audit.exception.NoSuchMOIAuditException {

		return getPersistence().findByActionStatus_First(
			actionStatus, orderByComparator);
	}

	/**
	 * Returns the first moi audit in the ordered set where actionStatus = &#63;.
	 *
	 * @param actionStatus the action status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	public static MOIAudit fetchByActionStatus_First(
		String actionStatus, OrderByComparator<MOIAudit> orderByComparator) {

		return getPersistence().fetchByActionStatus_First(
			actionStatus, orderByComparator);
	}

	/**
	 * Returns the last moi audit in the ordered set where actionStatus = &#63;.
	 *
	 * @param actionStatus the action status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	public static MOIAudit findByActionStatus_Last(
			String actionStatus, OrderByComparator<MOIAudit> orderByComparator)
		throws com.moi.dms.audit.exception.NoSuchMOIAuditException {

		return getPersistence().findByActionStatus_Last(
			actionStatus, orderByComparator);
	}

	/**
	 * Returns the last moi audit in the ordered set where actionStatus = &#63;.
	 *
	 * @param actionStatus the action status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	public static MOIAudit fetchByActionStatus_Last(
		String actionStatus, OrderByComparator<MOIAudit> orderByComparator) {

		return getPersistence().fetchByActionStatus_Last(
			actionStatus, orderByComparator);
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
	public static MOIAudit[] findByActionStatus_PrevAndNext(
			long auditId, String actionStatus,
			OrderByComparator<MOIAudit> orderByComparator)
		throws com.moi.dms.audit.exception.NoSuchMOIAuditException {

		return getPersistence().findByActionStatus_PrevAndNext(
			auditId, actionStatus, orderByComparator);
	}

	/**
	 * Removes all the moi audits where actionStatus = &#63; from the database.
	 *
	 * @param actionStatus the action status
	 */
	public static void removeByActionStatus(String actionStatus) {
		getPersistence().removeByActionStatus(actionStatus);
	}

	/**
	 * Returns the number of moi audits where actionStatus = &#63;.
	 *
	 * @param actionStatus the action status
	 * @return the number of matching moi audits
	 */
	public static int countByActionStatus(String actionStatus) {
		return getPersistence().countByActionStatus(actionStatus);
	}

	/**
	 * Returns all the moi audits where actionDescription = &#63;.
	 *
	 * @param actionDescription the action description
	 * @return the matching moi audits
	 */
	public static List<MOIAudit> findByActionDescription(
		String actionDescription) {

		return getPersistence().findByActionDescription(actionDescription);
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
	public static List<MOIAudit> findByActionDescription(
		String actionDescription, int start, int end) {

		return getPersistence().findByActionDescription(
			actionDescription, start, end);
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
	public static List<MOIAudit> findByActionDescription(
		String actionDescription, int start, int end,
		OrderByComparator<MOIAudit> orderByComparator) {

		return getPersistence().findByActionDescription(
			actionDescription, start, end, orderByComparator);
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
	public static List<MOIAudit> findByActionDescription(
		String actionDescription, int start, int end,
		OrderByComparator<MOIAudit> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByActionDescription(
			actionDescription, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first moi audit in the ordered set where actionDescription = &#63;.
	 *
	 * @param actionDescription the action description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	public static MOIAudit findByActionDescription_First(
			String actionDescription,
			OrderByComparator<MOIAudit> orderByComparator)
		throws com.moi.dms.audit.exception.NoSuchMOIAuditException {

		return getPersistence().findByActionDescription_First(
			actionDescription, orderByComparator);
	}

	/**
	 * Returns the first moi audit in the ordered set where actionDescription = &#63;.
	 *
	 * @param actionDescription the action description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	public static MOIAudit fetchByActionDescription_First(
		String actionDescription,
		OrderByComparator<MOIAudit> orderByComparator) {

		return getPersistence().fetchByActionDescription_First(
			actionDescription, orderByComparator);
	}

	/**
	 * Returns the last moi audit in the ordered set where actionDescription = &#63;.
	 *
	 * @param actionDescription the action description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	public static MOIAudit findByActionDescription_Last(
			String actionDescription,
			OrderByComparator<MOIAudit> orderByComparator)
		throws com.moi.dms.audit.exception.NoSuchMOIAuditException {

		return getPersistence().findByActionDescription_Last(
			actionDescription, orderByComparator);
	}

	/**
	 * Returns the last moi audit in the ordered set where actionDescription = &#63;.
	 *
	 * @param actionDescription the action description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	public static MOIAudit fetchByActionDescription_Last(
		String actionDescription,
		OrderByComparator<MOIAudit> orderByComparator) {

		return getPersistence().fetchByActionDescription_Last(
			actionDescription, orderByComparator);
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
	public static MOIAudit[] findByActionDescription_PrevAndNext(
			long auditId, String actionDescription,
			OrderByComparator<MOIAudit> orderByComparator)
		throws com.moi.dms.audit.exception.NoSuchMOIAuditException {

		return getPersistence().findByActionDescription_PrevAndNext(
			auditId, actionDescription, orderByComparator);
	}

	/**
	 * Removes all the moi audits where actionDescription = &#63; from the database.
	 *
	 * @param actionDescription the action description
	 */
	public static void removeByActionDescription(String actionDescription) {
		getPersistence().removeByActionDescription(actionDescription);
	}

	/**
	 * Returns the number of moi audits where actionDescription = &#63;.
	 *
	 * @param actionDescription the action description
	 * @return the number of matching moi audits
	 */
	public static int countByActionDescription(String actionDescription) {
		return getPersistence().countByActionDescription(actionDescription);
	}

	/**
	 * Returns all the moi audits where actionConsumer = &#63;.
	 *
	 * @param actionConsumer the action consumer
	 * @return the matching moi audits
	 */
	public static List<MOIAudit> findByActionConsumer(String actionConsumer) {
		return getPersistence().findByActionConsumer(actionConsumer);
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
	public static List<MOIAudit> findByActionConsumer(
		String actionConsumer, int start, int end) {

		return getPersistence().findByActionConsumer(
			actionConsumer, start, end);
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
	public static List<MOIAudit> findByActionConsumer(
		String actionConsumer, int start, int end,
		OrderByComparator<MOIAudit> orderByComparator) {

		return getPersistence().findByActionConsumer(
			actionConsumer, start, end, orderByComparator);
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
	public static List<MOIAudit> findByActionConsumer(
		String actionConsumer, int start, int end,
		OrderByComparator<MOIAudit> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByActionConsumer(
			actionConsumer, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first moi audit in the ordered set where actionConsumer = &#63;.
	 *
	 * @param actionConsumer the action consumer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	public static MOIAudit findByActionConsumer_First(
			String actionConsumer,
			OrderByComparator<MOIAudit> orderByComparator)
		throws com.moi.dms.audit.exception.NoSuchMOIAuditException {

		return getPersistence().findByActionConsumer_First(
			actionConsumer, orderByComparator);
	}

	/**
	 * Returns the first moi audit in the ordered set where actionConsumer = &#63;.
	 *
	 * @param actionConsumer the action consumer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	public static MOIAudit fetchByActionConsumer_First(
		String actionConsumer, OrderByComparator<MOIAudit> orderByComparator) {

		return getPersistence().fetchByActionConsumer_First(
			actionConsumer, orderByComparator);
	}

	/**
	 * Returns the last moi audit in the ordered set where actionConsumer = &#63;.
	 *
	 * @param actionConsumer the action consumer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	public static MOIAudit findByActionConsumer_Last(
			String actionConsumer,
			OrderByComparator<MOIAudit> orderByComparator)
		throws com.moi.dms.audit.exception.NoSuchMOIAuditException {

		return getPersistence().findByActionConsumer_Last(
			actionConsumer, orderByComparator);
	}

	/**
	 * Returns the last moi audit in the ordered set where actionConsumer = &#63;.
	 *
	 * @param actionConsumer the action consumer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	public static MOIAudit fetchByActionConsumer_Last(
		String actionConsumer, OrderByComparator<MOIAudit> orderByComparator) {

		return getPersistence().fetchByActionConsumer_Last(
			actionConsumer, orderByComparator);
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
	public static MOIAudit[] findByActionConsumer_PrevAndNext(
			long auditId, String actionConsumer,
			OrderByComparator<MOIAudit> orderByComparator)
		throws com.moi.dms.audit.exception.NoSuchMOIAuditException {

		return getPersistence().findByActionConsumer_PrevAndNext(
			auditId, actionConsumer, orderByComparator);
	}

	/**
	 * Removes all the moi audits where actionConsumer = &#63; from the database.
	 *
	 * @param actionConsumer the action consumer
	 */
	public static void removeByActionConsumer(String actionConsumer) {
		getPersistence().removeByActionConsumer(actionConsumer);
	}

	/**
	 * Returns the number of moi audits where actionConsumer = &#63;.
	 *
	 * @param actionConsumer the action consumer
	 * @return the number of matching moi audits
	 */
	public static int countByActionConsumer(String actionConsumer) {
		return getPersistence().countByActionConsumer(actionConsumer);
	}

	/**
	 * Caches the moi audit in the entity cache if it is enabled.
	 *
	 * @param moiAudit the moi audit
	 */
	public static void cacheResult(MOIAudit moiAudit) {
		getPersistence().cacheResult(moiAudit);
	}

	/**
	 * Caches the moi audits in the entity cache if it is enabled.
	 *
	 * @param moiAudits the moi audits
	 */
	public static void cacheResult(List<MOIAudit> moiAudits) {
		getPersistence().cacheResult(moiAudits);
	}

	/**
	 * Creates a new moi audit with the primary key. Does not add the moi audit to the database.
	 *
	 * @param auditId the primary key for the new moi audit
	 * @return the new moi audit
	 */
	public static MOIAudit create(long auditId) {
		return getPersistence().create(auditId);
	}

	/**
	 * Removes the moi audit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param auditId the primary key of the moi audit
	 * @return the moi audit that was removed
	 * @throws NoSuchMOIAuditException if a moi audit with the primary key could not be found
	 */
	public static MOIAudit remove(long auditId)
		throws com.moi.dms.audit.exception.NoSuchMOIAuditException {

		return getPersistence().remove(auditId);
	}

	public static MOIAudit updateImpl(MOIAudit moiAudit) {
		return getPersistence().updateImpl(moiAudit);
	}

	/**
	 * Returns the moi audit with the primary key or throws a <code>NoSuchMOIAuditException</code> if it could not be found.
	 *
	 * @param auditId the primary key of the moi audit
	 * @return the moi audit
	 * @throws NoSuchMOIAuditException if a moi audit with the primary key could not be found
	 */
	public static MOIAudit findByPrimaryKey(long auditId)
		throws com.moi.dms.audit.exception.NoSuchMOIAuditException {

		return getPersistence().findByPrimaryKey(auditId);
	}

	/**
	 * Returns the moi audit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param auditId the primary key of the moi audit
	 * @return the moi audit, or <code>null</code> if a moi audit with the primary key could not be found
	 */
	public static MOIAudit fetchByPrimaryKey(long auditId) {
		return getPersistence().fetchByPrimaryKey(auditId);
	}

	/**
	 * Returns all the moi audits.
	 *
	 * @return the moi audits
	 */
	public static List<MOIAudit> findAll() {
		return getPersistence().findAll();
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
	public static List<MOIAudit> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<MOIAudit> findAll(
		int start, int end, OrderByComparator<MOIAudit> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<MOIAudit> findAll(
		int start, int end, OrderByComparator<MOIAudit> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the moi audits from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of moi audits.
	 *
	 * @return the number of moi audits
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MOIAuditPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MOIAuditPersistence, MOIAuditPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MOIAuditPersistence.class);

		ServiceTracker<MOIAuditPersistence, MOIAuditPersistence>
			serviceTracker =
				new ServiceTracker<MOIAuditPersistence, MOIAuditPersistence>(
					bundle.getBundleContext(), MOIAuditPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}