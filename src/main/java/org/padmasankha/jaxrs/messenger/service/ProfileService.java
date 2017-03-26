package org.padmasankha.jaxrs.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.padmasankha.jaxrs.messenger.database.DataBaseClass;
import org.padmasankha.jaxrs.messenger.model.Profile;

public class ProfileService {

	private static Map<String, Profile> profile = DataBaseClass.getProfile();
	
	public ProfileService() {
		profile.put("test", new Profile(1L, "test","Fname","Lname"));
	}
	
	public List<Profile> getAllProfile() {
		return new ArrayList<Profile>(profile.values());
	}
	
	public Profile getProfile(String profileName) {
		return profile.get(profileName);
	}
	
	public Profile addProfile(Profile pro) {
		pro.setId(profile.size() + 1);
		profile.put(pro.getProfileName(), pro);
		return pro;
	}
	
	public Profile updateProfile(Profile pro) {
		if(pro.getProfileName().isEmpty()){
			return null;
		}		
		profile.put(pro.getProfileName(), pro);		
		return pro;
	}
	
	public Profile removeProfile(String profileNAme) {
		return profile.remove(profileNAme);
	}
}
