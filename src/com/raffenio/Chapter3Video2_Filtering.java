package com.raffenio;


import java.beans.PropertyEditor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Chapter3Video2_Filtering {
    public static void main(String[] args) {
        /*
         * Filtering with streams
         *   it works with predicates
         *   it takes a value, does any validation, and returns a boolean value.
         * */


        //having  a list of integer, create a list of even numbers

        Integer[] list = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> listOfIntegers =new ArrayList<>(Arrays.asList(list));

        //first old approach
        List<Integer> evenFirstApproach = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            if(listOfIntegers.get(i)%2==0){
                evenFirstApproach.add(listOfIntegers.get(i));
            }
        }
        System.out.println(evenFirstApproach);

        //second way of doing it, using lamdas
        Predicate<Integer> isEven = ( x ) -> x % 2 == 0 ;

        List<Integer> evenSecondApproach = listOfIntegers
                .stream()
                .filter(isEven)
                .toList();

        System.out.println(evenSecondApproach);

        List<Integer> even3 = listOfIntegers
                .stream()
                .filter(  x  -> x % 2 == 0)  //instead of the predicate , we use the lamda expression inside directly / predicate
                .toList();

        System.out.println(even3);








        //example with strings
        String[] wordArr = {"hello", "functional", "programming", "is", "cool"};
        List<String> wordList = new ArrayList<>(Arrays.asList(wordArr));

        Predicate<String> moreThan5Long = (word) -> word.length()>5;

        List<String> longWords  = wordList
                .stream()
                .filter(moreThan5Long)
                .toList();
        System.out.println(longWords);




        //filter example with strings and high order function}
        Function<Integer, Predicate<String>> createLengthTest = (maxLength) -> {
            return (word) -> word.length() > maxLength;
        };

        Predicate<String> moreThan3 = createLengthTest.apply(3);
        Predicate<String> moreThan10 = createLengthTest.apply(10);

        List<String> moreThan3List = wordList.stream().filter(moreThan3).toList();
        List<String> moreThan10List = wordList.stream().filter(moreThan10).toList();
        System.out.println(moreThan3List);
        System.out.println(moreThan10List);





    }
}
