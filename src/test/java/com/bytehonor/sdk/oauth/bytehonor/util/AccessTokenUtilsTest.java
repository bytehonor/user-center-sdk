package com.bytehonor.sdk.oauth.bytehonor.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bytehonor.sdk.lang.bytehonor.util.MD5Utils;
import com.bytehonor.sdk.oauth.bytehonor.model.AccessTokenBody;

public class AccessTokenUtilsTest {

    private static final Logger LOG = LoggerFactory.getLogger(AccessTokenUtilsTest.class);

    @Test
    public void testMake() {
        String uuid = MD5Utils.md5("123456");
        String accessToken = AccessTokenUtils.make(uuid);
        LOG.info("accessToken:{}", accessToken);

        AccessTokenBody body = AccessTokenUtils.parse(accessToken);
        LOG.info("uuid:{}, time:{}", body.getUuid(), body.getTime());

        assertTrue("test", uuid.equals(body.getUuid()));
    }

}
