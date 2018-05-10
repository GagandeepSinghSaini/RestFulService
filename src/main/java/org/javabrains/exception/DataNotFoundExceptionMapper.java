package org.javabrains.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.javabrains.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	public Response toResponse(DataNotFoundException arg0) {
		ErrorMessage err = new ErrorMessage("Data Not FOund", 404, "The given does not contain the service file.");
		return Response.status(Status.NOT_FOUND).entity(err).build();
	}

}
