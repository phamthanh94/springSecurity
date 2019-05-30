package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ComponentScan
@ImportResource({"classpath*:/security/spring_security.xml"})
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DefaultAuthenticationProvider defaultAuthenticationProvider;

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
       auth.authenticationProvider(this.defaultAuthenticationProvider);
    }

}
