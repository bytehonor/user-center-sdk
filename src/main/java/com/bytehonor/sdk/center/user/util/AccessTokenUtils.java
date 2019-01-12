package com.bytehonor.sdk.center.user.util;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bytehonor.sdk.center.user.constant.UserRoleEnum;
import com.bytehonor.sdk.center.user.model.AccessToken;

public class AccessTokenUtils {

    private static final Logger LOG = LoggerFactory.getLogger(AccessTokenUtils.class);

    private static final char CON = '@';

    private static final String TRUE = "true";

    public static AccessToken build(HttpServletRequest request, String fromTerminal) {
        Objects.requireNonNull(request, "request");
        Objects.requireNonNull(fromTerminal, "fromTerminal");

        AccessToken accessToken = new AccessToken();
        accessToken.setFromTerminal(fromTerminal);
        boolean debug = TRUE.equals(request.getParameter("debug"));
        accessToken.setDebug(debug);
        if (debug) {
            return accessToken;
        }

        // 1@guid@token
        String auth = request.getHeader("Authentication");
        if (LOG.isDebugEnabled()) {
            LOG.debug("Authentication:{}", auth);
        }
        Objects.requireNonNull(auth, "Authentication");

        List<String> list = UserPassportUtils.split(auth, CON);
        if (list == null || list.size() < 3) {
            throw new RuntimeException("Authentication is invalid");
        }
        Integer typeVal = Integer.valueOf(list.get(0));
        UserRoleEnum role = UserRoleEnum.keyOf(typeVal);

        String guid = list.get(1);
        String token = list.get(2);
        accessToken.setGuid(guid);
        accessToken.setToken(token);
        accessToken.setRoleKey(role.getKey());
        return accessToken;
    }

}
