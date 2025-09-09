package com.functionalProgramming.java8.examples.FunctionInJava.BiFunction;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<String ,Integer > function = str -> str.length();
        System.out.println(function.apply("Pranay"));
        BiFunction<String ,String ,Integer> biFunction = (str1,str2) -> {
          String str3 = str1+str2;
          return str3.length();
        };
        System.out.println(biFunction.apply("Pranay","Bhoir"));

    }
}
