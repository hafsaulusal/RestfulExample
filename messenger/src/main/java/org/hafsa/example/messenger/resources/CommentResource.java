package org.hafsa.example.messenger.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Path;
import org.hafsa.example.messenger.database.DatabaseClass;
import org.hafsa.example.messenger.model.Comment;
import org.hafsa.example.messenger.model.Message;


@Path("/")
public class CommentResource {

	private Map<Long,Message> messages=DatabaseClass.getMessages();
	
	public List<Comment> getAllComment(long messageId)
	{
		Map<Long,Comment> comments=messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
		
	}
	
	public Comment getComment(long messageId,long commentId)
	{
		Map<Long,Comment> comments=messages.get(messageId).getComments();
		return comments.get(commentId);
	}
	
	public Comment addComment(long messageId,Comment comment)
	{
		Map<Long,Comment> comments=messages.get(messageId).getComments();
		comment.setId(comments.size()+1);
		comments.put(comment.getId(),comment);
		return comment;
	}
	
	public Comment updateMessage(long messageId,Comment comment)
	{
		Map<Long,Comment> comments=messages.get(messageId).getComments();
		if(comment.getId()<=0)
		{
			return null;
		}
		
		comments.put(comment.getId(),comment);
		return comment;
	}
	
	public Comment removeComment(long messageId,long commentId)
	{
		Map<Long,Comment> comments=messages.get(messageId).getComments();
		return comments.remove(commentId);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
