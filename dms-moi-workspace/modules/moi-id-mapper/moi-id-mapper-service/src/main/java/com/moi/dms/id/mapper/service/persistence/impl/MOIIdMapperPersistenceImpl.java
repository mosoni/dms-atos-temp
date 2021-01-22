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

package com.moi.dms.id.mapper.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.moi.dms.id.mapper.exception.NoSuchMOIIdMapperException;
import com.moi.dms.id.mapper.model.MOIIdMapper;
import com.moi.dms.id.mapper.model.impl.MOIIdMapperImpl;
import com.moi.dms.id.mapper.model.impl.MOIIdMapperModelImpl;
import com.moi.dms.id.mapper.service.persistence.MOIIdMapperPersistence;
import com.moi.dms.id.mapper.service.persistence.impl.constants.moiidmPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the moi ID mapper service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = MOIIdMapperPersistence.class)
public class MOIIdMapperPersistenceImpl
	extends BasePersistenceImpl<MOIIdMapper> implements MOIIdMapperPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MOIIdMapperUtil</code> to access the moi ID mapper persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MOIIdMapperImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByMapperId;
	private FinderPath _finderPathWithoutPaginationFindByMapperId;
	private FinderPath _finderPathCountByMapperId;

	/**
	 * Returns all the moi ID mappers where mapperId = &#63;.
	 *
	 * @param mapperId the mapper ID
	 * @return the matching moi ID mappers
	 */
	@Override
	public List<MOIIdMapper> findByMapperId(long mapperId) {
		return findByMapperId(
			mapperId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MOIIdMapper> findByMapperId(long mapperId, int start, int end) {
		return findByMapperId(mapperId, start, end, null);
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
	@Override
	public List<MOIIdMapper> findByMapperId(
		long mapperId, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator) {

		return findByMapperId(mapperId, start, end, orderByComparator, true);
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
	@Override
	public List<MOIIdMapper> findByMapperId(
		long mapperId, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByMapperId;
				finderArgs = new Object[] {mapperId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByMapperId;
			finderArgs = new Object[] {mapperId, start, end, orderByComparator};
		}

		List<MOIIdMapper> list = null;

		if (useFinderCache) {
			list = (List<MOIIdMapper>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOIIdMapper moiIdMapper : list) {
					if (mapperId != moiIdMapper.getMapperId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_MOIIDMAPPER_WHERE);

			sb.append(_FINDER_COLUMN_MAPPERID_MAPPERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOIIdMapperModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(mapperId);

				list = (List<MOIIdMapper>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where mapperId = &#63;.
	 *
	 * @param mapperId the mapper ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper findByMapperId_First(
			long mapperId, OrderByComparator<MOIIdMapper> orderByComparator)
		throws NoSuchMOIIdMapperException {

		MOIIdMapper moiIdMapper = fetchByMapperId_First(
			mapperId, orderByComparator);

		if (moiIdMapper != null) {
			return moiIdMapper;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mapperId=");
		sb.append(mapperId);

		sb.append("}");

		throw new NoSuchMOIIdMapperException(sb.toString());
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where mapperId = &#63;.
	 *
	 * @param mapperId the mapper ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper fetchByMapperId_First(
		long mapperId, OrderByComparator<MOIIdMapper> orderByComparator) {

		List<MOIIdMapper> list = findByMapperId(
			mapperId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where mapperId = &#63;.
	 *
	 * @param mapperId the mapper ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper findByMapperId_Last(
			long mapperId, OrderByComparator<MOIIdMapper> orderByComparator)
		throws NoSuchMOIIdMapperException {

		MOIIdMapper moiIdMapper = fetchByMapperId_Last(
			mapperId, orderByComparator);

		if (moiIdMapper != null) {
			return moiIdMapper;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mapperId=");
		sb.append(mapperId);

		sb.append("}");

		throw new NoSuchMOIIdMapperException(sb.toString());
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where mapperId = &#63;.
	 *
	 * @param mapperId the mapper ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper fetchByMapperId_Last(
		long mapperId, OrderByComparator<MOIIdMapper> orderByComparator) {

		int count = countByMapperId(mapperId);

		if (count == 0) {
			return null;
		}

		List<MOIIdMapper> list = findByMapperId(
			mapperId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the moi ID mappers where mapperId = &#63; from the database.
	 *
	 * @param mapperId the mapper ID
	 */
	@Override
	public void removeByMapperId(long mapperId) {
		for (MOIIdMapper moiIdMapper :
				findByMapperId(
					mapperId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(moiIdMapper);
		}
	}

	/**
	 * Returns the number of moi ID mappers where mapperId = &#63;.
	 *
	 * @param mapperId the mapper ID
	 * @return the number of matching moi ID mappers
	 */
	@Override
	public int countByMapperId(long mapperId) {
		FinderPath finderPath = _finderPathCountByMapperId;

		Object[] finderArgs = new Object[] {mapperId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOIIDMAPPER_WHERE);

			sb.append(_FINDER_COLUMN_MAPPERID_MAPPERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(mapperId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_MAPPERID_MAPPERID_2 =
		"moiIdMapper.mapperId = ?";

	private FinderPath _finderPathWithPaginationFindByMosipCurrentState;
	private FinderPath _finderPathWithoutPaginationFindByMosipCurrentState;
	private FinderPath _finderPathCountByMosipCurrentState;

	/**
	 * Returns all the moi ID mappers where mosipCurrentState = &#63;.
	 *
	 * @param mosipCurrentState the mosip current state
	 * @return the matching moi ID mappers
	 */
	@Override
	public List<MOIIdMapper> findByMosipCurrentState(String mosipCurrentState) {
		return findByMosipCurrentState(
			mosipCurrentState, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MOIIdMapper> findByMosipCurrentState(
		String mosipCurrentState, int start, int end) {

		return findByMosipCurrentState(mosipCurrentState, start, end, null);
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
	@Override
	public List<MOIIdMapper> findByMosipCurrentState(
		String mosipCurrentState, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator) {

		return findByMosipCurrentState(
			mosipCurrentState, start, end, orderByComparator, true);
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
	@Override
	public List<MOIIdMapper> findByMosipCurrentState(
		String mosipCurrentState, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator,
		boolean useFinderCache) {

		mosipCurrentState = Objects.toString(mosipCurrentState, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByMosipCurrentState;
				finderArgs = new Object[] {mosipCurrentState};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByMosipCurrentState;
			finderArgs = new Object[] {
				mosipCurrentState, start, end, orderByComparator
			};
		}

		List<MOIIdMapper> list = null;

		if (useFinderCache) {
			list = (List<MOIIdMapper>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOIIdMapper moiIdMapper : list) {
					if (!mosipCurrentState.equals(
							moiIdMapper.getMosipCurrentState())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_MOIIDMAPPER_WHERE);

			boolean bindMosipCurrentState = false;

			if (mosipCurrentState.isEmpty()) {
				sb.append(_FINDER_COLUMN_MOSIPCURRENTSTATE_MOSIPCURRENTSTATE_3);
			}
			else {
				bindMosipCurrentState = true;

				sb.append(_FINDER_COLUMN_MOSIPCURRENTSTATE_MOSIPCURRENTSTATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOIIdMapperModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindMosipCurrentState) {
					queryPos.add(mosipCurrentState);
				}

				list = (List<MOIIdMapper>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where mosipCurrentState = &#63;.
	 *
	 * @param mosipCurrentState the mosip current state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper findByMosipCurrentState_First(
			String mosipCurrentState,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws NoSuchMOIIdMapperException {

		MOIIdMapper moiIdMapper = fetchByMosipCurrentState_First(
			mosipCurrentState, orderByComparator);

		if (moiIdMapper != null) {
			return moiIdMapper;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mosipCurrentState=");
		sb.append(mosipCurrentState);

		sb.append("}");

		throw new NoSuchMOIIdMapperException(sb.toString());
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where mosipCurrentState = &#63;.
	 *
	 * @param mosipCurrentState the mosip current state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper fetchByMosipCurrentState_First(
		String mosipCurrentState,
		OrderByComparator<MOIIdMapper> orderByComparator) {

		List<MOIIdMapper> list = findByMosipCurrentState(
			mosipCurrentState, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where mosipCurrentState = &#63;.
	 *
	 * @param mosipCurrentState the mosip current state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper findByMosipCurrentState_Last(
			String mosipCurrentState,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws NoSuchMOIIdMapperException {

		MOIIdMapper moiIdMapper = fetchByMosipCurrentState_Last(
			mosipCurrentState, orderByComparator);

		if (moiIdMapper != null) {
			return moiIdMapper;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mosipCurrentState=");
		sb.append(mosipCurrentState);

		sb.append("}");

		throw new NoSuchMOIIdMapperException(sb.toString());
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where mosipCurrentState = &#63;.
	 *
	 * @param mosipCurrentState the mosip current state
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper fetchByMosipCurrentState_Last(
		String mosipCurrentState,
		OrderByComparator<MOIIdMapper> orderByComparator) {

		int count = countByMosipCurrentState(mosipCurrentState);

		if (count == 0) {
			return null;
		}

		List<MOIIdMapper> list = findByMosipCurrentState(
			mosipCurrentState, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MOIIdMapper[] findByMosipCurrentState_PrevAndNext(
			long mapperId, String mosipCurrentState,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws NoSuchMOIIdMapperException {

		mosipCurrentState = Objects.toString(mosipCurrentState, "");

		MOIIdMapper moiIdMapper = findByPrimaryKey(mapperId);

		Session session = null;

		try {
			session = openSession();

			MOIIdMapper[] array = new MOIIdMapperImpl[3];

			array[0] = getByMosipCurrentState_PrevAndNext(
				session, moiIdMapper, mosipCurrentState, orderByComparator,
				true);

			array[1] = moiIdMapper;

			array[2] = getByMosipCurrentState_PrevAndNext(
				session, moiIdMapper, mosipCurrentState, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MOIIdMapper getByMosipCurrentState_PrevAndNext(
		Session session, MOIIdMapper moiIdMapper, String mosipCurrentState,
		OrderByComparator<MOIIdMapper> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MOIIDMAPPER_WHERE);

		boolean bindMosipCurrentState = false;

		if (mosipCurrentState.isEmpty()) {
			sb.append(_FINDER_COLUMN_MOSIPCURRENTSTATE_MOSIPCURRENTSTATE_3);
		}
		else {
			bindMosipCurrentState = true;

			sb.append(_FINDER_COLUMN_MOSIPCURRENTSTATE_MOSIPCURRENTSTATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MOIIdMapperModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindMosipCurrentState) {
			queryPos.add(mosipCurrentState);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(moiIdMapper)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MOIIdMapper> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the moi ID mappers where mosipCurrentState = &#63; from the database.
	 *
	 * @param mosipCurrentState the mosip current state
	 */
	@Override
	public void removeByMosipCurrentState(String mosipCurrentState) {
		for (MOIIdMapper moiIdMapper :
				findByMosipCurrentState(
					mosipCurrentState, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(moiIdMapper);
		}
	}

	/**
	 * Returns the number of moi ID mappers where mosipCurrentState = &#63;.
	 *
	 * @param mosipCurrentState the mosip current state
	 * @return the number of matching moi ID mappers
	 */
	@Override
	public int countByMosipCurrentState(String mosipCurrentState) {
		mosipCurrentState = Objects.toString(mosipCurrentState, "");

		FinderPath finderPath = _finderPathCountByMosipCurrentState;

		Object[] finderArgs = new Object[] {mosipCurrentState};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOIIDMAPPER_WHERE);

			boolean bindMosipCurrentState = false;

			if (mosipCurrentState.isEmpty()) {
				sb.append(_FINDER_COLUMN_MOSIPCURRENTSTATE_MOSIPCURRENTSTATE_3);
			}
			else {
				bindMosipCurrentState = true;

				sb.append(_FINDER_COLUMN_MOSIPCURRENTSTATE_MOSIPCURRENTSTATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindMosipCurrentState) {
					queryPos.add(mosipCurrentState);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_MOSIPCURRENTSTATE_MOSIPCURRENTSTATE_2 =
			"moiIdMapper.mosipCurrentState = ?";

	private static final String
		_FINDER_COLUMN_MOSIPCURRENTSTATE_MOSIPCURRENTSTATE_3 =
			"(moiIdMapper.mosipCurrentState IS NULL OR moiIdMapper.mosipCurrentState = '')";

	private FinderPath _finderPathWithPaginationFindByMosipDocumentType;
	private FinderPath _finderPathWithoutPaginationFindByMosipDocumentType;
	private FinderPath _finderPathCountByMosipDocumentType;

	/**
	 * Returns all the moi ID mappers where mosipDocumentType = &#63;.
	 *
	 * @param mosipDocumentType the mosip document type
	 * @return the matching moi ID mappers
	 */
	@Override
	public List<MOIIdMapper> findByMosipDocumentType(String mosipDocumentType) {
		return findByMosipDocumentType(
			mosipDocumentType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MOIIdMapper> findByMosipDocumentType(
		String mosipDocumentType, int start, int end) {

		return findByMosipDocumentType(mosipDocumentType, start, end, null);
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
	@Override
	public List<MOIIdMapper> findByMosipDocumentType(
		String mosipDocumentType, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator) {

		return findByMosipDocumentType(
			mosipDocumentType, start, end, orderByComparator, true);
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
	@Override
	public List<MOIIdMapper> findByMosipDocumentType(
		String mosipDocumentType, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator,
		boolean useFinderCache) {

		mosipDocumentType = Objects.toString(mosipDocumentType, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByMosipDocumentType;
				finderArgs = new Object[] {mosipDocumentType};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByMosipDocumentType;
			finderArgs = new Object[] {
				mosipDocumentType, start, end, orderByComparator
			};
		}

		List<MOIIdMapper> list = null;

		if (useFinderCache) {
			list = (List<MOIIdMapper>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOIIdMapper moiIdMapper : list) {
					if (!mosipDocumentType.equals(
							moiIdMapper.getMosipDocumentType())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_MOIIDMAPPER_WHERE);

			boolean bindMosipDocumentType = false;

			if (mosipDocumentType.isEmpty()) {
				sb.append(_FINDER_COLUMN_MOSIPDOCUMENTTYPE_MOSIPDOCUMENTTYPE_3);
			}
			else {
				bindMosipDocumentType = true;

				sb.append(_FINDER_COLUMN_MOSIPDOCUMENTTYPE_MOSIPDOCUMENTTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOIIdMapperModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindMosipDocumentType) {
					queryPos.add(mosipDocumentType);
				}

				list = (List<MOIIdMapper>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where mosipDocumentType = &#63;.
	 *
	 * @param mosipDocumentType the mosip document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper findByMosipDocumentType_First(
			String mosipDocumentType,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws NoSuchMOIIdMapperException {

		MOIIdMapper moiIdMapper = fetchByMosipDocumentType_First(
			mosipDocumentType, orderByComparator);

		if (moiIdMapper != null) {
			return moiIdMapper;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mosipDocumentType=");
		sb.append(mosipDocumentType);

		sb.append("}");

		throw new NoSuchMOIIdMapperException(sb.toString());
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where mosipDocumentType = &#63;.
	 *
	 * @param mosipDocumentType the mosip document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper fetchByMosipDocumentType_First(
		String mosipDocumentType,
		OrderByComparator<MOIIdMapper> orderByComparator) {

		List<MOIIdMapper> list = findByMosipDocumentType(
			mosipDocumentType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where mosipDocumentType = &#63;.
	 *
	 * @param mosipDocumentType the mosip document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper findByMosipDocumentType_Last(
			String mosipDocumentType,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws NoSuchMOIIdMapperException {

		MOIIdMapper moiIdMapper = fetchByMosipDocumentType_Last(
			mosipDocumentType, orderByComparator);

		if (moiIdMapper != null) {
			return moiIdMapper;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mosipDocumentType=");
		sb.append(mosipDocumentType);

		sb.append("}");

		throw new NoSuchMOIIdMapperException(sb.toString());
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where mosipDocumentType = &#63;.
	 *
	 * @param mosipDocumentType the mosip document type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper fetchByMosipDocumentType_Last(
		String mosipDocumentType,
		OrderByComparator<MOIIdMapper> orderByComparator) {

		int count = countByMosipDocumentType(mosipDocumentType);

		if (count == 0) {
			return null;
		}

		List<MOIIdMapper> list = findByMosipDocumentType(
			mosipDocumentType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MOIIdMapper[] findByMosipDocumentType_PrevAndNext(
			long mapperId, String mosipDocumentType,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws NoSuchMOIIdMapperException {

		mosipDocumentType = Objects.toString(mosipDocumentType, "");

		MOIIdMapper moiIdMapper = findByPrimaryKey(mapperId);

		Session session = null;

		try {
			session = openSession();

			MOIIdMapper[] array = new MOIIdMapperImpl[3];

			array[0] = getByMosipDocumentType_PrevAndNext(
				session, moiIdMapper, mosipDocumentType, orderByComparator,
				true);

			array[1] = moiIdMapper;

			array[2] = getByMosipDocumentType_PrevAndNext(
				session, moiIdMapper, mosipDocumentType, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MOIIdMapper getByMosipDocumentType_PrevAndNext(
		Session session, MOIIdMapper moiIdMapper, String mosipDocumentType,
		OrderByComparator<MOIIdMapper> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MOIIDMAPPER_WHERE);

		boolean bindMosipDocumentType = false;

		if (mosipDocumentType.isEmpty()) {
			sb.append(_FINDER_COLUMN_MOSIPDOCUMENTTYPE_MOSIPDOCUMENTTYPE_3);
		}
		else {
			bindMosipDocumentType = true;

			sb.append(_FINDER_COLUMN_MOSIPDOCUMENTTYPE_MOSIPDOCUMENTTYPE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MOIIdMapperModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindMosipDocumentType) {
			queryPos.add(mosipDocumentType);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(moiIdMapper)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MOIIdMapper> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the moi ID mappers where mosipDocumentType = &#63; from the database.
	 *
	 * @param mosipDocumentType the mosip document type
	 */
	@Override
	public void removeByMosipDocumentType(String mosipDocumentType) {
		for (MOIIdMapper moiIdMapper :
				findByMosipDocumentType(
					mosipDocumentType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(moiIdMapper);
		}
	}

	/**
	 * Returns the number of moi ID mappers where mosipDocumentType = &#63;.
	 *
	 * @param mosipDocumentType the mosip document type
	 * @return the number of matching moi ID mappers
	 */
	@Override
	public int countByMosipDocumentType(String mosipDocumentType) {
		mosipDocumentType = Objects.toString(mosipDocumentType, "");

		FinderPath finderPath = _finderPathCountByMosipDocumentType;

		Object[] finderArgs = new Object[] {mosipDocumentType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOIIDMAPPER_WHERE);

			boolean bindMosipDocumentType = false;

			if (mosipDocumentType.isEmpty()) {
				sb.append(_FINDER_COLUMN_MOSIPDOCUMENTTYPE_MOSIPDOCUMENTTYPE_3);
			}
			else {
				bindMosipDocumentType = true;

				sb.append(_FINDER_COLUMN_MOSIPDOCUMENTTYPE_MOSIPDOCUMENTTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindMosipDocumentType) {
					queryPos.add(mosipDocumentType);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_MOSIPDOCUMENTTYPE_MOSIPDOCUMENTTYPE_2 =
			"moiIdMapper.mosipDocumentType = ?";

	private static final String
		_FINDER_COLUMN_MOSIPDOCUMENTTYPE_MOSIPDOCUMENTTYPE_3 =
			"(moiIdMapper.mosipDocumentType IS NULL OR moiIdMapper.mosipDocumentType = '')";

	private FinderPath _finderPathFetchByRegistrationId;
	private FinderPath _finderPathCountByRegistrationId;

	/**
	 * Returns the moi ID mapper where registrationId = &#63; or throws a <code>NoSuchMOIIdMapperException</code> if it could not be found.
	 *
	 * @param registrationId the registration ID
	 * @return the matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper findByRegistrationId(String registrationId)
		throws NoSuchMOIIdMapperException {

		MOIIdMapper moiIdMapper = fetchByRegistrationId(registrationId);

		if (moiIdMapper == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("registrationId=");
			sb.append(registrationId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchMOIIdMapperException(sb.toString());
		}

		return moiIdMapper;
	}

	/**
	 * Returns the moi ID mapper where registrationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param registrationId the registration ID
	 * @return the matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper fetchByRegistrationId(String registrationId) {
		return fetchByRegistrationId(registrationId, true);
	}

	/**
	 * Returns the moi ID mapper where registrationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param registrationId the registration ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper fetchByRegistrationId(
		String registrationId, boolean useFinderCache) {

		registrationId = Objects.toString(registrationId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {registrationId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByRegistrationId, finderArgs, this);
		}

		if (result instanceof MOIIdMapper) {
			MOIIdMapper moiIdMapper = (MOIIdMapper)result;

			if (!Objects.equals(
					registrationId, moiIdMapper.getRegistrationId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_MOIIDMAPPER_WHERE);

			boolean bindRegistrationId = false;

			if (registrationId.isEmpty()) {
				sb.append(_FINDER_COLUMN_REGISTRATIONID_REGISTRATIONID_3);
			}
			else {
				bindRegistrationId = true;

				sb.append(_FINDER_COLUMN_REGISTRATIONID_REGISTRATIONID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRegistrationId) {
					queryPos.add(registrationId);
				}

				List<MOIIdMapper> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByRegistrationId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {registrationId};
							}

							_log.warn(
								"MOIIdMapperPersistenceImpl.fetchByRegistrationId(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					MOIIdMapper moiIdMapper = list.get(0);

					result = moiIdMapper;

					cacheResult(moiIdMapper);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByRegistrationId, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (MOIIdMapper)result;
		}
	}

	/**
	 * Removes the moi ID mapper where registrationId = &#63; from the database.
	 *
	 * @param registrationId the registration ID
	 * @return the moi ID mapper that was removed
	 */
	@Override
	public MOIIdMapper removeByRegistrationId(String registrationId)
		throws NoSuchMOIIdMapperException {

		MOIIdMapper moiIdMapper = findByRegistrationId(registrationId);

		return remove(moiIdMapper);
	}

	/**
	 * Returns the number of moi ID mappers where registrationId = &#63;.
	 *
	 * @param registrationId the registration ID
	 * @return the number of matching moi ID mappers
	 */
	@Override
	public int countByRegistrationId(String registrationId) {
		registrationId = Objects.toString(registrationId, "");

		FinderPath finderPath = _finderPathCountByRegistrationId;

		Object[] finderArgs = new Object[] {registrationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOIIDMAPPER_WHERE);

			boolean bindRegistrationId = false;

			if (registrationId.isEmpty()) {
				sb.append(_FINDER_COLUMN_REGISTRATIONID_REGISTRATIONID_3);
			}
			else {
				bindRegistrationId = true;

				sb.append(_FINDER_COLUMN_REGISTRATIONID_REGISTRATIONID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRegistrationId) {
					queryPos.add(registrationId);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_REGISTRATIONID_REGISTRATIONID_2 =
		"moiIdMapper.registrationId = ?";

	private static final String _FINDER_COLUMN_REGISTRATIONID_REGISTRATIONID_3 =
		"(moiIdMapper.registrationId IS NULL OR moiIdMapper.registrationId = '')";

	private FinderPath _finderPathFetchByRegistrationIdCurrentState;
	private FinderPath _finderPathCountByRegistrationIdCurrentState;

	/**
	 * Returns the moi ID mapper where registrationId = &#63; and mosipCurrentState = &#63; or throws a <code>NoSuchMOIIdMapperException</code> if it could not be found.
	 *
	 * @param registrationId the registration ID
	 * @param mosipCurrentState the mosip current state
	 * @return the matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper findByRegistrationIdCurrentState(
			String registrationId, String mosipCurrentState)
		throws NoSuchMOIIdMapperException {

		MOIIdMapper moiIdMapper = fetchByRegistrationIdCurrentState(
			registrationId, mosipCurrentState);

		if (moiIdMapper == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("registrationId=");
			sb.append(registrationId);

			sb.append(", mosipCurrentState=");
			sb.append(mosipCurrentState);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchMOIIdMapperException(sb.toString());
		}

		return moiIdMapper;
	}

	/**
	 * Returns the moi ID mapper where registrationId = &#63; and mosipCurrentState = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param registrationId the registration ID
	 * @param mosipCurrentState the mosip current state
	 * @return the matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper fetchByRegistrationIdCurrentState(
		String registrationId, String mosipCurrentState) {

		return fetchByRegistrationIdCurrentState(
			registrationId, mosipCurrentState, true);
	}

	/**
	 * Returns the moi ID mapper where registrationId = &#63; and mosipCurrentState = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param registrationId the registration ID
	 * @param mosipCurrentState the mosip current state
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper fetchByRegistrationIdCurrentState(
		String registrationId, String mosipCurrentState,
		boolean useFinderCache) {

		registrationId = Objects.toString(registrationId, "");
		mosipCurrentState = Objects.toString(mosipCurrentState, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {registrationId, mosipCurrentState};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByRegistrationIdCurrentState, finderArgs, this);
		}

		if (result instanceof MOIIdMapper) {
			MOIIdMapper moiIdMapper = (MOIIdMapper)result;

			if (!Objects.equals(
					registrationId, moiIdMapper.getRegistrationId()) ||
				!Objects.equals(
					mosipCurrentState, moiIdMapper.getMosipCurrentState())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_MOIIDMAPPER_WHERE);

			boolean bindRegistrationId = false;

			if (registrationId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_REGISTRATIONIDCURRENTSTATE_REGISTRATIONID_3);
			}
			else {
				bindRegistrationId = true;

				sb.append(
					_FINDER_COLUMN_REGISTRATIONIDCURRENTSTATE_REGISTRATIONID_2);
			}

			boolean bindMosipCurrentState = false;

			if (mosipCurrentState.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_REGISTRATIONIDCURRENTSTATE_MOSIPCURRENTSTATE_3);
			}
			else {
				bindMosipCurrentState = true;

				sb.append(
					_FINDER_COLUMN_REGISTRATIONIDCURRENTSTATE_MOSIPCURRENTSTATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRegistrationId) {
					queryPos.add(registrationId);
				}

				if (bindMosipCurrentState) {
					queryPos.add(mosipCurrentState);
				}

				List<MOIIdMapper> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByRegistrationIdCurrentState,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									registrationId, mosipCurrentState
								};
							}

							_log.warn(
								"MOIIdMapperPersistenceImpl.fetchByRegistrationIdCurrentState(String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					MOIIdMapper moiIdMapper = list.get(0);

					result = moiIdMapper;

					cacheResult(moiIdMapper);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByRegistrationIdCurrentState,
						finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (MOIIdMapper)result;
		}
	}

	/**
	 * Removes the moi ID mapper where registrationId = &#63; and mosipCurrentState = &#63; from the database.
	 *
	 * @param registrationId the registration ID
	 * @param mosipCurrentState the mosip current state
	 * @return the moi ID mapper that was removed
	 */
	@Override
	public MOIIdMapper removeByRegistrationIdCurrentState(
			String registrationId, String mosipCurrentState)
		throws NoSuchMOIIdMapperException {

		MOIIdMapper moiIdMapper = findByRegistrationIdCurrentState(
			registrationId, mosipCurrentState);

		return remove(moiIdMapper);
	}

	/**
	 * Returns the number of moi ID mappers where registrationId = &#63; and mosipCurrentState = &#63;.
	 *
	 * @param registrationId the registration ID
	 * @param mosipCurrentState the mosip current state
	 * @return the number of matching moi ID mappers
	 */
	@Override
	public int countByRegistrationIdCurrentState(
		String registrationId, String mosipCurrentState) {

		registrationId = Objects.toString(registrationId, "");
		mosipCurrentState = Objects.toString(mosipCurrentState, "");

		FinderPath finderPath = _finderPathCountByRegistrationIdCurrentState;

		Object[] finderArgs = new Object[] {registrationId, mosipCurrentState};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MOIIDMAPPER_WHERE);

			boolean bindRegistrationId = false;

			if (registrationId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_REGISTRATIONIDCURRENTSTATE_REGISTRATIONID_3);
			}
			else {
				bindRegistrationId = true;

				sb.append(
					_FINDER_COLUMN_REGISTRATIONIDCURRENTSTATE_REGISTRATIONID_2);
			}

			boolean bindMosipCurrentState = false;

			if (mosipCurrentState.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_REGISTRATIONIDCURRENTSTATE_MOSIPCURRENTSTATE_3);
			}
			else {
				bindMosipCurrentState = true;

				sb.append(
					_FINDER_COLUMN_REGISTRATIONIDCURRENTSTATE_MOSIPCURRENTSTATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRegistrationId) {
					queryPos.add(registrationId);
				}

				if (bindMosipCurrentState) {
					queryPos.add(mosipCurrentState);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_REGISTRATIONIDCURRENTSTATE_REGISTRATIONID_2 =
			"moiIdMapper.registrationId = ? AND ";

	private static final String
		_FINDER_COLUMN_REGISTRATIONIDCURRENTSTATE_REGISTRATIONID_3 =
			"(moiIdMapper.registrationId IS NULL OR moiIdMapper.registrationId = '') AND ";

	private static final String
		_FINDER_COLUMN_REGISTRATIONIDCURRENTSTATE_MOSIPCURRENTSTATE_2 =
			"moiIdMapper.mosipCurrentState = ?";

	private static final String
		_FINDER_COLUMN_REGISTRATIONIDCURRENTSTATE_MOSIPCURRENTSTATE_3 =
			"(moiIdMapper.mosipCurrentState IS NULL OR moiIdMapper.mosipCurrentState = '')";

	private FinderPath _finderPathWithPaginationFindByResourceId;
	private FinderPath _finderPathWithoutPaginationFindByResourceId;
	private FinderPath _finderPathCountByResourceId;

	/**
	 * Returns all the moi ID mappers where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @return the matching moi ID mappers
	 */
	@Override
	public List<MOIIdMapper> findByResourceId(long resourceId) {
		return findByResourceId(
			resourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MOIIdMapper> findByResourceId(
		long resourceId, int start, int end) {

		return findByResourceId(resourceId, start, end, null);
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
	@Override
	public List<MOIIdMapper> findByResourceId(
		long resourceId, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator) {

		return findByResourceId(
			resourceId, start, end, orderByComparator, true);
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
	@Override
	public List<MOIIdMapper> findByResourceId(
		long resourceId, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByResourceId;
				finderArgs = new Object[] {resourceId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByResourceId;
			finderArgs = new Object[] {
				resourceId, start, end, orderByComparator
			};
		}

		List<MOIIdMapper> list = null;

		if (useFinderCache) {
			list = (List<MOIIdMapper>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOIIdMapper moiIdMapper : list) {
					if (resourceId != moiIdMapper.getResourceId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_MOIIDMAPPER_WHERE);

			sb.append(_FINDER_COLUMN_RESOURCEID_RESOURCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOIIdMapperModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(resourceId);

				list = (List<MOIIdMapper>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper findByResourceId_First(
			long resourceId, OrderByComparator<MOIIdMapper> orderByComparator)
		throws NoSuchMOIIdMapperException {

		MOIIdMapper moiIdMapper = fetchByResourceId_First(
			resourceId, orderByComparator);

		if (moiIdMapper != null) {
			return moiIdMapper;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("resourceId=");
		sb.append(resourceId);

		sb.append("}");

		throw new NoSuchMOIIdMapperException(sb.toString());
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper fetchByResourceId_First(
		long resourceId, OrderByComparator<MOIIdMapper> orderByComparator) {

		List<MOIIdMapper> list = findByResourceId(
			resourceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper findByResourceId_Last(
			long resourceId, OrderByComparator<MOIIdMapper> orderByComparator)
		throws NoSuchMOIIdMapperException {

		MOIIdMapper moiIdMapper = fetchByResourceId_Last(
			resourceId, orderByComparator);

		if (moiIdMapper != null) {
			return moiIdMapper;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("resourceId=");
		sb.append(resourceId);

		sb.append("}");

		throw new NoSuchMOIIdMapperException(sb.toString());
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper fetchByResourceId_Last(
		long resourceId, OrderByComparator<MOIIdMapper> orderByComparator) {

		int count = countByResourceId(resourceId);

		if (count == 0) {
			return null;
		}

		List<MOIIdMapper> list = findByResourceId(
			resourceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MOIIdMapper[] findByResourceId_PrevAndNext(
			long mapperId, long resourceId,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws NoSuchMOIIdMapperException {

		MOIIdMapper moiIdMapper = findByPrimaryKey(mapperId);

		Session session = null;

		try {
			session = openSession();

			MOIIdMapper[] array = new MOIIdMapperImpl[3];

			array[0] = getByResourceId_PrevAndNext(
				session, moiIdMapper, resourceId, orderByComparator, true);

			array[1] = moiIdMapper;

			array[2] = getByResourceId_PrevAndNext(
				session, moiIdMapper, resourceId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MOIIdMapper getByResourceId_PrevAndNext(
		Session session, MOIIdMapper moiIdMapper, long resourceId,
		OrderByComparator<MOIIdMapper> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MOIIDMAPPER_WHERE);

		sb.append(_FINDER_COLUMN_RESOURCEID_RESOURCEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MOIIdMapperModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(resourceId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(moiIdMapper)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MOIIdMapper> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the moi ID mappers where resourceId = &#63; from the database.
	 *
	 * @param resourceId the resource ID
	 */
	@Override
	public void removeByResourceId(long resourceId) {
		for (MOIIdMapper moiIdMapper :
				findByResourceId(
					resourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(moiIdMapper);
		}
	}

	/**
	 * Returns the number of moi ID mappers where resourceId = &#63;.
	 *
	 * @param resourceId the resource ID
	 * @return the number of matching moi ID mappers
	 */
	@Override
	public int countByResourceId(long resourceId) {
		FinderPath finderPath = _finderPathCountByResourceId;

		Object[] finderArgs = new Object[] {resourceId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOIIDMAPPER_WHERE);

			sb.append(_FINDER_COLUMN_RESOURCEID_RESOURCEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(resourceId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_RESOURCEID_RESOURCEID_2 =
		"moiIdMapper.resourceId = ?";

	private FinderPath _finderPathWithPaginationFindByDocumentTitle;
	private FinderPath _finderPathWithoutPaginationFindByDocumentTitle;
	private FinderPath _finderPathCountByDocumentTitle;

	/**
	 * Returns all the moi ID mappers where documentTitle = &#63;.
	 *
	 * @param documentTitle the document title
	 * @return the matching moi ID mappers
	 */
	@Override
	public List<MOIIdMapper> findByDocumentTitle(String documentTitle) {
		return findByDocumentTitle(
			documentTitle, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MOIIdMapper> findByDocumentTitle(
		String documentTitle, int start, int end) {

		return findByDocumentTitle(documentTitle, start, end, null);
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
	@Override
	public List<MOIIdMapper> findByDocumentTitle(
		String documentTitle, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator) {

		return findByDocumentTitle(
			documentTitle, start, end, orderByComparator, true);
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
	@Override
	public List<MOIIdMapper> findByDocumentTitle(
		String documentTitle, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator,
		boolean useFinderCache) {

		documentTitle = Objects.toString(documentTitle, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDocumentTitle;
				finderArgs = new Object[] {documentTitle};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDocumentTitle;
			finderArgs = new Object[] {
				documentTitle, start, end, orderByComparator
			};
		}

		List<MOIIdMapper> list = null;

		if (useFinderCache) {
			list = (List<MOIIdMapper>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOIIdMapper moiIdMapper : list) {
					if (!documentTitle.equals(moiIdMapper.getDocumentTitle())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_MOIIDMAPPER_WHERE);

			boolean bindDocumentTitle = false;

			if (documentTitle.isEmpty()) {
				sb.append(_FINDER_COLUMN_DOCUMENTTITLE_DOCUMENTTITLE_3);
			}
			else {
				bindDocumentTitle = true;

				sb.append(_FINDER_COLUMN_DOCUMENTTITLE_DOCUMENTTITLE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOIIdMapperModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDocumentTitle) {
					queryPos.add(documentTitle);
				}

				list = (List<MOIIdMapper>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where documentTitle = &#63;.
	 *
	 * @param documentTitle the document title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper findByDocumentTitle_First(
			String documentTitle,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws NoSuchMOIIdMapperException {

		MOIIdMapper moiIdMapper = fetchByDocumentTitle_First(
			documentTitle, orderByComparator);

		if (moiIdMapper != null) {
			return moiIdMapper;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("documentTitle=");
		sb.append(documentTitle);

		sb.append("}");

		throw new NoSuchMOIIdMapperException(sb.toString());
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where documentTitle = &#63;.
	 *
	 * @param documentTitle the document title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper fetchByDocumentTitle_First(
		String documentTitle,
		OrderByComparator<MOIIdMapper> orderByComparator) {

		List<MOIIdMapper> list = findByDocumentTitle(
			documentTitle, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where documentTitle = &#63;.
	 *
	 * @param documentTitle the document title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper findByDocumentTitle_Last(
			String documentTitle,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws NoSuchMOIIdMapperException {

		MOIIdMapper moiIdMapper = fetchByDocumentTitle_Last(
			documentTitle, orderByComparator);

		if (moiIdMapper != null) {
			return moiIdMapper;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("documentTitle=");
		sb.append(documentTitle);

		sb.append("}");

		throw new NoSuchMOIIdMapperException(sb.toString());
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where documentTitle = &#63;.
	 *
	 * @param documentTitle the document title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper fetchByDocumentTitle_Last(
		String documentTitle,
		OrderByComparator<MOIIdMapper> orderByComparator) {

		int count = countByDocumentTitle(documentTitle);

		if (count == 0) {
			return null;
		}

		List<MOIIdMapper> list = findByDocumentTitle(
			documentTitle, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MOIIdMapper[] findByDocumentTitle_PrevAndNext(
			long mapperId, String documentTitle,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws NoSuchMOIIdMapperException {

		documentTitle = Objects.toString(documentTitle, "");

		MOIIdMapper moiIdMapper = findByPrimaryKey(mapperId);

		Session session = null;

		try {
			session = openSession();

			MOIIdMapper[] array = new MOIIdMapperImpl[3];

			array[0] = getByDocumentTitle_PrevAndNext(
				session, moiIdMapper, documentTitle, orderByComparator, true);

			array[1] = moiIdMapper;

			array[2] = getByDocumentTitle_PrevAndNext(
				session, moiIdMapper, documentTitle, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MOIIdMapper getByDocumentTitle_PrevAndNext(
		Session session, MOIIdMapper moiIdMapper, String documentTitle,
		OrderByComparator<MOIIdMapper> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MOIIDMAPPER_WHERE);

		boolean bindDocumentTitle = false;

		if (documentTitle.isEmpty()) {
			sb.append(_FINDER_COLUMN_DOCUMENTTITLE_DOCUMENTTITLE_3);
		}
		else {
			bindDocumentTitle = true;

			sb.append(_FINDER_COLUMN_DOCUMENTTITLE_DOCUMENTTITLE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MOIIdMapperModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDocumentTitle) {
			queryPos.add(documentTitle);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(moiIdMapper)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MOIIdMapper> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the moi ID mappers where documentTitle = &#63; from the database.
	 *
	 * @param documentTitle the document title
	 */
	@Override
	public void removeByDocumentTitle(String documentTitle) {
		for (MOIIdMapper moiIdMapper :
				findByDocumentTitle(
					documentTitle, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(moiIdMapper);
		}
	}

	/**
	 * Returns the number of moi ID mappers where documentTitle = &#63;.
	 *
	 * @param documentTitle the document title
	 * @return the number of matching moi ID mappers
	 */
	@Override
	public int countByDocumentTitle(String documentTitle) {
		documentTitle = Objects.toString(documentTitle, "");

		FinderPath finderPath = _finderPathCountByDocumentTitle;

		Object[] finderArgs = new Object[] {documentTitle};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOIIDMAPPER_WHERE);

			boolean bindDocumentTitle = false;

			if (documentTitle.isEmpty()) {
				sb.append(_FINDER_COLUMN_DOCUMENTTITLE_DOCUMENTTITLE_3);
			}
			else {
				bindDocumentTitle = true;

				sb.append(_FINDER_COLUMN_DOCUMENTTITLE_DOCUMENTTITLE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDocumentTitle) {
					queryPos.add(documentTitle);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DOCUMENTTITLE_DOCUMENTTITLE_2 =
		"moiIdMapper.documentTitle = ?";

	private static final String _FINDER_COLUMN_DOCUMENTTITLE_DOCUMENTTITLE_3 =
		"(moiIdMapper.documentTitle IS NULL OR moiIdMapper.documentTitle = '')";

	private FinderPath _finderPathWithPaginationFindByFileEntryId;
	private FinderPath _finderPathWithoutPaginationFindByFileEntryId;
	private FinderPath _finderPathCountByFileEntryId;

	/**
	 * Returns all the moi ID mappers where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @return the matching moi ID mappers
	 */
	@Override
	public List<MOIIdMapper> findByFileEntryId(String fileEntryId) {
		return findByFileEntryId(
			fileEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MOIIdMapper> findByFileEntryId(
		String fileEntryId, int start, int end) {

		return findByFileEntryId(fileEntryId, start, end, null);
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
	@Override
	public List<MOIIdMapper> findByFileEntryId(
		String fileEntryId, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator) {

		return findByFileEntryId(
			fileEntryId, start, end, orderByComparator, true);
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
	@Override
	public List<MOIIdMapper> findByFileEntryId(
		String fileEntryId, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator,
		boolean useFinderCache) {

		fileEntryId = Objects.toString(fileEntryId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFileEntryId;
				finderArgs = new Object[] {fileEntryId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFileEntryId;
			finderArgs = new Object[] {
				fileEntryId, start, end, orderByComparator
			};
		}

		List<MOIIdMapper> list = null;

		if (useFinderCache) {
			list = (List<MOIIdMapper>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOIIdMapper moiIdMapper : list) {
					if (!fileEntryId.equals(moiIdMapper.getFileEntryId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_MOIIDMAPPER_WHERE);

			boolean bindFileEntryId = false;

			if (fileEntryId.isEmpty()) {
				sb.append(_FINDER_COLUMN_FILEENTRYID_FILEENTRYID_3);
			}
			else {
				bindFileEntryId = true;

				sb.append(_FINDER_COLUMN_FILEENTRYID_FILEENTRYID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOIIdMapperModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFileEntryId) {
					queryPos.add(fileEntryId);
				}

				list = (List<MOIIdMapper>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper findByFileEntryId_First(
			String fileEntryId,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws NoSuchMOIIdMapperException {

		MOIIdMapper moiIdMapper = fetchByFileEntryId_First(
			fileEntryId, orderByComparator);

		if (moiIdMapper != null) {
			return moiIdMapper;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fileEntryId=");
		sb.append(fileEntryId);

		sb.append("}");

		throw new NoSuchMOIIdMapperException(sb.toString());
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper fetchByFileEntryId_First(
		String fileEntryId, OrderByComparator<MOIIdMapper> orderByComparator) {

		List<MOIIdMapper> list = findByFileEntryId(
			fileEntryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper findByFileEntryId_Last(
			String fileEntryId,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws NoSuchMOIIdMapperException {

		MOIIdMapper moiIdMapper = fetchByFileEntryId_Last(
			fileEntryId, orderByComparator);

		if (moiIdMapper != null) {
			return moiIdMapper;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fileEntryId=");
		sb.append(fileEntryId);

		sb.append("}");

		throw new NoSuchMOIIdMapperException(sb.toString());
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper fetchByFileEntryId_Last(
		String fileEntryId, OrderByComparator<MOIIdMapper> orderByComparator) {

		int count = countByFileEntryId(fileEntryId);

		if (count == 0) {
			return null;
		}

		List<MOIIdMapper> list = findByFileEntryId(
			fileEntryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MOIIdMapper[] findByFileEntryId_PrevAndNext(
			long mapperId, String fileEntryId,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws NoSuchMOIIdMapperException {

		fileEntryId = Objects.toString(fileEntryId, "");

		MOIIdMapper moiIdMapper = findByPrimaryKey(mapperId);

		Session session = null;

		try {
			session = openSession();

			MOIIdMapper[] array = new MOIIdMapperImpl[3];

			array[0] = getByFileEntryId_PrevAndNext(
				session, moiIdMapper, fileEntryId, orderByComparator, true);

			array[1] = moiIdMapper;

			array[2] = getByFileEntryId_PrevAndNext(
				session, moiIdMapper, fileEntryId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MOIIdMapper getByFileEntryId_PrevAndNext(
		Session session, MOIIdMapper moiIdMapper, String fileEntryId,
		OrderByComparator<MOIIdMapper> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MOIIDMAPPER_WHERE);

		boolean bindFileEntryId = false;

		if (fileEntryId.isEmpty()) {
			sb.append(_FINDER_COLUMN_FILEENTRYID_FILEENTRYID_3);
		}
		else {
			bindFileEntryId = true;

			sb.append(_FINDER_COLUMN_FILEENTRYID_FILEENTRYID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MOIIdMapperModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindFileEntryId) {
			queryPos.add(fileEntryId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(moiIdMapper)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MOIIdMapper> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the moi ID mappers where fileEntryId = &#63; from the database.
	 *
	 * @param fileEntryId the file entry ID
	 */
	@Override
	public void removeByFileEntryId(String fileEntryId) {
		for (MOIIdMapper moiIdMapper :
				findByFileEntryId(
					fileEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(moiIdMapper);
		}
	}

	/**
	 * Returns the number of moi ID mappers where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @return the number of matching moi ID mappers
	 */
	@Override
	public int countByFileEntryId(String fileEntryId) {
		fileEntryId = Objects.toString(fileEntryId, "");

		FinderPath finderPath = _finderPathCountByFileEntryId;

		Object[] finderArgs = new Object[] {fileEntryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOIIDMAPPER_WHERE);

			boolean bindFileEntryId = false;

			if (fileEntryId.isEmpty()) {
				sb.append(_FINDER_COLUMN_FILEENTRYID_FILEENTRYID_3);
			}
			else {
				bindFileEntryId = true;

				sb.append(_FINDER_COLUMN_FILEENTRYID_FILEENTRYID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFileEntryId) {
					queryPos.add(fileEntryId);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FILEENTRYID_FILEENTRYID_2 =
		"moiIdMapper.fileEntryId = ?";

	private static final String _FINDER_COLUMN_FILEENTRYID_FILEENTRYID_3 =
		"(moiIdMapper.fileEntryId IS NULL OR moiIdMapper.fileEntryId = '')";

	private FinderPath _finderPathWithPaginationFindByUpdateDate;
	private FinderPath _finderPathWithoutPaginationFindByUpdateDate;
	private FinderPath _finderPathCountByUpdateDate;

	/**
	 * Returns all the moi ID mappers where updateDate = &#63;.
	 *
	 * @param updateDate the update date
	 * @return the matching moi ID mappers
	 */
	@Override
	public List<MOIIdMapper> findByUpdateDate(Date updateDate) {
		return findByUpdateDate(
			updateDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MOIIdMapper> findByUpdateDate(
		Date updateDate, int start, int end) {

		return findByUpdateDate(updateDate, start, end, null);
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
	@Override
	public List<MOIIdMapper> findByUpdateDate(
		Date updateDate, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator) {

		return findByUpdateDate(
			updateDate, start, end, orderByComparator, true);
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
	@Override
	public List<MOIIdMapper> findByUpdateDate(
		Date updateDate, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUpdateDate;
				finderArgs = new Object[] {_getTime(updateDate)};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUpdateDate;
			finderArgs = new Object[] {
				_getTime(updateDate), start, end, orderByComparator
			};
		}

		List<MOIIdMapper> list = null;

		if (useFinderCache) {
			list = (List<MOIIdMapper>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOIIdMapper moiIdMapper : list) {
					if (!Objects.equals(
							updateDate, moiIdMapper.getUpdateDate())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_MOIIDMAPPER_WHERE);

			boolean bindUpdateDate = false;

			if (updateDate == null) {
				sb.append(_FINDER_COLUMN_UPDATEDATE_UPDATEDATE_1);
			}
			else {
				bindUpdateDate = true;

				sb.append(_FINDER_COLUMN_UPDATEDATE_UPDATEDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOIIdMapperModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUpdateDate) {
					queryPos.add(new Timestamp(updateDate.getTime()));
				}

				list = (List<MOIIdMapper>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where updateDate = &#63;.
	 *
	 * @param updateDate the update date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper findByUpdateDate_First(
			Date updateDate, OrderByComparator<MOIIdMapper> orderByComparator)
		throws NoSuchMOIIdMapperException {

		MOIIdMapper moiIdMapper = fetchByUpdateDate_First(
			updateDate, orderByComparator);

		if (moiIdMapper != null) {
			return moiIdMapper;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("updateDate=");
		sb.append(updateDate);

		sb.append("}");

		throw new NoSuchMOIIdMapperException(sb.toString());
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where updateDate = &#63;.
	 *
	 * @param updateDate the update date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper fetchByUpdateDate_First(
		Date updateDate, OrderByComparator<MOIIdMapper> orderByComparator) {

		List<MOIIdMapper> list = findByUpdateDate(
			updateDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where updateDate = &#63;.
	 *
	 * @param updateDate the update date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper findByUpdateDate_Last(
			Date updateDate, OrderByComparator<MOIIdMapper> orderByComparator)
		throws NoSuchMOIIdMapperException {

		MOIIdMapper moiIdMapper = fetchByUpdateDate_Last(
			updateDate, orderByComparator);

		if (moiIdMapper != null) {
			return moiIdMapper;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("updateDate=");
		sb.append(updateDate);

		sb.append("}");

		throw new NoSuchMOIIdMapperException(sb.toString());
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where updateDate = &#63;.
	 *
	 * @param updateDate the update date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper fetchByUpdateDate_Last(
		Date updateDate, OrderByComparator<MOIIdMapper> orderByComparator) {

		int count = countByUpdateDate(updateDate);

		if (count == 0) {
			return null;
		}

		List<MOIIdMapper> list = findByUpdateDate(
			updateDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MOIIdMapper[] findByUpdateDate_PrevAndNext(
			long mapperId, Date updateDate,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws NoSuchMOIIdMapperException {

		MOIIdMapper moiIdMapper = findByPrimaryKey(mapperId);

		Session session = null;

		try {
			session = openSession();

			MOIIdMapper[] array = new MOIIdMapperImpl[3];

			array[0] = getByUpdateDate_PrevAndNext(
				session, moiIdMapper, updateDate, orderByComparator, true);

			array[1] = moiIdMapper;

			array[2] = getByUpdateDate_PrevAndNext(
				session, moiIdMapper, updateDate, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MOIIdMapper getByUpdateDate_PrevAndNext(
		Session session, MOIIdMapper moiIdMapper, Date updateDate,
		OrderByComparator<MOIIdMapper> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MOIIDMAPPER_WHERE);

		boolean bindUpdateDate = false;

		if (updateDate == null) {
			sb.append(_FINDER_COLUMN_UPDATEDATE_UPDATEDATE_1);
		}
		else {
			bindUpdateDate = true;

			sb.append(_FINDER_COLUMN_UPDATEDATE_UPDATEDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MOIIdMapperModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUpdateDate) {
			queryPos.add(new Timestamp(updateDate.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(moiIdMapper)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MOIIdMapper> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the moi ID mappers where updateDate = &#63; from the database.
	 *
	 * @param updateDate the update date
	 */
	@Override
	public void removeByUpdateDate(Date updateDate) {
		for (MOIIdMapper moiIdMapper :
				findByUpdateDate(
					updateDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(moiIdMapper);
		}
	}

	/**
	 * Returns the number of moi ID mappers where updateDate = &#63;.
	 *
	 * @param updateDate the update date
	 * @return the number of matching moi ID mappers
	 */
	@Override
	public int countByUpdateDate(Date updateDate) {
		FinderPath finderPath = _finderPathCountByUpdateDate;

		Object[] finderArgs = new Object[] {_getTime(updateDate)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOIIDMAPPER_WHERE);

			boolean bindUpdateDate = false;

			if (updateDate == null) {
				sb.append(_FINDER_COLUMN_UPDATEDATE_UPDATEDATE_1);
			}
			else {
				bindUpdateDate = true;

				sb.append(_FINDER_COLUMN_UPDATEDATE_UPDATEDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUpdateDate) {
					queryPos.add(new Timestamp(updateDate.getTime()));
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UPDATEDATE_UPDATEDATE_1 =
		"moiIdMapper.updateDate IS NULL";

	private static final String _FINDER_COLUMN_UPDATEDATE_UPDATEDATE_2 =
		"moiIdMapper.updateDate = ?";

	private FinderPath _finderPathWithPaginationFindByUpdatedBy;
	private FinderPath _finderPathWithoutPaginationFindByUpdatedBy;
	private FinderPath _finderPathCountByUpdatedBy;

	/**
	 * Returns all the moi ID mappers where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @return the matching moi ID mappers
	 */
	@Override
	public List<MOIIdMapper> findByUpdatedBy(String updatedBy) {
		return findByUpdatedBy(
			updatedBy, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MOIIdMapper> findByUpdatedBy(
		String updatedBy, int start, int end) {

		return findByUpdatedBy(updatedBy, start, end, null);
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
	@Override
	public List<MOIIdMapper> findByUpdatedBy(
		String updatedBy, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator) {

		return findByUpdatedBy(updatedBy, start, end, orderByComparator, true);
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
	@Override
	public List<MOIIdMapper> findByUpdatedBy(
		String updatedBy, int start, int end,
		OrderByComparator<MOIIdMapper> orderByComparator,
		boolean useFinderCache) {

		updatedBy = Objects.toString(updatedBy, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUpdatedBy;
				finderArgs = new Object[] {updatedBy};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUpdatedBy;
			finderArgs = new Object[] {
				updatedBy, start, end, orderByComparator
			};
		}

		List<MOIIdMapper> list = null;

		if (useFinderCache) {
			list = (List<MOIIdMapper>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MOIIdMapper moiIdMapper : list) {
					if (!updatedBy.equals(moiIdMapper.getUpdatedBy())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_MOIIDMAPPER_WHERE);

			boolean bindUpdatedBy = false;

			if (updatedBy.isEmpty()) {
				sb.append(_FINDER_COLUMN_UPDATEDBY_UPDATEDBY_3);
			}
			else {
				bindUpdatedBy = true;

				sb.append(_FINDER_COLUMN_UPDATEDBY_UPDATEDBY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MOIIdMapperModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUpdatedBy) {
					queryPos.add(updatedBy);
				}

				list = (List<MOIIdMapper>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper findByUpdatedBy_First(
			String updatedBy, OrderByComparator<MOIIdMapper> orderByComparator)
		throws NoSuchMOIIdMapperException {

		MOIIdMapper moiIdMapper = fetchByUpdatedBy_First(
			updatedBy, orderByComparator);

		if (moiIdMapper != null) {
			return moiIdMapper;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("updatedBy=");
		sb.append(updatedBy);

		sb.append("}");

		throw new NoSuchMOIIdMapperException(sb.toString());
	}

	/**
	 * Returns the first moi ID mapper in the ordered set where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper fetchByUpdatedBy_First(
		String updatedBy, OrderByComparator<MOIIdMapper> orderByComparator) {

		List<MOIIdMapper> list = findByUpdatedBy(
			updatedBy, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper findByUpdatedBy_Last(
			String updatedBy, OrderByComparator<MOIIdMapper> orderByComparator)
		throws NoSuchMOIIdMapperException {

		MOIIdMapper moiIdMapper = fetchByUpdatedBy_Last(
			updatedBy, orderByComparator);

		if (moiIdMapper != null) {
			return moiIdMapper;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("updatedBy=");
		sb.append(updatedBy);

		sb.append("}");

		throw new NoSuchMOIIdMapperException(sb.toString());
	}

	/**
	 * Returns the last moi ID mapper in the ordered set where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching moi ID mapper, or <code>null</code> if a matching moi ID mapper could not be found
	 */
	@Override
	public MOIIdMapper fetchByUpdatedBy_Last(
		String updatedBy, OrderByComparator<MOIIdMapper> orderByComparator) {

		int count = countByUpdatedBy(updatedBy);

		if (count == 0) {
			return null;
		}

		List<MOIIdMapper> list = findByUpdatedBy(
			updatedBy, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MOIIdMapper[] findByUpdatedBy_PrevAndNext(
			long mapperId, String updatedBy,
			OrderByComparator<MOIIdMapper> orderByComparator)
		throws NoSuchMOIIdMapperException {

		updatedBy = Objects.toString(updatedBy, "");

		MOIIdMapper moiIdMapper = findByPrimaryKey(mapperId);

		Session session = null;

		try {
			session = openSession();

			MOIIdMapper[] array = new MOIIdMapperImpl[3];

			array[0] = getByUpdatedBy_PrevAndNext(
				session, moiIdMapper, updatedBy, orderByComparator, true);

			array[1] = moiIdMapper;

			array[2] = getByUpdatedBy_PrevAndNext(
				session, moiIdMapper, updatedBy, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MOIIdMapper getByUpdatedBy_PrevAndNext(
		Session session, MOIIdMapper moiIdMapper, String updatedBy,
		OrderByComparator<MOIIdMapper> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MOIIDMAPPER_WHERE);

		boolean bindUpdatedBy = false;

		if (updatedBy.isEmpty()) {
			sb.append(_FINDER_COLUMN_UPDATEDBY_UPDATEDBY_3);
		}
		else {
			bindUpdatedBy = true;

			sb.append(_FINDER_COLUMN_UPDATEDBY_UPDATEDBY_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MOIIdMapperModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUpdatedBy) {
			queryPos.add(updatedBy);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(moiIdMapper)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MOIIdMapper> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the moi ID mappers where updatedBy = &#63; from the database.
	 *
	 * @param updatedBy the updated by
	 */
	@Override
	public void removeByUpdatedBy(String updatedBy) {
		for (MOIIdMapper moiIdMapper :
				findByUpdatedBy(
					updatedBy, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(moiIdMapper);
		}
	}

	/**
	 * Returns the number of moi ID mappers where updatedBy = &#63;.
	 *
	 * @param updatedBy the updated by
	 * @return the number of matching moi ID mappers
	 */
	@Override
	public int countByUpdatedBy(String updatedBy) {
		updatedBy = Objects.toString(updatedBy, "");

		FinderPath finderPath = _finderPathCountByUpdatedBy;

		Object[] finderArgs = new Object[] {updatedBy};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MOIIDMAPPER_WHERE);

			boolean bindUpdatedBy = false;

			if (updatedBy.isEmpty()) {
				sb.append(_FINDER_COLUMN_UPDATEDBY_UPDATEDBY_3);
			}
			else {
				bindUpdatedBy = true;

				sb.append(_FINDER_COLUMN_UPDATEDBY_UPDATEDBY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUpdatedBy) {
					queryPos.add(updatedBy);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UPDATEDBY_UPDATEDBY_2 =
		"moiIdMapper.updatedBy = ?";

	private static final String _FINDER_COLUMN_UPDATEDBY_UPDATEDBY_3 =
		"(moiIdMapper.updatedBy IS NULL OR moiIdMapper.updatedBy = '')";

	public MOIIdMapperPersistenceImpl() {
		setModelClass(MOIIdMapper.class);

		setModelImplClass(MOIIdMapperImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the moi ID mapper in the entity cache if it is enabled.
	 *
	 * @param moiIdMapper the moi ID mapper
	 */
	@Override
	public void cacheResult(MOIIdMapper moiIdMapper) {
		entityCache.putResult(
			entityCacheEnabled, MOIIdMapperImpl.class,
			moiIdMapper.getPrimaryKey(), moiIdMapper);

		finderCache.putResult(
			_finderPathFetchByRegistrationId,
			new Object[] {moiIdMapper.getRegistrationId()}, moiIdMapper);

		finderCache.putResult(
			_finderPathFetchByRegistrationIdCurrentState,
			new Object[] {
				moiIdMapper.getRegistrationId(),
				moiIdMapper.getMosipCurrentState()
			},
			moiIdMapper);

		moiIdMapper.resetOriginalValues();
	}

	/**
	 * Caches the moi ID mappers in the entity cache if it is enabled.
	 *
	 * @param moiIdMappers the moi ID mappers
	 */
	@Override
	public void cacheResult(List<MOIIdMapper> moiIdMappers) {
		for (MOIIdMapper moiIdMapper : moiIdMappers) {
			if (entityCache.getResult(
					entityCacheEnabled, MOIIdMapperImpl.class,
					moiIdMapper.getPrimaryKey()) == null) {

				cacheResult(moiIdMapper);
			}
			else {
				moiIdMapper.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all moi ID mappers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MOIIdMapperImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the moi ID mapper.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MOIIdMapper moiIdMapper) {
		entityCache.removeResult(
			entityCacheEnabled, MOIIdMapperImpl.class,
			moiIdMapper.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((MOIIdMapperModelImpl)moiIdMapper, true);
	}

	@Override
	public void clearCache(List<MOIIdMapper> moiIdMappers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MOIIdMapper moiIdMapper : moiIdMappers) {
			entityCache.removeResult(
				entityCacheEnabled, MOIIdMapperImpl.class,
				moiIdMapper.getPrimaryKey());

			clearUniqueFindersCache((MOIIdMapperModelImpl)moiIdMapper, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, MOIIdMapperImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		MOIIdMapperModelImpl moiIdMapperModelImpl) {

		Object[] args = new Object[] {moiIdMapperModelImpl.getRegistrationId()};

		finderCache.putResult(
			_finderPathCountByRegistrationId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByRegistrationId, args, moiIdMapperModelImpl,
			false);

		args = new Object[] {
			moiIdMapperModelImpl.getRegistrationId(),
			moiIdMapperModelImpl.getMosipCurrentState()
		};

		finderCache.putResult(
			_finderPathCountByRegistrationIdCurrentState, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchByRegistrationIdCurrentState, args,
			moiIdMapperModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		MOIIdMapperModelImpl moiIdMapperModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				moiIdMapperModelImpl.getRegistrationId()
			};

			finderCache.removeResult(_finderPathCountByRegistrationId, args);
			finderCache.removeResult(_finderPathFetchByRegistrationId, args);
		}

		if ((moiIdMapperModelImpl.getColumnBitmask() &
			 _finderPathFetchByRegistrationId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				moiIdMapperModelImpl.getOriginalRegistrationId()
			};

			finderCache.removeResult(_finderPathCountByRegistrationId, args);
			finderCache.removeResult(_finderPathFetchByRegistrationId, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				moiIdMapperModelImpl.getRegistrationId(),
				moiIdMapperModelImpl.getMosipCurrentState()
			};

			finderCache.removeResult(
				_finderPathCountByRegistrationIdCurrentState, args);
			finderCache.removeResult(
				_finderPathFetchByRegistrationIdCurrentState, args);
		}

		if ((moiIdMapperModelImpl.getColumnBitmask() &
			 _finderPathFetchByRegistrationIdCurrentState.getColumnBitmask()) !=
				 0) {

			Object[] args = new Object[] {
				moiIdMapperModelImpl.getOriginalRegistrationId(),
				moiIdMapperModelImpl.getOriginalMosipCurrentState()
			};

			finderCache.removeResult(
				_finderPathCountByRegistrationIdCurrentState, args);
			finderCache.removeResult(
				_finderPathFetchByRegistrationIdCurrentState, args);
		}
	}

	/**
	 * Creates a new moi ID mapper with the primary key. Does not add the moi ID mapper to the database.
	 *
	 * @param mapperId the primary key for the new moi ID mapper
	 * @return the new moi ID mapper
	 */
	@Override
	public MOIIdMapper create(long mapperId) {
		MOIIdMapper moiIdMapper = new MOIIdMapperImpl();

		moiIdMapper.setNew(true);
		moiIdMapper.setPrimaryKey(mapperId);

		moiIdMapper.setCompanyId(CompanyThreadLocal.getCompanyId());

		return moiIdMapper;
	}

	/**
	 * Removes the moi ID mapper with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mapperId the primary key of the moi ID mapper
	 * @return the moi ID mapper that was removed
	 * @throws NoSuchMOIIdMapperException if a moi ID mapper with the primary key could not be found
	 */
	@Override
	public MOIIdMapper remove(long mapperId) throws NoSuchMOIIdMapperException {
		return remove((Serializable)mapperId);
	}

	/**
	 * Removes the moi ID mapper with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the moi ID mapper
	 * @return the moi ID mapper that was removed
	 * @throws NoSuchMOIIdMapperException if a moi ID mapper with the primary key could not be found
	 */
	@Override
	public MOIIdMapper remove(Serializable primaryKey)
		throws NoSuchMOIIdMapperException {

		Session session = null;

		try {
			session = openSession();

			MOIIdMapper moiIdMapper = (MOIIdMapper)session.get(
				MOIIdMapperImpl.class, primaryKey);

			if (moiIdMapper == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMOIIdMapperException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(moiIdMapper);
		}
		catch (NoSuchMOIIdMapperException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected MOIIdMapper removeImpl(MOIIdMapper moiIdMapper) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(moiIdMapper)) {
				moiIdMapper = (MOIIdMapper)session.get(
					MOIIdMapperImpl.class, moiIdMapper.getPrimaryKeyObj());
			}

			if (moiIdMapper != null) {
				session.delete(moiIdMapper);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (moiIdMapper != null) {
			clearCache(moiIdMapper);
		}

		return moiIdMapper;
	}

	@Override
	public MOIIdMapper updateImpl(MOIIdMapper moiIdMapper) {
		boolean isNew = moiIdMapper.isNew();

		if (!(moiIdMapper instanceof MOIIdMapperModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(moiIdMapper.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(moiIdMapper);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in moiIdMapper proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MOIIdMapper implementation " +
					moiIdMapper.getClass());
		}

		MOIIdMapperModelImpl moiIdMapperModelImpl =
			(MOIIdMapperModelImpl)moiIdMapper;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(moiIdMapper);

				moiIdMapper.setNew(false);
			}
			else {
				moiIdMapper = (MOIIdMapper)session.merge(moiIdMapper);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {moiIdMapperModelImpl.getMapperId()};

			finderCache.removeResult(_finderPathCountByMapperId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByMapperId, args);

			args = new Object[] {moiIdMapperModelImpl.getMosipCurrentState()};

			finderCache.removeResult(_finderPathCountByMosipCurrentState, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByMosipCurrentState, args);

			args = new Object[] {moiIdMapperModelImpl.getMosipDocumentType()};

			finderCache.removeResult(_finderPathCountByMosipDocumentType, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByMosipDocumentType, args);

			args = new Object[] {moiIdMapperModelImpl.getResourceId()};

			finderCache.removeResult(_finderPathCountByResourceId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByResourceId, args);

			args = new Object[] {moiIdMapperModelImpl.getDocumentTitle()};

			finderCache.removeResult(_finderPathCountByDocumentTitle, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDocumentTitle, args);

			args = new Object[] {moiIdMapperModelImpl.getFileEntryId()};

			finderCache.removeResult(_finderPathCountByFileEntryId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFileEntryId, args);

			args = new Object[] {moiIdMapperModelImpl.getUpdateDate()};

			finderCache.removeResult(_finderPathCountByUpdateDate, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUpdateDate, args);

			args = new Object[] {moiIdMapperModelImpl.getUpdatedBy()};

			finderCache.removeResult(_finderPathCountByUpdatedBy, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUpdatedBy, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((moiIdMapperModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByMapperId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					moiIdMapperModelImpl.getOriginalMapperId()
				};

				finderCache.removeResult(_finderPathCountByMapperId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByMapperId, args);

				args = new Object[] {moiIdMapperModelImpl.getMapperId()};

				finderCache.removeResult(_finderPathCountByMapperId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByMapperId, args);
			}

			if ((moiIdMapperModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByMosipCurrentState.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					moiIdMapperModelImpl.getOriginalMosipCurrentState()
				};

				finderCache.removeResult(
					_finderPathCountByMosipCurrentState, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByMosipCurrentState, args);

				args = new Object[] {
					moiIdMapperModelImpl.getMosipCurrentState()
				};

				finderCache.removeResult(
					_finderPathCountByMosipCurrentState, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByMosipCurrentState, args);
			}

			if ((moiIdMapperModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByMosipDocumentType.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					moiIdMapperModelImpl.getOriginalMosipDocumentType()
				};

				finderCache.removeResult(
					_finderPathCountByMosipDocumentType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByMosipDocumentType, args);

				args = new Object[] {
					moiIdMapperModelImpl.getMosipDocumentType()
				};

				finderCache.removeResult(
					_finderPathCountByMosipDocumentType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByMosipDocumentType, args);
			}

			if ((moiIdMapperModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByResourceId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					moiIdMapperModelImpl.getOriginalResourceId()
				};

				finderCache.removeResult(_finderPathCountByResourceId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByResourceId, args);

				args = new Object[] {moiIdMapperModelImpl.getResourceId()};

				finderCache.removeResult(_finderPathCountByResourceId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByResourceId, args);
			}

			if ((moiIdMapperModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDocumentTitle.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					moiIdMapperModelImpl.getOriginalDocumentTitle()
				};

				finderCache.removeResult(_finderPathCountByDocumentTitle, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocumentTitle, args);

				args = new Object[] {moiIdMapperModelImpl.getDocumentTitle()};

				finderCache.removeResult(_finderPathCountByDocumentTitle, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocumentTitle, args);
			}

			if ((moiIdMapperModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFileEntryId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					moiIdMapperModelImpl.getOriginalFileEntryId()
				};

				finderCache.removeResult(_finderPathCountByFileEntryId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFileEntryId, args);

				args = new Object[] {moiIdMapperModelImpl.getFileEntryId()};

				finderCache.removeResult(_finderPathCountByFileEntryId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFileEntryId, args);
			}

			if ((moiIdMapperModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUpdateDate.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					moiIdMapperModelImpl.getOriginalUpdateDate()
				};

				finderCache.removeResult(_finderPathCountByUpdateDate, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUpdateDate, args);

				args = new Object[] {moiIdMapperModelImpl.getUpdateDate()};

				finderCache.removeResult(_finderPathCountByUpdateDate, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUpdateDate, args);
			}

			if ((moiIdMapperModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUpdatedBy.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					moiIdMapperModelImpl.getOriginalUpdatedBy()
				};

				finderCache.removeResult(_finderPathCountByUpdatedBy, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUpdatedBy, args);

				args = new Object[] {moiIdMapperModelImpl.getUpdatedBy()};

				finderCache.removeResult(_finderPathCountByUpdatedBy, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUpdatedBy, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, MOIIdMapperImpl.class,
			moiIdMapper.getPrimaryKey(), moiIdMapper, false);

		clearUniqueFindersCache(moiIdMapperModelImpl, false);
		cacheUniqueFindersCache(moiIdMapperModelImpl);

		moiIdMapper.resetOriginalValues();

		return moiIdMapper;
	}

	/**
	 * Returns the moi ID mapper with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the moi ID mapper
	 * @return the moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a moi ID mapper with the primary key could not be found
	 */
	@Override
	public MOIIdMapper findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMOIIdMapperException {

		MOIIdMapper moiIdMapper = fetchByPrimaryKey(primaryKey);

		if (moiIdMapper == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMOIIdMapperException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return moiIdMapper;
	}

	/**
	 * Returns the moi ID mapper with the primary key or throws a <code>NoSuchMOIIdMapperException</code> if it could not be found.
	 *
	 * @param mapperId the primary key of the moi ID mapper
	 * @return the moi ID mapper
	 * @throws NoSuchMOIIdMapperException if a moi ID mapper with the primary key could not be found
	 */
	@Override
	public MOIIdMapper findByPrimaryKey(long mapperId)
		throws NoSuchMOIIdMapperException {

		return findByPrimaryKey((Serializable)mapperId);
	}

	/**
	 * Returns the moi ID mapper with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mapperId the primary key of the moi ID mapper
	 * @return the moi ID mapper, or <code>null</code> if a moi ID mapper with the primary key could not be found
	 */
	@Override
	public MOIIdMapper fetchByPrimaryKey(long mapperId) {
		return fetchByPrimaryKey((Serializable)mapperId);
	}

	/**
	 * Returns all the moi ID mappers.
	 *
	 * @return the moi ID mappers
	 */
	@Override
	public List<MOIIdMapper> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MOIIdMapper> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<MOIIdMapper> findAll(
		int start, int end, OrderByComparator<MOIIdMapper> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<MOIIdMapper> findAll(
		int start, int end, OrderByComparator<MOIIdMapper> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<MOIIdMapper> list = null;

		if (useFinderCache) {
			list = (List<MOIIdMapper>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MOIIDMAPPER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MOIIDMAPPER;

				sql = sql.concat(MOIIdMapperModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MOIIdMapper>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the moi ID mappers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MOIIdMapper moiIdMapper : findAll()) {
			remove(moiIdMapper);
		}
	}

	/**
	 * Returns the number of moi ID mappers.
	 *
	 * @return the number of moi ID mappers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MOIIDMAPPER);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "mapperId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MOIIDMAPPER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MOIIdMapperModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the moi ID mapper persistence.
	 */
	@Activate
	public void activate() {
		MOIIdMapperModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		MOIIdMapperModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIIdMapperImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIIdMapperImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByMapperId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIIdMapperImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMapperId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByMapperId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIIdMapperImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMapperId",
			new String[] {Long.class.getName()},
			MOIIdMapperModelImpl.MAPPERID_COLUMN_BITMASK);

		_finderPathCountByMapperId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMapperId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByMosipCurrentState = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIIdMapperImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMosipCurrentState",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByMosipCurrentState = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIIdMapperImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMosipCurrentState", new String[] {String.class.getName()},
			MOIIdMapperModelImpl.MOSIPCURRENTSTATE_COLUMN_BITMASK);

		_finderPathCountByMosipCurrentState = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMosipCurrentState", new String[] {String.class.getName()});

		_finderPathWithPaginationFindByMosipDocumentType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIIdMapperImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMosipDocumentType",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByMosipDocumentType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIIdMapperImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMosipDocumentType", new String[] {String.class.getName()},
			MOIIdMapperModelImpl.MOSIPDOCUMENTTYPE_COLUMN_BITMASK);

		_finderPathCountByMosipDocumentType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMosipDocumentType", new String[] {String.class.getName()});

		_finderPathFetchByRegistrationId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIIdMapperImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByRegistrationId",
			new String[] {String.class.getName()},
			MOIIdMapperModelImpl.REGISTRATIONID_COLUMN_BITMASK);

		_finderPathCountByRegistrationId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRegistrationId",
			new String[] {String.class.getName()});

		_finderPathFetchByRegistrationIdCurrentState = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIIdMapperImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByRegistrationIdCurrentState",
			new String[] {String.class.getName(), String.class.getName()},
			MOIIdMapperModelImpl.REGISTRATIONID_COLUMN_BITMASK |
			MOIIdMapperModelImpl.MOSIPCURRENTSTATE_COLUMN_BITMASK);

		_finderPathCountByRegistrationIdCurrentState = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRegistrationIdCurrentState",
			new String[] {String.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByResourceId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIIdMapperImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByResourceId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByResourceId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIIdMapperImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByResourceId",
			new String[] {Long.class.getName()},
			MOIIdMapperModelImpl.RESOURCEID_COLUMN_BITMASK);

		_finderPathCountByResourceId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByResourceId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByDocumentTitle = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIIdMapperImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDocumentTitle",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDocumentTitle = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIIdMapperImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDocumentTitle",
			new String[] {String.class.getName()},
			MOIIdMapperModelImpl.DOCUMENTTITLE_COLUMN_BITMASK);

		_finderPathCountByDocumentTitle = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDocumentTitle",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByFileEntryId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIIdMapperImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFileEntryId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFileEntryId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIIdMapperImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFileEntryId",
			new String[] {String.class.getName()},
			MOIIdMapperModelImpl.FILEENTRYID_COLUMN_BITMASK);

		_finderPathCountByFileEntryId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFileEntryId",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByUpdateDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIIdMapperImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUpdateDate",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUpdateDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIIdMapperImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUpdateDate",
			new String[] {Date.class.getName()},
			MOIIdMapperModelImpl.UPDATEDATE_COLUMN_BITMASK);

		_finderPathCountByUpdateDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUpdateDate",
			new String[] {Date.class.getName()});

		_finderPathWithPaginationFindByUpdatedBy = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIIdMapperImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUpdatedBy",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUpdatedBy = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MOIIdMapperImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUpdatedBy",
			new String[] {String.class.getName()},
			MOIIdMapperModelImpl.UPDATEDBY_COLUMN_BITMASK);

		_finderPathCountByUpdatedBy = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUpdatedBy",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(MOIIdMapperImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = moiidmPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.moi.dms.id.mapper.model.MOIIdMapper"),
			true);
	}

	@Override
	@Reference(
		target = moiidmPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = moiidmPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_MOIIDMAPPER =
		"SELECT moiIdMapper FROM MOIIdMapper moiIdMapper";

	private static final String _SQL_SELECT_MOIIDMAPPER_WHERE =
		"SELECT moiIdMapper FROM MOIIdMapper moiIdMapper WHERE ";

	private static final String _SQL_COUNT_MOIIDMAPPER =
		"SELECT COUNT(moiIdMapper) FROM MOIIdMapper moiIdMapper";

	private static final String _SQL_COUNT_MOIIDMAPPER_WHERE =
		"SELECT COUNT(moiIdMapper) FROM MOIIdMapper moiIdMapper WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "moiIdMapper.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MOIIdMapper exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MOIIdMapper exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MOIIdMapperPersistenceImpl.class);

	static {
		try {
			Class.forName(moiidmPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}