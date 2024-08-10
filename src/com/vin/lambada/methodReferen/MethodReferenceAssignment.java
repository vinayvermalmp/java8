package com.vin.lambada.methodReferen;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

public class MethodReferenceAssignment {
    public static void main(String[] args) {
        staticMR();
        boundMR();
        unboundMR();
        constructorMR();
    }
    private static void staticMR(){
         List<Integer> list = Arrays.asList(1, 2, 7,4,5);
        // List<Integer> list = List.of(1, 2, 7,4,5); // immutable collection not modifiable so you can not sort
        Consumer<List<Integer>> lambada = l -> Collections.sort(l);// define the lamabda
        System.out.println(list);
        lambada.accept(list);
        System.out.println(list);

        List<Integer> list1 = Arrays.asList(1, 2, 7,4,5);
        Consumer<List<Integer>> lambadaMR = Collections::sort;// define the lambda with method reference version
        System.out.println(list1);
        lambada.accept(list1);
        System.out.println(list1);
    }

    public static void boundMR(){
        String name = "Mr. Joe Bloggs";

        Predicate<String> titleL  = (prefix) -> name.startsWith(prefix);
        System.out.println(titleL.test("Mr.")); // true
        System.out.println(titleL.test("Ms."));// false

        Predicate<String> titleMR = name::startsWith;
        System.out.println(titleMR.test("Mr.")); // true
        System.out.println(titleMR.test("Ms."));// false


    }
    private static  void unboundMR(){
        Predicate<String> lambada = s-> s.isEmpty();
        System.out.println(lambada.test(""));
        System.out.println(lambada.test("xyz"));

        Predicate<String> lambadaMR = String::isEmpty;
        System.out.println(lambadaMR.test(""));
        System.out.println(lambadaMR.test("xyz"));

        BiPredicate<String, String> biPredicate = (s1, s2) -> s1.startsWith(s2);
        System.out.println(biPredicate.test("Mr. Joe Bloggs", "Mr."));
        System.out.println(biPredicate.test("Mr. Joe Bloggs", "Ms."));

        BiPredicate<String, String> biPredicateMR = String::startsWith;
        System.out.println(biPredicateMR.test("Mr. Joe Bloggs", "Mr."));
        System.out.println(biPredicateMR.test("Mr. Joe Bloggs", "Ms."));
    }

    private static  void constructorMR(){
        Supplier<List<String>> lambada = () -> new ArrayList<>();
        List<String> list = lambada.get();
        list.add("lambada");
        System.out.println(list);
        Supplier<List<String>> lambadaMR = ArrayList::new;
        List<String> listMr = lambadaMR.get();
        listMr.add("lambada");
        System.out.println(listMr);

        Function<Integer, List<String>> fnlambada = (n) -> new ArrayList<>(n);
        List<String> list2 = fnlambada.apply(10);
        list2.add("lambada");
        System.out.println(list2);

        Function<Integer, List<String>> fnlambadaMr = ArrayList::new;
        List<String> list3 = fnlambadaMr.apply(10);
        list3.add("lambada");
        System.out.println(list3);
    }
}
