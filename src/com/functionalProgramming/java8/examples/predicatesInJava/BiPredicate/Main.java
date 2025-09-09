package com.functionalProgramming.java8.examples.predicatesInJava.BiPredicate;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // Normal predicate function.
        // Only takes a single argument.
        Predicate<Integer> normalPredicate = x -> x % 2 == 0;
        // Bipredicate function
        // It takes two arguments.
        BiPredicate<Integer,Integer> biPredicate= (x,y) -> {
         return x % 2 == 0 && y % 2 ==0;
        };
        System.out.println(biPredicate.test(2,5));
    }
}
