package com.vin.java11nf.annotations;

import java.lang.annotation.Repeatable;


/*
* This annotation enables us to specify an annotation on a
type more than once.
• This is useful if you wanted to use the same annotation but
with different values each time; thus, it is not of much use for
marker annotations (which have no elements).
• Requires two annotations:
1. A container annotation which has a value() array element; the
type of the array is the annotation you want to repeat.
2. The annotation to want to repeat; which is annotated with:
@Repeatable(ContainerAnnotationName.class)
* */

@interface Batteries {      // by convention, the plural of the annotation is used
    Battery[] value();      // must be value()
}

@Repeatable(Batteries.class)
@interface Battery{
    String level();
    boolean recharge();
}

@Battery(level="high", recharge=false)
@Battery(level="low", recharge=true)
class ElectricCar{}

public class RepeatableExample {

}

