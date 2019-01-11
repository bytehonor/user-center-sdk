package com.bytehonor.sdk.center.user.service.impl;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.redis.core.RedisTemplate;

import com.bytehonor.sdk.center.user.model.AccessToken;
import com.bytehonor.sdk.center.user.service.AccessTokenCacheService;
import com.bytehonor.sdk.center.user.util.RedisCacheUtils;

public class AccessTokenCacheServiceImpl implements AccessTokenCacheService {

    private RedisTemplate<String, Serializable> redisTemplate;

    public AccessTokenCacheServiceImpl(RedisTemplate<String, Serializable> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void save(AccessToken userToken, long expireAt) {
        Objects.requireNonNull(userToken, "userToken");
        Objects.requireNonNull(userToken.getProfileType(), "profileType");
        Objects.requireNonNull(userToken.getFromTerminal(), "fromTerminal");
        Objects.requireNonNull(userToken.getToken(), "token");
        Objects.requireNonNull(userToken.getGuid(), "guid");

        String key = RedisCacheUtils.buildKey(userToken.getProfileType(), userToken.getFromTerminal());
        String value = RedisCacheUtils.buildValue(userToken.getToken(), expireAt);
        redisTemplate.opsForHash().put(key, userToken.getGuid(), value);
    }

    @Override
    public void remove(AccessToken userToken) {
        Objects.requireNonNull(userToken, "userToken");
        Objects.requireNonNull(userToken.getProfileType(), "profileType");
        Objects.requireNonNull(userToken.getFromTerminal(), "fromTerminal");
        Objects.requireNonNull(userToken.getGuid(), "guid");

        String key = RedisCacheUtils.buildKey(userToken.getProfileType(), userToken.getFromTerminal());
        redisTemplate.opsForHash().delete(key, userToken.getGuid());
    }

    @Override
    public Object get(AccessToken userToken) {
        Objects.requireNonNull(userToken, "userToken");
        Objects.requireNonNull(userToken.getProfileType(), "profileType");
        Objects.requireNonNull(userToken.getFromTerminal(), "fromTerminal");
        Objects.requireNonNull(userToken.getGuid(), "guid");

        String key = RedisCacheUtils.buildKey(userToken.getProfileType(), userToken.getFromTerminal());
        return redisTemplate.opsForHash().get(key, userToken.getGuid());
    }

}
