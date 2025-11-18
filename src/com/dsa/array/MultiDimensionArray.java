package com.dsa.array;

import java.util.Arrays;
import java.util.Scanner;

public class MultiDimensionArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[3][3];

        // we will take the input of the 2D Array.
        // for each row we will iterate.
        for (int row = 0; row < arr.length; row++) {
            //for each row's column we will iterate
            for (int col = 0; col < arr[row].length; col++) {
                arr[row][col] = sc.nextInt();
//                System.out.print( arr[row][col] + " ");
            }
//            System.out.println();
        }

        // Doing the same operation using enhanced for loop.

        for (int[] a : arr){
            System.out.println(Arrays.toString(a));
        }
    }
}
