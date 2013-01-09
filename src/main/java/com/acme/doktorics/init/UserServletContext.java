package com.acme.doktorics.init;

import java.util.Date;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.metamodel.Metamodel;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.acme.doktorics.builder.UserBuilder;
import com.acme.doktorics.dao.SimpleUserDAO;
import com.acme.doktorics.dao.UserDAO;
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
        User Adam=builder.create().setName("Adam").setBirthDate(new Date(2001,11,11)).setLocation("Budapest").setUserRight(UserRight.USER).setAge(22).build();
        User Zoli=builder.create().setName("Zoli").setBirthDate(new Date(2001,11,11)).setLocation("Budapest").setUserRight(UserRight.USER).setAge(23).build();
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
       
        manager.persist(Adam);
        manager.persist(Zoli);
        
        tx.commit();
    }

}
