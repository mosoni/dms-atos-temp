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
 * Provides the remote service utility for MOIAudit. This utility wraps
 * <code>com.moi.dms.audit.service.impl.MOIAuditServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see MOIAuditService
 * @generated
 */
public class MOIAuditServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.moi.dms.audit.service.impl.MOIAuditServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static java.util.List<com.moi.dms.audit.model.MOIAudit>
		getMOIAuditByKeywords(
			String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.moi.dms.audit.model.MOIAudit> orderByComparator) {

		return getService().getMOIAuditByKeywords(
			keywords, start, end, orderByComparator);
	}

	/**
	 * Remote service to fetch MOIAudit using keywords
	 *
	 * @param keywords
	 * @param fromDate
	 * @param toDate
	 * @param start
	 * @param end
	 * @param orderByComparator
	 * @return List<MOIAudit>
	 */
	public static java.util.List<com.moi.dms.audit.model.MOIAudit>
		getMOIAuditBySearchCriteria(
			String keywords, String fromDate, String toDate, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.moi.dms.audit.model.MOIAudit> orderByComparator) {

		return getService().getMOIAuditBySearchCriteria(
			keywords, fromDate, toDate, start, end, orderByComparator);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static MOIAuditService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MOIAuditService, MOIAuditService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MOIAuditService.class);

		ServiceTracker<MOIAuditService, MOIAuditService> serviceTracker =
			new ServiceTracker<MOIAuditService, MOIAuditService>(
				bundle.getBundleContext(), MOIAuditService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}