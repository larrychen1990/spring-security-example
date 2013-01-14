package com.acme.doktorics.web;

import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.acme.doktorics.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Resource(name = "sessionRegistry")
    private SessionRegistryImpl sessionRegistry;

    @Autowired
    private UserService userService;

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = { "/", "/home", "/welcome" }, method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);
        model.addAttribute("users", sessionRegistry.getAllPrincipals());
        return "welcome";
    }

    @RequestMapping(value = { "/admin" }, method = RequestMethod.GET)
    public String admin(Locale locale, Model model) {
        logger.info("Admin view", locale);
        model.addAttribute("actualUser", sessionRegistry.getAllPrincipals());
        model.addAttribute("users", userService.findAll());
        return "admin";
    }
}
