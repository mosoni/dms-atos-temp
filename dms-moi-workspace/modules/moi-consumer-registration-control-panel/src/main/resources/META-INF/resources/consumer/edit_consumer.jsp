<%@ include file="../init.jsp"%>

<liferay-ui:error key="serviceErrorDetails">
	<liferay-ui:message key="error.consumer-service-error"
		arguments='<%=SessionErrors.get(liferayPortletRequest,
						"serviceErrorDetails")%>' />
</liferay-ui:error>

<liferay-ui:error key="consumerDescriptionEmpty"
	message="error.consumer-description-empty" />

<liferay-ui:error key="consumerNameInvalid"
	message="error.consumer-name-invalid" />

<liferay-ui:error key="consumerIdInvalid"
	message="error.consumer-id-invalid" />

<liferay-ui:error key="documentTypeExists"
	message="error.consumer-document-type-exists" />

<%-- Generate add / edit action URL and set title. --%>

<c:choose>
	<c:when test="${not empty consumer}">
		<portlet:actionURL var="consumerActionURL"
			name="<%=MVCCommandNames.EDIT_CONSUMER%>">
			<portlet:param name="redirect" value="${param.redirect}" />
		</portlet:actionURL>

		<c:set var="editTitle" value="edit-consumer" />
	</c:when>
	<c:otherwise>
		<portlet:actionURL var="consumerActionURL"
			name="<%=MVCCommandNames.ADD_CONSUMER%>">
			<portlet:param name="redirect" value="${param.redirect}" />
		</portlet:actionURL>

		<c:set var="editTitle" value="add-consumer" />
	</c:otherwise>
</c:choose>

<div class="container-fluid-1280 edit-consumer">

	<h1>
		<liferay-ui:message key="${editTitle}" />
	</h1>

	<aui:model-context bean="${consumer}" model="${consumerClass}" />

	<aui:form action="${consumerActionURL}" name="fm">
		<aui:input name="registrationId" field="registrationId" type="hidden" />
		<aui:fieldset-group markupView="lexicon">
			<aui:fieldset>
				<%-- Consumer ID field. --%>
				<aui:input name="consumerId">
					<aui:validator name="required" />
				</aui:input>

				<%-- Consumer Name field. --%>
				<aui:input name="consumerName">
					<aui:validator name="required" />
				</aui:input>

				<%-- Consumer Description field. --%>
				<aui:input name="consumerDescription">
				</aui:input>

				<%-- Supported Document field. --%>
				<aui:input name="supportedDocumentType">
				</aui:input>

				<%-- Consumer Status field. --%>
				<aui:select name="consumerStatus" required="true" showEmptyOption="false">
					<aui:option value="Active">Active</aui:option>
					<aui:option value="Inactive">Inactive</aui:option>
				</aui:select>
			</aui:fieldset>
		</aui:fieldset-group>

		<%--Buttons. --%>
		<aui:button-row>
			<aui:button cssClass="btn btn-primary" type="submit" />
			<aui:button cssClass="btn btn-secondary" onClick="${param.redirect}"
				type="cancel" />
		</aui:button-row>
	</aui:form>
</div>