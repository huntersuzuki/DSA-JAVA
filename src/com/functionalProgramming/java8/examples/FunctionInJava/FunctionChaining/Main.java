package com.functionalProgramming.java8.examples.FunctionInJava.FunctionChaining;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // Example of function chaining.
        Function<String,String> function1 = s -> s.toUpperCase();
        Function<String,String> function2 = s -> s.substring(0,3);
        Function<String,String> result = function1.andThen(function2);
        System.out.println(result.apply("Pranay"));

    }
}
