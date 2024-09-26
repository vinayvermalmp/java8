package com.vin.concurrency.es;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SubmittingTaskCollections {
    // single threads executers will accept the task sequentilly in the order
    // they are submitted
    // private static ExecutorService es = Executors.newSingleThreadExecutor();

    // with 4 threads to share the work, there is no guarantee with leter
    // will appear first
     private static ExecutorService es = Executors.newFixedThreadPool(5);
    private static List<Callable<String>> callables = new ArrayList<>();
    public static void main(String[] args) {
        callables.add(() -> "A");  // adding Callable tasks
        callables.add(() -> "B");
        callables.add(() -> "C");
        callables.add(() -> "D");
        callables.add(() -> "F");
     // invokeAny();
        invokeAll();

    }
    public static  void invokeAny(){
        try {
            // submitting a collection of task
            // executes synchronously and return when all of the tasks has compleated
            // Note : Single thread executer will always execute the first task submitted
            String result = es.invokeAny(callables);
            // String result = es.invokeAny(callables, 500, TimeUnit.MILLISECONDS);
            System.out.println(result);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }finally {
            es.shutdown();
        }
        System.out.println("Always at the end");
    }

    public static  void invokeAll(){
        try {
            // submitting a collection of task
            // executes synchronously and return when one of the tasks has compleated
            // other task are cancelled
            // Note : Single thread executer will always execute the first task submitted
            List<Future<String>> list = es.invokeAll(callables);
            // String result = es.invokeAny(callables, 500, TimeUnit.MILLISECONDS);
            for (Future<String> future: list){
                System.out.println(future.get()); // A, B, C, D in order
            }
            // System.out.println(result);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }finally {
            es.shutdown();
        }
        System.out.println("Always at the end");
    }
}
