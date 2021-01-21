package com.liferay.appointments.internal.graphql.query.v1_0;

import com.liferay.appointments.dto.v1_0.Appointment;
import com.liferay.appointments.dto.v1_0.SiteDocument;
import com.liferay.appointments.resource.v1_0.AppointmentResource;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.validation.constraints.NotEmpty;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Javier Gamarra
 * @generated
 */
@Generated("")
public class Query {

	public static void setAppointmentResourceComponentServiceObjects(
		ComponentServiceObjects<AppointmentResource>
			appointmentResourceComponentServiceObjects) {

		_appointmentResourceComponentServiceObjects =
			appointmentResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {appointments(siteKey: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public AppointmentPage appointments(
			@GraphQLName("siteKey") @NotEmpty String siteKey)
		throws Exception {

		return _applyComponentServiceObjects(
			_appointmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			appointmentResource -> new AppointmentPage(
				appointmentResource.getSiteAppointmentsPage(
					Long.valueOf(siteKey))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {appointmentDocument(DocumentType: ___, Identifier: ___, ModuleType: ___){id, name, mimeType, folderName, file}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public SiteDocument appointmentDocument(
			@GraphQLName("ModuleType") String ModuleType,
			@GraphQLName("DocumentType") String DocumentType,
			@GraphQLName("Identifier") String Identifier)
		throws Exception {

		return _applyComponentServiceObjects(
			_appointmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			appointmentResource ->
				appointmentResource.getSiteAppointmentDocument(
					ModuleType, DocumentType, Identifier));
	}

	@GraphQLName("AppointmentPage")
	public class AppointmentPage {

		public AppointmentPage(Page appointmentPage) {
			actions = appointmentPage.getActions();
			items = appointmentPage.getItems();
			lastPage = appointmentPage.getLastPage();
			page = appointmentPage.getPage();
			pageSize = appointmentPage.getPageSize();
			totalCount = appointmentPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Appointment> items;

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
			AppointmentResource appointmentResource)
		throws Exception {

		appointmentResource.setContextAcceptLanguage(_acceptLanguage);
		appointmentResource.setContextCompany(_company);
		appointmentResource.setContextHttpServletRequest(_httpServletRequest);
		appointmentResource.setContextHttpServletResponse(_httpServletResponse);
		appointmentResource.setContextUriInfo(_uriInfo);
		appointmentResource.setContextUser(_user);
	}

	private static ComponentServiceObjects<AppointmentResource>
		_appointmentResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private com.liferay.portal.kernel.model.Company _company;
	private com.liferay.portal.kernel.model.User _user;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private UriInfo _uriInfo;

}