package com.acme.doktorics.service;

import java.util.List;

import com.acme.doktorics.domain.User;

public interface UserService{


	List<User> findAll();
	
	void delete(String id);

	void save(User messageObject);
}