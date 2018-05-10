package org.javabrains;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/injectParams")
public class InjectParamResource {

	@GET
	@Path("/query")
	@Produces(MediaType.TEXT_PLAIN)
	public String getQueryParams(@QueryParam("query") String queryParam) {
		return "Query Param: "+queryParam;  //http://localhost:8080/messenger/service/injectParams/query?query=qwerty
	}
	
	@GET
	@Path("/matrix")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMatrixParams(@MatrixParam("mparam") String matrixparam) {
		return "MatrixParam: "+matrixparam;  //http://localhost:8080/messenger/service/injectParams/matrix;mparam=qwerty
	}
	
	@GET
	@Path("/header")
	@Produces(MediaType.TEXT_PLAIN)
	public String getHeaderParams(@HeaderParam("hparam") String hparam) {
		return "Header Param: "+hparam;  // http://localhost:8080/messenger/service/injectParams/header
	}
	
	@GET
	@Path("/cookie")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCookieParam(@QueryParam("cParam") String cookieValue) {
		return "qParam: "+cookieValue;
	}
	
}
