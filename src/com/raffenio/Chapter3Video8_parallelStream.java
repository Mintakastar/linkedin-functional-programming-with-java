package com.raffenio;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Chapter3Video8_parallelStream {
    public static void main(String[] args) {
        /*
         * parallel stream
         *   processes the data parallely instead of seqeuancilly
         *   the result is ordered
         * */


        //having  a list of integer, create a list of even numbers





        //example with strings
        String[] wordArr = {"hello", "functional", "programming", "is", "cool"};
        List<String> wordList = new ArrayList<>(Arrays.asList(wordArr));

        List<String> proccesedWords  = wordList
                .parallelStream()
                .map((word)->{
                    System.out.println("uppercasing "+word);
                    return word.toUpperCase();
                })
                .map((upperCasedWord)->{
                    System.out.println("adding ! to "+upperCasedWord);
                    return upperCasedWord+"!";
                })
                .toList();
        System.out.println(proccesedWords);





    }
}
