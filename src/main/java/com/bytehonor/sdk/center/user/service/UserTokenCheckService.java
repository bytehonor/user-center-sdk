package com.bytehonor.sdk.center.user.service;

import com.bytehonor.sdk.center.user.model.UserToken;

public interface UserTokenCheckService {

	public boolean isUserTokenOk(UserToken userToken, String fromTerminal);
}
