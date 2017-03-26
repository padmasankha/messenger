package org.padmasankha.jaxrs.messenger.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message {

	private long id;
	private String message;
	private Date created;
	private String outhor;
	
	private Map<Long, Comment> comments = new HashMap<>();
	
	public Message(){
		
	}
	
	public Message(long id, String message, String outhor) {
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

	@XmlTransient
	public Map<Long, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}
	
}
