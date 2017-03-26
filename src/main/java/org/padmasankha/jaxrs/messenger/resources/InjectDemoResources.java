package org.padmasankha.jaxrs.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResources {

	@GET
	@Path("/annotation")
	public String getParamUsingAnnotations(@MatrixParam("param") String matricsParam,
										   @HeaderParam("headerparam") String headerparam,
										   @CookieParam("value") String value) {
		
		return "Matrix param " + matricsParam + " Header param "+ headerparam + " Cookie param " + value;
	}
	
	@GET
	@Path("/context")
	public String getParamUsingContext(@Context UriInfo info,
									   @Context HttpHeaders headers){
		
		String path =  info.getAbsolutePath().toString();
		String cokies = headers.getCookies().toString();
		
		return "context param :" + path + " header param " + cokies;
		
	}
	
}
