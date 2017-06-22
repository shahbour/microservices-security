package com.shahbour.controller;

import com.shahbour.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by shahbour on 6/14/17.
 */
@Controller
@Slf4j
public class DashboardController {

    @RequestMapping(value = {"/","dashboard"},method = RequestMethod.GET)
    public String dashboard(@AuthenticationPrincipal User user) {
       // log.info("Testing {}",userDetails.getAuthorities());
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = (User) auth.getPrincipal();
        log.info("{}",user.getFullName());
//        OAuth2Authentication authentication = (OAuth2Authentication)SecurityContextHolder.getContext().getAuthentication();
//        OAuth2Request request =  authentication.getOAuth2Request();
//        OAuth2AuthenticationDetails authenticationDetails = (OAuth2AuthenticationDetails) authentication.getDetails();
//        Object object = authenticationDetails.getDecodedDetails();
        return "dashboard";
    }

    @RequestMapping(value = {"/","dashboard"},method = RequestMethod.POST)
    public String dashboardPost() {
//        OAuth2Authentication authentication = (OAuth2Authentication)SecurityContextHolder.getContext().getAuthentication();
//        OAuth2Request request =  authentication.getOAuth2Request();
//        OAuth2AuthenticationDetails authenticationDetails = (OAuth2AuthenticationDetails) authentication.getDetails();
//        Object object = authenticationDetails.getDecodedDetails();
        return "dashboard";
    }

}
