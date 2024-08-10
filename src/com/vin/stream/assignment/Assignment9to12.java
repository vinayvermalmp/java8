package com.vin.stream.assignment;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class Assignment9to12 {
    public static void main(String[] args) {
        List<Person> friends =
                Arrays.asList(  new Person("Bob", "Kelly", 31),
                        new Person("Paul", "Landers", 32),
                        new Person("John", "Paters", 33));
        OptionalDouble avarage = friends
                .stream()
                    .filter(person -> person.getAge() < 30.0)
                        .mapToInt(person -> person.getAge()).average();
        System.out.println("average -> "+avarage.orElse(0.0) );

        //--------------------------------------------------------

        Optional<Double> price = Optional.ofNullable(20.0);

        price.ifPresent(p -> System.out.println(p));
        double x = price.orElse(22.0);
        System.out.println("x -> "+ x);
        double x2 = price.orElseGet(() -> 33.0);
        System.out.println("x2 -> "+ x);

        Optional<Double> price2 = Optional.ofNullable(null);
        System.out.println("price2 -> "+price2);
        if (price2.isEmpty()) {
            System.out.println("Empty");
        }
        price2.ifPresent(System.out::println); // nothing is preanted
        Double x3 = price2.orElse(44.0);
        System.out.println("x3 -> " +x3);

        //--------------------------
        Optional<Double> price3 = Optional.ofNullable(null);
        Double z = price3.orElseThrow(() -> new RuntimeException("BAD CODE"));
        System.out.println(z);
        //price3.ifPresentOrElse(aDouble -> System.out.println(aDouble));

    }
}
