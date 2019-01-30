package org.teddymv.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.teddymv.messenger.model.Message;
import org.teddymv.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {

	MessageService mServ = new MessageService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages() {
		System.out.println("test1");
		return mServ.getAllMessages();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message msg) {
		return mServ.addMessage(msg);
	}

	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message test(@PathParam("messageId") long mId) {

		return mServ.getMessage(mId);
	}

}
