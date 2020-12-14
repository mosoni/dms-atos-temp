<%@ include file="/init.jsp"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ page
	import="com.moi.dms.trace.request.web.search.container.MOITraceRequestDisplayTerms"%>
<%@ page
	import="com.moi.dms.trace.request.web.search.container.MOITraceRequestSearchContainer"%>
<%@ page
	import="com.moi.dms.trace.request.web.util.MOITraceRequestHelper"%>
<%@page
	import="com.moi.dms.trace.request.web.constants.MOITraceRequestCommandNames"%>
<%@page
	import="com.moi.dms.trace.request.web.constants.MOITraceRequestConstants"%>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	String portletURLString = portletURL.toString();
	MOITraceRequestSearchContainer traceRequestSearchContainer = new MOITraceRequestSearchContainer(
			renderRequest, portletURL);
	MOITraceRequestDisplayTerms displayTerms = (MOITraceRequestDisplayTerms) traceRequestSearchContainer
			.getDisplayTerms();
	SimpleDateFormat sdf = new SimpleDateFormat(MOITraceRequestConstants.DATE_FORMAT);
%>
<style>
.exportBtn {
	margin: 10px;
	position: relative;
	float: right;
	clear: both;
}
</style>
<div class="container-fluid-1280">
	<aui:form action="<%=portletURLString%>" method="post" name="fm">
		<liferay-ui:search-container
			searchContainer="<%=traceRequestSearchContainer%>"
			emptyResultsMessage="no-trace-requests" id="traceRequestsEntries"
			total="<%=MOITraceRequestHelper.getMOITraceRequestCount(
							displayTerms,
							traceRequestSearchContainer.getStart(),
							traceRequestSearchContainer.getEnd())%>">
			<liferay-ui:search-form page="/search.jsp"
				servletContext="<%=application%>" />
			<liferay-ui:search-container-results
				results="<%=MOITraceRequestHelper.getMOITraceRequest(
								displayTerms,
								traceRequestSearchContainer.getStart(),
								traceRequestSearchContainer.getEnd())%>">


				<portlet:resourceURL var="exportURL" id="<%=MOITraceRequestCommandNames.EXPORT_TRACE_REQUESTS %>">
					<portlet:param name="<%=MOITraceRequestConstants.FROM_DATE%>"
						value="<%=displayTerms.getFromDate()%>" />
					<portlet:param name="<%=MOITraceRequestConstants.TO_DATE%>"
						value="<%=displayTerms.getToDate()%>" />
					<portlet:param name="<%=MOITraceRequestConstants.KEYWORDS%>"
						value="<%=displayTerms.getKeywords()%>" />
				</portlet:resourceURL>

				<liferay-util:buffer var="onClickFn">
					submitForm(document.hrefFm, '<%=exportURL
									+ MOITraceRequestConstants.EXPORT_URL_APPEND%>');
				</liferay-util:buffer>
				<div class="row" style="">
					<div class="col-md-12">
						<a class="btn btn-info exportBtn" style="color: white;"
							onclick="${onClickFn}"><%=LanguageUtil.get(request,
								"traceRequest-export")%></a>
					</div>
				</div>

			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row
				className="com.moi.dms.trace.request.model.MOITraceRequest"
				modelVar="entry">
				<liferay-ui:search-container-column-text
					name="traceRequest-requestedBy" value="${entry.requestedBy}" />
				<liferay-ui:search-container-column-text
					name="traceRequest-requestIncomingDate"
					value="<%=sdf.format(entry.getRequestIncomingDate())%>" />
				<liferay-ui:search-container-column-text
					name="traceRequest-requestedConsumerName"
					value="${entry.requestedConsumerName}" />
				<liferay-ui:search-container-column-text
					name="traceRequest-requestedOperation"
					value="${entry.requestedOperation}" />
				<liferay-ui:search-container-column-text
					name="traceRequest-requestedDocumentType"
					value="${entry.requestedDocumentType}" />
				<liferay-ui:search-container-column-text
					name="traceRequest-requestValid" value="${entry.requestValid}" />
				<liferay-ui:search-container-column-text
					name="traceRequest-requestResult" value="${entry.requestResult}" />
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator displayStyle="list" markupView="lexicon" />

		</liferay-ui:search-container>
	</aui:form>
</div>