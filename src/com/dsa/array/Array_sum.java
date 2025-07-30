package com.dsa.array;

public class Array_sum {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 10, 4, 5, 3, 8, 10, 4, 7, 3};

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        System.out.println(sum);
    }
}
