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

package com.moi.dms.id.mapper.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.moi.dms.id.mapper.model.MOIIdMapper;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MOIIdMapper in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MOIIdMapperCacheModel
	implements CacheModel<MOIIdMapper>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MOIIdMapperCacheModel)) {
			return false;
		}

		MOIIdMapperCacheModel moiIdMapperCacheModel =
			(MOIIdMapperCacheModel)object;

		if (mapperId == moiIdMapperCacheModel.mapperId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, mapperId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{mapperId=");
		sb.append(mapperId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", mosipCurrentState=");
		sb.append(mosipCurrentState);
		sb.append(", mosipDocumentType=");
		sb.append(mosipDocumentType);
		sb.append(", registrationId=");
		sb.append(registrationId);
		sb.append(", resourceId=");
		sb.append(resourceId);
		sb.append(", documentTitle=");
		sb.append(documentTitle);
		sb.append(", activeState=");
		sb.append(activeState);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append(", updateDate=");
		sb.append(updateDate);
		sb.append(", updatedBy=");
		sb.append(updatedBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MOIIdMapper toEntityModel() {
		MOIIdMapperImpl moiIdMapperImpl = new MOIIdMapperImpl();

		moiIdMapperImpl.setMapperId(mapperId);
		moiIdMapperImpl.setGroupId(groupId);
		moiIdMapperImpl.setCompanyId(companyId);

		if (mosipCurrentState == null) {
			moiIdMapperImpl.setMosipCurrentState("");
		}
		else {
			moiIdMapperImpl.setMosipCurrentState(mosipCurrentState);
		}

		if (mosipDocumentType == null) {
			moiIdMapperImpl.setMosipDocumentType("");
		}
		else {
			moiIdMapperImpl.setMosipDocumentType(mosipDocumentType);
		}

		if (registrationId == null) {
			moiIdMapperImpl.setRegistrationId("");
		}
		else {
			moiIdMapperImpl.setRegistrationId(registrationId);
		}

		moiIdMapperImpl.setResourceId(resourceId);

		if (documentTitle == null) {
			moiIdMapperImpl.setDocumentTitle("");
		}
		else {
			moiIdMapperImpl.setDocumentTitle(documentTitle);
		}

		moiIdMapperImpl.setActiveState(activeState);

		if (fileEntryId == null) {
			moiIdMapperImpl.setFileEntryId("");
		}
		else {
			moiIdMapperImpl.setFileEntryId(fileEntryId);
		}

		if (updateDate == Long.MIN_VALUE) {
			moiIdMapperImpl.setUpdateDate(null);
		}
		else {
			moiIdMapperImpl.setUpdateDate(new Date(updateDate));
		}

		if (updatedBy == null) {
			moiIdMapperImpl.setUpdatedBy("");
		}
		else {
			moiIdMapperImpl.setUpdatedBy(updatedBy);
		}

		moiIdMapperImpl.resetOriginalValues();

		return moiIdMapperImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mapperId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		mosipCurrentState = objectInput.readUTF();
		mosipDocumentType = objectInput.readUTF();
		registrationId = objectInput.readUTF();

		resourceId = objectInput.readLong();
		documentTitle = objectInput.readUTF();

		activeState = objectInput.readInt();
		fileEntryId = objectInput.readUTF();
		updateDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mapperId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		if (mosipCurrentState == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mosipCurrentState);
		}

		if (mosipDocumentType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mosipDocumentType);
		}

		if (registrationId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(registrationId);
		}

		objectOutput.writeLong(resourceId);

		if (documentTitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(documentTitle);
		}

		objectOutput.writeInt(activeState);

		if (fileEntryId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fileEntryId);
		}

		objectOutput.writeLong(updateDate);

		if (updatedBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(updatedBy);
		}
	}

	public long mapperId;
	public long groupId;
	public long companyId;
	public String mosipCurrentState;
	public String mosipDocumentType;
	public String registrationId;
	public long resourceId;
	public String documentTitle;
	public int activeState;
	public String fileEntryId;
	public long updateDate;
	public String updatedBy;

}