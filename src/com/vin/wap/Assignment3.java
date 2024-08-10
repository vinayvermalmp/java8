package com.vin.wap;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Notes{
    private int id;
    private String name;
    private long tagId;
    public Notes(int id , String name, long tagId){
        this.id = id;
        this.name = name;
        this.tagId = tagId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getTagId() {
        return tagId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }
}

public class Assignment3 {
    public static void main(String[] args) {
//    How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order?
        List<Notes> noteLst = new ArrayList<>();
        noteLst.add(new Notes(1, "note1", 11));
        noteLst.add(new Notes(2, "note2", 22));
        noteLst.add(new Notes(3, "note3", 33));
        noteLst.add(new Notes(4, "note4", 44));
        noteLst.add(new Notes(5, "note5", 55));

        noteLst.add(new Notes(6, "note4", 66));
        listToMap(noteLst).forEach((k, v) -> System.out.println(k +" & value"+ v));
        // -------
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        countName(names).forEach((k, v) -> System.out.println(k+" -> "+v));

        countOnlyDuplicateElement(names).forEach((k, v) -> System.out.println(k+" -> "+v));

        countCharacterInString("string data to count each character").forEach((k, v) -> {
            System.out.print(k+" -> "+v+ ", ");
        });

    }

    // 22. Write a program to print the count of each character in a String?
    public static Map<Character, Long> countCharacterInString(String str){
        return str.chars()
                .mapToObj(i -> Character.toLowerCase((char) i))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
    }

    public static Map<String, Long> listToMap(List<Notes> noteLst){
        return noteLst.stream()
                .sorted(Comparator.comparing(Notes::getTagId).reversed())
                .collect(Collectors.toMap(Notes::getName, Notes::getTagId,
                        (oldValue, newValue)-> oldValue, LinkedHashMap::new));
    }

    // 18. How to count each element/word from the String ArrayList in Java8?
    public static Map<String, Long> countName(List<String> namesList){
        return namesList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

   // 19. How to find only duplicate elements with its count from the String ArrayList in Java8?
   public static Map<String, Long> countOnlyDuplicateElement(List<String> namesList){
       System.out.println("countOnlyDuplicateElement");
       return namesList.stream().filter(x -> Collections.frequency(namesList, x) > 1).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
   }


}
