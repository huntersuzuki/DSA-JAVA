package com.dsa.array;

/**
 * This class demonstrates how to find the maximum value in an array
 * and within a specific range of the array.
 */
public class MaxItem {
    public static void main(String[] args) {
        // Initialize an array of integers
        int[] arr = {1, 8, 5, 7, 3, 99};
        
        // Find and print the maximum value in the entire array
        System.out.println("Max value in the Array list: " + max(arr));
        
        // Find and print the maximum value in a specific range (from index 1 to 4)
        // Note: The end index is exclusive in maxInRange method
        System.out.println("Max value in range of Array list: " + maxInRange(arr, 1, 4));
    }

    /**
     * Finds the maximum value in the entire array.
     * 
     * @param arr The input array of integers
     * @return The maximum value found in the array
     */
    static int max(int[] arr) {
        // Initialize maxVal with the first element of the array
        int maxVal = arr[0];
        
        // Iterate through each element of the array
        for (int i = 1; i < arr.length; i++) {
            // If current element is greater than maxVal, update maxVal
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }
        return maxVal;
    }
    /**
     * Finds the maximum value in a specific range of the array.
     * 
     * @param arr The input array of integers
     * @param start The starting index (inclusive) of the range
     * @param end The ending index (exclusive) of the range
     * @return The maximum value found in the specified range
     * @throws IllegalArgumentException if start is greater than or equal to end
     * @throws ArrayIndexOutOfBoundsException if start or end are out of array bounds
     */
    static int maxInRange(int[] arr, int start, int end) {
        // Input validation
        if (start >= end) {
            throw new IllegalArgumentException("Start index must be less than end index");
        }
        if (start < 0 || end > arr.length) {
            throw new ArrayIndexOutOfBoundsException("Indices out of array bounds");
        }
        
        // Initialize maxVal with the first element in the range
        int maxVal = arr[start];
        
        // Iterate through the specified range
        for (int i = start + 1; i < end; i++) {
            // If current element is greater than maxVal, update maxVal
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }
        return maxVal;
    }
}
