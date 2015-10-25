package com.thoughtworks.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.thoughtworks.messenger.database.DatabaseClass;
import com.thoughtworks.messenger.model.Profile;


public class ProfileService {
	
	
	public ProfileService() {
		profiles.put("profileOne", new Profile(1L, "profileOne", "Gagan", "Bhatnagar"));
	}

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	//Get all profiles
	public List<Profile> getAllProfiles(){
		List<Profile> list = new ArrayList<Profile>();
		//All all the map values to the list as this will be the superset of all profiles
		list.addAll(profiles.values());
		return list;
	}
	
	//Get a single profile
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	//Add a profile
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	//Update a profile
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	//Delete profile
	public void removeProfile(String profileName){
		profiles.remove(profileName);
	}
}
