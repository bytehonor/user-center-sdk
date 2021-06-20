package com.bytehonor.sdk.oauth.bytehonor.service.impl;

public class AccessTokenCacheServiceImpl {

//    private RedisTemplate<String, Serializable> redisTemplate;
//
//    public AccessTokenCacheServiceImpl(RedisTemplate<String, Serializable> redisTemplate) {
//        this.redisTemplate = redisTemplate;
//    }
//
//    @Override
//    public void save(String fromTerminal, String token, long expireAt) {
//        Objects.requireNonNull(fromTerminal, "fromTerminal");
//        Objects.requireNonNull(token, "token");
//        String key = RedisCacheUtils.buildKey(fromTerminal, token);
//        long timeout = expireAt - System.currentTimeMillis() - RandomUtils.getInt(1111, 9999);
//        redisTemplate.opsForValue().setIfAbsent(key, String.valueOf(expireAt), timeout, TimeUnit.MILLISECONDS);
//    }
//
//    @Override
//    public void remove(String fromTerminal, String token) {
//        Objects.requireNonNull(fromTerminal, "fromTerminal");
//        Objects.requireNonNull(token, "token");
//
//        String key = RedisCacheUtils.buildKey(fromTerminal, token);
//        redisTemplate.delete(key);
//    }
//
//    @Override
//    public boolean isEffective(String fromTerminal, String token) {
//        Objects.requireNonNull(fromTerminal, "fromTerminal");
//        Objects.requireNonNull(token, "token");
//
//        String key = RedisCacheUtils.buildKey(fromTerminal, token);
//        Object val = redisTemplate.opsForValue().get(key);
//        if (val == null) {
//            return false;
//        }
//        long expireAt = 0L;
//        try {
//            expireAt = Long.valueOf((String) val);
//        } catch (Exception e) {
//
//        }
//        return expireAt > System.currentTimeMillis();
//
//    }

}
