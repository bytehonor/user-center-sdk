package com.bytehonor.sdk.center.user.util;

import java.security.MessageDigest;

/**
 * 密码加密
 * 
 * @author lijianqiang
 *
 */
public class PasswordUtils {

    private static final String HJTJ = "huajietaojin";

    private static final char HEXS[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
            'f' };

    /**
     * @param clearText
     * @param salt
     * @return
     */
    public static String encrypt(String clearText, String salt) {
        StringBuilder sb = new StringBuilder();
        sb.append(clearText).append(HJTJ).append(salt);
        return md5(sb.toString());
    }

    private static String md5(String s) {
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = HEXS[byte0 >>> 4 & 0xf];
                str[k++] = HEXS[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
