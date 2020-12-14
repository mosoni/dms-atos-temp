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

package com.moi.dms.audit.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for MOIAudit. This utility wraps
 * <code>com.moi.dms.audit.service.impl.MOIAuditLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MOIAuditLocalService
 * @generated
 */
public class MOIAuditLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.moi.dms.audit.service.impl.MOIAuditLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the moi audit to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MOIAuditLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param moiAudit the moi audit
	 * @return the moi audit that was added
	 */
	public static com.moi.dms.audit.model.MOIAudit addMOIAudit(
		com.moi.dms.audit.model.MOIAudit moiAudit) {

		return getService().addMOIAudit(moiAudit);
	}

	/**
	 * Creates a new moi audit with the primary key. Does not add the moi audit to the database.
	 *
	 * @param auditId the primary key for the new moi audit
	 * @return the new moi audit
	 */
	public static com.moi.dms.audit.model.MOIAudit createMOIAudit(
		long auditId) {

		return getService().createMOIAudit(auditId);
	}

	/**
	 * Deletes the moi audit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MOIAuditLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param auditId the primary key of the moi audit
	 * @return the moi audit that was removed
	 * @throws PortalException if a moi audit with the primary key could not be found
	 */
	public static com.moi.dms.audit.model.MOIAudit deleteMOIAudit(long auditId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteMOIAudit(auditId);
	}

	/**
	 * Deletes the moi audit from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MOIAuditLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param moiAudit the moi audit
	 * @return the moi audit that was removed
	 */
	public static com.moi.dms.audit.model.MOIAudit deleteMOIAudit(
		com.moi.dms.audit.model.MOIAudit moiAudit) {

		return getService().deleteMOIAudit(moiAudit);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.moi.dms.audit.model.impl.MOIAuditModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.moi.dms.audit.model.impl.MOIAuditModelImpl</code>.
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

	public static com.moi.dms.audit.model.MOIAudit fetchMOIAudit(long auditId) {
		return getService().fetchMOIAudit(auditId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the moi audit with the primary key.
	 *
	 * @param auditId the primary key of the moi audit
	 * @return the moi audit
	 * @throws PortalException if a moi audit with the primary key could not be found
	 */
	public static com.moi.dms.audit.model.MOIAudit getMOIAudit(long auditId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getMOIAudit(auditId);
	}

	public static java.util.List<com.moi.dms.audit.model.MOIAudit>
		getMOIAuditByKeywords(
			String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.moi.dms.audit.model.MOIAudit> orderByComparator) {

		return getService().getMOIAuditByKeywords(
			keywords, start, end, orderByComparator);
	}

	public static java.util.List<com.moi.dms.audit.model.MOIAudit>
		getMOIAuditBySearchCriteria(
			String keywords, String fromDate, String toDate, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.moi.dms.audit.model.MOIAudit> orderByComparator) {

		return getService().getMOIAuditBySearchCriteria(
			keywords, fromDate, toDate, start, end, orderByComparator);
	}

	/**
	 * Returns a range of all the moi audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.moi.dms.audit.model.impl.MOIAuditModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of moi audits
	 * @param end the upper bound of the range of moi audits (not inclusive)
	 * @return the range of moi audits
	 */
	public static java.util.List<com.moi.dms.audit.model.MOIAudit> getMOIAudits(
		int start, int end) {

		return getService().getMOIAudits(start, end);
	}

	/**
	 * Returns the number of moi audits.
	 *
	 * @return the number of moi audits
	 */
	public static int getMOIAuditsCount() {
		return getService().getMOIAuditsCount();
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
	 * Updates the moi audit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MOIAuditLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param moiAudit the moi audit
	 * @return the moi audit that was updated
	 */
	public static com.moi.dms.audit.model.MOIAudit updateMOIAudit(
		com.moi.dms.audit.model.MOIAudit moiAudit) {

		return getService().updateMOIAudit(moiAudit);
	}

	public static MOIAuditLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MOIAuditLocalService, MOIAuditLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MOIAuditLocalService.class);

		ServiceTracker<MOIAuditLocalService, MOIAuditLocalService>
			serviceTracker =
				new ServiceTracker<MOIAuditLocalService, MOIAuditLocalService>(
					bundle.getBundleContext(), MOIAuditLocalService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}