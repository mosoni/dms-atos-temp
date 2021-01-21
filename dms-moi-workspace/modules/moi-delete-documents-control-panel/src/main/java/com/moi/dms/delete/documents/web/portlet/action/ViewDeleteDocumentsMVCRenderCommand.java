package com.moi.dms.delete.documents.web.portlet.action;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.moi.dms.delete.documents.model.MOIDeleteDocuments;
import com.moi.dms.delete.documents.service.MOIDeleteDocumentsLocalService;
import com.moi.dms.delete.documents.web.constants.MOIDeleteDocumentsConstants;
import com.moi.dms.delete.documents.web.constants.MOIDeleteDocumentsPortletKeys;
import com.moi.dms.delete.documents.web.constants.MVCCommandNames;
import com.moi.dms.delete.documents.web.display.context.DeleteDocumentManagementToolbarDisplayContext;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * MVC command for showing the Delete Documents list.
 * 
 * @author Chintan Bhadra
 */
@Component(
	immediate = true, 
	property = {
		"javax.portlet.name=" + MOIDeleteDocumentsPortletKeys.MOIDELETEDOCUMENTS, 
		"mvc.command.name=/",
		"mvc.command.name=" + MVCCommandNames.VIEW_DOCUMENTS
	}, 
	service = MVCRenderCommand.class
)
public class ViewDeleteDocumentsMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException {

		// Add Document list related attributes.
		addDeleteDocumentListAttributes(renderRequest);

		// Add Clay management toolbar related attributes.
		addManagementToolbarAttributes(renderRequest, renderResponse);

		return MVCCommandNames.VIEW_JSP;
	}

	/**
	 * Adds assigment list related attributes to the request.
	 * 
	 * @param renderRequest
	 */
	private void addDeleteDocumentListAttributes(RenderRequest renderRequest) {

		// Resolve start and end for the search.
		int currentPage = ParamUtil.getInteger(renderRequest,
				SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR);

		int delta = ParamUtil.getInteger(renderRequest,
				SearchContainer.DEFAULT_DELTA_PARAM,
				SearchContainer.DEFAULT_DELTA);

		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = start + delta;

		// Get sorting options.
		// Notice that this doesn't really sort on title because the field is
		// stored in XML. In real world this search would be integrated to the
		// search engine to get localized sort options.

		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol",
				MOIDeleteDocumentsConstants.DOCUMENT_ID);
		String orderByType = ParamUtil.getString(renderRequest, "orderByType",
				"asc");

		// Create comparator
		OrderByComparator<MOIDeleteDocuments> comparator = OrderByComparatorFactoryUtil
				.create("DeleteDocuments", orderByCol,
						!("asc").equals(orderByType));

		// Get keywords.
		// Notice that cleaning keywords is not implemented.
		String keywords = ParamUtil.getString(renderRequest,
				MOIDeleteDocumentsConstants.KEYWORDS);

		// Call the service to get the list of Documents.
		List<MOIDeleteDocuments> documents = _deleteDocumentsService
				.getDeleteDocumentsByKeywords(keywords, start, end, comparator);

		// Set request attributes.
		renderRequest.setAttribute(MOIDeleteDocumentsConstants.DOCUMENTS,
				documents);
		renderRequest.setAttribute(MOIDeleteDocumentsConstants.DOCUMENT_COUNT,
				_deleteDocumentsService
						.getDeleteDocumentsCountByKeywords(keywords));
	}

	/**
	 * Adds Clay management toolbar context object to the request.
	 * 
	 * @param renderRequest
	 * @param renderResponse
	 */
	private void addManagementToolbarAttributes(RenderRequest renderRequest,
			RenderResponse renderResponse) {

		LiferayPortletRequest liferayPortletRequest = _portal
				.getLiferayPortletRequest(renderRequest);

		LiferayPortletResponse liferayPortletResponse = _portal
				.getLiferayPortletResponse(renderResponse);

		DeleteDocumentManagementToolbarDisplayContext delDocMgmtToolbarDispContext = new DeleteDocumentManagementToolbarDisplayContext(
				liferayPortletRequest, liferayPortletResponse,
				_portal.getHttpServletRequest(renderRequest));

		renderRequest.setAttribute(
				MOIDeleteDocumentsConstants.DELETE_DOC_MGMT_TOOLBAR_DISP_CNTXT,
				delDocMgmtToolbarDispContext);

	}

	@Reference
	protected MOIDeleteDocumentsLocalService _deleteDocumentsService;

	@Reference
	private Portal _portal;
}
