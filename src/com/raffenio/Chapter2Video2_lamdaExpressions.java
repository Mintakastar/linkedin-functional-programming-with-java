package com.raffenio;

import java.awt.im.InputContext;
import java.util.function.Function;
public class Chapter2Video2_lamdaExpressions {
    public static void main(String[] args) {
        /**
         * This is related to lamdas expressions
         */

        //return the absolute value of an integer

        //oneLine
        Function<Integer, Integer> absoluteValueOneline =  (x)-> x<0? -x:x;

        //multiLine
        Function<Integer, Integer> absoluteValueMultiline =  (x)-> {
            if(x<0){
                return -x;
            }else{
                return x;
            }
        };

        System.out.println(absoluteValueOneline.apply(-10));
        System.out.println(absoluteValueOneline.apply(10));

        System.out.println(absoluteValueMultiline.apply(10));
        System.out.println(absoluteValueMultiline.apply(-10));

    }
}
