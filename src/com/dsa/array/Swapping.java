package com.dsa.array;

import java.util.Arrays;

/**
 * This class demonstrates array manipulation techniques including swapping elements and reversing an array.
 */
public class Swapping {
    public static void main(String[] args) {
        // Initialize an array of integers
        int[] arr = {1, 8, 5, 7, 3, 99};
        
        // Uncomment to test swapping two elements at specific indices
        // swap(arr, 1, 4); // This would swap elements at index 1 (8) and 4 (3)
        
        // Reverse the entire array
        reverse(arr);
        
        // Print the array after reversal
        System.out.println("Array after reversal: " + Arrays.toString(arr));
    }

    /**
     * Reverses the elements of the array in-place.
     * Uses two pointers (start and end) that move towards each other,
     * swapping elements until they meet in the middle.
     *
     * @param arr The array to be reversed
     */
    static void reverse(int[] arr) {
        int start = 0;                  // Pointer starting from the beginning
        int end = arr.length - 1;       // Pointer starting from the end

        while (start < end) {          // Continue until pointers meet or cross
            swap(arr, start, end);      // Swap elements at start and end indices
            start++;                    // Move start pointer right
            end--;                      // Move end pointer left
        }
    }

    /**
     * Swaps two elements in an array using a temporary variable.
     *
     * @param arr    The array containing elements to be swapped
     * @param index1 The index of the first element
     * @param index2 The index of the second element
     */
    static void swap(int[] arr, int index1, int index2) {
        // Store the value at index1 in a temporary variable
        int temp = arr[index1];
        // Assign the value at index2 to index1
        arr[index1] = arr[index2];
        // Assign the stored value (original index1) to index2
        arr[index2] = temp;
    }
}
