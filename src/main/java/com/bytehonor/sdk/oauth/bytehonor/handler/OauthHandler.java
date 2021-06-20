package com.bytehonor.sdk.oauth.bytehonor.handler;

import com.bytehonor.sdk.oauth.bytehonor.constant.BytehonorTerminalEnum;
import com.bytehonor.sdk.oauth.bytehonor.model.OauthPassport;
import com.bytehonor.sdk.oauth.bytehonor.model.OauthRequest;

public interface OauthHandler {

    public BytehonorTerminalEnum terminal();

    public OauthPassport handle(OauthRequest request);
}
