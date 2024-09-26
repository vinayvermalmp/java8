package com.vin.concurrency.es;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// various type Executeor service
public class VariousType {

    public static void main(String[] args) {

        // Cached thread pool executors
        ExecutorService es3 = Executors.newCachedThreadPool();

        // FixedThreadPool
        int cpuCount = Runtime.getRuntime().availableProcessors();
        ExecutorService es2 = Executors.newFixedThreadPool(cpuCount);
        System.out.println(cpuCount);

        // SingleThread Executoer
        ExecutorService es1 = Executors.newSingleThreadExecutor();
    }
}
