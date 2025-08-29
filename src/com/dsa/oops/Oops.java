package com.dsa.oops;

class Animal{
    String name;
    String breed;
    String colour;
    int age;
}

class Person{
    String name;
    String nationality;
    String weight;
    int age;
}

public class Oops {
    public static void main(String[] args) {
        Animal dog = new Animal();
        dog.name = "Rocky";
        dog.colour = "Brown";
        dog.breed = "German Sheperd";
        dog.age = 12;
        System.out.println(dog.name);
    }
}
