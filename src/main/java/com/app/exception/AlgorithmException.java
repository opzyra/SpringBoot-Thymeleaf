package com.app.exception;

public class AlgorithmException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AlgorithmException(Throwable cause) {
		super(cause);
	}
	
	public AlgorithmException(String message, Throwable cause) {
		super(message, cause);
	}

}
