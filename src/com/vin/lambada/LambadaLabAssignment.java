package com.vin.lambada;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface Printable<T>{
    void print(T t);
}
interface Retrievable<T> {
    T retrive();
}
interface  Evaulate<T> {
    boolean isNegative(T t);
}
interface Functionable<T, R>{
    R apply(T t);
}
class Person{
    private String name;
    private int age;
    private double height;

    Person(String name, int age, double height){
        this.name = name;
        this.age= age;
        this.height=height;
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public double getHeight() {
        return this.height;
    }

    @Override
    public String toString() {
        return "name : "+ this.getName()+
                " age " + this.getAge()+
                " height "+ this.getHeight();
    }
}
public class LambadaLabAssignment {
    private static List<Person> getPeople() {
        List<Person> result = new ArrayList<>();
        result.add(new Person("Mike", 33, 1.8));
        result.add(new Person("Mary", 25, 1.4));
        result.add(new Person("Alan", 34, 1.7));
        result.add(new Person("Zoe", 30, 1.5));
        return result;
    }
    private static void sortAge(List<Person> listPeople){
        listPeople.sort(
                Comparator.comparing(p -> p.getAge()));
        // Comparator.comparing(Person::getAge);
        System.out.println("After sort by age");
        listPeople.forEach(p -> System.out.println(p));
    }

    private static void sortName(List<Person> listPeople){
        listPeople.sort(
               // Comparator.comparing(p -> p.getName()));
        Comparator.comparing(Person::getAge));
        System.out.println("After sort by name");
        listPeople.forEach(p -> System.out.println(p));
    }
    private static void sortHeight(List<Person> listPeople){
        listPeople.sort(
                Comparator.comparing(p -> p.getHeight()));
        // Comparator.comparing(Person::getAge);
        System.out.println("After sort by height");
        listPeople.forEach(p -> System.out.println(p));
    }
    public static void main(String[] args) {
        LambadaLabAssignment assignment = new LambadaLabAssignment();
        assignment.consumer();
        assignment.supplier();
        assignment.predicate();
        assignment.function();

        List<Person> listPeople = getPeople();
        listPeople.forEach(person -> System.out.println(person) );
        sortAge(listPeople);
        sortName(listPeople);
        sortHeight(listPeople);
    }

    private void consumer() {
        Printable<String> lambada = s -> System.out.println(s);
        lambada.print("Printable lambada");
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("Printable lambada");
        Consumer<String> consumerMr = System.out::println;
        consumerMr.accept("Printable lambada");
    }
    private void supplier() {
        Retrievable<Integer> lambda = () -> 77;
        System.out.println("Retrivable : "+ lambda.retrive() );

        Supplier<Integer> supplier = () -> 77;
        System.out.println("Retrivable : "+ supplier.get());

    }

    private void predicate(){
        int x = -4;
        Evaluate<Integer> lambada = (i) -> i < 0;
        System.out.println(x + " is nagitaive " + lambada.isNegative(x));
        x = 5;
        System.out.println(x + " is nagitaive " + lambada.isNegative(x));

        Predicate<Integer> predicate = n -> n<0;
        x = -3;
        System.out.println(x + " is nagitaive " + lambada.isNegative(x));
        x = 7;
        System.out.println(x + " is nagitaive " + lambada.isNegative(x));

        Predicate<Integer> predicate1 = n -> n%2 ==0;
        System.out.println("4 is even? "+ check(4, predicate1));
        System.out.println("7 is even? "+ check(7, predicate1));

        Predicate<String> predicate2 = s -> s.startsWith("Mr.");
        System.out.println("Mr. Joe Bloggs start eith Mr.? "+ check("Mr. Joe Bloggs", predicate2));
        System.out.println("Ms. Ann Bloggs start eith Mr.? "+ check("Ms. Ann Bloggs ", predicate2));

        Predicate<Person> predicate3 = p -> p.getAge() > 18;
        System.out.println("Mike (33, 1.8) is adult? "+ check(new Person("Mike", 33, 1.8), predicate3));
        System.out.println("Ann (13, 1.4) is adult?  "+ check(new Person("Ann" , 13, 1.4), predicate3));
    }

    private void function(){
        Functionable<Integer, String> lambada = (n) -> n.toString();
        System.out.println("Number is : " + lambada.apply(25));

        Function<Integer, String> function = (n) -> n.toString();
        System.out.println("Number is : " + function.apply(25));
    }

    private static<T> boolean check(T t, Predicate<T> lambada){
        return lambada.test(t);
    }
}
