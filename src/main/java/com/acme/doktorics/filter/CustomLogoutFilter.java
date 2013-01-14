package com.acme.doktorics.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

public class CustomLogoutFilter  extends SimpleUrlLogoutSuccessHandler {

    
    
    private final Logger logger = LoggerFactory.getLogger(CustomLogoutFilter.class);
    
    
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
        throws IOException, ServletException {
        // TODO Auto-generated method stub
        logger.info("logout successhandler: "+request.getRemoteAddr());
        super.onLogoutSuccess(request, response, authentication);
    }

}
