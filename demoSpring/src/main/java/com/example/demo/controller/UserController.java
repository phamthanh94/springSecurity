package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller public class UserController {

    @Autowired private UserService userService;

    @RequestMapping(value = "/signUp") public String signUp(@RequestParam(value = "username") String userName,
            @RequestParam(value = "password") String password, @RequestParam(value = "email") String email,
            @RequestParam(value = "role") String role) {
        try {
            userService.createUser(userName, password, email, role);
        } catch (Exception e) {
            return "signUpPage";
        }
        return "redirect:login";
    }

}
