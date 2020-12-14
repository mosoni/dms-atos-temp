<%@ include file="../init.jsp"%>

<c:set var="consumer" value="${SEARCH_CONTAINER_RESULT_ROW.object}" />

<liferay-ui:icon-menu markupView="lexicon">

	<%-- View action. --%>

	<%-- <portlet:renderURL var="viewConsumerURL">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.VIEW_CONSUMER%>" />
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="registrationId"
			value="${consumer.registrationId}" />
	</portlet:renderURL>

	<liferay-ui:icon message="view" url="${viewConsumerURL}" /> --%>

	<%-- Edit action. --%>
	<portlet:renderURL var="editConsumerURL">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.EDIT_CONSUMER %>" />
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="registrationId"
			value="${consumer.registrationId}" />
	</portlet:renderURL>

	<liferay-ui:icon message="edit" iconCssClass="icon-edit"
		url="${editConsumerURL}" />

	<%-- Delete action. --%>
	<portlet:actionURL name="<%=MVCCommandNames.DELETE_CONSUMER%>"
		var="deleteConsumerURL">
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="registrationId"
			value="${consumer.registrationId}" />
	</portlet:actionURL>

	<%-- Activate action. --%>
	<portlet:actionURL name="<%=MVCCommandNames.UPDATE_CONSUMER_STATUS%>"
		var="activateConsumerURL">
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="registrationId"
			value="${consumer.registrationId}" />
			<portlet:param name="consumerStatus" value="Active" />
	</portlet:actionURL>

	<%-- Deactivate action. --%>
	<portlet:actionURL name="<%=MVCCommandNames.UPDATE_CONSUMER_STATUS%>"
		var="deactivateConsumerURL">
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="registrationId"
			value="${consumer.registrationId}" />
		<portlet:param name="consumerStatus" value="Inactive" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="${deleteConsumerURL}" showIcon="true"
		confirmation="are-you-sure-to-delete" />

	<c:choose>
		<c:when test='${consumer.consumerStatus.equals("Active")}'>
			<liferay-ui:icon iconCssClass="icon-remove" message="Deactivate"
				url="${deactivateConsumerURL}" />
		</c:when>
		<c:otherwise>
			<liferay-ui:icon iconCssClass="icon-ok" message="Activate"
				url="${activateConsumerURL}" />
		</c:otherwise>
	</c:choose>

</liferay-ui:icon-menu>