package com.vin.stream.terminal;

import java.util.Optional;
import java.util.stream.Stream;

public class TOpMinMax {
    public static void main(String[] args) {
        doMinAndMax();
    }

    public static void doMinAndMax(){

        // Optional<T> min(Comparator)
        // Optional<T> max(Comparator)
        // Optional introduce in Java 8 to replace 'null'. If the stream is
        // empty then the Optional will be empty (and we won't have to
        // deal with null).
        Optional<String> min = Stream.of("deer", "horse", "pig")
                .min((s1, s2) -> s1.length()-s2.length());
        min.ifPresent(System.out::println);// pig

        Optional<Integer> max = Stream.of(4,6,2,12,9)
                .max((i1, i2) -> i1-i2);
        max.ifPresent(System.out::println);// 12

    }
}
