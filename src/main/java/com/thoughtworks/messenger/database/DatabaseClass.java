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
	private static Map<Long, Profile> profiles = new HashMap<>();
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	public static Map<Long, Profile> getProfiles() {
		return profiles;
	}
	
	
}
