package com.bytehonor.sdk.center.user.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bytehonor.sdk.center.user.model.UserPassport;

public class UserPassportUtilsTest {

	private static final Logger LOG = LoggerFactory.getLogger(UserPassportUtilsTest.class);

	@Test
	public void testToString() {
		String src = UserPassportUtils.toString(1, "guid", "fromTerminal", "fromIp");
		LOG.info("src:{}", src);
		assertTrue("*testToString*", src != null);
	}

	@Test
	public void testGetString() {
		UserPassport up = UserPassportUtils.get("1&guid&fromTerminal&fromIp");
		LOG.info("getGuid:{}", up.getGuid());
		assertTrue("*testToString*", up.getGuid() != null);
	}

	@Test
	public void testTime() {
		String src = "1&guid&fromTerminal&fromIp";
		int total = 1000;
		long start1 = System.nanoTime();
		for (int i = 0; i < total; i++) {
			UserPassportUtils.split(src, '&');
		}
		long cost1 = System.nanoTime() - start1;

		long start2 = System.nanoTime();
		for (int i = 0; i < total; i++) {
			src.split("&");
		}
		long cost2 = System.nanoTime() - start2;

		LOG.info("cost1:{}, cost2:{}, diff:{}", cost1, cost2, (cost1 - cost2));
		assertTrue("*testTime*", true);
	}
}
