package com.acme.doktorics.dao;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.acme.doktorics.domain.Role;
import com.acme.doktorics.domain.User;
import com.acme.doktorics.service.RoleService;
import com.acme.doktorics.service.UserService;

public class InitBean implements InitializingBean {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Override
    public void afterPropertiesSet() throws Exception {
        if (userService.findAll().size() == 0)
        {
            System.out.println("login init");
            init();
        }

    }

    private void init() {

        Role admin = new Role();
        admin.setName("ROLE_ADMIN");
        Role user = new Role();
        user.setName("ROLE_USER");

        roleService.save(admin);
        roleService.save(user);

        admin = roleService.findByName("ROLE_ADMIN");
        user = roleService.findByName("ROLE_USER");

        User Zoli = new User();
        Zoli.setEmail("dsfsdfsdf@dsfsdf.com");
        Zoli.setEnabled(true);
        Zoli.setPassword("Zoli");
        Zoli.setUsername("Zoli");

        User Adam = new User();
        Adam.setEmail("ddsfsdfsdfsdfsdfsdfsdf@dsfsdf.com");
        Adam.setEnabled(true);
        Adam.setPassword("Adam");
        Adam.setUsername("Adam");

        userService.save(Zoli);
        userService.save(Adam);

        user.addUser(Zoli);
        user.addUser(Adam);
        admin.addUser(Zoli);

        Zoli.addRole(user);
        Adam.addRole(user);
        Zoli.addRole(admin);

        roleService.update(admin);
        roleService.update(user);
        userService.update(Adam);
        userService.update(Zoli);

    }

}
