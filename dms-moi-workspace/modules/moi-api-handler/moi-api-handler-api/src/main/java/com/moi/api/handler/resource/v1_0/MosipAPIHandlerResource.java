package com.moi.api.handler.resource.v1_0;

import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import com.liferay.portal.vulcan.pagination.Page;

import com.moi.api.handler.dto.v1_0.DocumentResult;

import java.util.Locale;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.annotation.versioning.ProviderType;

/**
 * To access this resource, run:
 *
 *     curl -u your@email.com:yourpassword -D - http://localhost:8080/o/moi-api-handler/v1.0
 *
 * @author Mohit
 * @generated
 */
@Generated("")
@ProviderType
public interface MosipAPIHandlerResource {

	public static Builder builder() {
		return FactoryHolder.factory.create();
	}

	public Page<DocumentResult> uploadMosipDocument(
			String ModuleType, String ConsumerCode, String DocumentType,
			String IdentifierNumber, String Metadata, String PreviousModuleType,
			String PreviousIdentifier, MultipartBody multipartBody)
		throws Exception;

	public Page<DocumentResult> updateMosipDocument(
			String ModuleType, String ConsumerCode, String DocumentType,
			String IdentifierNumber, String Metadata, String PreviousModuleType,
			String PreviousIdentifier, MultipartBody multipartBody)
		throws Exception;

	public Page<DocumentResult> getMosipDocument(
			String ModuleType, String ConsumerCode, String DocumentType,
			String Identifier)
		throws Exception;

	public Page<DocumentResult> addIDCSNumber(
			String RegistrationNumber, String IDCSNumber)
		throws Exception;

	public Page<DocumentResult> deleteMosipDocument(
			String ModuleType, MultipartBody multipartBody)
		throws Exception;

	public default void setContextAcceptLanguage(
		AcceptLanguage contextAcceptLanguage) {
	}

	public void setContextCompany(
		com.liferay.portal.kernel.model.Company contextCompany);

	public default void setContextHttpServletRequest(
		HttpServletRequest contextHttpServletRequest) {
	}

	public default void setContextHttpServletResponse(
		HttpServletResponse contextHttpServletResponse) {
	}

	public default void setContextUriInfo(UriInfo contextUriInfo) {
	}

	public void setContextUser(
		com.liferay.portal.kernel.model.User contextUser);

	public static class FactoryHolder {

		public static volatile Factory factory;

	}

	@ProviderType
	public interface Builder {

		public MosipAPIHandlerResource build();

		public Builder checkPermissions(boolean checkPermissions);

		public Builder httpServletRequest(
			HttpServletRequest httpServletRequest);

		public Builder preferredLocale(Locale preferredLocale);

		public Builder user(com.liferay.portal.kernel.model.User user);

	}

	@ProviderType
	public interface Factory {

		public Builder create();

	}

}