package com.bytehonor.sdk.center.user.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

import com.bytehonor.protocol.common.server.constant.HeaderKey;
import com.bytehonor.sdk.center.user.model.UserPassport;

public class UserPassportUtils {

	private static final String CON = "@";

	public static UserPassport build(Integer profileType, String guid, String fromIp, String fromTerminal) {
		UserPassport up = new UserPassport();
		up.setFromIp(fromIp);
		up.setFromTerminal(fromTerminal);
		up.setGuid(guid);
		up.setProfileType(profileType);
		return up;
	}

	public static String toString(Integer profileType, String guid, String fromTerminal, String fromIp) {
		StringBuilder sb = new StringBuilder();
		sb.append(profileType).append(CON).append(guid).append(CON).append(fromTerminal).append(CON).append(fromIp);
		return sb.toString();
	}

	public static UserPassport get(HttpServletRequest request) {
		String val = request.getHeader(HeaderKey.x_USER_PASSPORT);
		UserPassport up = new UserPassport();
		if (StringUtils.isEmpty(val)) {
			return up;
		}
		String[] arr = val.split(CON);
		if (arr == null || arr.length != 4) {
			return up;
		}
		up.setProfileType(Integer.valueOf(arr[0]));
		up.setGuid(arr[1]);
		up.setFromTerminal(arr[2]);
		up.setFromIp(arr[3]);
		return up;
	}
}
