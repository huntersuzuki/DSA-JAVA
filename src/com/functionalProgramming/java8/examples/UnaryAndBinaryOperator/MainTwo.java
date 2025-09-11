package com.functionalProgramming.java8.examples.UnaryAndBinaryOperator;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class MainTwo {
    public static void main(String[] args) {
        BiFunction<String ,String ,String > biFunction = (str1,str2) -> str1 + str2;
        // binary operator extends BiFunction.
        BinaryOperator<String > binaryOperator = (str1,str2) -> str1 + str2;
        System.out.println(binaryOperator.apply("Pranay","Bhoir"));
    }
}
