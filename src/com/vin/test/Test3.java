package com.vin.test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

interface NumberMultiply<T, U , R>{

    R multiply(T t, U u);

}

public class Test3 {


    /*String input = " p  ar  t  ";
        char[] characters = input.toCharArray();
        String result = "";
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == ' ') {
                continue;
            }
            result += characters[i];
        }
        System.out.println(result);*/

    public static void main(String[] args) {

        NumberMultiply<Integer, Integer, Integer> lambada = (a, b) -> a*b;

        System.out.println("result" + lambada.multiply(3, 4));

        List<Integer>  list = Arrays.asList(2, 2, 4, 2,7,5,8, 7);
        Map<Integer, Integer> dupOccStore = new HashMap<>();
        list.stream().collect(Collectors.toMap(Function.identity(), e -> 1, Integer::sum)).forEach(
                (k, v) -> System.out.println(k+" and occ +"+ v)
        );

        IntSummaryStatistics sum = IntStream.range(1, 10).filter(n -> n % 2 != 0).peek(n -> System.out.println(n)).summaryStatistics();
        System.out.println(sum.getSum());


        System.out.println(isPalindrome(1221));
        printFactors(10);
       // printSquareStar(10);
        inputThenPrintSumAndAverage();


    }
    public static void printFactors (int a){
        if ( a < 1) {
            System.out.println("Invalid Value");
            return;
        }
        int i =1;
        while(i <= a){
            if(a%i == 0){
                System.out.println(i);
            }
            ++i;
        }
    }
    public static boolean isPalindrome(int number){
        int reverse = 0;
        int temp = number;
        while(temp != 0){
            reverse = reverse*10 + temp % 10;
            temp /=10;
        }
        return number == reverse;
    }

//    public static void printSquareStar (int number){
//        if (number < 5){
//            System.out.println("Invalid Value");
//        }
//        for(int row = 1; row <= number ; row++ ) {
//            System.out.print("i*"+i);
//            for (int j = 0; j <= number-i ; j++ ) {
//                System.out.print("j*"+j);
//                System.out.print(" ");
//            }
//            System.out.println("");
//        }
//    }

    public static void inputThenPrintSumAndAverage (){
        Scanner scanner = new Scanner(System.in);
        int counter = 1;
        int value = Integer.parseInt(scanner.nextLine());
        System.out.println(value);

    }
}
