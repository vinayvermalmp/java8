package com.vin.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[] {2, 7, 11, 15};
        findIndexOfTargetSum(arr, 9);
       // String[] str = "Vinay"
        List<String> listOsString = new ArrayList<>();

// Arrays.stream(strList)
        listOsString.stream().filter(s -> s.startsWith("al"));

    }
    public static int[] findIndexOfTargetSum(int[] arr, int targetSum){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length-1; i++){
            int value  = targetSum - arr[i];
            if (map.containsValue(value)) {
                return new int[]{map.get(value) , i};
            }
            map.put(arr[i], i);

        }
        return null;
    }
}
