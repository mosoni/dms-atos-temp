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

package com.moi.dms.delete.documents.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MOIDeleteDocumentsSoap implements Serializable {

	public static MOIDeleteDocumentsSoap toSoapModel(MOIDeleteDocuments model) {
		MOIDeleteDocumentsSoap soapModel = new MOIDeleteDocumentsSoap();

		soapModel.setDocumentId(model.getDocumentId());
		soapModel.setFileEntryId(model.getFileEntryId());
		soapModel.setFileEntryName(model.getFileEntryName());
		soapModel.setConsumerCode(model.getConsumerCode());
		soapModel.setModuleType(model.getModuleType());
		soapModel.setUploadedBy(model.getUploadedBy());
		soapModel.setUploadedDate(model.getUploadedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setComments(model.getComments());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());
		soapModel.setPendingIdentifiers(model.getPendingIdentifiers());

		return soapModel;
	}

	public static MOIDeleteDocumentsSoap[] toSoapModels(
		MOIDeleteDocuments[] models) {

		MOIDeleteDocumentsSoap[] soapModels =
			new MOIDeleteDocumentsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MOIDeleteDocumentsSoap[][] toSoapModels(
		MOIDeleteDocuments[][] models) {

		MOIDeleteDocumentsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new MOIDeleteDocumentsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MOIDeleteDocumentsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MOIDeleteDocumentsSoap[] toSoapModels(
		List<MOIDeleteDocuments> models) {

		List<MOIDeleteDocumentsSoap> soapModels =
			new ArrayList<MOIDeleteDocumentsSoap>(models.size());

		for (MOIDeleteDocuments model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new MOIDeleteDocumentsSoap[soapModels.size()]);
	}

	public MOIDeleteDocumentsSoap() {
	}

	public long getPrimaryKey() {
		return _documentId;
	}

	public void setPrimaryKey(long pk) {
		setDocumentId(pk);
	}

	public long getDocumentId() {
		return _documentId;
	}

	public void setDocumentId(long documentId) {
		_documentId = documentId;
	}

	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	public String getFileEntryName() {
		return _fileEntryName;
	}

	public void setFileEntryName(String fileEntryName) {
		_fileEntryName = fileEntryName;
	}

	public String getConsumerCode() {
		return _consumerCode;
	}

	public void setConsumerCode(String consumerCode) {
		_consumerCode = consumerCode;
	}

	public String getModuleType() {
		return _moduleType;
	}

	public void setModuleType(String moduleType) {
		_moduleType = moduleType;
	}

	public String getUploadedBy() {
		return _uploadedBy;
	}

	public void setUploadedBy(String uploadedBy) {
		_uploadedBy = uploadedBy;
	}

	public Date getUploadedDate() {
		return _uploadedDate;
	}

	public void setUploadedDate(Date uploadedDate) {
		_uploadedDate = uploadedDate;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	public String getUpdatedBy() {
		return _updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		_updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return _updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		_updatedDate = updatedDate;
	}

	public String getPendingIdentifiers() {
		return _pendingIdentifiers;
	}

	public void setPendingIdentifiers(String pendingIdentifiers) {
		_pendingIdentifiers = pendingIdentifiers;
	}

	private long _documentId;
	private long _fileEntryId;
	private String _fileEntryName;
	private String _consumerCode;
	private String _moduleType;
	private String _uploadedBy;
	private Date _uploadedDate;
	private String _status;
	private String _comments;
	private String _updatedBy;
	private Date _updatedDate;
	private String _pendingIdentifiers;

}