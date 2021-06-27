package com.bytehonor.sdk.oauth.bytehonor.model;

public class OauthRequest {

    private Boolean strict;

    private String fromTerminal;

    private String path;

    private String method;

    private String accessToken;

    private String accessSign;

    private Long accessTime;

    private String browsToken;
    
    public OauthRequest() {
        this.strict = true;
    }

    public Boolean getStrict() {
        return strict;
    }

    public void setStrict(Boolean strict) {
        this.strict = strict;
    }

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

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Long getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Long accessTime) {
        this.accessTime = accessTime;
    }

    public String getBrowsToken() {
        return browsToken;
    }

    public void setBrowsToken(String browsToken) {
        this.browsToken = browsToken;
    }

}
