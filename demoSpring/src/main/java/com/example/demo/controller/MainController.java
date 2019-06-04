package com.example.demo.controller;

import com.example.demo.dto.Message;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller(value = "/main")
public class MainController {

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

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model,
            Principal principal) {
        return "adminPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET) public String loginPage(Model model) {
        return "loginPage";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "page/index";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET) public String accessDenied(Model model,
            Principal principal) {

        if (principal != null) {
            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }

        return "403Page";
    }

    @RequestMapping(value = "/signUpPage", method = RequestMethod.GET) public String signPage(Model model) {
        return "signUpPage";
    }

    @MessageMapping(value = "/chat")
    @SendTo("topic/messages")
    public Message send(@Payload Message message) {
        return message;
    }
}
