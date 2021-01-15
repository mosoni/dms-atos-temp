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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.moi.dms.id.mapper.exception.NoSuchMOIIdMapperException;
import com.moi.dms.id.mapper.model.MOIIdMapper;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the moi ID mapper service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MOIIdMapperUtil
 * @generated
 */
@ProviderType
public interface MOIIdMapperPersistence extends BasePersistence<MOIIdMapper> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MOIIdMapperUtil} to access the moi ID mapper persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the moi ID mappers where mapperId = &#63;.
	 *
	 * @param mapperId the mapper ID
	 * @return the matching moi ID mappers
	 */
	public java.util.List<MOIIdMapper> findByMapperId(long mapperId);

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
	public java.util.List<MOIIdMapper> findByMapperId(
		long mapperId, int start, int end);

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
	public java.util.List<MOIIdMapper> findByMapperId(
		long mapperId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator);

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
	public java.util.List<MOIIdMapper> findByMapperId(
		long mapperId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi ID mapper in the ordered set where mapperId = &#63;.
	 *
	 * @param mapperId the mapper ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper findByMapperId_First(
			long mapperId,
			com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
				orderByComparator)
		throws NoSuchMOIIdMapperException;

	/**
	 * Returns the first moi ID mapper in the ordered set where mapperId = &#63;.
	 *
	 * @param mapperId the mapper ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper fetchByMapperId_First(
		long mapperId,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator);

	/**
	 * Returns the last moi ID mapper in the ordered set where mapperId = &#63;.
	 *
	 * @param mapperId the mapper ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper findByMapperId_Last(
			long mapperId,
			com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
				orderByComparator)
		throws NoSuchMOIIdMapperException;

	/**
	 * Returns the last moi ID mapper in the ordered set where mapperId = &#63;.
	 *
	 * @param mapperId the mapper ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper fetchByMapperId_Last(
		long mapperId,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator);

	/**
	 * Removes all the moi ID mappers where mapperId = &#63; from the database.
	 *
	 * @param mapperId the mapper ID
	 */
	public void removeByMapperId(long mapperId);

	/**
	 * Returns the number of moi ID mappers where mapperId = &#63;.
	 *
	 * @param mapperId the mapper ID
	 * @return the number of matching moi ID mappers
	 */
	public int countByMapperId(long mapperId);

	/**
	 * Returns all the moi ID mappers where mosipCurrentState = &#63;.
	 *
	 * @param mosipCurrentState the mosip current state
	 * @return the matching moi ID mappers
	 */
	public java.util.List<MOIIdMapper> findByMosipCurrentState(
		String mosipCurrentState);

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
	public java.util.List<MOIIdMapper> findByMosipCurrentState(
		String mosipCurrentState, int start, int end);

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
	public java.util.List<MOIIdMapper> findByMosipCurrentState(
		String mosipCurrentState, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator);

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
	public java.util.List<MOIIdMapper> findByMosipCurrentState(
		String mosipCurrentState, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi ID mapper in the ordered set where mosipCurrentState = &#63;.
	 *
	 * @param mosipCurrentState the mosip current state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper findByMosipCurrentState_First(
			String mosipCurrentState,
			com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
				orderByComparator)
		throws NoSuchMOIIdMapperException;

	/**
	 * Returns the first moi ID mapper in the ordered set where mosipCurrentState = &#63;.
	 *
	 * @param mosipCurrentState the mosip current state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper fetchByMosipCurrentState_First(
		String mosipCurrentState,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator);

	/**
	 * Returns the last moi ID mapper in the ordered set where mosipCurrentState = &#63;.
	 *
	 * @param mosipCurrentState the mosip current state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper findByMosipCurrentState_Last(
			String mosipCurrentState,
			com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
				orderByComparator)
		throws NoSuchMOIIdMapperException;

	/**
	 * Returns the last moi ID mapper in the ordered set where mosipCurrentState = &#63;.
	 *
	 * @param mosipCurrentState the mosip current state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper fetchByMosipCurrentState_Last(
		String mosipCurrentState,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator);

	/**
	 * Returns the moi ID mappers before and after the current moi ID mapper in the ordered set where mosipCurrentState = &#63;.
	 *
	 * @param mapperId the primary key of the current moi ID mapper
	 * @param mosipCurrentState the mosip current state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a moi ID mapper with the primary key could not be found
	 */
	public MOIIdMapper[] findByMosipCurrentState_PrevAndNext(
			long mapperId, String mosipCurrentState,
			com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
				orderByComparator)
		throws NoSuchMOIIdMapperException;

	/**
	 * Removes all the moi ID mappers where mosipCurrentState = &#63; from the database.
	 *
	 * @param mosipCurrentState the mosip current state
	 */
	public void removeByMosipCurrentState(String mosipCurrentState);

	/**
	 * Returns the number of moi ID mappers where mosipCurrentState = &#63;.
	 *
	 * @param mosipCurrentState the mosip current state
	 * @return the number of matching moi ID mappers
	 */
	public int countByMosipCurrentState(String mosipCurrentState);

	/**
	 * Returns all the moi ID mappers where mosipDocumentType = &#63;.
	 *
	 * @param mosipDocumentType the mosip document type
	 * @return the matching moi ID mappers
	 */
	public java.util.List<MOIIdMapper> findByMosipDocumentType(
		String mosipDocumentType);

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
	public java.util.List<MOIIdMapper> findByMosipDocumentType(
		String mosipDocumentType, int start, int end);

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
	public java.util.List<MOIIdMapper> findByMosipDocumentType(
		String mosipDocumentType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator);

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
	public java.util.List<MOIIdMapper> findByMosipDocumentType(
		String mosipDocumentType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi ID mapper in the ordered set where mosipDocumentType = &#63;.
	 *
	 * @param mosipDocumentType the mosip document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper findByMosipDocumentType_First(
			String mosipDocumentType,
			com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
				orderByComparator)
		throws NoSuchMOIIdMapperException;

	/**
	 * Returns the first moi ID mapper in the ordered set where mosipDocumentType = &#63;.
	 *
	 * @param mosipDocumentType the mosip document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper fetchByMosipDocumentType_First(
		String mosipDocumentType,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator);

	/**
	 * Returns the last moi ID mapper in the ordered set where mosipDocumentType = &#63;.
	 *
	 * @param mosipDocumentType the mosip document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper findByMosipDocumentType_Last(
			String mosipDocumentType,
			com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
				orderByComparator)
		throws NoSuchMOIIdMapperException;

	/**
	 * Returns the last moi ID mapper in the ordered set where mosipDocumentType = &#63;.
	 *
	 * @param mosipDocumentType the mosip document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper fetchByMosipDocumentType_Last(
		String mosipDocumentType,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator);

	/**
	 * Returns the moi ID mappers before and after the current moi ID mapper in the ordered set where mosipDocumentType = &#63;.
	 *
	 * @param mapperId the primary key of the current moi ID mapper
	 * @param mosipDocumentType the mosip document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a moi ID mapper with the primary key could not be found
	 */
	public MOIIdMapper[] findByMosipDocumentType_PrevAndNext(
			long mapperId, String mosipDocumentType,
			com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
				orderByComparator)
		throws NoSuchMOIIdMapperException;

	/**
	 * Removes all the moi ID mappers where mosipDocumentType = &#63; from the database.
	 *
	 * @param mosipDocumentType the mosip document type
	 */
	public void removeByMosipDocumentType(String mosipDocumentType);

	/**
	 * Returns the number of moi ID mappers where mosipDocumentType = &#63;.
	 *
	 * @param mosipDocumentType the mosip document type
	 * @return the number of matching moi ID mappers
	 */
	public int countByMosipDocumentType(String mosipDocumentType);

	/**
	 * Returns all the moi ID mappers where registrationId = &#63;.
	 *
	 * @param registrationId the registration ID
	 * @return the matching moi ID mappers
	 */
	public java.util.List<MOIIdMapper> findByRegistrationId(
		String registrationId);

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
	public java.util.List<MOIIdMapper> findByRegistrationId(
		String registrationId, int start, int end);

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
	public java.util.List<MOIIdMapper> findByRegistrationId(
		String registrationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator);

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
	public java.util.List<MOIIdMapper> findByRegistrationId(
		String registrationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi ID mapper in the ordered set where registrationId = &#63;.
	 *
	 * @param registrationId the registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper findByRegistrationId_First(
			String registrationId,
			com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
				orderByComparator)
		throws NoSuchMOIIdMapperException;

	/**
	 * Returns the first moi ID mapper in the ordered set where registrationId = &#63;.
	 *
	 * @param registrationId the registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper fetchByRegistrationId_First(
		String registrationId,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator);

	/**
	 * Returns the last moi ID mapper in the ordered set where registrationId = &#63;.
	 *
	 * @param registrationId the registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper findByRegistrationId_Last(
			String registrationId,
			com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
				orderByComparator)
		throws NoSuchMOIIdMapperException;

	/**
	 * Returns the last moi ID mapper in the ordered set where registrationId = &#63;.
	 *
	 * @param registrationId the registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper fetchByRegistrationId_Last(
		String registrationId,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator);

	/**
	 * Returns the moi ID mappers before and after the current moi ID mapper in the ordered set where registrationId = &#63;.
	 *
	 * @param mapperId the primary key of the current moi ID mapper
	 * @param registrationId the registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a moi ID mapper with the primary key could not be found
	 */
	public MOIIdMapper[] findByRegistrationId_PrevAndNext(
			long mapperId, String registrationId,
			com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
				orderByComparator)
		throws NoSuchMOIIdMapperException;

	/**
	 * Removes all the moi ID mappers where registrationId = &#63; from the database.
	 *
	 * @param registrationId the registration ID
	 */
	public void removeByRegistrationId(String registrationId);

	/**
	 * Returns the number of moi ID mappers where registrationId = &#63;.
	 *
	 * @param registrationId the registration ID
	 * @return the number of matching moi ID mappers
	 */
	public int countByRegistrationId(String registrationId);

	/**
	 * Returns the moi ID mapper where registrationId = &#63; and mosipCurrentState = &#63; or throws a <code>NoSuchMOIIdMapperException</code> if it could not be found.
	 *
	 * @param registrationId the registration ID
	 * @param mosipCurrentState the mosip current state
	 * @return the matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper findByRegistrationIdCurrentState(
			String registrationId, String mosipCurrentState)
		throws NoSuchMOIIdMapperException;

	/**
	 * Returns the moi ID mapper where registrationId = &#63; and mosipCurrentState = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param registrationId the registration ID
	 * @param mosipCurrentState the mosip current state
	 * @return the matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper fetchByRegistrationIdCurrentState(
		String registrationId, String mosipCurrentState);

	/**
	 * Returns the moi ID mapper where registrationId = &#63; and mosipCurrentState = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param registrationId the registration ID
	 * @param mosipCurrentState the mosip current state
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper fetchByRegistrationIdCurrentState(
		String registrationId, String mosipCurrentState,
		boolean useFinderCache);

	/**
	 * Removes the moi ID mapper where registrationId = &#63; and mosipCurrentState = &#63; from the database.
	 *
	 * @param registrationId the registration ID
	 * @param mosipCurrentState the mosip current state
	 * @return the moi ID mapper that was removed
	 */
	public MOIIdMapper removeByRegistrationIdCurrentState(
			String registrationId, String mosipCurrentState)
		throws NoSuchMOIIdMapperException;

	/**
	 * Returns the number of moi ID mappers where registrationId = &#63; and mosipCurrentState = &#63;.
	 *
	 * @param registrationId the registration ID
	 * @param mosipCurrentState the mosip current state
	 * @return the number of matching moi ID mappers
	 */
	public int countByRegistrationIdCurrentState(
		String registrationId, String mosipCurrentState);

	/**
	 * Returns all the moi ID mappers where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @return the matching moi ID mappers
	 */
	public java.util.List<MOIIdMapper> findByResourceId(long resourceId);

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
	public java.util.List<MOIIdMapper> findByResourceId(
		long resourceId, int start, int end);

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
	public java.util.List<MOIIdMapper> findByResourceId(
		long resourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator);

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
	public java.util.List<MOIIdMapper> findByResourceId(
		long resourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi ID mapper in the ordered set where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper findByResourceId_First(
			long resourceId,
			com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
				orderByComparator)
		throws NoSuchMOIIdMapperException;

	/**
	 * Returns the first moi ID mapper in the ordered set where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper fetchByResourceId_First(
		long resourceId,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator);

	/**
	 * Returns the last moi ID mapper in the ordered set where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper findByResourceId_Last(
			long resourceId,
			com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
				orderByComparator)
		throws NoSuchMOIIdMapperException;

	/**
	 * Returns the last moi ID mapper in the ordered set where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper fetchByResourceId_Last(
		long resourceId,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator);

	/**
	 * Returns the moi ID mappers before and after the current moi ID mapper in the ordered set where resourceId = &#63;.
	 *
	 * @param mapperId the primary key of the current moi ID mapper
	 * @param resourceId the resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a moi ID mapper with the primary key could not be found
	 */
	public MOIIdMapper[] findByResourceId_PrevAndNext(
			long mapperId, long resourceId,
			com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
				orderByComparator)
		throws NoSuchMOIIdMapperException;

	/**
	 * Removes all the moi ID mappers where resourceId = &#63; from the database.
	 *
	 * @param resourceId the resource ID
	 */
	public void removeByResourceId(long resourceId);

	/**
	 * Returns the number of moi ID mappers where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @return the number of matching moi ID mappers
	 */
	public int countByResourceId(long resourceId);

	/**
	 * Returns all the moi ID mappers where documentTitle = &#63;.
	 *
	 * @param documentTitle the document title
	 * @return the matching moi ID mappers
	 */
	public java.util.List<MOIIdMapper> findByDocumentTitle(
		String documentTitle);

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
	public java.util.List<MOIIdMapper> findByDocumentTitle(
		String documentTitle, int start, int end);

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
	public java.util.List<MOIIdMapper> findByDocumentTitle(
		String documentTitle, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator);

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
	public java.util.List<MOIIdMapper> findByDocumentTitle(
		String documentTitle, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi ID mapper in the ordered set where documentTitle = &#63;.
	 *
	 * @param documentTitle the document title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper findByDocumentTitle_First(
			String documentTitle,
			com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
				orderByComparator)
		throws NoSuchMOIIdMapperException;

	/**
	 * Returns the first moi ID mapper in the ordered set where documentTitle = &#63;.
	 *
	 * @param documentTitle the document title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper fetchByDocumentTitle_First(
		String documentTitle,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator);

	/**
	 * Returns the last moi ID mapper in the ordered set where documentTitle = &#63;.
	 *
	 * @param documentTitle the document title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper findByDocumentTitle_Last(
			String documentTitle,
			com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
				orderByComparator)
		throws NoSuchMOIIdMapperException;

	/**
	 * Returns the last moi ID mapper in the ordered set where documentTitle = &#63;.
	 *
	 * @param documentTitle the document title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper fetchByDocumentTitle_Last(
		String documentTitle,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator);

	/**
	 * Returns the moi ID mappers before and after the current moi ID mapper in the ordered set where documentTitle = &#63;.
	 *
	 * @param mapperId the primary key of the current moi ID mapper
	 * @param documentTitle the document title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a moi ID mapper with the primary key could not be found
	 */
	public MOIIdMapper[] findByDocumentTitle_PrevAndNext(
			long mapperId, String documentTitle,
			com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
				orderByComparator)
		throws NoSuchMOIIdMapperException;

	/**
	 * Removes all the moi ID mappers where documentTitle = &#63; from the database.
	 *
	 * @param documentTitle the document title
	 */
	public void removeByDocumentTitle(String documentTitle);

	/**
	 * Returns the number of moi ID mappers where documentTitle = &#63;.
	 *
	 * @param documentTitle the document title
	 * @return the number of matching moi ID mappers
	 */
	public int countByDocumentTitle(String documentTitle);

	/**
	 * Returns all the moi ID mappers where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @return the matching moi ID mappers
	 */
	public java.util.List<MOIIdMapper> findByFileEntryId(String fileEntryId);

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
	public java.util.List<MOIIdMapper> findByFileEntryId(
		String fileEntryId, int start, int end);

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
	public java.util.List<MOIIdMapper> findByFileEntryId(
		String fileEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator);

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
	public java.util.List<MOIIdMapper> findByFileEntryId(
		String fileEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi ID mapper in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper findByFileEntryId_First(
			String fileEntryId,
			com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
				orderByComparator)
		throws NoSuchMOIIdMapperException;

	/**
	 * Returns the first moi ID mapper in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper fetchByFileEntryId_First(
		String fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator);

	/**
	 * Returns the last moi ID mapper in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper findByFileEntryId_Last(
			String fileEntryId,
			com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
				orderByComparator)
		throws NoSuchMOIIdMapperException;

	/**
	 * Returns the last moi ID mapper in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper fetchByFileEntryId_Last(
		String fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator);

	/**
	 * Returns the moi ID mappers before and after the current moi ID mapper in the ordered set where fileEntryId = &#63;.
	 *
	 * @param mapperId the primary key of the current moi ID mapper
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a moi ID mapper with the primary key could not be found
	 */
	public MOIIdMapper[] findByFileEntryId_PrevAndNext(
			long mapperId, String fileEntryId,
			com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
				orderByComparator)
		throws NoSuchMOIIdMapperException;

	/**
	 * Removes all the moi ID mappers where fileEntryId = &#63; from the database.
	 *
	 * @param fileEntryId the file entry ID
	 */
	public void removeByFileEntryId(String fileEntryId);

	/**
	 * Returns the number of moi ID mappers where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @return the number of matching moi ID mappers
	 */
	public int countByFileEntryId(String fileEntryId);

	/**
	 * Returns all the moi ID mappers where updateDate = &#63;.
	 *
	 * @param updateDate the update date
	 * @return the matching moi ID mappers
	 */
	public java.util.List<MOIIdMapper> findByUpdateDate(Date updateDate);

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
	public java.util.List<MOIIdMapper> findByUpdateDate(
		Date updateDate, int start, int end);

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
	public java.util.List<MOIIdMapper> findByUpdateDate(
		Date updateDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator);

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
	public java.util.List<MOIIdMapper> findByUpdateDate(
		Date updateDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi ID mapper in the ordered set where updateDate = &#63;.
	 *
	 * @param updateDate the update date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper findByUpdateDate_First(
			Date updateDate,
			com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
				orderByComparator)
		throws NoSuchMOIIdMapperException;

	/**
	 * Returns the first moi ID mapper in the ordered set where updateDate = &#63;.
	 *
	 * @param updateDate the update date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper fetchByUpdateDate_First(
		Date updateDate,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator);

	/**
	 * Returns the last moi ID mapper in the ordered set where updateDate = &#63;.
	 *
	 * @param updateDate the update date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper findByUpdateDate_Last(
			Date updateDate,
			com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
				orderByComparator)
		throws NoSuchMOIIdMapperException;

	/**
	 * Returns the last moi ID mapper in the ordered set where updateDate = &#63;.
	 *
	 * @param updateDate the update date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper fetchByUpdateDate_Last(
		Date updateDate,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator);

	/**
	 * Returns the moi ID mappers before and after the current moi ID mapper in the ordered set where updateDate = &#63;.
	 *
	 * @param mapperId the primary key of the current moi ID mapper
	 * @param updateDate the update date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a moi ID mapper with the primary key could not be found
	 */
	public MOIIdMapper[] findByUpdateDate_PrevAndNext(
			long mapperId, Date updateDate,
			com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
				orderByComparator)
		throws NoSuchMOIIdMapperException;

	/**
	 * Removes all the moi ID mappers where updateDate = &#63; from the database.
	 *
	 * @param updateDate the update date
	 */
	public void removeByUpdateDate(Date updateDate);

	/**
	 * Returns the number of moi ID mappers where updateDate = &#63;.
	 *
	 * @param updateDate the update date
	 * @return the number of matching moi ID mappers
	 */
	public int countByUpdateDate(Date updateDate);

	/**
	 * Returns all the moi ID mappers where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @return the matching moi ID mappers
	 */
	public java.util.List<MOIIdMapper> findByUpdatedBy(String updatedBy);

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
	public java.util.List<MOIIdMapper> findByUpdatedBy(
		String updatedBy, int start, int end);

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
	public java.util.List<MOIIdMapper> findByUpdatedBy(
		String updatedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator);

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
	public java.util.List<MOIIdMapper> findByUpdatedBy(
		String updatedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first moi ID mapper in the ordered set where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper findByUpdatedBy_First(
			String updatedBy,
			com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
				orderByComparator)
		throws NoSuchMOIIdMapperException;

	/**
	 * Returns the first moi ID mapper in the ordered set where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper fetchByUpdatedBy_First(
		String updatedBy,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator);

	/**
	 * Returns the last moi ID mapper in the ordered set where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper findByUpdatedBy_Last(
			String updatedBy,
			com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
				orderByComparator)
		throws NoSuchMOIIdMapperException;

	/**
	 * Returns the last moi ID mapper in the ordered set where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	public MOIIdMapper fetchByUpdatedBy_Last(
		String updatedBy,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator);

	/**
	 * Returns the moi ID mappers before and after the current moi ID mapper in the ordered set where updatedBy = &#63;.
	 *
	 * @param mapperId the primary key of the current moi ID mapper
	 * @param updatedBy the updated by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a moi ID mapper with the primary key could not be found
	 */
	public MOIIdMapper[] findByUpdatedBy_PrevAndNext(
			long mapperId, String updatedBy,
			com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
				orderByComparator)
		throws NoSuchMOIIdMapperException;

	/**
	 * Removes all the moi ID mappers where updatedBy = &#63; from the database.
	 *
	 * @param updatedBy the updated by
	 */
	public void removeByUpdatedBy(String updatedBy);

	/**
	 * Returns the number of moi ID mappers where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @return the number of matching moi ID mappers
	 */
	public int countByUpdatedBy(String updatedBy);

	/**
	 * Caches the moi ID mapper in the entity cache if it is enabled.
	 *
	 * @param moiIdMapper the moi ID mapper
	 */
	public void cacheResult(MOIIdMapper moiIdMapper);

	/**
	 * Caches the moi ID mappers in the entity cache if it is enabled.
	 *
	 * @param moiIdMappers the moi ID mappers
	 */
	public void cacheResult(java.util.List<MOIIdMapper> moiIdMappers);

	/**
	 * Creates a new moi ID mapper with the primary key. Does not add the moi ID mapper to the database.
	 *
	 * @param mapperId the primary key for the new moi ID mapper
	 * @return the new moi ID mapper
	 */
	public MOIIdMapper create(long mapperId);

	/**
	 * Removes the moi ID mapper with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mapperId the primary key of the moi ID mapper
	 * @return the moi ID mapper that was removed
	 * @throws NoSuchMOIIdMapperException if a moi ID mapper with the primary key could not be found
	 */
	public MOIIdMapper remove(long mapperId) throws NoSuchMOIIdMapperException;

	public MOIIdMapper updateImpl(MOIIdMapper moiIdMapper);

	/**
	 * Returns the moi ID mapper with the primary key or throws a <code>NoSuchMOIIdMapperException</code> if it could not be found.
	 *
	 * @param mapperId the primary key of the moi ID mapper
	 * @return the moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a moi ID mapper with the primary key could not be found
	 */
	public MOIIdMapper findByPrimaryKey(long mapperId)
		throws NoSuchMOIIdMapperException;

	/**
	 * Returns the moi ID mapper with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mapperId the primary key of the moi ID mapper
	 * @return the moi ID mapper, or <code>null</code> if a moi ID mapper with the primary key could not be found
	 */
	public MOIIdMapper fetchByPrimaryKey(long mapperId);

	/**
	 * Returns all the moi ID mappers.
	 *
	 * @return the moi ID mappers
	 */
	public java.util.List<MOIIdMapper> findAll();

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
	public java.util.List<MOIIdMapper> findAll(int start, int end);

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
	public java.util.List<MOIIdMapper> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator);

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
	public java.util.List<MOIIdMapper> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MOIIdMapper>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the moi ID mappers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of moi ID mappers.
	 *
	 * @return the number of moi ID mappers
	 */
	public int countAll();

}