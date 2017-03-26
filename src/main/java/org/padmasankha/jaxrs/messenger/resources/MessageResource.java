package org.padmasankha.jaxrs.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.padmasankha.jaxrs.messenger.model.Message;
import org.padmasankha.jaxrs.messenger.resources.bean.MessageFilterBean;
import org.padmasankha.jaxrs.messenger.service.MessageService;


@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	private MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBean messageFilterBean) {
		if(messageFilterBean.getYear() >0){
			return messageService.getAllMessagesForYear(messageFilterBean.getYear());
		}
		if(messageFilterBean.getStart() > 0 && messageFilterBean.getSize() > 0){
			return messageService.getAllMessagesPaginated(messageFilterBean.getStart(), messageFilterBean.getSize());
		}
		return messageService.getAllMessages();
	}
	
	@POST
	public Response addMessage(Message msg, @Context UriInfo info){
		Message newMsg =  messageService.addMessage(msg);
		String id = String.valueOf(newMsg.getId());
		URI url = info.getAbsolutePathBuilder().path(id).build();
		return Response.created(url)
				.entity(newMsg)
				.build();
	}
	
	@PUT
	@Path("/{messageid}")
	public Message updateMessage(@PathParam("messageid") long id, Message msg){
		msg.setId(id);
		return messageService.updateMessage(msg);
	}
	
	@DELETE
	@Path("/{messageid}")
	public void deleteMessage(@PathParam("messageid") long id){
		messageService.removeMessage(id);
	}
	
	@GET
	@Path("/{messageid}")
	public Message getMessage(@PathParam("messageid") long id){
		return messageService.getMessage(id);
	}
	
	@Path("/{messageid}/comment")
	public CommentResources getCommentResources(){
		return new CommentResources();
	}
	

}
