package com.functionalProgramming.java8.examples.predicatesInJava;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> salaryGreaterThanOneLac = (x) -> {
            return x > 100000;
        };
        System.out.println(salaryGreaterThanOneLac.test(1000000));
    }
}
