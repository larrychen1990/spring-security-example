package com.acme.doktorics.web;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.acme.doktorics.domain.User;
import com.acme.doktorics.service.RoleService;
import com.acme.doktorics.service.UserService;

@Controller
public class LoginController {

    @Resource(name = "sessionRegistry")
    private SessionRegistryImpl sessionRegistry;

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @ModelAttribute("user")
    public User getUser() {
        return new User();
    }

    @RequestMapping("/denied")
    public String denied() {
        System.out.println("denied get");
        return "denied";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
        System.out.println("login get");
               return "login";

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(@Valid User user, ModelMap model) {
        System.out.println("login post");
        System.out.println(user);

        return "login";

    }

   

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        System.out.println("logout get");
        return "logout";

    }

    @RequestMapping("/error")
    public String error() {
        System.out.println("error get");
        return "error";
    }
}
