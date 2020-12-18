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

package com.moi.dms.id.mapper.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.moi.dms.id.mapper.service.http.MOIIdMapperServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MOIIdMapperSoap implements Serializable {

	public static MOIIdMapperSoap toSoapModel(MOIIdMapper model) {
		MOIIdMapperSoap soapModel = new MOIIdMapperSoap();

		soapModel.setMapperId(model.getMapperId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setMosipCurrentState(model.getMosipCurrentState());
		soapModel.setMosipDocumentType(model.getMosipDocumentType());
		soapModel.setRegistrationId(model.getRegistrationId());
		soapModel.setResourceId(model.getResourceId());
		soapModel.setDocumentTitle(model.getDocumentTitle());
		soapModel.setActiveState(model.getActiveState());
		soapModel.setFileEntryId(model.getFileEntryId());
		soapModel.setUpdateDate(model.getUpdateDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());

		return soapModel;
	}

	public static MOIIdMapperSoap[] toSoapModels(MOIIdMapper[] models) {
		MOIIdMapperSoap[] soapModels = new MOIIdMapperSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MOIIdMapperSoap[][] toSoapModels(MOIIdMapper[][] models) {
		MOIIdMapperSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MOIIdMapperSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MOIIdMapperSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MOIIdMapperSoap[] toSoapModels(List<MOIIdMapper> models) {
		List<MOIIdMapperSoap> soapModels = new ArrayList<MOIIdMapperSoap>(
			models.size());

		for (MOIIdMapper model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MOIIdMapperSoap[soapModels.size()]);
	}

	public MOIIdMapperSoap() {
	}

	public long getPrimaryKey() {
		return _mapperId;
	}

	public void setPrimaryKey(long pk) {
		setMapperId(pk);
	}

	public long getMapperId() {
		return _mapperId;
	}

	public void setMapperId(long mapperId) {
		_mapperId = mapperId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getMosipCurrentState() {
		return _mosipCurrentState;
	}

	public void setMosipCurrentState(String mosipCurrentState) {
		_mosipCurrentState = mosipCurrentState;
	}

	public String getMosipDocumentType() {
		return _mosipDocumentType;
	}

	public void setMosipDocumentType(String mosipDocumentType) {
		_mosipDocumentType = mosipDocumentType;
	}

	public String getRegistrationId() {
		return _registrationId;
	}

	public void setRegistrationId(String registrationId) {
		_registrationId = registrationId;
	}

	public long getResourceId() {
		return _resourceId;
	}

	public void setResourceId(long resourceId) {
		_resourceId = resourceId;
	}

	public String getDocumentTitle() {
		return _documentTitle;
	}

	public void setDocumentTitle(String documentTitle) {
		_documentTitle = documentTitle;
	}

	public int getActiveState() {
		return _activeState;
	}

	public void setActiveState(int activeState) {
		_activeState = activeState;
	}

	public String getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(String fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	public Date getUpdateDate() {
		return _updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		_updateDate = updateDate;
	}

	public String getUpdatedBy() {
		return _updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		_updatedBy = updatedBy;
	}

	private long _mapperId;
	private long _groupId;
	private long _companyId;
	private String _mosipCurrentState;
	private String _mosipDocumentType;
	private String _registrationId;
	private long _resourceId;
	private String _documentTitle;
	private int _activeState;
	private String _fileEntryId;
	private Date _updateDate;
	private String _updatedBy;

}