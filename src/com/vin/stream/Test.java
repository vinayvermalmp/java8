//package com.vin.stream;
//
//public class Test {
//
//    /*
//    Find the minimum distance between the given two words
//
//Given a list of words followed by two words, the task is to find the minimum distance between the given two words in the list of words.
//
//Examples:
//
//Input: S = { “the”, “quick”, “brown”, “fox”, “quick”}, word1 = “the”, word2 = “fox”
//Output: 3
//Explanation: Minimum distance between the words “the” and “fox” is 3
//
//Input: S = {“geeks”, “for”, “geeks”, “contribute”,  “practice”}, word1 = “geeks”, word2 = “practice”
//Output: 2
//Explanation: Minimum distance between the words “geeks” and “practice” is 2
//
//
//
//
//
//=============
//
//Count Distinct Subsequences
//
//Given a string, find the count of distinct subsequences of it.
//
//Examples:
//Input: str = “gfg”
//Output: 7
//Explanation: The seven distinct subsequences are “”, “g”, “f”, “gf”, “fg”, “gg” and “gfg”
//
//Input: str = “ggg”
//Output: 4
//Explanation: The four distinct subsequences are “”, “g”, “gg” and “ggg”
//
//
//====================================
//
//
//
//
//
//
//
//
//
//
//
//
//
//Check if a string can be obtained by rotating another string 2 places
//
//Given two strings, str1 and str2, the task is to determine if str2 can be obtained by rotating str1 exactly 2 places in either a clockwise or anticlockwise direction.
//
//Examples:
//Input: str1 = “amazon”, str2 = “azonam”
//Output: Yes
//Explanation: Rotating string1 by 2 places in anti-clockwise gives the string2.
//
//Input: str1 = “amazon”, str2 = “onamaz”
//Output: Yes
//Explanation: Rotating string1 by 2 places in clockwise gives the string2.
//
//
//
//
//    * */
//
//    public static void main(String[] args) {
//        String[] s = { "the", "quick", "brown", "fox", "quick"};
//
//
//        System.out.println("distance = " + findDistanceBW(s, "the", "fox"));
//
//        countSubSequences("gfg");
//    }
//
//    public static int findDistanceBW(String[] sArray, String word1, String word2){
//         int posOfW1 = 0;
//         int posOfW2 = 0;
//        for (int i = 0; i < sArray.length ; i++) {
//            if (sArray[i] == word1) {
//                posOfW1 = i;
//            }
//            if (sArray[i] == word2) {
//                posOfW2 = i;
//            }
//        }
//
//        return posOfW2-posOfW1;
//    }
//
//    public static void countSubSequences(String str){
//
//        char[] charArray = str.toCharArray();
//
//        int count = 0;
//
//        for (int i = 0; i < charArray.length; i++) {
//            for (int j = 0; j < charArray.length ; j++) {
//                str.substring(i, j);
//                System.out.printf(str.substring(i, j) + ",");
//            }
//        }
//
//    }
//
//    public static String rotateStrin(String str) {
//
//        int l = str.length();
//        int k = 2;
//        int rotation = l-k-1
//
//        for (int i = 0; i < l-k; i++) {
//
//        }
//
//    }
//}
