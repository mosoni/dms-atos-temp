package com.moi.dms.trace.request.web.search.container;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;
import com.moi.dms.trace.request.web.constants.MOITraceRequestConstants;

import javax.portlet.PortletRequest;

/**
 * MOI Trace Request custom DisplayTerms class.
 * 
 * @author Chintan Bhadra
 *
 */
public class MOITraceRequestDisplayTerms extends DisplayTerms {

	private String fromDate;
	private String toDate;

	/**
	 * This Constructor is used for intializing the class variables
	 * 
	 * @param portletRequest : Holds fromDate, toDate, keywords parameters
	 */
	public MOITraceRequestDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		fromDate = ParamUtil.getString(portletRequest,
				MOITraceRequestConstants.FROM_DATE);
		toDate = ParamUtil.getString(portletRequest,
				MOITraceRequestConstants.TO_DATE);
	}

	/**
	 * This method is used to return FromDate variable value
	 * 
	 * @return String
	 */
	public String getFromDate() {
		return fromDate;
	}

	/**
	 * This method is used to set FromDate variable value
	 * 
	 * @param String
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * This method is used to return ToDate variable value
	 * 
	 * @return String
	 */
	public String getToDate() {
		return toDate;
	}

	/**
	 * This method is used to set ToDate variable value
	 * 
	 * @param String
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
}
