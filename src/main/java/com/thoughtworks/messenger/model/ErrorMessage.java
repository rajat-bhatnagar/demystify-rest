package com.thoughtworks.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	private String error;
	private int errorCode;
	private String documentation;
	
	//We need the no-arg constructor as we need to serialize and de-serialize
	public ErrorMessage() {
	}
	public ErrorMessage(String error, int errorCode, String documentation) {
		super();
		this.error = error;
		this.errorCode = errorCode;
		this.documentation = documentation;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	
}
