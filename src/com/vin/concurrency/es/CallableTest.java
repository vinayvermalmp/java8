package com.vin.concurrency.es;

import java.util.concurrent.*;

public class CallableTest {
    public static void main(String[] args) {
        // create an executer service with a fixed size thred pool consisting of one thred
        ExecutorService ex = Executors.newSingleThreadExecutor();

        // submit the callable task (asynchronously) to the executer service
        // and the store the future object
        Future<Integer> future = ex.submit(() -> 5 +3); // v call();

        try {
            // get() will block for 500 miliseconds
            // time unit is an enum
            System.out.println("the answer is: " +future.get(500, TimeUnit.MILLISECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }


        ex.shutdown();
    }
}
