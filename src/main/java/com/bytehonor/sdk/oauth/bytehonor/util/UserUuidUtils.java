package com.bytehonor.sdk.oauth.bytehonor.util;

import com.bytehonor.sdk.lang.bytehonor.util.MD5Utils;

public class UserUuidUtils {

    public static String uuidWeixin(String appid, String openid) {
        return MD5Utils.md5(new StringBuilder().append(appid).append(":").append(openid).toString());
    }

    public static String uuidWeibo(Long uid) {
        return MD5Utils.md5(new StringBuilder().append("weibo").append(":").append(uid).toString());
    }
}
