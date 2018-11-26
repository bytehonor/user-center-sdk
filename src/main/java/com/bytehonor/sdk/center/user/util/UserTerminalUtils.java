package com.bytehonor.sdk.center.user.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

import com.bytehonor.sdk.center.user.constant.HeaderKey;

public class UserTerminalUtils {
	
	public static String getFromTerminal(HttpServletRequest request) {
		String from = request.getHeader(HeaderKey.X_FROM_TERMINAL);
		return from;
	}

	public static String getFromIp(HttpServletRequest request) {
		String ip = request.getHeader(HeaderKey.X_REAL_IP);
		if (StringUtils.isEmpty(ip) == false) {
			return ip;
		}
		ip = request.getHeader(HeaderKey.X_FORWARDED_FOR);
		if (StringUtils.isEmpty(ip) == false) {
			int at = ip.indexOf(",");
			if (at < 0) {
				return ip;
			}
			return ip.substring(0, at);
		}

		return request.getRemoteAddr();
	}
	
//	public static String getIp(String ip) {
//		if (StringUtils.isEmpty(ip) == false) {
//			int at = ip.indexOf(",");
//			if (at < 0) {
//				return ip;
//			}
//			return ip.substring(0, at);
//		}
//		return "xxx";
//	}
//	
//	public static void main(String[] args) {
//		System.out.println("1:" + getIp("1.1.1.1"));
//		System.out.println("2:" + getIp(null));
//		System.out.println("3:" + getIp("1.1.1.1,2.2.2.2"));
//		System.out.println("4:" + getIp("1.1.1.1,2.2.2.2,3.3.3.3"));
//	}
}
