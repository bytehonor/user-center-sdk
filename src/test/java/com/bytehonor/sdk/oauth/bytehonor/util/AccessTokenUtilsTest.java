package com.bytehonor.sdk.oauth.bytehonor.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bytehonor.sdk.oauth.bytehonor.model.AccessTokenBody;

public class AccessTokenUtilsTest {

    private static final Logger LOG = LoggerFactory.getLogger(AccessTokenUtilsTest.class);

    @Test
    public void testMake() {
        String uuid = UserUuidUtils.uuidWeixin("wx4bbf894f0e5470ff", "o7Sh9w3IztzKJJvJk8xWf89v4nE8");
        String accessToken = AccessTokenUtils.make(uuid);
        LOG.info("accessToken:{}", accessToken);

        AccessTokenBody body = AccessTokenUtils.parse(accessToken);
        
        LOG.info("uuid:{}, time:{}", body.getUuid(), body.getExpireAt());

        assertTrue("test", uuid.equals(body.getUuid()));
    }

}
