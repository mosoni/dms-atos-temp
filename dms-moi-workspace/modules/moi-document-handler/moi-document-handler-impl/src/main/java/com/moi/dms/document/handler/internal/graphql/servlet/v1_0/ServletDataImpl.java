package com.moi.dms.document.handler.internal.graphql.servlet.v1_0;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import com.moi.dms.document.handler.internal.graphql.mutation.v1_0.Mutation;
import com.moi.dms.document.handler.internal.graphql.query.v1_0.Query;
import com.moi.dms.document.handler.resource.v1_0.MosipDocumentHandlerResource;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author Mohit
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Query.setMosipDocumentHandlerResourceComponentServiceObjects(
			_mosipDocumentHandlerResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/moi-document-handler-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<MosipDocumentHandlerResource>
		_mosipDocumentHandlerResourceComponentServiceObjects;

}