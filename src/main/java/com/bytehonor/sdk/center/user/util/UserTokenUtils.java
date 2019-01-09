package com.bytehonor.sdk.center.user.util;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.bytehonor.sdk.center.user.constant.UserProfileEnum;
import com.bytehonor.sdk.center.user.model.UserToken;

public class UserTokenUtils {

    private static final Logger LOG = LoggerFactory.getLogger(UserTokenUtils.class);

    private static final char CON = '@';

    public static UserToken build(HttpServletRequest request) {
        Objects.requireNonNull(request, "request");
        UserToken ut = new UserToken();
        boolean debug = "true".equals(request.getParameter("debug"));
        ut.setDebug(debug);
        if (debug) {
            return ut;
        }

        // 1@guid@token
        String auth = request.getHeader("Authentication");
        if (LOG.isDebugEnabled()) {
            LOG.debug("Authentication:{}", auth);
        }
        if (StringUtils.isEmpty(auth)) {
            throw new RuntimeException("Authentication is null");
        }

        List<String> list = UserPassportUtils.split(auth, CON);
        if (list == null || list.size() < 3) {
            throw new RuntimeException("Authentication is invalid");
        }
        Integer typeVal = Integer.valueOf(list.get(0));
        UserProfileEnum type = UserProfileEnum.typeOf(typeVal);
        if (UserProfileEnum.UNKNOWN.getType() == type.getType()) {
            throw new RuntimeException("Authentication type is invalid");
        }

        String guid = list.get(1);
        String token = list.get(2);
        ut.setGuid(guid);
        ut.setToken(token);
        ut.setProfileType(typeVal);
        return ut;
    }

}
