package com.vin.stream.terminal;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
* Terminal Operations : Collectors.partitioningBy()
• Partitioning is a special case of grouping where there are
only two possible groups – true and false.
• The keys will be the booleans true and false.
* */
public class TOpCollectPartitioningByApi {
    public static void main(String[] args) {
        doPartitioning1();
        doPartitioning2();
        doPartitioning3();
    }
    public static void doPartitioning1(){
        Stream<String> names = Stream.of("Thomas", "Teresa", "Mike", "Alan", "Peter");
        Map<Boolean, List<String>> map = names.collect(
                //pass in a predicate
                Collectors.partitioningBy(s -> s.startsWith("T"))
        );
        System.out.println(map); // {false=[Mike, Alan], true=[Thomas, Teresa, Peter]}
    }

    public static void doPartitioning2(){

        Stream<String> names = Stream.of("Thomas", "Teresa", "Mike", "Alan", "Peter");
        Map<Boolean, List<String>> map =
                names.collect(
                        // pass in a Predicate
                        Collectors.partitioningBy(s -> s.length() > 4)
                );
        System.out.println(map);// {false=[Mike, Alan], true=[Thomas, Teresa, Peter]}

    }

    public static void doPartitioning3(){

        Stream<String> names = Stream.of("Thomas", "Teresa", "Mike", "Alan", "Peter");
        Map<Boolean, List<String>> map =
                names.collect(
                        // forcing an empty list
                        Collectors.partitioningBy(s -> s.length() > 10)
                );
        System.out.println(map);// {false=[Thomas, Teresa, Mike, Alan, Peter], true=[]}

    }
    // As with groupingBy(), we can change the values type from List to Set.
    public static void doPartitioning4(){

        Stream<String> names = Stream.of("Thomas", "Teresa", "Mike", "Alan", "Peter");
        Map<Boolean, Set<String>> map =
                names.collect(
                        // pass in a Predicate
                        Collectors.partitioningBy(
                                s -> s.length() > 4, // predicate
                                Collectors.toSet()
                                )
                );
        System.out.println(map);// {false=[Mike, Alan], true=[Thomas, Teresa, Peter]}

    }



}
