package com.vin.test.OopsTest;

class Super{
    static  String ID = "VINAY";

}
class  Sub extends Super{
    static {
        System.out.println("In sub");
    }
}

public class TestClass5 {
    public static void main(String[] args) {

        System.out.println(Sub.ID);
    }
}
