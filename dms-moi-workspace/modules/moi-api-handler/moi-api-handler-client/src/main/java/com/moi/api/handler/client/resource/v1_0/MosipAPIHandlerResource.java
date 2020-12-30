package com.moi.api.handler.client.resource.v1_0;

import com.moi.api.handler.client.dto.v1_0.DocumentResult;
import com.moi.api.handler.client.dto.v1_0.MosipAPIHandler;
import com.moi.api.handler.client.http.HttpInvoker;
import com.moi.api.handler.client.pagination.Page;
import com.moi.api.handler.client.problem.Problem;
import com.moi.api.handler.client.serdes.v1_0.DocumentResultSerDes;
import com.moi.api.handler.client.serdes.v1_0.MosipAPIHandlerSerDes;

import java.io.File;

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
public interface MosipAPIHandlerResource {

	public static Builder builder() {
		return new Builder();
	}

	public Page<DocumentResult> uploadMosipDocument(
			String ModuleType, String ConsumerCode, String DocumentType,
			String IdentifierNumber, String Metadata, String PreviousModuleType,
			String PreviousIdentifier, MosipAPIHandler mosipAPIHandler,
			Map<String, File> multipartFiles)
		throws Exception;

	public HttpInvoker.HttpResponse uploadMosipDocumentHttpResponse(
			String ModuleType, String ConsumerCode, String DocumentType,
			String IdentifierNumber, String Metadata, String PreviousModuleType,
			String PreviousIdentifier, MosipAPIHandler mosipAPIHandler,
			Map<String, File> multipartFiles)
		throws Exception;

	public Page<DocumentResult> updateMosipDocument(
			String ModuleType, String ConsumerCode, String DocumentType,
			String IdentifierNumber, String Metadata, String PreviousModuleType,
			String PreviousIdentifier, MosipAPIHandler mosipAPIHandler,
			Map<String, File> multipartFiles)
		throws Exception;

	public HttpInvoker.HttpResponse updateMosipDocumentHttpResponse(
			String ModuleType, String ConsumerCode, String DocumentType,
			String IdentifierNumber, String Metadata, String PreviousModuleType,
			String PreviousIdentifier, MosipAPIHandler mosipAPIHandler,
			Map<String, File> multipartFiles)
		throws Exception;

	public static class Builder {

		public Builder authentication(String login, String password) {
			_login = login;
			_password = password;

			return this;
		}

		public MosipAPIHandlerResource build() {
			return new MosipAPIHandlerResourceImpl(this);
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

	public static class MosipAPIHandlerResourceImpl
		implements MosipAPIHandlerResource {

		public Page<DocumentResult> uploadMosipDocument(
				String ModuleType, String ConsumerCode, String DocumentType,
				String IdentifierNumber, String Metadata,
				String PreviousModuleType, String PreviousIdentifier,
				MosipAPIHandler mosipAPIHandler,
				Map<String, File> multipartFiles)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				uploadMosipDocumentHttpResponse(
					ModuleType, ConsumerCode, DocumentType, IdentifierNumber,
					Metadata, PreviousModuleType, PreviousIdentifier,
					mosipAPIHandler, multipartFiles);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			try {
				return Page.of(content, DocumentResultSerDes::toDTO);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
		}

		public HttpInvoker.HttpResponse uploadMosipDocumentHttpResponse(
				String ModuleType, String ConsumerCode, String DocumentType,
				String IdentifierNumber, String Metadata,
				String PreviousModuleType, String PreviousIdentifier,
				MosipAPIHandler mosipAPIHandler,
				Map<String, File> multipartFiles)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			httpInvoker.multipart();

			httpInvoker.part(
				"mosipAPIHandler",
				MosipAPIHandlerSerDes.toJSON(mosipAPIHandler));

			for (Map.Entry<String, File> entry : multipartFiles.entrySet()) {
				httpInvoker.part(entry.getKey(), entry.getValue());
			}

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

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

			if (ModuleType != null) {
				httpInvoker.parameter("ModuleType", String.valueOf(ModuleType));
			}

			if (ConsumerCode != null) {
				httpInvoker.parameter(
					"ConsumerCode", String.valueOf(ConsumerCode));
			}

			if (DocumentType != null) {
				httpInvoker.parameter(
					"DocumentType", String.valueOf(DocumentType));
			}

			if (IdentifierNumber != null) {
				httpInvoker.parameter(
					"IdentifierNumber", String.valueOf(IdentifierNumber));
			}

			if (Metadata != null) {
				httpInvoker.parameter("Metadata", String.valueOf(Metadata));
			}

			if (PreviousModuleType != null) {
				httpInvoker.parameter(
					"PreviousModuleType", String.valueOf(PreviousModuleType));
			}

			if (PreviousIdentifier != null) {
				httpInvoker.parameter(
					"PreviousIdentifier", String.valueOf(PreviousIdentifier));
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port + "/o/moi-api-handler/v1.0/uploadDocument");

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		public Page<DocumentResult> updateMosipDocument(
				String ModuleType, String ConsumerCode, String DocumentType,
				String IdentifierNumber, String Metadata,
				String PreviousModuleType, String PreviousIdentifier,
				MosipAPIHandler mosipAPIHandler,
				Map<String, File> multipartFiles)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				updateMosipDocumentHttpResponse(
					ModuleType, ConsumerCode, DocumentType, IdentifierNumber,
					Metadata, PreviousModuleType, PreviousIdentifier,
					mosipAPIHandler, multipartFiles);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			try {
				return Page.of(content, DocumentResultSerDes::toDTO);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
		}

		public HttpInvoker.HttpResponse updateMosipDocumentHttpResponse(
				String ModuleType, String ConsumerCode, String DocumentType,
				String IdentifierNumber, String Metadata,
				String PreviousModuleType, String PreviousIdentifier,
				MosipAPIHandler mosipAPIHandler,
				Map<String, File> multipartFiles)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			httpInvoker.multipart();

			httpInvoker.part(
				"mosipAPIHandler",
				MosipAPIHandlerSerDes.toJSON(mosipAPIHandler));

			for (Map.Entry<String, File> entry : multipartFiles.entrySet()) {
				httpInvoker.part(entry.getKey(), entry.getValue());
			}

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

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

			if (ModuleType != null) {
				httpInvoker.parameter("ModuleType", String.valueOf(ModuleType));
			}

			if (ConsumerCode != null) {
				httpInvoker.parameter(
					"ConsumerCode", String.valueOf(ConsumerCode));
			}

			if (DocumentType != null) {
				httpInvoker.parameter(
					"DocumentType", String.valueOf(DocumentType));
			}

			if (IdentifierNumber != null) {
				httpInvoker.parameter(
					"IdentifierNumber", String.valueOf(IdentifierNumber));
			}

			if (Metadata != null) {
				httpInvoker.parameter("Metadata", String.valueOf(Metadata));
			}

			if (PreviousModuleType != null) {
				httpInvoker.parameter(
					"PreviousModuleType", String.valueOf(PreviousModuleType));
			}

			if (PreviousIdentifier != null) {
				httpInvoker.parameter(
					"PreviousIdentifier", String.valueOf(PreviousIdentifier));
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port + "/o/moi-api-handler/v1.0/updateDocument");

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		private MosipAPIHandlerResourceImpl(Builder builder) {
			_builder = builder;
		}

		private static final Logger _logger = Logger.getLogger(
			MosipAPIHandlerResource.class.getName());

		private Builder _builder;

	}

}