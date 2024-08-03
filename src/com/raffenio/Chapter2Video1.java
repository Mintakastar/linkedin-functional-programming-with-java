package com.raffenio;

import java.util.function.Function;

public class Chapter2Video1 {

    protected static class MyMath{
        public static Integer triple(Integer x){
            return x*3;
        }
    }
    public static void main(String[] args) {
        //        input     output
        Function<Integer, Integer> myTripple = MyMath::triple;

        Integer result = myTripple.apply(5);
        System.out.println(result);

        // README
        //a class method
        //cualquier metodo de una clase lo podemos pasar a una funcion
        //
        //una first class function, es basicamente una funcion que se puede pasar a una variable, se puede pasar como parametro a otras funciones,
        //osea un Function de java


        System.out.println("\nEjemplo ABS de math con una funcion (todos saldran positivos)");

        Function<Integer,Integer> myabs = Math::abs;   // el metodo estatico abc, lo pasamos a una variable del tipo de la interfaz funcion

        System.out.println(myabs.apply(-10));
        System.out.println(myabs.apply(-20));
        System.out.println(myabs.apply(-30));
        System.out.println(myabs.apply(40));


    }
}

