package com.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class DefaultAuthenticationProvider implements AuthenticationProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultAuthenticationProvider.class);

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken  auth = null;

        UserDetails userDetails = userDetailsService.loadUserByUsername(authentication.getName());
        if (userDetails.getPassword().equals(authentication.getCredentials().toString())){
            auth = new UsernamePasswordAuthenticationToken(
                    authentication.getPrincipal(),
                    authentication.getCredentials(),
                    userDetails.getAuthorities());
            LOGGER.info("User {} successfully authenticated",
                    userDetails.getUsername());
        } else {
            throw new BadCredentialsException(
                    "ERR002 Authentication Failed: Invalid username or password for user, "
                            + authentication.getPrincipal());
        }
        return auth;
    }

    @Override public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
