package com.thoughtworks.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class CommentResource {
	
	/*
	 **************  URL for rest service ********************
	 *  http://localhost:8080/demystify-rest/webapi/messages/1/comments
	 *  http://localhost:8080/demystify-rest/webapi/messages/1/comments/12
	 *  ******************************************************
	 */
	
	@GET
	public String getComment(){
		return "sub-resource comment";
	}
	
	//Even though we do not have messageId here , we can still get the value
	// as the control has been delegated here from MessageResource
	@GET
	@Path("/{commentId}")
	public String getCommentSubresource(@PathParam("commentId") long commentId , @PathParam("messageId") long messageId){
		return "Method to return commentId: "+commentId+" messageId: "+messageId;
	}
}
