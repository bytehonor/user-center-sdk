package com.bytehonor.sdk.oauth.bytehonor.model;

import java.util.Objects;

public class AccessTokenBody {

    private String uuid;

    private Long expireAt;

    public AccessTokenBody(String uuid, Long expireAt) {
        this.uuid = uuid;
        this.expireAt = expireAt;
    }

    public AccessTokenBody() {
        this(null, null);
    }

    public static AccessTokenBody of(String uuid, Long expireAt) {
        Objects.requireNonNull(uuid, "uuid");
        Objects.requireNonNull(expireAt, "expireAt");
        return new AccessTokenBody(uuid, expireAt);
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(Long expireAt) {
        this.expireAt = expireAt;
    }

}
