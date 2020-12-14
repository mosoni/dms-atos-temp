package com.moi.dms.trace.request.web.search.container;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.moi.dms.trace.request.model.MOITraceRequest;
import com.moi.dms.trace.request.web.constants.MOITraceRequestConstants;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

/**
 * The purpose of this class is to handle custom Trace Request container.
 * 
 * Accessibility : This class gets executed from Employer control panel module.
 * When end user performs search, flow comes to this class on respective method.
 * 
 * 
 * @author Chintan Bhadra
 */
public class MOITraceRequestSearchContainer
		extends SearchContainer<MOITraceRequest> {

	public static final String EMPTY_RESULTS_MESSAGE = MOITraceRequestConstants.NO_RECORD_FOUND;
	public static final int DEFAULT_DELTA = 20;

	static List<String> headerNames = new ArrayList<String>();

	/**
	 * This static block is used for initializing the class variables
	 */
	static {
		headerNames.add(MOITraceRequestConstants.FROM_DATE);
		headerNames.add(MOITraceRequestConstants.TO_DATE);
		headerNames.add(MOITraceRequestConstants.KEYWORDS);
	}

	/**
	 * This Constructor is used for intializing the class variables
	 * 
	 * @param portletRequest : Holds fromDate, toDate parameters
	 * @param iteratorURL
	 */
	public MOITraceRequestSearchContainer(PortletRequest portletRequest,
			PortletURL iteratorURL) {

		super(portletRequest, new MOITraceRequestDisplayTerms(portletRequest),
				new MOITraceRequestDisplayTerms(portletRequest),
				DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headerNames,
				EMPTY_RESULTS_MESSAGE);

		MOITraceRequestDisplayTerms displayTerms = (MOITraceRequestDisplayTerms) getDisplayTerms();

		iteratorURL.getRenderParameters().setValue(
				MOITraceRequestConstants.FROM_DATE, displayTerms.getFromDate());
		iteratorURL.getRenderParameters().setValue(
				MOITraceRequestConstants.TO_DATE, displayTerms.getToDate());
	}
}
