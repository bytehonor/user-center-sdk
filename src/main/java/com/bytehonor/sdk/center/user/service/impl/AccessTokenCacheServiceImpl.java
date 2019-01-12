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
    public void save(Integer roleKey, String fromTerminal, String guid, String token, long expireAt) {
        Objects.requireNonNull(roleKey, "roleKey");
        Objects.requireNonNull(fromTerminal, "fromTerminal");
        Objects.requireNonNull(guid, "guid");
        Objects.requireNonNull(token, "token");
        String key = RedisCacheUtils.buildKey(roleKey, fromTerminal);
        String value = RedisCacheUtils.buildValue(token, expireAt);
        redisTemplate.opsForHash().put(key, guid, value);
    }

    @Override
    public void save(AccessToken token, long expireAt) {
        Objects.requireNonNull(token, "accessToken");

        save(token.getRoleKey(), token.getFromTerminal(), token.getGuid(), token.getToken(), expireAt);
    }

    @Override
    public void remove(AccessToken token) {
        Objects.requireNonNull(token, "userToken");
        Objects.requireNonNull(token.getRoleKey(), "roleKey");
        Objects.requireNonNull(token.getFromTerminal(), "fromTerminal");
        Objects.requireNonNull(token.getGuid(), "guid");

        String key = RedisCacheUtils.buildKey(token.getRoleKey(), token.getFromTerminal());
        redisTemplate.opsForHash().delete(key, token.getGuid());
    }

    @Override
    public Object get(AccessToken userToken) {
        Objects.requireNonNull(userToken, "userToken");
        Objects.requireNonNull(userToken.getRoleKey(), "roleKey");
        Objects.requireNonNull(userToken.getFromTerminal(), "fromTerminal");
        Objects.requireNonNull(userToken.getGuid(), "guid");

        String key = RedisCacheUtils.buildKey(userToken.getRoleKey(), userToken.getFromTerminal());
        return redisTemplate.opsForHash().get(key, userToken.getGuid());
    }

}
