package com.vin.java11nf.security.EnsuringDataIntegrity;

import java.util.ArrayList;

public class TestImmutable {
    public static void main(String[] args) {
        ArrayList<String> employees = new ArrayList<>();
        employees.add("Ram");
        employees.add("Shyam");
        Department department = Department.createNewInstance("vinay", "Gurugram", 3, employees);
        System.out.println("Created : " +department);

        String name = department.getName();
        String address = department.getAddress();
        int numEmployess = department.getNumEmployees();
        employees = department.getEmployees();

        System.out.println("Retrived :" +name+" "+address+" "+numEmployess+" "+employees);


        // change what I got back - any effect on department immutable object

        name ="Mohan"; // strings are immutable so new objects are created in the background -> ok
        address = "Lakhimpur";
        numEmployess = 5;  // simple primitive i.e value is just copied back
        employees.add("Tom"); // as we only got the copy of AL; we are changing that copy

        System.out.println("Any change? :"+ department);

    }
}
