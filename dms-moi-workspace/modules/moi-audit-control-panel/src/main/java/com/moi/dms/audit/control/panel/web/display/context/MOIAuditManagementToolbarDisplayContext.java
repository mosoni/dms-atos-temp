package com.moi.dms.audit.control.panel.web.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.BaseManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.moi.dms.audit.control.panel.constants.MOIAuditControlPanelPortletKeys;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

/**
 * MOI Audit management toolbar display context.
 *
 * This class passes contextual information to the user interface
 * for the Clay management toolbar.
 *
 * @author Ganesh Shelke
 */
public class MOIAuditManagementToolbarDisplayContext extends BaseManagementToolbarDisplayContext {

	public MOIAuditManagementToolbarDisplayContext(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse,
			HttpServletRequest httpServletRequest) {
		super(liferayPortletRequest, liferayPortletResponse, httpServletRequest);
		// TODO Auto-generated constructor stub
		_portalPreferences = PortletPreferencesFactoryUtil
				.getPortalPreferences(liferayPortletRequest);

	}

	/**
	 * Returns the creation menu for the toolbar (plus sign on the management
	 * toolbar).
	 *
	 * @return creation menu
	 */
	/*
	 * public CreationMenu getCreationMenu() {
	 * 
	 * return new CreationMenu() { { addDropdownItem(dropdownItem -> {
	 * dropdownItem.setHref( liferayPortletResponse.createRenderURL(),
	 * "mvcRenderCommandName", MVCCommandNames.EDIT_CONSUMER, "redirect",
	 * currentURLObj.toString()); dropdownItem.setLabel(
	 * LanguageUtil.get(request, "add-consumer")); }); } }; }
	 */

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
					MOIAuditControlPanelPortletKeys.MOIAUDITCONTROLPANEL,
					"assignments-display-style", "list");
		} else {
			_portalPreferences.setValue(
					MOIAuditControlPanelPortletKeys.MOIAUDITCONTROLPANEL,
					"assignments-display-style", displayStyle);

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
		return ParamUtil.getString(request, "orderByCol", "auditId");
	}

	/**
	 * Returns the sort type (ascending / descending).
	 * 
	 * @return sort type
	 */
	public String getOrderByType() {
		return ParamUtil.getString(request, "orderByType", "asc");
	}

	/**
	 * Returns the action URL for the search.
	 *
	 * @return search action URL
	 */
	/*
	 * @Override public String getSearchActionURL() {
	 * 
	 * PortletURL searchURL = liferayPortletResponse.createRenderURL();
	 * 
	 * searchURL.setProperty("mvcRenderCommandName",
	 * MVCCommandNames.VIEW_CONSUMERS); String navigation =
	 * ParamUtil.getString(request, "navigation", "entries");
	 * searchURL.setParameter("navigation", navigation);
	 * searchURL.setParameter("orderByCol", getOrderByCol());
	 * searchURL.setParameter("orderByType", getOrderByType());
	 * 
	 * return searchURL.toString(); }
	 */

	private final PortalPreferences _portalPreferences;

}
