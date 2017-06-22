package com.shahbour.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * Created by shahbour on 16/06/17.
 */
@Configuration
@EnableOAuth2Sso
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {


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
