package com.acme.doktorics.web;

import javax.annotation.Resource;

import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    
    @Resource(name = "sessionRegistry")
    private SessionRegistryImpl sessionRegistry;


    @RequestMapping("/denied")
    public String denied() {
        return "denied";
    }

    @RequestMapping("/error")
    public String error() {
        return "error";
    }
}
