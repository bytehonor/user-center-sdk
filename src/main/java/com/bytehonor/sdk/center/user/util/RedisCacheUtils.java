package com.bytehonor.sdk.center.user.util;

import java.util.List;

import org.springframework.util.StringUtils;

import com.bytehonor.sdk.center.user.model.StringLongPair;

public class RedisCacheUtils {

    public static final String KEY_PREFIX = "global:hash:user-token:";

    private static final char M = ':';

    /**
     * <pre>
     * key = KEY_PREFIX + {roleKey}:{fromTerminal},
     * field = guid,
     * value = token + timestamp,
     * </pre>
     * 
     * @param userToken
     * @return
     */
    public static String buildKey(Integer roleKey, String fromTerminal) {
        StringBuilder sb = new StringBuilder();
        sb.append(KEY_PREFIX).append(roleKey).append(M).append(fromTerminal);
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
        List<String> list = UserPassportUtils.split(val, M);
        if (list == null || list.size() != 2) {
            return res;
        }
        res.setKey(list.get(0));
        res.setValue(Long.valueOf(list.get(1)));
        return res;
    }
}
