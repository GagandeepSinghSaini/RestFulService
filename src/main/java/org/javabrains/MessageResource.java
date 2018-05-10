package org.javabrains;

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
import javax.ws.rs.core.UriInfo;

import org.javabrains.model.Message;
import org.javabrains.service.MessageService;

@Path("/messages")
public class MessageResource {

	MessageService msgService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages() {
		return msgService.getAllMessages();  //http://localhost:8080/messenger/service/messages
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_XML)
	public Message getMessage(@PathParam("messageId") Long msgId, @Context UriInfo uriInfo) {
		Message message =  msgService.getMessage(msgId);    //http://localhost:8080/messenger/service/messages/{messageId}
		String uri = uriInfo.getBaseUriBuilder()
		.path(MessageResource.class)
		.path(Long.toString(message.getId()))
		.build().toString();
		message.addLink(uri, "self");
		return message;
	}
	
	@POST
	@Path("/postMessage")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Message postMessage(Message message) {
		return msgService.addMessage(message);    // http://localhost:8080/messenger/service/messages/postMessage
	}
	
	@PUT
	@Path("/updateMessage")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Message updateMessage(Message message) {
		System.out.println("Start updating the message");   // http://localhost:8080/messenger/service/messages/updateMessage
		return msgService.updateMessage(message);
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public String deleteMessage(Message message) {
		return msgService.removeMessage(message);   // http://localhost:8080/messenger/service/messages
	}
	
	@Path("/{msgId}/comments")
	public CommentResource getCommentResources() {
		return new CommentResource();
	}
}
