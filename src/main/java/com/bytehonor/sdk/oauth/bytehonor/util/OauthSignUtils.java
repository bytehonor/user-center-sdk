package com.bytehonor.sdk.oauth.bytehonor.util;

import java.util.Objects;

import com.bytehonor.sdk.define.bytehonor.code.StandardCode;
import com.bytehonor.sdk.define.bytehonor.error.StandardException;
import com.bytehonor.sdk.lang.bytehonor.util.MD5Utils;

public class OauthSignUtils {

    public static void checkSignV1(String path, String accessToken, String accessSign) {
        Objects.requireNonNull(path, "path");
        Objects.requireNonNull(accessToken, "accessToken");
        Objects.requireNonNull(accessSign, "accessSign");

        String sign = MD5Utils.md5(path + "bytehonor" + accessToken);
        if (sign.equalsIgnoreCase(accessSign) == false) {
            throw new StandardException(StandardCode.FORBIDDEN, "FORBIDDEN");
        }
    }
}
