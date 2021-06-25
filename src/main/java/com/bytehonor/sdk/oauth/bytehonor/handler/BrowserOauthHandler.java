package com.bytehonor.sdk.oauth.bytehonor.handler;

import java.util.Objects;

import com.bytehonor.sdk.define.bytehonor.error.TokenExpiredExcption;
import com.bytehonor.sdk.oauth.bytehonor.constant.BytehonorTerminalEnum;
import com.bytehonor.sdk.oauth.bytehonor.model.AccessTokenBody;
import com.bytehonor.sdk.oauth.bytehonor.model.OauthRequest;
import com.bytehonor.sdk.oauth.bytehonor.model.OauthResult;
import com.bytehonor.sdk.oauth.bytehonor.util.AccessTokenUtils;

public class BrowserOauthHandler implements OauthHandler {

    @Override
    public BytehonorTerminalEnum terminal() {
        return BytehonorTerminalEnum.BROWSER;
    }

    @Override
    public OauthResult handle(OauthRequest request) {
        Objects.requireNonNull(request.getDebug(), "debug");
        AccessTokenBody body = AccessTokenUtils.parse(request.getDebug()); // 放在debug
        if (body.getExpireAt() < System.currentTimeMillis()) {
            throw new TokenExpiredExcption();
        }
        return OauthResult.permit(body.getUuid(), null);
    }

}
