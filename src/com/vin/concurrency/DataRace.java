package com.vin.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

// data race condition
public class DataRace {
    private static int count =0 ;

    public static void addToCounter(){
        int c = count;
        System.out.println("Before. "+count + ". Thread id: "+Thread.currentThread().getId());
        count = c + 1; // not atomic
        System.out.println("After. "+count + ". Thread id: "+Thread.currentThread().getId());
    }
    public static void main(String[] args) {
        for(int i=1; i<=10; i++){
            new Thread(() -> addToCounter())
                    .start();
        }
    }
}
// solution datarace condition
// No duplicated numbers; guaranteed to get to 10.
// However, order is still not guaranteed.
class AtomicIntegerExample {
    private static AtomicInteger atomicCount = new AtomicInteger(0) ;

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        for(int i=1; i<=10; i++){
            es.submit(() -> System.out.print(atomicCount.incrementAndGet() + " "));
        }
        es.shutdown();

    }
}
// 2 5 3 1 4 6 7 8 9 10

