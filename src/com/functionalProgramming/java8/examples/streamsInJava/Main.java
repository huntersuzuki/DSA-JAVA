package com.functionalProgramming.java8.examples.streamsInJava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main{
    public static void main(String[] args) {
        List<String > list = Arrays.asList("Apple","Banana","Strawberry");
         Stream<String> stream = list.stream();

         String[] array = {"Apple","Banana","Strawberry"};
         Stream<String > myStream = Arrays.stream(array);

         // Method fo creating a stream directly.
        Stream<Integer> integerStream = Stream.of(1,2,3,4,5);

        Stream<Integer> limitString = Stream.iterate(0,n -> n + 1).limit(100);

        Stream<Integer> randomStream = Stream.generate(() -> (int) (Math.random() * 100)).limit(5);

    }
}
