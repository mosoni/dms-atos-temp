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

package com.moi.dms.audit.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.moi.dms.audit.model.MOIAudit;
import com.moi.dms.audit.service.base.MOIAuditServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the moi audit remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.moi.dms.audit.service.MOIAuditService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MOIAuditServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=moiaudit",
		"json.web.service.context.path=MOIAudit"
	},
	service = AopService.class
)
public class MOIAuditServiceImpl extends MOIAuditServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.moi.dms.audit.service.MOIAuditServiceUtil</code> to access the moi audit remote service.
	 */
	
	public List<MOIAudit> getMOIAuditByKeywords(String keywords,
			int start, int end,
			OrderByComparator<MOIAudit> orderByComparator) {

		return moiAuditLocalService.getMOIAuditByKeywords(
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
	public List<MOIAudit> getMOIAuditBySearchCriteria(
			String keywords, String fromDate, String toDate, int start, int end,
			OrderByComparator<MOIAudit> orderByComparator) {

		return moiAuditLocalService.getMOIAuditBySearchCriteria(
				keywords, fromDate, toDate, start, end, orderByComparator);
	}
}