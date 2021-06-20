package com.bytehonor.sdk.oauth.bytehonor.model;

public class OauthPassport {

    private String uuid;

    private Boolean enabled;

    private Boolean admin;

    private Long timestamp;

    public static OauthPassport permit(String uuid, Boolean admin) {
        return new OauthPassport(uuid, true, admin);
    }

    public static OauthPassport deny(String uuid, Boolean admin) {
        return new OauthPassport(uuid, false, admin);
    }

    public OauthPassport(String uuid, Boolean enabled, Boolean admin) {
        this.uuid = uuid;
        this.enabled = enabled;
        this.admin = admin;
    }

    public OauthPassport() {
        this(null, null, null);
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

}
