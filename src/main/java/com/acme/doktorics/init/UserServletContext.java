package com.acme.doktorics.init;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.acme.doktorics.domain.Role;
import com.acme.doktorics.domain.User;


public class UserServletContext implements ServletContextListener{

    
    ServletContext context;
    
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void contextInitialized(ServletContextEvent contextEvent) {
       
        Role admin=new Role();
        admin.setName("ROLE_ADMIN");
        Role user=new Role();
        user.setName("ROLE_USER");
       
        
        User Zoli=new User();
        Zoli.setEmail("dsfsdfsdf@dsfsdf.com");
        Zoli.setEnabled(true);
        Zoli.setPassword("Zoli");
        Zoli.setUsername("Zoli");
        Zoli.addRole(admin);
        Zoli.addRole(user);
        admin.addUser(Zoli);
        user.addUser(Zoli);
        
        User Adam=new User();
        Adam.setEmail("ddsfsdfsdfsdfsdfsdfsdf@dsfsdf.com");
        Adam.setEnabled(true);
        Adam.setPassword("Adam");
        Adam.setUsername("Adam");
        Adam.addRole(user);
        user.addUser(Adam);
        
        
        
        
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
            manager.persist(user);
            manager.persist(admin);
            manager.persist(Adam);
            manager.persist(Zoli);
            tx.commit();
        }
      
        
    }

}
