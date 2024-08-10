package com.vin.test;

import java.util.ArrayList;
import java.util.List;


class Employee{
    private int id;
    private String name;
    private String email;

    public Employee(int id, String name, String email){
        this.id = id;
        this.name = email;
        this.email = email;
    }

    public int getId(){
        return  id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return  name;
    }
    public  void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public String toString() {
        return "[id: "+ this.id+", name: "+ this.name+", email:"+ this.email+" ]";
    }

}
public class Test8 {
    public static void main(String[] args) {
        // tprint the list email of employobj
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(new Employee(1, "Arun", "arun@email.com"));
        employeeList.add(new Employee(1, "Vrun", "vrun@email.com"));
        employeeList.add(new Employee(1, "karan", "karan@email.com"));
        employeeList.stream().map(emp -> emp.getEmail()).forEach(System.out::println);

        String s = "welcometojava";
        String s1 = s.substring(0, 3);
        System.out.println(s +" :::--"+ s1);
        System.out.println(getSmallestAndLargest(s, 3));


//        for (int i = 0; i <=s.length()-k ; i++) {
//            String sb s.substring(i, k+i);
//            int com = A.compareTo(sb);
//            if (com >= 0) {
//                largest = sb;
//            } else {
//                smallest = sb;
//            }
//        }

        //employeeList
    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        for (int i = 0; i <=s.length()-k; i++) {
            String sb = s.substring(i, k+i);
            // int sb = smallest.compareTo(sb);
            if(sb.compareTo(largest)>0) {
                largest=sb;
            }else {
                smallest = sb;
            }

            if(sb.compareTo(smallest)<0){smallest=sb;}

        }

        return smallest + "\n" + largest;
    }
}
