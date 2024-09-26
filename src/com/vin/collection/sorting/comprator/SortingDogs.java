package com.vin.collection.sorting.comprator;

import java.util.*;

public class SortingDogs {
    public static void main(String[] args) {
        comparable(new Dog[]{new Dog("Spot", 2), new Dog("Rover", 7)});  // just-in-time array
        comparable(Arrays.asList(new Dog("Spot", 2), new Dog("Rover", 7)));

        comparator(new Dog[]{new Dog("Rover", 7), new Dog("Spot", 2)});
        comparator(Arrays.asList(new Dog("Rover", 7), new Dog("Spot", 2)));
        sortingDogsMultipleFields();
    }

    private static void sortingDogsMultipleFields(){
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Trixy", 5));
        dogs.add(new Dog("Bella", 7));
        dogs.add(new Dog("Bella", 2)); // second Bella
        Comparator<Dog> compDog = Comparator
                .comparing(Dog::getName)
                .thenComparingInt(Dog::getAge);
        Collections.sort(dogs, compDog);
        System.out.println(dogs);// [Cat{name=Bella, age=2}, Cat{name=Bella, age=7}, Cat{name=Trixy, age=5}]
    }

    private static void comparator(Dog[] dogArray) {
        Comparator<Dog> byAge = Comparator.comparing(dog -> dog.getAge());
        Arrays.sort(dogArray, byAge);
        System.out.println(Arrays.toString(dogArray));

        Comparator<Dog> byAgeReversed = Comparator.comparing(Dog::getAge).reversed();
        Arrays.sort(dogArray, byAgeReversed);
        System.out.println(Arrays.toString(dogArray));
    }

    private static void comparator(List<Dog> dogList) {
        Comparator<Dog> byAge = Comparator.comparing(dog -> dog.getAge());
        Collections.sort(dogList, byAge);
        System.out.println(dogList.toString());

        Comparator<Dog> byAgeReversed = Comparator.comparing(Dog::getAge).reversed();
        Collections.sort(dogList, byAgeReversed);
        System.out.println(dogList);// [Dog{name=Rover, age=7}, Dog{name=Spot, age=2}]
    }

    private static void comparable(Dog[] dogs) {
        Arrays.sort(dogs);
        System.out.println(Arrays.toString(dogs));
    }
    private static void comparable(List<Dog> dogLists) {
        Collections.sort(dogLists);
        System.out.println(dogLists);
    }
}
