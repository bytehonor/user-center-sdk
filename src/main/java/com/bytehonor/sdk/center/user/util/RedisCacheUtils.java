package com.bytehonor.sdk.center.user.util;

import org.springframework.util.StringUtils;

import com.bytehonor.sdk.center.user.model.StringLongPair;

public class RedisCacheUtils {

    public static final String KEY_PREFIX = "global:hash:user-token:";

    private static final String M = ":";

    /**
     * <pre>
     * key = KEY_PREFIX + {terminalType}:{terminalName},
     * field = guid,
     * value = token + timestamp,
     * </pre>
     * 
     * @param userToken
     * @return
     */
    public static String buildKey(Integer terminalType, String terminalName) {
        StringBuilder sb = new StringBuilder();
        sb.append(KEY_PREFIX).append(terminalType).append(M).append(terminalName);
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
