package com.moi.api.handler.client.dto.v1_0;

import com.moi.api.handler.client.function.UnsafeSupplier;
import com.moi.api.handler.client.serdes.v1_0.JiraAPIHandlerSerDes;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Mohit
 * @generated
 */
@Generated("")
public class JiraAPIHandler implements Cloneable {

	public static JiraAPIHandler toDTO(String json) {
		return JiraAPIHandlerSerDes.toDTO(json);
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public void setFolderName(
		UnsafeSupplier<String, Exception> folderNameUnsafeSupplier) {

		try {
			folderName = folderNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String folderName;

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

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public void setMimeType(
		UnsafeSupplier<String, Exception> mimeTypeUnsafeSupplier) {

		try {
			mimeType = mimeTypeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String mimeType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setName(UnsafeSupplier<String, Exception> nameUnsafeSupplier) {
		try {
			name = nameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String name;

	@Override
	public JiraAPIHandler clone() throws CloneNotSupportedException {
		return (JiraAPIHandler)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof JiraAPIHandler)) {
			return false;
		}

		JiraAPIHandler jiraAPIHandler = (JiraAPIHandler)object;

		return Objects.equals(toString(), jiraAPIHandler.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return JiraAPIHandlerSerDes.toJSON(this);
	}

}