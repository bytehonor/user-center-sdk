package com.bytehonor.sdk.oauth.bytehonor.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class AccessTokenBody {

    private String uuid;

    private LocalDateTime time;

    public AccessTokenBody(String uuid, LocalDateTime time) {
        this.uuid = uuid;
        this.time = time;
    }

    public AccessTokenBody() {
        this(null, null);
    }

    public static AccessTokenBody of(String uuid, LocalDateTime time) {
        Objects.requireNonNull(uuid, "uuid");
        Objects.requireNonNull(time, "time");
        return new AccessTokenBody(uuid, time);
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

}
