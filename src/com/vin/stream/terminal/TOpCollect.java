package com.vin.stream.terminal;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TOpCollect {
    public static void main(String[] args) {
        doCollect1();
        System.out.println("Terminal Operations collect() – using API-defined Collectors");
        doJoining();
        doAverageInt();
        doCollectToMap1();
        doCollectToMap2();
        doCollectToMap3();
    }

    public static void doCollect1(){

        // StringBuilder collect(Supplier<StringBuilder> supplier,
        //               BiConsumer<StringBuilder,String> accumulator
        //               BiConsumer<StringBuilder,StringBuilder> combiner)
        // This version is used when you want complete control over
        // how collecting should work. The accumulator adds an element
        // to the collection e.g. the next String to the StringBuilder.
        // The combiner takes two collections and merges them. It is useful
        // in parallel processing.
        StringBuilder word = Stream.of("ad", "jud", "i", "cate")
                .collect(() -> new StringBuilder(),         // StringBuilder::new
                        (sb, str) -> sb.append(str),       // StringBuilder::append
                        (sb1, sb2) -> sb1.append(sb2));    // StringBuilder::append
        System.out.println(word);// adjudicate
    }

    // Terminal Operations collect() – using API-defined Collectors
    // collecting into map
    public static void doCollectToMap3() {

        // The maps returned are HashMaps but this is not guaranteed. What if we wanted
        // a TreeMap implementation so our keys would be sorted. The last argument
        // caters for this.
        TreeMap<String, Integer> map =
                Stream.of("cake", "biscuits", "apple tart", "cake")
                        .collect(
                                Collectors.toMap(s -> s,            // key is the String
                                        s -> s.length(),   // value is the length of the String
                                        (len1, len2) -> len1 +len2, // what to do if we have
                                        // duplicate keys
                                        //    - add the *values*
                                        () -> new TreeMap<>() // TreeMap::new works
                                ));
        System.out.println(map); //
        System.out.println(map.getClass());
    }
    public static void doCollectToMap2(){
        // We want a map: number of characters in dessert name -> dessert name
        // However, 2 of the desserts have the same length (cake and tart) and as
        // length is our key and we can't have duplicate keys, this leads to an
        // exception as Java does not know what to do...
        //    IllegalStateException: Duplicate key 4 (attempted merging values cake and tart)
        // To get around this, we can supply a merge function, whereby we append the
        // colliding keys values together.
        Map<Integer, String> map = Stream.of("cake", "biscuits", "tart", "cart")
                .collect(
                        Collectors.toMap(
                        s-> s.length(),   // Function for the key
                        s-> s,  // function for the value
                        (s1, s2) -> s1 + "," + s2)// Merge function - what to
                                                // do if we have duplicate keys
                                                //   - append the values
                );
        System.out.println(map);
    }
    public static void doCollectToMap1(){
        // We want a map: dessert name -> number of characters in dessert name
        // Output:
        //   {biscuits=8, cake=4, apple tart=10}
        Map<String, Integer> map = Stream.of("cake", "biscuits", "apple tart")
                .collect(Collectors.toMap(
                        s-> s,   // Function for the key
                        s-> s.length()  // function for the value
                ));
        System.out.println(map);
    }

    public static void doJoining(){
        String str = Stream.of("cake", "biscuits", "apple tart")
                .collect(Collectors.joining(", "));
        System.out.println(str);
    }

    public static void doAverageInt(){
        Double avg = Stream.of("cake", "biscuits", "apple tart")
                .collect(Collectors.averagingInt(s -> s.length()));
        System.out.println("average :  "+avg);
    }


}
