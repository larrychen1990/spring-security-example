package com.acme.doktorics.init;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.acme.doktorics.builder.UserBuilder;
import com.acme.doktorics.domain.User;
import com.acme.doktorics.domain.UserRight;


public class UserServletContext implements ServletContextListener{

    
    ServletContext context;
    
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void contextInitialized(ServletContextEvent contextEvent) {
        // TODO Auto-generated method stub
        UserBuilder builder=new UserBuilder();
        @SuppressWarnings("deprecation")
        User Adam=builder.create().setName("Adam").setBirthDate(new Date(2001,11,11)).setLocation("Budapest").setPassword("Adam").setUserRight(UserRight.USER_ROLE).setAge(22).build();
        @SuppressWarnings("deprecation")
        User Zoli=builder.create().setName("Zoli").setBirthDate(new Date(2001,11,11)).setLocation("Budapest").setPassword("Zoli").setUserRight(UserRight.USER_ROLE).setAge(23).build();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        @SuppressWarnings("unchecked")
        List<User> result = manager.createQuery("from " + User.class.getName()).getResultList();
        tx.commit();
        if(result.size()==0)
        {
            tx.begin();
            manager.persist(Adam);
            manager.persist(Zoli);
            tx.commit();
        }
      
        
    }

}
