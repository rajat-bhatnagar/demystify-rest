package com.thoughtworks.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.server.Uri;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResources {

	public InjectDemoResources() {
		super();
	}
	
	//using @Contect aannotation is a quick way for finding details about the request
	//if you are not aware about what you are looking for
	
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers){
		String path = uriInfo.getAbsolutePath().toString();
		String httpHeadersClass = headers.getClass().toString();
		return "Path : " +path+ " HttpHeaders class : "+httpHeadersClass;
     }

}
