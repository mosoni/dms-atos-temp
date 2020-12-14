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

package com.moi.dms.audit.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.moi.dms.audit.service.http.MOIAuditServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MOIAuditSoap implements Serializable {

	public static MOIAuditSoap toSoapModel(MOIAudit model) {
		MOIAuditSoap soapModel = new MOIAuditSoap();

		soapModel.setAuditId(model.getAuditId());
		soapModel.setActionPerformedBy(model.getActionPerformedBy());
		soapModel.setActionPerformedDate(model.getActionPerformedDate());
		soapModel.setActionStatus(model.getActionStatus());
		soapModel.setActionDescription(model.getActionDescription());
		soapModel.setActionConsumer(model.getActionConsumer());

		return soapModel;
	}

	public static MOIAuditSoap[] toSoapModels(MOIAudit[] models) {
		MOIAuditSoap[] soapModels = new MOIAuditSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MOIAuditSoap[][] toSoapModels(MOIAudit[][] models) {
		MOIAuditSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MOIAuditSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MOIAuditSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MOIAuditSoap[] toSoapModels(List<MOIAudit> models) {
		List<MOIAuditSoap> soapModels = new ArrayList<MOIAuditSoap>(
			models.size());

		for (MOIAudit model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MOIAuditSoap[soapModels.size()]);
	}

	public MOIAuditSoap() {
	}

	public long getPrimaryKey() {
		return _auditId;
	}

	public void setPrimaryKey(long pk) {
		setAuditId(pk);
	}

	public long getAuditId() {
		return _auditId;
	}

	public void setAuditId(long auditId) {
		_auditId = auditId;
	}

	public String getActionPerformedBy() {
		return _actionPerformedBy;
	}

	public void setActionPerformedBy(String actionPerformedBy) {
		_actionPerformedBy = actionPerformedBy;
	}

	public Date getActionPerformedDate() {
		return _actionPerformedDate;
	}

	public void setActionPerformedDate(Date actionPerformedDate) {
		_actionPerformedDate = actionPerformedDate;
	}

	public String getActionStatus() {
		return _actionStatus;
	}

	public void setActionStatus(String actionStatus) {
		_actionStatus = actionStatus;
	}

	public String getActionDescription() {
		return _actionDescription;
	}

	public void setActionDescription(String actionDescription) {
		_actionDescription = actionDescription;
	}

	public String getActionConsumer() {
		return _actionConsumer;
	}

	public void setActionConsumer(String actionConsumer) {
		_actionConsumer = actionConsumer;
	}

	private long _auditId;
	private String _actionPerformedBy;
	private Date _actionPerformedDate;
	private String _actionStatus;
	private String _actionDescription;
	private String _actionConsumer;

}