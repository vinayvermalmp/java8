package com.vin.stream.assignment;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// 1. Stream a list of int primitives between the range of 0 (inclusive) and 5 (exclusive). Calculate and
//output the average
public class Assignment1 {
    public static void main(String[] args) {
        IntStream ist = IntStream.range(0, 5);
        //ist.forEach(System.out::println);
        double average = ist.average().orElse(0.0);
        System.out.println("avg " +average);

        /*Given the Book class (in the zip file), declare a List typed for Book with the following Book’s:
a. title=”Gone with the wind”, price=5.0
b. title=”Gone with the wind”, price=10.0
c. title=”Atlas shrugged”, price=15.0
In a pipeline which has no return type: (QID 2.1847)
 stream the books
 using the collect() method, generate a Map that maps the book title to its price
 using forEach(), output the title and price of each entry in the map
What happened and why? Fix this by using the Collectors.toMap(Function, Function,
BinaryOperator) method*/

        List<Book> books = Arrays.asList(
                new Book("Gone with the wind", 10.0),
                new Book("Gone with the wind", 20.0),
                new Book("Atlas Shrugged", 15.0) );
        books.stream()
                .collect(Collectors.toMap(b -> b.getTitle(), b-> b.getPrice(), (v1, v2) -> v1+v2))
                .forEach((k, v) -> System.out.println(k + " -> " + v));
//        String str = "ababcdefdefghhf";
//        Map<Character, Long> resultMap = new HashMap<>();
//        str.chars().forEach(c -> resultMap.merge((char) c , 1L, Long::sum));
//        resultMap.forEach((k, v) -> System.out.println(k + " occurance -> " + v));

         List<String>  titleList = books.stream().map(book -> book.getTitle()).toList();

         //-------------------
        DoubleStream doubleStream = DoubleStream.of(0, 2,4);
        double s = doubleStream.filter(x -> x%2 != 0).sum();
        System.out.println("sum " +s);

        OptionalDouble avg = Stream.of(1.0,3.0).filter(x -> x%2 == 0).mapToDouble(x -> x).average();
        System.out.println("average : " + avg.orElse(0.0));

        // --------------------------------------------------

        /*13. This question demonstrates lazy evaluation. Declare the following List<Integer> ls =
Arrays.asList(11, 11, 22, 33, 33, 55, 66);
a. stream the List (note that this is possible because List is a Collection and Collection defines a
stream() method); ensure only distinct (unique) numbers are streamed; check if “any match”
11. You should get true for this.
b. stream the List again (this is necessary because once a stream is closed by a previous terminal
operation, you must re-create the stream); check to see if “none match” the expression
x%11>0. Note that the terminal operation noneMatch(Predicate) needs to return false for
every element in the stream for noneMatch() to return true. In other words, “none of them
match this….that’s correct, none of them do; return true”. You should get true here as well.
*/

        List<Integer> ls =
                Arrays.asList(11, 11, 22, 33, 33, 55, 66);
        ls.stream().distinct().forEach(System.out::println);
        boolean bl = ls.stream().distinct().anyMatch(n -> n ==11 );
        System.out.println( " is 11 is present in list array " + bl); // true

        boolean noneMatch = ls.stream().noneMatch(n -> n%11 > 0);
        System.out.println("none match” the expression x%11>0 -- "+noneMatch);

        // ----------------------------------------

        /*14. Examine the following code. Note that an AtomicInteger is a version of Integer that is safe to use in
concurrent (multi-threaded) environments. The method incrementAndGet() is similar to ++ai
a) Why is the value of ai at the end 0 (and not 4)?*/
        AtomicInteger ai = new AtomicInteger();
        Stream.of(11, 11, 22, 33)
                .parallel()
                .filter(n -> {
                    ai.incrementAndGet();
                    return n % 2 == 0;
                }).forEach( n -> System.out.println(n));
        System.out.println(ai);

        //--------------
        AtomicInteger atomicInteger = new AtomicInteger();
        Stream<Integer> stream = Stream.of(11, 11, 22, 33).parallel();
               stream.filter(n -> {
                   atomicInteger.incrementAndGet();
                    return n % 2 == 0;
                }).forEach( n -> System.out.println(n));
        System.out.println(atomicInteger);


    }
}
