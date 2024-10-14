package com.vin.java11nf.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
RetentionPolicy         value Description
SOURCE                  Source file only, compiler discards it.
CLASS                    Stored in the .class file but not available at runtime. This is
                         the default compiler behaviour.
RUNTIME                  Stored in the .class and available at runtime (via reflection).
*
* */

@Retention(RetentionPolicy.SOURCE)  // annotation discarded by the compiler
@interface Mouse{}                  // i.e. not in .class file

@Retention(RetentionPolicy.RUNTIME) // annotation stored in .class file and
@interface Keyboard{}               // available at runtime (via reflection)

public class RetentionExample {
    public static void main(String[] args) {

    }

}
