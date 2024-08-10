package com.vin.wap;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Assignment4 {
    public static void main(String[] args) {
        System.out.println(" Is Prime No : " + isPrime(7));
        System.out.println("Is Armstrong Number : " + isArmStrong(371));
        int[] a = { 1, 4, 5, 2, 12, 34, 2, 11 };
        findDuplicateNumberByJava1_8(a);
        System.out.println(" Is Palindrome No : " + isPalindrome(16461));
        printDuplicateString("this is a car for mohit to play a car for this");
        findFibonacciSeries();
        int[] arr = { 3, 6, 32, 1, 8, 5, 31, 22 };
        System.out.println("find the second-highest number " +findSecondHighehestNumber(arr));
        System.out.println("find the second-lowest number " +findSecondlowestNumber(arr));
        String input = "Java Stream API is very good concept";
        firstNonRepeatedCharacter(input);
    }

    //11- Write a program to print the First Not Repeated Char in string.
    public static void firstNonRepeatedCharacter(String value){
      char c =  value.chars().peek(System.out::println).mapToObj(x-> Character.toLowerCase((char) x))
              .peek(System.out::println)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(Map.Entry::getKey)
                .findFirst()
              .get();
        System.out.println(" First Not Repeated Char in string -> {"+  value+"} ->> "+ c);
    }

    //9-Write a program to find the second-lowest number in an array.
    public static int findSecondlowestNumber(int[] arr){
      return Arrays.stream(arr).boxed()
                .sorted()
                .skip(1)
                .findFirst()
                .get();
    }
    //9-Write a program to find the second-highest number in an array.
    public static int findSecondHighehestNumber(int[] arr){
        return Arrays.stream(arr).boxed()
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .findFirst()
                .get();
    }

    // 6// Write a program to print the Fibonacci Series.
    public  static void findFibonacciSeries(){
        Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0]+f[1]}).limit(10).map(f -> f[0])
                .forEach(System.out::print);
    }

    //5- Write a program to print duplicate strings.
    public static void printDuplicateString(String value){
        Arrays.stream(value.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1L)
                .map(entry -> entry.getKey())
                .toList().forEach(System.out::println);
    }



    //4-Write a program to find whether a string or number is palindrome or not.
    public static boolean isPalindrome(int n){
        //A Palindromic number is a number (such as 16461) that
        // remains the same when its digits are reversed.
        String value = String.valueOf(n);
        int len = value.length();
        boolean isPal = IntStream.range(0, len/2)
                .anyMatch(index -> value.charAt(index) == value.charAt(len-index-1));
        // str---
       // String str = "madam";
        // boolean isPal =  IntStream.rangeClosed(0, l/2).allMatch(index -> str.charAt(index) == str.charAt(len-index));
//        if (isPal){
//            System.out.println("Yes");
//        } else{
//            System.out.println("No");
//        }


        return isPal;
    }

    public static void findDuplicateNumberByJava1_8(int[] arr){
       Arrays.stream(arr).boxed()
              .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
              .entrySet()
              .stream()
              .filter(entry -> entry.getValue() > 1L)
              .map(entry -> entry.getValue())
              .collect(Collectors.toList()).forEach(System.out::println);

       // IntStream.rangeClosed()
        int[] a = { 1, 4, 5, 2, 12, 34, 2, 11 };
        int index = 2;
        int index2 = 4;

       int value = Arrays.stream(arr, index, index2+1).boxed().reduce(0, Integer::sum);
        System.out.println("summmmmmmmmmmmmmm ---"+value);
    }
    // 3- Write a program to print duplicate numbers.

    //2-Write a Java Program to check Armstrong numbers.
    public static boolean isArmStrong(int n){
        //Armstrong number is the number in any given number base,
        // which forms the total of the same number,
        //when each of its digits is raised to the power of
        // the number of digits in the number.
        int len = String.valueOf(n).length();
        int sum = String.valueOf(n).chars().map(ch -> Character.digit(ch, 10))
                .map(digit ->(int) Math.pow(digit, len)).sum();
        return  sum == n;
    }
    // 1- Write a Java Program to find whether a number is prime or not.
    public static boolean isPrime(int n){
        //Prime numbers are natural numbers
        // that are divisible by only 1 and the number itself
        if (n == 0 || n== 1 ){
            return false;
        }
        if (n == 2) {
            return true;
        }
        boolean isPrime = IntStream.range(2, n/2).noneMatch(x -> n%2 ==0);
        return isPrime;
    }


}
