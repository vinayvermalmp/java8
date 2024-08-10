package com.vin.datastructure.wap;

import java.util.stream.IntStream;

public class Fibonacci {

    static int n1 = 0, n2 = 1, n3 = 0;
    public static void main(String[] args) {
        // print first n number of  fibonacci series ..
        int N = 5, sum = 0;
        for (int i = 0; i < N ; i++) {
            System.out.print(fib(i)+" ");
            sum += fib(i);
        }
        System.out.println("sum of first n fibonacci series "+ sum);
        IntStream.range(0, 5).map(Fibonacci::fib).forEach(i -> System.out.print(i + ","));
        System.out.println("--------------");
        printPattern(5);
        System.out.println("--------------");
        System.out.println(gcd(20, 28));
        System.out.println("--------------");
        System.out.println(factorial(5));
        System.out.println("--------------");
        printNoPattern(5);
        System.out.println("--------------");
        printNoPattern2(4);
        System.out.println("--------------");
        String str = "codingMinutes";
        long result = str.chars().mapToObj(code -> Character.toLowerCase(Character.valueOf((char) code)))
                .filter(c -> c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                .count();
        System.out.println(result);



    }

    private static void printNoPattern2(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i ; j++) {
                if (i == 1) {
                    System.out.print(i);
                }
                else if (i == 2) {
                    System.out.print(j+1);
                } else if(i == 3) {
                    System.out.print(j+i);
                } else {
                    System.out.print(j+i+2);
                }
            }
            System.out.println("");
        }
    }

    private static void printNoPattern(int n) {
        for (int i = 1; i <= 5 ; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println("");
        }
    }

    private static int factorial(int n) {
        if (n == 0){
            return 1;
        }
        return n*factorial(n-1);
    }

    private static int gcd(int a, int b) {
        int n;
        if (a> b) {
           n = b;
        } else {
            n =a;
        }
//         IntStream.iterate(n, i -> i > 0, i -> i-1).peek(i -> System.out.println("peak-- "+i))
//                .filter(i -> a % i == 0 && b % i == 0).peek(i -> System.out.println("filter-- "+i))
//                .forEach(i -> System.out.println("for ea-- "+i));
          return  IntStream.iterate(n, i -> i > 0, i -> i-1)
                  .filter(i -> a % i == 0 && b % i == 0)
                 .max().getAsInt();

    }


    private static void printPattern(int n) {
        for (int i = 1; i <= n; i++) {
             System.out.print("*");
            for (int j = 1; j <= n-i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    static int fib(int n) {
        // Base Case
        if (n <= 1)
            return n;
        // Recursive call
        return fib(n - 1) + fib(n - 2);
    }

//    private static void printNFibonacciNumber(int n) {
//        if (n > 0){
//            n3 = n1+n2;
//            n1 = n2;
//            n2 = n3;
//            System.out.println(n3);
//            printNFibonacciNumber(n-1);
//        }
//    }
}
