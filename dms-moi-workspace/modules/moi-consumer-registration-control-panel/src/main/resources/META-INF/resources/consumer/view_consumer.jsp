<%@ include file="../init.jsp"%>

<div class="container-fluid-1280">

	<h2>Consumer Registration Information</h2>

	<div class="consumer-metadata">

		<dl>
			<dt>
				<liferay-ui:message key="consumer-id" />
			</dt>
			<dd>${consumer.consumerId}</dd>

			<dt>
				<liferay-ui:message key="consumer-name" />
			</dt>
			<dd>${consumer.consumerName}</dd>

			<%-- <dt>
				<liferay-ui:message key="description" />
			</dt>
			<dd>${consumer.getDescription(locale)}</dd> --%>
			<dt>
				<liferay-ui:message key="supported-document-type" />
			</dt>
			<dd>${consumer.supportedDocumentType}</dd>
		</dl>
	</div>
</div>