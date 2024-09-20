package com.vin.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
* All of the streams thus far have been sequential streams i.e.
the streams have processed the data one element at a time.
• Parallel streams can process elements in a stream
concurrently i.e. at the same time.
• Java achieves this by splitting the stream up into substreams and then the pipeline operations are performed on
the sub-streams concurrently (each sub-stream has its own
thread).
* */
public class ParallelStreams {
    public static void main(String[] args) {

        sequentialStream();
        System.out.println();
        parallelStream();
        System.out.println();
        sequentialAddition();
        System.out.println();
        parallelAddition();
    }

    public static void sequentialAddition() {
        /*
            Sequential stream
            10 20 30 40 50 60
               30 30 40 50 60
                  60 40 50 60
                    100 50 60
                       150 60
                          210
        */
        // Sequential stream
        int sum = Stream.of(10, 20, 30, 40, 50, 60)
                // IntStream has the sum() method so we use
                // the mapToInt() method to map from Stream<Integer>
                // to an IntStream (i.e. a stream of int primitives).
                // IntStream mapToInt(ToIntFunction)
                //    ToIntFunction is a functional interface:
                //       int applyAsInt​(T value)
                .mapToInt(n -> n.intValue())
                //  .mapToInt(Integer::intValue)
                //  .mapToInt(n -> n)
                .sum();
        System.out.println("Sum == "+sum); // 210
    }

    /*
    • To make a stream parallel, we can use the parallel() or
parallelStream() methods.
• parallel() is available in Stream<T>.
• parallelStream() is defined in the Collection<E> interface
    * */

    public static void parallelAddition() {

        Stream<String> animalsStream = List.of("sheep", "pigs", "horses")
                .parallelStream(); // parallelStream() is defined in the Collection<E> interface

//        Stream<String> animalsStream = Stream.of("sheep", "pigs", "horses")
//                                             .parallel(); // parallel() is available in Stream<T>.

        /*
            Parallel stream
            Thread 1        Thread 2
            10 20 30        40 50 60
               30 30           90 60
                  60             150
                       210
        */
        int sum = Stream.of(10, 20, 30, 40, 50, 60)
                .parallel() // Stream<T> method
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum == "+sum); // 210
    }
    // be carefull with parallel stream when order is important
    public static void sequentialStream() {
        Arrays.asList("a", "b", "c") // create List
                .stream()   // stream the List
                .forEach(System.out::print);// abc
    }
    public static void parallelStream() {
        Arrays.asList("a", "b", "c") // create List
                .stream()   // stream the List
                .parallel()
                .forEach(System.out::print);// bca
    }

}
