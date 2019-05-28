package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User,Long> {


    public User findUserByUserName(String userName);


}
