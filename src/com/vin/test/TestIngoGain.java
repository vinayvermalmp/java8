package com.vin.test;

class Base {
    public final void doSomething(Object o) {
        System.out.println("Object");
    }
}
class Derived extends Base {

    public void doSomething(Integer i) {
        System.out.println("Int");
    }
}
public class TestIngoGain {
    public static void main(String[] args) {
        Base b = new Base();
        Base d = new Derived();
        b.doSomething(new Integer(0));
        d.doSomething(new Integer(0));
    }
}
