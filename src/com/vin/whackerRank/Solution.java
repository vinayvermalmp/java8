package com.vin.whackerRank;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.io.*;

interface A{
   public void  mai();
}
interface B{
    public void  mai();
}

class MainT implements A, B{

    @Override
    public void mai() {
        System.out.println("implemented");
    }
}


class Solution{
    public static int area;
    // public static int H;
    public static void main(String []argh) throws Exception {

        A a = new MainT();
        a.mai();
        System.out.println(findDay(8 ,05, 2015));
         List<String> lixt = new ArrayList<>();

        lixt.add("nbt");
        List<String> list = lixt;
        lixt = null;
        list.stream().forEach(System.out::println);

        try
        {
            Scanner sc = new Scanner(System.in);
            int B=sc.nextInt();
            int H = sc.nextInt();
            if (B <= 0 || H <= 0 ) {
                throw new Exception();
            }

            {
                area = B*H;
            }
            System.out.println(area);
        }
        catch(Exception e)
        {
            System.out.println(e.toString() +": Breadth and height must be positive");
        }

    }

    public static String findDay(int month, int day, int year) throws ParseException {
       // String date = ""+day+"/"
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
//        Date date = sdf.parse(day+"-"+ month+"-"+ year);
//        sdf.applyPattern("EEEE");
//        String str = sdf.format(date);
//        return str;
        LocalDate localDate = LocalDate.of(year, month, day);
          DayOfWeek dd = localDate.getDayOfWeek();
          String str = String.valueOf(dd);
          return  str;

//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.YEAR, year);
//        calendar.set(Calendar.MONTH, month);
//        calendar.set(Calendar.DATE, day);
//
//        Date date = calendar.getTime();
//        DateFormat df = new SimpleDateFormat("EEEE");
//        return df.format(date);

    }
    //calDate cannot be resolvedJava(570425394)
}



