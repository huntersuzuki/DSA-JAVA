package com.functionalProgramming.java8.examples.staticMethods;

interface A{
    static void sayHello(){
        System.out.println("Hello");
    }

    default void sayBye(){
        System.out.println("Bye!!!");
    }
}

public class MyClass implements A {
    public static void main(String[] args) {
        MyClass m = new MyClass();
        // I am getting an error because we cannot access a static method
        // with a class object which implemented the interface.
//        m.sayHello(); // we get an error "Static method may only be called on its containing interface"
        // To access a static method in an interface.
        // we can access it as follows.
        A.sayHello(); // this is how we can access it.
        // We can access a default method with the class object
        // Example -
        m.sayBye();
    }
    // Now we also cannot override the static method of the interface.
    // Example -
    static void sayHello(){
        System.out.println("Hello there");
        // Here it might have been appearing as the static method inside the interface has been overridden,
        // but that is not the case because the implementation class (class which implemented the interface)
        // cannot see the static method inside the interface, so what we are doing here is basically,
        // creating our own method instead of overriding the interface method.
        // that's why we are not encountering any error.
    }
}
