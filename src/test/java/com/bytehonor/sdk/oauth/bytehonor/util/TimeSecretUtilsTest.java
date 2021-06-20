package com.bytehonor.sdk.oauth.bytehonor.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeSecretUtilsTest {

    private static final Logger LOG = LoggerFactory.getLogger(TimeSecretUtilsTest.class);

    @Test
    public void testMake32() {
        int count = 0;
        int size = 10000;
        for (int i = 0; i < size; i++) {
            String secret = TimeSecretUtils.make32();
            boolean isOk = TimeSecretUtils.check32(secret) != null;
            LOG.info("{}, {}, {}", isOk, secret.length(), secret);
            if (isOk) {
                count++;
            }
        }
        assertTrue("*testMake32*", count == size);
    }

}
