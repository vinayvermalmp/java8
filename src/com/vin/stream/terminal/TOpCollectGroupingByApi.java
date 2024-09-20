package com.vin.stream.terminal;

// Terminal Operation Collector groupingBy

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
* groupingBy() tells collect() to group all of the elements into
a Map.
• groupingBy() takes a Function which determines the keys in
the Map.
• Each value is a List of all entries that match that key. The
List is a default, which can be changed.
* */
public class TOpCollectGroupingByApi {
    public static void main(String[] args) {
        doGroupingBy1();
        doGroupingBy2();
        doGroupingBy3();
    }
    public static void doGroupingBy1(){
        Stream<String> names = Stream.of("Martin", "Peter", "Joe", "Tom", "Tom", "Ann", "Alan");
        Map<Integer, List<String>> map = names.collect(
                // passing in a Function that determines the
                // key in the Map
                Collectors.groupingBy(String::length)
        );

        System.out.println(map);
    }

    /*
    * • What if we wanted a Set instead of a List as the value in the
map (to remove the duplication of “Tom”) ?
*
• groupingBy() is overloaded to allow us to pass down a
“downstream collector”. This is a collector that does
something special with the values.
    * */

    public static void doGroupingBy2(){
        Stream<String> names = Stream.of("Martin", "Peter", "Joe", "Tom", "Tom", "Ann", "Alan");
        Map<Integer, Set<String>> map = names.collect(
                Collectors.groupingBy(
                        String::length, // key in the Map
                        Collectors.toSet() // // what to do with the values
                )
        );
        System.out.println(map); // {3=[Ann, Joe, Tom], 4=[Alan], 5=[Peter], 6=[Martin]}
    }

    /*
    * • There are no guarantees on the type of Map returned.
• What if we wanted to ensure we got back a TreeMap but leave
the values as a List? We can achieve this by using the (optional)
map type Supplier while passing down the toList() collector.
    * */

    public static void doGroupingBy3(){
        Stream<String> names = Stream.of("Martin", "Peter", "Joe", "Tom", "Tom", "Ann", "Alan");
        TreeMap<Integer, List<String>> map = names.collect(
                Collectors.groupingBy(
                        String::length, // key in the Map
                        TreeMap::new, // map type supplier
                        Collectors.toList() // downstream collector

                )
        );
        System.out.println(map); // {3=[Ann, Joe, Tom], 4=[Alan], 5=[Peter], 6=[Martin]}
        System.out.println(map.getClass()); // class java.util.TreeMap
    }


}
