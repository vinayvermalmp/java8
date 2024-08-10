package com.vin.javaIO;

import java.io.*;

public class ReadingWritingExamples {
    public static void main(String[] args) {
        //copyTextFile(false);
       // copyTextFile(true);
       // copyBinaryFile(false);
        copyBinaryFile(true);
    }
    public static void copyTextFile(boolean buffering){
        File src = new File("D:\\workspace\\java8\\src\\com\\vin\\javaIO\\ReadingWritingExamples.java");
        File dest = new File("D:\\workspace\\java8\\src\\com\\vin\\javaIO\\ReadingWritingExamples2.java");
        try(var rdr = new BufferedReader(new FileReader(src));
            var wtr = new BufferedWriter(new FileWriter(dest)); ) {
            if (buffering){
                // using buffered reader and buffered writer api
                String str = null;
                // readline is used to specific to bufferreader
                while ((str = rdr.readLine()) != null){
                    wtr.write(str);
                    wtr.newLine(); // readline() strips out the end of line character
                }
            }
            else {
                // no buffering i.e read one byte at a time ; an int is used because
                // java uses -1 to signal the end of the stream
                int b;
                while ((b = rdr.read()) != -1){
                    wtr.write(b);
                }
            }
        } catch (IOException io){
            io.printStackTrace();
        }
    }

    public static void copyBinaryFile(boolean buffering){
        // 1. Using / instead of \
        // 2. Using relative path instead of absolute path
        System.out.println("Working Directory = " + System.getProperty("user.dir")); // C:\Users\skennedy\Documents\NetbeansProjects\Udemy
        File src = new File ("D:\\workspace\\java8\\out\\production\\java8\\com\\vin\\javaIO\\ReadingWritingExamples.class");
        File dest = new File ("D:\\workspace\\java8\\out\\production\\java8\\com\\vin\\javaIO\\ReadingWritingExamples2.class");

        // in-built close() with try-with-resourcse
        try(var in = new BufferedInputStream(new FileInputStream(src));
            var out = new BufferedOutputStream(new FileOutputStream(dest))){

            if(buffering){
                var buffer = new byte[1024];
                int numBytesRead=0;
                while((numBytesRead = in.read(buffer)) > 0 ){
                    // As the file is unlikely to be an exact multiple of 1024 bytes, 'numBytesRead' helps
                    // us to write out exactly the number of extra bytes above that multiple
                    // e.g. 2058 = 1024 + 1024 + 10
                    // write(byte[], int, int) is in FileOutputStream and BufferedOutputStream
                    out.write(buffer, 0, numBytesRead);
                    out.flush();
                }
            }else {
                // no buffering i.e. read one byte at a time; an int is used because
                // Java uses -1 to signal the end of the stream
                int b;
                while((b = in.read()) != -1){
                    out.write(b);
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
