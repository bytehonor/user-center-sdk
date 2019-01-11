package com.bytehonor.sdk.center.user.service;

import com.bytehonor.sdk.center.user.model.AccessToken;

public interface AccessTokenCacheService {

	public void save(AccessToken userToken, long expireAt);
	
	public Object get(AccessToken userToken);
	
	public void remove(AccessToken userToken);
}
