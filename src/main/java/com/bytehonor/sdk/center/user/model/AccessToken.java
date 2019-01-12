package com.bytehonor.sdk.center.user.model;

import com.bytehonor.sdk.center.user.constant.UserRoleEnum;

public class AccessToken {

    private Boolean debug;

    private String guid;

    private String token;

    private Integer roleKey;

    private String fromTerminal;

    public AccessToken() {
        this.debug = false;
        this.roleKey = UserRoleEnum.BYTEHONOR_USER.getKey();
    }

    public Boolean getDebug() {
        return debug;
    }

    public void setDebug(Boolean debug) {
        this.debug = debug;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(Integer roleKey) {
        this.roleKey = roleKey;
    }

    public String getFromTerminal() {
        return fromTerminal;
    }

    public void setFromTerminal(String fromTerminal) {
        this.fromTerminal = fromTerminal;
    }

}
