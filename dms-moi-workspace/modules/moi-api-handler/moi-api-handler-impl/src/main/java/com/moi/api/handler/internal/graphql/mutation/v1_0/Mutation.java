package com.moi.api.handler.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import com.liferay.portal.vulcan.pagination.Page;

import com.moi.api.handler.dto.v1_0.JiraAPIHandler;
import com.moi.api.handler.resource.v1_0.DocumentResultResource;

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

	public static void setDocumentResultResourceComponentServiceObjects(
		ComponentServiceObjects<DocumentResultResource>
			documentResultResourceComponentServiceObjects) {

		_documentResultResourceComponentServiceObjects =
			documentResultResourceComponentServiceObjects;
	}

	@GraphQLField
	@GraphQLName(
		value = "uploadJiraDocumentConsumerCodeTicketNumberDocumentTitleMetadataMultipartBody",
		description = "null"
	)
	public java.util.Collection<JiraAPIHandler> uploadJiraDocument(
			@GraphQLName("consumerCode") String consumerCode,
			@GraphQLName("ticketNumber") String ticketNumber,
			@GraphQLName("documentTitle") String documentTitle,
			@GraphQLName("metadata") String metadata,
			@GraphQLName("multipartBody") MultipartBody multipartBody)
		throws Exception {

		return _applyComponentServiceObjects(
			_documentResultResourceComponentServiceObjects,
			this::_populateResourceContext,
			documentResultResource -> {
				Page paginationPage = documentResultResource.uploadJiraDocument(
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
			DocumentResultResource documentResultResource)
		throws Exception {

		documentResultResource.setContextAcceptLanguage(_acceptLanguage);
		documentResultResource.setContextCompany(_company);
		documentResultResource.setContextHttpServletRequest(
			_httpServletRequest);
		documentResultResource.setContextHttpServletResponse(
			_httpServletResponse);
		documentResultResource.setContextUriInfo(_uriInfo);
		documentResultResource.setContextUser(_user);
	}

	private static ComponentServiceObjects<DocumentResultResource>
		_documentResultResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private com.liferay.portal.kernel.model.User _user;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private UriInfo _uriInfo;

}