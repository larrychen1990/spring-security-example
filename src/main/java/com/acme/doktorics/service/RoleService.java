package com.acme.doktorics.service;

import java.util.List;

import com.acme.doktorics.domain.Role;

public interface RoleService {
    
    List<Role> findAll();

    void delete(String id);

    void save(Role role);
    
    Role findByName(String name);
    
    Role findMostSignificantRole();
    
    Role findMostWeakestRole();
    
    void update(Role role);

	List<Role> findAllRolebyID();
}
