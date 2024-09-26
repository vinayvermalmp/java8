package com.vin.javaIO.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

// current directory: c
public class PathOperations {
    public static void main(String[] args) {
        // current directory
        System.out.println(System.getProperty("user.dir"));   // D:\workspace\java8
        
        //pathInfo(Paths.get("D:\\workspace\\java8\\src\\Main.java"));
        pathInfo(Path.of("abc\\def\\ghi\\jkl"));

    }

    private static void pathInfo(Path path) {
        System.out.println("toString: "+path);
        System.out.println("getNameCount: " + path.getNameCount()); // 4
        for (int i = 0; i < path.getNameCount(); i++) {
            System.out.println("getName("+i+"): " +path.getName(i) );

        }
        System.out.println("getFileName: " + path.getFileName()); // getFileName: Main.java
        System.out.println("getParent: " + path.getParent());  // getParent: D:\workspace\java8\src
        System.out.println("getRoot: " + path.getRoot());  //getRoot: D:\

        //        System.out.println("exception: " + Path.of("/").getName(0)); // java.lang.IllegalArgumentException

        System.out.println("subpath(0,3): "+path.subpath(0, 3));  // subpath(0,3): workspace\java8\src
        System.out.println("subpath(0,3): "+path.subpath(1, 3));  // subpath(0,3): java8\src
        System.out.println("subpath(0,3): "+path.subpath(2, 3));  // subpath(0,3): src

        System.out.println("isAbsolute: "+path.isAbsolute());  // true
    }

}
