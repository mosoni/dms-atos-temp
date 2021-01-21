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

package com.moi.dms.delete.documents.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.moi.dms.delete.documents.model.MOIDeleteDocuments;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MOIDeleteDocuments in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MOIDeleteDocumentsCacheModel
	implements CacheModel<MOIDeleteDocuments>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MOIDeleteDocumentsCacheModel)) {
			return false;
		}

		MOIDeleteDocumentsCacheModel moiDeleteDocumentsCacheModel =
			(MOIDeleteDocumentsCacheModel)object;

		if (documentId == moiDeleteDocumentsCacheModel.documentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, documentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{documentId=");
		sb.append(documentId);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append(", fileEntryName=");
		sb.append(fileEntryName);
		sb.append(", consumerCode=");
		sb.append(consumerCode);
		sb.append(", moduleType=");
		sb.append(moduleType);
		sb.append(", uploadedBy=");
		sb.append(uploadedBy);
		sb.append(", uploadedDate=");
		sb.append(uploadedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", comments=");
		sb.append(comments);
		sb.append(", updatedBy=");
		sb.append(updatedBy);
		sb.append(", updatedDate=");
		sb.append(updatedDate);
		sb.append(", pendingIdentifiers=");
		sb.append(pendingIdentifiers);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MOIDeleteDocuments toEntityModel() {
		MOIDeleteDocumentsImpl moiDeleteDocumentsImpl =
			new MOIDeleteDocumentsImpl();

		moiDeleteDocumentsImpl.setDocumentId(documentId);
		moiDeleteDocumentsImpl.setFileEntryId(fileEntryId);

		if (fileEntryName == null) {
			moiDeleteDocumentsImpl.setFileEntryName("");
		}
		else {
			moiDeleteDocumentsImpl.setFileEntryName(fileEntryName);
		}

		if (consumerCode == null) {
			moiDeleteDocumentsImpl.setConsumerCode("");
		}
		else {
			moiDeleteDocumentsImpl.setConsumerCode(consumerCode);
		}

		if (moduleType == null) {
			moiDeleteDocumentsImpl.setModuleType("");
		}
		else {
			moiDeleteDocumentsImpl.setModuleType(moduleType);
		}

		if (uploadedBy == null) {
			moiDeleteDocumentsImpl.setUploadedBy("");
		}
		else {
			moiDeleteDocumentsImpl.setUploadedBy(uploadedBy);
		}

		if (uploadedDate == Long.MIN_VALUE) {
			moiDeleteDocumentsImpl.setUploadedDate(null);
		}
		else {
			moiDeleteDocumentsImpl.setUploadedDate(new Date(uploadedDate));
		}

		if (status == null) {
			moiDeleteDocumentsImpl.setStatus("");
		}
		else {
			moiDeleteDocumentsImpl.setStatus(status);
		}

		if (comments == null) {
			moiDeleteDocumentsImpl.setComments("");
		}
		else {
			moiDeleteDocumentsImpl.setComments(comments);
		}

		if (updatedBy == null) {
			moiDeleteDocumentsImpl.setUpdatedBy("");
		}
		else {
			moiDeleteDocumentsImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			moiDeleteDocumentsImpl.setUpdatedDate(null);
		}
		else {
			moiDeleteDocumentsImpl.setUpdatedDate(new Date(updatedDate));
		}

		if (pendingIdentifiers == null) {
			moiDeleteDocumentsImpl.setPendingIdentifiers("");
		}
		else {
			moiDeleteDocumentsImpl.setPendingIdentifiers(pendingIdentifiers);
		}

		moiDeleteDocumentsImpl.resetOriginalValues();

		return moiDeleteDocumentsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		documentId = objectInput.readLong();

		fileEntryId = objectInput.readLong();
		fileEntryName = objectInput.readUTF();
		consumerCode = objectInput.readUTF();
		moduleType = objectInput.readUTF();
		uploadedBy = objectInput.readUTF();
		uploadedDate = objectInput.readLong();
		status = objectInput.readUTF();
		comments = objectInput.readUTF();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
		pendingIdentifiers = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(documentId);

		objectOutput.writeLong(fileEntryId);

		if (fileEntryName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fileEntryName);
		}

		if (consumerCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(consumerCode);
		}

		if (moduleType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(moduleType);
		}

		if (uploadedBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uploadedBy);
		}

		objectOutput.writeLong(uploadedDate);

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (comments == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(comments);
		}

		if (updatedBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(updatedBy);
		}

		objectOutput.writeLong(updatedDate);

		if (pendingIdentifiers == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pendingIdentifiers);
		}
	}

	public long documentId;
	public long fileEntryId;
	public String fileEntryName;
	public String consumerCode;
	public String moduleType;
	public String uploadedBy;
	public long uploadedDate;
	public String status;
	public String comments;
	public String updatedBy;
	public long updatedDate;
	public String pendingIdentifiers;

}