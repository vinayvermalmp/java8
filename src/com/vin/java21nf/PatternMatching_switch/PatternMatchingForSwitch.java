package com.vin.java21nf.PatternMatching_switch;

/*
In other words, the selection of which branch to execute is
separated from what to do when we execute that branch.
• Changes include:
• case labels can include patterns and null
• case labels can include optional when clauses (“guards”)
• selector expression types broadened
• from:
• integral primitive types (excluding long), their corresponding wrapper
types, String and enums.
• to:
• integral primitive types (excluding long) and any reference type.
• enum constant case labels improved
• qualified enum constants now allowed
* */
sealed class Vehicle permits Car, Boat, Train{}
final class Car extends Vehicle {
    private int numDoors;
    Car(int numDoors){
        this.numDoors = numDoors;
    }
    public int getNumDoors() {return numDoors;}
    public String onRoad(){
        return "I can move on the road";
    }
}
final class Boat extends Vehicle{}
final class Train extends Vehicle{}

//Pattern-matching for switch - pattern labels, null and when clauses
public class PatternMatchingForSwitch {

    public static void patternMatchingSwitch(Vehicle v) {
        System.out.println(
                switch (v) { // 'v' is the "selector expression"
                    // 'Boat b' is a (type) pattern label
                    case Boat b -> "It's a Boat";
                    case Train t -> "It's a Train";
                    // 'Car c' is a type pattern and also a "guarded case label"
                    // 'c.getNumDoors() == 4' is a "guard":
                    //    A guard is a boolean expression on the RHS of a 'when' clause.
                    // Overall it is called a "guarded pattern".
                    case Car c when c.getNumDoors() == 4 -> "It's a Saloon/Sedan: " + c.onRoad();
                    case Car c when c.getNumDoors() == 2 -> {
                        yield "It's a Convertible: " + c.onRoad();
                    }
                    // 1. If both Vehicle and default are omitted, exhaustiveness error
                    // 2. If both Vehicle and default are present, "unconditional" error (Vehicle dominates default)
                    // 3. If both default and null are present, default dominates null
                    // 4. Grammar amended to allow "null, default" label
  //                 case Vehicle vehicle -> "Generic Vehicle"; // unconditional pattern and "default" not allowed as:
//                   default -> "Invalid type";   //    - dominated/unreachable if "Vehicle vehicle" type pattern there
//                    case null             -> "Invalid type"; // dominated/unreachable if 'default' there
                    case null, default      -> "Invalid type";
                }
        );
    }
    public static void main(String[] args) {
        patternMatchingSwitch(new Car(2));  //It's a Convertible: I can move on the road
        patternMatchingSwitch(new Car(4));  //It's a Saloon/Sedan: I can move on the road
        patternMatchingSwitch(new Boat());          //It's a Boat
        patternMatchingSwitch(new Vehicle());  //Invalid type
        patternMatchingSwitch(null);    //Invalid type

    }
}
