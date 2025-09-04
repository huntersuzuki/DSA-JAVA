package com.functionalProgramming.java8.examples.comparatorsUsingLambdaExpression;

import java.util.Comparator;

public class MyClass implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        return a-b;
    }
}
