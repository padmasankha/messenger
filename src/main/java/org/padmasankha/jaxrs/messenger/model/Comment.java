package org.padmasankha.jaxrs.messenger.model;

import java.util.Date;

public class Comment {

	private long id;
	private String message;
	private Date created;
	private String outhor;
	
	public Comment() {
		
	}
	
	public Comment(long id, String message, String outhor) {
		this.id = id;
		this.message = message;
		this.created =  new Date();
		this.outhor =  outhor;		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getOuthor() {
		return outhor;
	}

	public void setOuthor(String outhor) {
		this.outhor = outhor;
	}
	
	
}
