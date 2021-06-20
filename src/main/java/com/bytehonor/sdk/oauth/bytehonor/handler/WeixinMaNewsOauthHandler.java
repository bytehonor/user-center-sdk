package com.bytehonor.sdk.oauth.bytehonor.handler;

import com.bytehonor.sdk.oauth.bytehonor.constant.BytehonorTerminalEnum;
import com.bytehonor.sdk.oauth.bytehonor.model.OauthPassport;
import com.bytehonor.sdk.oauth.bytehonor.model.OauthRequest;

public class WeixinMaNewsOauthHandler implements OauthHandler {

    @Override
    public BytehonorTerminalEnum terminal() {
        return BytehonorTerminalEnum.WEIXIN_MA_NEWS;
    }

    @Override
    public OauthPassport handle(OauthRequest request) {
        return OauthPassport.permit(null, null);
    }

}
