package com.acme.doktorics.web;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.acme.doktorics.domain.User;
import com.acme.doktorics.service.UserService;

@Controller
public class LoginController {

    @Resource(name = "sessionRegistry")
    private SessionRegistryImpl sessionRegistry;

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public User getUser() {
        return new User();
    }

    @RequestMapping("/denied")
    public String denied() {
        return "denied";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String create(@Valid User user, BindingResult errors, Model model, RedirectAttributes flash) {
        if (errors.hasErrors()) {
            return "/register/register";
        } 
            return "redirect:/register";

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model) {

        return "login";

    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(ModelMap model) {

        return "login";

    }
    
    
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
 
        return "login";
 
    }

    @RequestMapping("/error")
    public String error() {
        return "error";
    }
}
