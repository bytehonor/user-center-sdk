package com.bytehonor.sdk.center.user.util;

import org.springframework.util.StringUtils;

import com.bytehonor.sdk.center.user.model.StringLongPair;

public class RedisCacheUtils {

	public static final String KEY_PREFIX = "global:user-token-hash:";

	private static final String M = ":";

	/**
	 * key = KEY_PREFIX + {profileType}:{fromTerminal} field = guid value = token +
	 * timestamp
	 * 
	 * @param userToken
	 * @return
	 */
	public static String buildKey(Integer profileType, String fromTerminal) {
		StringBuilder sb = new StringBuilder();
		sb.append(KEY_PREFIX).append(profileType).append(M).append(fromTerminal);
		return sb.toString();
	}

	public static String buildValue(String token, Long timestamp) {
		StringBuilder sb = new StringBuilder();
		sb.append(token).append(M).append(timestamp);
		return sb.toString();
	}

	public static StringLongPair parseValue(String val) {
		StringLongPair res = new StringLongPair();
		if (StringUtils.isEmpty(val)) {
			return res;
		}
		String[] arr = val.split(M);
		if (arr == null || arr.length != 2) {
			return res;
		}
		res.setKey(arr[0]);
		res.setValue(Long.valueOf(arr[1]));
		return res;
	}
}
