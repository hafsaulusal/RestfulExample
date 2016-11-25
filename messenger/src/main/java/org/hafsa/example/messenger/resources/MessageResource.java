package org.hafsa.example.messenger.resources;

import javax.ws.rs.core.MediaType;

import org.hafsa.example.messenger.model.Message;
import org.hafsa.example.messenger.resources.beans.MessageBean;
import org.hafsa.example.messenger.service.MessageService;

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
import javax.ws.rs.QueryParam;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService messageservice=new MessageService();
	
	@GET
	public List<Message> getMessages(@BeanParam MessageBean bean){
		if(bean.getYear()>0) 
		{
			return messageservice.getAllMessageForYear(bean.getYear());
		}
		if(bean.getStart()>=0 && bean.getSize()>1)
		{
			return messageservice.getAllMessagesPaginated(bean.getStart(), bean.getSize());
		}
		return messageservice.getAllMessages();
	}
	
	@POST
	public Message addMessage(Message message)
	{
		return messageservice.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId")long id,Message message)
	{
		message.setId(id);
		return messageservice.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId")long id)
	{
		messageservice.removeMessage(id);
	}
	
	
	@GET
	@Path("/{messageId}")
	public Message getMessages(@PathParam("messageId")long id)
	{
		return messageservice.getMessage(id);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}
	
	
	
	
	
	
}
