package com.dsa.linearSearch;

/**
 * This class provides a method to find the minimum number in an array.
 */
public class FindMinNum {

    /**
     * The main method serves as the entry point for the program.
     * It initializes an integer array and then calls the `minNum` method
     * to find and print the minimum element in that array.
     *
     * @param args Command line arguments (not used in this program).
     */
    public static void main(String[] args) { // Changed to public static void main
        int[] arr = {18, 12, -7, 3, 14, 28};
        // Calls the minNum method to find the minimum element
        // and prints the result to the console.
        System.out.println(minNum(arr));
    }

    /**
     * This method finds the minimum number in a given integer array.
     * It iterates through the array, comparing each element with the current
     * minimum value found so far, and updates the minimum if a smaller element is encountered.
     *
     * @param arr The input integer array from which to find the minimum number.
     * @return The minimum integer found in the array.
     */
    static int minNum(int[] arr) {
        // Initialize 'ans' with the first element of the array.
        // This assumes the array is not empty. If the array could be empty,
        // additional checks would be needed (e.g., throwing an exception or returning a sentinel value).
        int ans = arr[0];
        // Iterate through the array starting from the second element (index 1)
        // as the first element is already considered as the initial minimum.
        for (int i = 1; i < arr.length; i++) { // Start from i = 1
            if (arr[i] < ans) { // If the current element is smaller than the current minimum
                ans = arr[i];   // Update 'ans' to the new minimum
            }
        }
        return ans; // Return the smallest element found
    }
}
