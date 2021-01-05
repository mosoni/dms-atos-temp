package com.moi.api.handler.client.dto.v1_0;

import com.moi.api.handler.client.function.UnsafeSupplier;
import com.moi.api.handler.client.serdes.v1_0.DocumentResultSerDes;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Mohit
 * @generated
 */
@Generated("")
public class DocumentResult implements Cloneable {

	public static DocumentResult toDTO(String json) {
		return DocumentResultSerDes.toDTO(json);
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setResult(
		UnsafeSupplier<String, Exception> resultUnsafeSupplier) {

		try {
			result = resultUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String result;

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public void setResultMessage(
		UnsafeSupplier<String, Exception> resultMessageUnsafeSupplier) {

		try {
			resultMessage = resultMessageUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String resultMessage;

	public Long getTraceId() {
		return traceId;
	}

	public void setTraceId(Long traceId) {
		this.traceId = traceId;
	}

	public void setTraceId(
		UnsafeSupplier<Long, Exception> traceIdUnsafeSupplier) {

		try {
			traceId = traceIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long traceId;

	@Override
	public DocumentResult clone() throws CloneNotSupportedException {
		return (DocumentResult)super.clone();
	}

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
		return DocumentResultSerDes.toJSON(this);
	}

}