package com.functionalProgramming.java8.examples.functionalInterface.lambraExpression;


// A functional inter face is an interface which only has a single
// abstract method and can have multiple default or static method.
@FunctionalInterface // Annotation which tells the compiler that it's a functional interface.
public interface MyInterface {

     String sayHello(); // abstract method

    // A default method, but we still have a single abstract method.
    // Thus, this interface is still a functional interface.
    default void sayBye(){

    }

    // Now again a new static method is added but because we did not add an
    // abstract method and have only single abstract method
    // Thus, this interface is still a functional interface.
    public static void sayOk(){

    }
}
