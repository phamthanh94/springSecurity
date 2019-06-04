package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {

     void createUser(String userName, String password, String email, String role);

     List<User> getAllUsers();
}
