package com.bytehonor.sdk.center.user.constant;

/**
 * UserProfileTypeEnum
 * 
 * @author lijianqiang
 *
 */
public enum UserProfileTypeEnum {
	UNKNOWN(0, "UNKNOWN"),

	HUAJIETAOJIN_WECHAT(1, "HUAJIETAOJIN_WECHAT"),

	HUAJIETAOJIN_MERCHANT(2, "HUAJIETAOJIN_MERCHANT"),

	HUAJIETAOJIN_ADMIN(3, "HUAJIETAOJIN_ADMIN"),

	;

	private final int type;

	private final String name;

	UserProfileTypeEnum(int type, String name) {
		this.type = type;
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public static UserProfileTypeEnum typeOf(int type) {
		for (UserProfileTypeEnum bean : values()) {
			if (bean.type == type) {
				return bean;
			}
		}
		return UNKNOWN;
	}

}
