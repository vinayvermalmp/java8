package com.vin.test.OopsTest;

//reference type determine the data accessed (static or non static)

class ABCD{
    int x = 10;
    static int y = 20;
}

class MNOP extends ABCD{
    int x = 30;
    static int y = 40;
}
public class TestClass2 {
    public static void main(String[] args) {
        // access to static and instance fields and static methods depends on the class of reference variable
        // not the actual object to which variable points to.

        // but in case of instance methods the method of the actual class of the object is called
        System.out.println(new MNOP().x+ " , "+ new MNOP().y); // 30 , 40
        ABCD abcd= new MNOP();

        System.out.println(abcd.x +" , "+ abcd.y); // 10 , 20

        MNOP mnop = (MNOP) abcd;
        System.out.println(mnop.x +" , "+ mnop.y); // 30 , 40
    }
}
