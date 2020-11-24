package com.moi.dms.document.handler.internal.resource.v1_0;

import com.liferay.portal.vulcan.pagination.Page;
import com.moi.dms.document.handler.dto.v1_0.MosipDocumentHandler;
import com.moi.dms.document.handler.resource.v1_0.MosipDocumentHandlerResource;

import javax.validation.constraints.NotNull;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Mohit
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/mosip-document-handler.properties",
	scope = ServiceScope.PROTOTYPE, service = MosipDocumentHandlerResource.class
)
public class MosipDocumentHandlerResourceImpl
	extends BaseMosipDocumentHandlerResourceImpl {
	
@Override
public Page<MosipDocumentHandler> getSiteAppointmentsPage(@NotNull Long siteId) throws Exception {
	// TODO Auto-generated method stub
	return super.getSiteAppointmentsPage(siteId);
}
	
}