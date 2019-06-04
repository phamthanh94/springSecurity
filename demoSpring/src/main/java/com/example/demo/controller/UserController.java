package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller(value = "/user")
public class UserController {

    @Autowired private UserService userService;

    @RequestMapping(value = "/getAllUsers")
    public String getAllUser(Model model){
        try {
            List<User> lst = userService.getAllUsers();
            model.addAttribute("listUsers", lst);
        }catch (Exception e){

        }
        return "/listUser";
    }
}
