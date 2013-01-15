package com.acme.doktorics.web;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.acme.doktorics.domain.User;

@Controller
public class AdminContoller extends AbstractController{


    @RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.POST)
    public String deleteUser(@PathVariable String id,Locale locale, Model model)
    {
        logger.info("Delete user");
        userService.delete(id);
        buildModel(model);
        return "redirect:/admin";
        
    }
    
    @RequestMapping(value = { "/register" }, method = RequestMethod.POST)
    public String register(@Valid User user,@ModelAttribute("role") String role, Model model)
    {
        logger.info("Register user");
        userService.addNewUser(user, role);
        buildModel(model);
        return "redirect:/admin";
        
    }
    
    @RequestMapping(value = { "/addrole/{id}/{name}" }, method = RequestMethod.POST)
    public String addrole(@PathVariable String id,@PathVariable String name, Model model)
    {
        logger.info("Register user");
        userService.addRole(Long.parseLong(id), name);
        buildModel(model);
        return "redirect:/admin";
        
    }
    
    @RequestMapping(value = { "/removerole/{id}/{name}" }, method = RequestMethod.POST)
    public String removerole(@PathVariable String id,@PathVariable String name, Model model)
    {
        logger.info("Register user");
        userService.removeRole(Long.parseLong(id), name);
        buildModel(model);
        return "redirect:/admin";
        
    }
    
 
    
    
}
