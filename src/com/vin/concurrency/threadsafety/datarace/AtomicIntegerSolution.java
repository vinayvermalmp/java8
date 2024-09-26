package com.vin.concurrency.threadsafety.datarace;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;


// No duplicated numbers; guaranteed to get to 10.
// However, order is still not guaranteed.
public class AtomicIntegerSolution {
    private static AtomicInteger atomicCount = new AtomicInteger(0);

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 10; i++) {
            es.submit(() -> System.out.printf(atomicCount.incrementAndGet() +" "));
        }
        es.shutdown();
    }
} // 1 4 5 2 3 8 6 7 10 9  order is still not guaranteed
