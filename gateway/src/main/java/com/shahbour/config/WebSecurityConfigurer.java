package com.shahbour.config;


import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;


/**
 * Created by shahbour on 16/06/17.
 */
@Configuration
@EnableOAuth2Sso
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    //This is needed on the gateway so OAuth2TokenRelayFilter do check the validation of token and refresh it.
    @Bean
    public OAuth2RestOperations oAuth2RestOperations(OAuth2ClientContext oauth2ClientContext, OAuth2ProtectedResourceDetails details) {
        OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(details, oauth2ClientContext);
        return oAuth2RestTemplate;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                //.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                //.and()
                //.exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint())
                //.and()
                .authorizeRequests()
                .anyRequest().authenticated();

    }

}
