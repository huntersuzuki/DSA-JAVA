package com.functionalProgramming.java8.examples.predicatesInJava;

import java.util.function.Predicate;

public class MainThree {
    public static void main(String[] args) {
        Predicate<String> startsWithLetterP = (x) -> {
            return x.toLowerCase().charAt(0) == 'p';
        };
        Predicate<String> endsWithLetterY = (x) -> {
          return x.toLowerCase().charAt(x.length()-1) == 'y';
        };
        Predicate<String> and = startsWithLetterP.and(endsWithLetterY);
        Predicate<String> or = startsWithLetterP.or(endsWithLetterY);
        Predicate<String> negate = startsWithLetterP.negate();
        System.out.println("AND method in predicate : " + and.test("pranay"));
        System.out.println("OR method in predicate : " + or.test("pranay"));
        System.out.println("NEGATE method in predicate : " + negate.test("pranay"));

        Student student1 = new Student("Pranay",1);
        Student student2 = new Student("Manisha",3);
        Student student3 = new Student("Aditi",5);

        Predicate<Student> studentPredicate = (x) -> {
          return x.getId() > 1;
        };

        System.out.println("Student Predicate value : "+studentPredicate.test(student2));

        Predicate<String> isEqual = Predicate.isEqual("Pranay");
        System.out.println("IsEqual method of predicate : "+isEqual.test("Pranay"));
    }
}
