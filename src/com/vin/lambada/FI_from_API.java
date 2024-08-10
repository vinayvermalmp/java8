package com.vin.lambada;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FI_from_API {
    public static void main(String[] args) {
        FI_from_API fiFromApi = new FI_from_API();
        fiFromApi.predicate();
        fiFromApi.supplier();
        fiFromApi.consumer();
        fiFromApi.function();
        fiFromApi.unaryBinaryOperator();
    }

    public void predicate(){ // when you waant to filter/match use predicate functional interface
        //
        Predicate<String> pStr = (s) -> s.contains("city");
        System.out.println(pStr.test("Lakhimpur city"));

        //
        BiPredicate<String, Integer> checkLength = (str, len) -> str.length() == len;
        System.out.println(checkLength.test("Lakhimpur city", 8)); // false (str lenth is 14)
    }

    public void supplier(){ // when you wnat to supply values without any input
        //
        Supplier<StringBuilder> supSB = () -> new StringBuilder();
        System.out.println("Supplierr SB: " +supSB.get().append("SK"));

        Supplier<LocalTime> supTime = () -> LocalTime.now();
        System.out.println("Supplier localTime : " + supTime.get());

        Supplier<Double> supRandom = () -> Math.random();
        System.out.println(supRandom.get());
    }

    public void consumer(){ // use the parameter but not interested in return value
        Consumer<String> printC = (s) -> System.out.println(s);
        printC.accept("to be or not to be, that is the question");

        List<String> names = new ArrayList<>();
        names.add("vinay"); names.add("Neha");
        names.forEach(printC);

        var mapCapitalStates = new HashMap<String, String>();
        BiConsumer<String, String> biCon = (key, value) -> mapCapitalStates.put(key, value);
        biCon.accept("Lucknow","UP");
        biCon.accept("Patna","Bihar");
        System.out.println(mapCapitalStates);

        BiConsumer<String, String> mapPrint = (key, value) -> System.out.println(key+ " is the capital of " + value);
        mapCapitalStates.forEach(mapPrint);

    }

    public  void function(){ // transform the input into an output(type can be different)
        Function<String, Integer> fun2 = s -> s.length();
        System.out.println(fun2.apply("vinay kumar"));// 11

        BiFunction<String, String, Integer> biFun= (s1, s2) -> s1.length() + s2.length();
        System.out.println(biFun.apply("vinay kumar", "Verma"));// 16

        BiFunction<String, String, String> biFun2= (s1, s2) -> s1.concat(s2);
        System.out.println(biFun2.apply("vinay kumar", "Verma"));// Vinay kumar verma

    }

    public void unaryBinaryOperator(){ // transform an input into an output (types are the same)

        // UnaryOperator<T> extends Function<T, T> is a functional interface
        UnaryOperator<String> unaryOp = name -> "My name is " + name;
        System.out.println(unaryOp.apply("Vinay"));

        // BinaryOperator<T> extends Function<T, T, T> is a functional interface
        BinaryOperator<String> biOp = (firstName, lastName) -> firstName.concat(lastName);
        System.out.println(biOp.apply("Vinay " , "Verma"));
    }

}
