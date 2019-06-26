package com.bytehonor.sdk.center.user.service;

public interface AccessTokenCacheService {

    public void save(String fromTerminal, String token, long expireAt);

    public boolean isEffective(String fromTerminal, String token);

    public void remove(String fromTerminal, String token);
}
