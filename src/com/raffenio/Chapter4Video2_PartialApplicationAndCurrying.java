package com.raffenio;


import com.raffenio.functions.TriFunction;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Chapter4Video2_PartialApplicationAndCurrying {
    public static void main(String[] args) {
        /*
         * partial application
         *   when you change in input parameter of a function to a fixed value, and used it into another function
         *      This is used to configure more general functions
         *      into a more specific function.
         * */

        //create a function with many input parameters, in this case 3 parameters
        //and will return only one value
        TriFunction<Integer,Integer,Integer,Integer> add = (x,y,z) -> x+y+z;

        //create a function, that will receive a value, (which will be replaced)
        //and will return a BiFunction ( a function with less parameters than the original one, in this case will receive 2 parameters )
        Function<Integer, BiFunction<Integer,Integer,Integer>> specificFunctionCreator=
                (x) -> { //we fixed the arguent x here
                   return (y,z)->add.apply(x,y,z); //this is closure
                 };

        BiFunction<Integer,Integer,Integer> add5 = specificFunctionCreator.apply(5);

        System.out.println(add5.apply(5,5)); //will print 15
        System.out.println(add5.apply(10,10)); //will print 25





        //Fix the first 2 paramters and have the last  one open
        BiFunction<Integer, Integer, Function<Integer,Integer>> specificFunctionCreator2=
                (x,y) -> { //we fixed the arguent x here
                    return (z)->add.apply(x,y,z); //this is closure
                };

        Function<Integer,Integer> add5And6 = specificFunctionCreator2.apply(5,6);

        System.out.println(add5And6.apply(5)); //will print 16
        System.out.println(add5And6.apply(10)); //will print 21



        //Fix the first 3 parameters //TODO
        Function<Integer,   Function<Integer,   Function<Integer,Integer>>> addPartialAll =  (x)->(y)->(z)->add.apply(x,y,z) ;  //this is carrying, pasing values from one funtion to another one,

                            Function<Integer,   Function<Integer,Integer>>          add_5 = addPartialAll.apply(5);

                                                 Function<Integer,Integer>      add_5And6 = add_5.apply(6);

                                                                              Integer sum = add_5And6.apply(7);

        System.out.println(sum); //will print 18




    }
}
