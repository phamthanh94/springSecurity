package com.example.demo.controller;

import com.example.demo.dto.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller public class MainController {

    @RequestMapping(value = "/admin", method = RequestMethod.GET) public String adminPage(Model model,
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
