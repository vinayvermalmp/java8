package com.vin.java11nf.security.EnsuringDataIntegrity;

import java.util.ArrayList;

/*• Immutable objects are objects that cannot be changed after
creation.
• They are secure objects and use the following guidelines:
1. Do not provide any “setter” methods.
2. Make all the fields private and final.
3. Prevent subclassing (prevents overriding):
    a) make the class final
    b) make the constructor private and provide a public static factory
    method e.g. “createNewInstance”
4. Instance fields:
    a) immutable types e.g. String, ok
    b) mutable types e.g. StringBuilder, do NOT share references
    i.e. use “defensive copying” and “advanced encapsulation”
*
*
* */

final class Department { // canot subclass this class and all method are final
    // private final instance variable
    private final String name; // String is immutable
    private final String address; // String is immutable

    private final int numEmployees;

    private final ArrayList<String> employees; // mutable

    // private constructor  - cannot subclass this class because this constructor
    // cannot be invocked from a subclass
    private Department(String name, String address, int numEmployees, ArrayList<String> employees){
        this.name = name;
        this.address = address;
        this.numEmployees = numEmployees;
        this.employees = new ArrayList<>(employees);
        // this.employees = employees; // vreaking encapulation
    }

    // factory method to create a Departmeent
    public static Department createNewInstance(String name, String address, int numEmployees, ArrayList<String> employees){
        return new Department( name,  address,  numEmployees, employees);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getNumEmployees() {
        return numEmployees;
    }

    public ArrayList<String> getEmployees() {
        return new ArrayList<>(employees); // return a new object
        //return employees;
    }

    @Override
    public String toString() {
        return "Department{" + "name='" + name + ", address='" + address + ", numEmployees=" + numEmployees + ", employees=" + employees + '}';
    }

}

//class SportsDepartmant extends Department{
//
//
//
//}


