package com.acme.doktorics.service;

import java.util.List;

import com.acme.doktorics.domain.User;

public interface UserService{


	List<User> findAll();
	
	void delete(String id);

	void save(User messageObject);
	
	void addNewUser(User user,String role);
	
	void update(User user);
	
	void addRole(Long id,String roleName);
	
	void removeRole(Long id,String roleName);
}