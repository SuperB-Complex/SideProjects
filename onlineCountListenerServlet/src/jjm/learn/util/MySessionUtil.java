package jjm.learn.util;

import java.util.Map;

import jjm.learn.entity.User;

public class MySessionUtil {
		
	public static Object getUserBySessionId(Map<String, User> userMap, String sessionId) {
		
		if (userMap.containsKey(sessionId)) {
			return userMap.get(sessionId);
		}
		
		return null;
	}
}
