package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Inject
    private CacheManager cacheManager;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createUser(String userName, String password, String email, String role) {
        userRepository.createUser(userName, password, email, role);
    }

    @Override
    public List<User> getAllUsers() {
        return  (List<User>) userRepository.findAll();
    }
}
