package com.moi.dms.consumer.registration.web.portlet.action;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.moi.dms.consumer.registration.model.ConsumerRegistration;
import com.moi.dms.consumer.registration.service.ConsumerRegistrationService;
import com.moi.dms.consumer.registration.web.constants.DMSConsumerRegistrationConstants;
import com.moi.dms.consumer.registration.web.constants.DMSConsumerRegistrationPortletKeys;
import com.moi.dms.consumer.registration.web.constants.MVCCommandNames;
import com.moi.dms.consumer.registration.web.display.context.ConsumersManagementToolbarDisplayContext;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * MVC command for showing the consumer list.
 * 
 * @author Chintan Bhadra
 */
@Component(
	immediate = true, 
	property = {
		"javax.portlet.name=" + DMSConsumerRegistrationPortletKeys.DMSConsumerRegistration, 
		"mvc.command.name=/",
		"mvc.command.name=" + MVCCommandNames.VIEW_CONSUMERS
	}, 
	service = MVCRenderCommand.class
)
public class ViewConsumerMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException {

		// Add consumer list related attributes.
		addConsumerListAttributes(renderRequest);

		// Add Clay management toolbar related attributes.
		addManagementToolbarAttributes(renderRequest, renderResponse);

		return MVCCommandNames.VIEW_JSP;
	}

	/**
	 * Adds assigment list related attributes to the request.
	 * 
	 * @param renderRequest
	 */
	private void addConsumerListAttributes(RenderRequest renderRequest) {

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
				"consumerId");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType",
				"asc");

		// Create comparator
		OrderByComparator<ConsumerRegistration> comparator = OrderByComparatorFactoryUtil
				.create("ConsumerRegistration", orderByCol,
						!("asc").equals(orderByType));

		// Get keywords.
		// Notice that cleaning keywords is not implemented.
		String keywords = ParamUtil.getString(renderRequest, "keywords");

		// Call the service to get the list of Consumers.
		List<ConsumerRegistration> consumers = _consumerRegistrationService
				.getConsumerRegistrationByKeywords(keywords, start, end,
						comparator);

		// Set request attributes.
		renderRequest.setAttribute(DMSConsumerRegistrationConstants.CONSUMERS,
				consumers);
		renderRequest.setAttribute(
				DMSConsumerRegistrationConstants.CONSUMER_COUNT,
				_consumerRegistrationService
						.getConsumerRegistrationCountByKeywords(keywords));
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

		ConsumersManagementToolbarDisplayContext consumersManagementToolbarDisplayContext = new ConsumersManagementToolbarDisplayContext(
				liferayPortletRequest, liferayPortletResponse,
				_portal.getHttpServletRequest(renderRequest));

		renderRequest.setAttribute(
				DMSConsumerRegistrationConstants.CONSUMER_MGMT_TOOLBAR_DISP_CNTXT,
				consumersManagementToolbarDisplayContext);

	}

	@Reference
	protected ConsumerRegistrationService _consumerRegistrationService;

	@Reference
	private Portal _portal;
}
