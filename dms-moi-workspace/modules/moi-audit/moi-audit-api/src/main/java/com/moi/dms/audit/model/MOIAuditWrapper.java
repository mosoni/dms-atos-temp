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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link MOIAudit}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MOIAudit
 * @generated
 */
public class MOIAuditWrapper
	extends BaseModelWrapper<MOIAudit>
	implements ModelWrapper<MOIAudit>, MOIAudit {

	public MOIAuditWrapper(MOIAudit moiAudit) {
		super(moiAudit);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("auditId", getAuditId());
		attributes.put("actionPerformedBy", getActionPerformedBy());
		attributes.put("actionPerformedDate", getActionPerformedDate());
		attributes.put("actionStatus", getActionStatus());
		attributes.put("actionDescription", getActionDescription());
		attributes.put("actionConsumer", getActionConsumer());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long auditId = (Long)attributes.get("auditId");

		if (auditId != null) {
			setAuditId(auditId);
		}

		String actionPerformedBy = (String)attributes.get("actionPerformedBy");

		if (actionPerformedBy != null) {
			setActionPerformedBy(actionPerformedBy);
		}

		Date actionPerformedDate = (Date)attributes.get("actionPerformedDate");

		if (actionPerformedDate != null) {
			setActionPerformedDate(actionPerformedDate);
		}

		String actionStatus = (String)attributes.get("actionStatus");

		if (actionStatus != null) {
			setActionStatus(actionStatus);
		}

		String actionDescription = (String)attributes.get("actionDescription");

		if (actionDescription != null) {
			setActionDescription(actionDescription);
		}

		String actionConsumer = (String)attributes.get("actionConsumer");

		if (actionConsumer != null) {
			setActionConsumer(actionConsumer);
		}
	}

	/**
	 * Returns the action consumer of this moi audit.
	 *
	 * @return the action consumer of this moi audit
	 */
	@Override
	public String getActionConsumer() {
		return model.getActionConsumer();
	}

	/**
	 * Returns the action description of this moi audit.
	 *
	 * @return the action description of this moi audit
	 */
	@Override
	public String getActionDescription() {
		return model.getActionDescription();
	}

	/**
	 * Returns the action performed by of this moi audit.
	 *
	 * @return the action performed by of this moi audit
	 */
	@Override
	public String getActionPerformedBy() {
		return model.getActionPerformedBy();
	}

	/**
	 * Returns the action performed date of this moi audit.
	 *
	 * @return the action performed date of this moi audit
	 */
	@Override
	public Date getActionPerformedDate() {
		return model.getActionPerformedDate();
	}

	/**
	 * Returns the action status of this moi audit.
	 *
	 * @return the action status of this moi audit
	 */
	@Override
	public String getActionStatus() {
		return model.getActionStatus();
	}

	/**
	 * Returns the audit ID of this moi audit.
	 *
	 * @return the audit ID of this moi audit
	 */
	@Override
	public long getAuditId() {
		return model.getAuditId();
	}

	/**
	 * Returns the primary key of this moi audit.
	 *
	 * @return the primary key of this moi audit
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the action consumer of this moi audit.
	 *
	 * @param actionConsumer the action consumer of this moi audit
	 */
	@Override
	public void setActionConsumer(String actionConsumer) {
		model.setActionConsumer(actionConsumer);
	}

	/**
	 * Sets the action description of this moi audit.
	 *
	 * @param actionDescription the action description of this moi audit
	 */
	@Override
	public void setActionDescription(String actionDescription) {
		model.setActionDescription(actionDescription);
	}

	/**
	 * Sets the action performed by of this moi audit.
	 *
	 * @param actionPerformedBy the action performed by of this moi audit
	 */
	@Override
	public void setActionPerformedBy(String actionPerformedBy) {
		model.setActionPerformedBy(actionPerformedBy);
	}

	/**
	 * Sets the action performed date of this moi audit.
	 *
	 * @param actionPerformedDate the action performed date of this moi audit
	 */
	@Override
	public void setActionPerformedDate(Date actionPerformedDate) {
		model.setActionPerformedDate(actionPerformedDate);
	}

	/**
	 * Sets the action status of this moi audit.
	 *
	 * @param actionStatus the action status of this moi audit
	 */
	@Override
	public void setActionStatus(String actionStatus) {
		model.setActionStatus(actionStatus);
	}

	/**
	 * Sets the audit ID of this moi audit.
	 *
	 * @param auditId the audit ID of this moi audit
	 */
	@Override
	public void setAuditId(long auditId) {
		model.setAuditId(auditId);
	}

	/**
	 * Sets the primary key of this moi audit.
	 *
	 * @param primaryKey the primary key of this moi audit
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected MOIAuditWrapper wrap(MOIAudit moiAudit) {
		return new MOIAuditWrapper(moiAudit);
	}

}