package com.vin.java11nf.annotations;

/*
ElementType value           Scope (what it applies to)
TYPE                         Interfaces, enums, classes, annotations.
METHOD                        Method declarations
PARAMETER                     Constructor and method parameters
FIELD                         Instance and static variables
CONSTRUCTOR                   Constructor declarations
LOCAL_VARIABLE                Local variables
ANNOTATION_TYPE               Annotations
TYPE_USE                     Anywhere there is a Java data type. This includes where
                             types are used e.g. object creation with new.
*
* */


// While java.lang is automatically imported, java.lang.annotation is not.
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

//@Target({ElementType.FIELD, ElementType.PARAMETER}) // 1.
//@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.CONSTRUCTOR}) // 2.
//@Target(ElementType.TYPE_USE) // 3.
@interface DataItem{}

@DataItem class X{} // annotation type not applicable to this type of declaration
@DataItem interface Y{} // annotation type not applicable to this type of declaration
class Z{
    @DataItem int a;            // ok
    @DataItem static int b;     // ok

    @DataItem Z(){}
    void m1(@DataItem int a){}  // ok
}
/////////////////////////////////////////////////////////////////////////////////
@Target(ElementType.TYPE_USE)
@interface Wildcard{}

class X1{
    @Wildcard int x;        // instance variable
    @Wildcard static int y; // class variable

    void m1(@Wildcard int a){// method parameter
        @Wildcard int z=0;   // local variable
        var x1 = new @Wildcard X1();    // new instance

        int n = (@Wildcard int)23.9;    // on a cast
    }
}
/////////////////////////////////////////////////////////////////////////////////
public class TargetExample {
    public static void main(String[] args) {

    }

}

