<%@ include file="/init.jsp"%>

<liferay-ui:error key="serviceErrorDetails">
	<liferay-ui:message
		arguments='<%=SessionErrors.get(liferayPortletRequest,
						"serviceErrorDetails")%>'
		key="error.consumer-service-error" />
</liferay-ui:error>
<liferay-ui:success key="consumerAdded"
	message="consumer-added-successfully" />
<liferay-ui:success key="consumerUpdated"
	message="consumer-updated-successfully" />
<liferay-ui:success key="consumerDeleted"
	message="consumer-deleted-successfully" />
<liferay-ui:success key="consumerActivated"
	message="consumer-activated-successfully" />
<liferay-ui:success key="consumerDeactivated"
	message="consumer-deactivated-successfully" />

<div class="container-fluid-1280">
	<%-- Clay management toolbar. --%>

	<clay:management-toolbar disabled="${consumerCount eq 0}"
		displayContext="${consumersManagementToolbarDisplayContext}"
		itemsTotal="${consumerCount}" searchContainerId="consumerEntries"
		selectable="false" />

	<%-- Search container. --%>

	<liferay-ui:search-container emptyResultsMessage="no-consumers"
		id="consumerEntries" iteratorURL="${portletURL}"
		total="${consumerCount}">

		<liferay-ui:search-container-results results="${consumers}" />

		<liferay-ui:search-container-row
			className="com.moi.dms.consumer.registration.model.ConsumerRegistration"
			modelVar="entry">
			<%@ include file="/consumer/entry_search_columns.jspf"%>
		</liferay-ui:search-container-row>

		<%-- Iterator / Paging --%>
		<liferay-ui:search-iterator
			displayStyle="${consumersManagementToolbarDisplayContext.getDisplayStyle()}"
			markupView="lexicon" />
	</liferay-ui:search-container>
</div>