package com.functionalProgramming.java8.examples.functionalInterface.lambraExpression;

public class MyInterfaceImpl{
    public static void main(String[] args) {
        MyInterface m = () -> "Hello from lambda MyInterface";
        System.out.println(m.sayHello());
        // Because of lambda expression we don't have to create a separate implementation class
        // And we can implement the same abstract method multiple times.
        // Example -
        MyInterface mi = () -> "Hello guys how are you";
        System.out.println(mi.sayHello());
        // Output -
        // Hello from lambda MyInterface
        // Hello guys how are you
    }

}
