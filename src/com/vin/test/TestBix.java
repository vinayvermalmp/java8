package com.vin.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class TestBix {

    public static void main(String[] args) {
        int input = 54326;
        int temp = input;
        int count = 0;
        while( input != 0){
            input /= 10;
            count++;
        }
        int[] arr = new int[count];
        while (temp != 0){
            int a = temp % 10;

            temp /=10;
        }
        // IntStream.range(0, count).
        System.out.println(count);
        ///Arrays.stream()
        //IntStream.iterate(0, count).

        str1();
        System.out.println(s());
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5,6,7, 8,9);
        IntStream.range(0, list.size()).forEach(i -> {
            StringBuilder sb = new StringBuilder();
            if (i >= (list.size()-4)) {
                sb.append(list.get(i));
            } else {
                sb.append("*");
            }
            System.out.print(sb);
        });
    }
    public static void str1(){
        String s1="apple";
        String s2="apple";
        String s3= new String("apple");

        System.out.println(s1==s3); // false
        System.out.println(s2==s1); // true
        System.out.println(s1.equals(s3)); // -- true
        System.out.println(s1.equals(s2)); // true
    }
    public static int s(){
        try{

            return 1;

        }
        finally{
            System.out.println("vinay");
            return 2;
            //System.exit(0);
        }

        // return  880;
    }

}
