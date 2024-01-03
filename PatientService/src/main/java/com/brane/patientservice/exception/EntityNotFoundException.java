/*
 * Copyright (c) Brane and/or its affiliates. All rights reserved.
 *
 */

package com.brane.patientservice.exception;

public class EntityNotFoundException extends Exception {

	private static final long serialVersionUID = 1181650707049869636L;

	/**
	 * Constructs a new <code>EntityNotFoundException</code> exception with
	 * <code>null</code> as its detail message.
	 */
	public EntityNotFoundException() {
		super();
	}

	/**
	 * Constructs a new <code>EntityNotFoundException</code> exception with
	 * <code>null</code> as its detail message.
	 */
	public EntityNotFoundException(Exception cause) {
		super(cause);
	}

	/**
	 * Constructs a new <code>EntityNotFoundException</code> exception with the
	 * specified detail message.
	 * 
	 * @param message
	 *            the detail message.
	 */
	public EntityNotFoundException(String message) {
		super(message);
	}

	/**
	 * Constructs a new <code>EntityNotFoundException</code> exception with the
	 * specified detail message.
	 *
	 * @param message
	 *            the detail message.
	 */
	public EntityNotFoundException(String message, Exception cause) {
		super(message, cause);
	}

}
