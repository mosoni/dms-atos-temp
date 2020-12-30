package com.moi.api.handler.client.serdes.v1_0;

import com.moi.api.handler.client.dto.v1_0.JiraAPIHandler;
import com.moi.api.handler.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author Mohit
 * @generated
 */
@Generated("")
public class JiraAPIHandlerSerDes {

	public static JiraAPIHandler toDTO(String json) {
		JiraAPIHandlerJSONParser jiraAPIHandlerJSONParser =
			new JiraAPIHandlerJSONParser();

		return jiraAPIHandlerJSONParser.parseToDTO(json);
	}

	public static JiraAPIHandler[] toDTOs(String json) {
		JiraAPIHandlerJSONParser jiraAPIHandlerJSONParser =
			new JiraAPIHandlerJSONParser();

		return jiraAPIHandlerJSONParser.parseToDTOs(json);
	}

	public static String toJSON(JiraAPIHandler jiraAPIHandler) {
		if (jiraAPIHandler == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (jiraAPIHandler.getFolderName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"folderName\": ");

			sb.append("\"");

			sb.append(_escape(jiraAPIHandler.getFolderName()));

			sb.append("\"");
		}

		if (jiraAPIHandler.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(jiraAPIHandler.getId());
		}

		if (jiraAPIHandler.getMimeType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"mimeType\": ");

			sb.append("\"");

			sb.append(_escape(jiraAPIHandler.getMimeType()));

			sb.append("\"");
		}

		if (jiraAPIHandler.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(jiraAPIHandler.getName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		JiraAPIHandlerJSONParser jiraAPIHandlerJSONParser =
			new JiraAPIHandlerJSONParser();

		return jiraAPIHandlerJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(JiraAPIHandler jiraAPIHandler) {
		if (jiraAPIHandler == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (jiraAPIHandler.getFolderName() == null) {
			map.put("folderName", null);
		}
		else {
			map.put(
				"folderName", String.valueOf(jiraAPIHandler.getFolderName()));
		}

		if (jiraAPIHandler.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(jiraAPIHandler.getId()));
		}

		if (jiraAPIHandler.getMimeType() == null) {
			map.put("mimeType", null);
		}
		else {
			map.put("mimeType", String.valueOf(jiraAPIHandler.getMimeType()));
		}

		if (jiraAPIHandler.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(jiraAPIHandler.getName()));
		}

		return map;
	}

	public static class JiraAPIHandlerJSONParser
		extends BaseJSONParser<JiraAPIHandler> {

		@Override
		protected JiraAPIHandler createDTO() {
			return new JiraAPIHandler();
		}

		@Override
		protected JiraAPIHandler[] createDTOArray(int size) {
			return new JiraAPIHandler[size];
		}

		@Override
		protected void setField(
			JiraAPIHandler jiraAPIHandler, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "folderName")) {
				if (jsonParserFieldValue != null) {
					jiraAPIHandler.setFolderName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					jiraAPIHandler.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "mimeType")) {
				if (jsonParserFieldValue != null) {
					jiraAPIHandler.setMimeType((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					jiraAPIHandler.setName((String)jsonParserFieldValue);
				}
			}
			else {
				throw new IllegalArgumentException(
					"Unsupported field name " + jsonParserFieldName);
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\":");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(",");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}