package com.vin.test.OopsTest;

// interfaces can extend from multiple interfaces

interface I1 {

}
interface I2 {
    int VALUE = 10;
    void m2();
}
interface I3 extends I1, I2{ // valid
    public void m2();
    public void m2(int x);
}

// abstract classes can implement interfaces without providing any methods
interface I4{
    void setValue(String s);
    String getValues();
}
abstract class Btr implements I4 { // abstract classes can implement interfaces without providing any methods
    int getValue(int x){ return 0;}
    /* this method is not in I4 so valid */
}

public interface TestInterface1 {
}

