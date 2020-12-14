<%@page import="com.moi.dms.audit.control.panel.web.constants.MVCCommandNames"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@page import="com.moi.dms.audit.control.panel.web.display.context.MOIAuditManagementToolbarDisplayContext"%>
<%@ include file="/init.jsp" %>
<p>
	<b><liferay-ui:message key="moiauditcontrolpanel.caption"/></b>
</p>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.moi.dms.audit.service.MOIAuditLocalServiceUtil"%>
<%@page import="com.moi.dms.audit.model.MOIAudit"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp" %>

<style>
.exportBtn {
    margin: 10px;
    position: relative;
    float: right;
    clear: both;
}

</style>

<portlet:resourceURL  var="exportCSVURL">
	<portlet:param name="<%= Constants.CMD %>" value="exportCSV"/>
</portlet:resourceURL>


<liferay-portlet:renderURL varImpl="searchURL">
    <portlet:param name="mvcPath" 
    value="/view_search.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm">
    <liferay-portlet:renderURLParams varImpl="searchURL" />

    <div class="search-form">
        <span class="aui-search-bar">
            <aui:input inlineField="<%= true %>" label="" 
            name="keywords" size="30" title="search-entries" type="text"
            />

            <aui:button type="submit" value="search" />
        </span>
    </div>
</aui:form>


<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/view.jsp" />
</liferay-portlet:renderURL>



<liferay-ui:search-container emptyResultsMessage="there-are-no-moiauditdetails"
	headerNames="auditId,actionPerformedBy,actionPerformedDate,actionStatus,actionDescription,actionConsumer"
	iteratorURL="<%=iteratorURL%>" delta="2" deltaConfigurable="true" >
	
	<liferay-ui:search-container-results>
		<%
		
			List<MOIAudit> moiAuditDetailsList = MOIAuditLocalServiceUtil.getMOIAudits(-1,-1);
					results = ListUtil.subList(moiAuditDetailsList, searchContainer.getStart(), searchContainer.getEnd());
					searchContainer.setTotal(moiAuditDetailsList.size());
					searchContainer.setResults(results);
		%>
	
			<portlet:resourceURL var="exportURL" id="<%=MVCCommandNames.EXPORT_MOI_AUDIT %>" >
				<portlet:param name="<%=MVCCommandNames.CMD %>" value="<%=MVCCommandNames.EXPORT%>"/>
			</portlet:resourceURL>
			
			<liferay-util:buffer var="onClickFn"
			>
					submitForm(document.hrefFm, '<%= exportURL + MVCCommandNames.EXPORT_URL_APPEND %>');
			</liferay-util:buffer>
			<div class="row" style="">
	    	   <div class="col-md-12">
				<a class="btn btn-info exportBtn" style="color: white;" onclick="<%=onClickFn%>"><%=LanguageUtil.get(request, "export") %></a>
				</div>
			</div>
	</liferay-ui:search-container-results>
	
	<liferay-ui:search-container-row className="MOIAudit"
		keyProperty="auditId" modelVar="currentObjectAutoDetails"  >
		<liferay-ui:search-container-column-text name="Action Performed By"
			property="actionPerformedBy" />
		<liferay-ui:search-container-column-text name="Action Performed Date"
			property="actionPerformedDate" />
		<liferay-ui:search-container-column-text name="Action Status"
			property="actionStatus" />
			<liferay-ui:search-container-column-text name="Action Description"
			property="actionDescription" />
		<liferay-ui:search-container-column-text name="Action Consumer"
			property="actionConsumer" />		
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />









