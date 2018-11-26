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
	public boolean isUserTokenOk(UserToken userToken, String fromTerminal) {
		String key = RedisCacheUtils.buildKey(userToken.getProfileType(), fromTerminal);
		Object val = redisTemplate.opsForHash().get(key, userToken.getGuid());
		if (val == null) {
			LOG.info("cache val is null");
			return false;
		}
		StringLongPair pair = RedisCacheUtils.parseValue(String.valueOf(val));
		if (pair == null || StringUtils.isEmpty(pair.getKey())) {
			LOG.info("cache parse invalid");
			return false;
		}
		if (pair.getKey().equals(userToken.getToken())) {
			LOG.info("token is invalid");
			return false;
		}
		long now = System.currentTimeMillis();
		if (now > pair.getValue()) {
			LOG.info("token is expired");
			return false;
		}
		return true;
	}

}
