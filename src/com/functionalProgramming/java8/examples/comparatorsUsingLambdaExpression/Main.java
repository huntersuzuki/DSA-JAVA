package com.functionalProgramming.java8.examples.comparatorsUsingLambdaExpression;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(55);
        list.add(23);
        list.add(89);
        list.add(199);
        list.add(51);
        // Sorting by implementing the function interface in the MyClass class.
        // This is a more traditional way.
//        Collections.sort(list,new MyClass());
        // Using the function interface method by lambda expression.
        Collections.sort(list,(a,b) -> b-a);
        System.out.println(list);

        Student student = new Student(1,"Pranay");
        Student student1 = new Student(22,"Manisha");
        Student student2 = new Student(67,"Aditi");
        Student student3 = new Student(7,"Rudra");

        List<Student> list1 = new ArrayList<Student>();
        list1.add(student);
        list1.add(student1);
        list1.add(student2);
        list1.add(student3);
        Collections.sort(list1,(a,b) -> b.id - a.id);
        System.out.println(list1);
    }
}
