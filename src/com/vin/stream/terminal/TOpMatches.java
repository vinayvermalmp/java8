package com.vin.stream.terminal;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class TOpMatches {
    public static void main(String[] args) {
        doMatches();
    }

    public static void doMatches(){

        // boolean anyMatch(Predicate)
        // boolean allMatch(Predicate)
        // boolean noneMatch(Predicate)
        List<String> names = Arrays.asList("Alan", "Brian", "Colin");
        Predicate<String> pred = name -> name.startsWith("A");
        System.out.println(names.stream().anyMatch(pred)); // true (one does)
        System.out.println(names.stream().allMatch(pred)); // false (two don't)
        System.out.println(names.stream().noneMatch(pred));// false (one does)
    }
}
