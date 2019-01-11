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
    public void save(Integer terminalType, String terminalName, String guid, String token, long expireAt) {
        Objects.requireNonNull(terminalType, "terminalType");
        Objects.requireNonNull(terminalName, "terminalName");
        Objects.requireNonNull(guid, "guid");
        Objects.requireNonNull(token, "token");
        String key = RedisCacheUtils.buildKey(terminalType, terminalName);
        String value = RedisCacheUtils.buildValue(token, expireAt);
        redisTemplate.opsForHash().put(key, guid, value);
    }

    @Override
    public void save(AccessToken token, long expireAt) {
        Objects.requireNonNull(token, "accessToken");

        save(token.getTerminalKey(), token.getTerminalName(), token.getGuid(), token.getToken(), expireAt);
    }

    @Override
    public void remove(AccessToken token) {
        Objects.requireNonNull(token, "userToken");
        Objects.requireNonNull(token.getTerminalKey(), "profileType");
        Objects.requireNonNull(token.getTerminalName(), "fromTerminal");
        Objects.requireNonNull(token.getGuid(), "guid");

        String key = RedisCacheUtils.buildKey(token.getTerminalKey(), token.getTerminalName());
        redisTemplate.opsForHash().delete(key, token.getGuid());
    }

    @Override
    public Object get(AccessToken userToken) {
        Objects.requireNonNull(userToken, "userToken");
        Objects.requireNonNull(userToken.getTerminalKey(), "profileType");
        Objects.requireNonNull(userToken.getTerminalName(), "fromTerminal");
        Objects.requireNonNull(userToken.getGuid(), "guid");

        String key = RedisCacheUtils.buildKey(userToken.getTerminalKey(), userToken.getTerminalName());
        return redisTemplate.opsForHash().get(key, userToken.getGuid());
    }

}
