package com.bytehonor.sdk.center.user.model;

public class UserPassport {

	private String guid;

	private Integer profileType;

	private String fromTerminal;

	private String fromIp;

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public Integer getProfileType() {
		return profileType;
	}

	public void setProfileType(Integer profileType) {
		this.profileType = profileType;
	}

	public String getFromTerminal() {
		return fromTerminal;
	}

	public void setFromTerminal(String fromTerminal) {
		this.fromTerminal = fromTerminal;
	}

	public String getFromIp() {
		return fromIp;
	}

	public void setFromIp(String fromIp) {
		this.fromIp = fromIp;
	}

}
