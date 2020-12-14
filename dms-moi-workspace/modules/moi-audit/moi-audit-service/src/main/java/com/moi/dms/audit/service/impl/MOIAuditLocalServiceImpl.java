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
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.moi.dms.audit.model.MOIAudit;
import com.moi.dms.audit.service.base.MOIAuditLocalServiceBaseImpl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the moi audit local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.moi.dms.audit.service.MOIAuditLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MOIAuditLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.moi.dms.audit.model.MOIAudit",
	service = AopService.class
)

public class MOIAuditLocalServiceImpl extends MOIAuditLocalServiceBaseImpl {

	@Override
	public List<MOIAudit> getMOIAuditByKeywords(String keywords, int start,
			int end, OrderByComparator<MOIAudit> orderByComparator) {
		// TODO Auto-generated method stub
		System.out.println("---------- getMOITraceRequestByKeywords -----------");
		return moiAuditLocalService.dynamicQuery(
				getKeywordSearchDynamicQuery(keywords), start, end,
				orderByComparator);
	}
	private DynamicQuery getKeywordSearchDynamicQuery(String keywords) {
		DynamicQuery dynamicQuery = dynamicQuery();
		if (Validator.isNotNull(keywords)) {
			Disjunction disjunctionQuery = RestrictionsFactoryUtil
					.disjunction();
			disjunctionQuery.add(RestrictionsFactoryUtil
					.like("actionPerformedBy", "%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil
					.like("actionStatus", "%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil
					.like("actionDescription", "%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil
					.like("actionConsumer", "%" + keywords + "%"));
			/*
			 * disjunctionQuery.add(RestrictionsFactoryUtil.like("groupId", "%"
			 * + keywords + "%"));
			 */
			dynamicQuery.add(disjunctionQuery);
		}
		return dynamicQuery;
	}
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.moi.dms.audit.service.MOIAuditLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.moi.dms.audit.service.MOIAuditLocalServiceUtil</code>.
	 */
	@Override
	public List<MOIAudit> getMOIAuditBySearchCriteria(String keywords,
			String fromDate, String toDate, int start, int end,
			OrderByComparator<MOIAudit> orderByComparator) {
		// TODO Auto-generated method stub
		return moiAuditLocalService.dynamicQuery(
				getSearchDynamicQuery(keywords, fromDate, toDate), start, end,
				orderByComparator);
	}
	/**
	 * Method for finding MOITraceRequest object using dynamic query.
	 * 
	 * @param keywords
	 * @param fromDate
	 * @param toDate
	 * 
	 * @return DynamicQuery
	 */
	private DynamicQuery getSearchDynamicQuery(String keywords, String fromDate,
			String toDate) {
		DynamicQuery dynamicQuery = dynamicQuery();
		Disjunction disjunctionQuery = RestrictionsFactoryUtil.disjunction();
		if (Validator.isNotNull(keywords)) {
			disjunctionQuery.add(RestrictionsFactoryUtil.like("actionPerformedBy",
					"%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil
					.like("actionStatus", "%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil
					.like("actionDescription", "%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil
					.like("actionConsumer", "%" + keywords + "%"));
			/*
			 * disjunctionQuery.add(RestrictionsFactoryUtil
			 * .like("requestedDocumentType", "%" + keywords + "%"));
			 * disjunctionQuery.add(RestrictionsFactoryUtil.like(
			 * "requestResult", "%" + keywords + "%"));
			 */

		}

		if (Validator.isNotNull(fromDate) && Validator.isNotNull(toDate)) {
			DateTimeFormatter dateFormatter = DateTimeFormatter
					.ofPattern("yyyy-MM-dd HH:mm:ss");
			Date fromDateObj = Date
					.from(LocalDateTime.parse(fromDate, dateFormatter)
							.atZone(ZoneId.systemDefault()).toInstant());
			Date toDateObj = Date
					.from(LocalDateTime.parse(toDate, dateFormatter)
							.atZone(ZoneId.systemDefault()).toInstant());
			disjunctionQuery.add(RestrictionsFactoryUtil
					.between("actionPerformedDate", fromDateObj, toDateObj));
		}

		dynamicQuery.add(disjunctionQuery);
		return dynamicQuery;
	}
}