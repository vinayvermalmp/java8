package com.vin.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStream {
    public static void main(String[] args) {
        //Creating a Stream from an Array
        // Arrays.stream() can be used to stream an array
        Double[] numbers = {1.1, 2.2, 3.3};
        Stream<Double> stream1 = Arrays.stream(numbers);
        System.out.println("Number of elements " +stream1.count());

        //Creating a Stream from a Collection
        //The default Collection interface method stream() is used.

        List<String> animelList = Arrays.asList("dog", "cat", "pig");
        Stream<String> animelsStream = animelList.stream();
        System.out.println("Number of elements " +animelsStream.count());

        Map<String , Integer> namesToAges = new HashMap<>();
        namesToAges.put("Mike", 22);
        namesToAges.put("Marry", 24);
        namesToAges.put("Alice", 31);
        System.out.println("Number of elements " +namesToAges.entrySet().stream().count());

        IntStream.range(1, 100).filter(n -> n <= 100 && n % 2 ==0).forEach(System.out::println);

        //Stream.of() is a static generically-typed utility method that
        //accepts a varargs parameter and returns an ordered stream of
        //those values.
        Stream<String> count = Stream.of("dog", "cat", "pig");

    }
}
