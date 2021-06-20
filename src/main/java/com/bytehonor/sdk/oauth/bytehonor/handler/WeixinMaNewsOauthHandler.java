package com.bytehonor.sdk.oauth.bytehonor.handler;

import com.bytehonor.sdk.oauth.bytehonor.constant.BytehonorTerminalEnum;
import com.bytehonor.sdk.oauth.bytehonor.model.OauthResult;
import com.bytehonor.sdk.oauth.bytehonor.model.OauthRequest;

public class WeixinMaNewsOauthHandler implements OauthHandler {

    @Override
    public BytehonorTerminalEnum terminal() {
        return BytehonorTerminalEnum.WEIXIN_MA_NEWS;
    }

    @Override
    public OauthResult handle(OauthRequest request) {
        return OauthResult.permit(null, null);
    }

}
