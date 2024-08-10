package com.vin.stream.assignment;

import java.util.*;
import java.util.stream.Collectors;

/*
Code a method public static Optional<String> getGrade(int marks) (QID 2.1826)
a. in the method getGrade:
i. declare an empty optional, typed for String called grade
ii. insert the following code:
if (marks > 50) {grade = Optional.of(“PASS”);} else {grade.of(“FAIL”);}
b. in main():
i. declare an Optional, typed for String named grade1 which is initialised to the return
value of calling getGrade(50)
ii. declare an Optional, typed for String named grade2 which is initialised to the return
value of calling getGrade(55)
iii. using orElse() on grade1, output the value of grade1 or “UNKNOWN”
iv. if(grade2.isPresent()) is true: use ifPresent(Consumer) to output the contents of
grade2; if false, use orElse() to output the contents of grade2 or “Empty”
v. Notes:
1. Optional’s are immutable.
2. Optional.of(null); // NullPointerException
3. Optional.ofNullable(null); // Optional.empty returne
* */
public class AssignmentQ5To8 {
    public static void main(String[] args) {
        //
        Optional<String> graade1 = getGrade(50);
        Optional<String> graade2 = getGrade(55);
        System.out.println(graade1.orElse("UNKNOWN"));
        if (graade2.isPresent()) {
            graade2.ifPresent(System.out::println);
        }else {
            System.out.println(graade2.orElse("Empty"));
        }

        /*Given the Book class (in the zip file), declare a List typed for Book with the following Book’s:
a. title=”Thinking in Java”, price=30.0
b. title=”Java in 24 hrs”, price=20.0
c. title=”Java Recipes”, price=10.0
Stream the books and calculate the average price of the books whose price is > 10.
Change the filter to books whose price is > 90. Ensure you do not get an exception.
        * */
        List<Book> bookList = Arrays.asList(
          new Book("Thinking in Java", 30.0),
          new Book("Java in 24 hrs", 20.0),
          new Book("Java Recipes", 10.0)
        );

//        double avrage = bookList
//                    .stream()
//                        .filter(book -> book.getPrice() > 90.0)
//                        .mapToInt(b -> (int) b.getPrice()).average().getAsDouble(); this will give exception
         OptionalDouble avrage = bookList
                .stream()
                .filter(book -> book.getPrice() > 10.0)
                .mapToDouble(b -> b.getPrice()).average();
        System.out.println("the average price of the books whose price is > 10. = -> "+ avrage.orElse(0.0));

        /*Given the Book class (in the zip file), declare a List typed for Book with the following Book’s:
a. title=”Atlas Shrugged”, price=10.0
b. title=”Freedom at Midnight”, price=5.0
c. title=”Gone with the wind”, price=5.0
Stream the books and instantiate a Map named ‘bookMap’ that maps the book title to its price. To do
this use the collect(Collectors.toMap(Function fnToGetKey, Function fnToGetValue)). Iterate
through ‘bookMap’ (using the Map forEach(BiConsumer) method). The BiConsumer only outputs
prices where the title begins with “A”.
        *
        * */
        List<Book> bookList1 = Arrays.asList(
                new Book("Atlas Shrugged", 30.0),
                new Book("Freedom at Midnight", 20.0),
                new Book("Gone with the wind", 10.0)
        );

        Map<String, Double> bookmap =
                bookList1.stream()
                        .collect(Collectors.toMap(book -> book.getTitle(), book -> book.getPrice()));
       // bookmap.forEach((k , v) -> System.out.println("title " +k+ " values "+v));
        bookmap.forEach((k, v) -> {
            if (k.startsWith("A")) {
                System.out.println("title " +k+ " values "+v);
            }
        });

    }

    public  static Optional<String> getGrade(int marks){
        Optional<String> grade = Optional.empty();
        if (marks > 50) {
            grade = Optional.of("PASS");
        } else {
            grade = Optional.of("FAIL");
        }
        return grade;
    }
}
