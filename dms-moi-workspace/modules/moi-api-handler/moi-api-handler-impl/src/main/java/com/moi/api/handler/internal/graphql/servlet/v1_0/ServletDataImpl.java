package com.moi.api.handler.internal.graphql.servlet.v1_0;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import com.moi.api.handler.internal.graphql.mutation.v1_0.Mutation;
import com.moi.api.handler.internal.graphql.query.v1_0.Query;
import com.moi.api.handler.resource.v1_0.DocumentResultResource;

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
		Mutation.setDocumentResultResourceComponentServiceObjects(
			_documentResultResourceComponentServiceObjects);

		Query.setDocumentResultResourceComponentServiceObjects(
			_documentResultResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/moi-api-handler-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<DocumentResultResource>
		_documentResultResourceComponentServiceObjects;

}