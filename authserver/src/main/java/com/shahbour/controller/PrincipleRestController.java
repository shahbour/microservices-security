package com.shahbour.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by shahbour on 13/06/17.
 */
@RestController
public class PrincipleRestController {
    @RequestMapping(method = RequestMethod.GET, value = "/user")
    Principal principal(Principal principal) {
        return principal;
    }
}
