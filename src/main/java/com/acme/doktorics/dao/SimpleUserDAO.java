package com.acme.doktorics.dao;

import org.springframework.stereotype.Repository;

import com.acme.doktorics.domain.User;

@Repository
public class SimpleUserDAO extends AbstractJpaDAO<User> implements UserDAO{
		
	public SimpleUserDAO()
	{
		setClazz(User.class);
	}

	

}
