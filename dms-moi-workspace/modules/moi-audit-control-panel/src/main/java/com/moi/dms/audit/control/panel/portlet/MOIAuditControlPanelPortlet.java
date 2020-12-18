package com.moi.dms.audit.control.panel.portlet;

import com.moi.dms.audit.control.panel.constants.MOIAuditControlPanelPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Ganesh Shelke
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=MOI Audit Control Panel",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + MOIAuditControlPanelPortletKeys.MOIAUDITCONTROLPANEL,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.version=3.0",
		"com.liferay.portlet.header-portlet-css=/css/main.css"
	},
	service = Portlet.class
)
public class MOIAuditControlPanelPortlet extends MVCPortlet {
}