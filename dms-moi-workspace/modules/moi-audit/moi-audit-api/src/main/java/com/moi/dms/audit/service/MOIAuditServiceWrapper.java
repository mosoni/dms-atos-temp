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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MOIAuditService}.
 *
 * @author Brian Wing Shun Chan
 * @see MOIAuditService
 * @generated
 */
public class MOIAuditServiceWrapper
	implements MOIAuditService, ServiceWrapper<MOIAuditService> {

	public MOIAuditServiceWrapper(MOIAuditService moiAuditService) {
		_moiAuditService = moiAuditService;
	}

	@Override
	public java.util.List<com.moi.dms.audit.model.MOIAudit>
		getMOIAuditByKeywords(
			String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.moi.dms.audit.model.MOIAudit> orderByComparator) {

		return _moiAuditService.getMOIAuditByKeywords(
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
	@Override
	public java.util.List<com.moi.dms.audit.model.MOIAudit>
		getMOIAuditBySearchCriteria(
			String keywords, String fromDate, String toDate, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.moi.dms.audit.model.MOIAudit> orderByComparator) {

		return _moiAuditService.getMOIAuditBySearchCriteria(
			keywords, fromDate, toDate, start, end, orderByComparator);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _moiAuditService.getOSGiServiceIdentifier();
	}

	@Override
	public MOIAuditService getWrappedService() {
		return _moiAuditService;
	}

	@Override
	public void setWrappedService(MOIAuditService moiAuditService) {
		_moiAuditService = moiAuditService;
	}

	private MOIAuditService _moiAuditService;

}