package com.bytehonor.sdk.oauth.bytehonor.util;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.util.Base64Utils;

import com.bytehonor.sdk.define.bytehonor.constant.TimeConstants;
import com.bytehonor.sdk.lang.bytehonor.util.LocalDateTimeUtils;
import com.bytehonor.sdk.oauth.bytehonor.error.OauthException;
import com.bytehonor.sdk.oauth.bytehonor.model.AccessTokenBody;

public class AccessTokenUtils {

    private static final char SPL = '_';

    public static String make(String uuid) {
        Objects.requireNonNull(uuid, "uuid");
        return make(uuid, TimeConstants.MONTH);
    }

    public static String make(String uuid, long millis) {
        Objects.requireNonNull(uuid, "uuid");
        return encode(AccessTokenBody.of(uuid, System.currentTimeMillis() + millis));
    }

    public static String encode(AccessTokenBody body) {
        Objects.requireNonNull(body, "body");
        // uuid32_secret32
        LocalDateTime ldt = LocalDateTimeUtils.fromTimestamp(body.getExpireAt());
        return base64Encode(
                new StringBuilder().append(body.getUuid()).append(SPL).append(TimeSecretUtils.make32(ldt)).toString());
    }

    public static AccessTokenBody parse(String accessToken) {
        Objects.requireNonNull(accessToken, "accessToken");
        String dec = "";
        try {
            dec = base64Decode(accessToken);
        } catch (Exception e) {
            throw new OauthException("accessToken decode failed");
        }
        // uuid32_secret32
        if (dec == null || dec.length() != 65 || SPL != dec.charAt(32)) {
            throw new OauthException("accessToken length illegal");
        }
        LocalDateTime ldt = TimeSecretUtils.check32(dec.substring(33));
        if (ldt == null) {
            throw new OauthException("secret illegal");
        }
        return new AccessTokenBody(dec.substring(0, 32), LocalDateTimeUtils.toTimestamp(ldt));
    }

    public static String base64Encode(String src) {
        Objects.requireNonNull(src, "src");
        String base = Base64Utils.encodeToUrlSafeString(src.getBytes());
        base = base.replaceAll("=", "_");
        return base;
    }

    public static String base64Decode(String base) {
        Objects.requireNonNull(base, "base");
        base = base.replaceAll("_", "=");
        return new String(Base64Utils.decodeFromUrlSafeString(base));
    }
}
