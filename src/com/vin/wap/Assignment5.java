package com.vin.wap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Assignment5 {
    public static void main(String[] args) {
        // 12- Write a program to a Flattering list of objects.
        List<Integer> oddList = Arrays.asList(1, 3, 5, 7, 9, 11);
        List<Integer> evenList = Arrays.asList(2, 4, 6, 8, 10);
        List<List<Integer>> listOfList = Arrays.asList(oddList, evenList);
        System.out.println(listOfList);
        List<Integer> flatList = listOfList.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());
        flatList.forEach(x -> System.out.print(x+" "));

        // List<Integer> flatlist2 = Stream.concat(oddList.stream(), evenList.stream()).toList()
        System.out.println();
        printEvenNumberByJava8();
        System.out.println();
        printOddNumberByJava8();

        System.out.println();
        int a[] = { 3, 6, 32, 1, 8, 5, 31, 22 };

        System.out.println("sum oof array element"+ sumArray(a));


    }

    public static int sumArray(int[] arr){
        // 18-Write a program to sum an array without using the sum method.
        //Arrays.stream(arr).boxed().reduce(0, (a, b) -> a+b).intValue();
       return Arrays.stream(arr).boxed().collect(Collectors.summingInt(Integer::intValue));



       // Arrays.stream(arr).boxed().collect(Collectors.summarizingInt(Integer::intValue)).peek(System.out::println);;
    }

    // 14- Write a program to Print Even and Odd Numbers.
    private static void printEvenNumberByJava8() {
        IntStream.rangeClosed(0, 10).filter(x -> x % 2 == 0).forEach(x -> System.out.print(x+", "));
    }
    private static void printOddNumberByJava8() {
        IntStream.rangeClosed(0, 10).filter(x -> x % 2 != 0).forEach(x -> System.out.print(x+", "));
    }


}
