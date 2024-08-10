package com.vin.concurrency;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("run() : " +Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        new Thread(new MyRunnable()).start();
        System.out.println("main() : " +Thread.currentThread().getName());

        // lambada version of creating threads
        // Thread t = new Thread(() -> System.out.println("run() : " +Thread.currentThread().getName()));
        // t.start();
        // t.run();
        //System.out.println("main() : " +Thread.currentThread().getName());
    }
}
