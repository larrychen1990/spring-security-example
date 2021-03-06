package com.acme.doktorics.web;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController extends AbstractController{

    
    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = { "/", "/home", "/welcome" }, method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);
        buildModel(model);
        return "welcome";
    }

    @RequestMapping(value = { "/admin" }, method = RequestMethod.GET)
    public String admin(Locale locale, Model model) {
        logger.info("Admin view", locale);
        buildModel(model);
        return "admin";
    }
}
