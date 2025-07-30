package com.dsa.loops;

import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        // For loop :
//        for(int i = 1; i <= 1000; i ++){
//            System.out.println(i+" I am sorry");
//        }
        Scanner sc = new Scanner(System.in);
        System.out.println("To exit press 0");
        int num = sc.nextInt();
        // While Loop :
//        while (num != 0){
//            System.out.println("You have entered: "+num);
//            System.out.print("Enter again: ");
//            num = sc.nextInt();
//        }
//        System.out.println("Finished");
    // Do-while Loop :
    do{
        System.out.println("You have entered: "+num);
            System.out.print("Enter again: ");
            num = sc.nextInt();
    }while(num !=0);
        System.out.println("Finished");
    }
}
