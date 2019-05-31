package com.example.demo.config;

import com.example.demo.service.FacebookSignUpServiceImpl;
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
@ImportResource({"classpath*:/applicationContext.xml"})
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DefaultAuthenticationProvider defaultAuthenticationProvider;

    @Autowired
    private FacebookSignUpServiceImpl facebookSignUpService;

//    @Autowired
//    private UsersConnectionRepository usersConnectionRepository;
//
//    @Autowired
//    private ConnectionFactoryLocator connectionFactoryLocator;

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
       auth.authenticationProvider(this.defaultAuthenticationProvider);
    }


//    @Bean
//    public ProviderSignInController providerSignInController(){
//        ((InMemoryUsersConnectionRepository) usersConnectionRepository)
//                .setConnectionSignUp(facebookSignUpService);
//
//        return new ProviderSignInController(
//                this.connectionFactoryLocator,
//                this.usersConnectionRepository,
//                new FacebookSignInAdapter());
//    }

}
