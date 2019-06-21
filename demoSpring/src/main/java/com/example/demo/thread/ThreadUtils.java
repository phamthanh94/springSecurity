package com.example.demo.thread;

public class ThreadUtils implements Runnable {

    private Thread thread;
    private String threadName;


    ThreadUtils(String name){
        this.threadName = name;
    }

    @Override
    public void run() {
        try {
       for (int i= 0; i< 5;i++){
           System.out.println("Thread:" +threadName+ ":" + i);
           Thread.sleep(1000);
         }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        if (thread == null){
            thread = new Thread(this,threadName);
            thread.start();
        }
    }
}
