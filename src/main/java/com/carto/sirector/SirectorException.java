package com.carto.sirector;

/**
 * Sirector Exception which will be throwed by event handlers if any error
 * happened when handling event.
 * 
 * @author chenfeng
 * 
 */
public class SirectorException extends RuntimeException {

	private static final long serialVersionUID = 4898686611676070892L;

	public SirectorException() {
		super();
	}

	public SirectorException(String message, Throwable cause) {
		super(message, cause);
	}

	public SirectorException(String message) {
		super(message);
	}

	public SirectorException(Throwable cause) {
		super(cause);
	}

}
