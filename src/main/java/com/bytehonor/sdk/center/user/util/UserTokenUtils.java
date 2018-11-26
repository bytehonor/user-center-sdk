package com.bytehonor.sdk.center.user.util;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bytehonor.sdk.center.user.constant.UserProfileTypeEnum;
import com.bytehonor.sdk.center.user.model.UserToken;

public class UserTokenUtils {

	private static final Logger LOG = LoggerFactory.getLogger(UserTokenUtils.class);

	public static UserToken build(HttpServletRequest request) {
		UserToken ut = new UserToken();
		String debug = request.getParameter("debug");
		boolean isDebug = "true".equals(debug);
		if (isDebug) {
			return ut;
		}

		// 1@guid@token
		String auth = request.getHeader("Authentication");
		if (LOG.isDebugEnabled()) {
			LOG.debug("Authentication:{}", auth);
		}
		String[] arr = auth.split("@");
		if (arr.length < 3) {
			throw new RuntimeException("Authentication is invalid");
		}
		Integer typeVal = Integer.valueOf(arr[0]);
		UserProfileTypeEnum type = UserProfileTypeEnum.typeOf(typeVal);
		if (UserProfileTypeEnum.UNKNOWN.getType() == type.getType()) {
			throw new RuntimeException("Authentication content is invalid");
		}
//		String fromTerminal = UserTerminalUtils.getFromTerminal(request);
//		String fromIp = UserTerminalUtils.getFromIp(request);
		
		String guid = arr[1];
		String token = arr[2];
		ut.setGuid(guid);
		ut.setToken(token);
		ut.setProfileType(typeVal);
//		ut.setFromIp(fromIp);
//		ut.setFromTerminal(fromTerminal);
		return ut;
	}

}
