package com.bytehonor.sdk.center.user.util;

import com.bytehonor.sdk.basic.lang.util.MD5Utils;

public class RedisCacheUtils {

    public static final String KEY_PREFIX = "kv:access-token:";

    /**
     * <pre>
     * key = KEY_PREFIX + {fromTerminal},
     * field = token
     * value = expireAt,
     * </pre>
     * 
     * @param userToken
     * @return
     */
    public static String buildKey(String fromTerminal, String token) {
        StringBuilder sb = new StringBuilder();
        sb.append(KEY_PREFIX).append(fromTerminal).append(":").append(MD5Utils.md5(token));
        return sb.toString();
    }
}
