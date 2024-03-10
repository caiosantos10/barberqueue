package com.santos.barberqueue.services.exceptions;

public class InvalidDateFormat extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InvalidDateFormat(String msg) {
		super(msg);
	}
	
	public InvalidDateFormat(String msg, Throwable cause) {
		super(msg, cause);
	}

}
