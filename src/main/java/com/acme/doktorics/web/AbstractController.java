package com.acme.doktorics.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.acme.doktorics.domain.User;
import com.acme.doktorics.service.RoleService;
import com.acme.doktorics.service.UserService;

public abstract class AbstractController {

	protected static final Logger logger = LoggerFactory
			.getLogger(AbstractController.class);

	@Resource(name = "sessionRegistry")
	protected SessionRegistryImpl sessionRegistry;

	@Autowired
	protected UserService userService;
	@Autowired
	protected RoleService roleService;

	@ModelAttribute("user")
	public User getUser() {
		return new User();
	}

	protected void buildModel(Model model) {
		model.addAttribute("actualUser", sessionRegistry.getAllPrincipals());
		model.addAttribute("users", userService.findAll());
	}

}
