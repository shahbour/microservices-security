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
@Component
public class Interceptor implements RequestInterceptor {

    private final OAuth2RestTemplate template;

    public Interceptor(ClientCredentialsResourceDetails oauth2RemoteResource) {
      template = new OAuth2RestTemplate(oauth2RemoteResource, new DefaultOAuth2ClientContext(new DefaultAccessTokenRequest()));
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Authorization", "bearer " + template.getAccessToken().getValue());
    }
}
