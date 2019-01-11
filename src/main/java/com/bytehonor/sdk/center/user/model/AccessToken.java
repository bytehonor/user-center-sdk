package com.bytehonor.sdk.center.user.model;

import com.bytehonor.sdk.center.user.constant.TerminalEnum;

public class AccessToken {

    private Boolean debug;

    private String guid;

    private String token;

    private Integer terminalKey;

    private String terminalName;

    public AccessToken() {
        this.debug = false;
        this.terminalKey = TerminalEnum.UNKNOWN.getKey();
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

    public Integer getTerminalKey() {
        return terminalKey;
    }

    public void setTerminalKey(Integer terminalKey) {
        this.terminalKey = terminalKey;
    }

    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

}
