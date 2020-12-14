package com.moi.dms.audit.control.panel.util;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.moi.dms.audit.control.panel.search.container.MOIAuditDisplayTerms;
import com.moi.dms.audit.control.panel.web.constants.MVCCommandNames;
import com.moi.dms.audit.model.MOIAudit;
import com.moi.dms.audit.service.MOIAuditLocalServiceUtil;
import com.moi.dms.audit.service.MOIAuditServiceUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * Helper/Util class to fetch results by search criteria.
 * 
 * @author Ganesh Shelke
 *
 */
public class MOIAuditHelper {

	/**
	 * Method to fetch MOI Trace requests as per the search criteria.
	 * 
	 * @param displayTerms
	 * @param start
	 * @param end
	 * @return List<MOIAudit>
	 * @throws SystemException
	 */
	public static List<MOIAudit> getMOIAuditRequest(
			MOIAuditDisplayTerms displayTerms, int start, int end)
			throws SystemException {
		List<MOIAudit> traceRequestList = getAuditRequestData(
				displayTerms.getFromDate(), displayTerms.getToDate(),
				displayTerms.getKeywords(), start, end);
		return traceRequestList;
	}

	/**
	 * Method to fetch MOI audits count as per the search criteria.
	 * 
	 * @param displayTerms
	 * @param start
	 * @param end
	 * @return int
	 * @throws SystemException
	 */
	public static int getMOIAuditCount(
			MOIAuditDisplayTerms displayTerms, int start, int end)
			throws SystemException {
		return getAuditRequestData(displayTerms.getFromDate(),
				displayTerms.getToDate(), displayTerms.getKeywords(), start,
				end).size();
	}

	/**
	 * Fetched MOI Trace Request List.
	 * 
	 * @param isAdvancedSearch
	 * @param fromDate
	 * @param toDate
	 * @param keywords
	 * @param start
	 * @param end
	 * @return List<MOITraceRequest>
	 * @throws SystemException
	 */
	private static List<MOIAudit> getAuditRequestData(String fromDate,
			String toDate, String keywords, int start, int end)
			throws SystemException {

		List<MOIAudit> moiAuditList = null;
		if (Validator.isBlank(keywords)
				&& (Validator.isBlank(fromDate) || Validator.isBlank(toDate))) {
			System.out.println("------ Normal Search -------------");
			// No search
			moiAuditList = MOIAuditLocalServiceUtil.getMOIAudits(-1, -1);
					
		}else if (!Validator.isBlank(keywords)) {
		  System.out.println("------ Only Keywords Search -------------");
		  OrderByComparator<MOIAudit> moiAuditComparator =
		  OrderByComparatorFactoryUtil .create("MOIAudit",
		  MVCCommandNames.Audit_ID, "desc"); moiAuditList =
		  MOIAuditServiceUtil.getMOIAuditByKeywords(keywords,
		  start, end, moiAuditComparator); 
		}else{
			  System.out.println("------ Date & Keyword Search -------------");
			  OrderByComparator<MOIAudit> moiAuditComparator =
			  OrderByComparatorFactoryUtil .create("MOITraceRequest",
			  MVCCommandNames.Audit_ID, "desc"); 
			  fromDate+=" 00:00:00"; 
			  toDate+= " 23:59:59"; 
			  moiAuditList = MOIAuditServiceUtil.getMOIAuditBySearchCriteria(keywords, fromDate, toDate,
			  start, end, moiAuditComparator);
		}
			 
		 
			 
		if (null == moiAuditList) {
			moiAuditList = new ArrayList<MOIAudit>();
		}
		return moiAuditList;
	}
}