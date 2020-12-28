package com.moi.api.handler.client.dto.v1_0;

import com.moi.api.handler.client.function.UnsafeSupplier;
import com.moi.api.handler.client.serdes.v1_0.MosipAPIHandlerSerDes;

import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Mohit
 * @generated
 */
@Generated("")
public class MosipAPIHandler implements Cloneable {

	public static MosipAPIHandler toDTO(String json) {
		return MosipAPIHandlerSerDes.toDTO(json);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setDate(UnsafeSupplier<Date, Exception> dateUnsafeSupplier) {
		try {
			date = dateUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setId(UnsafeSupplier<Long, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long id;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTitle(
		UnsafeSupplier<String, Exception> titleUnsafeSupplier) {

		try {
			title = titleUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String title;

	@Override
	public MosipAPIHandler clone() throws CloneNotSupportedException {
		return (MosipAPIHandler)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MosipAPIHandler)) {
			return false;
		}

		MosipAPIHandler mosipAPIHandler = (MosipAPIHandler)object;

		return Objects.equals(toString(), mosipAPIHandler.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return MosipAPIHandlerSerDes.toJSON(this);
	}

}