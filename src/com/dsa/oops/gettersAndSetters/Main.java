package com.dsa.oops.gettersAndSetters;

class Person{
   private String name;
   private int age;

   void setName(String name){
       this.name = name;
   }
   String getName(){
       return this.name;
   }
   void setAge(int age){
       this.age = age;
   }
   int getAge(){
       return this.age;
   }
}

public class Main {
    public static void main(String[] args) {
        Person pranay = new Person();
        pranay.setName("Pranay Bhoir");
        pranay.setAge(24);
        System.out.println(pranay.getName());
        System.out.println(pranay.getAge());
    }
}
