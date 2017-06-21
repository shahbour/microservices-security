package com.shahbour.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.stereotype.Component;

/**
 * Created by shahbour on 14/06/17.
 */
public class OAuth2FeignRequestInterceptor implements RequestInterceptor {

    private final OAuth2RestTemplate oauth2RestTemplate;

    public OAuth2FeignRequestInterceptor(OAuth2RestTemplate oauth2RestTemplate) {
        this.oauth2RestTemplate = oauth2RestTemplate;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Authorization", "bearer " + oauth2RestTemplate.getAccessToken().getValue());
    }
}
