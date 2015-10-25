package com.thoughtworks.messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.thoughtworks.messenger.model.Message;
import com.thoughtworks.messenger.model.Profile;

public class DatabaseClass {
	
	/*
	 * This is not thread safe
	 * No Concurrency
	 */
	
	private static Map<Long, Message> messages = new HashMap<>();
	
	//profileName which is a String is the key for the Profile Map 
	private static Map<String, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
	
	
}
