package com.bytehonor.sdk.oauth.bytehonor.model;

public class OauthRequest {

    private String fromTerminal;

    private String path;

    private String accessToken;

    private String accessSign;

    private String debug;

    public String getFromTerminal() {
        return fromTerminal;
    }

    public void setFromTerminal(String fromTerminal) {
        this.fromTerminal = fromTerminal;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessSign() {
        return accessSign;
    }

    public void setAccessSign(String accessSign) {
        this.accessSign = accessSign;
    }

    public String getDebug() {
        return debug;
    }

    public void setDebug(String debug) {
        this.debug = debug;
    }

}
