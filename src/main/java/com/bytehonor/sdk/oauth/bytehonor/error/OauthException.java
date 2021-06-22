package com.bytehonor.sdk.oauth.bytehonor.error;

import com.bytehonor.sdk.define.bytehonor.code.StandardCode;
import com.bytehonor.sdk.define.bytehonor.error.StandardException;

public class OauthException extends StandardException {

    private static final long serialVersionUID = -4075883869265211853L;

    public OauthException() {
        super(StandardCode.UNAUTHORIZED, "oauth failed");
    }

    public OauthException(String message) {
        super(StandardCode.UNAUTHORIZED, message);
    }
}