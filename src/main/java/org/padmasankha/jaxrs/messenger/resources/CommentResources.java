package org.padmasankha.jaxrs.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.padmasankha.jaxrs.messenger.model.Comment;
import org.padmasankha.jaxrs.messenger.service.CommentService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResources {
	
	private CommentService commentService = new CommentService();

	@GET
	public List<Comment> getAllComment(@PathParam("messageid") long messageid){
		return commentService.getAllComments(messageid);
	}
	
	@POST
	public Comment addComment(@PathParam("messageid") long messageid, Comment comment){
		return commentService.addComment(messageid, comment);
	}
	
	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageid") long messageid,
								 @PathParam("messageid") long commentid, Comment comment){
		comment.setId(commentid);
		return commentService.updateComment(messageid, comment);
	}
	
	@DELETE
	@Path("/{commentId}")
	public void deleteComment(@PathParam("messageid") long messageid,
			                  @PathParam("messageid") long commentid, Comment comment){
		commentService.removeMessage(messageid, commentid);
	}
}
