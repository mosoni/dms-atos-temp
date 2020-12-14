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

package com.moi.dms.consumer.registration.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.moi.dms.consumer.registration.service.http.ConsumerRegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ConsumerRegistrationSoap implements Serializable {

	public static ConsumerRegistrationSoap toSoapModel(
		ConsumerRegistration model) {

		ConsumerRegistrationSoap soapModel = new ConsumerRegistrationSoap();

		soapModel.setRegistrationId(model.getRegistrationId());
		soapModel.setConsumerId(model.getConsumerId());
		soapModel.setConsumerName(model.getConsumerName());
		soapModel.setConsumerDescription(model.getConsumerDescription());
		soapModel.setSupportedDocumentType(model.getSupportedDocumentType());
		soapModel.setConsumerStatus(model.getConsumerStatus());

		return soapModel;
	}

	public static ConsumerRegistrationSoap[] toSoapModels(
		ConsumerRegistration[] models) {

		ConsumerRegistrationSoap[] soapModels =
			new ConsumerRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ConsumerRegistrationSoap[][] toSoapModels(
		ConsumerRegistration[][] models) {

		ConsumerRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ConsumerRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ConsumerRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ConsumerRegistrationSoap[] toSoapModels(
		List<ConsumerRegistration> models) {

		List<ConsumerRegistrationSoap> soapModels =
			new ArrayList<ConsumerRegistrationSoap>(models.size());

		for (ConsumerRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new ConsumerRegistrationSoap[soapModels.size()]);
	}

	public ConsumerRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _registrationId;
	}

	public void setPrimaryKey(long pk) {
		setRegistrationId(pk);
	}

	public long getRegistrationId() {
		return _registrationId;
	}

	public void setRegistrationId(long registrationId) {
		_registrationId = registrationId;
	}

	public String getConsumerId() {
		return _consumerId;
	}

	public void setConsumerId(String consumerId) {
		_consumerId = consumerId;
	}

	public String getConsumerName() {
		return _consumerName;
	}

	public void setConsumerName(String consumerName) {
		_consumerName = consumerName;
	}

	public String getConsumerDescription() {
		return _consumerDescription;
	}

	public void setConsumerDescription(String consumerDescription) {
		_consumerDescription = consumerDescription;
	}

	public String getSupportedDocumentType() {
		return _supportedDocumentType;
	}

	public void setSupportedDocumentType(String supportedDocumentType) {
		_supportedDocumentType = supportedDocumentType;
	}

	public String getConsumerStatus() {
		return _consumerStatus;
	}

	public void setConsumerStatus(String consumerStatus) {
		_consumerStatus = consumerStatus;
	}

	private long _registrationId;
	private String _consumerId;
	private String _consumerName;
	private String _consumerDescription;
	private String _supportedDocumentType;
	private String _consumerStatus;

}