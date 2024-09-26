package com.vin.collection.sorting;

import java.util.*;

public class SortingCatsMultipleFields {
    public static void main(String[] args) {
        Comparator<Cat> comparator = Comparator.comparing(Cat::getName)
                .thenComparingInt(Cat::getAge);
        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat("Bella", 12));
        catList.add(new Cat("trella", 10));
        catList.add(new Cat("Bella", 17));
        catList.forEach(System.out::println);
        Collections.sort(catList, comparator);
        catList.forEach(System.out::println);
    }
}
