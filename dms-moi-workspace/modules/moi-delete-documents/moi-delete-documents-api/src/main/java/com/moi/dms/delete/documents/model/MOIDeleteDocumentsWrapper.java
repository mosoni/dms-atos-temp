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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link MOIDeleteDocuments}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MOIDeleteDocuments
 * @generated
 */
public class MOIDeleteDocumentsWrapper
	extends BaseModelWrapper<MOIDeleteDocuments>
	implements ModelWrapper<MOIDeleteDocuments>, MOIDeleteDocuments {

	public MOIDeleteDocumentsWrapper(MOIDeleteDocuments moiDeleteDocuments) {
		super(moiDeleteDocuments);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("documentId", getDocumentId());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("fileEntryName", getFileEntryName());
		attributes.put("consumerCode", getConsumerCode());
		attributes.put("moduleType", getModuleType());
		attributes.put("uploadedBy", getUploadedBy());
		attributes.put("uploadedDate", getUploadedDate());
		attributes.put("status", getStatus());
		attributes.put("comments", getComments());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());
		attributes.put("pendingIdentifiers", getPendingIdentifiers());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long documentId = (Long)attributes.get("documentId");

		if (documentId != null) {
			setDocumentId(documentId);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		String fileEntryName = (String)attributes.get("fileEntryName");

		if (fileEntryName != null) {
			setFileEntryName(fileEntryName);
		}

		String consumerCode = (String)attributes.get("consumerCode");

		if (consumerCode != null) {
			setConsumerCode(consumerCode);
		}

		String moduleType = (String)attributes.get("moduleType");

		if (moduleType != null) {
			setModuleType(moduleType);
		}

		String uploadedBy = (String)attributes.get("uploadedBy");

		if (uploadedBy != null) {
			setUploadedBy(uploadedBy);
		}

		Date uploadedDate = (Date)attributes.get("uploadedDate");

		if (uploadedDate != null) {
			setUploadedDate(uploadedDate);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		String updatedBy = (String)attributes.get("updatedBy");

		if (updatedBy != null) {
			setUpdatedBy(updatedBy);
		}

		Date updatedDate = (Date)attributes.get("updatedDate");

		if (updatedDate != null) {
			setUpdatedDate(updatedDate);
		}

		String pendingIdentifiers = (String)attributes.get(
			"pendingIdentifiers");

		if (pendingIdentifiers != null) {
			setPendingIdentifiers(pendingIdentifiers);
		}
	}

	/**
	 * Returns the comments of this moi delete documents.
	 *
	 * @return the comments of this moi delete documents
	 */
	@Override
	public String getComments() {
		return model.getComments();
	}

	/**
	 * Returns the consumer code of this moi delete documents.
	 *
	 * @return the consumer code of this moi delete documents
	 */
	@Override
	public String getConsumerCode() {
		return model.getConsumerCode();
	}

	/**
	 * Returns the document ID of this moi delete documents.
	 *
	 * @return the document ID of this moi delete documents
	 */
	@Override
	public long getDocumentId() {
		return model.getDocumentId();
	}

	/**
	 * Returns the file entry ID of this moi delete documents.
	 *
	 * @return the file entry ID of this moi delete documents
	 */
	@Override
	public long getFileEntryId() {
		return model.getFileEntryId();
	}

	/**
	 * Returns the file entry name of this moi delete documents.
	 *
	 * @return the file entry name of this moi delete documents
	 */
	@Override
	public String getFileEntryName() {
		return model.getFileEntryName();
	}

	/**
	 * Returns the module type of this moi delete documents.
	 *
	 * @return the module type of this moi delete documents
	 */
	@Override
	public String getModuleType() {
		return model.getModuleType();
	}

	/**
	 * Returns the pending identifiers of this moi delete documents.
	 *
	 * @return the pending identifiers of this moi delete documents
	 */
	@Override
	public String getPendingIdentifiers() {
		return model.getPendingIdentifiers();
	}

	/**
	 * Returns the primary key of this moi delete documents.
	 *
	 * @return the primary key of this moi delete documents
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this moi delete documents.
	 *
	 * @return the status of this moi delete documents
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the updated by of this moi delete documents.
	 *
	 * @return the updated by of this moi delete documents
	 */
	@Override
	public String getUpdatedBy() {
		return model.getUpdatedBy();
	}

	/**
	 * Returns the updated date of this moi delete documents.
	 *
	 * @return the updated date of this moi delete documents
	 */
	@Override
	public Date getUpdatedDate() {
		return model.getUpdatedDate();
	}

	/**
	 * Returns the uploaded by of this moi delete documents.
	 *
	 * @return the uploaded by of this moi delete documents
	 */
	@Override
	public String getUploadedBy() {
		return model.getUploadedBy();
	}

	/**
	 * Returns the uploaded date of this moi delete documents.
	 *
	 * @return the uploaded date of this moi delete documents
	 */
	@Override
	public Date getUploadedDate() {
		return model.getUploadedDate();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the comments of this moi delete documents.
	 *
	 * @param comments the comments of this moi delete documents
	 */
	@Override
	public void setComments(String comments) {
		model.setComments(comments);
	}

	/**
	 * Sets the consumer code of this moi delete documents.
	 *
	 * @param consumerCode the consumer code of this moi delete documents
	 */
	@Override
	public void setConsumerCode(String consumerCode) {
		model.setConsumerCode(consumerCode);
	}

	/**
	 * Sets the document ID of this moi delete documents.
	 *
	 * @param documentId the document ID of this moi delete documents
	 */
	@Override
	public void setDocumentId(long documentId) {
		model.setDocumentId(documentId);
	}

	/**
	 * Sets the file entry ID of this moi delete documents.
	 *
	 * @param fileEntryId the file entry ID of this moi delete documents
	 */
	@Override
	public void setFileEntryId(long fileEntryId) {
		model.setFileEntryId(fileEntryId);
	}

	/**
	 * Sets the file entry name of this moi delete documents.
	 *
	 * @param fileEntryName the file entry name of this moi delete documents
	 */
	@Override
	public void setFileEntryName(String fileEntryName) {
		model.setFileEntryName(fileEntryName);
	}

	/**
	 * Sets the module type of this moi delete documents.
	 *
	 * @param moduleType the module type of this moi delete documents
	 */
	@Override
	public void setModuleType(String moduleType) {
		model.setModuleType(moduleType);
	}

	/**
	 * Sets the pending identifiers of this moi delete documents.
	 *
	 * @param pendingIdentifiers the pending identifiers of this moi delete documents
	 */
	@Override
	public void setPendingIdentifiers(String pendingIdentifiers) {
		model.setPendingIdentifiers(pendingIdentifiers);
	}

	/**
	 * Sets the primary key of this moi delete documents.
	 *
	 * @param primaryKey the primary key of this moi delete documents
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this moi delete documents.
	 *
	 * @param status the status of this moi delete documents
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the updated by of this moi delete documents.
	 *
	 * @param updatedBy the updated by of this moi delete documents
	 */
	@Override
	public void setUpdatedBy(String updatedBy) {
		model.setUpdatedBy(updatedBy);
	}

	/**
	 * Sets the updated date of this moi delete documents.
	 *
	 * @param updatedDate the updated date of this moi delete documents
	 */
	@Override
	public void setUpdatedDate(Date updatedDate) {
		model.setUpdatedDate(updatedDate);
	}

	/**
	 * Sets the uploaded by of this moi delete documents.
	 *
	 * @param uploadedBy the uploaded by of this moi delete documents
	 */
	@Override
	public void setUploadedBy(String uploadedBy) {
		model.setUploadedBy(uploadedBy);
	}

	/**
	 * Sets the uploaded date of this moi delete documents.
	 *
	 * @param uploadedDate the uploaded date of this moi delete documents
	 */
	@Override
	public void setUploadedDate(Date uploadedDate) {
		model.setUploadedDate(uploadedDate);
	}

	@Override
	protected MOIDeleteDocumentsWrapper wrap(
		MOIDeleteDocuments moiDeleteDocuments) {

		return new MOIDeleteDocumentsWrapper(moiDeleteDocuments);
	}

}