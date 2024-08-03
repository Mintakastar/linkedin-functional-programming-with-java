package com.raffenio;


import com.raffenio.functions.NoArgFunction;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Chapter2Video8_HigherOrderFunctions {
    public static void main(String[] args) {
        /*
         * Higher-Order functions,
         *   are functions that takes functions as parameters and returns functions
         * */

        //create a divider funcion:
        BiFunction<Float, Float, Float> divide = (x, y) -> x / y;

        System.out.println(divide.apply(10f, 5f));//returns 2
        try {
            System.out.println(divide.apply(10f, 0f));//error
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }


        System.out.println("\n\n");


        //create a divider function validating the y arg
        BiFunction<Float, Float, Float> divideSaveHardCode = (x, y) -> {
            if (y == 0f) {
                System.out.println("Zero Value");

                return 0f;
            }
            return x / y;
        };

        System.out.println(divideSaveHardCode.apply(10f, 5f));//returns 2
        System.out.println(divideSaveHardCode.apply(10f, 0f));//error


        System.out.println("\n\n");

        //create a function that , takes a function and validate its paramters

        Function<
                BiFunction<Float, Float, Float>,  //receives a bi function
                BiFunction<Float, Float, Float>   //and returns a bi function
                > divideZeroArgCheck =
                (func)->  //receives a bi function
                        (x,y)->{//and returns a bi function
                            if (y == 0f) {
                                System.out.println("Zero Value");
                                return 0f;
                            }
                            return func.apply(x,y);
                        }
                ;

        BiFunction<Float, Float, Float> divideSafe = divideZeroArgCheck.apply(divide);


        System.out.println(divideSafe.apply(10f, 5f));//returns 2
        System.out.println(divideSafe.apply(10f, 0f));//0



    }
}
