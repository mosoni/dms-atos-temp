<%@page import="com.moi.dms.audit.control.panel.search.container.MOIAuditDisplayTerms"%>
<%@page import="com.moi.dms.audit.control.panel.search.container.MOIAuditSearchContainer"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>

<%@include file="init.jsp"%>

<%
	MOIAuditSearchContainer searchContainer = (MOIAuditSearchContainer) request
			.getAttribute("liferay-ui:search:searchContainer");
	MOIAuditDisplayTerms displayTerms = (MOIAuditDisplayTerms) searchContainer
			.getDisplayTerms();
%>

<style>
.searchTraceRequest {
	margin-bottom: 2em;
	margin-top: 1em;
}
</style>
<portlet:renderURL var="mainURL" />
<div class="searchTraceRequest">
	<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
		<div class="col-md-12 mt-4">
			<aui:nav-bar-search>
				<div class="search-fields">
					<aui:form action="" cssClass="floating-left" method="post"
						name="fm" onClick="search()">
						<div class="date-container pl-3 row">
							<div class="col">
								<aui:input type="Date" name="fromDate" label="Audit From Date"
									cssClass="statusAllign"
									value="<%=displayTerms.getFromDate()%>" />
							</div>
							<div class="col">
								<aui:input type="Date" name="toDate" label="Audit To Date"
									cssClass="toDate statusAllign"
									value="<%=displayTerms.getToDate()%>" />
							</div>
							<div class="col" style="margin-top: 15px">
								<liferay-ui:input-search markupView="lexicon" />
							</div>
							<div class="col" style="margin-top: 15px">
								<a href="<%=mainURL.toString()%>"
								class="btn btn-default mb-2 ml-3 mt-2 resetButton">Reset</a>
							</div>
						</div>
					</aui:form>
				</div>
			</aui:nav-bar-search>
		</div>
	</aui:nav-bar>
</div>