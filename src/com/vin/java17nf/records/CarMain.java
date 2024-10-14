package com.vin.java17nf.records;

/*
Records are a special type of class that help avoid
boilerplate code. They are considered “data carriers”.
• Records are immutable and are final by default.
• You cannot extend your custom record because records
already (implicitly) extend from the Record class. This is
similar to enums (which implicitly extend from Enum).

Records can have both static fields and static methods.
• Records can have instance methods.
• Records cannot have instance fields. All the instance fields
are listed as “components” in the record declaration.
• Records can implement interfaces.


Records are specified using a record declaration where you
specify the “components” of the record.
• Implicitly generated are:
• canonical constructor
• toString() - the string representation of all the record class's
components, with their names.
• equals() and hashCode() - which specify that two record classes are
equal if they are of the same type and contain equal component values
• public accessor methods with the same name as the components.
* */
public class CarMain {
    public static void main(String[] args) {
       //  1. Regular class
//        Car car = new Car("231G1234", "Joe Bloggs");
//        System.out.println(car);
//        System.out.println(car.getOwner());
//        System.out.println(car.getRegNumber());

        // 2. Using a record
        CarRecord carRecord = new CarRecord("231G4321", "Mary Bloggs");
        System.out.println(carRecord);
        System.out.println(carRecord.owner()); // slightly different accessor method names
        System.out.println(carRecord.regNumber());

        // 3. Define an instance method; cannot define an instance field
         System.out.println(carRecord.isNewCar());

        // 4. Define a static field
         System.out.println(CarRecord.currentYear);

        // 5. Define a static method
        CarRecord blankCar = CarRecord.createBlankCarRecord();
        System.out.println("blank owner:"+blankCar.owner()); // slightly different accessor method names
        System.out.println("blank reg number:"+blankCar.regNumber());

        // 6. Custom canonical constructor and compact constructor
        // 7. Non-canonical record constructor must delegate to another constructor
        // 8. Override the owner() accessor method
        // 9. Cannot define a subtype based on a record
        // 10. Can implement an interface
        // 11. When defining your record, you cannot extend from another type

    }
}
