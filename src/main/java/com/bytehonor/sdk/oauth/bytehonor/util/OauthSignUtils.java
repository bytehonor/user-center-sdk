package com.bytehonor.sdk.oauth.bytehonor.util;

import java.util.Objects;

import com.bytehonor.sdk.define.bytehonor.code.StandardCode;
import com.bytehonor.sdk.define.bytehonor.error.StandardException;
import com.bytehonor.sdk.lang.bytehonor.util.MD5Utils;

public class OauthSignUtils {

    public static void checkSign(String path, String accessToken, Long accessTime, String accessSign) {
        Objects.requireNonNull(path, "path");
        Objects.requireNonNull(accessToken, "accessToken");
        Objects.requireNonNull(accessTime, "accessTime");
        Objects.requireNonNull(accessSign, "accessSign");

        String sign = MD5Utils.md5(path + accessToken + accessTime);
        if (sign.equalsIgnoreCase(accessSign) == false) {
            throw new StandardException(StandardCode.FORBIDDEN, "FORBIDDEN");
        }
    }
}
