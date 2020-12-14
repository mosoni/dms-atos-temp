<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.moi.dms.audit.service.MOIAuditLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.search.Field"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.search.Document"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.search.Hits"%>
<%@page import="com.moi.dms.audit.model.MOIAudit"%>
<%@page import="com.liferay.portal.kernel.search.Indexer"%>
<%@page import="com.liferay.portal.kernel.search.IndexerRegistryUtil"%>
<%@page import="com.liferay.portal.kernel.search.SearchContextFactory"%>
<%@page import="com.liferay.portal.kernel.search.SearchContext"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp" %>
<%
  long keywords = Long.parseLong(ParamUtil.getString(request, "keywords"));
System.out.println("keywords=======================>"+keywords);
  //long guestbookId = ParamUtil.getLong(renderRequest, "auditId");
%>

<liferay-portlet:renderURL varImpl="searchURL">
        <portlet:param name="mvcPath" 
        value="/view_search.jsp" />
</liferay-portlet:renderURL>

<portlet:renderURL var="viewURL">
    <portlet:param 
        name="mvcPath" 
        value="/view.jsp" 
    />
</portlet:renderURL>
<aui:form action="<%= searchURL %>" method="get" name="fm">
    <liferay-portlet:renderURLParams varImpl="searchURL" />

<liferay-ui:header
    backURL="<%= viewURL.toString() %>"
    title="search"
/>

    <div class="search-form">
        <span class="aui-search-bar">
            <aui:input inlineField="<%= true %>" label="" name="keywords" 
            size="30" title="search-entries" type="text" />

            <aui:button type="submit" value="search" />
        </span>
    </div>
</aui:form>

<%-- <%
    SearchContext searchContext = SearchContextFactory
    .getInstance(request);

    searchContext.setKeywords(keywords);
    searchContext.setAttribute("paginationType", "more");
    searchContext.setStart(0);
    searchContext.setEnd(10);
    Indexer indexer = IndexerRegistryUtil.getIndexer(MOIAudit.class);
    System.out.println("indexer=======================>"+indexer);
    Hits hits = indexer.search(searchContext);

List<MOIAudit> entries = new ArrayList<MOIAudit>();

    for (int i = 0; i < hits.getDocs().length; i++) {
            Document doc = hits.doc(i);

            long entryId  = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
            System.out.println("entryId=======================>"+entryId);
            MOIAudit entry = null;

            try {
            	/* entry = EntryLocalServiceUtil.getEntry(entryId); */
            	 entry = MOIAuditLocalServiceUtil.getMOIAudit(entryId); 
            	System.out.println("entry=======================>"+entry);
            } catch (PortalException pe) {
                    _log.error(pe.getLocalizedMessage());
            } catch (SystemException se) {
                    _log.error(se.getLocalizedMessage());
            }

            entries.add(entry);
    }
    
    List<MOIAudit> mOIAudits = MOIAuditLocalServiceUtil.getMOIAudits(-1, -1);

        Map<String, String> mOIAuditsMap = new HashMap<String, String>();

        for (MOIAudit mOIAudit : mOIAudits) {
        	mOIAuditsMap.put(Long.toString(mOIAudit.getAuditId()), mOIAudit.getActionDescription());
        }
%> --%>

<%-- <liferay-ui:search-container delta="10" 
    emptyResultsMessage="no-entries-were-found" 
    total="<%= entries.size() %>">
        <liferay-ui:search-container-results
                results="<%= entries %>">
                
<liferay-ui:search-container-row
        className="com.moi.dms.audit.model.MOIAudit"
        keyProperty="auditId" modelVar="entry" escapedModel="<%=true%>">
<liferay-ui:search-container-column-text name="moiaudit"
        value="<%=mOIAuditsMap.get(Long.toString(entry.getAuditId()))%>" />

    <liferay-ui:search-container-column-text property="actionPerformedBy" />

    <!-- <liferay-ui:search-container-column-text property="actionPerformedDate" />
    <liferay-ui:search-container-column-text property="actionStatus" />

    <liferay-ui:search-container-column-text property="actionDescription" />
    <liferay-ui:search-container-column-text property="actionConsumer" /> -->
    

    <!-- <liferay-ui:search-container-column-jsp
        path="/guestbookwebportlet/entry_actions.jsp"
        align="right" /> -->
</liferay-ui:search-container-row>
<liferay-ui:search-iterator />
</liferay-ui:search-container> --%>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/view.jsp" />
</liferay-portlet:renderURL>
<liferay-ui:search-container emptyResultsMessage="there-are-no-moiauditdetails"
	headerNames="auditId,actionPerformedBy,actionPerformedDate,actionStatus,actionDescription,actionConsumer"
	iteratorURL="<%=iteratorURL%>" delta="2" deltaConfigurable="true" >
	
	<liferay-ui:search-container-results>
		<%
		
			MOIAudit moiAuditdetails = MOIAuditLocalServiceUtil.getMOIAudit(keywords);
		List<MOIAudit> moiAuditDetailsList = new ArrayList<MOIAudit>();
		moiAuditDetailsList.add(moiAuditdetails);
					results = ListUtil.subList(moiAuditDetailsList, searchContainer.getStart(), searchContainer.getEnd());
					searchContainer.setTotal(1);
					searchContainer.setResults(results);
		%>
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
</liferay-ui:search-container>

<%!
        private static Log _log = LogFactoryUtil.getLog("html.moiauditwebportlet.view_search_jsp");
%>