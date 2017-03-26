package org.padmasankha.jaxrs.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.padmasankha.jaxrs.messenger.model.Profile;
import org.padmasankha.jaxrs.messenger.service.ProfileService;

@Path("/profile")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResourse {
	
	private ProfileService profileResourse =  new ProfileService();
	
	@GET
	public List<Profile> getMessages() {
		return profileResourse.getAllProfile();
	}
	
	@POST
	public Profile addMessage(Profile pro){
		return profileResourse.addProfile(pro);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateMessage(@PathParam("profileName") String profileName, Profile pro){
		pro.setProfileName(profileName);
		return profileResourse.updateProfile(pro);
	}
	
	@DELETE
	@Path("/{profileName}")
	public void deleteMessage(@PathParam("profileName") String profileName){
		profileResourse.removeProfile(profileName);
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getMessage(@PathParam("profileName") String profileName){
		return profileResourse.getProfile(profileName);
	}

}
