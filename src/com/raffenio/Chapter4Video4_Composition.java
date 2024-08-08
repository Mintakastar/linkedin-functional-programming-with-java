package com.raffenio;


import com.raffenio.functions.TriFunction;

import javax.print.attribute.standard.PresentationDirection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Chapter4Video4_Composition {
    protected static class Employee {
        public final String name;
        public final Integer age;
        public final String jobTitle;
        public final Float salary;

        public Employee(String name, Integer age, String jobTitle, Float salary) {
            this.name = name;
            this.age = age;
            this.jobTitle = jobTitle;
            this.salary = salary;
        }
    }

    public static void main(String[] args) {
        /*
         * composition
         *   take some small functions, and create a more complex one combining them
         *   using "compose" method
         *   using "andThen" method
         *   this will work as long as the result of the function satisfies the parameter of the next function
         * */

        //function that multiplies by 2
        Function<Integer,Integer> timesTwo = x -> x*2;

        //function that subtract one
        Function<Integer,Integer> minusOne = x -> x-1 ;

        //combine these two function using "compose"
        //The function that is added, is the one that is executed first
        Function<Integer,Integer> minusOneAndTimesTwo = timesTwo.compose(minusOne);

        //input 10
        //10 - 1  = 9     // this minus one function is executed first
        // 9 * 2  = 18    // this times two function is executed at the end.
        System.out.println(minusOneAndTimesTwo.apply(10));


        //combine these two function using "andThen"
        //which execute the functions in the order of appearance
        Function<Integer,Integer> timesTwoAndMinusOne = timesTwo.andThen(minusOne);

        //input 10
        //10 * 2  = 20    // this times two function is executed first
        //20 - 1  = 19     // this minus one function is executed after times two , as the chain of execution says
        System.out.println(timesTwoAndMinusOne.apply(10));



        Employee[] employeesArr = {
                new Employee("John", 34, "developer", 80000f),
                new Employee("Hannah", 24, "developer", 95000f),
                new Employee("Bart", 50, "sales executive", 100000f),
                new Employee("Sophie", 49, "construction worker", 40000f),
                new Employee("Darren", 38, "writer", 50000f),
                new Employee("Nancy", 29, "developer", 75000f),
        };
        List<Employee> employees = new ArrayList<>(Arrays.asList(employeesArr));

        //task get all the employees names, reversed, and upper cased

        //create different functions for each step
        Function<Employee,String> getName = emp -> emp.name ;
        Function<String,String> reverse = name -> new StringBuilder(name).reverse().toString();
        Function<String,String> upperCase = name -> name.toUpperCase();

        //compose a more complex function based on this steps
        Function<Employee,String> getReversedUpperCasedName = getName.andThen(reverse).andThen(upperCase);

        //use the more complex functino into an stream
        List<String> result  = employees
                .stream()
                .map(getReversedUpperCasedName)
                .toList();
        System.out.println(result);

        //output: [NHOJ, HANNAH, TRAB, EIHPOS, NERRAD, YCNAN]




    }
}
