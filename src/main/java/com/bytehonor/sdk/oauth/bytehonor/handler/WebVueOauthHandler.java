package com.bytehonor.sdk.oauth.bytehonor.handler;

import java.util.Objects;

import com.bytehonor.sdk.define.bytehonor.constant.TimeConstants;
import com.bytehonor.sdk.define.bytehonor.error.TokenExpiredExcption;
import com.bytehonor.sdk.oauth.bytehonor.constant.BytehonorTerminalEnum;
import com.bytehonor.sdk.oauth.bytehonor.model.AccessTokenBody;
import com.bytehonor.sdk.oauth.bytehonor.model.OauthRequest;
import com.bytehonor.sdk.oauth.bytehonor.model.OauthResult;
import com.bytehonor.sdk.oauth.bytehonor.util.AccessTokenUtils;
import com.bytehonor.sdk.oauth.bytehonor.util.OauthSignUtils;

public class WebVueOauthHandler implements OauthHandler {

    @Override
    public BytehonorTerminalEnum terminal() {
        return BytehonorTerminalEnum.WEB_VUE;
    }

    @Override
    public OauthResult handle(OauthRequest request) {
        Objects.requireNonNull(request.getFromTerminal(), "fromTerminal");
        Objects.requireNonNull(request.getPath(), "path");
        Objects.requireNonNull(request.getAccessToken(), "accessToken");
        Objects.requireNonNull(request.getAccessSign(), "accessSign");
        long now = System.currentTimeMillis();
        if (now - request.getAccessTime() > TimeConstants.HOUR) {
            throw new TokenExpiredExcption();
        }
        if (request.getStrict()) {
            OauthSignUtils.checkSign(request.getPath(), request.getAccessToken(), request.getAccessTime(),
                    request.getAccessSign());
        }
        AccessTokenBody body = AccessTokenUtils.parse(request.getAccessToken());
        if (body.getExpireAt() < now) {
            throw new TokenExpiredExcption();
        }
        return OauthResult.permit(body.getUuid(), null);
    }

}
