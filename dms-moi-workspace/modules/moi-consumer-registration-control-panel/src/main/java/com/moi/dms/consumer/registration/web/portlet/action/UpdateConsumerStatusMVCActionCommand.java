package com.moi.dms.consumer.registration.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.moi.dms.consumer.registration.model.ConsumerRegistration;
import com.moi.dms.consumer.registration.service.ConsumerRegistrationService;
import com.moi.dms.consumer.registration.web.constants.DMSConsumerRegistrationConstants;
import com.moi.dms.consumer.registration.web.constants.DMSConsumerRegistrationPortletKeys;
import com.moi.dms.consumer.registration.web.constants.MVCCommandNames;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * MVC Action Command for updating consumers status (Active/Inactive).
 * 
 * @author Chintan Bhadra
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + DMSConsumerRegistrationPortletKeys.DMSConsumerRegistration,
		"mvc.command.name=" + MVCCommandNames.UPDATE_CONSUMER_STATUS
	},
	service = MVCActionCommand.class
)
public class UpdateConsumerStatusMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

		ConsumerRegistration consumer = null;
		// Get consumer id from request.
		long registrationId = ParamUtil.getLong(actionRequest,
				DMSConsumerRegistrationConstants.CONSUMER_REGISTRATION_ID);
		String consumerStatus = ParamUtil.getString(actionRequest,
				DMSConsumerRegistrationConstants.CONSUMER_STATUS);

		try {
			// Call service to fetch and update the consumer.
			consumer = _consumerRegistrationService
					.getConsumerRegistration(registrationId);
			_consumerRegistrationService.updateConsumerRegistration(
					registrationId, consumer.getConsumerName(),
					consumer.getConsumerId(),
					consumer.getConsumerDescriptionMap(),
					consumer.getSupportedDocumentType(), consumerStatus);

			if (DMSConsumerRegistrationConstants.CONSUMER_STATUS_ACTIVE
					.equals(consumerStatus)) {
				SessionMessages.add(actionRequest,
						DMSConsumerRegistrationConstants.CONSUMER_ACTIVATED_MESSAGE);
			} else {
				SessionMessages.add(actionRequest,
						DMSConsumerRegistrationConstants.CONSUMER_DEACTIVATED_MESSAGE);
			}
		} catch (PortalException pe) {
			// Set error messages from the service layer.
			SessionErrors.add(actionRequest,
					DMSConsumerRegistrationConstants.SERVICE_ERROR_DETAILS, pe);
		}
	}

	@Reference
	protected ConsumerRegistrationService _consumerRegistrationService;
}
