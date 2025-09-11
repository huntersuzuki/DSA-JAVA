package com.functionalProgramming.java8.examples.UnaryAndBinaryOperator;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        Function<Integer,Integer> function1 = x -> x * x;
        Function<String ,String > function2 = str -> str.toLowerCase();

        // A unary operator is a special case of function.
        // we only have to give a single datatype and the return type and the argument type is automatically inferred.
        UnaryOperator<Integer> unaryOperator = x -> x * x;
        System.out.println(unaryOperator.apply(5));
    }
}
