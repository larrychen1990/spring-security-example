package com.acme.doktorics.dao;

import org.springframework.stereotype.Repository;

import com.acme.doktorics.domain.Role;

@Repository
public class SimpleRoleDAO extends AbstractJpaDAO<Role> implements RoleDAO{

    public SimpleRoleDAO()
    {
        setClazz(Role.class);
    }

  

    
}
