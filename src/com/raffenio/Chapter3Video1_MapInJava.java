package com.raffenio;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Chapter3Video1_MapInJava {
    public static void main(String[] args) {
        /*
         * Mapping with streams
         *   convert one list of certain type to another, o do some processing on it.
         * */

        //have a list of int , and create a new list of doubled those ints

        Integer[] list = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> listOfIntegers =new ArrayList<>(Arrays.asList(list));

        //first old aproach
        List<Integer> doubledFirstAproach = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            doubledFirstAproach.add(list[i]*2);
        }
        System.out.println(doubledFirstAproach);

        //second way of doing it, using lamdas
        Function<Integer,Integer> timesTwo = ( x ) -> x * 2 ;

        List<Integer> doubledSecondAproach = Arrays.stream(list)
                .map(timesTwo).toList();

        System.out.println(doubledSecondAproach);




    }
}
