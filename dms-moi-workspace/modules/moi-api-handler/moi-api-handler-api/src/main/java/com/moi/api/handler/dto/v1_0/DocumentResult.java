package com.moi.api.handler.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.validation.Valid;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Mohit
 * @generated
 */
@Generated("")
@GraphQLName("DocumentResult")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "DocumentResult")
public class DocumentResult {

	public static DocumentResult toDTO(String json) {
		return ObjectMapperUtil.readValue(DocumentResult.class, json);
	}

	@Schema
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@JsonIgnore
	public void setResult(
		UnsafeSupplier<String, Exception> resultUnsafeSupplier) {

		try {
			result = resultUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String result;

	@Schema
	@Valid
	public Object getResultFile() {
		return resultFile;
	}

	public void setResultFile(Object resultFile) {
		this.resultFile = resultFile;
	}

	@JsonIgnore
	public void setResultFile(
		UnsafeSupplier<Object, Exception> resultFileUnsafeSupplier) {

		try {
			resultFile = resultFileUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Object resultFile;

	@Schema
	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	@JsonIgnore
	public void setResultMessage(
		UnsafeSupplier<String, Exception> resultMessageUnsafeSupplier) {

		try {
			resultMessage = resultMessageUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String resultMessage;

	@Schema
	public Long getTraceId() {
		return traceId;
	}

	public void setTraceId(Long traceId) {
		this.traceId = traceId;
	}

	@JsonIgnore
	public void setTraceId(
		UnsafeSupplier<Long, Exception> traceIdUnsafeSupplier) {

		try {
			traceId = traceIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long traceId;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DocumentResult)) {
			return false;
		}

		DocumentResult documentResult = (DocumentResult)object;

		return Objects.equals(toString(), documentResult.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (result != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"result\": ");

			sb.append("\"");

			sb.append(_escape(result));

			sb.append("\"");
		}

		if (resultFile != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"resultFile\": ");

			sb.append(String.valueOf(resultFile));
		}

		if (resultMessage != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"resultMessage\": ");

			sb.append("\"");

			sb.append(_escape(resultMessage));

			sb.append("\"");
		}

		if (traceId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"traceId\": ");

			sb.append(traceId);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		defaultValue = "com.moi.api.handler.dto.v1_0.DocumentResult",
		name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		return string.replaceAll("\"", "\\\\\"");
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

			Class<?> clazz = value.getClass();

			if (clazz.isArray()) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(value);
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(",");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}