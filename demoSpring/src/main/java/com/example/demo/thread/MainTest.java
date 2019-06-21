package com.example.demo.thread;

public class MainTest {

    public static void main(String[] args) {
        ThreadUtils thread1 = new ThreadUtils("Thread1");
        thread1.start();
        ThreadUtils thread2 = new ThreadUtils("Thread2");
        thread2.start();
    }
}
