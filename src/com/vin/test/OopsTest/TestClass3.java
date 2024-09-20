package com.vin.test.OopsTest;


// trying to acces private data defined higher up the inheritance tree
class  A{
    public int i =10;
    private int j = 20;

}
class B extends A{
    private int i = 20;
    public int k = 30;
}
class C extends B{

}
public class TestClass3 {
    public static void main(String[] args) {
        C c = new C();
       // System.out.println(c.i); // compiler error
       // System.out.println(c.j); // compiler error
        System.out.println(c.k); // 30
        // here round bracket ensue cast is done first otherwise we get the same compiler error
        // as above i has private acces in B
        System.out.println(((A)c).i); // 10
    }
}
