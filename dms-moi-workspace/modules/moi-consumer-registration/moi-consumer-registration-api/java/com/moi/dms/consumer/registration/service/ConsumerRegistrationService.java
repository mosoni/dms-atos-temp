/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.moi.dms.consumer.registration.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.moi.dms.consumer.registration.model.ConsumerRegistration;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for ConsumerRegistration. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerRegistrationServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ConsumerRegistrationService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ConsumerRegistrationServiceUtil} to access the consumer registration remote service. Add custom service methods to <code>com.moi.dms.consumer.registration.service.impl.ConsumerRegistrationServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public ConsumerRegistration addConsumerRegistration(
			String consumerName, String consumerId,
			Map<Locale, String> descriptionMap, String supportedDocumentType,
			String consumerStatus, ServiceContext serviceContext)
		throws PortalException;

	public ConsumerRegistration deleteConsumerRegistration(long registrationId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ConsumerRegistration> getAllConsumerRegistrations();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ConsumerRegistration getConsumerRegistration(long registrationId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ConsumerRegistration> getConsumerRegistrationByConsumerId(
		String consumerId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ConsumerRegistration> getConsumerRegistrationByKeywords(
		String keywords, int start, int end,
		OrderByComparator<ConsumerRegistration> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getConsumerRegistrationCountByKeywords(String keywords);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public ConsumerRegistration updateConsumerRegistration(
			long consumerRegistrationId, String consumerName, String consumerId,
			Map<Locale, String> descriptionMap, String supportedDocumentType,
			String consumerStatus, ServiceContext serviceContext)
		throws PortalException;

}