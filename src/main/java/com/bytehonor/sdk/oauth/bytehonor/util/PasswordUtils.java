package com.bytehonor.sdk.oauth.bytehonor.util;

import com.bytehonor.sdk.lang.bytehonor.util.MD5Utils;

/**
 * 密码加密
 * 
 * @author lijianqiang
 *
 */
public class PasswordUtils {

    private static final String HJTJ = "bytehonor";

    /**
     * @param clearText
     * @param salt
     * @return
     */
    public static String encrypt(String clearText, String salt) {
        StringBuilder sb = new StringBuilder();
        sb.append(clearText).append(HJTJ).append(salt);
        return MD5Utils.md5(sb.toString());
    }
}
