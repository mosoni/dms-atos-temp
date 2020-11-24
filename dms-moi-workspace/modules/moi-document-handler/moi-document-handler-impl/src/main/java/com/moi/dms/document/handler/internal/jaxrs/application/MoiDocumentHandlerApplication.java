package com.moi.dms.document.handler.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author Mohit
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false",
		"osgi.jaxrs.application.base=/moi-document-handler",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=MoiDocumentHandler"
	},
	service = Application.class
)
@Generated("")
public class MoiDocumentHandlerApplication extends Application {
}