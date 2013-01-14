package com.acme.doktorics.web;

import java.util.Locale;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.acme.doktorics.domain.User;
import com.acme.doktorics.service.UserService;

@Controller
public class AdminContoller extends AbstractController{


    @RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.POST)
    public String deleteUser(@PathVariable String id,Locale locale, Model model)
    {
        logger.info("Delete user");
        userService.delete(id);
        buildModel(model);
        return "admin";
        
    }
    
    @RequestMapping(value = { "/register" }, method = RequestMethod.POST)
    public String register(@Valid User user,@ModelAttribute("role") String role, Model model)
    {
        logger.info("Register user");
        userService.addNewUser(user, role);
        buildModel(model);
        return "admin";
        
    }
    
 
    
    
}
