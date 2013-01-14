package com.acme.doktorics.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acme.doktorics.dao.RoleDAO;
import com.acme.doktorics.domain.Role;

@Service
@Transactional
public class SimpleRoleService implements RoleService {

    @Autowired
    private RoleDAO roleDao;
    protected static final Logger logger = LoggerFactory.getLogger(SimpleRoleService.class);

    @Override
    public List<Role> findAll() {
        List<Role> roles = roleDao.findAll();
        if (roles == null) {
            roles = new ArrayList<Role>();
        }
        return roles;
    }

    @Override
    public void delete(String id) {
        Role role = roleDao.findOne(Long.parseLong(id));
        roleDao.delete(role);

    }

    @Override
    public void save(Role role) {
        roleDao.save(role);

    }

    @Override
    public Role findByName(String name) {
        Role role = roleDao.findElementByName("name", name);
        return role;
    }

}
