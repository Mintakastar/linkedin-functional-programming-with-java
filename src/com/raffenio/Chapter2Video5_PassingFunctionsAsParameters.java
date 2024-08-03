package com.raffenio;

import com.raffenio.functions.NoArgFunction;

import java.nio.channels.NotYetBoundException;
import java.util.function.BiFunction;

public class Chapter2Video5_PassingFunctionsAsParameters {

    protected static class MyMath{
        public static Integer add(Integer x, Integer y){
            return x+y;
        }
        public static Integer substract(Integer x, Integer y){
            return x-y;
        }

        public static Integer combine2And3(BiFunction<Integer,Integer,Integer> combineFunc){
            return combineFunc.apply(2,3); //accepts 2 integer
        }
    }

    public static void main(String[] args) {
        System.out.println(MyMath.add(5,5));
        System.out.println(MyMath.substract(15,5));

        System.out.println(MyMath.combine2And3(MyMath::add));
        System.out.println(MyMath.combine2And3(MyMath::substract));

        System.out.println(MyMath.combine2And3((x,y)-> x*2 + y*2 ));


    }


}
