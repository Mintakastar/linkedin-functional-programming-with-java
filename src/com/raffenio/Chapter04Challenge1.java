package com.raffenio;


// Java code below
// Write your answer here, and then test your code.
// Your job is to implement the findLargest() method.

import java.util.Arrays;
import java.util.function.Function;
import java.util.*;
import java.util.stream.IntStream;


class Chapter04Challenge1 {

    // Change these boolean values to control whether you see
    // the expected result and/or hints.
    static boolean showExpectedResult = true;
    static boolean showHints = true;

    // Return the largest number in the 'numbers' array
    static int getIndexOfLargest(int[] numbers) {
        // Your code goes here.

        List<Integer> list= new ArrayList( Arrays.asList(numbers));

        //one way, using
        // mapToInt then Max method
        //You may either convert the stream to IntStream:
  /*        OptionalInt max= list
          .stream()
          .mapToInt(Integer::intValue)
          .max();
        return max.getAsInt(); //failed ?
*/

        //Or specify the natural order comparator:
          /*Optional<Integer> max2 = list
          .stream()
          .max(Comparator.naturalOrder());
        return max2.get().intValue();
        *///fails?

         /*Optional<Integer> max = list.stream().reduce(Integer::max);

        return max.get().intValue();*/
        /*
        int max = Integer.MIN_VALUE;
        int maxIndex=-1;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]>max){
                max = numbers[i];
                maxIndex=i;
            }

        }
        return maxIndex;*/


        //from the Video
        //recorre todo el stream, ahora de enteros
        //y hace un reduce, comparando los numeros y lo que regresa seria el index mayo
        // si no lo encuentra, regresa -1
        return IntStream.range(0,numbers.length)
                .reduce((i,j)->numbers[i]>=numbers[j]?i:j)
                .orElse(-1);

    }

    static int countLetters(String s) {
        return s.length();
    }

    static String getByIndex(String[] strings, int index) {
        return strings[index];
    }

    static String getLongestWord(String[] strings) {
        return getByIndex(
                strings,
                getIndexOfLargest(Arrays.stream(strings).mapToInt(Chapter04Challenge1::countLetters).toArray())
                );
    }

    public static void main(String[] args) {
        // This is how your code will be called.
// Your answer should be the largest value in the numbers array.
// You can edit this code to try different testing cases.
        int[] numbers = { 7, 17, 13, 19, 5 };
        String[] words = {
                "apple", "banana", "cherry",
                "date", "fig", "grape",
                "kiwi", "lemon", "mango"
        };
        String s = "Hello composition";
        int index = 3;

        int indexOfLargestNumber = Chapter04Challenge1.getIndexOfLargest(numbers);
        System.out.println("indexOfLargestNumber: "+indexOfLargestNumber);
        int numLetters = Chapter04Challenge1.countLetters(s);
        System.out.println("numLetters: "+numLetters);
        String aWord = Chapter04Challenge1.getByIndex(words, index);
        System.out.println("aWord: "+aWord);
        String compositionResult = Chapter04Challenge1.getLongestWord(words);

        System.out.println("compositionResult: "+compositionResult);


        /*
         * Expected result for getIndexOfLargest: 3
         * Expected result for countLetters: 17
         * Expected result for getByIndex: date
         * Expected result for getLongestWord: banana
         * Hint: The nice part about composition is that you can pay attention to implementing just one thing at a time.
         * */
    }

}
