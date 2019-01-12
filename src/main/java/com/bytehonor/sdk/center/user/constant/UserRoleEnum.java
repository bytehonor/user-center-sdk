package com.bytehonor.sdk.center.user.constant;

/**
 * UserRoleEnum
 * 
 * @author lijianqiang
 *
 */
public enum UserRoleEnum {
    BYTEHONOR_USER(0, "BYTEHONOR_USER"),

    HJTJ_CONSUMER(1, "HJTJ_CONSUMER"),

    HJTJ_MERCHANT(2, "HJTJ_MERCHANT"),

    HJTJ_ADMIN(3, "HJTJ_ADMIN"),

    ;

    private final int key;

    private final String name;

    UserRoleEnum(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public int getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public static UserRoleEnum keyOf(int key) {
        for (UserRoleEnum bean : values()) {
            if (bean.key == key) {
                return bean;
            }
        }
        return BYTEHONOR_USER;
    }

}
