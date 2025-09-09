package com.functionalProgramming.java8.examples.consumerInJava.BiConsumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Consumer<Integer> consumer = x -> System.out.println(x);
        consumer.accept(24);

        BiConsumer<Integer,Integer> biConsumer = (x,y) -> {
            System.out.println(x + y);
        };
        biConsumer.accept(20,90);
    }
}
