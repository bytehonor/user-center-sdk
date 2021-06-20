package com.bytehonor.sdk.oauth.bytehonor.handler;

import java.util.Objects;

import com.bytehonor.sdk.oauth.bytehonor.constant.BytehonorTerminalEnum;
import com.bytehonor.sdk.oauth.bytehonor.model.OauthPassport;
import com.bytehonor.sdk.oauth.bytehonor.model.OauthRequest;

public class BrowserOauthHandler implements OauthHandler {

    @Override
    public BytehonorTerminalEnum terminal() {
        return BytehonorTerminalEnum.BROWSER;
    }

    @Override
    public OauthPassport handle(OauthRequest request) {
        Objects.requireNonNull(request.getDebug(), "debug");

        return OauthPassport.permit(null, null);
    }

}
