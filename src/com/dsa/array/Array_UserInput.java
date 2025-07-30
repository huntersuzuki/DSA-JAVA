package com.dsa.array;

import java.util.Scanner;

public class Array_UserInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr;
        int x;
        System.out.print("Enter the Size of the Array: ");
        x = sc.nextInt();
        arr = new int[x];
        for (int i=0;i<x;i++){
            arr[i] = sc.nextInt();
        }
//        System.out.println(com.dsa.array.Arrays.toString(arr));

        for (int j = 0; j < x; j++) {
            System.out.print(arr[j] + " ");
        }
    }
}
