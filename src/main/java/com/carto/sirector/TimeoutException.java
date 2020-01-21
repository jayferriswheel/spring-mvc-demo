package com.carto.sirector;

public class TimeoutException extends SirectorException {

	private static final long serialVersionUID = -5423490721470482068L;

	public TimeoutException() {
		super();
	}

	public TimeoutException(String message, Throwable cause) {
		super(message, cause);
	}

	public TimeoutException(String message) {
		super(message);
	}

	public TimeoutException(Throwable cause) {
		super(cause);
	}

}
