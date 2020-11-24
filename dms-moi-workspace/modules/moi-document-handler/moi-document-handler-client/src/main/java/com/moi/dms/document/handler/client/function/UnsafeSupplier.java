package com.moi.dms.document.handler.client.function;

import javax.annotation.Generated;

/**
 * @author Mohit
 * @generated
 */
@FunctionalInterface
@Generated("")
public interface UnsafeSupplier<T, E extends Throwable> {

	public T get() throws E;

}