package com.vin.concurrency.concurrentCollection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TheProblem {
    public static void main(String[] args){
        Map<String, String> capitalCities = new HashMap<>();
       // Map<String, String> capitalCities = new ConcurrentHashMap<>(); // fix the issues
        capitalCities.put("Lucknow", "UP");
        capitalCities.put("Patna", "Bihar");

//        for (String key: capitalCities.keySet()){
//            System.out.println(key+ " is the capital of the "+capitalCities);
//            capitalCities.remove(key); // ConcurrentModificationException
//        }

        // another option is to use an iterator which has no such concurrent modification issues
        // this can also solve the problem
        System.out.println(" before "+capitalCities);
        for (var iter = capitalCities.keySet().iterator(); iter.hasNext(); ){
            var key = iter.next();
            System.out.println(key+ " is the capital of the "+capitalCities);
            iter.remove();
        }
        System.out.println(" after "+capitalCities);

    }
}
