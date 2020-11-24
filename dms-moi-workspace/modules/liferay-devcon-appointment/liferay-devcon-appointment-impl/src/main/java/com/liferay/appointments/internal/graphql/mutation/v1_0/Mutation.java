package com.liferay.appointments.internal.graphql.mutation.v1_0;

import com.liferay.appointments.dto.v1_0.Appointment;
import com.liferay.appointments.dto.v1_0.SiteDocument;
import com.liferay.appointments.resource.v1_0.AppointmentResource;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.multipart.MultipartBody;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.validation.constraints.NotEmpty;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Javier Gamarra
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setAppointmentResourceComponentServiceObjects(
		ComponentServiceObjects<AppointmentResource>
			appointmentResourceComponentServiceObjects) {

		_appointmentResourceComponentServiceObjects =
			appointmentResourceComponentServiceObjects;
	}

	@GraphQLField(description = "")
	public Appointment createSiteAppointment(
			@GraphQLName("siteKey") @NotEmpty String siteKey,
			@GraphQLName("appointment") Appointment appointment)
		throws Exception {

		return _applyComponentServiceObjects(
			_appointmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			appointmentResource -> appointmentResource.postSiteAppointment(
				Long.valueOf(siteKey), appointment));
	}

	@GraphQLField
	public Response createSiteAppointmentBatch(
			@GraphQLName("siteKey") @NotEmpty String siteKey,
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_appointmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			appointmentResource -> appointmentResource.postSiteAppointmentBatch(
				Long.valueOf(siteKey), callbackURL, object));
	}

	@GraphQLField(description = "")
	@GraphQLName(
		value = "postSiteAppointmentDocumentSiteIdMultipartBody",
		description = ""
	)
	public SiteDocument createSiteAppointmentDocument(
			@GraphQLName("siteKey") @NotEmpty String siteKey,
			@GraphQLName("multipartBody") MultipartBody multipartBody)
		throws Exception {

		return _applyComponentServiceObjects(
			_appointmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			appointmentResource ->
				appointmentResource.postSiteAppointmentDocument(
					Long.valueOf(siteKey), multipartBody));
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
	private com.liferay.portal.kernel.model.Company _company;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private com.liferay.portal.kernel.model.User _user;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private UriInfo _uriInfo;

}