package org.javabrains;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.javabrains.model.Profile;
import org.javabrains.service.ProfileService;

@Path("/profiles")
public class ProfileResource {

	ProfileService pService = new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Profile> getAllProfiles() {
		return pService.getAllProfiles();  // http://localhost:8080/messenger/service/profiles
	}
	
	@GET
	@Path("/{profileId}")
	@Produces(MediaType.APPLICATION_XML)
	public Profile getProfile(@PathParam("profileId") Long pId) {
		return pService.getProfile(pId);           // http://localhost:8080/messenger/service/profiles/{profileId}
	}
	
}
