package com.example.demo.dao;

import com.example.demo.entity.User;

public interface UserRepositoryCustom {

     User findUserByUserName(String userName);

     int createUser(String username, String password, String email, String role);
}
