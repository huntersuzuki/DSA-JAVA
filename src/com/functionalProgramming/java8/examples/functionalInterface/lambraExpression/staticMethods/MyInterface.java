package com.functionalProgramming.java8.examples.functionalInterface.lambraExpression.staticMethods;

// Here in java 8 we can write the main method in the interface.
// but the earlier version before java 8 does not support it,
// because from java 8 static methods in interface is supported.
public interface MyInterface {
    public static void main(String[] args) {
        System.out.println("Hello from interface");
    }
}
