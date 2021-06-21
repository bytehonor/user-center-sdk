package com.bytehonor.sdk.oauth.bytehonor.util;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.util.Base64Utils;

import com.bytehonor.sdk.define.bytehonor.error.ParameterExcption;
import com.bytehonor.sdk.oauth.bytehonor.model.AccessTokenBody;

public class AccessTokenUtils {

    private static final char SPL = '_';

    public static String make(String uuid) {
        Objects.requireNonNull(uuid, "uuid");
        return encode(AccessTokenBody.of(uuid, LocalDateTime.now()));
    }

    public static String encode(AccessTokenBody body) {
        Objects.requireNonNull(body, "body");
        // uuid32_secret32
        return base64Encode(new StringBuilder().append(body.getUuid()).append(SPL)
                .append(TimeSecretUtils.make32(body.getTime())).toString());
    }

    public static AccessTokenBody parse(String accessToken) {
        Objects.requireNonNull(accessToken, "accessToken");
        String dec = "";
        try {
            dec = base64Decode(accessToken);
        } catch (Exception e) {
            throw new ParameterExcption("accessToken is illegal");
        }
        // uuid32_secret32
        if (dec == null || dec.length() != 65 || SPL != dec.charAt(32)) {
            throw new ParameterExcption("accessToken illegal");
        }
        LocalDateTime time = TimeSecretUtils.check32(dec.substring(33));
        if (time == null) {
            throw new ParameterExcption("secret illegal");
        }
        return new AccessTokenBody(dec.substring(0, 32), time);
    }

    public static String base64Encode(String src) {
        Objects.requireNonNull(src, "src");
        return Base64Utils.encodeToUrlSafeString(src.getBytes());
    }

    public static String base64Decode(String src) {
        Objects.requireNonNull(src, "src");
        return new String(Base64Utils.decodeFromUrlSafeString(src));
    }
}
