package com.acme.doktorics.builder;

import com.acme.doktorics.domain.User;

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
    
    
    
    
    
//    public UserBuilder setBirthDate(Date date)
//    {
//        user.setBirthdate(date);
//        return this;
//    }
//    
//    public UserBuilder setUserRight(User.UserRight right)
//    {
//        user.getRights().add(right);
//        return this;
//    }
//    
//    public UserBuilder setLocation(String location)
//    {
//        user.setLocation(location);
//        return this;
//    }
//    
//    public UserBuilder setAge(Integer age)
//    {
//        user.setAge(age);
//        return this;
//    }
//    
//    public UserBuilder setName(String name)
//    {
//        user.setName(name);
//        return this;
//    }
    
    public UserBuilder setPassword(String password)
    {
        user.setPassword(password);
        return this;
    }
    
    
}
