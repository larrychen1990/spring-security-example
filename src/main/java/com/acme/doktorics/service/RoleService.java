package com.acme.doktorics.service;

import java.util.List;

import com.acme.doktorics.domain.Role;

public interface RoleService {
    
    List<Role> findAll();

    void delete(String id);

    void save(Role role);
    
    Role findByName(String name);
    
    
    void update(Role role);
}
