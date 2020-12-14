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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.moi.dms.audit.exception.NoSuchMOIAuditException;
import com.moi.dms.audit.model.MOIAudit;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the moi audit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MOIAuditUtil
 * @generated
 */
@ProviderType
public interface MOIAuditPersistence extends BasePersistence<MOIAudit> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MOIAuditUtil} to access the moi audit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the moi audits where auditId = &#63;.
	 *
	 * @param auditId the audit ID
	 * @return the matching moi audits
	 */
	public java.util.List<MOIAudit> findByAuditId(long auditId);

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
	public java.util.List<MOIAudit> findByAuditId(
		long auditId, int start, int end);

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
	public java.util.List<MOIAudit> findByAuditId(
		long auditId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
			orderByComparator);

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
	public java.util.List<MOIAudit> findByAuditId(
		long auditId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi audit in the ordered set where auditId = &#63;.
	 *
	 * @param auditId the audit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	public MOIAudit findByAuditId_First(
			long auditId,
			com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
				orderByComparator)
		throws NoSuchMOIAuditException;

	/**
	 * Returns the first moi audit in the ordered set where auditId = &#63;.
	 *
	 * @param auditId the audit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	public MOIAudit fetchByAuditId_First(
		long auditId,
		com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
			orderByComparator);

	/**
	 * Returns the last moi audit in the ordered set where auditId = &#63;.
	 *
	 * @param auditId the audit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	public MOIAudit findByAuditId_Last(
			long auditId,
			com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
				orderByComparator)
		throws NoSuchMOIAuditException;

	/**
	 * Returns the last moi audit in the ordered set where auditId = &#63;.
	 *
	 * @param auditId the audit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	public MOIAudit fetchByAuditId_Last(
		long auditId,
		com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
			orderByComparator);

	/**
	 * Removes all the moi audits where auditId = &#63; from the database.
	 *
	 * @param auditId the audit ID
	 */
	public void removeByAuditId(long auditId);

	/**
	 * Returns the number of moi audits where auditId = &#63;.
	 *
	 * @param auditId the audit ID
	 * @return the number of matching moi audits
	 */
	public int countByAuditId(long auditId);

	/**
	 * Returns all the moi audits where actionPerformedBy = &#63;.
	 *
	 * @param actionPerformedBy the action performed by
	 * @return the matching moi audits
	 */
	public java.util.List<MOIAudit> findByActionPerformedBy(
		String actionPerformedBy);

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
	public java.util.List<MOIAudit> findByActionPerformedBy(
		String actionPerformedBy, int start, int end);

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
	public java.util.List<MOIAudit> findByActionPerformedBy(
		String actionPerformedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
			orderByComparator);

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
	public java.util.List<MOIAudit> findByActionPerformedBy(
		String actionPerformedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi audit in the ordered set where actionPerformedBy = &#63;.
	 *
	 * @param actionPerformedBy the action performed by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	public MOIAudit findByActionPerformedBy_First(
			String actionPerformedBy,
			com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
				orderByComparator)
		throws NoSuchMOIAuditException;

	/**
	 * Returns the first moi audit in the ordered set where actionPerformedBy = &#63;.
	 *
	 * @param actionPerformedBy the action performed by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	public MOIAudit fetchByActionPerformedBy_First(
		String actionPerformedBy,
		com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
			orderByComparator);

	/**
	 * Returns the last moi audit in the ordered set where actionPerformedBy = &#63;.
	 *
	 * @param actionPerformedBy the action performed by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	public MOIAudit findByActionPerformedBy_Last(
			String actionPerformedBy,
			com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
				orderByComparator)
		throws NoSuchMOIAuditException;

	/**
	 * Returns the last moi audit in the ordered set where actionPerformedBy = &#63;.
	 *
	 * @param actionPerformedBy the action performed by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	public MOIAudit fetchByActionPerformedBy_Last(
		String actionPerformedBy,
		com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
			orderByComparator);

	/**
	 * Returns the moi audits before and after the current moi audit in the ordered set where actionPerformedBy = &#63;.
	 *
	 * @param auditId the primary key of the current moi audit
	 * @param actionPerformedBy the action performed by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi audit
	 * @throws NoSuchMOIAuditException if a moi audit with the primary key could not be found
	 */
	public MOIAudit[] findByActionPerformedBy_PrevAndNext(
			long auditId, String actionPerformedBy,
			com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
				orderByComparator)
		throws NoSuchMOIAuditException;

	/**
	 * Removes all the moi audits where actionPerformedBy = &#63; from the database.
	 *
	 * @param actionPerformedBy the action performed by
	 */
	public void removeByActionPerformedBy(String actionPerformedBy);

	/**
	 * Returns the number of moi audits where actionPerformedBy = &#63;.
	 *
	 * @param actionPerformedBy the action performed by
	 * @return the number of matching moi audits
	 */
	public int countByActionPerformedBy(String actionPerformedBy);

	/**
	 * Returns all the moi audits where actionPerformedDate = &#63;.
	 *
	 * @param actionPerformedDate the action performed date
	 * @return the matching moi audits
	 */
	public java.util.List<MOIAudit> findByAtionPerformedDate(
		Date actionPerformedDate);

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
	public java.util.List<MOIAudit> findByAtionPerformedDate(
		Date actionPerformedDate, int start, int end);

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
	public java.util.List<MOIAudit> findByAtionPerformedDate(
		Date actionPerformedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
			orderByComparator);

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
	public java.util.List<MOIAudit> findByAtionPerformedDate(
		Date actionPerformedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi audit in the ordered set where actionPerformedDate = &#63;.
	 *
	 * @param actionPerformedDate the action performed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	public MOIAudit findByAtionPerformedDate_First(
			Date actionPerformedDate,
			com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
				orderByComparator)
		throws NoSuchMOIAuditException;

	/**
	 * Returns the first moi audit in the ordered set where actionPerformedDate = &#63;.
	 *
	 * @param actionPerformedDate the action performed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	public MOIAudit fetchByAtionPerformedDate_First(
		Date actionPerformedDate,
		com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
			orderByComparator);

	/**
	 * Returns the last moi audit in the ordered set where actionPerformedDate = &#63;.
	 *
	 * @param actionPerformedDate the action performed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	public MOIAudit findByAtionPerformedDate_Last(
			Date actionPerformedDate,
			com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
				orderByComparator)
		throws NoSuchMOIAuditException;

	/**
	 * Returns the last moi audit in the ordered set where actionPerformedDate = &#63;.
	 *
	 * @param actionPerformedDate the action performed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	public MOIAudit fetchByAtionPerformedDate_Last(
		Date actionPerformedDate,
		com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
			orderByComparator);

	/**
	 * Returns the moi audits before and after the current moi audit in the ordered set where actionPerformedDate = &#63;.
	 *
	 * @param auditId the primary key of the current moi audit
	 * @param actionPerformedDate the action performed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi audit
	 * @throws NoSuchMOIAuditException if a moi audit with the primary key could not be found
	 */
	public MOIAudit[] findByAtionPerformedDate_PrevAndNext(
			long auditId, Date actionPerformedDate,
			com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
				orderByComparator)
		throws NoSuchMOIAuditException;

	/**
	 * Removes all the moi audits where actionPerformedDate = &#63; from the database.
	 *
	 * @param actionPerformedDate the action performed date
	 */
	public void removeByAtionPerformedDate(Date actionPerformedDate);

	/**
	 * Returns the number of moi audits where actionPerformedDate = &#63;.
	 *
	 * @param actionPerformedDate the action performed date
	 * @return the number of matching moi audits
	 */
	public int countByAtionPerformedDate(Date actionPerformedDate);

	/**
	 * Returns all the moi audits where actionStatus = &#63;.
	 *
	 * @param actionStatus the action status
	 * @return the matching moi audits
	 */
	public java.util.List<MOIAudit> findByActionStatus(String actionStatus);

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
	public java.util.List<MOIAudit> findByActionStatus(
		String actionStatus, int start, int end);

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
	public java.util.List<MOIAudit> findByActionStatus(
		String actionStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
			orderByComparator);

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
	public java.util.List<MOIAudit> findByActionStatus(
		String actionStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi audit in the ordered set where actionStatus = &#63;.
	 *
	 * @param actionStatus the action status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	public MOIAudit findByActionStatus_First(
			String actionStatus,
			com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
				orderByComparator)
		throws NoSuchMOIAuditException;

	/**
	 * Returns the first moi audit in the ordered set where actionStatus = &#63;.
	 *
	 * @param actionStatus the action status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	public MOIAudit fetchByActionStatus_First(
		String actionStatus,
		com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
			orderByComparator);

	/**
	 * Returns the last moi audit in the ordered set where actionStatus = &#63;.
	 *
	 * @param actionStatus the action status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	public MOIAudit findByActionStatus_Last(
			String actionStatus,
			com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
				orderByComparator)
		throws NoSuchMOIAuditException;

	/**
	 * Returns the last moi audit in the ordered set where actionStatus = &#63;.
	 *
	 * @param actionStatus the action status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	public MOIAudit fetchByActionStatus_Last(
		String actionStatus,
		com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
			orderByComparator);

	/**
	 * Returns the moi audits before and after the current moi audit in the ordered set where actionStatus = &#63;.
	 *
	 * @param auditId the primary key of the current moi audit
	 * @param actionStatus the action status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi audit
	 * @throws NoSuchMOIAuditException if a moi audit with the primary key could not be found
	 */
	public MOIAudit[] findByActionStatus_PrevAndNext(
			long auditId, String actionStatus,
			com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
				orderByComparator)
		throws NoSuchMOIAuditException;

	/**
	 * Removes all the moi audits where actionStatus = &#63; from the database.
	 *
	 * @param actionStatus the action status
	 */
	public void removeByActionStatus(String actionStatus);

	/**
	 * Returns the number of moi audits where actionStatus = &#63;.
	 *
	 * @param actionStatus the action status
	 * @return the number of matching moi audits
	 */
	public int countByActionStatus(String actionStatus);

	/**
	 * Returns all the moi audits where actionDescription = &#63;.
	 *
	 * @param actionDescription the action description
	 * @return the matching moi audits
	 */
	public java.util.List<MOIAudit> findByActionDescription(
		String actionDescription);

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
	public java.util.List<MOIAudit> findByActionDescription(
		String actionDescription, int start, int end);

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
	public java.util.List<MOIAudit> findByActionDescription(
		String actionDescription, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
			orderByComparator);

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
	public java.util.List<MOIAudit> findByActionDescription(
		String actionDescription, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi audit in the ordered set where actionDescription = &#63;.
	 *
	 * @param actionDescription the action description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	public MOIAudit findByActionDescription_First(
			String actionDescription,
			com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
				orderByComparator)
		throws NoSuchMOIAuditException;

	/**
	 * Returns the first moi audit in the ordered set where actionDescription = &#63;.
	 *
	 * @param actionDescription the action description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	public MOIAudit fetchByActionDescription_First(
		String actionDescription,
		com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
			orderByComparator);

	/**
	 * Returns the last moi audit in the ordered set where actionDescription = &#63;.
	 *
	 * @param actionDescription the action description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	public MOIAudit findByActionDescription_Last(
			String actionDescription,
			com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
				orderByComparator)
		throws NoSuchMOIAuditException;

	/**
	 * Returns the last moi audit in the ordered set where actionDescription = &#63;.
	 *
	 * @param actionDescription the action description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	public MOIAudit fetchByActionDescription_Last(
		String actionDescription,
		com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
			orderByComparator);

	/**
	 * Returns the moi audits before and after the current moi audit in the ordered set where actionDescription = &#63;.
	 *
	 * @param auditId the primary key of the current moi audit
	 * @param actionDescription the action description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi audit
	 * @throws NoSuchMOIAuditException if a moi audit with the primary key could not be found
	 */
	public MOIAudit[] findByActionDescription_PrevAndNext(
			long auditId, String actionDescription,
			com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
				orderByComparator)
		throws NoSuchMOIAuditException;

	/**
	 * Removes all the moi audits where actionDescription = &#63; from the database.
	 *
	 * @param actionDescription the action description
	 */
	public void removeByActionDescription(String actionDescription);

	/**
	 * Returns the number of moi audits where actionDescription = &#63;.
	 *
	 * @param actionDescription the action description
	 * @return the number of matching moi audits
	 */
	public int countByActionDescription(String actionDescription);

	/**
	 * Returns all the moi audits where actionConsumer = &#63;.
	 *
	 * @param actionConsumer the action consumer
	 * @return the matching moi audits
	 */
	public java.util.List<MOIAudit> findByActionConsumer(String actionConsumer);

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
	public java.util.List<MOIAudit> findByActionConsumer(
		String actionConsumer, int start, int end);

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
	public java.util.List<MOIAudit> findByActionConsumer(
		String actionConsumer, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
			orderByComparator);

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
	public java.util.List<MOIAudit> findByActionConsumer(
		String actionConsumer, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi audit in the ordered set where actionConsumer = &#63;.
	 *
	 * @param actionConsumer the action consumer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	public MOIAudit findByActionConsumer_First(
			String actionConsumer,
			com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
				orderByComparator)
		throws NoSuchMOIAuditException;

	/**
	 * Returns the first moi audit in the ordered set where actionConsumer = &#63;.
	 *
	 * @param actionConsumer the action consumer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	public MOIAudit fetchByActionConsumer_First(
		String actionConsumer,
		com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
			orderByComparator);

	/**
	 * Returns the last moi audit in the ordered set where actionConsumer = &#63;.
	 *
	 * @param actionConsumer the action consumer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit
	 * @throws NoSuchMOIAuditException if a matching moi audit could not be found
	 */
	public MOIAudit findByActionConsumer_Last(
			String actionConsumer,
			com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
				orderByComparator)
		throws NoSuchMOIAuditException;

	/**
	 * Returns the last moi audit in the ordered set where actionConsumer = &#63;.
	 *
	 * @param actionConsumer the action consumer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi audit, or <code>null</code> if a matching moi audit could not be found
	 */
	public MOIAudit fetchByActionConsumer_Last(
		String actionConsumer,
		com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
			orderByComparator);

	/**
	 * Returns the moi audits before and after the current moi audit in the ordered set where actionConsumer = &#63;.
	 *
	 * @param auditId the primary key of the current moi audit
	 * @param actionConsumer the action consumer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi audit
	 * @throws NoSuchMOIAuditException if a moi audit with the primary key could not be found
	 */
	public MOIAudit[] findByActionConsumer_PrevAndNext(
			long auditId, String actionConsumer,
			com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
				orderByComparator)
		throws NoSuchMOIAuditException;

	/**
	 * Removes all the moi audits where actionConsumer = &#63; from the database.
	 *
	 * @param actionConsumer the action consumer
	 */
	public void removeByActionConsumer(String actionConsumer);

	/**
	 * Returns the number of moi audits where actionConsumer = &#63;.
	 *
	 * @param actionConsumer the action consumer
	 * @return the number of matching moi audits
	 */
	public int countByActionConsumer(String actionConsumer);

	/**
	 * Caches the moi audit in the entity cache if it is enabled.
	 *
	 * @param moiAudit the moi audit
	 */
	public void cacheResult(MOIAudit moiAudit);

	/**
	 * Caches the moi audits in the entity cache if it is enabled.
	 *
	 * @param moiAudits the moi audits
	 */
	public void cacheResult(java.util.List<MOIAudit> moiAudits);

	/**
	 * Creates a new moi audit with the primary key. Does not add the moi audit to the database.
	 *
	 * @param auditId the primary key for the new moi audit
	 * @return the new moi audit
	 */
	public MOIAudit create(long auditId);

	/**
	 * Removes the moi audit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param auditId the primary key of the moi audit
	 * @return the moi audit that was removed
	 * @throws NoSuchMOIAuditException if a moi audit with the primary key could not be found
	 */
	public MOIAudit remove(long auditId) throws NoSuchMOIAuditException;

	public MOIAudit updateImpl(MOIAudit moiAudit);

	/**
	 * Returns the moi audit with the primary key or throws a <code>NoSuchMOIAuditException</code> if it could not be found.
	 *
	 * @param auditId the primary key of the moi audit
	 * @return the moi audit
	 * @throws NoSuchMOIAuditException if a moi audit with the primary key could not be found
	 */
	public MOIAudit findByPrimaryKey(long auditId)
		throws NoSuchMOIAuditException;

	/**
	 * Returns the moi audit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param auditId the primary key of the moi audit
	 * @return the moi audit, or <code>null</code> if a moi audit with the primary key could not be found
	 */
	public MOIAudit fetchByPrimaryKey(long auditId);

	/**
	 * Returns all the moi audits.
	 *
	 * @return the moi audits
	 */
	public java.util.List<MOIAudit> findAll();

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
	public java.util.List<MOIAudit> findAll(int start, int end);

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
	public java.util.List<MOIAudit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
			orderByComparator);

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
	public java.util.List<MOIAudit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIAudit>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the moi audits from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of moi audits.
	 *
	 * @return the number of moi audits
	 */
	public int countAll();

}