package com.vin.test;


import java.lang.reflect.Array;
import java.util.Arrays;

/*
Merge Two Sorted Arrays
Problem Statement
Implement the method int[] mergeArrays(int[] arr1, int[] arr2) that takes
two chronologically sorted arrays and returns a new sorted array
including all elements from the input arrays.
*
* */
public class Test23 {
    public static void main(String[] args) {
        int[] a = {1, 2, 6, 4};
        int[] b = {5, 11, 7, 8};
        mergeArray(a, b);
    }

    public static void mergeArray(int[] a, int[] b){
        //Arrays.stream(a)
        int lenA = a.length;
        int lenB = b.length;
        int[] c = new int[lenA+lenB];

        for (int i = 0; i < lenA; i++) {
            c[i] = a[i];
        }
        for (int i = 0; i < lenB; i++) {
            c[lenA+i] = b[i];
        }

        for (int i = 0; i < c.length; i++) {
            System.out.printf(c[i]+",");
        }
    }
}
