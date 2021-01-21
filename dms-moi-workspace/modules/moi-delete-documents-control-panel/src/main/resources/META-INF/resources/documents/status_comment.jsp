<%@ include file="../init.jsp"%>

<liferay-ui:error key="serviceErrorDetails">
	<liferay-ui:message key="error.consumer-service-error"
		arguments='<%=SessionErrors.get(liferayPortletRequest,
						"serviceErrorDetails")%>' />
</liferay-ui:error>

<portlet:actionURL name="<%=MVCCommandNames.UPDATE_DOCUMENT_STATUS%>"
	var="updateDocumentStatusURL">
	<portlet:param name="redirect" value="${param.redirect}" />
</portlet:actionURL>

<%
	String downloadURL = (String) request
			.getAttribute(MOIDeleteDocumentsConstants.DOWNLOAD_URL);
%>
<div class="container-fluid-1280 view-document">
	<h1>
		<liferay-ui:message key="update-document-title" />
	</h1>
	<aui:model-context bean="${document}" model="${documentClass}" />

	<aui:form action="${updateDocumentStatusURL}" name="fm">
		<aui:fieldset-group markupView="lexicon">
			<aui:fieldset>
				<aui:input name="documentId" field="documentId" type="text"
					value="${document.documentId}" />
				<aui:input name="oldStatus" label="current-status"
					value="${document.status}" disabled="true" />
				<aui:input name="comments" type="textarea" label="comment"
					value="${document.comments}">
					<aui:validator name="required" />
				</aui:input>
				<aui:select name="status" label="new-status">
					<aui:option value="Approved">Approve</aui:option>
					<aui:option value="Rejected">Reject</aui:option>
				</aui:select>
			</aui:fieldset>
		</aui:fieldset-group>
		<aui:button-row>
			<aui:button cssClass="btn btn-primary" type="submit" value="submit" />
			<aui:button cssClass="btn btn-primary" type="button" value="download"
				onClick="<%=downloadURL%>" />
			<aui:button cssClass="btn btn-secondary" onClick="${param.redirect}"
				type="cancel" />
		</aui:button-row>
	</aui:form>
</div>
