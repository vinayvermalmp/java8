package com.vin.datastructure.wap;

import java.util.stream.IntStream;

public class CountDigitOfNumber {

    public static void main(String[] args) {
        System.out.println(countDigit(1234500));
        System.out.println(reverse(12304500));
    }

    private static int countDigit(int i) {
        int count=0;
        int temp = i;
        while (temp != 0){
            temp /=10;
            count++;
        }
        return  count;
    }
    private static int reverse(int i){
        int temp = i;
        int reverse = 0;
        while ( temp != 0){
            reverse = reverse*10 + temp%10;
            temp /=10;
        }

        // with java 8
//        int n = i;
//        int str = IntStream.iterate(n, a -> a>0, a->a/10)
//                .map(a -> a%10)
//                .reduce(0, (a, b) -> a*10 + b);
//        System.out.println("---"+str);


        return reverse;
    }

}
