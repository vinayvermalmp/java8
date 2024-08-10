package com.vin.lambada;

import java.util.function.Predicate;

// my own custom functional interface
interface Evaluate<T>{
    boolean isNegative(T t); // similar to predicate
}

public class TestPredicate {
    public static void main(String[] args) {
        // Evaluate<Integer> lambada1 = i -> i < 0;
        Evaluate<Integer> lambada = i -> { return i < 0;};

        System.out.println("Evalute : -1 " + lambada.isNegative(-1));
        System.out.println("Evalute : +1 " + lambada.isNegative(1));

        Predicate<Integer> predicate = i -> i < 0;
        System.out.println("predicate : -1 " + lambada.isNegative(-1));
        System.out.println("predicate : +1 " + lambada.isNegative(1));

        int x = 4;
        System.out.println("Is "+x+" even? " + check(x, n -> n%2 == 0)); // true
        x = 7;
        System.out.println("Is "+x+" even? " + check(x, n -> n%2 == 0)); // false

        String name = "Mr. Vinay kumar ";
        System.out.println("Does "+name+" start with Mr.? " + check(name, s -> s.startsWith("Mr."))); // true
        name = "Ms. Vinay kumar ";
        System.out.println("Does "+name+" start with Mr.? " + check(name, s -> s.startsWith("Mr."))); // true
    }

    public static <T> boolean check(T t, Predicate<T> lambada){
        return lambada.test(t);
    }
}
