package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;

@Service
public class FacebookSignUpServiceImpl implements ConnectionSignUp {

    @Autowired UserRepository userRepository;

    @Override
    public String execute(Connection<?> connection) {
        userRepository.createUser(connection.getDisplayName(),"1",null,"FACEBOOK_USER");
        return connection.getDisplayName();
    }
}
