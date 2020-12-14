package com.moi.dms.consumer.registration.web.portlet;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;
import com.moi.dms.consumer.registration.web.constants.DMSConsumerRegistrationPortletKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * This class displays the portlet in the Site Administrator Content panel.
 * 
 * @author Chintan Bhadra
 *
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=1600",
		"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT
	},
	service = PanelApp.class
)
public class ConsumerRegistrationPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return DMSConsumerRegistrationPortletKeys.DMSConsumerRegistration;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + DMSConsumerRegistrationPortletKeys.DMSConsumerRegistration + ")", unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}
