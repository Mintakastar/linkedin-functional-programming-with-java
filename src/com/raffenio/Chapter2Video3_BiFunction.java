package com.raffenio;

import com.raffenio.functions.NoArgFunction;
import com.raffenio.functions.TriFunction;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Chapter2Video3_BiFunction {
    public static void main(String[] args) {
        /**
         * This is related to bifuncion interface
         */

        //oneLine
        BiFunction<Integer, Integer, Integer> add =  (x,y)->x+y;
        System.out.println(add.apply(32,32)); //prints 64

        TriFunction<Integer,Integer,Integer,Integer> addThree = (x,y,z)-> x+y+z;
        System.out.println(addThree.apply(54,3,4)); //61

        NoArgFunction <String > sayHello = ()->"Hello!";
        System.out.println(sayHello.apply());//Hello!






    }
}
