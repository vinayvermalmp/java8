package com.vin.java17nf.assignment;

public class University {
    public static void main(String[] args) {
        Faculty faculty = new EngineeringFaculty();
        Department department = new SoftwareEngineeringDept();
       // LecturerRecord record = new LecturerRecord("", 22, faculty, department );
        // LecturerRecord record = new LecturerRecord("Vinay", -3, faculty, department );

//        LecturerRecord lecturerRecord = new LecturerRecord("Vinay Kumar", 23, faculty, department);
//
//        System.out.println("Nmae is "+lecturerRecord.name());
//        System.out.println("age is "+lecturerRecord.age());
//        System.out.println("Faculty is "+lecturerRecord.faculty());
//        System.out.println("Department is "+lecturerRecord.dep());
//
//        lecturerRecord.whichFaculty();
//
//        lecturerRecord.whichDept();
//
//        System.out.println(lecturerRecord.hasPhd());

        LecturerRecord lecturerRecord = new LecturerRecord("Dr. Rohit Kumar", 53, new BusinessFaculty(), new AccountingDept());

        System.out.println("Nmae is "+lecturerRecord.name());
        System.out.println("age is "+lecturerRecord.age());
        System.out.println("Faculty is "+lecturerRecord.faculty());
        System.out.println("Department is "+lecturerRecord.dep());

        lecturerRecord.whichFaculty();

        lecturerRecord.whichDept();

        System.out.println(lecturerRecord.hasPhd()? lecturerRecord.name() +" has Phd" : lecturerRecord.name() + " does not have Phd");

    }
}
