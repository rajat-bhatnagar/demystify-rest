package com.thoughtworks.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	private long ID;
	private String message;
	private Date created;
	private String author;
	
	
	public Message() {
		super();
	}
	
	public Message(long iD, String message, String author) {
		super();
		ID = iD;
		this.message = message;
		this.author = author;
		this.created = new Date();
	}
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	

}
