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

package com.moi.dms.id.mapper.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.moi.dms.id.mapper.model.MOIIdMapper;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the moi ID mapper service. This utility wraps <code>com.moi.dms.id.mapper.service.persistence.impl.MOIIdMapperPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MOIIdMapperPersistence
 * @generated
 */
public class MOIIdMapperUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(MOIIdMapper moiIdMapper) {
		getPersistence().clearCache(moiIdMapper);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, MOIIdMapper> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MOIIdMapper> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MOIIdMapper> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MOIIdMapper> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MOIIdMapper update(MOIIdMapper moiIdMapper) {
		return getPersistence().update(moiIdMapper);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MOIIdMapper update(
		MOIIdMapper moiIdMapper, ServiceContext serviceContext) {

		return getPersistence().update(moiIdMapper, serviceContext);
	}

	/**
	 * Returns all the moi ID mappers where mapperId = &#63;.
	 *
	 * @param mapperId the mapper ID
	 * @return the matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByMapperId(long mapperId) {
		return getPersistence().findByMapperId(mapperId);
	}

	/**
	 * Returns a range of all the moi ID mappers where mapperId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param mapperId the mapper ID
	 * @param start the lower bound of the range of moi ID mappers
	 * @param end the upper bound of the range of moi ID mappers (not inclusive)
	 * @return the range of matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByMapperId(
		long mapperId, int start, int end) {

		return getPersistence().findByMapperId(mapperId, start, end);
	}

	/**
	 * Returns an ordered range of all the moi ID mappers where mapperId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param mapperId the mapper ID
	 * @param start the lower bound of the range of moi ID mappers
	 * @param end the upper bound of the range of moi ID mappers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByMapperId(
		long mapperId, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator) {

		return getPersistence().findByMapperId(
			mapperId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the moi ID mappers where mapperId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param mapperId the mapper ID
	 * @param start the lower bound of the range of moi ID mappers
	 * @param end the upper bound of the range of moi ID mappers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByMapperId(
		long mapperId, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByMapperId(
			mapperId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where mapperId = &#63;.
	 *
	 * @param mapperId the mapper ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper findByMapperId_First(
			long mapperId, OrderByComparator<MOIIdMapper> orderByComparator)
		throws com.moi.dms.id.mapper.exception.NoSuchMOIIdMapperException {

		return getPersistence().findByMapperId_First(
			mapperId, orderByComparator);
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where mapperId = &#63;.
	 *
	 * @param mapperId the mapper ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper fetchByMapperId_First(
		long mapperId, OrderByComparator<MOIIdMapper> orderByComparator) {

		return getPersistence().fetchByMapperId_First(
			mapperId, orderByComparator);
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where mapperId = &#63;.
	 *
	 * @param mapperId the mapper ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper findByMapperId_Last(
			long mapperId, OrderByComparator<MOIIdMapper> orderByComparator)
		throws com.moi.dms.id.mapper.exception.NoSuchMOIIdMapperException {

		return getPersistence().findByMapperId_Last(
			mapperId, orderByComparator);
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where mapperId = &#63;.
	 *
	 * @param mapperId the mapper ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper fetchByMapperId_Last(
		long mapperId, OrderByComparator<MOIIdMapper> orderByComparator) {

		return getPersistence().fetchByMapperId_Last(
			mapperId, orderByComparator);
	}

	/**
	 * Removes all the moi ID mappers where mapperId = &#63; from the database.
	 *
	 * @param mapperId the mapper ID
	 */
	public static void removeByMapperId(long mapperId) {
		getPersistence().removeByMapperId(mapperId);
	}

	/**
	 * Returns the number of moi ID mappers where mapperId = &#63;.
	 *
	 * @param mapperId the mapper ID
	 * @return the number of matching moi ID mappers
	 */
	public static int countByMapperId(long mapperId) {
		return getPersistence().countByMapperId(mapperId);
	}

	/**
	 * Returns all the moi ID mappers where mosipCurrentState = &#63;.
	 *
	 * @param mosipCurrentState the mosip current state
	 * @return the matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByMosipCurrentState(
		String mosipCurrentState) {

		return getPersistence().findByMosipCurrentState(mosipCurrentState);
	}

	/**
	 * Returns a range of all the moi ID mappers where mosipCurrentState = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param mosipCurrentState the mosip current state
	 * @param start the lower bound of the range of moi ID mappers
	 * @param end the upper bound of the range of moi ID mappers (not inclusive)
	 * @return the range of matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByMosipCurrentState(
		String mosipCurrentState, int start, int end) {

		return getPersistence().findByMosipCurrentState(
			mosipCurrentState, start, end);
	}

	/**
	 * Returns an ordered range of all the moi ID mappers where mosipCurrentState = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param mosipCurrentState the mosip current state
	 * @param start the lower bound of the range of moi ID mappers
	 * @param end the upper bound of the range of moi ID mappers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByMosipCurrentState(
		String mosipCurrentState, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator) {

		return getPersistence().findByMosipCurrentState(
			mosipCurrentState, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the moi ID mappers where mosipCurrentState = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param mosipCurrentState the mosip current state
	 * @param start the lower bound of the range of moi ID mappers
	 * @param end the upper bound of the range of moi ID mappers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByMosipCurrentState(
		String mosipCurrentState, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByMosipCurrentState(
			mosipCurrentState, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where mosipCurrentState = &#63;.
	 *
	 * @param mosipCurrentState the mosip current state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper findByMosipCurrentState_First(
			String mosipCurrentState,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws com.moi.dms.id.mapper.exception.NoSuchMOIIdMapperException {

		return getPersistence().findByMosipCurrentState_First(
			mosipCurrentState, orderByComparator);
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where mosipCurrentState = &#63;.
	 *
	 * @param mosipCurrentState the mosip current state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper fetchByMosipCurrentState_First(
		String mosipCurrentState,
		OrderByComparator<MOIIdMapper> orderByComparator) {

		return getPersistence().fetchByMosipCurrentState_First(
			mosipCurrentState, orderByComparator);
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where mosipCurrentState = &#63;.
	 *
	 * @param mosipCurrentState the mosip current state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper findByMosipCurrentState_Last(
			String mosipCurrentState,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws com.moi.dms.id.mapper.exception.NoSuchMOIIdMapperException {

		return getPersistence().findByMosipCurrentState_Last(
			mosipCurrentState, orderByComparator);
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where mosipCurrentState = &#63;.
	 *
	 * @param mosipCurrentState the mosip current state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper fetchByMosipCurrentState_Last(
		String mosipCurrentState,
		OrderByComparator<MOIIdMapper> orderByComparator) {

		return getPersistence().fetchByMosipCurrentState_Last(
			mosipCurrentState, orderByComparator);
	}

	/**
	 * Returns the moi ID mappers before and after the current moi ID mapper in the ordered set where mosipCurrentState = &#63;.
	 *
	 * @param mapperId the primary key of the current moi ID mapper
	 * @param mosipCurrentState the mosip current state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a moi ID mapper with the primary key could not be found
	 */
	public static MOIIdMapper[] findByMosipCurrentState_PrevAndNext(
			long mapperId, String mosipCurrentState,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws com.moi.dms.id.mapper.exception.NoSuchMOIIdMapperException {

		return getPersistence().findByMosipCurrentState_PrevAndNext(
			mapperId, mosipCurrentState, orderByComparator);
	}

	/**
	 * Removes all the moi ID mappers where mosipCurrentState = &#63; from the database.
	 *
	 * @param mosipCurrentState the mosip current state
	 */
	public static void removeByMosipCurrentState(String mosipCurrentState) {
		getPersistence().removeByMosipCurrentState(mosipCurrentState);
	}

	/**
	 * Returns the number of moi ID mappers where mosipCurrentState = &#63;.
	 *
	 * @param mosipCurrentState the mosip current state
	 * @return the number of matching moi ID mappers
	 */
	public static int countByMosipCurrentState(String mosipCurrentState) {
		return getPersistence().countByMosipCurrentState(mosipCurrentState);
	}

	/**
	 * Returns all the moi ID mappers where mosipDocumentType = &#63;.
	 *
	 * @param mosipDocumentType the mosip document type
	 * @return the matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByMosipDocumentType(
		String mosipDocumentType) {

		return getPersistence().findByMosipDocumentType(mosipDocumentType);
	}

	/**
	 * Returns a range of all the moi ID mappers where mosipDocumentType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param mosipDocumentType the mosip document type
	 * @param start the lower bound of the range of moi ID mappers
	 * @param end the upper bound of the range of moi ID mappers (not inclusive)
	 * @return the range of matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByMosipDocumentType(
		String mosipDocumentType, int start, int end) {

		return getPersistence().findByMosipDocumentType(
			mosipDocumentType, start, end);
	}

	/**
	 * Returns an ordered range of all the moi ID mappers where mosipDocumentType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param mosipDocumentType the mosip document type
	 * @param start the lower bound of the range of moi ID mappers
	 * @param end the upper bound of the range of moi ID mappers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByMosipDocumentType(
		String mosipDocumentType, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator) {

		return getPersistence().findByMosipDocumentType(
			mosipDocumentType, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the moi ID mappers where mosipDocumentType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param mosipDocumentType the mosip document type
	 * @param start the lower bound of the range of moi ID mappers
	 * @param end the upper bound of the range of moi ID mappers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByMosipDocumentType(
		String mosipDocumentType, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByMosipDocumentType(
			mosipDocumentType, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where mosipDocumentType = &#63;.
	 *
	 * @param mosipDocumentType the mosip document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper findByMosipDocumentType_First(
			String mosipDocumentType,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws com.moi.dms.id.mapper.exception.NoSuchMOIIdMapperException {

		return getPersistence().findByMosipDocumentType_First(
			mosipDocumentType, orderByComparator);
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where mosipDocumentType = &#63;.
	 *
	 * @param mosipDocumentType the mosip document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper fetchByMosipDocumentType_First(
		String mosipDocumentType,
		OrderByComparator<MOIIdMapper> orderByComparator) {

		return getPersistence().fetchByMosipDocumentType_First(
			mosipDocumentType, orderByComparator);
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where mosipDocumentType = &#63;.
	 *
	 * @param mosipDocumentType the mosip document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper findByMosipDocumentType_Last(
			String mosipDocumentType,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws com.moi.dms.id.mapper.exception.NoSuchMOIIdMapperException {

		return getPersistence().findByMosipDocumentType_Last(
			mosipDocumentType, orderByComparator);
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where mosipDocumentType = &#63;.
	 *
	 * @param mosipDocumentType the mosip document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper fetchByMosipDocumentType_Last(
		String mosipDocumentType,
		OrderByComparator<MOIIdMapper> orderByComparator) {

		return getPersistence().fetchByMosipDocumentType_Last(
			mosipDocumentType, orderByComparator);
	}

	/**
	 * Returns the moi ID mappers before and after the current moi ID mapper in the ordered set where mosipDocumentType = &#63;.
	 *
	 * @param mapperId the primary key of the current moi ID mapper
	 * @param mosipDocumentType the mosip document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a moi ID mapper with the primary key could not be found
	 */
	public static MOIIdMapper[] findByMosipDocumentType_PrevAndNext(
			long mapperId, String mosipDocumentType,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws com.moi.dms.id.mapper.exception.NoSuchMOIIdMapperException {

		return getPersistence().findByMosipDocumentType_PrevAndNext(
			mapperId, mosipDocumentType, orderByComparator);
	}

	/**
	 * Removes all the moi ID mappers where mosipDocumentType = &#63; from the database.
	 *
	 * @param mosipDocumentType the mosip document type
	 */
	public static void removeByMosipDocumentType(String mosipDocumentType) {
		getPersistence().removeByMosipDocumentType(mosipDocumentType);
	}

	/**
	 * Returns the number of moi ID mappers where mosipDocumentType = &#63;.
	 *
	 * @param mosipDocumentType the mosip document type
	 * @return the number of matching moi ID mappers
	 */
	public static int countByMosipDocumentType(String mosipDocumentType) {
		return getPersistence().countByMosipDocumentType(mosipDocumentType);
	}

	/**
	 * Returns all the moi ID mappers where registrationId = &#63;.
	 *
	 * @param registrationId the registration ID
	 * @return the matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByRegistrationId(
		String registrationId) {

		return getPersistence().findByRegistrationId(registrationId);
	}

	/**
	 * Returns a range of all the moi ID mappers where registrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param registrationId the registration ID
	 * @param start the lower bound of the range of moi ID mappers
	 * @param end the upper bound of the range of moi ID mappers (not inclusive)
	 * @return the range of matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByRegistrationId(
		String registrationId, int start, int end) {

		return getPersistence().findByRegistrationId(
			registrationId, start, end);
	}

	/**
	 * Returns an ordered range of all the moi ID mappers where registrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param registrationId the registration ID
	 * @param start the lower bound of the range of moi ID mappers
	 * @param end the upper bound of the range of moi ID mappers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByRegistrationId(
		String registrationId, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator) {

		return getPersistence().findByRegistrationId(
			registrationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the moi ID mappers where registrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param registrationId the registration ID
	 * @param start the lower bound of the range of moi ID mappers
	 * @param end the upper bound of the range of moi ID mappers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByRegistrationId(
		String registrationId, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRegistrationId(
			registrationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where registrationId = &#63;.
	 *
	 * @param registrationId the registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper findByRegistrationId_First(
			String registrationId,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws com.moi.dms.id.mapper.exception.NoSuchMOIIdMapperException {

		return getPersistence().findByRegistrationId_First(
			registrationId, orderByComparator);
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where registrationId = &#63;.
	 *
	 * @param registrationId the registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper fetchByRegistrationId_First(
		String registrationId,
		OrderByComparator<MOIIdMapper> orderByComparator) {

		return getPersistence().fetchByRegistrationId_First(
			registrationId, orderByComparator);
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where registrationId = &#63;.
	 *
	 * @param registrationId the registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper findByRegistrationId_Last(
			String registrationId,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws com.moi.dms.id.mapper.exception.NoSuchMOIIdMapperException {

		return getPersistence().findByRegistrationId_Last(
			registrationId, orderByComparator);
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where registrationId = &#63;.
	 *
	 * @param registrationId the registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper fetchByRegistrationId_Last(
		String registrationId,
		OrderByComparator<MOIIdMapper> orderByComparator) {

		return getPersistence().fetchByRegistrationId_Last(
			registrationId, orderByComparator);
	}

	/**
	 * Returns the moi ID mappers before and after the current moi ID mapper in the ordered set where registrationId = &#63;.
	 *
	 * @param mapperId the primary key of the current moi ID mapper
	 * @param registrationId the registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a moi ID mapper with the primary key could not be found
	 */
	public static MOIIdMapper[] findByRegistrationId_PrevAndNext(
			long mapperId, String registrationId,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws com.moi.dms.id.mapper.exception.NoSuchMOIIdMapperException {

		return getPersistence().findByRegistrationId_PrevAndNext(
			mapperId, registrationId, orderByComparator);
	}

	/**
	 * Removes all the moi ID mappers where registrationId = &#63; from the database.
	 *
	 * @param registrationId the registration ID
	 */
	public static void removeByRegistrationId(String registrationId) {
		getPersistence().removeByRegistrationId(registrationId);
	}

	/**
	 * Returns the number of moi ID mappers where registrationId = &#63;.
	 *
	 * @param registrationId the registration ID
	 * @return the number of matching moi ID mappers
	 */
	public static int countByRegistrationId(String registrationId) {
		return getPersistence().countByRegistrationId(registrationId);
	}

	/**
	 * Returns the moi ID mapper where registrationId = &#63; and mosipCurrentState = &#63; or throws a <code>NoSuchMOIIdMapperException</code> if it could not be found.
	 *
	 * @param registrationId the registration ID
	 * @param mosipCurrentState the mosip current state
	 * @return the matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper findByRegistrationIdCurrentState(
			String registrationId, String mosipCurrentState)
		throws com.moi.dms.id.mapper.exception.NoSuchMOIIdMapperException {

		return getPersistence().findByRegistrationIdCurrentState(
			registrationId, mosipCurrentState);
	}

	/**
	 * Returns the moi ID mapper where registrationId = &#63; and mosipCurrentState = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param registrationId the registration ID
	 * @param mosipCurrentState the mosip current state
	 * @return the matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper fetchByRegistrationIdCurrentState(
		String registrationId, String mosipCurrentState) {

		return getPersistence().fetchByRegistrationIdCurrentState(
			registrationId, mosipCurrentState);
	}

	/**
	 * Returns the moi ID mapper where registrationId = &#63; and mosipCurrentState = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param registrationId the registration ID
	 * @param mosipCurrentState the mosip current state
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper fetchByRegistrationIdCurrentState(
		String registrationId, String mosipCurrentState,
		boolean useFinderCache) {

		return getPersistence().fetchByRegistrationIdCurrentState(
			registrationId, mosipCurrentState, useFinderCache);
	}

	/**
	 * Removes the moi ID mapper where registrationId = &#63; and mosipCurrentState = &#63; from the database.
	 *
	 * @param registrationId the registration ID
	 * @param mosipCurrentState the mosip current state
	 * @return the moi ID mapper that was removed
	 */
	public static MOIIdMapper removeByRegistrationIdCurrentState(
			String registrationId, String mosipCurrentState)
		throws com.moi.dms.id.mapper.exception.NoSuchMOIIdMapperException {

		return getPersistence().removeByRegistrationIdCurrentState(
			registrationId, mosipCurrentState);
	}

	/**
	 * Returns the number of moi ID mappers where registrationId = &#63; and mosipCurrentState = &#63;.
	 *
	 * @param registrationId the registration ID
	 * @param mosipCurrentState the mosip current state
	 * @return the number of matching moi ID mappers
	 */
	public static int countByRegistrationIdCurrentState(
		String registrationId, String mosipCurrentState) {

		return getPersistence().countByRegistrationIdCurrentState(
			registrationId, mosipCurrentState);
	}

	/**
	 * Returns all the moi ID mappers where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @return the matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByResourceId(long resourceId) {
		return getPersistence().findByResourceId(resourceId);
	}

	/**
	 * Returns a range of all the moi ID mappers where resourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param resourceId the resource ID
	 * @param start the lower bound of the range of moi ID mappers
	 * @param end the upper bound of the range of moi ID mappers (not inclusive)
	 * @return the range of matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByResourceId(
		long resourceId, int start, int end) {

		return getPersistence().findByResourceId(resourceId, start, end);
	}

	/**
	 * Returns an ordered range of all the moi ID mappers where resourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param resourceId the resource ID
	 * @param start the lower bound of the range of moi ID mappers
	 * @param end the upper bound of the range of moi ID mappers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByResourceId(
		long resourceId, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator) {

		return getPersistence().findByResourceId(
			resourceId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the moi ID mappers where resourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param resourceId the resource ID
	 * @param start the lower bound of the range of moi ID mappers
	 * @param end the upper bound of the range of moi ID mappers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByResourceId(
		long resourceId, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByResourceId(
			resourceId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper findByResourceId_First(
			long resourceId, OrderByComparator<MOIIdMapper> orderByComparator)
		throws com.moi.dms.id.mapper.exception.NoSuchMOIIdMapperException {

		return getPersistence().findByResourceId_First(
			resourceId, orderByComparator);
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper fetchByResourceId_First(
		long resourceId, OrderByComparator<MOIIdMapper> orderByComparator) {

		return getPersistence().fetchByResourceId_First(
			resourceId, orderByComparator);
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper findByResourceId_Last(
			long resourceId, OrderByComparator<MOIIdMapper> orderByComparator)
		throws com.moi.dms.id.mapper.exception.NoSuchMOIIdMapperException {

		return getPersistence().findByResourceId_Last(
			resourceId, orderByComparator);
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper fetchByResourceId_Last(
		long resourceId, OrderByComparator<MOIIdMapper> orderByComparator) {

		return getPersistence().fetchByResourceId_Last(
			resourceId, orderByComparator);
	}

	/**
	 * Returns the moi ID mappers before and after the current moi ID mapper in the ordered set where resourceId = &#63;.
	 *
	 * @param mapperId the primary key of the current moi ID mapper
	 * @param resourceId the resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a moi ID mapper with the primary key could not be found
	 */
	public static MOIIdMapper[] findByResourceId_PrevAndNext(
			long mapperId, long resourceId,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws com.moi.dms.id.mapper.exception.NoSuchMOIIdMapperException {

		return getPersistence().findByResourceId_PrevAndNext(
			mapperId, resourceId, orderByComparator);
	}

	/**
	 * Removes all the moi ID mappers where resourceId = &#63; from the database.
	 *
	 * @param resourceId the resource ID
	 */
	public static void removeByResourceId(long resourceId) {
		getPersistence().removeByResourceId(resourceId);
	}

	/**
	 * Returns the number of moi ID mappers where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @return the number of matching moi ID mappers
	 */
	public static int countByResourceId(long resourceId) {
		return getPersistence().countByResourceId(resourceId);
	}

	/**
	 * Returns all the moi ID mappers where documentTitle = &#63;.
	 *
	 * @param documentTitle the document title
	 * @return the matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByDocumentTitle(String documentTitle) {
		return getPersistence().findByDocumentTitle(documentTitle);
	}

	/**
	 * Returns a range of all the moi ID mappers where documentTitle = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param documentTitle the document title
	 * @param start the lower bound of the range of moi ID mappers
	 * @param end the upper bound of the range of moi ID mappers (not inclusive)
	 * @return the range of matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByDocumentTitle(
		String documentTitle, int start, int end) {

		return getPersistence().findByDocumentTitle(documentTitle, start, end);
	}

	/**
	 * Returns an ordered range of all the moi ID mappers where documentTitle = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param documentTitle the document title
	 * @param start the lower bound of the range of moi ID mappers
	 * @param end the upper bound of the range of moi ID mappers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByDocumentTitle(
		String documentTitle, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator) {

		return getPersistence().findByDocumentTitle(
			documentTitle, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the moi ID mappers where documentTitle = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param documentTitle the document title
	 * @param start the lower bound of the range of moi ID mappers
	 * @param end the upper bound of the range of moi ID mappers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByDocumentTitle(
		String documentTitle, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDocumentTitle(
			documentTitle, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where documentTitle = &#63;.
	 *
	 * @param documentTitle the document title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper findByDocumentTitle_First(
			String documentTitle,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws com.moi.dms.id.mapper.exception.NoSuchMOIIdMapperException {

		return getPersistence().findByDocumentTitle_First(
			documentTitle, orderByComparator);
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where documentTitle = &#63;.
	 *
	 * @param documentTitle the document title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper fetchByDocumentTitle_First(
		String documentTitle,
		OrderByComparator<MOIIdMapper> orderByComparator) {

		return getPersistence().fetchByDocumentTitle_First(
			documentTitle, orderByComparator);
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where documentTitle = &#63;.
	 *
	 * @param documentTitle the document title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper findByDocumentTitle_Last(
			String documentTitle,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws com.moi.dms.id.mapper.exception.NoSuchMOIIdMapperException {

		return getPersistence().findByDocumentTitle_Last(
			documentTitle, orderByComparator);
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where documentTitle = &#63;.
	 *
	 * @param documentTitle the document title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper fetchByDocumentTitle_Last(
		String documentTitle,
		OrderByComparator<MOIIdMapper> orderByComparator) {

		return getPersistence().fetchByDocumentTitle_Last(
			documentTitle, orderByComparator);
	}

	/**
	 * Returns the moi ID mappers before and after the current moi ID mapper in the ordered set where documentTitle = &#63;.
	 *
	 * @param mapperId the primary key of the current moi ID mapper
	 * @param documentTitle the document title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a moi ID mapper with the primary key could not be found
	 */
	public static MOIIdMapper[] findByDocumentTitle_PrevAndNext(
			long mapperId, String documentTitle,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws com.moi.dms.id.mapper.exception.NoSuchMOIIdMapperException {

		return getPersistence().findByDocumentTitle_PrevAndNext(
			mapperId, documentTitle, orderByComparator);
	}

	/**
	 * Removes all the moi ID mappers where documentTitle = &#63; from the database.
	 *
	 * @param documentTitle the document title
	 */
	public static void removeByDocumentTitle(String documentTitle) {
		getPersistence().removeByDocumentTitle(documentTitle);
	}

	/**
	 * Returns the number of moi ID mappers where documentTitle = &#63;.
	 *
	 * @param documentTitle the document title
	 * @return the number of matching moi ID mappers
	 */
	public static int countByDocumentTitle(String documentTitle) {
		return getPersistence().countByDocumentTitle(documentTitle);
	}

	/**
	 * Returns all the moi ID mappers where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @return the matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByFileEntryId(String fileEntryId) {
		return getPersistence().findByFileEntryId(fileEntryId);
	}

	/**
	 * Returns a range of all the moi ID mappers where fileEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param fileEntryId the file entry ID
	 * @param start the lower bound of the range of moi ID mappers
	 * @param end the upper bound of the range of moi ID mappers (not inclusive)
	 * @return the range of matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByFileEntryId(
		String fileEntryId, int start, int end) {

		return getPersistence().findByFileEntryId(fileEntryId, start, end);
	}

	/**
	 * Returns an ordered range of all the moi ID mappers where fileEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param fileEntryId the file entry ID
	 * @param start the lower bound of the range of moi ID mappers
	 * @param end the upper bound of the range of moi ID mappers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByFileEntryId(
		String fileEntryId, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator) {

		return getPersistence().findByFileEntryId(
			fileEntryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the moi ID mappers where fileEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param fileEntryId the file entry ID
	 * @param start the lower bound of the range of moi ID mappers
	 * @param end the upper bound of the range of moi ID mappers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByFileEntryId(
		String fileEntryId, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFileEntryId(
			fileEntryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper findByFileEntryId_First(
			String fileEntryId,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws com.moi.dms.id.mapper.exception.NoSuchMOIIdMapperException {

		return getPersistence().findByFileEntryId_First(
			fileEntryId, orderByComparator);
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper fetchByFileEntryId_First(
		String fileEntryId, OrderByComparator<MOIIdMapper> orderByComparator) {

		return getPersistence().fetchByFileEntryId_First(
			fileEntryId, orderByComparator);
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper findByFileEntryId_Last(
			String fileEntryId,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws com.moi.dms.id.mapper.exception.NoSuchMOIIdMapperException {

		return getPersistence().findByFileEntryId_Last(
			fileEntryId, orderByComparator);
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper fetchByFileEntryId_Last(
		String fileEntryId, OrderByComparator<MOIIdMapper> orderByComparator) {

		return getPersistence().fetchByFileEntryId_Last(
			fileEntryId, orderByComparator);
	}

	/**
	 * Returns the moi ID mappers before and after the current moi ID mapper in the ordered set where fileEntryId = &#63;.
	 *
	 * @param mapperId the primary key of the current moi ID mapper
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a moi ID mapper with the primary key could not be found
	 */
	public static MOIIdMapper[] findByFileEntryId_PrevAndNext(
			long mapperId, String fileEntryId,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws com.moi.dms.id.mapper.exception.NoSuchMOIIdMapperException {

		return getPersistence().findByFileEntryId_PrevAndNext(
			mapperId, fileEntryId, orderByComparator);
	}

	/**
	 * Removes all the moi ID mappers where fileEntryId = &#63; from the database.
	 *
	 * @param fileEntryId the file entry ID
	 */
	public static void removeByFileEntryId(String fileEntryId) {
		getPersistence().removeByFileEntryId(fileEntryId);
	}

	/**
	 * Returns the number of moi ID mappers where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @return the number of matching moi ID mappers
	 */
	public static int countByFileEntryId(String fileEntryId) {
		return getPersistence().countByFileEntryId(fileEntryId);
	}

	/**
	 * Returns all the moi ID mappers where updateDate = &#63;.
	 *
	 * @param updateDate the update date
	 * @return the matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByUpdateDate(Date updateDate) {
		return getPersistence().findByUpdateDate(updateDate);
	}

	/**
	 * Returns a range of all the moi ID mappers where updateDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param updateDate the update date
	 * @param start the lower bound of the range of moi ID mappers
	 * @param end the upper bound of the range of moi ID mappers (not inclusive)
	 * @return the range of matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByUpdateDate(
		Date updateDate, int start, int end) {

		return getPersistence().findByUpdateDate(updateDate, start, end);
	}

	/**
	 * Returns an ordered range of all the moi ID mappers where updateDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param updateDate the update date
	 * @param start the lower bound of the range of moi ID mappers
	 * @param end the upper bound of the range of moi ID mappers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByUpdateDate(
		Date updateDate, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator) {

		return getPersistence().findByUpdateDate(
			updateDate, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the moi ID mappers where updateDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param updateDate the update date
	 * @param start the lower bound of the range of moi ID mappers
	 * @param end the upper bound of the range of moi ID mappers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByUpdateDate(
		Date updateDate, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUpdateDate(
			updateDate, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where updateDate = &#63;.
	 *
	 * @param updateDate the update date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper findByUpdateDate_First(
			Date updateDate, OrderByComparator<MOIIdMapper> orderByComparator)
		throws com.moi.dms.id.mapper.exception.NoSuchMOIIdMapperException {

		return getPersistence().findByUpdateDate_First(
			updateDate, orderByComparator);
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where updateDate = &#63;.
	 *
	 * @param updateDate the update date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper fetchByUpdateDate_First(
		Date updateDate, OrderByComparator<MOIIdMapper> orderByComparator) {

		return getPersistence().fetchByUpdateDate_First(
			updateDate, orderByComparator);
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where updateDate = &#63;.
	 *
	 * @param updateDate the update date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper findByUpdateDate_Last(
			Date updateDate, OrderByComparator<MOIIdMapper> orderByComparator)
		throws com.moi.dms.id.mapper.exception.NoSuchMOIIdMapperException {

		return getPersistence().findByUpdateDate_Last(
			updateDate, orderByComparator);
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where updateDate = &#63;.
	 *
	 * @param updateDate the update date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper fetchByUpdateDate_Last(
		Date updateDate, OrderByComparator<MOIIdMapper> orderByComparator) {

		return getPersistence().fetchByUpdateDate_Last(
			updateDate, orderByComparator);
	}

	/**
	 * Returns the moi ID mappers before and after the current moi ID mapper in the ordered set where updateDate = &#63;.
	 *
	 * @param mapperId the primary key of the current moi ID mapper
	 * @param updateDate the update date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a moi ID mapper with the primary key could not be found
	 */
	public static MOIIdMapper[] findByUpdateDate_PrevAndNext(
			long mapperId, Date updateDate,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws com.moi.dms.id.mapper.exception.NoSuchMOIIdMapperException {

		return getPersistence().findByUpdateDate_PrevAndNext(
			mapperId, updateDate, orderByComparator);
	}

	/**
	 * Removes all the moi ID mappers where updateDate = &#63; from the database.
	 *
	 * @param updateDate the update date
	 */
	public static void removeByUpdateDate(Date updateDate) {
		getPersistence().removeByUpdateDate(updateDate);
	}

	/**
	 * Returns the number of moi ID mappers where updateDate = &#63;.
	 *
	 * @param updateDate the update date
	 * @return the number of matching moi ID mappers
	 */
	public static int countByUpdateDate(Date updateDate) {
		return getPersistence().countByUpdateDate(updateDate);
	}

	/**
	 * Returns all the moi ID mappers where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @return the matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByUpdatedBy(String updatedBy) {
		return getPersistence().findByUpdatedBy(updatedBy);
	}

	/**
	 * Returns a range of all the moi ID mappers where updatedBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param updatedBy the updated by
	 * @param start the lower bound of the range of moi ID mappers
	 * @param end the upper bound of the range of moi ID mappers (not inclusive)
	 * @return the range of matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByUpdatedBy(
		String updatedBy, int start, int end) {

		return getPersistence().findByUpdatedBy(updatedBy, start, end);
	}

	/**
	 * Returns an ordered range of all the moi ID mappers where updatedBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param updatedBy the updated by
	 * @param start the lower bound of the range of moi ID mappers
	 * @param end the upper bound of the range of moi ID mappers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByUpdatedBy(
		String updatedBy, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator) {

		return getPersistence().findByUpdatedBy(
			updatedBy, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the moi ID mappers where updatedBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param updatedBy the updated by
	 * @param start the lower bound of the range of moi ID mappers
	 * @param end the upper bound of the range of moi ID mappers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching moi ID mappers
	 */
	public static List<MOIIdMapper> findByUpdatedBy(
		String updatedBy, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUpdatedBy(
			updatedBy, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper findByUpdatedBy_First(
			String updatedBy, OrderByComparator<MOIIdMapper> orderByComparator)
		throws com.moi.dms.id.mapper.exception.NoSuchMOIIdMapperException {

		return getPersistence().findByUpdatedBy_First(
			updatedBy, orderByComparator);
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper fetchByUpdatedBy_First(
		String updatedBy, OrderByComparator<MOIIdMapper> orderByComparator) {

		return getPersistence().fetchByUpdatedBy_First(
			updatedBy, orderByComparator);
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper findByUpdatedBy_Last(
			String updatedBy, OrderByComparator<MOIIdMapper> orderByComparator)
		throws com.moi.dms.id.mapper.exception.NoSuchMOIIdMapperException {

		return getPersistence().findByUpdatedBy_Last(
			updatedBy, orderByComparator);
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public static MOIIdMapper fetchByUpdatedBy_Last(
		String updatedBy, OrderByComparator<MOIIdMapper> orderByComparator) {

		return getPersistence().fetchByUpdatedBy_Last(
			updatedBy, orderByComparator);
	}

	/**
	 * Returns the moi ID mappers before and after the current moi ID mapper in the ordered set where updatedBy = &#63;.
	 *
	 * @param mapperId the primary key of the current moi ID mapper
	 * @param updatedBy the updated by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a moi ID mapper with the primary key could not be found
	 */
	public static MOIIdMapper[] findByUpdatedBy_PrevAndNext(
			long mapperId, String updatedBy,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws com.moi.dms.id.mapper.exception.NoSuchMOIIdMapperException {

		return getPersistence().findByUpdatedBy_PrevAndNext(
			mapperId, updatedBy, orderByComparator);
	}

	/**
	 * Removes all the moi ID mappers where updatedBy = &#63; from the database.
	 *
	 * @param updatedBy the updated by
	 */
	public static void removeByUpdatedBy(String updatedBy) {
		getPersistence().removeByUpdatedBy(updatedBy);
	}

	/**
	 * Returns the number of moi ID mappers where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @return the number of matching moi ID mappers
	 */
	public static int countByUpdatedBy(String updatedBy) {
		return getPersistence().countByUpdatedBy(updatedBy);
	}

	/**
	 * Caches the moi ID mapper in the entity cache if it is enabled.
	 *
	 * @param moiIdMapper the moi ID mapper
	 */
	public static void cacheResult(MOIIdMapper moiIdMapper) {
		getPersistence().cacheResult(moiIdMapper);
	}

	/**
	 * Caches the moi ID mappers in the entity cache if it is enabled.
	 *
	 * @param moiIdMappers the moi ID mappers
	 */
	public static void cacheResult(List<MOIIdMapper> moiIdMappers) {
		getPersistence().cacheResult(moiIdMappers);
	}

	/**
	 * Creates a new moi ID mapper with the primary key. Does not add the moi ID mapper to the database.
	 *
	 * @param mapperId the primary key for the new moi ID mapper
	 * @return the new moi ID mapper
	 */
	public static MOIIdMapper create(long mapperId) {
		return getPersistence().create(mapperId);
	}

	/**
	 * Removes the moi ID mapper with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mapperId the primary key of the moi ID mapper
	 * @return the moi ID mapper that was removed
	 * @throws NoSuchMOIIdMapperException if a moi ID mapper with the primary key could not be found
	 */
	public static MOIIdMapper remove(long mapperId)
		throws com.moi.dms.id.mapper.exception.NoSuchMOIIdMapperException {

		return getPersistence().remove(mapperId);
	}

	public static MOIIdMapper updateImpl(MOIIdMapper moiIdMapper) {
		return getPersistence().updateImpl(moiIdMapper);
	}

	/**
	 * Returns the moi ID mapper with the primary key or throws a <code>NoSuchMOIIdMapperException</code> if it could not be found.
	 *
	 * @param mapperId the primary key of the moi ID mapper
	 * @return the moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a moi ID mapper with the primary key could not be found
	 */
	public static MOIIdMapper findByPrimaryKey(long mapperId)
		throws com.moi.dms.id.mapper.exception.NoSuchMOIIdMapperException {

		return getPersistence().findByPrimaryKey(mapperId);
	}

	/**
	 * Returns the moi ID mapper with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mapperId the primary key of the moi ID mapper
	 * @return the moi ID mapper, or <code>null</code> if a moi ID mapper with the primary key could not be found
	 */
	public static MOIIdMapper fetchByPrimaryKey(long mapperId) {
		return getPersistence().fetchByPrimaryKey(mapperId);
	}

	/**
	 * Returns all the moi ID mappers.
	 *
	 * @return the moi ID mappers
	 */
	public static List<MOIIdMapper> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the moi ID mappers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of moi ID mappers
	 * @param end the upper bound of the range of moi ID mappers (not inclusive)
	 * @return the range of moi ID mappers
	 */
	public static List<MOIIdMapper> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the moi ID mappers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of moi ID mappers
	 * @param end the upper bound of the range of moi ID mappers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of moi ID mappers
	 */
	public static List<MOIIdMapper> findAll(
		int start, int end, OrderByComparator<MOIIdMapper> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the moi ID mappers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MOIIdMapperModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of moi ID mappers
	 * @param end the upper bound of the range of moi ID mappers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of moi ID mappers
	 */
	public static List<MOIIdMapper> findAll(
		int start, int end, OrderByComparator<MOIIdMapper> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the moi ID mappers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of moi ID mappers.
	 *
	 * @return the number of moi ID mappers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MOIIdMapperPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<MOIIdMapperPersistence, MOIIdMapperPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MOIIdMapperPersistence.class);

		ServiceTracker<MOIIdMapperPersistence, MOIIdMapperPersistence>
			serviceTracker =
				new ServiceTracker
					<MOIIdMapperPersistence, MOIIdMapperPersistence>(
						bundle.getBundleContext(), MOIIdMapperPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}