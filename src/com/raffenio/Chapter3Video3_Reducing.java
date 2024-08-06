package com.raffenio;


import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Chapter3Video3_Reducing {
    public static void main(String[] args) {
        /*
         * reduce
         *   it works with binary operator   BinaryOperator<T>
         *   it takes 2 values if the same type, and returns one value of the same type
         *
         *  the 2 parameters are the accumulator and the curren value
         * the accumulator can be set with an initial value
         *
         * reduce( binaryOperator )           -> returns an Optional<T>  , because we are not sure if it will return something
         * reduce( initial, binaryOperator )  -> returns a value itself  , if it does not process anything , it will return at least the initial value.
         * */


        //having  a list of integer, create a list of even numbers

        Integer[] list = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> listOfIntegers =new ArrayList<>(Arrays.asList(list));

        //get the sum of all integers

        BinaryOperator<Integer> sumAll= (acc, x) -> acc + x;  //compact way

        BinaryOperator<Integer> sumAllExplained= (acc, x) -> {
            Integer result = acc + x;
            System.out.println("acc : "+acc+", value: "+x +" result: "+result);
            return result;

        };  //explaining what it does

        Integer sum = listOfIntegers.stream().reduce(0,sumAll);
        Optional<Integer> sumOptional = listOfIntegers.stream().reduce(sumAll);

        System.out.println(sum);
        System.out.println(sumOptional.get());

        System.out.println("\n\n");
        Integer sumExplained = listOfIntegers.stream().reduce(0,sumAllExplained);
        Optional<Integer> sumOptionalExplained = listOfIntegers.stream().reduce(sumAllExplained);

        System.out.println(sumExplained);
        System.out.println(sumOptionalExplained.get());



        //calculate the average?
        int numbersOfElements = listOfIntegers.size();

        //sum of all numbers divided by the numbers of elements
        float average = (float)listOfIntegers.stream().reduce(0,(acc,x)->acc+x)/numbersOfElements;
        System.out.println("\n\nThis is the average "+average);



    }
}
