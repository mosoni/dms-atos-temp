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

package com.moi.dms.audit.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.moi.dms.audit.model.MOIAudit;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MOIAudit in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MOIAuditCacheModel
	implements CacheModel<MOIAudit>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MOIAuditCacheModel)) {
			return false;
		}

		MOIAuditCacheModel moiAuditCacheModel = (MOIAuditCacheModel)object;

		if (auditId == moiAuditCacheModel.auditId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, auditId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{auditId=");
		sb.append(auditId);
		sb.append(", actionPerformedBy=");
		sb.append(actionPerformedBy);
		sb.append(", actionPerformedDate=");
		sb.append(actionPerformedDate);
		sb.append(", actionStatus=");
		sb.append(actionStatus);
		sb.append(", actionDescription=");
		sb.append(actionDescription);
		sb.append(", actionConsumer=");
		sb.append(actionConsumer);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MOIAudit toEntityModel() {
		MOIAuditImpl moiAuditImpl = new MOIAuditImpl();

		moiAuditImpl.setAuditId(auditId);

		if (actionPerformedBy == null) {
			moiAuditImpl.setActionPerformedBy("");
		}
		else {
			moiAuditImpl.setActionPerformedBy(actionPerformedBy);
		}

		if (actionPerformedDate == Long.MIN_VALUE) {
			moiAuditImpl.setActionPerformedDate(null);
		}
		else {
			moiAuditImpl.setActionPerformedDate(new Date(actionPerformedDate));
		}

		if (actionStatus == null) {
			moiAuditImpl.setActionStatus("");
		}
		else {
			moiAuditImpl.setActionStatus(actionStatus);
		}

		if (actionDescription == null) {
			moiAuditImpl.setActionDescription("");
		}
		else {
			moiAuditImpl.setActionDescription(actionDescription);
		}

		if (actionConsumer == null) {
			moiAuditImpl.setActionConsumer("");
		}
		else {
			moiAuditImpl.setActionConsumer(actionConsumer);
		}

		moiAuditImpl.resetOriginalValues();

		return moiAuditImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		auditId = objectInput.readLong();
		actionPerformedBy = objectInput.readUTF();
		actionPerformedDate = objectInput.readLong();
		actionStatus = objectInput.readUTF();
		actionDescription = objectInput.readUTF();
		actionConsumer = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(auditId);

		if (actionPerformedBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(actionPerformedBy);
		}

		objectOutput.writeLong(actionPerformedDate);

		if (actionStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(actionStatus);
		}

		if (actionDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(actionDescription);
		}

		if (actionConsumer == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(actionConsumer);
		}
	}

	public long auditId;
	public String actionPerformedBy;
	public long actionPerformedDate;
	public String actionStatus;
	public String actionDescription;
	public String actionConsumer;

}