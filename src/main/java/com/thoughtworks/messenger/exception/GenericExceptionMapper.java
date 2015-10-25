package com.thoughtworks.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.thoughtworks.messenger.model.ErrorMessage;


@Provider
//@Provider annotation registers this exception mapper

/*
 * This is a blanket exception catcher
 */
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable throwable) {
		// Generate JSON Response to show in Response
		ErrorMessage errorMessage = new ErrorMessage("Blanket generic Exception", 500, "This is the blanket exception for the REST service");
		//Pass this errorMessage to the Response
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();
	}

}