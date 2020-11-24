package com.moi.dms.document.handler.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;

import com.moi.dms.document.handler.dto.v1_0.MosipDocumentHandler;
import com.moi.dms.document.handler.resource.v1_0.MosipDocumentHandlerResource;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.validation.constraints.NotEmpty;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Mohit
 * @generated
 */
@Generated("")
public class Query {

	public static void setMosipDocumentHandlerResourceComponentServiceObjects(
		ComponentServiceObjects<MosipDocumentHandlerResource>
			mosipDocumentHandlerResourceComponentServiceObjects) {

		_mosipDocumentHandlerResourceComponentServiceObjects =
			mosipDocumentHandlerResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {appointments(siteKey: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public MosipDocumentHandlerPage appointments(
			@GraphQLName("siteKey") @NotEmpty String siteKey)
		throws Exception {

		return _applyComponentServiceObjects(
			_mosipDocumentHandlerResourceComponentServiceObjects,
			this::_populateResourceContext,
			mosipDocumentHandlerResource -> new MosipDocumentHandlerPage(
				mosipDocumentHandlerResource.getSiteAppointmentsPage(
					Long.valueOf(siteKey))));
	}

	@GraphQLName("MosipDocumentHandlerPage")
	public class MosipDocumentHandlerPage {

		public MosipDocumentHandlerPage(Page mosipDocumentHandlerPage) {
			actions = mosipDocumentHandlerPage.getActions();
			items = mosipDocumentHandlerPage.getItems();
			lastPage = mosipDocumentHandlerPage.getLastPage();
			page = mosipDocumentHandlerPage.getPage();
			pageSize = mosipDocumentHandlerPage.getPageSize();
			totalCount = mosipDocumentHandlerPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<MosipDocumentHandler> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

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

	private void _populateResourceContext(
			MosipDocumentHandlerResource mosipDocumentHandlerResource)
		throws Exception {

		mosipDocumentHandlerResource.setContextAcceptLanguage(_acceptLanguage);
		mosipDocumentHandlerResource.setContextCompany(_company);
		mosipDocumentHandlerResource.setContextHttpServletRequest(
			_httpServletRequest);
		mosipDocumentHandlerResource.setContextHttpServletResponse(
			_httpServletResponse);
		mosipDocumentHandlerResource.setContextUriInfo(_uriInfo);
		mosipDocumentHandlerResource.setContextUser(_user);
	}

	private static ComponentServiceObjects<MosipDocumentHandlerResource>
		_mosipDocumentHandlerResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private com.liferay.portal.kernel.model.Company _company;
	private com.liferay.portal.kernel.model.User _user;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private UriInfo _uriInfo;

}