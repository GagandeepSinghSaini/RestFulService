package org.javabrains.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.javabrains.database.DatabaseClass;
import org.javabrains.model.Profile;

public class ProfileService {

	private Map<Long, Profile> profiles = DatabaseClass.getProfiles();
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(Long id) {
		return profiles.get(id);
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getId() <= 0) {
			return null;
		}
		
		profiles.put(profile.getId(), profile);
		return profile;
	}
	
	public Profile removeProfile(long id) {
		return profiles.remove(id);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getId(), profile);
		return profile;
	}
	
}
