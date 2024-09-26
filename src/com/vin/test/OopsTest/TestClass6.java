package com.vin.test.OopsTest;

import java.io.FileNotFoundException;
import java.io.IOException;

class Great{
    public void doStuff() throws FileNotFoundException{
        System.out.println("Great");
    }
}
 class Amazing extends Great{
     @Override
     public void doStuff() throws FileNotFoundException, IllegalArgumentException {
         super.doStuff();
     }

     //    @Override
//    public void doStuff() throws IOException, IllegalArgumentException {  // not valid u can not throw extra checked exception in overriding method
//        System.out.println("amazing");
//    }
}
public class TestClass6 {
    public static void main(String[] args) throws FileNotFoundException {
        Great great = new Amazing();
        great.doStuff();
    }
}
