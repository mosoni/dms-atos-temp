<%@ include file="../init.jsp"%>

<liferay-ui:error key="serviceErrorDetails">
	<liferay-ui:message key="error.consumer-service-error"
		arguments='<%=SessionErrors.get(liferayPortletRequest,
						"serviceErrorDetails")%>' />
</liferay-ui:error>

<div class="container-fluid-1280 view-document">

	<h1>
		<liferay-ui:message key="view-document-title" />
	</h1>

	<aui:model-context bean="${document}" model="${documentClass}" />

	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset>

			<aui:input name="fileEntryName" disabled="true"
				value="${document.fileEntryName}"></aui:input>
			<aui:input name="consumerCode" disabled="true"
				value="${document.consumerCode}"></aui:input>
			<aui:input name="moduleType" disabled="true"
				value="${document.moduleType}"></aui:input>
			<aui:input name="uploadedBy" disabled="true"
				value="${document.uploadedBy}"></aui:input>
			<aui:input name="uploadedDate" disabled="true"
				value="${document.uploadedDate}"></aui:input>
			<aui:input name="status" disabled="true" value="${document.status}"></aui:input>
			<aui:input name="comments" disabled="true" type="textarea"
				value="${document.comments}"></aui:input>
			<aui:input name="updatedBy" disabled="true"
				value="${document.updatedBy}"></aui:input>
			<aui:input name="updatedDate" disabled="true"
				value="${document.updatedDate}"></aui:input>
			<aui:input name="pendingIdentifiers" disabled="true" type="textarea"
				value="${document.pendingIdentifiers}"></aui:input>
		</aui:fieldset>
	</aui:fieldset-group>

	<%--Buttons. --%>
	<aui:button-row>
		<aui:button cssClass="btn btn-secondary" onClick="${param.redirect}"
			type="cancel" />
	</aui:button-row>
</div>