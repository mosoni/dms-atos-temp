<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.moi.dms.audit.service.MOIAuditLocalServiceUtil"%>
<%@page import="com.moi.dms.audit.model.MOIAudit"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="demomoiaudit.caption"/></b>
</p>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/view.jsp" />
</liferay-portlet:renderURL>

<liferay-ui:search-container emptyResultsMessage="there-are-no-moiauditdetails"
	headerNames="auditId,actionPerformedBy,actionPerformedDate,actionStatus,actionDescription,actionConsumer"
	iteratorURL="<%=iteratorURL%>" delta="10" deltaConfigurable="true" >
	
	<liferay-ui:search-container-results>
		<%
		
			List<MOIAudit> moiAuditDetailsList = MOIAuditLocalServiceUtil.getMOIAudits(-1,-1);
					results = ListUtil.subList(moiAuditDetailsList, searchContainer.getStart(), searchContainer.getEnd());
					searchContainer.setTotal(moiAuditDetailsList.size());
					searchContainer.setResults(results);
		%>
	</liferay-ui:search-container-results>
	
	<liferay-ui:search-container-row className="MOIAudit"
		keyProperty="auditId" modelVar="currentObjectAutoDetails"  >
		<liferay-ui:search-container-column-text name="ActionPerformedBy"
			property="actionPerformedBy" />
		<liferay-ui:search-container-column-text name="ActionPerformedDate"
			property="actionPerformedDate" />
		<liferay-ui:search-container-column-text name="ActionStatus"
			property="actionStatus" />
			<liferay-ui:search-container-column-text name="ActionDescription"
			property="actionDescription" />
		<liferay-ui:search-container-column-text name="ActionConsumer"
			property="actionConsumer" />		
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
</liferay-ui:search-container>