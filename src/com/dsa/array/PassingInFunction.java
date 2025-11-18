package com.dsa.array;

import java.util.Arrays;

public class PassingInFunction {
    public static void main(String[] args) {
        // nums is pointing towards the value in the heap memory.
        // nums ---> [10,66,89,4]
        int[] nums = {10,66,89,4};
        System.out.println(Arrays.toString(nums));
        // Here the nums array is passed to the function change(),
        // and the variable arr is also pointing towards,
        // [10,66,89,4].
        // so when arr[0] = 99, it changes the original array,
        // because both nums and arr are pointing towards the same value,
        // in the heap memory.
        // nums --->[10,66,89,4]<--- arr
        change(nums);
        System.out.println(Arrays.toString(nums));
    }
// Arrays are mutable in java.
    // mutable means their value can be changes.
    static void change(int[] arr){
        // Here arr is also pointing towards the
        // values in the heap memory
        // arr ---> [10,66,89,4]
        arr[0] = 99;
    }
}
