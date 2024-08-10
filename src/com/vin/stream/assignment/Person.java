package com.vin.stream.assignment;

public class Person {
    private String fName;
    private String lNmae;
    private int age;
    Person(String fName, String lName, int age){
        this.fName = fName;
        this.lNmae = lName;
        this.age= age;

    }
    public String getfName(){
        return fName;
    }
    public int getAge(){
        return age;
    }

}
