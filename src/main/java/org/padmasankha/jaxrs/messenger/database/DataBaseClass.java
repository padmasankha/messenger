package org.padmasankha.jaxrs.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.padmasankha.jaxrs.messenger.model.Message;
import org.padmasankha.jaxrs.messenger.model.Profile;

public class DataBaseClass {

	private static Map<Long, Message> message = new HashMap<>();
	private static Map<String, Profile> profile = new HashMap<>();
	
	public static Map<Long, Message> getMessage() {
		return message;
	}
	
	public static Map<String, Profile> getProfile() {
		return profile;
	}
	
}
