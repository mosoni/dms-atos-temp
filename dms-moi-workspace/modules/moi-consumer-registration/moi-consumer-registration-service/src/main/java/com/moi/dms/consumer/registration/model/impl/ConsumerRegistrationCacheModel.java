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

package com.moi.dms.consumer.registration.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.moi.dms.consumer.registration.model.ConsumerRegistration;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ConsumerRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ConsumerRegistrationCacheModel
	implements CacheModel<ConsumerRegistration>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ConsumerRegistrationCacheModel)) {
			return false;
		}

		ConsumerRegistrationCacheModel consumerRegistrationCacheModel =
			(ConsumerRegistrationCacheModel)object;

		if (registrationId == consumerRegistrationCacheModel.registrationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, registrationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{registrationId=");
		sb.append(registrationId);
		sb.append(", consumerId=");
		sb.append(consumerId);
		sb.append(", consumerName=");
		sb.append(consumerName);
		sb.append(", consumerDescription=");
		sb.append(consumerDescription);
		sb.append(", supportedDocumentType=");
		sb.append(supportedDocumentType);
		sb.append(", consumerStatus=");
		sb.append(consumerStatus);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ConsumerRegistration toEntityModel() {
		ConsumerRegistrationImpl consumerRegistrationImpl =
			new ConsumerRegistrationImpl();

		consumerRegistrationImpl.setRegistrationId(registrationId);

		if (consumerId == null) {
			consumerRegistrationImpl.setConsumerId("");
		}
		else {
			consumerRegistrationImpl.setConsumerId(consumerId);
		}

		if (consumerName == null) {
			consumerRegistrationImpl.setConsumerName("");
		}
		else {
			consumerRegistrationImpl.setConsumerName(consumerName);
		}

		if (consumerDescription == null) {
			consumerRegistrationImpl.setConsumerDescription("");
		}
		else {
			consumerRegistrationImpl.setConsumerDescription(
				consumerDescription);
		}

		if (supportedDocumentType == null) {
			consumerRegistrationImpl.setSupportedDocumentType("");
		}
		else {
			consumerRegistrationImpl.setSupportedDocumentType(
				supportedDocumentType);
		}

		if (consumerStatus == null) {
			consumerRegistrationImpl.setConsumerStatus("");
		}
		else {
			consumerRegistrationImpl.setConsumerStatus(consumerStatus);
		}

		consumerRegistrationImpl.resetOriginalValues();

		return consumerRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		registrationId = objectInput.readLong();
		consumerId = objectInput.readUTF();
		consumerName = objectInput.readUTF();
		consumerDescription = objectInput.readUTF();
		supportedDocumentType = objectInput.readUTF();
		consumerStatus = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(registrationId);

		if (consumerId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(consumerId);
		}

		if (consumerName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(consumerName);
		}

		if (consumerDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(consumerDescription);
		}

		if (supportedDocumentType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(supportedDocumentType);
		}

		if (consumerStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(consumerStatus);
		}
	}

	public long registrationId;
	public String consumerId;
	public String consumerName;
	public String consumerDescription;
	public String supportedDocumentType;
	public String consumerStatus;

}