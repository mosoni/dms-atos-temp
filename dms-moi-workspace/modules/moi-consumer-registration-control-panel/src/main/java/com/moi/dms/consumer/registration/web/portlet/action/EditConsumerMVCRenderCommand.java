package com.moi.dms.consumer.registration.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.moi.dms.consumer.registration.model.ConsumerRegistration;
import com.moi.dms.consumer.registration.service.ConsumerRegistrationLocalService;
import com.moi.dms.consumer.registration.web.constants.DMSConsumerRegistrationConstants;
import com.moi.dms.consumer.registration.web.constants.DMSConsumerRegistrationPortletKeys;
import com.moi.dms.consumer.registration.web.constants.MVCCommandNames;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * MVC Command for showing edit consumer registration screen.
 * 
 * @author Chintan Bhadra
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + DMSConsumerRegistrationPortletKeys.DMSConsumerRegistration,
		"mvc.command.name=" + MVCCommandNames.EDIT_CONSUMER
	}, 
	service = MVCRenderCommand.class
)
public class EditConsumerMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException {

		ConsumerRegistration consumer = null;
		long registrationId = ParamUtil.getLong(renderRequest,
				DMSConsumerRegistrationConstants.CONSUMER_REGISTRATION_ID, 0);
		if (registrationId > 0) {
			try {
				// Call the service to get the consumer for editing.
				consumer = _consumerRegistrationService
						.getConsumerRegistration(registrationId);
			} catch (PortalException pe) {
				pe.printStackTrace();
			}
		}

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		// Set back icon visible.
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		portletDisplay.setShowBackIcon(true);
		String redirect = renderRequest.getParameter("redirect");
		portletDisplay.setURLBack(redirect);

		// Set consumer to the request attributes.
		renderRequest.setAttribute(DMSConsumerRegistrationConstants.CONSUMER,
				consumer);
		renderRequest.setAttribute(
				DMSConsumerRegistrationConstants.CONSUMER_CLASS,
				ConsumerRegistration.class);

		return MVCCommandNames.EDIT_CONSUMER_JSP;
	}

	@Reference
	private ConsumerRegistrationLocalService _consumerRegistrationService;

}