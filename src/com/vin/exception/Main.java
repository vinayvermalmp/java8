package com.vin.exception;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filename = "testing.csv";
        testFile(filename);
       // Path path = Paths.get(filename);
//        try {
//            List<String> lines = Files.readAllLines(path);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("file not exist here ");
            return;
        }
        System.out.println("I'am good to go");
    }

    private static void testFile(String filename){
        Path path = Paths.get(filename);
        try {
            List<String> lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("i would log somthing either way");
        }
    }
}
