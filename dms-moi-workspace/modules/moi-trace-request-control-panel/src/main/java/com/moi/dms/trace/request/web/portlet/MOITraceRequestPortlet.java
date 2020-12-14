package com.moi.dms.trace.request.web.portlet;

import com.moi.dms.trace.request.web.constants.MOITraceRequestPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Chintan Bhadra
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.display-category=category.hidden",
		"javax.portlet.display-name=MOI Request Trace",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + MOITraceRequestPortletKeys.MOITraceRequest,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,administrator",
		"javax.portlet.init-param.add-process-action-success-action=false",
		"javax.portlet.version=3.0"
	},
	service = Portlet.class
)
public class MOITraceRequestPortlet extends MVCPortlet {
}