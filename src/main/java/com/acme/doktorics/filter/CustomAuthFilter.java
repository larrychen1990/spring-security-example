package com.acme.doktorics.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class CustomAuthFilter extends UsernamePasswordAuthenticationFilter {

    
    private final Logger logger = LoggerFactory.getLogger(CustomAuthFilter.class);
    
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        logger.info("login attempt from:" + request.getRemoteAddr());
        Authentication authentication = super.attemptAuthentication(request, response);
        return authentication;
    }
    
    
}
