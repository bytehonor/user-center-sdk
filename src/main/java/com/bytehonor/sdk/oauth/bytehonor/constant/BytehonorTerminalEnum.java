package com.bytehonor.sdk.oauth.bytehonor.constant;

import com.bytehonor.sdk.lang.bytehonor.string.StringObject;

/**
 * 
 * @author lijianqiang
 *
 */
public enum BytehonorTerminalEnum {

    BROWSER("browser", "浏览器"),

    WEB_VUE("vue-now-ui-web", "vue.bytehonor.com的WEB端"),

    WEB_ADMIN("news-admin-web", "admin.bytehonor.comd的WEB端"),

    WEIXIN_MA_NEWS("weixin-ma-wx6606ed97cb1b17e1", "微信小程序.全网重点"),

    ;

    private String key;

    private String name;

    private BytehonorTerminalEnum(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public static BytehonorTerminalEnum keyOf(String key) {
        if (StringObject.isEmpty(key)) {
            return BROWSER;
        }
        key = key.toLowerCase();
        for (BytehonorTerminalEnum item : BytehonorTerminalEnum.values()) {
            if (item.getKey().equals(key)) {
                return item;
            }
        }
        return BROWSER;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
