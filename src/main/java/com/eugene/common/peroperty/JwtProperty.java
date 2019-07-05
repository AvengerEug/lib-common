package com.eugene.common.peroperty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * jwt properties 配置类
 * 在需要使用它的地方 使用@Resource注解即可
 */
@ConfigurationProperties(prefix = "jwt")
public class JwtProperty {

    private String header;
    private String cookie;
    private String type;
    private String expiration;
    private String secret;
    private Map<String, Object> refresh;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public Map<String, Object> getRefresh() {
        return refresh;
    }

    public void setRefresh(Map<String, Object> refresh) {
        this.refresh = refresh;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
