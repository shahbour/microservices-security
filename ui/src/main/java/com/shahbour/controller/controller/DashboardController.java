package com.shahbour.controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by shahbour on 6/14/17.
 */
@Controller
public class DashboardController {

    @RequestMapping({"/","dashboard"})
    public String dashboard() {
//        OAuth2Authentication authentication = (OAuth2Authentication)SecurityContextHolder.getContext().getAuthentication();
//        OAuth2Request request =  authentication.getOAuth2Request();
//        OAuth2AuthenticationDetails authenticationDetails = (OAuth2AuthenticationDetails) authentication.getDetails();
//        Object object = authenticationDetails.getDecodedDetails();
        return "dashboard";
    }

}
