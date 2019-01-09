package com.bytehonor.sdk.center.user.service.impl;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.redis.core.RedisTemplate;

import com.bytehonor.sdk.center.user.model.UserToken;
import com.bytehonor.sdk.center.user.service.UserTokenCacheService;
import com.bytehonor.sdk.center.user.util.RedisCacheUtils;

public class UserTokenCacheServiceImpl implements UserTokenCacheService {

    private RedisTemplate<String, Serializable> redisTemplate;

    public UserTokenCacheServiceImpl(RedisTemplate<String, Serializable> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void save(UserToken userToken, long expireAt, String fromTerminal) {
        Objects.requireNonNull(userToken, "userToken");
        Objects.requireNonNull(fromTerminal, "fromTerminal");
        String key = RedisCacheUtils.buildKey(userToken.getProfileType(), fromTerminal);
        String value = RedisCacheUtils.buildValue(userToken.getToken(), expireAt);
        redisTemplate.opsForHash().put(key, userToken.getGuid(), value);
    }

    @Override
    public void remove(UserToken userToken, String fromTerminal) {
        Objects.requireNonNull(userToken, "userToken");
        Objects.requireNonNull(fromTerminal, "fromTerminal");
        String key = RedisCacheUtils.buildKey(userToken.getProfileType(), fromTerminal);
        redisTemplate.opsForHash().delete(key, userToken.getGuid());
    }

    @Override
    public Object get(UserToken userToken, String fromTerminal) {
        Objects.requireNonNull(userToken, "userToken");
        Objects.requireNonNull(fromTerminal, "fromTerminal");
        String key = RedisCacheUtils.buildKey(userToken.getProfileType(), fromTerminal);
        return redisTemplate.opsForHash().get(key, userToken.getGuid());
    }

}
