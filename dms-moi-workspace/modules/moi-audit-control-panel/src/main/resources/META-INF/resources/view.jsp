<%@page import="com.moi.dms.audit.control.panel.util.MOIAuditHelper"%>
<%@page import="com.moi.dms.audit.control.panel.search.container.MOIAuditDisplayTerms"%>
<%@page import="com.moi.dms.audit.control.panel.search.container.MOIAuditSearchContainer"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.moi.dms.audit.control.panel.web.constants.MVCCommandNames"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@page import="com.moi.dms.audit.control.panel.web.display.context.MOIAuditManagementToolbarDisplayContext"%>
<%@ include file="/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.moi.dms.audit.service.MOIAuditLocalServiceUtil"%>
<%@page import="com.moi.dms.audit.model.MOIAudit"%>
<%@page import="java.util.List"%>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
	String portletURLString = portletURL.toString();
	MOIAuditSearchContainer moiAuditSearchContainer = new MOIAuditSearchContainer(
			renderRequest, portletURL);
	MOIAuditDisplayTerms displayTerms = (MOIAuditDisplayTerms) moiAuditSearchContainer
			.getDisplayTerms();
	System.out.println("START =============>- "+moiAuditSearchContainer.getStart());
	System.out.println("END ============> "+moiAuditSearchContainer.getEnd());
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
			searchContainer="<%=moiAuditSearchContainer%>"
			emptyResultsMessage="no-audit-requests" id="auditEntries"
			total="<%=MOIAuditHelper.getMOIAuditCount(
							displayTerms,
							moiAuditSearchContainer.getStart(),
							moiAuditSearchContainer.getEnd())%>">
			<liferay-ui:search-form page="/search.jsp"
				servletContext="<%=application%>" />

			<liferay-ui:search-container-results
				results="<%=MOIAuditHelper.getMOIAuditRequest(
							displayTerms,
							moiAuditSearchContainer.getStart(),
							moiAuditSearchContainer.getEnd())%>" />
							
			<portlet:resourceURL var="exportURL" id="<%=MVCCommandNames.EXPORT_MOI_AUDIT%>">
					<portlet:param name="<%=MVCCommandNames.FROM_DATE%>"
						value="<%=displayTerms.getFromDate()%>" />
					<portlet:param name="<%=MVCCommandNames.TO_DATE%>"
						value="<%=displayTerms.getToDate()%>" />
					<portlet:param name="<%=MVCCommandNames.KEYWORDS%>"
						value="<%=displayTerms.getKeywords()%>" />
						<%-- <portlet:param name="<%=MVCCommandNames.START%>"
						value="<%=moiAuditSearchContainer.getStart()%>" />
						<portlet:param name="<%=MVCCommandNames.END%>"
						value="<%=moiAuditSearchContainer.getEnd()%>" /> --%>
				</portlet:resourceURL>

				<liferay-util:buffer var="onClickFn">
					submitForm(document.hrefFm, '<%=exportURL
									+ MVCCommandNames.EXPORT_URL_APPEND%>');
				</liferay-util:buffer>
				<div class="row" style="">
					<div class="col-md-12">
						<a class="btn btn-info exportBtn" style="color: white;"
							onclick="${onClickFn}"><%=LanguageUtil.get(request,
								"export")%></a>
					</div>
				</div>
			<liferay-ui:search-container-row
				className="com.moi.dms.audit.model.MOIAudit"
				modelVar="entry">
				<liferay-ui:search-container-column-text
					name="Action Performed By" value="${entry.actionPerformedBy}" />
				<liferay-ui:search-container-column-text
					name="Action Performed Date"
					value="${entry.actionPerformedDate}" />
				<liferay-ui:search-container-column-text
					name="Action Status"
					value="${entry.actionStatus}" />
				<liferay-ui:search-container-column-text
					name="Action Description"
					value="${entry.actionDescription}" />
				<liferay-ui:search-container-column-text
					name="Action Consumer"
					value="${entry.actionConsumer}" />
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator displayStyle="list" markupView="lexicon" />

		</liferay-ui:search-container>
	</aui:form>
</div>