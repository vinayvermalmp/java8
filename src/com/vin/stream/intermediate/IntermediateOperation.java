package com.vin.stream.intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", age=" + age + '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}

/*
   * • Unlike a terminal operation, an intermediate operation
produces a stream as a result.
* ex: map(), limit(), distinct(), flatMap(), sorted(), filter(), peak()
   * */
public class IntermediateOperation {
    public static void main(String[] args) {
        //doFilter();
        //doDistinct();
        //doLimit();
        //doMap();
        //doFlatMap();
       // System.out.println();
        doSortedFromBook();
        doSorted2();


    }

    public static void doFilter() {

        // Stream<T> filter(Predicate)
        // The filter() method returns a Stream with the elements that
        // MATCH the given predicate.
        Stream.of("galway", "mayo", "roscommon")
               // .peek(System.out::println)
                .filter(countyName -> countyName.length() > 5)
                .forEach(System.out::println);// galwayroscommon
    }
    public static void doDistinct() {
        // Stream<T> distinct()
        // distinct() is a stateful intermediate operation
        // Output: 1.eagle 2.eagle 1.eagle 1.EAGLE 2.EAGLE
        Stream.of("eagle", "eagle", "EAGLE")
                .peek(s -> System.out.print(" 1."+s))
                .distinct()
                .forEach(s -> System.out.print(" 2."+s));

    }
    public static void doLimit() {

        // Stream<T> limit(long maxSize)
        // limit is a short-circuiting stateful
        // intermediate operation. Lazy evaluation - 66, 77, 88 and 99
        // are not streamed as they are not needed (limit of 2 i.e. 44 and 55).
        // Output:
        //  A - 11 A - 22 A - 33 A - 44 B - 44 C - 44 A - 55 B - 55 C - 55
        Stream.of(11,22,33,44,55,66,77,88,99)
                .peek(n -> System.out.print(" A - "+n))
                .filter(n -> n > 40)
                .peek(n -> System.out.print(" B - "+n))
                .limit(2)
                .forEach(n -> System.out.print(" C - "+n));
    }

    public static void doMap() {

        // <R> Stream<R> map(Function<T,R> mapper)
        //     Function's functional method: R apply(T t);
        Stream.of("book", "pen", "ruler")
                .map(s -> s.length()) // String::length
                .forEach(System.out::print);// 435
    }
    public static void doFlatMap() {

        List<String> list1 = Arrays.asList("sean", "desmond");
        List<String> list2 = Arrays.asList("mary", "ann");
        Stream<List<String>> streamOfLists = Stream.of(list1, list2);

        // flatMap(Function(T, R)) IN:T OUT:R
        //  flatMap(List<String>, Stream<String>)
        streamOfLists.flatMap(list -> list.stream())
                .forEach(System.out::print);// seandesmondmaryann
    }
    /*
    • sorted() returns a stream with the elements sorted.
    • Just like sorting arrays, Java uses natural ordering unless we
      provide a comparator.
    • sorted() is a stateful intermediate operation; it needs to see
     all of the data before it can sort it.
    * */

    public static void doSortedFromBook() {

        // Stream<T> sorted()
        // Stream<T> sorted(Comparator<T> comparator)
        // Output:
        //  0.Toby 1.Toby - sorted() can't sort yet
        //                  needs all the data, holds Toby
        //  0.Anna 1.Anna - sorted() can't sort yet, holds Anna
        //  0.Leroy       - filtered out
        //  0.Alex 1.Alex - sorted() can't sort yet, holds Alex
        //                - Java tells sorted() - "its time to sort"
        //  2.Alex 3.Alex - limit() passes on Alex, Alex is output
        //  2.Anna 3.Anna - limit() passes on Anna and lets Java know
        //                  thats 2 of 2; Java lets forEach print Anna
        //                  and then stops the pipeline
        // Note: Toby is not output.
        Stream.of("Toby", "Anna", "Leroy", "Alex", "Graig")
                .peek(s -> System.out.print(" 0."+s))
                .filter(s -> s.length()==4)
                .peek(s -> System.out.print(" 1."+s)) // no Leroy
                .sorted() // stores Toby, Anna and Alex
                .peek(s -> System.out.print(" 2."+s))
                .limit(2)
                .forEach(s -> System.out.print(" 3."+s));// no Toby

    }
    public static void doSorted2() {

        // Stream<T> sorted(Comparator<T> comparator)
        // Output:
        //   Person{name=John, age=23}Person{name=Mary, age=25}
        Person john = new Person("John", 23);
        Person mary = new Person("Mary", 25);
//        Person john = new Person("Mohan", 23);
//        Person mary = new Person("Rohan", 25);
        Stream.of(john, mary).
                //.sorted(Comparator.comparing(Person::getAge))
                sorted(Comparator.comparing(person -> person.getAge()))
                .forEach(System.out::println);
    }






}
