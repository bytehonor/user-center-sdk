package com.bytehonor.sdk.oauth.bytehonor.handler;

import java.util.Objects;

import com.bytehonor.sdk.oauth.bytehonor.constant.BytehonorTerminalEnum;
import com.bytehonor.sdk.oauth.bytehonor.model.OauthPassport;
import com.bytehonor.sdk.oauth.bytehonor.model.OauthRequest;

public class WebAdminOauthHandler implements OauthHandler {

    @Override
    public BytehonorTerminalEnum terminal() {
        return BytehonorTerminalEnum.WEB_ADMIN;
    }

    @Override
    public OauthPassport handle(OauthRequest request) {
        Objects.requireNonNull(request.getFromTerminal(), "fromTerminal");
        
        return OauthPassport.permit(null, null);
    }

}
