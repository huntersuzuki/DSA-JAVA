package com.functionalProgramming.java8.examples.FunctionInJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<String,Integer> getLength = (x) -> {
            return x.length();
        };
        Function<String,String> getFirstThreeLettersOfTheString = (x) -> {
            return x.substring(0,3);
        };
        Function<List<Student>,List<Student>> studentsWithPraAsPrefix = (li) -> {
          List<Student> result = new ArrayList<>();
          for (Student s : li){
              if (getFirstThreeLettersOfTheString.apply(s.getName()).equalsIgnoreCase("pra")){
                  result.add(s);
              }
          }
          return result;
        };
        Student s1 = new Student(1,"Pranay");
        Student s2 = new Student(2,"Prahalad");
        Student s3 = new Student(1,"Advik");
        List<Student> studentList = Arrays.asList(s1,s2,s3);
        System.out.println(studentsWithPraAsPrefix.apply(studentList));
        System.out.println(getLength.apply("Pranay"));
        System.out.println(getFirstThreeLettersOfTheString.apply("Pranay"));

    }
    private static class Student{
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
