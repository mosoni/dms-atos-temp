package com.moi.api.handler.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import com.liferay.portal.vulcan.pagination.Page;

import com.moi.api.handler.dto.v1_0.DocumentResult;
import com.moi.api.handler.resource.v1_0.JiraAPIHandlerResource;
import com.moi.api.handler.resource.v1_0.MosipAPIHandlerResource;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Mohit
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setJiraAPIHandlerResourceComponentServiceObjects(
		ComponentServiceObjects<JiraAPIHandlerResource>
			jiraAPIHandlerResourceComponentServiceObjects) {

		_jiraAPIHandlerResourceComponentServiceObjects =
			jiraAPIHandlerResourceComponentServiceObjects;
	}

	public static void setMosipAPIHandlerResourceComponentServiceObjects(
		ComponentServiceObjects<MosipAPIHandlerResource>
			mosipAPIHandlerResourceComponentServiceObjects) {

		_mosipAPIHandlerResourceComponentServiceObjects =
			mosipAPIHandlerResourceComponentServiceObjects;
	}

	@GraphQLField
	@GraphQLName(
		value = "uploadMosipDocumentModuleTypeConsumerCodeDocumentTypeIdentifierNumberMetadataPreviousModuleTypePreviousIdentifierMultipartBody",
		description = "null"
	)
	public java.util.Collection<DocumentResult> uploadMosipDocument(
			@GraphQLName("ModuleType") String ModuleType,
			@GraphQLName("ConsumerCode") String ConsumerCode,
			@GraphQLName("DocumentType") String DocumentType,
			@GraphQLName("IdentifierNumber") String IdentifierNumber,
			@GraphQLName("Metadata") String Metadata,
			@GraphQLName("PreviousModuleType") String PreviousModuleType,
			@GraphQLName("PreviousIdentifier") String PreviousIdentifier,
			@GraphQLName("multipartBody") MultipartBody multipartBody)
		throws Exception {

		return _applyComponentServiceObjects(
			_mosipAPIHandlerResourceComponentServiceObjects,
			this::_populateResourceContext,
			mosipAPIHandlerResource -> {
				Page paginationPage =
					mosipAPIHandlerResource.uploadMosipDocument(
						ModuleType, ConsumerCode, DocumentType,
						IdentifierNumber, Metadata, PreviousModuleType,
						PreviousIdentifier, multipartBody);

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLName(
		value = "updateMosipDocumentModuleTypeConsumerCodeDocumentTypeIdentifierNumberMetadataPreviousModuleTypePreviousIdentifierMultipartBody",
		description = "null"
	)
	public java.util.Collection<DocumentResult> updateMosipDocument(
			@GraphQLName("ModuleType") String ModuleType,
			@GraphQLName("ConsumerCode") String ConsumerCode,
			@GraphQLName("DocumentType") String DocumentType,
			@GraphQLName("IdentifierNumber") String IdentifierNumber,
			@GraphQLName("Metadata") String Metadata,
			@GraphQLName("PreviousModuleType") String PreviousModuleType,
			@GraphQLName("PreviousIdentifier") String PreviousIdentifier,
			@GraphQLName("multipartBody") MultipartBody multipartBody)
		throws Exception {

		return _applyComponentServiceObjects(
			_mosipAPIHandlerResourceComponentServiceObjects,
			this::_populateResourceContext,
			mosipAPIHandlerResource -> {
				Page paginationPage =
					mosipAPIHandlerResource.updateMosipDocument(
						ModuleType, ConsumerCode, DocumentType,
						IdentifierNumber, Metadata, PreviousModuleType,
						PreviousIdentifier, multipartBody);

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	public java.util.Collection<DocumentResult> getMosipDocument(
			@GraphQLName("ModuleType") String ModuleType,
			@GraphQLName("ConsumerCode") String ConsumerCode,
			@GraphQLName("DocumentType") String DocumentType,
			@GraphQLName("Identifier") String Identifier)
		throws Exception {

		return _applyComponentServiceObjects(
			_mosipAPIHandlerResourceComponentServiceObjects,
			this::_populateResourceContext,
			mosipAPIHandlerResource -> {
				Page paginationPage = mosipAPIHandlerResource.getMosipDocument(
					ModuleType, ConsumerCode, DocumentType, Identifier);

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	public java.util.Collection<DocumentResult> addIDCSNumber(
			@GraphQLName("RegistrationNumber") String RegistrationNumber,
			@GraphQLName("IDCSNumber") String IDCSNumber)
		throws Exception {

		return _applyComponentServiceObjects(
			_mosipAPIHandlerResourceComponentServiceObjects,
			this::_populateResourceContext,
			mosipAPIHandlerResource -> {
				Page paginationPage = mosipAPIHandlerResource.addIDCSNumber(
					RegistrationNumber, IDCSNumber);

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLName(
		value = "deleteMosipDocumentModuleTypeConsumerCodeMultipartBody",
		description = "null"
	)
	public java.util.Collection<DocumentResult> deleteMosipDocument(
			@GraphQLName("ModuleType") String ModuleType,
			@GraphQLName("ConsumerCode") String ConsumerCode,
			@GraphQLName("multipartBody") MultipartBody multipartBody)
		throws Exception {

		return _applyComponentServiceObjects(
			_mosipAPIHandlerResourceComponentServiceObjects,
			this::_populateResourceContext,
			mosipAPIHandlerResource -> {
				Page paginationPage =
					mosipAPIHandlerResource.deleteMosipDocument(
						ModuleType, ConsumerCode, multipartBody);

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLName(
		value = "uploadJiraDocumentConsumerCodeTicketNumberDocumentTitleMetadataMultipartBody",
		description = "null"
	)
	public java.util.Collection<DocumentResult> uploadJiraDocument(
			@GraphQLName("consumerCode") String consumerCode,
			@GraphQLName("ticketNumber") String ticketNumber,
			@GraphQLName("documentTitle") String documentTitle,
			@GraphQLName("metadata") String metadata,
			@GraphQLName("multipartBody") MultipartBody multipartBody)
		throws Exception {

		return _applyComponentServiceObjects(
			_jiraAPIHandlerResourceComponentServiceObjects,
			this::_populateResourceContext,
			jiraAPIHandlerResource -> {
				Page paginationPage = jiraAPIHandlerResource.uploadJiraDocument(
					consumerCode, ticketNumber, documentTitle, metadata,
					multipartBody);

				return paginationPage.getItems();
			});
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(
			JiraAPIHandlerResource jiraAPIHandlerResource)
		throws Exception {

		jiraAPIHandlerResource.setContextAcceptLanguage(_acceptLanguage);
		jiraAPIHandlerResource.setContextCompany(_company);
		jiraAPIHandlerResource.setContextHttpServletRequest(
			_httpServletRequest);
		jiraAPIHandlerResource.setContextHttpServletResponse(
			_httpServletResponse);
		jiraAPIHandlerResource.setContextUriInfo(_uriInfo);
		jiraAPIHandlerResource.setContextUser(_user);
	}

	private void _populateResourceContext(
			MosipAPIHandlerResource mosipAPIHandlerResource)
		throws Exception {

		mosipAPIHandlerResource.setContextAcceptLanguage(_acceptLanguage);
		mosipAPIHandlerResource.setContextCompany(_company);
		mosipAPIHandlerResource.setContextHttpServletRequest(
			_httpServletRequest);
		mosipAPIHandlerResource.setContextHttpServletResponse(
			_httpServletResponse);
		mosipAPIHandlerResource.setContextUriInfo(_uriInfo);
		mosipAPIHandlerResource.setContextUser(_user);
	}

	private static ComponentServiceObjects<JiraAPIHandlerResource>
		_jiraAPIHandlerResourceComponentServiceObjects;
	private static ComponentServiceObjects<MosipAPIHandlerResource>
		_mosipAPIHandlerResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private com.liferay.portal.kernel.model.User _user;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private UriInfo _uriInfo;

}