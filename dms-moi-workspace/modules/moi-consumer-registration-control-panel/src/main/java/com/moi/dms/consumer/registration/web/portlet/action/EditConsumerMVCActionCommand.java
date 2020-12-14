package com.moi.dms.consumer.registration.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.moi.dms.consumer.registration.exception.ConsumerRegistrationValidationException;
import com.moi.dms.consumer.registration.service.ConsumerRegistrationService;
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
 * MVC Action Command for editing Consumers.
 * 
 * @author Chintan Bhadra
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + DMSConsumerRegistrationPortletKeys.DMSConsumerRegistration,
		"mvc.command.name=" + MVCCommandNames.EDIT_CONSUMER
		},
	service = MVCActionCommand.class
)
public class EditConsumerMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

		// Get parameters from the request.
		long consumerRegistrationId = ParamUtil.getLong(actionRequest,
				DMSConsumerRegistrationConstants.CONSUMER_REGISTRATION_ID);
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
			// Call the service to update the consumer
			_consumerRegistrationService.updateConsumerRegistration(
					consumerRegistrationId, consumerName, consumerId,
					descriptionMap, supportedDocumentType, consumerStatus);

			SessionMessages.add(actionRequest,
					DMSConsumerRegistrationConstants.CONSUMER_UPDATED_MESSAGE);
			sendRedirect(actionRequest, actionResponse);
		} catch (ConsumerRegistrationValidationException ave) {

			// Get error messages from the service layer.
			ave.getErrors()
					.forEach(key -> SessionErrors.add(actionRequest, key));
			actionResponse.getRenderParameters().setValue(
					DMSConsumerRegistrationConstants.MVC_RENDER_COMMAND_NAME,
					MVCCommandNames.EDIT_CONSUMER);

		} catch (PortalException pe) {

			SessionErrors.add(actionRequest,
					DMSConsumerRegistrationConstants.SERVICE_ERROR_DETAILS, pe);
			actionResponse.getRenderParameters().setValue(
					DMSConsumerRegistrationConstants.MVC_RENDER_COMMAND_NAME,
					MVCCommandNames.EDIT_CONSUMER);
		}
	}

	@Reference
	protected ConsumerRegistrationService _consumerRegistrationService;
}