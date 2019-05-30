package com.example.demo.Utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class WebUtils {

    public static String encryte(String params) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(params);
    }



}
