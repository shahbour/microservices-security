package com.shahbour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by shahbour on 6/14/17.
 */
@Controller
public class DefaultController {

    @RequestMapping(value = "/")
    public String defaultRedirect() {
        return "redirect:/ui/";
    }
}
