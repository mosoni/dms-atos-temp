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

package com.moi.dms.delete.documents.model.impl;

import com.moi.dms.delete.documents.model.MOIDeleteDocuments;
import com.moi.dms.delete.documents.service.MOIDeleteDocumentsLocalServiceUtil;

/**
 * The extended model base implementation for the MOIDeleteDocuments service. Represents a row in the &quot;moi_deletedocuments&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MOIDeleteDocumentsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MOIDeleteDocumentsImpl
 * @see MOIDeleteDocuments
 * @generated
 */
public abstract class MOIDeleteDocumentsBaseImpl
	extends MOIDeleteDocumentsModelImpl implements MOIDeleteDocuments {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a moi delete documents model instance should use the <code>MOIDeleteDocuments</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			MOIDeleteDocumentsLocalServiceUtil.addMOIDeleteDocuments(this);
		}
		else {
			MOIDeleteDocumentsLocalServiceUtil.updateMOIDeleteDocuments(this);
		}
	}

}