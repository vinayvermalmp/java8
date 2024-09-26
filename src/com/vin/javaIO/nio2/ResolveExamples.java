package com.vin.javaIO.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolveExamples {
    public static void main(String[] args) {
        // current directory
        System.out.println(System.getProperty("user.dir"));   // D:\workspace\java8
        Path absolute = Paths.get("D:\\workspace\\java8");
        Path relative = Path.of("nio2");
        Path file     = Path.of("name.txt");

        System.out.println("absolute.resolve(relative): "+
                absolute.resolve(relative)); //  D:\workspace\java8\nio2
        System.out.println("absolute.resolve(file): "+
                absolute.resolve(file)); // D:\workspace\java8\name.txt
        System.out.println("relative.resolve(file): "+
                relative.resolve(file)); // nio2\name.txt

        // trying to resolve an absolute path within anything just returns the absolute path
        System.out.println("relative.resolve(absolute): "+
                relative.resolve(absolute));// C:\Users\skennedy\Documents\NetbeansProjects\Udemy
        System.out.println("file.resolve(absolute): "+
                file.resolve(absolute));// C:\Users\skennedy\Documents\NetbeansProjects\Udemy
        System.out.println("absolute.resolve(absolute): "+
                absolute.resolve(absolute));// C:\Users\skennedy\Documents\NetbeansProjects\Udemy


        // interesting...
        Path p1  = Path.of("dir");
        Path p2  = Path.of("sk.txt");
        System.out.println("dir.resolve(sk.txt): "+
                p1.resolve(p2));// dir\sk.txt
        System.out.println("sk.txt.resolve(dir): "+     // sk.txt could be a directory (it is) and
                p2.resolve(p1));// sk.txt\dir           // dir could be a file (it is)
    }

}
