package com.vin.test.OopsTest;

// Any field in interface is implicitly public static and final whether these keyword are specified or not
public interface TestInterface {
    public  int A =1;
    int b = 2;
    static int c = 2;
    final int d = 2;
    public  static  int e = 1;
    static  final  int f = 1;

    public  final  int g = 1;

    public  static final int h = 1;

    // default void compute(); // not valid
    default void compute(){} // valid
    // when you mark a method in interface as default, you are trying to provide a default implementation
    //of that method so that any class that implement this interface doesn't necessarily have to
    // provide its own implementation.
    // thus, a default method without a method body doesn't make any sense
    // default void compute(){};


    // note default keyword can occure for a method in interface but not in abstract class

    public void computeA(); // valid all interface method are public by default

    static void computeC(){
        System.out.println("computing...........");
    }
    // an interface can have static method but the method must have method body in that case
    // becoz a static method can not be abstract
    // so  static void computeC(); is not valid


   /* default static void computeD(){ // not valid as interface method cannot be default and static both same time
        // because default method is always instance method
        System.out.println("computing...........");
    }*/

}
