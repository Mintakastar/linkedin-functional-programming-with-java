package com.raffenio;


import com.raffenio.functions.NoArgFunction;

import java.util.function.Function;

public class Chapter2Video7_Closure {
    public static void main(String[] args) {
        /*
        * Closure,
        *   When we have a function A, that returns a function B
        *   This function B, has access to the scope of the function A.
        *   (its variables values)
        * */

        //create a function that returns a function that returns a string
        //these functions does not receive any value

        //example with no variable
        NoArgFunction<NoArgFunction<String>> createGreeterTest =
                ()->
                        ()-> "Hello Rafa";

        NoArgFunction<String> greeterTest = createGreeterTest.apply();
        System.out.println(greeterTest.apply());



        //example with inner variable
        NoArgFunction<NoArgFunction<String>> createGreeter =
                ()->{
                    String name= "Rafael";
                    return       ()-> "Hello "+name;
                };

        NoArgFunction<String> greeter = createGreeter.apply();
        System.out.println(greeter.apply());


        //example sending a variable from outside
        Function<String,NoArgFunction<String>> createGreeterWithName =
                (String name)->{
                    return       ()-> "Hello "+name;
                };

        NoArgFunction<String> greeterRafita = createGreeterWithName.apply("Rafita");
        NoArgFunction<String> greeterGoku = createGreeterWithName.apply("Goku");
        System.out.println(greeterRafita.apply());
        System.out.println(greeterGoku.apply());



    }
}
