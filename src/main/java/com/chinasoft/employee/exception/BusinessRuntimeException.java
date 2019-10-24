package com.chinasoft.employee.exception;

/**
 * 
 * @author Mango
 *
 */
public class BusinessRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7185880187356976638L;

	public BusinessRuntimeException() {
		super();
	}

	public BusinessRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BusinessRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessRuntimeException(String message) {
		super(message);
	}

	public BusinessRuntimeException(Throwable cause) {
		super(cause);
	}
	
}
