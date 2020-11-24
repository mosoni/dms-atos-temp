package com.moi.dms.document.handler.client.dto.v1_0;

import com.moi.dms.document.handler.client.function.UnsafeSupplier;
import com.moi.dms.document.handler.client.serdes.v1_0.MosipDocumentHandlerSerDes;

import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Mohit
 * @generated
 */
@Generated("")
public class MosipDocumentHandler implements Cloneable {

	public static MosipDocumentHandler toDTO(String json) {
		return MosipDocumentHandlerSerDes.toDTO(json);
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
	public MosipDocumentHandler clone() throws CloneNotSupportedException {
		return (MosipDocumentHandler)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MosipDocumentHandler)) {
			return false;
		}

		MosipDocumentHandler mosipDocumentHandler =
			(MosipDocumentHandler)object;

		return Objects.equals(toString(), mosipDocumentHandler.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return MosipDocumentHandlerSerDes.toJSON(this);
	}

}