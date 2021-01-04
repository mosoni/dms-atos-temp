package com.moi.dms.trace.request.web.util;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.moi.dms.trace.request.model.MOITraceRequest;
import com.moi.dms.trace.request.service.MOITraceRequestLocalServiceUtil;
import com.moi.dms.trace.request.web.constants.MOITraceRequestConstants;
import com.moi.dms.trace.request.web.search.container.MOITraceRequestDisplayTerms;

/**
 * Helper/Util class to fetch results by search criteria.
 * 
 * @author Chintan Bhadra
 *
 */
public class MOITraceRequestHelper {

	/**
	 * Method to fetch MOI Trace requests as per the search criteria.
	 * 
	 * @param displayTerms
	 * @param start
	 * @param end
	 * @return List<MOITraceRequest>
	 * @throws SystemException
	 */
	public static List<MOITraceRequest> getMOITraceRequest(
			MOITraceRequestDisplayTerms displayTerms, int start, int end)
			throws SystemException {

		List<MOITraceRequest> traceRequestList = null;

		String fromDate = displayTerms.getFromDate();
		String toDate = displayTerms.getToDate();

		OrderByComparator<MOITraceRequest> traceRequestComparator = OrderByComparatorFactoryUtil
				.create(MOITraceRequestConstants.MOI_TRACE_REQUEST_OBJ,
						MOITraceRequestConstants.REQUEST_ID, "desc");

		if (Validator.isNotNull(fromDate)) {
			fromDate += MOITraceRequestConstants.FROM_TIME;
		}

		if (Validator.isNotNull(toDate)) {
			toDate += MOITraceRequestConstants.TO_TIME;
		}

		traceRequestList = MOITraceRequestLocalServiceUtil
				.getMOITraceRequestBySearchCriteria(displayTerms.getKeywords(),
						fromDate, toDate, start, end, traceRequestComparator);

		if (null == traceRequestList) {
			traceRequestList = new ArrayList<MOITraceRequest>();
		}

		return traceRequestList;
	}

	/**
	 * Method to fetch MOI Trace requests count as per the search criteria.
	 * 
	 * @param displayTerms
	 * @param start
	 * @param end
	 * @return int
	 * @throws SystemException
	 */
	public static int getMOITraceRequestCount(
			MOITraceRequestDisplayTerms displayTerms, int start, int end)
			throws SystemException {

		String fromDate = displayTerms.getFromDate();
		String toDate = displayTerms.getToDate();

		if (Validator.isNotNull(fromDate)) {
			fromDate += MOITraceRequestConstants.FROM_TIME;
		}

		if (Validator.isNotNull(toDate)) {
			toDate += MOITraceRequestConstants.TO_TIME;
		}

		return (int) MOITraceRequestLocalServiceUtil
				.getMOITraceRequestCountBySearchCriteria(fromDate, toDate,
						displayTerms.getKeywords());
	}
}