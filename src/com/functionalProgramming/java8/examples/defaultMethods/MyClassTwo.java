package com.functionalProgramming.java8.examples.defaultMethods;


interface A{
    default void sayHello(){
        System.out.println("Hello from interface A");
    }
}

interface B{
    default void sayHello(){
        System.out.println("Hello from interface B");
    }
}


public class MyClassTwo implements A,B {
//    public static void main(String[] args) {
//        // Now what happens here is the compiler
//        // doesn't know which method of the interface is being called
//        // It's either interface A or B.
//        // Thus, we get an error
//        MyClassTwo m = new MyClassTwo();
//        m.sayHello();
//
//    }
public static void main(String[] args) {
    MyClassTwo myClassTwo = new MyClassTwo();
    myClassTwo.sayHello();
}
// Here we have implemented and overridden the method of the interface,
// and then called the method of the interface using super keyword.
@Override
    public void sayHello(){
    A.super.sayHello();
    //    OR
    System.out.println("Hello from overridden method");
}
}
