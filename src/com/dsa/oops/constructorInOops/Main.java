package com.dsa.oops.constructorInOops;

class Person{
    String name;
    int age;

    Person(String name){
        System.out.println("Calling with name");
        this.name = name;
    }
    Person(){
        System.out.println("Calling without name");
    }

    void speak(String text){
        System.out.println(name+" : "+text);
    }

    void walk(){
        System.out.println(name+" is able to walk !!");
    }
}

public class Main {
    public static void main(String[] args) {
        Person pranay = new Person();
        System.out.println(pranay.name);
        Person manisha = new Person("Manisha");
        System.out.println(manisha.name);

    }
}
