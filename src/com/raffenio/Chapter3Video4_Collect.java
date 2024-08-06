package com.raffenio;


import java.text.CollationElementIterator;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Chapter3Video4_Collect {
    public static void main(String[] args) {
        /*
         * collect
         *  transform the stream back into a collection
         *
         * */


        //having  a list of integer, create a list of even numbers

        Integer[] list = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> listOfIntegers =new ArrayList<>(Arrays.asList(list));
        String[] wordArr = {"hello", "functional", "programming", "is", "cool", "programming",};
        List<String> wordList = new ArrayList<>(Arrays.asList(wordArr));



        List<String> longWords  = wordList
                .stream()
                .filter(word -> word.length()>5)
                .toList();
        System.out.println("list " + longWords); //this allows duplicates

        Set<String> longWordsSet  = wordList
                .stream()
                .filter(word -> word.length()>5)
                .collect(Collectors.toSet());
        System.out.println("set. " + longWordsSet);  // in this way duplicated are not returned


        String oneElement  = wordList
                .stream()
                .filter(word -> word.length()>5)
                .collect(Collectors.joining("', '"));
        System.out.println("one element, separated with delimiter::: " + oneElement); //this allows duplicates


        long count  = wordList
                .stream()
                .filter(word -> word.length()>5)
                .collect(Collectors.counting());
        System.out.println("count: " + count); //this allows duplicates





        //group by length  //it will return a map with many groups based on the parameter/ validattion done
        String[] wordArrGroup = {"hello","main","happy",  "functional", "programming", "is", "cool", "programming",};
        List<String> wordListGroup = new ArrayList<>(Arrays.asList(wordArr));

        Map<Integer,List<String>> wordsMappedByLength =
                wordListGroup
                        .stream()
                        .collect(Collectors.groupingBy((word)->word.length()));

        System.out.println(wordsMappedByLength);

        //partitionin by it will return a map with 2 groups, true/false, based on the PREDICATE

        Map<Boolean,List<String>> wordsPartitioneddBy =
                wordListGroup
                        .stream()
                        .collect(Collectors.partitioningBy((word)->word.length()>5));

        System.out.println(wordsPartitioneddBy);
    }
}
