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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link MOIIdMapper}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MOIIdMapper
 * @generated
 */
public class MOIIdMapperWrapper
	extends BaseModelWrapper<MOIIdMapper>
	implements ModelWrapper<MOIIdMapper>, MOIIdMapper {

	public MOIIdMapperWrapper(MOIIdMapper moiIdMapper) {
		super(moiIdMapper);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mapperId", getMapperId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("mosipCurrentState", getMosipCurrentState());
		attributes.put("mosipDocumentType", getMosipDocumentType());
		attributes.put("registrationId", getRegistrationId());
		attributes.put("resourceId", getResourceId());
		attributes.put("documentTitle", getDocumentTitle());
		attributes.put("activeState", getActiveState());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("updateDate", getUpdateDate());
		attributes.put("updatedBy", getUpdatedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mapperId = (Long)attributes.get("mapperId");

		if (mapperId != null) {
			setMapperId(mapperId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String mosipCurrentState = (String)attributes.get("mosipCurrentState");

		if (mosipCurrentState != null) {
			setMosipCurrentState(mosipCurrentState);
		}

		String mosipDocumentType = (String)attributes.get("mosipDocumentType");

		if (mosipDocumentType != null) {
			setMosipDocumentType(mosipDocumentType);
		}

		String registrationId = (String)attributes.get("registrationId");

		if (registrationId != null) {
			setRegistrationId(registrationId);
		}

		Long resourceId = (Long)attributes.get("resourceId");

		if (resourceId != null) {
			setResourceId(resourceId);
		}

		String documentTitle = (String)attributes.get("documentTitle");

		if (documentTitle != null) {
			setDocumentTitle(documentTitle);
		}

		Integer activeState = (Integer)attributes.get("activeState");

		if (activeState != null) {
			setActiveState(activeState);
		}

		String fileEntryId = (String)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		Date updateDate = (Date)attributes.get("updateDate");

		if (updateDate != null) {
			setUpdateDate(updateDate);
		}

		String updatedBy = (String)attributes.get("updatedBy");

		if (updatedBy != null) {
			setUpdatedBy(updatedBy);
		}
	}

	/**
	 * Returns the active state of this moi ID mapper.
	 *
	 * @return the active state of this moi ID mapper
	 */
	@Override
	public int getActiveState() {
		return model.getActiveState();
	}

	/**
	 * Returns the company ID of this moi ID mapper.
	 *
	 * @return the company ID of this moi ID mapper
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the document title of this moi ID mapper.
	 *
	 * @return the document title of this moi ID mapper
	 */
	@Override
	public String getDocumentTitle() {
		return model.getDocumentTitle();
	}

	/**
	 * Returns the file entry ID of this moi ID mapper.
	 *
	 * @return the file entry ID of this moi ID mapper
	 */
	@Override
	public String getFileEntryId() {
		return model.getFileEntryId();
	}

	/**
	 * Returns the group ID of this moi ID mapper.
	 *
	 * @return the group ID of this moi ID mapper
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the mapper ID of this moi ID mapper.
	 *
	 * @return the mapper ID of this moi ID mapper
	 */
	@Override
	public long getMapperId() {
		return model.getMapperId();
	}

	/**
	 * Returns the mosip current state of this moi ID mapper.
	 *
	 * @return the mosip current state of this moi ID mapper
	 */
	@Override
	public String getMosipCurrentState() {
		return model.getMosipCurrentState();
	}

	/**
	 * Returns the mosip document type of this moi ID mapper.
	 *
	 * @return the mosip document type of this moi ID mapper
	 */
	@Override
	public String getMosipDocumentType() {
		return model.getMosipDocumentType();
	}

	/**
	 * Returns the primary key of this moi ID mapper.
	 *
	 * @return the primary key of this moi ID mapper
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the registration ID of this moi ID mapper.
	 *
	 * @return the registration ID of this moi ID mapper
	 */
	@Override
	public String getRegistrationId() {
		return model.getRegistrationId();
	}

	/**
	 * Returns the resource ID of this moi ID mapper.
	 *
	 * @return the resource ID of this moi ID mapper
	 */
	@Override
	public long getResourceId() {
		return model.getResourceId();
	}

	/**
	 * Returns the update date of this moi ID mapper.
	 *
	 * @return the update date of this moi ID mapper
	 */
	@Override
	public Date getUpdateDate() {
		return model.getUpdateDate();
	}

	/**
	 * Returns the updated by of this moi ID mapper.
	 *
	 * @return the updated by of this moi ID mapper
	 */
	@Override
	public String getUpdatedBy() {
		return model.getUpdatedBy();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the active state of this moi ID mapper.
	 *
	 * @param activeState the active state of this moi ID mapper
	 */
	@Override
	public void setActiveState(int activeState) {
		model.setActiveState(activeState);
	}

	/**
	 * Sets the company ID of this moi ID mapper.
	 *
	 * @param companyId the company ID of this moi ID mapper
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the document title of this moi ID mapper.
	 *
	 * @param documentTitle the document title of this moi ID mapper
	 */
	@Override
	public void setDocumentTitle(String documentTitle) {
		model.setDocumentTitle(documentTitle);
	}

	/**
	 * Sets the file entry ID of this moi ID mapper.
	 *
	 * @param fileEntryId the file entry ID of this moi ID mapper
	 */
	@Override
	public void setFileEntryId(String fileEntryId) {
		model.setFileEntryId(fileEntryId);
	}

	/**
	 * Sets the group ID of this moi ID mapper.
	 *
	 * @param groupId the group ID of this moi ID mapper
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the mapper ID of this moi ID mapper.
	 *
	 * @param mapperId the mapper ID of this moi ID mapper
	 */
	@Override
	public void setMapperId(long mapperId) {
		model.setMapperId(mapperId);
	}

	/**
	 * Sets the mosip current state of this moi ID mapper.
	 *
	 * @param mosipCurrentState the mosip current state of this moi ID mapper
	 */
	@Override
	public void setMosipCurrentState(String mosipCurrentState) {
		model.setMosipCurrentState(mosipCurrentState);
	}

	/**
	 * Sets the mosip document type of this moi ID mapper.
	 *
	 * @param mosipDocumentType the mosip document type of this moi ID mapper
	 */
	@Override
	public void setMosipDocumentType(String mosipDocumentType) {
		model.setMosipDocumentType(mosipDocumentType);
	}

	/**
	 * Sets the primary key of this moi ID mapper.
	 *
	 * @param primaryKey the primary key of this moi ID mapper
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the registration ID of this moi ID mapper.
	 *
	 * @param registrationId the registration ID of this moi ID mapper
	 */
	@Override
	public void setRegistrationId(String registrationId) {
		model.setRegistrationId(registrationId);
	}

	/**
	 * Sets the resource ID of this moi ID mapper.
	 *
	 * @param resourceId the resource ID of this moi ID mapper
	 */
	@Override
	public void setResourceId(long resourceId) {
		model.setResourceId(resourceId);
	}

	/**
	 * Sets the update date of this moi ID mapper.
	 *
	 * @param updateDate the update date of this moi ID mapper
	 */
	@Override
	public void setUpdateDate(Date updateDate) {
		model.setUpdateDate(updateDate);
	}

	/**
	 * Sets the updated by of this moi ID mapper.
	 *
	 * @param updatedBy the updated by of this moi ID mapper
	 */
	@Override
	public void setUpdatedBy(String updatedBy) {
		model.setUpdatedBy(updatedBy);
	}

	@Override
	protected MOIIdMapperWrapper wrap(MOIIdMapper moiIdMapper) {
		return new MOIIdMapperWrapper(moiIdMapper);
	}

}