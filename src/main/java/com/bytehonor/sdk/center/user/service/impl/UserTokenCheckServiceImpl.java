package com.bytehonor.sdk.center.user.service.impl;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;

import com.bytehonor.sdk.center.user.model.StringLongPair;
import com.bytehonor.sdk.center.user.model.UserToken;
import com.bytehonor.sdk.center.user.service.UserTokenCheckService;
import com.bytehonor.sdk.center.user.util.RedisCacheUtils;

public class UserTokenCheckServiceImpl implements UserTokenCheckService {

	private static final Logger LOG = LoggerFactory.getLogger(UserTokenCheckServiceImpl.class);

	private RedisTemplate<String, Serializable> redisTemplate;

	public UserTokenCheckServiceImpl(RedisTemplate<String, Serializable> redisTemplate) {
		LOG.info("construct");
		this.redisTemplate = redisTemplate;
	}

	@Override
	public boolean isEffective(UserToken userToken, String fromTerminal) {
		String key = RedisCacheUtils.buildKey(userToken.getProfileType(), fromTerminal);
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
		if (pair.getKey().equals(userToken.getToken())) {
			LOG.debug("token is invalid");
			throw new RuntimeException("token is invalid");
		}
		long now = System.currentTimeMillis();
		if (now > pair.getValue()) {
			LOG.debug("token is expired");
			throw new RuntimeException("token is expired");
		}
		return true;
	}

}
