package com.vin.stream.terminal;

import java.util.Optional;
import java.util.stream.Stream;

public class TOpFindAnyFindFirst {
    public static void main(String[] args) {
        doFindAnyFindFirst();
    }

    public static void doFindAnyFindFirst(){

        // Optional<T> findAny()
        // Optional<T> findFirst()
        // These are terminal operations but not reductions
        // as they sometimes return without processing all
        // the elements in the stream. Reductions reduce the
        // entire stream into one value.
        Optional<String> any = Stream.of("John", "Paul")
                .findAny();
        any.ifPresent(System.out::println);// John (usually)

        Optional<String> first = Stream.of("John", "Paul")
                .findFirst();
        first.ifPresent(System.out::println);// John

    }
}
