package com.moi.dms.document.handler.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import com.moi.dms.document.handler.client.dto.v1_0.MosipDocumentHandler;
import com.moi.dms.document.handler.client.http.HttpInvoker;
import com.moi.dms.document.handler.client.pagination.Page;
import com.moi.dms.document.handler.client.resource.v1_0.MosipDocumentHandlerResource;
import com.moi.dms.document.handler.client.serdes.v1_0.MosipDocumentHandlerSerDes;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang.time.DateUtils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Mohit
 * @generated
 */
@Generated("")
public abstract class BaseMosipDocumentHandlerResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_mosipDocumentHandlerResource.setContextCompany(testCompany);

		MosipDocumentHandlerResource.Builder builder =
			MosipDocumentHandlerResource.builder();

		mosipDocumentHandlerResource = builder.locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		MosipDocumentHandler mosipDocumentHandler1 =
			randomMosipDocumentHandler();

		String json = objectMapper.writeValueAsString(mosipDocumentHandler1);

		MosipDocumentHandler mosipDocumentHandler2 =
			MosipDocumentHandlerSerDes.toDTO(json);

		Assert.assertTrue(equals(mosipDocumentHandler1, mosipDocumentHandler2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		MosipDocumentHandler mosipDocumentHandler =
			randomMosipDocumentHandler();

		String json1 = objectMapper.writeValueAsString(mosipDocumentHandler);
		String json2 = MosipDocumentHandlerSerDes.toJSON(mosipDocumentHandler);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		MosipDocumentHandler mosipDocumentHandler =
			randomMosipDocumentHandler();

		mosipDocumentHandler.setTitle(regex);

		String json = MosipDocumentHandlerSerDes.toJSON(mosipDocumentHandler);

		Assert.assertFalse(json.contains(regex));

		mosipDocumentHandler = MosipDocumentHandlerSerDes.toDTO(json);

		Assert.assertEquals(regex, mosipDocumentHandler.getTitle());
	}

	@Test
	public void testGetSiteAppointmentsPage() throws Exception {
		Page<MosipDocumentHandler> page =
			mosipDocumentHandlerResource.getSiteAppointmentsPage(
				testGetSiteAppointmentsPage_getSiteId());

		Assert.assertEquals(0, page.getTotalCount());

		Long siteId = testGetSiteAppointmentsPage_getSiteId();
		Long irrelevantSiteId =
			testGetSiteAppointmentsPage_getIrrelevantSiteId();

		if ((irrelevantSiteId != null)) {
			MosipDocumentHandler irrelevantMosipDocumentHandler =
				testGetSiteAppointmentsPage_addMosipDocumentHandler(
					irrelevantSiteId, randomIrrelevantMosipDocumentHandler());

			page = mosipDocumentHandlerResource.getSiteAppointmentsPage(
				irrelevantSiteId);

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantMosipDocumentHandler),
				(List<MosipDocumentHandler>)page.getItems());
			assertValid(page);
		}

		MosipDocumentHandler mosipDocumentHandler1 =
			testGetSiteAppointmentsPage_addMosipDocumentHandler(
				siteId, randomMosipDocumentHandler());

		MosipDocumentHandler mosipDocumentHandler2 =
			testGetSiteAppointmentsPage_addMosipDocumentHandler(
				siteId, randomMosipDocumentHandler());

		page = mosipDocumentHandlerResource.getSiteAppointmentsPage(siteId);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(mosipDocumentHandler1, mosipDocumentHandler2),
			(List<MosipDocumentHandler>)page.getItems());
		assertValid(page);
	}

	protected MosipDocumentHandler
			testGetSiteAppointmentsPage_addMosipDocumentHandler(
				Long siteId, MosipDocumentHandler mosipDocumentHandler)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetSiteAppointmentsPage_getSiteId() throws Exception {
		return testGroup.getGroupId();
	}

	protected Long testGetSiteAppointmentsPage_getIrrelevantSiteId()
		throws Exception {

		return irrelevantGroup.getGroupId();
	}

	protected MosipDocumentHandler
			testGraphQLMosipDocumentHandler_addMosipDocumentHandler()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		MosipDocumentHandler mosipDocumentHandler1,
		MosipDocumentHandler mosipDocumentHandler2) {

		Assert.assertTrue(
			mosipDocumentHandler1 + " does not equal " + mosipDocumentHandler2,
			equals(mosipDocumentHandler1, mosipDocumentHandler2));
	}

	protected void assertEquals(
		List<MosipDocumentHandler> mosipDocumentHandlers1,
		List<MosipDocumentHandler> mosipDocumentHandlers2) {

		Assert.assertEquals(
			mosipDocumentHandlers1.size(), mosipDocumentHandlers2.size());

		for (int i = 0; i < mosipDocumentHandlers1.size(); i++) {
			MosipDocumentHandler mosipDocumentHandler1 =
				mosipDocumentHandlers1.get(i);
			MosipDocumentHandler mosipDocumentHandler2 =
				mosipDocumentHandlers2.get(i);

			assertEquals(mosipDocumentHandler1, mosipDocumentHandler2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<MosipDocumentHandler> mosipDocumentHandlers1,
		List<MosipDocumentHandler> mosipDocumentHandlers2) {

		Assert.assertEquals(
			mosipDocumentHandlers1.size(), mosipDocumentHandlers2.size());

		for (MosipDocumentHandler mosipDocumentHandler1 :
				mosipDocumentHandlers1) {

			boolean contains = false;

			for (MosipDocumentHandler mosipDocumentHandler2 :
					mosipDocumentHandlers2) {

				if (equals(mosipDocumentHandler1, mosipDocumentHandler2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				mosipDocumentHandlers2 + " does not contain " +
					mosipDocumentHandler1,
				contains);
		}
	}

	protected void assertValid(MosipDocumentHandler mosipDocumentHandler) {
		boolean valid = true;

		if (mosipDocumentHandler.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("date", additionalAssertFieldName)) {
				if (mosipDocumentHandler.getDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("title", additionalAssertFieldName)) {
				if (mosipDocumentHandler.getTitle() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<MosipDocumentHandler> page) {
		boolean valid = false;

		java.util.Collection<MosipDocumentHandler> mosipDocumentHandlers =
			page.getItems();

		int size = mosipDocumentHandlers.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (Field field :
				ReflectionUtil.getDeclaredFields(
					com.moi.dms.document.handler.dto.v1_0.MosipDocumentHandler.
						class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					ReflectionUtil.getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(
		MosipDocumentHandler mosipDocumentHandler1,
		MosipDocumentHandler mosipDocumentHandler2) {

		if (mosipDocumentHandler1 == mosipDocumentHandler2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("date", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						mosipDocumentHandler1.getDate(),
						mosipDocumentHandler2.getDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						mosipDocumentHandler1.getId(),
						mosipDocumentHandler2.getId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("title", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						mosipDocumentHandler1.getTitle(),
						mosipDocumentHandler2.getTitle())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}
		}

		return true;
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_mosipDocumentHandlerResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_mosipDocumentHandlerResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator,
		MosipDocumentHandler mosipDocumentHandler) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("date")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(
							mosipDocumentHandler.getDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(
							mosipDocumentHandler.getDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(mosipDocumentHandler.getDate()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("title")) {
			sb.append("'");
			sb.append(String.valueOf(mosipDocumentHandler.getTitle()));
			sb.append("'");

			return sb.toString();
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected MosipDocumentHandler randomMosipDocumentHandler()
		throws Exception {

		return new MosipDocumentHandler() {
			{
				date = RandomTestUtil.nextDate();
				id = RandomTestUtil.randomLong();
				title = StringUtil.toLowerCase(RandomTestUtil.randomString());
			}
		};
	}

	protected MosipDocumentHandler randomIrrelevantMosipDocumentHandler()
		throws Exception {

		MosipDocumentHandler randomIrrelevantMosipDocumentHandler =
			randomMosipDocumentHandler();

		return randomIrrelevantMosipDocumentHandler;
	}

	protected MosipDocumentHandler randomPatchMosipDocumentHandler()
		throws Exception {

		return randomMosipDocumentHandler();
	}

	protected MosipDocumentHandlerResource mosipDocumentHandlerResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(":");
					sb.append(entry.getValue());
					sb.append(",");
				}

				sb.setLength(sb.length() - 1);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(",");
				}

				sb.setLength(sb.length() - 1);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final Log _log = LogFactoryUtil.getLog(
		BaseMosipDocumentHandlerResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private
		com.moi.dms.document.handler.resource.v1_0.MosipDocumentHandlerResource
			_mosipDocumentHandlerResource;

}