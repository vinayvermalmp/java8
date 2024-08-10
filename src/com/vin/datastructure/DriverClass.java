package com.vin.datastructure;

class X {
    static int i = 1111;
    static{
        i = i-- - --i; //L1
    }
    {
        i = i++ + ++i; //L2
    }
}
class Y extends X{
    static{
        i = --i - i--; //L3
    }
    {
        i = ++i + i++; //L4
    }
}
public class DriverClass{
    public static void main(String[] args){
        Y y = new Y();
        System.out.println(y.i); //L5
    }
}

