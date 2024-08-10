package com.vin.test;

import java.util.Scanner;

public class TestAirtel {
    public static void main(String[] args) {


    }

    public static int sumOfTwoElementsOfArray(int[] arr , int index1, int index2){
        if (index1 > index2) {
            return 0;
        }
        int sum = 0;
        for (int i = index1; i <= index2 ; i++) {
                sum +=arr[i];
        }
        return sum;
    }
}
