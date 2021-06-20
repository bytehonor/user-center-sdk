package com.bytehonor.sdk.oauth.bytehonor.builder;

import java.time.LocalDateTime;

import com.bytehonor.sdk.oauth.bytehonor.constant.BytehonorTerminalEnum;
import com.bytehonor.sdk.oauth.bytehonor.model.AccessTokenBody;

public interface AccessTokenBuilder {

    public BytehonorTerminalEnum terminal();

    public String make(String user, LocalDateTime ldt);
    
    public AccessTokenBody parse(String accessToken);
}
