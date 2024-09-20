package com.vin.wap;

import java.util.*;
import java.util.stream.Collectors;

/*Given a list of integers, that exist in the list using Stream functions?*/
public class Assignment1 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,15,8,49,25,98,32, 15, 10, 8);
       // System.out.println("find out all the even numbers ");
        //getEvenNumber(list).forEach(System.out::println);

        //System.out.println("numbers starting with 1");
        // getNumberStartingWith1(list).forEach(System.out::println);

        //System.out.println("find duplicate elements in a given integers list");
        //findDuplicateElements(list).forEach(System.out::println);

        //System.out.println("find the first element of the list");
        //findFirstElement(list).ifPresent(System.out::println);

//        System.out.println("find the total number of elements present in list");
//        System.out.println(findTotalElements(list));
//        System.out.println("find the min, max, number present in list");
//        findMaxElement(list).ifPresent(System.out::println);
        System.out.println("sort number present in list");
        sortElement(list);
        getCubeOfElement(list);
        sortArrayThenConvertTOSTream();


        // 21. Write a Program to find the Maximum element in an array?
        System.out.println("maxmium " + findMaxInt(new int[]{2, 3, 4, 6,7}));

    }

    public static int findMaxInt(int[] arr){
        return Arrays.stream(arr).max().getAsInt();
    }

    public static List<Integer> getEvenNumber(List<Integer> numbers){
        return  numbers.stream().filter(i -> i%2 == 0).collect(Collectors.toList());
    }

    /*2. Given a list of integers, find out all the numbers starting with 1 using Stream functions?*/
    public static List<String> getNumberStartingWith1(List<Integer> numbers){
        //return  numbers.stream().filter(i -> i.toString().startsWith("1")).collect(Collectors.toList());
        // this will return List<Integer>
        return numbers.stream().map(s -> s +"").filter(s-> s.startsWith("1")).collect(Collectors.toList());
    }

    /*3. How to find duplicate elements in a given integers list in java using Stream functions?*/
    public static Set<Integer> findDuplicateElements(List<Integer> numbers){
        Set<Integer> set = new HashSet<>();
        return numbers.stream().filter(n->!set.add(n)).collect(Collectors.toSet());
    }

    /*4. Given the list of integers, find the first element of the list using Stream functions?*/
    public static Optional<Integer> findFirstElement(List<Integer> numbers){
        return numbers.stream().findFirst();
    }
    public static long findTotalElements(List<Integer> numbers){
        return numbers.stream().count();
    }

    /*6. Given a list of integers, find the maximum value element present in it using Stream functions?*/
    public static Optional<Integer> findMaxElement(List<Integer> numbers){
        return numbers.stream().max(Integer::compare);
        //return numbers.stream().min(Integer::compare);
    }
    /*9. Given a list of integers, sort all the values present in it using Stream functions?*/
    public static void sortElement(List<Integer> numbers){
         numbers.stream().sorted().forEach(n ->System.out.print(n + " "));
        System.out.println("Print in reverse order");
        numbers.stream().sorted(Collections.reverseOrder()).forEach(n ->System.out.print(n + " "));
    }

    //    14. Java 8 program to perform cube on list elements and filter numbers greater than 50.
    public static void getCubeOfElement(List<Integer> numbers){
        System.out.println("Print in reverse order");
        numbers.stream().map(i -> i*i*i).filter(i -> i > 50).forEach(n ->System.out.print(n + " "));
    }

    //15. Write a Java 8 program to sort an array and then convert the sorted array into Stream?
    public static void sortArrayThenConvertTOSTream(){
        System.out.println("sortArrayThenConvertTOSTream");
        int arr[] = { 99, 55, 203, 99, 4, 91 };
        Arrays.parallelSort(arr);
        Arrays.stream(arr).forEach(n ->System.out.print(n + " "));
    }

}
