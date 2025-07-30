package com.dsa.conditionals;

public class Conditionals {
    public static void main(String[] args) {
        int age = 16;
//
                if(age < 13){
                    System.out.println("You are a child");
                }else if(age >= 13 && age <=19){
                    System.out.println("You are a teen");
                } else if (age >=20 && age <=50) {
                    System.out.println("You are a adult");
                }else{
                    System.out.println("You are not Old");
                }


    }
}
