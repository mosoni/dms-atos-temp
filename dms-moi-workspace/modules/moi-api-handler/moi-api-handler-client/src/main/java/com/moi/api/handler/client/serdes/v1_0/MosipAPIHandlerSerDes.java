package com.moi.api.handler.client.serdes.v1_0;

import com.moi.api.handler.client.dto.v1_0.MosipAPIHandler;
import com.moi.api.handler.client.json.BaseJSONParser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
public class MosipAPIHandlerSerDes {

	public static MosipAPIHandler toDTO(String json) {
		MosipAPIHandlerJSONParser mosipAPIHandlerJSONParser =
			new MosipAPIHandlerJSONParser();

		return mosipAPIHandlerJSONParser.parseToDTO(json);
	}

	public static MosipAPIHandler[] toDTOs(String json) {
		MosipAPIHandlerJSONParser mosipAPIHandlerJSONParser =
			new MosipAPIHandlerJSONParser();

		return mosipAPIHandlerJSONParser.parseToDTOs(json);
	}

	public static String toJSON(MosipAPIHandler mosipAPIHandler) {
		if (mosipAPIHandler == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (mosipAPIHandler.getDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"date\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(mosipAPIHandler.getDate()));

			sb.append("\"");
		}

		if (mosipAPIHandler.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(mosipAPIHandler.getId());
		}

		if (mosipAPIHandler.getTitle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"title\": ");

			sb.append("\"");

			sb.append(_escape(mosipAPIHandler.getTitle()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		MosipAPIHandlerJSONParser mosipAPIHandlerJSONParser =
			new MosipAPIHandlerJSONParser();

		return mosipAPIHandlerJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(MosipAPIHandler mosipAPIHandler) {
		if (mosipAPIHandler == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (mosipAPIHandler.getDate() == null) {
			map.put("date", null);
		}
		else {
			map.put(
				"date",
				liferayToJSONDateFormat.format(mosipAPIHandler.getDate()));
		}

		if (mosipAPIHandler.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(mosipAPIHandler.getId()));
		}

		if (mosipAPIHandler.getTitle() == null) {
			map.put("title", null);
		}
		else {
			map.put("title", String.valueOf(mosipAPIHandler.getTitle()));
		}

		return map;
	}

	public static class MosipAPIHandlerJSONParser
		extends BaseJSONParser<MosipAPIHandler> {

		@Override
		protected MosipAPIHandler createDTO() {
			return new MosipAPIHandler();
		}

		@Override
		protected MosipAPIHandler[] createDTOArray(int size) {
			return new MosipAPIHandler[size];
		}

		@Override
		protected void setField(
			MosipAPIHandler mosipAPIHandler, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "date")) {
				if (jsonParserFieldValue != null) {
					mosipAPIHandler.setDate(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					mosipAPIHandler.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "title")) {
				if (jsonParserFieldValue != null) {
					mosipAPIHandler.setTitle((String)jsonParserFieldValue);
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