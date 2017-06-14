package com.shahbour.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * Created by shahbour on 6/14/17.
 */
@Configuration
public class WebMvcConfigurationAdapter extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {

//        http
//                .logout()
//                .clearAuthentication(true)
//                .and()
//                .authorizeRequests()
//                .antMatchers("/login","/uaa/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .csrf()
//                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());

//        http.antMatcher("/**")
//                .authorizeRequests()
//                .antMatchers("/index.html", "/login", "/", "/api/catalog/**",
//                        "/user", "/assets/**").permitAll()
//                .anyRequest().authenticated().and().csrf().disable();
    }

}
