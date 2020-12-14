package com.moi.dms.trace.request.web.constants;

/**
 * MOITraceRequest Constant class
 * 
 * @author Chintan Bhadra
 *
 */
public class MOITraceRequestConstants {

	/** Constant for "MOITraceRequest" Object */
	public static final String MOI_TRACE_REQUEST_OBJ = "MOITraceRequest";

	/** Constant for "requestId" set in request/response */
	public static final String REQUEST_ID = "requestId";

	/** Constant for "requestedBy" set in request/response */
	public static final String REQUESTED_BY = "requestedBy";

	/** Constant for "requestIncomingDate" set in request/response */
	public static final String REQUEST_INCOMING_DATE = "requestIncomingDate";

	/** Constant for "requestedConsumerCode" set in request/response */
	public static final String REQUESTED_CONSUMER_CODE = "requestedConsumerCode";

	/** Constant for "requestedConsumerName" set in request/response */
	public static final String REQUESTED_CONSUMER_NAME = "requestedConsumerName";

	/** Constant for "requestedOperation" set in request/response */
	public static final String REQUESTED_OPERATION = "requestedOperation";

	/** Constant for "requestedDocumentType" set in request/response */
	public static final String REQUESTED_DOCUMENT_TYPE = "requestedDocumentType";

	/** Constant for "requestValid" set in request/response */
	public static final String REQUEST_VALID = "requestValid";

	/** Constant for "requestResult" set in request/response */
	public static final String REQUEST_RESULT = "requestResult";

	/** Constant for "requestResultDate" set in request/response */
	public static final String REQUEST_RESULT_DATE = "requestResultDate";

	/** Constant for "requestedBy" label */
	public static final String REQUESTED_BY_LABEL = "Requested By";

	/** Constant for "requestIncomingDate" label */
	public static final String REQUEST_INCOMING_DATE_LABEL = "Incoming Date";

	/** Constant for "requestedConsumerCode" label */
	public static final String REQUESTED_CONSUMER_CODE_LABEL = "Consumer Code";

	/** Constant for "requestedConsumerName" label */
	public static final String REQUESTED_CONSUMER_NAME_LABEL = "Consumer Name";

	/** Constant for "requestedOperation" label */
	public static final String REQUESTED_OPERATION_LABEL = "Activity";

	/** Constant for "requestedDocumentType" label */
	public static final String REQUESTED_DOCUMENT_TYPE_LABEL = "Document Type";

	/** Constant for "requestValid" label */
	public static final String REQUEST_VALID_LABEL = "Request Valid";

	/** Constant for "requestResult" label */
	public static final String REQUEST_RESULT_LABEL = "Result";

	/** Constant for "requestResultDate" label */
	public static final String REQUEST_RESULT_DATE_LABEL = "Result Date";

	/** Constant for "mvcRenderCommandName" */
	public static final String MVC_RENDER_COMMAND_NAME = "mvcRenderCommandName";

	/** Constant for "serviceErrorDetails" */
	public static final String SERVICE_ERROR_DETAILS = "serviceErrorDetails";

	/** Constant for "traceRequests" set in request/response */
	public static final String NO_RECORD_FOUND = "No MOI Trace Request records found.";

	/** Constant for "fromDate" set in request/response */
	public static final String FROM_DATE = "fromDate";

	/** Constant for "toDate" set in request/response */
	public static final String TO_DATE = "toDate";

	/** Constant for "keywords" set in request/response */
	public static final String KEYWORDS = "keywords";

	/** Constant for " 00:00:00" to be attached to from Date */
	public static final String FROM_TIME = " 00:00:00";

	/** Constant for " 00:00:00" to be attached to from Date */
	public static final String TO_TIME = " 23:59:59";

	/** Constant for Export resource function */
	public static final String EXPORT_URL_APPEND = "&compress=0&etag=0&strip=0";

	/** Constant for Export resource function */
	public static final String EXPORT_SHEET_NAME = "MOI_Trace_Requests_Report";

	/** Constant for Export resource function */
	public static final String EXPORT_FILE_NAME_XLS = EXPORT_SHEET_NAME
			+ ".xls";

	/** Constant for Date format */
	public static final String DATE_FORMAT = "dd-MM-yyyy HH:mm:ss";
}
