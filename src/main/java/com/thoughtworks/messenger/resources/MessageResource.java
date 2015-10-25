package com.thoughtworks.messenger.resources;

import java.net.URI;
import java.util.List;

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

import com.thoughtworks.messenger.model.Message;
import com.thoughtworks.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {
	/*
	 **************  URL for rest service ********************
	 *  http://localhost:8080/demystify-rest/webapi/messages
	 *  http://localhost:8080/demystify-rest/webapi/messages/1
	 *  ******************************************************
	 */
	
	
	MessageService messageService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message>  getMessages(){
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message test(@PathParam("messageId") long id){
		return messageService.getMessage(id);
	}
	
	
	//Generate appropiate headers in response object and set the status in header to created 201
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(@Context UriInfo uriInfo , Message message){
		Message newMessage = messageService.addMessage(message);
		String newId = String.valueOf(message.getID());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri).entity(newMessage).build();
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long id, Message message){
		message.setID(id);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId") long id){
	   messageService.removeMessage(id);
	}
	
	//This is how we delegate to a sub-resource as Comments come under messages
	@Path("/{messageId}/comments")
	public CommentResource getComments(){
		return new CommentResource();
	}

}
