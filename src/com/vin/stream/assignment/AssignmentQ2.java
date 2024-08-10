package com.vin.stream.assignment;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Stream;

public class AssignmentQ2 {
    public static void main(String[] args) {

        /*
        2. Given the Item class (in the zip file), declare a List typed for Item with the following Item’s:
            a. id=1 name=”Screw”
            b. id=2 name=”Nail”
            c. id=3 name=”Bolt”
            Stream the list and sort it so that it outputs “BoltNailScrew” i.e. alphabetic name order. Use Stream’s
            forEach method to output the names (use the method reference version for the required Consumer
            lambda).
        * */

        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "Screw"));
        items.add(new Item(2, "Nail"));
        items.add(new Item(3, "Bolt"));

        items.stream().sorted(Comparator.comparing(Item::getName)).map(item -> item.getName()).forEach(System.out::printf);


        /*3. Generate a Stream<List<String>> using the Stream.of(Arrays.asList(“a”, “b”), Arrays.asList(“a”,
“c”)) method call. Filter the stream so that only list’s that contain “c” make it through the filter.
Flatten the Stream<List<String>> to a Stream<String> using the flatMap() operation. Note that
flapMap() states in the API “Each mapped stream is closed after its contents have been placed into
this [new] stream.”. Use forEach() to output the new stream. */

        Stream<List<String>> streamOfLists = Stream.of(
                Arrays.asList("a", "b"),
                Arrays.asList("a","c"),
                Arrays.asList("d", "c"));

        streamOfLists
                .filter(list -> list.contains("c"))
                .peek(list -> System.out.println("\n"+ list))
                .flatMap(list -> list.stream())
                .forEach(System.out::println);

        // ---------------------------------------------------------
        /* Using 1, 2 and 3 create a List of Integers.
i. Stream the list and calculate the sum, using the sum() method from IntStream.
ii. Stream the list again and calculate the maximum value, using the max() method from
IntStream. */
        List<Integer> li2 = Arrays.asList(1,2,3);
        int sum = li2.stream().mapToInt(i -> i).sum();
        System.out.println("sum of 1,2 ,3 is "+ sum);

        int max = li2.stream().mapToInt(i-> i.intValue()).max().getAsInt();
        System.out.println("max of 1,2 ,3 is "+ max);

        // -----------------------------------------------

        /*Given the Person class (in the zip file), declare a List typed for Person with the following
Person’s:
i. “Alan”, “Burke”, 22
ii. “Zoe”, “Peters”, 20
iii. “Peter”, “Castle”, 29
Using the max(Comparator) from Stream, calculate the oldest person in the list.*/

    List<Person> people = new ArrayList<>();
        people.add(new Person("Alan", "Burke", 22));
        people.add(new Person("Zoe", "Peters", 20));
        people.add(new Person("Peter", "Castle", 29));

        Person person = people.stream().max(Comparator.comparing(Person::getAge)).get();
        System.out.println("the oldest person is : " +person.getfName()+"("+person.getAge()+")");


        //--------------------------
        /*Using 10, 47, 33 and 23 create a List of Integers. Stream the list and using the following
versions of reduce(), calculate the maximum value:
i. Optional<T> reduce(BinaryOperator<T> accumulator)
ii. T reduce(T identity, BinaryOperator<T> accumulator)
*/
            List<Integer> integerList = Arrays.asList(10, 47, 33, 23);

            int maxInt = integerList
                        .stream()
                                .reduce((a, b)->a>b?a:b).get();
                            //.reduce((a, b) -> Integer.max(a, b)).get();
        System.out.println("max of 10, 47, 33 and 23 is -> " +maxInt);



    }





}
