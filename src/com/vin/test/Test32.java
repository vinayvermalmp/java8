package com.vin.test;


import javax.annotation.processing.Generated;
import javax.xml.stream.events.Characters;
import java.beans.Transient;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

interface Reportar{
    public static final String INM = "nbt";
    String name();
    void  report();
    default String ReportingOn(String toping){
        return toping;
    }

}
abstract class ReportarClass{
    public static String INW ="hd";

    public abstract String name();
    public abstract void  report();

    public String ReportingOn(String toping){
        return toping;
    }

}
abstract class RepoInt implements Reportar{


    @Override
    public void report() {
        System.out.println("Reporter by name " +name());
    }
    public String ReportingOn(String toping){
        return "toping";
    }


}

abstract class RepoAbs extends ReportarClass{

    public abstract String name();

    @Override
    public void report() {
        System.out.println("Reporter by name " +name());
    }
}

public class Test32 {
    public static void main(String[] args) {
        String str = "aabfdfbdffd fhfg bbcdfhgfdd";
        //output = ["aa","bbbb","c","ddd"]
//        ReportarClass reportarClass = new RepoAbs();
//        Reportar repo = new RepoInt();
//
//        reportarClass.report();
//        repo.report();
//
//        List<Integer> list2 = Arrays.asList(2, 3, 5,6);
//        //List<Integer> list = new ArrayList<>(list2);
//        list2.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
//
//        list2.stream().collect(Collectors.toSet());
//        IntStream.rangeClosed(1, 100).filter(ele -> ele%2 == 0).forEach(System.out::println);
//        IntStream.rangeClosed(1, 100).filter(ele -> ele%2 != 0).forEach(System.out::println);



        List<String> list = new ArrayList<>();
         str.chars().mapToObj(uc -> Character.toLowerCase((char) uc))
                .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()))
                .entrySet().stream().forEach( entry -> {
                    String str2 = "";
                    for(int i=0; i< entry.getValue(); i++){
                        str2 += entry.getKey();
                    }
                    list.add(str2);
                });
         list.forEach(System.out::println);

    }
}




