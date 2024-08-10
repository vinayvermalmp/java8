package com.vin.wap;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Assignment2 {
    public static void main(String[] args) {
        String input = "Java articles are Awesome";
        System.out.println("find the first non-repeated character in it using");
        findFirstNonRepeatedCharacter(input);
        System.out.println("find the first repeated character in it using");
        findFirstRepeatedCharacter(input);
        System.out.println("Given an integer array contains duplicates");
        System.out.println("Input: nums = [1,2,3,1] " +containsDuplicate(new int[]{1,2,3,1}));
        System.out.println("Input: nums = [1,2,3,4] " +containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(" get current date and time");
        getCurrentDateAndTime();

        concatenateStream();



    }

    /*7. Given a String, find the first non-repeated character in it using Stream functions?*/
    public static void findFirstNonRepeatedCharacter(String input){
       // Set<Character> set = new HashSet<Character>();
         input.chars()
                 .mapToObj(i -> Character.toLowerCase((char) i))
                 .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                 .entrySet()
                 .stream()
                 .filter(entry -> entry.getValue() == 1L)
                 .map(entry -> entry.getKey())
                 .findFirst()
                 .ifPresent(System.out::println);
                 //.forEach(System.out::println);
    }

    /*8. Given a String, find the first repeated character in it using Stream functions?*/
    public static void findFirstRepeatedCharacter(String input){
        input.chars()
                .mapToObj(i -> Character.toLowerCase((char) i))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new , Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1L)
                .map(entry -> entry.getKey())
                .findFirst()
                .ifPresent(System.out::println);
    }
    /*11. Given an integer array nums, return true if any value appears at least twice in the array,
    and return false if every element is distinct.*/

    public static boolean containsDuplicate(int[] numbers){
        List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        Set<Integer> set = new HashSet<>(list);
        if (set.size() == list.size()) {
            return  false;
        } else {
            return true;
        }
    }

    /*12. How will you get the current date and time using Java 8 Date and Time API?*/

    public static void getCurrentDateAndTime(){
        System.out.println("Current date "+ LocalDate.now());
        System.out.println("Current time "+ LocalTime.now());
        System.out.println("Current date and time "+ LocalDateTime.now());
    }

//    13. Write a Java 8 program to concatenate two Streams?

    public static void concatenateStream(){
        List<String> list1 = Arrays.asList("Java", "8");
        List<String> list2 = Arrays.asList("explained", "through", "programs");
        Stream<String> concatStream = Stream.concat(list1.stream(), list2.stream());
        concatStream.forEach(s -> System.out.print(s + " "));

        List<Integer> list4 = Arrays.asList(2, 4, 8, 7, 1 );
        List<Integer> list5 = Arrays.asList(3, 6, 10, 5, 9);
        Stream.concat(list4.stream(), list5.stream()).sorted().toList().forEach(System.out::println);
    }
    /*17. How to convert a List of objects into a Map
    by considering duplicated keys and store them in sorted order?*/













}
