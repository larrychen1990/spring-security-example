package com.acme.doktorics.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acme.doktorics.dao.UserDAO;
import com.acme.doktorics.domain.Role;
import com.acme.doktorics.domain.User;

@Service
@Transactional
public class SimpleUserService implements UserService {

	@Autowired
	private UserDAO userDao;
	@Autowired
	private RoleService roleService;
	protected static final Logger logger = LoggerFactory
			.getLogger(SimpleUserService.class);


	@Override
	public List<User> findAll() {
		List<User> users = userDao.findAll();
		if (users == null) {
			users = new ArrayList<User>();
		}
		return users;
	}

	@Override
	public void delete(String id) {
		User user = userDao.findOne(Long.parseLong(id));
		userDao.delete(user);
	}

	@Override
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	public void addNewUser(User user, String role) {
		Role adminRole = roleService.findByName("ROLE_ADMIN");
		Role userRole = roleService.findByName("ROLE_USER");
		if (role.equals("ROLE_ADMIN")) {
			user.addRole(adminRole);
		}
		user.addRole(userRole);
		save(user);

	}

	@Override
	public void update(User user) {
		userDao.update(user);

	}

	@Override
	public void addRole(Long id, String roleName) {
		User user = userDao.findOne(id);
		Role role = roleService.findByName(roleName);
		if (!user.getRoles().contains(role)) {
			role.addUser(user);
			user.addRole(role);
			roleService.update(role);
			update(user);
		} else {
			logger.info("This user contain the " + role.getName() + " role...");
		}

	}

	@Override
	public void removeRole(Long id, String roleName) {
		User user = userDao.findOne(id);
		Role role = roleService.findByName(roleName);
		Role weak = roleService.findMostWeakestRole();
		if (roleName.equals(weak.getName())) {
			user.setRoles(new ArrayList<Role>());
			user.addRole(weak);
			if (!weak.getUsers().contains(user)) {
				weak.addUser(user);
			}
			roleService.update(weak);
			update(user);
		} else {
			role.removeUser(user);
			user.removeRole(role);
			roleService.update(role);
			update(user);
		}

		logger.info("This user " + user.getUsername() + " removed role as the "
				+ role.getName() + " role...");

	}

}