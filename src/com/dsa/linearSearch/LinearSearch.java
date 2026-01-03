package com.dsa.linearSearch;

/**
 * This class demonstrates the implementation of a linear search algorithm.
 * Linear search is a simple searching algorithm that checks each element in the list
 * sequentially until it finds the target value or reaches the end of the list.
 */
public class LinearSearch {
    
    /**
     * The main method serves as the entry point of the program.
     * It initializes an array, defines a target value, and performs a linear search.
     * 
     * @param args Command line arguments (not used in this example)
     */
    public static void main(String[] args) {
        // Initialize an array of integers to search through
        int[] nums = {33, 52, 98, 2, 6, 30, 12, 789, 12, -99, -11, 34};
        
        // The value we want to find in the array
        int target = 3;
        
        // Call the linearSearch method and store the result
        int result = linearSearch(nums, target);
        
        // Print the result (-1 if not found, otherwise the index of the target)
        System.out.println("Search result: " + result);
    }

    /**
     * Performs a linear search on the given array to find the target value.
     * 
     * @param arr The array to be searched
     * @param target The value to find in the array
     * @return The index of the target if found, -1 otherwise
     * 
     * Time Complexity: O(n) - In the worst case, we might need to check each element once
     * Space Complexity: O(1) - Uses constant extra space
     */
    static int linearSearch(int[] arr, int target) {
        // Check if the array is empty
        if (arr.length == 0) {
            System.out.println("The provided array is empty");
            return -1;  // Return -1 to indicate the array is empty
        }

        // Iterate through each element in the array
        for (int i = 0; i < arr.length; i++) {
            // Get the current element
            int element = arr[i];
            
            // Check if the current element matches the target
            if (element == target) {
                System.out.println("Element found at index: " + i);
                return i;  // Return the index where the target was found
            }
        }
        
        // If we reach here, the target was not found in the array
        System.out.println("Element " + target + " not found in the array");
        return -1;  // Return -1 to indicate the target was not found
    }
}
