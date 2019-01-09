package com.bytehonor.sdk.center.user.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

import com.bytehonor.sdk.center.user.constant.UserHeaderKey;
import com.bytehonor.sdk.center.user.model.UserPassport;

public class UserPassportUtils {

	private static final char CON = '&';

	public static UserPassport build(Integer profileType, String guid, String fromIp, String fromTerminal) {
		UserPassport up = new UserPassport();
		up.setFromIp(fromIp);
		up.setFromTerminal(fromTerminal);
		up.setGuid(guid);
		up.setProfileType(profileType);
		return up;
	}

	public static String toString(Integer profileType, String guid, String fromTerminal, String fromIp) {
		StringBuilder sb = new StringBuilder();
		sb.append(profileType).append(CON).append(guid).append(CON).append(fromTerminal).append(CON).append(fromIp);
		return sb.toString();
	}

	public static UserPassport get(HttpServletRequest request) {
		String val = request.getHeader(UserHeaderKey.X_USER_PASSPORT);
		return get(val);
	}

	public static UserPassport get(String val) {
		UserPassport up = new UserPassport();
		if (StringUtils.isEmpty(val)) {
			return up;
		}
		List<String> arr = split(val);
		if (arr == null || arr.size() != 4) {
			return up;
		}
		up.setProfileType(Integer.valueOf(arr.get(0)));
		up.setGuid(arr.get(1));
		up.setFromTerminal(arr.get(2));
		up.setFromIp(arr.get(3));
		return up;
	}

	/**
	 * 比 src.spilt() 会更快一些
	 * 
	 * @param src
	 * @return
	 */
	public static List<String> split(String src) {
		Objects.requireNonNull(src, "src");
		int length = src.length();
		List<String> res = new ArrayList<String>();
		int begin = 0;
		int count = 0;
		boolean findOne = false;
		boolean beginNewOne = true;
		char[] charArray = src.toCharArray();
		for (int i = 0; i < length; i++) {
			if (CON != charArray[i]) {
				if (beginNewOne) {
					begin = i;
					beginNewOne = false;
				}
				count++;
				findOne = false;
			} else {
				findOne = true;
			}

			if (findOne && count > 0) {
				res.add(new String(charArray, begin, count));
				count = 0;
				beginNewOne = true;
			}
		}

		if (count > 0) {
			res.add(new String(charArray, begin, count));
		}

		return res;
	}
}
