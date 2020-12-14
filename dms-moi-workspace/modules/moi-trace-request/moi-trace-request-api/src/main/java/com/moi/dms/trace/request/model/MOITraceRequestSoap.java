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

package com.moi.dms.trace.request.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.moi.dms.trace.request.service.http.MOITraceRequestServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MOITraceRequestSoap implements Serializable {

	public static MOITraceRequestSoap toSoapModel(MOITraceRequest model) {
		MOITraceRequestSoap soapModel = new MOITraceRequestSoap();

		soapModel.setRequestId(model.getRequestId());
		soapModel.setRequestedBy(model.getRequestedBy());
		soapModel.setRequestIncomingDate(model.getRequestIncomingDate());
		soapModel.setRequestedConsumerCode(model.getRequestedConsumerCode());
		soapModel.setRequestedConsumerName(model.getRequestedConsumerName());
		soapModel.setRequestedOperation(model.getRequestedOperation());
		soapModel.setRequestedDocumentType(model.getRequestedDocumentType());
		soapModel.setRequestValid(model.isRequestValid());
		soapModel.setRequestResult(model.getRequestResult());
		soapModel.setRequestResultDate(model.getRequestResultDate());

		return soapModel;
	}

	public static MOITraceRequestSoap[] toSoapModels(MOITraceRequest[] models) {
		MOITraceRequestSoap[] soapModels =
			new MOITraceRequestSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MOITraceRequestSoap[][] toSoapModels(
		MOITraceRequest[][] models) {

		MOITraceRequestSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new MOITraceRequestSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MOITraceRequestSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MOITraceRequestSoap[] toSoapModels(
		List<MOITraceRequest> models) {

		List<MOITraceRequestSoap> soapModels =
			new ArrayList<MOITraceRequestSoap>(models.size());

		for (MOITraceRequest model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MOITraceRequestSoap[soapModels.size()]);
	}

	public MOITraceRequestSoap() {
	}

	public long getPrimaryKey() {
		return _requestId;
	}

	public void setPrimaryKey(long pk) {
		setRequestId(pk);
	}

	public long getRequestId() {
		return _requestId;
	}

	public void setRequestId(long requestId) {
		_requestId = requestId;
	}

	public String getRequestedBy() {
		return _requestedBy;
	}

	public void setRequestedBy(String requestedBy) {
		_requestedBy = requestedBy;
	}

	public Date getRequestIncomingDate() {
		return _requestIncomingDate;
	}

	public void setRequestIncomingDate(Date requestIncomingDate) {
		_requestIncomingDate = requestIncomingDate;
	}

	public String getRequestedConsumerCode() {
		return _requestedConsumerCode;
	}

	public void setRequestedConsumerCode(String requestedConsumerCode) {
		_requestedConsumerCode = requestedConsumerCode;
	}

	public String getRequestedConsumerName() {
		return _requestedConsumerName;
	}

	public void setRequestedConsumerName(String requestedConsumerName) {
		_requestedConsumerName = requestedConsumerName;
	}

	public String getRequestedOperation() {
		return _requestedOperation;
	}

	public void setRequestedOperation(String requestedOperation) {
		_requestedOperation = requestedOperation;
	}

	public String getRequestedDocumentType() {
		return _requestedDocumentType;
	}

	public void setRequestedDocumentType(String requestedDocumentType) {
		_requestedDocumentType = requestedDocumentType;
	}

	public boolean getRequestValid() {
		return _requestValid;
	}

	public boolean isRequestValid() {
		return _requestValid;
	}

	public void setRequestValid(boolean requestValid) {
		_requestValid = requestValid;
	}

	public String getRequestResult() {
		return _requestResult;
	}

	public void setRequestResult(String requestResult) {
		_requestResult = requestResult;
	}

	public Date getRequestResultDate() {
		return _requestResultDate;
	}

	public void setRequestResultDate(Date requestResultDate) {
		_requestResultDate = requestResultDate;
	}

	private long _requestId;
	private String _requestedBy;
	private Date _requestIncomingDate;
	private String _requestedConsumerCode;
	private String _requestedConsumerName;
	private String _requestedOperation;
	private String _requestedDocumentType;
	private boolean _requestValid;
	private String _requestResult;
	private Date _requestResultDate;

}