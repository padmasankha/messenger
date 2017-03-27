package org.padmasankha.jaxrs.messenger.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.padmasankha.jaxrs.messenger.model.ErrorMessage;

// @Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 500, "http://test.com/link");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(errorMessage)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}

}
