<%@ include file="/init.jsp"%>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>

<liferay-ui:error key="serviceErrorDetails">
	<liferay-ui:message
		arguments='<%=SessionErrors.get(liferayPortletRequest,
						"serviceErrorDetails")%>'
		key="error.document-service-error" />
</liferay-ui:error>
<liferay-ui:success key="documentUpdated"
	message="status-updated-successfully" />

<div class="container-fluid-1280">
	<%-- Clay management toolbar. --%>

	<clay:management-toolbar disabled="${documentCount eq 0}"
		displayContext="${deleteDocumentManagementToolbarDisplayContext}"
		itemsTotal="${documentCount}" searchContainerId="delDocumentEntries"
		selectable="false" />

	<%-- Search container. --%>

	<liferay-ui:search-container emptyResultsMessage="no-delete-documents"
		id="delDocumentEntries" iteratorURL="${portletURL}"
		total="${documentCount}">

		<liferay-ui:search-container-results results="${documents}" />

		<liferay-ui:search-container-row
			className="com.moi.dms.delete.documents.model.MOIDeleteDocuments"
			modelVar="entry">

			<liferay-ui:search-container-column-text name="file-entry-name"
				value="${entry.fileEntryName}" />
			<liferay-ui:search-container-column-text name="uploaded-by"
				value="${entry.uploadedBy}" />
			<liferay-ui:search-container-column-text name="uploaded-date"
				value="${entry.uploadedDate}" />
			<liferay-ui:search-container-column-text name="updated-by"
				value="${entry.updatedBy}" />
			<liferay-ui:search-container-column-text name="updated-date"
				value="${entry.updatedDate}" />
			<liferay-ui:search-container-column-text name="document-status"
				value="${entry.status}" />
			<liferay-ui:search-container-column-jsp name="document-action"
				path="/documents/entry_actions.jsp" />

		</liferay-ui:search-container-row>

		<%-- Iterator / Paging --%>
		<liferay-ui:search-iterator
			displayStyle="${deleteDocumentManagementToolbarDisplayContext.getDisplayStyle()}"
			markupView="lexicon" />
	</liferay-ui:search-container>
</div>