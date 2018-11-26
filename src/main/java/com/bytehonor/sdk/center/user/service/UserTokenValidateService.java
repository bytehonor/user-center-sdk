package com.bytehonor.sdk.center.user.service;

import com.bytehonor.sdk.center.user.model.UserToken;

public interface UserTokenValidateService {

	public boolean isEffective(UserToken userToken, String fromTerminal);
}
