package com.vin.stream.terminal;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Stream;

// foreach and count ....
public class TerminalOperations {
    public static void main(String[] args) {

        doForEach();
        System.out.println("------------");
        doCount();
    }



    public static void doForEach(){

        // void forEach(Consumer)
        // As there is no return value, forEach() is not a reduction.
        // As the return type is 'void', if you want something to
        // happen, it has to happen inside the Consumer (side-effect).
        Stream<String> names = Stream.of("Cathy", "Pauline", "Zoe");
        names.forEach(System.out::println);//CathyPaulineZoe

        // Notes: forEach is also a method in the Collection interface.
        //        Streams cannot be the source of a for-each loop
        //        because streams do not implement the Iterable interface.
        Stream<Integer> s = Stream.of(1);
        //       for(Integer i : s){}// error: required array or Iterable

    }



    public static void doCount(){

        long count = Stream.of("dog", "cat")
                .count();
        System.out.println(count); // 2

    }


}

/*
    public static void doMinAndMax(){

        // Optional<T> min(Comparator)
        // Optional<T> max(Comparator)
        // Optional introduce in Java 8 to replace 'null'. If the stream is
        // empty then the Optional will be empty (and we won't have to
        // deal with null).
        Optional<String> min = Stream.of("cow", "horse", "pig")
                                .min((s1, s2) -> s1.length()-s2.length());
        min.ifPresent(System.out::println);// cow

        Optional<Integer> max = Stream.of(4,6,2,9,9)
                                .max((i1, i2) -> i1-i2);
        max.ifPresent(System.out::println);//9

    }

*/
