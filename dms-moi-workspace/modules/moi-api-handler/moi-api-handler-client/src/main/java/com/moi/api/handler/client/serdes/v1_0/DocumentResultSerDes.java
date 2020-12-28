package com.moi.api.handler.client.serdes.v1_0;

import com.moi.api.handler.client.dto.v1_0.DocumentResult;
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
public class DocumentResultSerDes {

	public static DocumentResult toDTO(String json) {
		DocumentResultJSONParser documentResultJSONParser =
			new DocumentResultJSONParser();

		return documentResultJSONParser.parseToDTO(json);
	}

	public static DocumentResult[] toDTOs(String json) {
		DocumentResultJSONParser documentResultJSONParser =
			new DocumentResultJSONParser();

		return documentResultJSONParser.parseToDTOs(json);
	}

	public static String toJSON(DocumentResult documentResult) {
		if (documentResult == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (documentResult.getFolderName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"folderName\": ");

			sb.append("\"");

			sb.append(_escape(documentResult.getFolderName()));

			sb.append("\"");
		}

		if (documentResult.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(documentResult.getId());
		}

		if (documentResult.getMimeType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"mimeType\": ");

			sb.append("\"");

			sb.append(_escape(documentResult.getMimeType()));

			sb.append("\"");
		}

		if (documentResult.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(documentResult.getName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		DocumentResultJSONParser documentResultJSONParser =
			new DocumentResultJSONParser();

		return documentResultJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(DocumentResult documentResult) {
		if (documentResult == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (documentResult.getFolderName() == null) {
			map.put("folderName", null);
		}
		else {
			map.put(
				"folderName", String.valueOf(documentResult.getFolderName()));
		}

		if (documentResult.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(documentResult.getId()));
		}

		if (documentResult.getMimeType() == null) {
			map.put("mimeType", null);
		}
		else {
			map.put("mimeType", String.valueOf(documentResult.getMimeType()));
		}

		if (documentResult.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(documentResult.getName()));
		}

		return map;
	}

	public static class DocumentResultJSONParser
		extends BaseJSONParser<DocumentResult> {

		@Override
		protected DocumentResult createDTO() {
			return new DocumentResult();
		}

		@Override
		protected DocumentResult[] createDTOArray(int size) {
			return new DocumentResult[size];
		}

		@Override
		protected void setField(
			DocumentResult documentResult, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "folderName")) {
				if (jsonParserFieldValue != null) {
					documentResult.setFolderName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					documentResult.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "mimeType")) {
				if (jsonParserFieldValue != null) {
					documentResult.setMimeType((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					documentResult.setName((String)jsonParserFieldValue);
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