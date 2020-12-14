package com.moi.dms.audit.control.panel.portlet;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;
import com.moi.dms.audit.control.panel.constants.MOIAuditControlPanelPortletKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Ganesh Shelke
 */

@Component(
     immediate = true,
     property = {
         "panel.app.order:Integer=100",
         "panel.category.key=" + PanelCategoryKeys.CONTROL_PANEL_USERS
     },
    service = PanelApp.class
)
public class MOIAuditPanelApp extends BasePanelApp{
	 @Override
	    public String getPortletId() {
	 return MOIAuditControlPanelPortletKeys.MOIAUDITCONTROLPANEL;
	    }

	    @Override
	    @Reference(target = "(javax.portlet.name=" + MOIAuditControlPanelPortletKeys.MOIAUDITCONTROLPANEL + ")",unbind = "-")
	    public void setPortlet(Portlet portlet) {
	        super.setPortlet(portlet);
	    }
}
