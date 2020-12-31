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

package com.moi.dms.consumer.registration.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;

import com.moi.dms.consumer.registration.service.ConsumerRegistrationServiceUtil;

import java.rmi.RemoteException;

import java.util.Locale;
import java.util.Map;

/**
 * Provides the SOAP utility for the
 * <code>ConsumerRegistrationServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.moi.dms.consumer.registration.model.ConsumerRegistrationSoap</code>. If the method in the
 * service utility returns a
 * <code>com.moi.dms.consumer.registration.model.ConsumerRegistration</code>, that is translated to a
 * <code>com.moi.dms.consumer.registration.model.ConsumerRegistrationSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerRegistrationServiceHttp
 * @generated
 */
public class ConsumerRegistrationServiceSoap {

	/**
	 * Remote service to add new consumer registration.
	 *
	 * @param consumerName
	 * @param consumerId
	 * @param descriptionMap
	 * @param supportedDocumentType
	 * @param consumerStatus
	 * @return ConsumerRegistration
	 * @throws PortalException
	 */
	public static
		com.moi.dms.consumer.registration.model.ConsumerRegistrationSoap
				addConsumerRegistration(
					String consumerName, String consumerId,
					String[] descriptionMapLanguageIds,
					String[] descriptionMapValues, String supportedDocumentType,
					String consumerStatus)
			throws RemoteException {

		try {
			Map<Locale, String> descriptionMap =
				LocalizationUtil.getLocalizationMap(
					descriptionMapLanguageIds, descriptionMapValues);

			com.moi.dms.consumer.registration.model.ConsumerRegistration
				returnValue =
					ConsumerRegistrationServiceUtil.addConsumerRegistration(
						consumerName, consumerId, descriptionMap,
						supportedDocumentType, consumerStatus);

			return com.moi.dms.consumer.registration.model.
				ConsumerRegistrationSoap.toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Remote service to update consumer registration.
	 *
	 * @param consumerRegistrationId
	 * @param consumerName
	 * @param consumerId
	 * @param descriptionMap
	 * @param supportedDocumentType
	 * @param consumerStatus
	 * @return ConsumerRegistration
	 * @throws PortalException
	 */
	public static
		com.moi.dms.consumer.registration.model.ConsumerRegistrationSoap
				updateConsumerRegistration(
					long consumerRegistrationId, String consumerName,
					String consumerId, String[] descriptionMapLanguageIds,
					String[] descriptionMapValues, String supportedDocumentType,
					String consumerStatus)
			throws RemoteException {

		try {
			Map<Locale, String> descriptionMap =
				LocalizationUtil.getLocalizationMap(
					descriptionMapLanguageIds, descriptionMapValues);

			com.moi.dms.consumer.registration.model.ConsumerRegistration
				returnValue =
					ConsumerRegistrationServiceUtil.updateConsumerRegistration(
						consumerRegistrationId, consumerName, consumerId,
						descriptionMap, supportedDocumentType, consumerStatus);

			return com.moi.dms.consumer.registration.model.
				ConsumerRegistrationSoap.toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Delete the consumer registration with the primary key.
	 *
	 * @param registrationId the primary key of the consumer registration
	 * @return the consumer registration
	 * @throws PortalException if a consumer registration with the primary key could not be found
	 */
	public static
		com.moi.dms.consumer.registration.model.ConsumerRegistrationSoap
				deleteConsumerRegistration(long registrationId)
			throws RemoteException {

		try {
			com.moi.dms.consumer.registration.model.ConsumerRegistration
				returnValue =
					ConsumerRegistrationServiceUtil.deleteConsumerRegistration(
						registrationId);

			return com.moi.dms.consumer.registration.model.
				ConsumerRegistrationSoap.toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Returns the consumer registration with the primary key.
	 *
	 * @param registrationId the primary key of the consumer registration
	 * @return the consumer registration
	 * @throws PortalException if a consumer registration with the primary key could not be found
	 */
	public static
		com.moi.dms.consumer.registration.model.ConsumerRegistrationSoap
				getConsumerRegistration(long registrationId)
			throws RemoteException {

		try {
			com.moi.dms.consumer.registration.model.ConsumerRegistration
				returnValue =
					ConsumerRegistrationServiceUtil.getConsumerRegistration(
						registrationId);

			return com.moi.dms.consumer.registration.model.
				ConsumerRegistrationSoap.toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Returns the consumer registration with the Consumer Id.
	 *
	 * @param consumerId
	 * @return the consumer registration
	 * @throws PortalException
	 */
	public static
		com.moi.dms.consumer.registration.model.ConsumerRegistrationSoap[]
				getConsumerRegistrationByConsumerId(String consumerId)
			throws RemoteException {

		try {
			java.util.List
				<com.moi.dms.consumer.registration.model.ConsumerRegistration>
					returnValue =
						ConsumerRegistrationServiceUtil.
							getConsumerRegistrationByConsumerId(consumerId);

			return com.moi.dms.consumer.registration.model.
				ConsumerRegistrationSoap.toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Returns all the consumer registrations
	 *
	 * @param consumerId
	 * @return the consumer registration
	 * @throws PortalException
	 */
	public static
		com.moi.dms.consumer.registration.model.ConsumerRegistrationSoap[]
				getAllConsumerRegistrations()
			throws RemoteException {

		try {
			java.util.List
				<com.moi.dms.consumer.registration.model.ConsumerRegistration>
					returnValue =
						ConsumerRegistrationServiceUtil.
							getAllConsumerRegistrations();

			return com.moi.dms.consumer.registration.model.
				ConsumerRegistrationSoap.toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Returns the consumer registrations with keywords.
	 *
	 * @param keywords
	 * @param start
	 * @param end
	 * @param orderByComparator
	 * @return List<ConsumerRegistration>
	 */
	public static
		com.moi.dms.consumer.registration.model.ConsumerRegistrationSoap[]
				getConsumerRegistrationByKeywords(
					String keywords, int start, int end,
					com.liferay.portal.kernel.util.OrderByComparator
						<com.moi.dms.consumer.registration.model.
							ConsumerRegistration> orderByComparator)
			throws RemoteException {

		try {
			java.util.List
				<com.moi.dms.consumer.registration.model.ConsumerRegistration>
					returnValue =
						ConsumerRegistrationServiceUtil.
							getConsumerRegistrationByKeywords(
								keywords, start, end, orderByComparator);

			return com.moi.dms.consumer.registration.model.
				ConsumerRegistrationSoap.toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Returns the consumer registrations count with keywords.
	 *
	 * @param keywords
	 * @return long
	 */
	public static long getConsumerRegistrationCountByKeywords(String keywords)
		throws RemoteException {

		try {
			long returnValue =
				ConsumerRegistrationServiceUtil.
					getConsumerRegistrationCountByKeywords(keywords);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		ConsumerRegistrationServiceSoap.class);

}