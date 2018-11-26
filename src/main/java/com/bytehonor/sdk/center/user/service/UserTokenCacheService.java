package com.bytehonor.sdk.center.user.service;

import com.bytehonor.sdk.center.user.model.UserToken;

public interface UserTokenCacheService {

	public void save(UserToken userToken, long expireAt, String fromTerminal);
	
	public Object get(UserToken userToken, String fromTerminal);
	
	public void remove(UserToken userToken, String fromTerminal);
}
