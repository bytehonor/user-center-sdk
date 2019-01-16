package com.bytehonor.sdk.center.user.constant;

/**
 * UserRoleEnum
 * 
 * @author lijianqiang
 *
 */
public enum UserRoleEnum {
    BYTEHONOR_USER(0, "BYTEHONOR_USER"),

    CONSUMER(1, "CONSUMER"),

    MERCHANT(2, "CONSUMER"),

    ADMIN(3, "CONSUMER"),

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
        return null;
    }

}
