package com.moi.dms.audit.control.panel.search.container;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.moi.dms.audit.control.panel.web.constants.MVCCommandNames;
import com.moi.dms.audit.model.MOIAudit;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

/**
 * The purpose of this class is to handle custom MOI Audit container.
 * 
 * Accessibility : This class gets executed from user control panel module.
 * When end user performs search, flow comes to this class on respective method.
 * 
 * 
 * @author Ganesh Shelke
 */
public class MOIAuditSearchContainer
		extends SearchContainer<MOIAudit> {

	public static final String EMPTY_RESULTS_MESSAGE = MVCCommandNames.NO_RECORD_FOUND;
	public static final int DEFAULT_DELTA = 20;

	static List<String> headerNames = new ArrayList<String>();

	/**
	 * This static block is used for initializing the class variables
	 */
	static {
		headerNames.add(MVCCommandNames.FROM_DATE);
		headerNames.add(MVCCommandNames.TO_DATE);
		headerNames.add(MVCCommandNames.KEYWORDS);
	}

	/**
	 * This Constructor is used for intializing the class variables
	 * 
	 * @param portletRequest : Holds fromDate, toDate parameters
	 * @param iteratorURL
	 */
	public MOIAuditSearchContainer(PortletRequest portletRequest,
			PortletURL iteratorURL) {

		super(portletRequest, new MOIAuditDisplayTerms(portletRequest),
				new MOIAuditDisplayTerms(portletRequest),
				DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headerNames,
				EMPTY_RESULTS_MESSAGE);

		MOIAuditDisplayTerms displayTerms = (MOIAuditDisplayTerms) getDisplayTerms();
		System.out.println("displayTerms.getFromDate()==========="+displayTerms.getFromDate());
		System.out.println("displayTerms.getToDate()==========="+displayTerms.getToDate());
		iteratorURL.getRenderParameters().setValue(
				MVCCommandNames.FROM_DATE, displayTerms.getFromDate());
		iteratorURL.getRenderParameters().setValue(
				MVCCommandNames.TO_DATE, displayTerms.getToDate());
	}
}
