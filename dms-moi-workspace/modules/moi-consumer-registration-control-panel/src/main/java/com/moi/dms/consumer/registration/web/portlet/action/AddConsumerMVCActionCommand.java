package com.moi.dms.consumer.registration.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.moi.dms.consumer.registration.exception.ConsumerRegistrationValidationException;
import com.moi.dms.consumer.registration.service.ConsumerRegistrationLocalService;
import com.moi.dms.consumer.registration.web.constants.DMSConsumerRegistrationConstants;
import com.moi.dms.consumer.registration.web.constants.DMSConsumerRegistrationPortletKeys;
import com.moi.dms.consumer.registration.web.constants.MVCCommandNames;

import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * MVC Action Command for adding consumers.
 * 
 * @author Chintan Bhadra
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + DMSConsumerRegistrationPortletKeys.DMSConsumerRegistration,
		"mvc.command.name=" + MVCCommandNames.ADD_CONSUMER
	},
	service = MVCActionCommand.class
)
public class AddConsumerMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

		// Get parameters from the request.
		// Use LocalizationUtil to get a localized parameter.

		String consumerName = ParamUtil.getString(actionRequest,
				DMSConsumerRegistrationConstants.CONSUMER_NAME);
		String consumerId = ParamUtil.getString(actionRequest,
				DMSConsumerRegistrationConstants.CONSUMER_ID);
		Map<Locale, String> descriptionMap = LocalizationUtil
				.getLocalizationMap(actionRequest,
						DMSConsumerRegistrationConstants.CONSUMER_DESCRIPTION);
		String supportedDocumentType = ParamUtil.getString(actionRequest,
				DMSConsumerRegistrationConstants.SUPPORTED_DOCUMENT_TYPE);
		String consumerStatus = ParamUtil.getString(actionRequest,
				DMSConsumerRegistrationConstants.CONSUMER_STATUS);

		try {
			// Call the service to add a a new consumerignment.
			_consumerRegistrationService.addConsumerRegistration(consumerName,
					consumerId, descriptionMap, supportedDocumentType,
					consumerStatus);

			SessionMessages.add(actionRequest,
					DMSConsumerRegistrationConstants.CONSUMER_ADDED_MESSAGE);
			sendRedirect(actionRequest, actionResponse);
		} catch (ConsumerRegistrationValidationException ave) {

			// Get error messages from the service layer.
			ave.getErrors()
					.forEach(key -> SessionErrors.add(actionRequest, key));
			actionResponse.getRenderParameters().setValue(
					DMSConsumerRegistrationConstants.MVC_RENDER_COMMAND_NAME,
					MVCCommandNames.EDIT_CONSUMER);

		} catch (PortalException pe) {
			// Set error messages from the service layer.
			SessionErrors.add(actionRequest,
					DMSConsumerRegistrationConstants.SERVICE_ERROR_DETAILS, pe);
			actionResponse.getRenderParameters().setValue(
					DMSConsumerRegistrationConstants.MVC_RENDER_COMMAND_NAME,
					MVCCommandNames.EDIT_CONSUMER);
		}
	}

	@Reference
	protected ConsumerRegistrationLocalService _consumerRegistrationService;

}