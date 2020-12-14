package com.moi.dms.trace.request.web.portlet;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;
import com.moi.dms.trace.request.web.constants.MOITraceRequestPortletKeys;

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
		"panel.app.order:Integer=1700",
		"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT
	},
	service = PanelApp.class
)
public class MOITraceRequestPanelApp extends BasePanelApp {

	/**
	 * Get Portlet Id.
	 * 
	 * @return String
	 */
	@Override
	public String getPortletId() {
		return MOITraceRequestPortletKeys.MOITraceRequest;
	}

	/**
	 * Set Portlet Id
	 * 
	 * @param portlet
	 */
	@Override
	@Reference(target = "(javax.portlet.name="
			+ MOITraceRequestPortletKeys.MOITraceRequest + ")", unbind = "-")
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}
}
