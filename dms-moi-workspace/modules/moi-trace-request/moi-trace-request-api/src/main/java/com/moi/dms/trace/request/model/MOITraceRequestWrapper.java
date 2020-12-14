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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link MOITraceRequest}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MOITraceRequest
 * @generated
 */
public class MOITraceRequestWrapper
	extends BaseModelWrapper<MOITraceRequest>
	implements ModelWrapper<MOITraceRequest>, MOITraceRequest {

	public MOITraceRequestWrapper(MOITraceRequest moiTraceRequest) {
		super(moiTraceRequest);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("requestId", getRequestId());
		attributes.put("requestedBy", getRequestedBy());
		attributes.put("requestIncomingDate", getRequestIncomingDate());
		attributes.put("requestedConsumerCode", getRequestedConsumerCode());
		attributes.put("requestedConsumerName", getRequestedConsumerName());
		attributes.put("requestedOperation", getRequestedOperation());
		attributes.put("requestedDocumentType", getRequestedDocumentType());
		attributes.put("requestValid", isRequestValid());
		attributes.put("requestResult", getRequestResult());
		attributes.put("requestResultDate", getRequestResultDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long requestId = (Long)attributes.get("requestId");

		if (requestId != null) {
			setRequestId(requestId);
		}

		String requestedBy = (String)attributes.get("requestedBy");

		if (requestedBy != null) {
			setRequestedBy(requestedBy);
		}

		Date requestIncomingDate = (Date)attributes.get("requestIncomingDate");

		if (requestIncomingDate != null) {
			setRequestIncomingDate(requestIncomingDate);
		}

		String requestedConsumerCode = (String)attributes.get(
			"requestedConsumerCode");

		if (requestedConsumerCode != null) {
			setRequestedConsumerCode(requestedConsumerCode);
		}

		String requestedConsumerName = (String)attributes.get(
			"requestedConsumerName");

		if (requestedConsumerName != null) {
			setRequestedConsumerName(requestedConsumerName);
		}

		String requestedOperation = (String)attributes.get(
			"requestedOperation");

		if (requestedOperation != null) {
			setRequestedOperation(requestedOperation);
		}

		String requestedDocumentType = (String)attributes.get(
			"requestedDocumentType");

		if (requestedDocumentType != null) {
			setRequestedDocumentType(requestedDocumentType);
		}

		Boolean requestValid = (Boolean)attributes.get("requestValid");

		if (requestValid != null) {
			setRequestValid(requestValid);
		}

		String requestResult = (String)attributes.get("requestResult");

		if (requestResult != null) {
			setRequestResult(requestResult);
		}

		Date requestResultDate = (Date)attributes.get("requestResultDate");

		if (requestResultDate != null) {
			setRequestResultDate(requestResultDate);
		}
	}

	/**
	 * Returns the primary key of this moi trace request.
	 *
	 * @return the primary key of this moi trace request
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the requested by of this moi trace request.
	 *
	 * @return the requested by of this moi trace request
	 */
	@Override
	public String getRequestedBy() {
		return model.getRequestedBy();
	}

	/**
	 * Returns the requested consumer code of this moi trace request.
	 *
	 * @return the requested consumer code of this moi trace request
	 */
	@Override
	public String getRequestedConsumerCode() {
		return model.getRequestedConsumerCode();
	}

	/**
	 * Returns the requested consumer name of this moi trace request.
	 *
	 * @return the requested consumer name of this moi trace request
	 */
	@Override
	public String getRequestedConsumerName() {
		return model.getRequestedConsumerName();
	}

	/**
	 * Returns the requested document type of this moi trace request.
	 *
	 * @return the requested document type of this moi trace request
	 */
	@Override
	public String getRequestedDocumentType() {
		return model.getRequestedDocumentType();
	}

	/**
	 * Returns the requested operation of this moi trace request.
	 *
	 * @return the requested operation of this moi trace request
	 */
	@Override
	public String getRequestedOperation() {
		return model.getRequestedOperation();
	}

	/**
	 * Returns the request ID of this moi trace request.
	 *
	 * @return the request ID of this moi trace request
	 */
	@Override
	public long getRequestId() {
		return model.getRequestId();
	}

	/**
	 * Returns the request incoming date of this moi trace request.
	 *
	 * @return the request incoming date of this moi trace request
	 */
	@Override
	public Date getRequestIncomingDate() {
		return model.getRequestIncomingDate();
	}

	/**
	 * Returns the request result of this moi trace request.
	 *
	 * @return the request result of this moi trace request
	 */
	@Override
	public String getRequestResult() {
		return model.getRequestResult();
	}

	/**
	 * Returns the request result date of this moi trace request.
	 *
	 * @return the request result date of this moi trace request
	 */
	@Override
	public Date getRequestResultDate() {
		return model.getRequestResultDate();
	}

	/**
	 * Returns the request valid of this moi trace request.
	 *
	 * @return the request valid of this moi trace request
	 */
	@Override
	public boolean getRequestValid() {
		return model.getRequestValid();
	}

	/**
	 * Returns <code>true</code> if this moi trace request is request valid.
	 *
	 * @return <code>true</code> if this moi trace request is request valid; <code>false</code> otherwise
	 */
	@Override
	public boolean isRequestValid() {
		return model.isRequestValid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the primary key of this moi trace request.
	 *
	 * @param primaryKey the primary key of this moi trace request
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the requested by of this moi trace request.
	 *
	 * @param requestedBy the requested by of this moi trace request
	 */
	@Override
	public void setRequestedBy(String requestedBy) {
		model.setRequestedBy(requestedBy);
	}

	/**
	 * Sets the requested consumer code of this moi trace request.
	 *
	 * @param requestedConsumerCode the requested consumer code of this moi trace request
	 */
	@Override
	public void setRequestedConsumerCode(String requestedConsumerCode) {
		model.setRequestedConsumerCode(requestedConsumerCode);
	}

	/**
	 * Sets the requested consumer name of this moi trace request.
	 *
	 * @param requestedConsumerName the requested consumer name of this moi trace request
	 */
	@Override
	public void setRequestedConsumerName(String requestedConsumerName) {
		model.setRequestedConsumerName(requestedConsumerName);
	}

	/**
	 * Sets the requested document type of this moi trace request.
	 *
	 * @param requestedDocumentType the requested document type of this moi trace request
	 */
	@Override
	public void setRequestedDocumentType(String requestedDocumentType) {
		model.setRequestedDocumentType(requestedDocumentType);
	}

	/**
	 * Sets the requested operation of this moi trace request.
	 *
	 * @param requestedOperation the requested operation of this moi trace request
	 */
	@Override
	public void setRequestedOperation(String requestedOperation) {
		model.setRequestedOperation(requestedOperation);
	}

	/**
	 * Sets the request ID of this moi trace request.
	 *
	 * @param requestId the request ID of this moi trace request
	 */
	@Override
	public void setRequestId(long requestId) {
		model.setRequestId(requestId);
	}

	/**
	 * Sets the request incoming date of this moi trace request.
	 *
	 * @param requestIncomingDate the request incoming date of this moi trace request
	 */
	@Override
	public void setRequestIncomingDate(Date requestIncomingDate) {
		model.setRequestIncomingDate(requestIncomingDate);
	}

	/**
	 * Sets the request result of this moi trace request.
	 *
	 * @param requestResult the request result of this moi trace request
	 */
	@Override
	public void setRequestResult(String requestResult) {
		model.setRequestResult(requestResult);
	}

	/**
	 * Sets the request result date of this moi trace request.
	 *
	 * @param requestResultDate the request result date of this moi trace request
	 */
	@Override
	public void setRequestResultDate(Date requestResultDate) {
		model.setRequestResultDate(requestResultDate);
	}

	/**
	 * Sets whether this moi trace request is request valid.
	 *
	 * @param requestValid the request valid of this moi trace request
	 */
	@Override
	public void setRequestValid(boolean requestValid) {
		model.setRequestValid(requestValid);
	}

	@Override
	protected MOITraceRequestWrapper wrap(MOITraceRequest moiTraceRequest) {
		return new MOITraceRequestWrapper(moiTraceRequest);
	}

}