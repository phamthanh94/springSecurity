package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

//@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);
        div(Arrays.asList(1,2,3,4,6,10));
    }

    public static void div(List<Integer> listPoint){

        float mid = (float) listPoint.stream().mapToInt(i->i).sum()/2;
        System.out.println(mid);
        listPoint.stream().forEach(i -> {

        });
    }
}
