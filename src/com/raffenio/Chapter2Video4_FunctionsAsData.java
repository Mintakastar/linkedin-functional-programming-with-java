package com.raffenio;

import com.raffenio.functions.NoArgFunction;
import com.raffenio.functions.TriFunction;

import java.util.function.BiFunction;

public class Chapter2Video4_FunctionsAsData {

    protected static class Person{
        private String name;
        private Integer age;
        public Person(String name , Integer age){
            this.name = name;
            this.age = age;
        }
    }

    protected static class DataLoader{

        public final NoArgFunction<Person> loadPerson;

        public DataLoader(boolean isDevelopment){
           this.loadPerson = isDevelopment ? this::loadPersonFake : this::loadPersonReal;
        }

        private Person loadPersonReal(){
            System.out.println("Loading person");
            return new Person("Real Person",30);
        }
        private Person loadPersonFake(){
            System.out.println("Returning person fake Object");
            return new Person("Fake Person",300);
        }
    }

    public static void main(String[] args) {
        /**
         * This is related to FUNCTIONS AS DATA
         */

        //load data from a server....
        final Boolean IS_DEVELOPMENT = true;

        DataLoader dataloader = new DataLoader(IS_DEVELOPMENT);
        System.out.println(dataloader.loadPerson.apply());


        DataLoader dataloaderFalse = new DataLoader(false);
        System.out.println(dataloaderFalse.loadPerson.apply());



    }
}
