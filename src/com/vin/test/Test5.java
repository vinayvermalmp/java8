package com.vin.test;

interface Operation<T, U, R>{
    R operate(T t, U u);
}

public class Test5 {
    public static void main(String[] args) {

        Operation<Integer, Integer, Integer> lambadaAddition = (a, b) -> a+b;
        Operation<Integer, Integer, Integer> lambadaMultiplication = (a, b) -> a*b;
        Operation<Integer, Integer, Double> lambadaDivision = (a, b) -> (double) a / b;

        System.out.println("Addition -> " +lambadaAddition.operate(2,5));
        System.out.println("Multiplication -> " +lambadaMultiplication.operate(2,5));
        System.out.println("Division -> " +lambadaDivision.operate(6,3));
        Operation<Integer, Integer, Integer> lamMin  = (a, b) ->  {
            if (a > b){
                return b;
            }
            return a;
        };
        System.out.println(lamMin.operate(2, 5)+ " min");

    }




}
