package com.moi.dms.consumer.registration.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
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
 * MVC Command for showing single consumer.
 * 
 * @author Chintan Bhadra
 */
@Component(
	immediate = true, 
	property = {
		"javax.portlet.name=" + DMSConsumerRegistrationPortletKeys.DMSConsumerRegistration, 
		"mvc.command.name=" + MVCCommandNames.VIEW_CONSUMER
	}, 
	service = MVCRenderCommand.class
)
public class ViewSingleConsumerMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		long registrationId = ParamUtil.getLong(renderRequest,
				DMSConsumerRegistrationConstants.CONSUMER_REGISTRATION_ID, 0);

		try {
			// Call the service to get the Consumer details.
			ConsumerRegistration consumer = _consumerRegistrationService
					.getConsumerRegistration(registrationId);

			// Set attributes to the request.
			renderRequest.setAttribute(
					DMSConsumerRegistrationConstants.CONSUMER, consumer);

			// Set back icon visible.
			PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
			String redirect = renderRequest.getParameter("redirect");
			portletDisplay.setShowBackIcon(true);
			portletDisplay.setURLBack(redirect);
			return MVCCommandNames.VIEW_CONSUMER_JSP;
		} catch (PortalException pe) {
			throw new PortletException(pe);
		}
	}

	@Reference
	private ConsumerRegistrationLocalService _consumerRegistrationService;

	@Reference
	private Portal _portal;
}