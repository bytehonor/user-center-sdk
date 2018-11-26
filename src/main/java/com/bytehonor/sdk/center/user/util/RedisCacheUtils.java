package com.bytehonor.sdk.center.user.util;

import com.bytehonor.sdk.center.user.model.StringLongPair;

public class RedisCacheUtils {
	
	public static final String KEY_PREFIX = "global:user-token-hash:";
	
	private static final String M = ":";

	/**
	 * key = KEY_PREFIX + {profileType}:{fromTerminal}
	 * field = guid
	 * value = token + timestamp
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
	
	public static StringLongPair parseValue(Object val) {
		StringLongPair res = new StringLongPair();
		
		return res;
	}
}
