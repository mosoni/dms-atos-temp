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

package com.moi.dms.trace.request.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.moi.dms.trace.request.model.MOITraceRequest;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MOITraceRequest in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MOITraceRequestCacheModel
	implements CacheModel<MOITraceRequest>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MOITraceRequestCacheModel)) {
			return false;
		}

		MOITraceRequestCacheModel moiTraceRequestCacheModel =
			(MOITraceRequestCacheModel)object;

		if (requestId == moiTraceRequestCacheModel.requestId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, requestId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{requestId=");
		sb.append(requestId);
		sb.append(", requestedBy=");
		sb.append(requestedBy);
		sb.append(", requestIncomingDate=");
		sb.append(requestIncomingDate);
		sb.append(", requestedConsumerCode=");
		sb.append(requestedConsumerCode);
		sb.append(", requestedConsumerName=");
		sb.append(requestedConsumerName);
		sb.append(", requestedOperation=");
		sb.append(requestedOperation);
		sb.append(", requestedDocumentType=");
		sb.append(requestedDocumentType);
		sb.append(", requestValid=");
		sb.append(requestValid);
		sb.append(", requestResult=");
		sb.append(requestResult);
		sb.append(", requestResultDate=");
		sb.append(requestResultDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MOITraceRequest toEntityModel() {
		MOITraceRequestImpl moiTraceRequestImpl = new MOITraceRequestImpl();

		moiTraceRequestImpl.setRequestId(requestId);

		if (requestedBy == null) {
			moiTraceRequestImpl.setRequestedBy("");
		}
		else {
			moiTraceRequestImpl.setRequestedBy(requestedBy);
		}

		if (requestIncomingDate == Long.MIN_VALUE) {
			moiTraceRequestImpl.setRequestIncomingDate(null);
		}
		else {
			moiTraceRequestImpl.setRequestIncomingDate(
				new Date(requestIncomingDate));
		}

		if (requestedConsumerCode == null) {
			moiTraceRequestImpl.setRequestedConsumerCode("");
		}
		else {
			moiTraceRequestImpl.setRequestedConsumerCode(requestedConsumerCode);
		}

		if (requestedConsumerName == null) {
			moiTraceRequestImpl.setRequestedConsumerName("");
		}
		else {
			moiTraceRequestImpl.setRequestedConsumerName(requestedConsumerName);
		}

		if (requestedOperation == null) {
			moiTraceRequestImpl.setRequestedOperation("");
		}
		else {
			moiTraceRequestImpl.setRequestedOperation(requestedOperation);
		}

		if (requestedDocumentType == null) {
			moiTraceRequestImpl.setRequestedDocumentType("");
		}
		else {
			moiTraceRequestImpl.setRequestedDocumentType(requestedDocumentType);
		}

		moiTraceRequestImpl.setRequestValid(requestValid);

		if (requestResult == null) {
			moiTraceRequestImpl.setRequestResult("");
		}
		else {
			moiTraceRequestImpl.setRequestResult(requestResult);
		}

		if (requestResultDate == Long.MIN_VALUE) {
			moiTraceRequestImpl.setRequestResultDate(null);
		}
		else {
			moiTraceRequestImpl.setRequestResultDate(
				new Date(requestResultDate));
		}

		moiTraceRequestImpl.resetOriginalValues();

		return moiTraceRequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		requestId = objectInput.readLong();
		requestedBy = objectInput.readUTF();
		requestIncomingDate = objectInput.readLong();
		requestedConsumerCode = objectInput.readUTF();
		requestedConsumerName = objectInput.readUTF();
		requestedOperation = objectInput.readUTF();
		requestedDocumentType = objectInput.readUTF();

		requestValid = objectInput.readBoolean();
		requestResult = objectInput.readUTF();
		requestResultDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(requestId);

		if (requestedBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(requestedBy);
		}

		objectOutput.writeLong(requestIncomingDate);

		if (requestedConsumerCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(requestedConsumerCode);
		}

		if (requestedConsumerName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(requestedConsumerName);
		}

		if (requestedOperation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(requestedOperation);
		}

		if (requestedDocumentType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(requestedDocumentType);
		}

		objectOutput.writeBoolean(requestValid);

		if (requestResult == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(requestResult);
		}

		objectOutput.writeLong(requestResultDate);
	}

	public long requestId;
	public String requestedBy;
	public long requestIncomingDate;
	public String requestedConsumerCode;
	public String requestedConsumerName;
	public String requestedOperation;
	public String requestedDocumentType;
	public boolean requestValid;
	public String requestResult;
	public long requestResultDate;

}