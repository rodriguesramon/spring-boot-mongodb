package com.ramoncosta.mongodb.service.exception;

public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String exception) {
		super(exception);
	}
}
