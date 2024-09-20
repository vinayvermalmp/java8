package com.vin.test.OopsTest;

//// explaining covariant returns, reference vs object type

class  Base{
    public Object getValues(){ return new Object();}
}
class  Base2 extends Base{
    public String getValues(){ return "hello";} // can return subClass when overriding methods
    // here String is subClass of object
}

public class TestClass {
    public static void main(String[] args) {
        Base b = new Base2();
        System.out.println(b.getValues());

    }
}
