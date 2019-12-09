package jjm.learn.entity;

public class User {
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getIp() {
		return Ip;
	}
	public void setIp(String ip) {
		Ip = ip;
	}
	public String getFirstTime() {
		return firstTime;
	}
	public void setFirstTime(String firstTime) {
		this.firstTime = firstTime;
	}
	
	private String sessionId;
	
	private String Ip;
	
	private String firstTime;
}
