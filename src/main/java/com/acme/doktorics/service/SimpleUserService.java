package com.acme.doktorics.service;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acme.doktorics.dao.UserDAO;
import com.acme.doktorics.domain.User;


@Service
@Transactional
public class SimpleUserService implements UserService {

    @Autowired
    private UserDAO userDao;
    protected static final Logger logger = LoggerFactory.getLogger(SimpleUserService.class);
   
  
    @Override
    public List<User> findAll()
    {
        List<User> users = userDao.findAll();
        if (users == null) {
            users = new ArrayList<User>();
        }
        return users;
    }

    @Override
    public void delete(String id) {
        User user=userDao.findOne(Long.parseLong(id));
        userDao.delete(user);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }
  

   

  
    
    
 

   

}