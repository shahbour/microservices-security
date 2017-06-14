package com.shahbour.config;

import com.shahbour.domain.Customer;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import java.util.List;

/**
 * Created by shahbour on 14/06/17.
 */
@Configuration
@EnableOAuth2Client
@Slf4j
public class RootConfiguration {

    private final ClientCredentialsResourceDetails oauth2RemoteResource;

    public RootConfiguration(ClientCredentialsResourceDetails oauth2RemoteResource) {
      log.info("Root Configuration");
     // oauth2RemoteResource.setClientId("task");
      this.oauth2RemoteResource = oauth2RemoteResource;

    }

//    @Bean
//    @Primary
//    public OAuth2RestTemplate oauth2RestTemplate() {
//        OAuth2RestTemplate template = new OAuth2RestTemplate(oauth2RemoteResource, new DefaultOAuth2ClientContext(new DefaultAccessTokenRequest()));
////        OAuth2AccessToken oAuth2AccessToken = template.getAccessToken();
////        log.info("{}" ,oAuth2AccessToken.getTokenType());
//        Customer customer = template.getForObject("http://resource-service/customers/1",  Customer.class);
//        return template;
//    }

//    @Bean
//    public RequestInterceptor requestTokenBearerInterceptor() {
//        return new RequestInterceptor() {
//            @Override
//            public void apply(RequestTemplate requestTemplate) {
//                OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)
//                        SecurityContextHolder.getContext().getAuthentication().getDetails();
//
//
//            }
//        };
//    }

}
