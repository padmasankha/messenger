package org.padmasankha.jaxrs.messenger.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.padmasankha.jaxrs.messenger.database.DataBaseClass;
import org.padmasankha.jaxrs.messenger.model.Comment;
import org.padmasankha.jaxrs.messenger.model.Message;

public class CommentService {

	private Map<Long, Message> message = DataBaseClass.getMessage();
	
	public CommentService() {
		Comment k =  new Comment(1L, "Test_Msg_1", "User");
		Map<Long, Comment> comments = new HashMap<>();
		comments.put(1L, k);
		message.get(1L).setComments(comments);
	}
	
	public List<Comment> getAllComments(long messageId) {
		Map<Long, Comment> cmt = message.get(messageId).getComments();		
		return new ArrayList<Comment>(cmt.values());
	}
	
	public Comment getComment(long messageId, long commentId) {
		Map<Long, Comment> cmt = message.get(messageId).getComments();		
		return cmt.get(commentId);
	}
	
	public Comment addComment(long messageId, Comment comment) {
		Map<Long, Comment> cmt = message.get(messageId).getComments();	
		comment.setId(cmt.size() + 1);
		cmt.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(long messageId, Comment comment) {
		Map<Long, Comment> cmt = message.get(messageId).getComments();	
		if(comment.getId() <=  0){
			return null;
		}		
		cmt.put(comment.getId(), comment);		
		return comment;
	}
	
	public Comment removeMessage(long messageId, long commentId) {
		Map<Long, Comment> cmt = message.get(messageId).getComments();	
		return cmt.remove(commentId);
	}
}
