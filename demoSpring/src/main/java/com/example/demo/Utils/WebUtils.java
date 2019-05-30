package com.example.demo.Utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class WebUtils {

    public static String encryte(String params) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(params);
    }

    public static void main(String[] args) {
        String password = "2";
        String encrytedPassword = encryte(password);
        System.out.println("Encryted Password: " + encrytedPassword);
    }

}
