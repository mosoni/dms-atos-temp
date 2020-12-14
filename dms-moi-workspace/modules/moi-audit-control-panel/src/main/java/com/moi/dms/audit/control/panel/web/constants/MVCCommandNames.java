package com.moi.dms.audit.control.panel.web.constants;

/**
 * Constant file for render and action command names.
 * @author Ganesh Shelke
 *
 */
public class MVCCommandNames {

	public static final String ADD_CONSUMER = "/dmsconsumerregistration/consumer/add";
	public static final String DELETE_CONSUMER = "/dmsconsumerregistration/consumer/delete";
	public static final String EDIT_CONSUMER = "/dmsconsumerregistration/consumer/edit";
	public static final String VIEW_CONSUMER = "/dmsconsumerregistration/consumer/view";
	public static final String UPDATE_CONSUMER_STATUS = "/dmsconsumerregistration/consumer/updatestatus";
	public static final String VIEW_CONSUMERS = "/dmsconsumerregistration/consumers/view";
	public static final String VIEW_EXPORT = "/moiaudit/export";

	public static final String VIEW_JSP = "/view.jsp";
	public static final String EDIT_CONSUMER_JSP = "/consumer/edit_consumer.jsp";
	public static final String VIEW_CONSUMER_JSP = "/consumer/view_consumer.jsp";
	
	public static final String EXPORT_URL_APPEND = "&compress=0&etag=0&strip=0";
	public static final String EMPLOYER_EXPORT_FILE_NAME = "JCBEmployers.xls";
	
	public static final String CMD = "cmd";
	public static final String EXPORT = "EXPORT";
	public static final String EXPORT_MOI_AUDIT = "EXPORT_MOI_AUDIT";
	/** Constant for "moiaudit" set in request/response */
	public static final String NO_RECORD_FOUND = "No MOI Audit records found.";
	/** Constant for "fromDate" set in request/response */
	public static final String FROM_DATE = "fromDate";

	/** Constant for "toDate" set in request/response */
	public static final String TO_DATE = "toDate";

	/** Constant for "toDate" set in request/response */
	public static final String KEYWORDS = "keywords";
	/** Constant for "requestId" set in request/response */
	public static final String Audit_ID = "auditId";
	
	/** Constant for "requestResultDate" label */
	public static final String ACTIONED_PERFORMED_BY_LABEL = "Action Performed By";
	/** Constant for "requestResultDate" label */
	public static final String ACTION_PERFORMED_DATE_LABEL = "Action Performed Date";
	/** Constant for "requestResultDate" label */
	public static final String ACTION_DESCRIPTION_LABEL = "Action Description";
	/** Constant for "requestResultDate" label */
	public static final String ACTION_STATUS_LABEL = "Action Status";
	/** Constant for "requestResultDate" label */
	public static final String ACTION_CONSUMER_LABEL = "Action Consumer";
	/** Constant for "requestResultDate" label */
	public static final String ACTION_GROUP_ID_LABLE = "Group ID";
	/** Constant for " 00:00:00" to be attached to from Date */
	public static final String FROM_TIME = " 00:00:00";
	/** Constant for " 00:00:00" to be attached to from Date */
	public static final String TO_TIME = " 23:59:59";
	
	/** Constant for Export resource function */
	public static final String EXPORT_SHEET_NAME = "MOI_Trace_Requests_Report";

	/** Constant for Export resource function */
	public static final String EXPORT_FILE_NAME_XLS = EXPORT_SHEET_NAME
			+ ".xls";

	/** Constant for Date format */
	public static final String DATE_FORMAT = "dd-MM-yyyy HH:mm:ss";
	
	/** Constant for "start" label */
	public static final String START = "START";
	/** Constant for "end" label */
	public static final String END = "END";
}