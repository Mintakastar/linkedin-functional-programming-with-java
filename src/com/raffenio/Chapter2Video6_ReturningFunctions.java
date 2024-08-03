package com.raffenio;

import com.raffenio.functions.NoArgFunction;

import java.util.function.Function;

public class Chapter2Video6_ReturningFunctions {

    protected static class MyMath   {
        public static Integer timesTwo(Integer x){
            return x*2;
        }
        public static Integer timesThree(Integer x){
            return x*3;
        }
        public static Integer timesFour(Integer x){
            return x*4;
        }

        public static Function<Integer,Integer> createMultiplier(Integer y/*multiplier*/){
            return (Integer x) -> x* y ;
        }
    }
    public static void main(String[] args) {
        //an example of how to return functions

        //let's create a functions with no arguments, that returns a function
        //                                            this function returned returns a string.

        NoArgFunction<NoArgFunction<String>> createGreeter = () -> () -> "Helllo Functional";

        NoArgFunction<String> greeter= createGreeter.apply();//this first function returns a function... that returns a string
        System.out.println(greeter.apply()); // this fucntions returns a string

        System.out.println(MyMath.timesTwo(2));
        System.out.println(MyMath.timesThree(2));
        System.out.println(MyMath.timesFour(2));

        Function<Integer,Integer> timesTwo=MyMath.createMultiplier(2);
        Function<Integer,Integer> timesThree=MyMath.createMultiplier(3);
        Function<Integer,Integer> timesFour=MyMath.createMultiplier(4);


        System.out.println(timesTwo.apply(2));
        System.out.println(timesThree.apply(2));
        System.out.println(timesFour.apply(2));


    }
}
