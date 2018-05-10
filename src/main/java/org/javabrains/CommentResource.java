package org.javabrains;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class CommentResource {


	@GET
	public String getComments() {
		return "check comment";
	}
	
}
