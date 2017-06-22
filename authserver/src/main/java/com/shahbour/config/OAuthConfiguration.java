package com.shahbour.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * Created by shahbour on 13/06/17.
 */
@Configuration
public class OAuthConfiguration extends AuthorizationServerConfigurerAdapter {

    private final AuthenticationManager authenticationManager;
    private final DataSource dataSource;
    private final UserMemoryRepositoryUserDetailsService userMemoryRepositoryUserDetailsService;

    @Autowired
    public OAuthConfiguration(AuthenticationManager authenticationManager, DataSource dataSource, UserMemoryRepositoryUserDetailsService userMemoryRepositoryUserDetailsService) {
        this.authenticationManager = authenticationManager;
        this.dataSource = dataSource;
        this.userMemoryRepositoryUserDetailsService = userMemoryRepositoryUserDetailsService;
    }

//    @Bean
//    public JwtAccessTokenConverter jwtAccessTokenConverter() {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        KeyPair keyPair = new KeyStoreKeyFactory(new ClassPathResource("keystore.jks"), "foobar".toCharArray()).getKeyPair("test");
//        converter.setKeyPair(keyPair);
//        return converter;
//    }

    @Bean
    public JdbcTokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }
    @Bean
    protected AuthorizationCodeServices authorizationCodeServices() {
        return new JdbcAuthorizationCodeServices(dataSource);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients.jdbc(dataSource);
//        clients.inMemory()
//                .withClient("acme")
//                .authorizedGrantTypes("authorization_code", "refresh_token", "password")
//                .scopes("openid")
//                .secret("acmesecret")
        //        .autoApprove(true)
        ;

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //final TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        //tokenEnhancerChain.setTokenEnhancers(Lists.newArrayList(new CustomTokenEnhancer() ));
        endpoints
                .userDetailsService(userMemoryRepositoryUserDetailsService)
                .authenticationManager(authenticationManager)
                .authorizationCodeServices(authorizationCodeServices())
                .tokenStore(tokenStore())
     //           .accessTokenConverter(jwtAccessTokenConverter()) // .tokenEnhancer(tokenEnhancerChain);//
                .approvalStoreDisabled();
    }
}

