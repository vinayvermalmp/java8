// package com.vin.java21nf.unnamed_classes_and_instance_main_methods;  // Implicitly declared class => no package statement allowed

// 0. HelloWorld working
// 1. Access instance methods/variables.
// 2. Show error if no main() method present.
// 3. Show error if constructor coded.
// 4. What happens if we try to new HelloWorld()?
// 5. What happens if another class is in this file?


// public class HelloWorld { }

import com.vin.java21nf.unnamed_classes_and_instance_main_methods.Others;

int x = 5;

void main(){
    System.out.println("Hello World");
    showX();
    new Others().test();
}

void showX(){
    System.out.println(x);
}

class SomeOtherClass{}