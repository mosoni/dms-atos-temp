package com.moi.dms.consumer.registration.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.moi.dms.consumer.registration.web.constants.DMSConsumerRegistrationPortletKeys;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Chintan Bhadra
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.css-class-wrapper=DMSConsumerRegistration-portlet",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.display-category=category.hidden",
		"javax.portlet.display-name=DMS Consumer Registration",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DMSConsumerRegistrationPortletKeys.DMSConsumerRegistration,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,administrator",
		"javax.portlet.init-param.add-process-action-success-action=false"
	},
	service = Portlet.class
)
public class DMSConsumerRegistrationPortlet extends MVCPortlet {
}