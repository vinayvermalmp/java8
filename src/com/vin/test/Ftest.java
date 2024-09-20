package com.vin.test;

import java.util.Arrays;
import java.util.List;

public class Ftest {

    public static void main(String[] args) {
        String[] roots = {"cat","bat","rat"};
        String sentence = "the cattle was rattled by the battery";
        replaceStringByroots(roots, sentence);

        String[] roots1 = {"a","b","c"};
        String sentence1 = "aadsfasf absbs bbab cadsfafs";
        // replaceStringByrootChar(roots1, sentence1);

//        ------------------------------------------------
        
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        String[] wordsOfSentnce = sentence.split(" ");
        for (int i = 0; i < wordsOfSentnce.length ; i++) {
            for (int j = 0; j < dictionary.size(); j++) {
                if(dictionary.get(j).length() == 1){

                }
                if (wordsOfSentnce[i].length() >= 3) {
                    if (wordsOfSentnce[i].substring(0, 3).equals(dictionary.get(j))) {
                        wordsOfSentnce[i] = dictionary.get(j);
                    }
                }

            }
        }
        return String.join(" ", wordsOfSentnce);
    }

    public static void replaceStringByroots(String[] roots, String sentence){

        if (sentence.isEmpty() || sentence.isBlank()) {
            return;
        }

        String[] wordsOfSentnce = sentence.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < wordsOfSentnce.length ; i++) {
            for (int j = 0; j < roots.length; j++) {
                if (wordsOfSentnce[i].length() >= 3) {
                    if (wordsOfSentnce[i].substring(0, 3).equals(roots[j])) {
                        wordsOfSentnce[i] = roots[j];
                    }
                }

            }
            sb.append(wordsOfSentnce[i]).append(" ");
        }
        System.out.println(sb);
        String.join(" ", wordsOfSentnce);
    }


//    public static void replaceStringByrootChar(String[] roots, String sentence){
//        if (sentence.isEmpty() || sentence.isBlank()) {
//            return;
//        }
//
//        String[] words = sentence.split(" ");
//        Arrays.stream(words).forEach();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < words.length; i++) {
//            for (int j = 0; j < roots.length ; j++) {
//                if (words[i].substring(0, 1).equals(roots[j])) {
//                    words[i] = roots[j];
//                }
//            }
//            sb.append(words[i]).append(" ");
//        }
//        // System.out.println(sb);
//        System.out.println("\"" +sb +"\"");
//    }
}