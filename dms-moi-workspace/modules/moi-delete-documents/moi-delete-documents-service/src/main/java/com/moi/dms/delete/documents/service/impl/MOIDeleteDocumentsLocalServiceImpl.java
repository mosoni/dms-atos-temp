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

package com.moi.dms.delete.documents.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.moi.dms.delete.documents.model.MOIDeleteDocuments;
import com.moi.dms.delete.documents.service.base.MOIDeleteDocumentsLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the moi delete documents local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.moi.dms.delete.documents.service.MOIDeleteDocumentsLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MOIDeleteDocumentsLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.moi.dms.delete.documents.model.MOIDeleteDocuments",
	service = AopService.class
)
public class MOIDeleteDocumentsLocalServiceImpl
	extends MOIDeleteDocumentsLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.moi.dms.delete.documents.service.MOIDeleteDocumentsLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.moi.dms.delete.documents.service.MOIDeleteDocumentsLocalServiceUtil</code>.
	 */

	/**
	 * Overloaded method to create new MOIDeleteDocuments entry. This method
	 * should be used instead of the original method.
	 * 
	 * @param fileEntryId
	 * @param fileEntryName
	 * @param consumerCode
	 * @param moduleType
	 * @param uploadedBy
	 * @param uploadedDate
	 * @param status
	 * @param comments
	 * @param updatedBy
	 * @param updatedDate
	 * @param pendingIdentifiers
	 * @return MOIDeleteDocuments
	 */
	public MOIDeleteDocuments addMOIDeleteDocuments(long fileEntryId,
			String fileEntryName, String consumerCode, String moduleType,
			String uploadedBy, Date uploadedDate, String status,
			String comments, String updatedBy, Date updatedDate,
			String pendingIdentifiers) {

		// Generate primary key for the MOIDeleteDocuments.
		long documentId = counterLocalService
				.increment(MOIDeleteDocuments.class.getName());

		// Create MOIDeleteDocuments. This doesn't yet persist the entity.
		MOIDeleteDocuments deleteDocument = createMOIDeleteDocuments(
				documentId);

		deleteDocument.setFileEntryId(fileEntryId);
		deleteDocument.setFileEntryName(fileEntryName);
		deleteDocument.setConsumerCode(consumerCode);
		deleteDocument.setModuleType(moduleType);
		deleteDocument.setUploadedBy(uploadedBy);
		deleteDocument.setUploadedDate(uploadedDate);
		deleteDocument.setStatus(status);
		deleteDocument.setComments(comments);
		deleteDocument.setUpdatedBy(updatedBy);
		deleteDocument.setUpdatedDate(updatedDate);
		deleteDocument.setPendingIdentifiers(pendingIdentifiers);

		return super.addMOIDeleteDocuments(deleteDocument);
	}

	/**
	 * Overloaded method to update existing MOIDeleteDocuments entry. This
	 * method should be used instead of the original method.
	 * 
	 * @param documentId
	 * @param fileEntryId
	 * @param fileEntryName
	 * @param consumerCode
	 * @param moduleType
	 * @param uploadedBy
	 * @param uploadedDate
	 * @param status
	 * @param comments
	 * @param updatedBy
	 * @param updatedDate
	 * @param pendingIdentifiers
	 * @return MOIDeleteDocuments
	 * @throws PortalException
	 */
	public MOIDeleteDocuments updateMOIDeleteDocuments(long documentId,
			long fileEntryId, String fileEntryName, String consumerCode,
			String moduleType, String uploadedBy, Date uploadedDate,
			String status, String comments, String updatedBy, Date updatedDate,
			String pendingIdentifiers) throws PortalException {

		// Get the MOIDeleteDocuments by id.
		MOIDeleteDocuments deleteDocument = getMOIDeleteDocuments(documentId);

		// Set updated fields and modification date.
		deleteDocument.setFileEntryId(fileEntryId);
		deleteDocument.setFileEntryName(fileEntryName);
		deleteDocument.setConsumerCode(consumerCode);
		deleteDocument.setModuleType(moduleType);
		deleteDocument.setUploadedBy(uploadedBy);
		deleteDocument.setUploadedDate(uploadedDate);
		deleteDocument.setStatus(status);
		deleteDocument.setComments(comments);
		deleteDocument.setUpdatedBy(updatedBy);
		deleteDocument.setUpdatedDate(updatedDate);
		deleteDocument.setPendingIdentifiers(pendingIdentifiers);

		// Persist MOIDeleteDocuments to database.
		return super.updateMOIDeleteDocuments(deleteDocument);
	}

	/**
	 * Calls update method of parent class.
	 * 
	 * @param moiDeleteDocument
	 */
	@Override
	public MOIDeleteDocuments updateMOIDeleteDocuments(
			MOIDeleteDocuments moiDeleteDocument) {
		return super.updateMOIDeleteDocuments(moiDeleteDocument);
	}

	/**
	 * Finder method for MOIDeleteDocuments.
	 * 
	 * @param documentId
	 * @return List<MOIDeleteDocuments>
	 */
	public List<MOIDeleteDocuments> getDeleteDocumentsByDocumentId(
			Long documentId) {
		return moiDeleteDocumentsPersistence.findByDocumentId(documentId);
	}

	/**
	 * Finder method for MOIDeleteDocuments.
	 * 
	 * @param documentId
	 * @param start
	 * @param end
	 * 
	 * @return List<MOIDeleteDocuments>
	 */
	public List<MOIDeleteDocuments> getDeleteDocumentsByDocumentId(
			Long documentId, int start, int end) {
		return moiDeleteDocumentsPersistence.findByDocumentId(documentId, start,
				end);
	}

	/**
	 * Finder method for all MOIDeleteDocuments.
	 * 
	 * @return List<MOIDeleteDocuments>
	 */
	public List<MOIDeleteDocuments> getAllDeleteDocuments() {
		return moiDeleteDocumentsPersistence.findAll();
	}

	/**
	 * Finder method for MOIDeleteDocuments.
	 * 
	 * @param status
	 * @return List<MOIDeleteDocuments>
	 */
	public List<MOIDeleteDocuments> getDeleteDocumentsByStatus(String status) {
		return moiDeleteDocumentsPersistence.findByStatus(status);
	}

	/**
	 * Finder method for MOIDeleteDocuments.
	 * 
	 * @param status
	 * @return List<MOIDeleteDocuments>
	 */
	public List<MOIDeleteDocuments> getDeleteDocumentsByStatus(
			List<String> multipleStatus) {

		DynamicQuery dynamicQuery = dynamicQuery();
		Disjunction disjunctionQuery = RestrictionsFactoryUtil.disjunction();
		for (String status : multipleStatus) {
			disjunctionQuery.add(
					RestrictionsFactoryUtil.like("status", "%" + status + "%"));
		}
		dynamicQuery.add(disjunctionQuery);
		return dynamicQuery(dynamicQuery);
	}

	/**
	 * Method for finding MOIDeleteDocuments object using dynamic query.
	 * 
	 * @param keywords
	 * @param fromDate
	 * @param toDate
	 * 
	 * @return DynamicQuery
	 */
	private DynamicQuery getKeywordSearchDynamicQuery(String keywords) {
		DynamicQuery dynamicQuery = dynamicQuery();
		Disjunction disjunctionQuery = RestrictionsFactoryUtil.disjunction();
		if (Validator.isNotNull(keywords)) {
			disjunctionQuery.add(RestrictionsFactoryUtil.like("fileEntryId",
					"%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil.like("consumerCode",
					"%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil.like("moduleType",
					"%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil.like("uploadedBy",
					"%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil.like("updatedBy",
					"%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil.like("status",
					"%" + keywords + "%"));
		}

		dynamicQuery.add(disjunctionQuery);
		return dynamicQuery;
	}

	/**
	 * Returns the MOIDeleteDocuments with keywords.
	 * 
	 * @param keywords
	 * @param start
	 * @param end
	 * @param orderByComparator
	 * @return List<MOIDeleteDocuments>
	 */
	public List<MOIDeleteDocuments> getDeleteDocumentsByKeywords(
			String keywords, int start, int end,
			OrderByComparator<MOIDeleteDocuments> orderByComparator) {

		return dynamicQuery(getKeywordSearchDynamicQuery(keywords), start, end,
				orderByComparator);
	}

	/**
	 * Returns the MOIDeleteDocuments count with keywords.
	 * 
	 * @param keywords
	 * @return long
	 */
	public long getDeleteDocumentsCountByKeywords(String keywords) {
		return dynamicQueryCount(getKeywordSearchDynamicQuery(keywords));
	}



	/**
	 * Method overridden as this method is not supported.
	 * 
	 * @param MOIDeleteDocuments
	 */
	@Override
	public MOIDeleteDocuments addMOIDeleteDocuments(
			MOIDeleteDocuments moiDeleteDocuments) {
		throw new UnsupportedOperationException("Method not supported.");
	}
}