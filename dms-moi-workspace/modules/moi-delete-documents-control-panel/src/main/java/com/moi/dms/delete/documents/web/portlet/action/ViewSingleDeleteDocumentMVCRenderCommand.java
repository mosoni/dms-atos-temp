package com.moi.dms.delete.documents.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.moi.dms.delete.documents.model.MOIDeleteDocuments;
import com.moi.dms.delete.documents.service.MOIDeleteDocumentsLocalService;
import com.moi.dms.delete.documents.web.constants.MOIDeleteDocumentsConstants;
import com.moi.dms.delete.documents.web.constants.MOIDeleteDocumentsPortletKeys;
import com.moi.dms.delete.documents.web.constants.MVCCommandNames;
import com.moi.dms.delete.documents.web.util.MOIDeleteDocumentsUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * MVC Command for showing single delete document entry.
 * 
 * @author Chintan Bhadra
 */
@Component(
	immediate = true, 
	property = {
		"javax.portlet.name=" + MOIDeleteDocumentsPortletKeys.MOIDELETEDOCUMENTS,
		"mvc.command.name=" + MVCCommandNames.VIEW_DOCUMENT
	}, 
	service = MVCRenderCommand.class
)
public class ViewSingleDeleteDocumentMVCRenderCommand
		implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		long documentId = ParamUtil.getLong(renderRequest,
				MOIDeleteDocumentsConstants.DOCUMENT_ID, 0);

		try {
			// Call the service to get the Consumer details.
			MOIDeleteDocuments document = _documentRegistrationService
					.getMOIDeleteDocuments(documentId);

			// Set attributes to the request.
			renderRequest.setAttribute(MOIDeleteDocumentsConstants.DOCUMENT,
					document);

			System.out.println(
					"Identifiers: " + document.getPendingIdentifiers());
			// Set back icon visible.
			PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
			String redirect = renderRequest.getRenderParameters()
					.getValue("redirect");
			portletDisplay.setShowBackIcon(true);
			portletDisplay.setURLBack(redirect);

			if (MOIDeleteDocumentsConstants.OPERATION_UPDATE
					.equals(ParamUtil.getString(renderRequest,
							MOIDeleteDocumentsConstants.OPERATION))) {

				String downloadURL = MOIDeleteDocumentsUtil.getDownloadURL(
						document.getFileEntryId(), themeDisplay, "");
				renderRequest.setAttribute(
						MOIDeleteDocumentsConstants.DOWNLOAD_URL, downloadURL);

				return MVCCommandNames.UPDATE_DOCUMENT_STATUS_JSP;
			} else {
				return MVCCommandNames.VIEW_DOCUMENT_JSP;
			}
		} catch (PortalException pe) {
			throw new PortletException(pe);
		}
	}

	@Reference
	private MOIDeleteDocumentsLocalService _documentRegistrationService;

	@Reference
	private Portal _portal;
}