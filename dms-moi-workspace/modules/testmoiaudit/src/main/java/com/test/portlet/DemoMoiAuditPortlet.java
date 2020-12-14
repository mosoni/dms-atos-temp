package com.test.portlet;

import com.test.constants.DemoMoiAuditPortletKeys;

import java.io.IOException;
import java.util.Date;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.moi.dms.audit.model.MOIAudit;
import com.moi.dms.audit.service.MOIAuditLocalService;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Ganesh Shelke
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DemoMoiAudit",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DemoMoiAuditPortletKeys.DEMOMOIAUDIT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DemoMoiAuditPortlet extends MVCPortlet {
	
	/*
	 * @Reference private MOIAuditLocalService _moiAuditLocalService;
	 */
	@Reference
	private MOIAuditLocalService _moiAuditLocalService;
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		
		
		
		  MOIAudit moiAudit =
		  _moiAuditLocalService.createMOIAudit(CounterLocalServiceUtil.
		  increment()); moiAudit.setActionPerformedBy("D");
		  moiAudit.setActionPerformedDate(new Date());
		  moiAudit.setActionStatus("Open");
		  moiAudit.setActionDescription("View");
		  moiAudit.setActionConsumer("C");
		  _moiAuditLocalService.addMOIAudit(moiAudit);
		  
		  MOIAudit moiAudit1 =
		  _moiAuditLocalService.createMOIAudit(CounterLocalServiceUtil.
		  increment()); moiAudit1.setActionPerformedBy("E");
		  moiAudit1.setActionPerformedDate(new Date());
		  moiAudit1.setActionStatus("Open");
		  moiAudit1.setActionDescription("Access");
		  moiAudit1.setActionConsumer("R");
		  _moiAuditLocalService.addMOIAudit(moiAudit1);
		  
		  MOIAudit moiAudit2 =
		  _moiAuditLocalService.createMOIAudit(CounterLocalServiceUtil.
		  increment()); moiAudit2.setActionPerformedBy("F");
		  moiAudit2.setActionPerformedDate(new Date());
		  moiAudit2.setActionStatus("Closed");
		  moiAudit2.setActionDescription("Edited");
		  moiAudit2.setActionConsumer("O");
		  _moiAuditLocalService.addMOIAudit(moiAudit2);
		 
		  
		 
		 System.out.println("Calling from Demo MOI Audit Portlet...");
		 super.doView(renderRequest, renderResponse);
	}
}