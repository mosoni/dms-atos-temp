package com.moi.dms.delete.documents.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.moi.dms.delete.documents.model.MOIDeleteDocuments;
import com.moi.dms.delete.documents.service.MOIDeleteDocumentsLocalService;
import com.moi.dms.delete.documents.web.constants.MOIDeleteDocumentsConstants;
import com.moi.dms.delete.documents.web.constants.MOIDeleteDocumentsPortletKeys;
import com.moi.dms.delete.documents.web.constants.MVCCommandNames;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * MVC Action Command for updating delete document status to Approved/Rejected.
 * 
 * @author Chintan Bhadra
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + MOIDeleteDocumentsPortletKeys.MOIDELETEDOCUMENTS,
		"mvc.command.name=" + MVCCommandNames.UPDATE_DOCUMENT_STATUS
		},
	service = MVCActionCommand.class
)
public class UpdateDeleteDocumentsStatusMVCActionCommand
		extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

		System.out.println("Here");
		// Get parameters from the request.
		long documentId = ParamUtil.getLong(actionRequest,
				MOIDeleteDocumentsConstants.DOCUMENT_ID);
		String comments = ParamUtil.getString(actionRequest,
				MOIDeleteDocumentsConstants.COMMENTS);
		String status = ParamUtil.getString(actionRequest,
				MOIDeleteDocumentsConstants.DOCUMENT_STATUS);
		System.out.println(documentId);
		System.out.println(comments);
		System.out.println(status);
		System.out.println(ParamUtil.getString(actionRequest,
				MOIDeleteDocumentsConstants.DOCUMENT_ID));

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		User user = _userService.getUser(themeDisplay.getUserId());

		try {
			// Call the service to update the consumer
			MOIDeleteDocuments moiDeleteDocuments = _deleteDocumentsService
					.getMOIDeleteDocuments(documentId);
			if (null != moiDeleteDocuments) {
				moiDeleteDocuments.setComments(comments);
				moiDeleteDocuments.setStatus(status);
				moiDeleteDocuments.setUpdatedBy(user.getScreenName());
				moiDeleteDocuments.setUpdatedDate(new Date());
				_deleteDocumentsService
						.updateMOIDeleteDocuments(moiDeleteDocuments);
			}

		} catch (PortalException pe) {
			pe.printStackTrace();
			SessionErrors.add(actionRequest,
					MOIDeleteDocumentsConstants.SERVICE_ERROR_DETAILS, pe);
			actionResponse.getRenderParameters().setValue(
					MOIDeleteDocumentsConstants.MVC_RENDER_COMMAND_NAME,
					MVCCommandNames.VIEW_DOCUMENTS);
		}

		SessionMessages.add(actionRequest,
				MOIDeleteDocumentsConstants.DOCUMENT_UPDATED_MESSAGE);
	}

	@Reference
	protected MOIDeleteDocumentsLocalService _deleteDocumentsService;
	
	@Reference
	protected UserLocalService _userService;
}