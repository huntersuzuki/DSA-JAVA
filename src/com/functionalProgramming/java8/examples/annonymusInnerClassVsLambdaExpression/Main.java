package com.functionalProgramming.java8.examples.annonymusInnerClassVsLambdaExpression;

public class Main {
    public static void main(String[] args) {
        // This a more traditional way to implement methods from the interface.
//        Employee employee = new SoftwareEngineer();
        // We will use annonymus inner class to do the same.
        Employee employee = new Employee() {
            @Override
            public String getSalary() {
                return "79900";
            }

            @Override
            public String getDesignation() {
                return "Software Engineer";
            }
        };
        System.out.println(employee.getSalary());
    }
}
