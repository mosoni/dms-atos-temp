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

package com.moi.dms.audit.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.moi.dms.audit.service.MOIAuditServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>MOIAuditServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.moi.dms.audit.model.MOIAuditSoap</code>. If the method in the
 * service utility returns a
 * <code>com.moi.dms.audit.model.MOIAudit</code>, that is translated to a
 * <code>com.moi.dms.audit.model.MOIAuditSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MOIAuditServiceHttp
 * @generated
 */
public class MOIAuditServiceSoap {

	public static com.moi.dms.audit.model.MOIAuditSoap[] getMOIAuditByKeywords(
			String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.moi.dms.audit.model.MOIAudit> orderByComparator)
		throws RemoteException {

		try {
			java.util.List<com.moi.dms.audit.model.MOIAudit> returnValue =
				MOIAuditServiceUtil.getMOIAuditByKeywords(
					keywords, start, end, orderByComparator);

			return com.moi.dms.audit.model.MOIAuditSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Remote service to fetch MOIAudit using keywords
	 *
	 * @param keywords
	 * @param fromDate
	 * @param toDate
	 * @param start
	 * @param end
	 * @param orderByComparator
	 * @return List<MOIAudit>
	 */
	public static com.moi.dms.audit.model.MOIAuditSoap[]
			getMOIAuditBySearchCriteria(
				String keywords, String fromDate, String toDate, int start,
				int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.moi.dms.audit.model.MOIAudit> orderByComparator)
		throws RemoteException {

		try {
			java.util.List<com.moi.dms.audit.model.MOIAudit> returnValue =
				MOIAuditServiceUtil.getMOIAuditBySearchCriteria(
					keywords, fromDate, toDate, start, end, orderByComparator);

			return com.moi.dms.audit.model.MOIAuditSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(MOIAuditServiceSoap.class);

}