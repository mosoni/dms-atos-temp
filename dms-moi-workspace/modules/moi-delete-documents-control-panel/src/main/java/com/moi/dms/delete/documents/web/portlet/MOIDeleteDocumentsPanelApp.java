package com.moi.dms.delete.documents.web.portlet;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;
import com.moi.dms.delete.documents.web.constants.MOIDeleteDocumentsPortletKeys;

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
		"panel.app.order:Integer=1800",
		"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT
	},
	service = PanelApp.class
)
public class MOIDeleteDocumentsPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return MOIDeleteDocumentsPortletKeys.MOIDELETEDOCUMENTS;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + MOIDeleteDocumentsPortletKeys.MOIDELETEDOCUMENTS + ")", unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}
