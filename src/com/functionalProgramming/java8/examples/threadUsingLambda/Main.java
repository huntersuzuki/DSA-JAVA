package com.functionalProgramming.java8.examples.threadUsingLambda;

public class Main {
    public static void main(String[] args) {

//    MyClass myClass = new MyClass();
//    Thread thread = new Thread(myClass);
//    thread.run();
        // Creating thread using lambda expression.
        Runnable runnable = () -> {
            for (int i = 1; i <= 10 ; i++) {
                System.out.println("Hello "+i);
            }
        };
        Thread thread = new Thread(runnable);
        thread.run();
    }
}
