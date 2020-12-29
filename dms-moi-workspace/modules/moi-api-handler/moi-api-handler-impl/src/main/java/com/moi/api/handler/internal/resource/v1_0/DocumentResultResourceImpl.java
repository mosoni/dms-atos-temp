package com.moi.api.handler.internal.resource.v1_0;

import com.liferay.portal.vulcan.multipart.BinaryFile;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import com.liferay.portal.vulcan.pagination.Page;
import com.moi.api.handler.dto.v1_0.JiraAPIHandler;
import com.moi.api.handler.resource.v1_0.DocumentResultResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Mohit
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/document-result.properties",
	scope = ServiceScope.PROTOTYPE, service = DocumentResultResource.class
)
public class DocumentResultResourceImpl extends BaseDocumentResultResourceImpl {
	@Override
	public Page<JiraAPIHandler> uploadJiraDocument(String consumerCode,
			String ticketNumber, String documentTitle, String metadata,
			MultipartBody multipartBody) throws Exception {

		// Fetching result from request parameters
		System.out.println("---- Fetching result from parameters ----");
		System.out.println("consumerCode: " + consumerCode);
		System.out.println("ticketNumber: " + ticketNumber);
		System.out.println("documentTitle: " + documentTitle);
		System.out.println("metadata: " + metadata);

		BinaryFile binaryFile = multipartBody.getBinaryFile("document");
		if (binaryFile == null) {
			System.out.println("No file found in body");
			return null;
		}

		// Fetching result from request body
		System.out.println("File Name: " + binaryFile.getFileName());
		System.out.println("---- Fetching result from body ----");
		System.out.println("consumerCode: "
				+ multipartBody.getValueAsString("consumerCode"));
		System.out.println("ticketNumber: "
				+ multipartBody.getValueAsString("ticketNumber"));
		System.out.println("documentTitle: "
				+ multipartBody.getValueAsString("documentTitle"));
		System.out.println(
				"metadata: " + multipartBody.getValueAsString("metadata"));

		return super.uploadJiraDocument(consumerCode, ticketNumber,
				documentTitle, metadata, multipartBody);
	}
}