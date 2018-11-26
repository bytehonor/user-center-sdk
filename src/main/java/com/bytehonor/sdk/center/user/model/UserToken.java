package com.bytehonor.sdk.center.user.model;

import com.bytehonor.sdk.center.user.constant.UserProfileTypeEnum;

public class UserToken {

	private Boolean debug;

	private String guid;

	private String token;

	private Integer profileType;

	public UserToken() {
		this.debug = false;
		this.profileType = UserProfileTypeEnum.UNKNOWN.getType();
	}

	public Boolean getDebug() {
		return debug;
	}

	public void setDebug(Boolean debug) {
		this.debug = debug;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getProfileType() {
		return profileType;
	}

	public void setProfileType(Integer profileType) {
		this.profileType = profileType;
	}

	// public String getFromTerminal() {
	// return fromTerminal;
	// }
	//
	// public void setFromTerminal(String fromTerminal) {
	// this.fromTerminal = fromTerminal;
	// }
	//
	// public String getFromIp() {
	// return fromIp;
	// }
	//
	// public void setFromIp(String fromIp) {
	// this.fromIp = fromIp;
	// }

}
