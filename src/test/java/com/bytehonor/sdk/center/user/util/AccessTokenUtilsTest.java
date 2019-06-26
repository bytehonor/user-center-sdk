package com.bytehonor.sdk.center.user.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccessTokenUtilsTest {

    private static final Logger LOG = LoggerFactory.getLogger(AccessTokenUtilsTest.class);

    @Test
    public void test() {
        String fromTerminal = "browsersssasdfasfd";
        long now = System.currentTimeMillis();
        for (int i = 200; i < 205; i++) {
            String token = AccessTokenUtils.generate(now + i, fromTerminal);
            LOG.info("ok:{}, length:{}, token:{}", AccessTokenUtils.check(token, fromTerminal), token.length(), token);

        }
        assertTrue("test", true);
    }

}
