package com.bytehonor.sdk.center.user.constant;

/**
 * TerminalEnum
 * 
 * @author lijianqiang
 *
 */
public enum TerminalEnum {
	UNKNOWN(0, "UNKNOWN"),

	HUAJIETAOJIN_WECHAT(1, "HUAJIETAOJIN_WECHAT"),

	HUAJIETAOJIN_MERCHANT(2, "HUAJIETAOJIN_MERCHANT"),

	HUAJIETAOJIN_ADMIN(3, "HUAJIETAOJIN_ADMIN"),

	;

	private final int key;

	private final String name;

	TerminalEnum(int key, String name) {
		this.key = key;
		this.name = name;
	}

	public int getKey() {
		return key;
	}

	public String getName() {
		return name;
	}

	public static TerminalEnum keyOf(int key) {
		for (TerminalEnum bean : values()) {
			if (bean.key == key) {
				return bean;
			}
		}
		return UNKNOWN;
	}

}
