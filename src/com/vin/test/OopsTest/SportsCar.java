package com.vin.test.OopsTest;



// explaining overriding , polymorphism, reference vs object type
class Car{
    public int gearRatio = 9;
    public String accelerate(){return "accelerate : car";}
}

public class SportsCar extends Car {
    public int gearRatio = 8;
    public String accelerate(){return "accelerate : sprotsCar";}
    public static void main(String[] args) {
        Car c = new SportsCar(); // refering car object so 9 get printeed
        // but accelerate method is polymorphic so sports class methode get called
        System.out.println(c.gearRatio + ","+c.accelerate());
    }
}
