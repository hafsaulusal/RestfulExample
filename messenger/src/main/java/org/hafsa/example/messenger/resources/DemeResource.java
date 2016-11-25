package org.hafsa.example.messenger.resources;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/demo")
public class DemeResource {
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("anotations")
	public String getParamUsingAnotations(@MatrixParam("param") String matrixparam,
			@HeaderParam("headerparam")String headerparam)
	{
		return "Matrix Param "+matrixparam+" header "+headerparam;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("context")
	public String getContext(@Context UriInfo uriInfo)
	{
		String path=uriInfo.getAbsolutePath().toString();
		return path;
	}
  	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
