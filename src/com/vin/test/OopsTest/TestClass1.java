package com.vin.test.OopsTest;

class Game{
    public void play() throws Exception{
        System.out.println("Playing............");

    }
}
class Soccer extends Game{
    public void play(String ball){
        System.out.println("Playing soccer with"+ ball);
    }
}

public class TestClass1 {
    public static void main(String[] args) throws Exception {
        // the reference type determines the method you can call
        Game g = new Soccer();
        g.play();
        // g.play("red"); throw exception
        System.out.println(g.getClass());// class com.vin.test.OopsTest.Soccer
        Soccer s = (Soccer) g;
        s.play();
        s.play("red");
        // getClass() returns the class of the object that the refrence refer to
        System.out.println(g.getClass()); //class com.vin.test.OopsTest.Soccer
        System.out.println(s.getClass()); //class com.vin.test.OopsTest.Soccer


    }
}
