package com.functionalProgramming.java8.examples.methodAndConstructorReference;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void print (String s){
        System.out.println(s);
    }
    public void hello (String s){
        System.out.println(s + " Says, hii everyone");
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Pranay","Rudra","Aditi","Sanika","Advik");
//        students.forEach(x -> System.out.println(students));
        // Method reference example.
        names.forEach(Main::print); // This is for a static method
//        students.forEach(Main:hello); // Getting error for a non-static method.
        // Solution
        Main main = new Main(); // Create an instance/object of a class.
        names.forEach(main::hello);
    // -----------------------------------------------------------------------------------------
        // Constructor reference example.
        List<Student> students = names.stream().map(Student::new).collect(Collectors.toList());

    }
}
