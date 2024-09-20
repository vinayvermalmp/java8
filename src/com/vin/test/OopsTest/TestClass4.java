package com.vin.test.OopsTest;

class Aa{
    int i = 10;
    public static void m1(){};
    public void m2(){}
}

class Bb extends Aa{
    int i = 20;
    public static void m1(){};
    public void m2(){}
}

public class TestClass4 {

    public static void main(String[] args) {
        Aa a = new Bb();
        System.out.println(a.i); //10
        a.m1(); // will call a's m1()
        a.m2(); // will call b's m2()
    }
}
