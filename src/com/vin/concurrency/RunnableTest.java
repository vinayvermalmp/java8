package com.vin.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableTest {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newSingleThreadExecutor();
        // execute the runnable task (asynchronously) - void run();
        ex.execute(() -> System.out.println("Runnable Example"));
        ex.shutdown();
    }
}
