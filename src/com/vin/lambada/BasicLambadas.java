package com.vin.lambada;

@FunctionalInterface
interface I extends I2 {
    static void m() {
        System.out.println("i am a static method");
    }

    void m2();

    @Override
    default void mdf() {
       //  I2.super.mdf();
        System.out.println("this is default implementation of mdf() in I");
    }
}
interface I2  {

    static void m2st() {
        System.out.println("i am a static method");
    }
    void m2();

    default void mdf() {
        System.out.println("i am default method in I2");
    }
}
public class BasicLambadas {
    public static void main(String[] args) {
        // pre-java 8
        I i = new I() {

            public void m() {
                System.out.println("I::m()");
            }

            @Override
            public void m2() {
                System.out.println("I::m2()");
            }
        };
        i.m2();

        I lambada1 = () -> {
            System.out.println("lambada version ");

        };
        I lambada2  = () -> System.out.println("lambada version ");
        lambada1.m2();
        lambada2.m2();
        //lambada1.m2st();//

        lambada1.mdf();
        //lambada2.mdf();
    }
}
