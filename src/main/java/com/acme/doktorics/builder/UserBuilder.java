package com.acme.doktorics.builder;

import java.util.Date;

import com.acme.doktorics.domain.User;
import com.acme.doktorics.domain.UserRight;

public class UserBuilder {
    private User user;
  
    
    public User build()
    {
        return this.user;
    }
    
    public UserBuilder create()
    {
        this.user=new User();
     
        return this;
    }
    
    public UserBuilder setBirthDate(Date date)
    {
        user.setBirthdate(date);
        return this;
    }
    
    public UserBuilder setUserRight(UserRight right)
    {
        user.setUserRight(right);
        return this;
    }
    
    public UserBuilder setLocation(String location)
    {
        user.setLocation(location);
        return this;
    }
    
    public UserBuilder setAge(Integer age)
    {
        user.setAge(age);
        return this;
    }
    
    public UserBuilder setName(String name)
    {
        user.setName(name);
        return this;
    }
    
    
}
