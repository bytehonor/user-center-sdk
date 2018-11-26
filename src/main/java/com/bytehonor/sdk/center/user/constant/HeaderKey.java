package com.bytehonor.sdk.center.user.constant;

public class HeaderKey {

	/**
	 * X-From-Terminal
	 */
	public static final String X_FROM_TERMINAL = "X-From-Terminal";

	/**
	 * X-Real-Ip
	 */
	public static final String X_REAL_IP = "X-Real-Ip";

	/**
	 * X-Forwarded-For
	 */
	public static final String X_FORWARDED_FOR = "X-Forwarded-For";

	/**
	 * 内部请求time
	 */
	public static final String X_RPC_TIME = "X-Rpc-Time";

	/**
	 * 内部请求sign md5（X_FROM_TERMINAL + X_RPC_TIME）
	 */
	public static final String X_RPC_SIGN = "X-Rpc-Sign";
	
	/**
	 * 用户身份同行信息
	 */
	public static final String x_USER_PASSPORT = "X-User-Passport";
}
