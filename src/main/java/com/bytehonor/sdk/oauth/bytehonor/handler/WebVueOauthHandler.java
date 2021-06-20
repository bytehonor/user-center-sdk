package com.bytehonor.sdk.oauth.bytehonor.handler;

import java.time.LocalDateTime;
import java.util.Objects;

import com.bytehonor.sdk.define.bytehonor.error.TokenExpiredExcption;
import com.bytehonor.sdk.oauth.bytehonor.constant.BytehonorTerminalEnum;
import com.bytehonor.sdk.oauth.bytehonor.model.AccessTokenBody;
import com.bytehonor.sdk.oauth.bytehonor.model.OauthPassport;
import com.bytehonor.sdk.oauth.bytehonor.model.OauthRequest;
import com.bytehonor.sdk.oauth.bytehonor.util.AccessTokenUtils;
import com.bytehonor.sdk.oauth.bytehonor.util.OauthSignUtils;

public class WebVueOauthHandler implements OauthHandler {

    @Override
    public BytehonorTerminalEnum terminal() {
        return BytehonorTerminalEnum.WEB_VUE;
    }

    @Override
    public OauthPassport handle(OauthRequest request) {
        Objects.requireNonNull(request.getFromTerminal(), "fromTerminal");
        Objects.requireNonNull(request.getPath(), "path");
        Objects.requireNonNull(request.getAccessToken(), "accessToken");
        Objects.requireNonNull(request.getAccessSign(), "accessSign");

        OauthSignUtils.checkSignV1(request.getPath(), request.getAccessToken(), request.getAccessSign());
        AccessTokenBody body = AccessTokenUtils.parse(request.getAccessToken());
        LocalDateTime expired = LocalDateTime.now().minusHours(2L);
        if (expired.isAfter(body.getTime())) {
            throw new TokenExpiredExcption();
        }
        return OauthPassport.permit(body.getUuid(), null);
    }

}
