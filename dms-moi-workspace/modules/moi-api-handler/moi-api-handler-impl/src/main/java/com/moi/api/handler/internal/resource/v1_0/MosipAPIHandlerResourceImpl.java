package com.moi.api.handler.internal.resource.v1_0;

import com.moi.api.handler.resource.v1_0.MosipAPIHandlerResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Mohit
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/mosip-api-handler.properties",
	scope = ServiceScope.PROTOTYPE, service = MosipAPIHandlerResource.class
)
public class MosipAPIHandlerResourceImpl
	extends BaseMosipAPIHandlerResourceImpl {
}