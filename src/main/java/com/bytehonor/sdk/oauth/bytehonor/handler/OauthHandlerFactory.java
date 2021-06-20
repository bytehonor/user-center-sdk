package com.bytehonor.sdk.oauth.bytehonor.handler;

import java.util.HashMap;
import java.util.Map;

import com.bytehonor.sdk.oauth.bytehonor.constant.BytehonorTerminalEnum;

public class OauthHandlerFactory {

    private static Map<String, OauthHandler> MAP = new HashMap<String, OauthHandler>();

    static {
        register(new BrowserOauthHandler());
        register(new WebAdminOauthHandler());
        register(new WebVueOauthHandler());
        register(new WeixinMaNewsOauthHandler());
    }

    private static void register(OauthHandler handler) {
        MAP.put(handler.terminal().getKey(), handler);
    }

    public static OauthHandler get(String terminal) {
        OauthHandler handler = MAP.get(terminal);
        if (handler != null) {
            return handler;
        }
        return MAP.get(BytehonorTerminalEnum.BROWSER.getKey());
    }
}
