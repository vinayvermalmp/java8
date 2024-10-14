package com.vin.java11nf;

interface InefficientTennis{ // lot of code duplication
    static void forehead(){
        System.out.println("Move into position");
        System.out.println("Hitting a forehand");
        System.out.println("Move back into reday position");
    }
    default void backhand(){
        System.out.println("Move into position");
        System.out.println("Hitting a forehand");
        System.out.println("Move back into reday position");
    }

    default void smash(){
        System.out.println("Move into position");
        System.out.println("Hitting a forehand");
        System.out.println("Move back into reday position");
    }
}

    /*
    * Introduced in Java 9, interfaces can now have private
methods.
• These private methods can be both static and non-static.
• As they are private, they are accessible within the interface
only.
• As with classes, you cannot access a non-static interface
method from a static method.
*
* • They have two advantages:
1. reduce code duplication
2. improve code encapsulation

    *
    * */
interface Tennis {
        private static void hit(String stroke) {
            System.out.println("Move into position");
            System.out.println("Hitting a "+stroke);
            System.out.println("Move back into reday position");

        }
        static void forehead(){hit("forehead");}  // from a static method - ok
        default void backhand(){hit("backhand");}  // from a default method - ok
        private void smash(){hit("smash");} // from another private method - ok

        // void volley(){hit("forehead");}  // abstaract method can not have method body
    }

    class ProfessionalTennis implements Tennis{ }

public class privateInterfaceDemo {

    public static void main(String[] args) {
        Tennis tennis = new ProfessionalTennis();
        tennis.backhand();
        Tennis.forehead();
    }

}
