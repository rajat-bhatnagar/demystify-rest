package com.thoughtworks.messenger.exception;

public class DataNotFoundException extends RuntimeException{

	
	//We need to add a serialVersionUID as RuntimeException has a serial version uid
	/**
	 * 
	 */
	private static final long serialVersionUID = -8291470018418271318L;

	public DataNotFoundException(String message) {
		super(message);
	}
	
	
}
