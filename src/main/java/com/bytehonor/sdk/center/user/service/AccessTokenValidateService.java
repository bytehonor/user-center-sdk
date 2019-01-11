package com.bytehonor.sdk.center.user.service;

import com.bytehonor.sdk.center.user.model.AccessToken;

public interface AccessTokenValidateService {

	public boolean isEffective(AccessToken userToken);
}
