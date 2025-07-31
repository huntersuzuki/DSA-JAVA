package com.functionalProgramming.java8.examples.functionalInterface.lambraExpression;

public class MyInterfaceImpl{
    public static void main(String[] args) {
        MyInterface m = () -> System.out.println("Hello from lambda MyInterface");
        m.sayHello();
    }

}
