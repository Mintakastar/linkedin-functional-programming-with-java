package com.raffenio;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Chapter3Video7_CombineListFunctions {
    static class Person {
        public final String name;
        public final Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }

    static class Car {
        public final String make;
        public final String color;
        public final Float price;

        public Car(String make, String color, Float price) {
            this.make = make;
            this.color = color;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "make='" + make + '\'' +
                    ", color='" + color + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    static class Employee {
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

        Employee[] employeesArr = {
                new Employee("John", 34, "developer", 80000f),
                new Employee("Hannah", 24, "developer", 95000f),
                new Employee("Bart", 50, "sales executive", 100000f),
                new Employee("Sophie", 49, "construction worker", 40000f),
                new Employee("Darren", 38, "writer", 50000f),
                new Employee("Nancy", 29, "developer", 75000f),
        };
        List<Employee> employees = new ArrayList<>(Arrays.asList(employeesArr));

        //tomar el salario de todos los developers y el salario de non developers, y compoarar su average

        Float salaryDeveloper =
                employees.stream()
                        .filter(emp->emp.jobTitle.equals("developer"))
                        .map(dev->dev.salary)
                        .reduce(0f,(acc,x)->acc+x);
        Long countDeveloper =
                employees.stream()
                        .filter(emp->emp.jobTitle.equals("developer"))
                        .collect(Collectors.counting());

        Float developerAverage= salaryDeveloper/countDeveloper;

        System.out.println("Developer average: "+developerAverage);






        Float salaryNonDeveloper =
                employees.stream()
                        .filter(emp->!emp.jobTitle.equals("developer"))
                        .map(nondev->nondev.salary)
                        .reduce(0f,(acc,x)->acc+x);
        Long countNonDeveloper =
                employees.stream()
                        .filter(emp->!emp.jobTitle.equals("developer"))
                        .collect(Collectors.counting());

        Float developerNonAverage= salaryNonDeveloper/countNonDeveloper;

        System.out.println("Non Developer average: "+developerNonAverage);

    }
}
