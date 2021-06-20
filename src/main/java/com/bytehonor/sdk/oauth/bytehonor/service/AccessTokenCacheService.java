package com.bytehonor.sdk.oauth.bytehonor.service;

public interface AccessTokenCacheService {

    public void save(String fromTerminal, String token, long expireAt);

    public boolean isEffective(String fromTerminal, String token);

    public void remove(String fromTerminal, String token);
}
