package com.raffenio;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Chapter3Challenge_appliyingStreams {


    // Return the largest number in the 'numbers' array
    static List<String> filterAndTransform(List<Integer> numbers) {
        List<String> numbersWords =
                numbers.stream()
                        .filter(num->num%3==0)
                        .map(
                                (numb)->{

                                    switch (numb){
                                        case 1: return "one";
                                        case 2: return "two";
                                        case 3: return "three";
                                        case 4: return "four";
                                        case 5: return "five";
                                        case 6: return "six";
                                        case 7: return "seven";
                                        case 8: return "eigth";
                                        case 9: return "nine";
                                        case 0: return "zero";
                                        default: return "?";
                                    }

                                }).toList();

        // Your code goes here
        return numbersWords;
    }




    // Return the largest number in the 'numbers' array
    static List<String> filterAndTransformVideoSolution(List<Integer> numbers) {

        String[] numberNames = { "zero","one","two","three","four","five","six","seven","eigth","nine"};
        List<String> numbersNamesList = new ArrayList<>(Arrays.asList(numberNames));

        return numbers.stream()
                .filter(x->x%3==0)
                .map(x->numberNames[x])
                .toList();


    }
    public static void main(String[] args) {

// This is how your code will be called.
// Your answer should be the largest value in the numbers array.
// You can edit this code to try different testing cases.
        Integer[] numbersArr = { 1, 5, 3, 6, 8, 9, 2 };
        List<Integer> numbers = new ArrayList<>(Arrays.asList(numbersArr));
        List<String> result = Chapter3Challenge_appliyingStreams.filterAndTransform(numbers);

        System.out.println(numbers);
        System.out.println(result);




        result = Chapter3Challenge_appliyingStreams.filterAndTransformVideoSolution(numbers);

        System.out.println(numbers);
        System.out.println(result);


    }
}
