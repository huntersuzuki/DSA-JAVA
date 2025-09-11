package com.functionalProgramming.java8.examples.streamsInJava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainTwo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,4,3,7,10,99,44,77,44,77,22,87,345,567);
        List<Integer> filteredList = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println(filteredList);
        List<Integer> mappedList = filteredList
                .stream()
                .map(x -> x / 2)
                .distinct()
                .sorted((a,b) -> b - a)
                .limit(3)
                .skip(1)
                .collect(Collectors.toList());
        System.out.println(mappedList);

        Long integer = Long.valueOf(Stream.iterate(0, x -> x + 1)
                .limit(101)
                .map(x -> x / 10)
                .distinct()
                .skip(1)
                .peek(System.out::println)
                .max((a,b) -> a - b)
                .get());
    }
}
