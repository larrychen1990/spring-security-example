package com.acme.doktorics.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserServletContext implements ServletContextListener{

    
    ServletContext context;
    protected static final Logger logger = LoggerFactory.getLogger(UserServletContext.class);
    
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void contextInitialized(ServletContextEvent contextEvent) {
       
        logger.info("init servlet.....");
        
    }

    

}
