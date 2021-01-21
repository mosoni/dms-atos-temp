package com.moi.dms.delete.documents.web.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.BaseManagementToolbarDisplayContext;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.moi.dms.delete.documents.web.constants.MOIDeleteDocumentsPortletKeys;
import com.moi.dms.delete.documents.web.constants.MVCCommandNames;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

/**
 * Delete Document management toolbar display context.
 *
 * This class passes contextual information to the user interface for the Clay
 * management toolbar.
 *
 * @author Chintan Bhadra
 */
public class DeleteDocumentManagementToolbarDisplayContext
		extends BaseManagementToolbarDisplayContext {

	public DeleteDocumentManagementToolbarDisplayContext(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse,
			HttpServletRequest httpServletRequest) {

		super(liferayPortletRequest, liferayPortletResponse,
				httpServletRequest);

		_portalPreferences = PortletPreferencesFactoryUtil
				.getPortalPreferences(liferayPortletRequest);

	}

	@Override
	public String getClearResultsURL() {
		return getSearchActionURL();
	}

	/**
	 * Returns the Consumer list display style.
	 * 
	 * Current selection is stored in portal preferences.
	 * 
	 * @return current display style
	 */
	public String getDisplayStyle() {

		String displayStyle = ParamUtil.getString(request, "displayStyle");
		if (Validator.isNull(displayStyle)) {
			displayStyle = _portalPreferences.getValue(
					MOIDeleteDocumentsPortletKeys.MOIDELETEDOCUMENTS,
					"delete-doc-display-style", "list");
		} else {
			_portalPreferences.setValue(
					MOIDeleteDocumentsPortletKeys.MOIDELETEDOCUMENTS,
					"delete-doc-display-style", displayStyle);

			request.setAttribute(WebKeys.SINGLE_PAGE_APPLICATION_CLEAR_CACHE,
					Boolean.TRUE);
		}

		return displayStyle;
	}

	/**
	 * Returns the sort order column.
	 * 
	 * @return sort column
	 */
	public String getOrderByCol() {
		return ParamUtil.getString(request, "orderByCol", "documentId");
	}

	/**
	 * Returns the sort type (ascending / descending).
	 * 
	 * @return sort type
	 */
	public String getOrderByType() {
		return ParamUtil.getString(request, "orderByType", "desc");
	}

	/**
	 * Returns the action URL for the search.
	 *
	 * @return search action URL
	 */
	@Override
	public String getSearchActionURL() {

		PortletURL searchURL = liferayPortletResponse.createRenderURL();

		searchURL.setProperty("mvcRenderCommandName",
				MVCCommandNames.VIEW_DOCUMENTS);
		String navigation = ParamUtil.getString(request, "navigation",
				"entries");
		searchURL.getRenderParameters().setValue("navigation", navigation);
		searchURL.getRenderParameters().setValue("orderByCol", getOrderByCol());
		searchURL.getRenderParameters().setValue("orderByType",
				getOrderByType());
		// searchURL.setParameter("navigation", navigation);
		// searchURL.setParameter("orderByCol", getOrderByCol());
		// searchURL.setParameter("orderByType", getOrderByType());

		return searchURL.toString();
	}

	private final PortalPreferences _portalPreferences;
}
