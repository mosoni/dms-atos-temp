package com.moi.dms.document.handler.client.resource.v1_0;

import com.moi.dms.document.handler.client.dto.v1_0.MosipDocumentHandler;
import com.moi.dms.document.handler.client.http.HttpInvoker;
import com.moi.dms.document.handler.client.pagination.Page;
import com.moi.dms.document.handler.client.problem.Problem;
import com.moi.dms.document.handler.client.serdes.v1_0.MosipDocumentHandlerSerDes;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Generated;

/**
 * @author Mohit
 * @generated
 */
@Generated("")
public interface MosipDocumentHandlerResource {

	public static Builder builder() {
		return new Builder();
	}

	public Page<MosipDocumentHandler> getSiteAppointmentsPage(Long siteId)
		throws Exception;

	public HttpInvoker.HttpResponse getSiteAppointmentsPageHttpResponse(
			Long siteId)
		throws Exception;

	public static class Builder {

		public Builder authentication(String login, String password) {
			_login = login;
			_password = password;

			return this;
		}

		public MosipDocumentHandlerResource build() {
			return new MosipDocumentHandlerResourceImpl(this);
		}

		public Builder endpoint(String host, int port, String scheme) {
			_host = host;
			_port = port;
			_scheme = scheme;

			return this;
		}

		public Builder header(String key, String value) {
			_headers.put(key, value);

			return this;
		}

		public Builder locale(Locale locale) {
			_locale = locale;

			return this;
		}

		public Builder parameter(String key, String value) {
			_parameters.put(key, value);

			return this;
		}

		private Builder() {
		}

		private Map<String, String> _headers = new LinkedHashMap<>();
		private String _host = "localhost";
		private Locale _locale;
		private String _login = "test@liferay.com";
		private String _password = "test";
		private Map<String, String> _parameters = new LinkedHashMap<>();
		private int _port = 8080;
		private String _scheme = "http";

	}

	public static class MosipDocumentHandlerResourceImpl
		implements MosipDocumentHandlerResource {

		public Page<MosipDocumentHandler> getSiteAppointmentsPage(Long siteId)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				getSiteAppointmentsPageHttpResponse(siteId);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			try {
				return Page.of(content, MosipDocumentHandlerSerDes::toDTO);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
		}

		public HttpInvoker.HttpResponse getSiteAppointmentsPageHttpResponse(
				Long siteId)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			for (Map.Entry<String, String> entry :
					_builder._headers.entrySet()) {

				httpInvoker.header(entry.getKey(), entry.getValue());
			}

			for (Map.Entry<String, String> entry :
					_builder._parameters.entrySet()) {

				httpInvoker.parameter(entry.getKey(), entry.getValue());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port +
						"/o/moi-document-handler/v1.0/mosip/{siteId}/fetch-document",
				siteId);

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		private MosipDocumentHandlerResourceImpl(Builder builder) {
			_builder = builder;
		}

		private static final Logger _logger = Logger.getLogger(
			MosipDocumentHandlerResource.class.getName());

		private Builder _builder;

	}

}