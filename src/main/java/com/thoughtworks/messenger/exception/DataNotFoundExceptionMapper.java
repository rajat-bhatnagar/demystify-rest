package com.thoughtworks.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.thoughtworks.messenger.model.ErrorMessage;

@Provider
//@Provider annotation registers this exception mapper
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException dataNotFoundException) {
		// Generate JSON Response to show in Response
		ErrorMessage errorMessage = new ErrorMessage("Data Not found Exception", 404, "This is a custom error as nothing was found by the REST service");
		//Pass this errorMessage to the Response
		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
	}

}
