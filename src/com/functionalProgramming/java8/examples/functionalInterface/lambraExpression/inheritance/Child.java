package com.functionalProgramming.java8.examples.functionalInterface.lambraExpression.inheritance;

@FunctionalInterface
public interface Child extends Parent{
    // Now here even though we do not have ny abstract methods, we don't get an error.
    // Because the child extending the parent interface has an abstract method.
    // Thus, this interface is also a functional interface.

    // Now that we added a new abstract class the interface is throwing an error.
    // because we already have an abstract method extending/inheriting from the parent.
//    public void sayBye();

    // Now if I define the same abstract method in the child,
    // it will still be a functional interface.
    public void sayHello();
}
