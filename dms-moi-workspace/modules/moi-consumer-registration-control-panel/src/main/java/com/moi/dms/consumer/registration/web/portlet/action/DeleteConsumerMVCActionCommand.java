package com.moi.dms.consumer.registration.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.moi.dms.consumer.registration.service.ConsumerRegistrationLocalService;
import com.moi.dms.consumer.registration.web.constants.DMSConsumerRegistrationConstants;
import com.moi.dms.consumer.registration.web.constants.DMSConsumerRegistrationPortletKeys;
import com.moi.dms.consumer.registration.web.constants.MVCCommandNames;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * MVC Action Command for deleting consumers.
 * 
 * @author Chintan Bhadra
 */
@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + DMSConsumerRegistrationPortletKeys.DMSConsumerRegistration,
        "mvc.command.name=" + MVCCommandNames.DELETE_CONSUMER
    },
    service = MVCActionCommand.class
)
public class DeleteConsumerMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

		// Get consumer id from request.
		long registrationId = ParamUtil.getLong(actionRequest,
				DMSConsumerRegistrationConstants.CONSUMER_REGISTRATION_ID);

		try {
			// Call service to delete the consumer.
			_consumerRegistrationService
					.deleteConsumerRegistration(registrationId);
			SessionMessages.add(actionRequest,
					DMSConsumerRegistrationConstants.CONSUMER_DELETED_MESSAGE);
		} catch (PortalException pe) {
			// Set error messages from the service layer.
			SessionErrors.add(actionRequest,
					DMSConsumerRegistrationConstants.SERVICE_ERROR_DETAILS, pe);
		}
	}

	@Reference
	protected ConsumerRegistrationLocalService _consumerRegistrationService;
}
