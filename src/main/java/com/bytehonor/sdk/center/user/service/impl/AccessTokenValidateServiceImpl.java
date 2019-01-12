package com.bytehonor.sdk.center.user.service.impl;

import java.io.Serializable;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;

import com.bytehonor.sdk.center.user.model.StringLongPair;
import com.bytehonor.sdk.center.user.model.AccessToken;
import com.bytehonor.sdk.center.user.service.AccessTokenValidateService;
import com.bytehonor.sdk.center.user.util.RedisCacheUtils;

public class AccessTokenValidateServiceImpl implements AccessTokenValidateService {

    private static final Logger LOG = LoggerFactory.getLogger(AccessTokenValidateServiceImpl.class);

    private RedisTemplate<String, Serializable> redisTemplate;

    public AccessTokenValidateServiceImpl(RedisTemplate<String, Serializable> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public boolean isEffective(AccessToken userToken) {
        Objects.requireNonNull(userToken, "userToken");
        Objects.requireNonNull(userToken.getRoleKey(), "roleKey");
        Objects.requireNonNull(userToken.getFromTerminal(), "fromTerminal");
        Objects.requireNonNull(userToken.getToken(), "token");
        Objects.requireNonNull(userToken.getGuid(), "guid");

        String key = RedisCacheUtils.buildKey(userToken.getRoleKey(), userToken.getFromTerminal());
        Object val = redisTemplate.opsForHash().get(key, userToken.getGuid());
        if (val == null) {
            LOG.debug("cache val is null");
            throw new RuntimeException("cache val is null");
        }
        StringLongPair pair = RedisCacheUtils.parseValue(String.valueOf(val));
        if (pair == null || StringUtils.isEmpty(pair.getKey())) {
            LOG.debug("cache parse invalid");
            throw new RuntimeException("cache parse invalid");
        }
        if (pair.getKey().equals(userToken.getToken()) == false) {
            LOG.info("token is invalid, cache:{}, upload:{}", pair.getKey(), userToken.getToken());
            throw new RuntimeException("token is invalid");
        }
        long now = System.currentTimeMillis();
        if (now > pair.getValue()) {
            LOG.info("token is expired, upload:{}, expireAt:{}", userToken.getToken(), pair.getValue());
            throw new RuntimeException("token is expired");
        }
        return true;
    }

}
