package org.javabrains.database;

import java.util.HashMap;
import java.util.Map;

import org.javabrains.model.Message;
import org.javabrains.model.Profile;

public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<Long, Message>();
	private static Map<Long, Profile> profiles = new HashMap<Long, Profile>();
	
	public static Map<Long, Message> getMessages() {
		messages.put(1L, new Message(1L, "Hello Gagan", "GAgan"));
		messages.put(2L, new Message(2L, "Hello Sachin", "Sachin"));
		messages.put(3L, new Message(3L, "Hello Harish", "Harish"));
		return messages;
	}
	
	public static Map<Long, Profile> getProfiles() {
		profiles.put(21L, new Profile(21L, "Profile_1", "Sachin", "Tendulkar"));
		profiles.put(22L, new Profile(22L, "Profile_2", "Rohit", "Sharma"));
		profiles.put(23L, new Profile(23L, "Profile_3", "Virat", "Kohli"));
		return profiles;
	}
	
}
