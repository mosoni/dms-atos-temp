<%@ include file="../init.jsp"%>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui"%>

<c:set var="document" value="${SEARCH_CONTAINER_RESULT_ROW.object}" />
<%
	String queryString = "";
	String url = "";
	ResultRow row = (ResultRow) request
			.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	if (row != null) {
		Object result = row.getObject();
		if (result instanceof MOIDeleteDocuments) {
			MOIDeleteDocuments delDocument = (MOIDeleteDocuments) result;
			url = MOIDeleteDocumentsUtil.getDownloadURL(
					delDocument.getFileEntryId(), themeDisplay,
					queryString);
		}
	}
%>
<liferay-ui:icon-menu markupView="lexicon">

	<portlet:renderURL var="viewDeleteDocumentURL">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.VIEW_DOCUMENT%>" />
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="documentId" value="${document.documentId}" />
		<portlet:param name="operation" value="view" />
	</portlet:renderURL>
		<portlet:renderURL var="updateDeleteDocumentStatusURL">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.VIEW_DOCUMENT%>" />
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="documentId" value="${document.documentId}" />
		<portlet:param name="operation" value="update" />
	</portlet:renderURL>

	<liferay-ui:icon iconCssClass="icon-download-alt" message="download"
		url="<%=url%>" />
	<liferay-ui:icon iconCssClass="icon-eye-open" message="view"
		url="${viewDeleteDocumentURL}" />
	<c:choose>
		<c:when
			test='${!document.status.equals("Completed") && !document.status.equals("In Progress")}'>
			<liferay-ui:icon iconCssClass="icon-edit-sign"
				message="update-status" url="${updateDeleteDocumentStatusURL}" />
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>

</liferay-ui:icon-menu>