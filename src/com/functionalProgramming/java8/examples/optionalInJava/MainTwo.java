package com.functionalProgramming.java8.examples.optionalInJava;

import java.util.Optional;

public class MainTwo {
    public static void main(String[] args) {
        Optional<String> name = getName(2);
        if (name.isPresent()) {
            System.out.println(name.get());
        }
        name.ifPresent(System.out::println);
    }
    public static Optional<String> getName(int id){
        String name = null;
        return Optional.ofNullable(name);
    }
}
