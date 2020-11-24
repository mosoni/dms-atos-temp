package com.moi.dms.document.handler.client.serdes.v1_0;

import com.moi.dms.document.handler.client.dto.v1_0.MosipDocumentHandler;
import com.moi.dms.document.handler.client.json.BaseJSONParser;

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
public class MosipDocumentHandlerSerDes {

	public static MosipDocumentHandler toDTO(String json) {
		MosipDocumentHandlerJSONParser mosipDocumentHandlerJSONParser =
			new MosipDocumentHandlerJSONParser();

		return mosipDocumentHandlerJSONParser.parseToDTO(json);
	}

	public static MosipDocumentHandler[] toDTOs(String json) {
		MosipDocumentHandlerJSONParser mosipDocumentHandlerJSONParser =
			new MosipDocumentHandlerJSONParser();

		return mosipDocumentHandlerJSONParser.parseToDTOs(json);
	}

	public static String toJSON(MosipDocumentHandler mosipDocumentHandler) {
		if (mosipDocumentHandler == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (mosipDocumentHandler.getDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"date\": ");

			sb.append("\"");

			sb.append(
				liferayToJSONDateFormat.format(mosipDocumentHandler.getDate()));

			sb.append("\"");
		}

		if (mosipDocumentHandler.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(mosipDocumentHandler.getId());
		}

		if (mosipDocumentHandler.getTitle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"title\": ");

			sb.append("\"");

			sb.append(_escape(mosipDocumentHandler.getTitle()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		MosipDocumentHandlerJSONParser mosipDocumentHandlerJSONParser =
			new MosipDocumentHandlerJSONParser();

		return mosipDocumentHandlerJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		MosipDocumentHandler mosipDocumentHandler) {

		if (mosipDocumentHandler == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (mosipDocumentHandler.getDate() == null) {
			map.put("date", null);
		}
		else {
			map.put(
				"date",
				liferayToJSONDateFormat.format(mosipDocumentHandler.getDate()));
		}

		if (mosipDocumentHandler.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(mosipDocumentHandler.getId()));
		}

		if (mosipDocumentHandler.getTitle() == null) {
			map.put("title", null);
		}
		else {
			map.put("title", String.valueOf(mosipDocumentHandler.getTitle()));
		}

		return map;
	}

	public static class MosipDocumentHandlerJSONParser
		extends BaseJSONParser<MosipDocumentHandler> {

		@Override
		protected MosipDocumentHandler createDTO() {
			return new MosipDocumentHandler();
		}

		@Override
		protected MosipDocumentHandler[] createDTOArray(int size) {
			return new MosipDocumentHandler[size];
		}

		@Override
		protected void setField(
			MosipDocumentHandler mosipDocumentHandler,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "date")) {
				if (jsonParserFieldValue != null) {
					mosipDocumentHandler.setDate(
						toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					mosipDocumentHandler.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "title")) {
				if (jsonParserFieldValue != null) {
					mosipDocumentHandler.setTitle((String)jsonParserFieldValue);
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