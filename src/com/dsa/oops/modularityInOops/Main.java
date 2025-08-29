package com.dsa.oops.modularityInOops;

class Person{
    String name;
    int age;

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
        Person manisha = new Person();
        pranay.name = "Pranay";
        manisha.name = "Manisha";
        pranay.age = 24;
        pranay.speak("Hey I am learning Java DSA");
        manisha.speak("Oh wow that's great ");
        manisha.walk();
    }
}
