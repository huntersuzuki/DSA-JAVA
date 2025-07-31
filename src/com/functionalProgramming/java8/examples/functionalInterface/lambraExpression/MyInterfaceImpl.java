package com.functionalProgramming.java8.examples.functionalInterface.lambraExpression;

public class MyInterfaceImpl{
    public static void main(String[] args) {
        MyInterface m = () -> "Hello from lambda MyInterface";
        System.out.println(m.sayHello());;
    }

}
