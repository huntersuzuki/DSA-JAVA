package com.dsa.BinarySearch;

import java.util.Scanner;

/*
 * This Java class demonstrates the implementation of the Binary Search algorithm.
 * Binary Search is an efficient algorithm for finding an item from a sorted list of items.
 * It works by repeatedly dividing in half the portion of the list that could contain the item,
 * until you've narrowed down the possible locations to just one.
 *
 * Key characteristics of Binary Search:
 * 1. The input array (or list) MUST be sorted.
 * 2. It has a time complexity of O(log n), which is significantly faster than linear search (O(n))
 *    for large datasets.
 * 3. It's a divide and conquer algorithm.
 */
public class BinarySearch {
    /*
     * The main method serves as the entry point for the program.
     * It initializes an array, prompts the user for a target value,
     * calls the binarySearch method, and prints the result.
     */
    public static void main(String[] args) { // Changed to public static void main to be a standard entry point
        Scanner sc = new Scanner(System.in);
        // Define a sorted array of integers. Binary Search requires the array to be sorted.
        int[] arr = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};

        // Prompt the user to enter the number they want to search for.
        System.out.println("Enter the number you want to search: ");
        // Read the integer input from the user.
        int target = sc.nextInt();

        // Call the binarySearch method to find the target in the array.
        // The method returns the index of the target if found, otherwise -1.
        int ans = binarySearch(arr, target);

        // Print the result.
        // If ans is -1, the target was not found. Otherwise, ans is the index of the target.
        System.out.println(ans);

        // Close the scanner to prevent resource leaks.
        sc.close();
    }

    /*
     * This method implements the Binary Search algorithm.
     * It takes a sorted integer array and a target integer as input.
     *
     * @param arr The sorted array of integers to search within.
     * @param target The integer value to search for.
     * @return The index of the target in the array if found, otherwise -1.
     */
    static int binarySearch(int[] arr, int target) {
        // Initialize 'start' to the first index of the array.
        int start = 0;
        // Initialize 'end' to the last index of the array.
        int end = arr.length - 1;

        // Loop continues as long as the 'start' pointer is less than or equal to the 'end' pointer.
        // This ensures that the search space is valid.
        while (start <= end) {
            // Calculate the middle index.
            // The formula `start + (end - start) / 2` is preferred over `(start + end) / 2`
            // to prevent potential integer overflow when `start` and `end` are very large.
            int mid = start + (end - start) / 2;

            // Compare the target with the element at the middle index.
            if (target < arr[mid]) {
                // If target is less than the middle element, it means the target must be in the left half.
                // So, update 'end' to `mid - 1` to narrow the search space to the left.
                end = mid - 1;
            } else if (target > arr[mid]) {
                // If target is greater than the middle element, it means the target must be in the right half.
                // So, update 'start' to `mid + 1` to narrow the search space to the right.
                start = mid + 1;
            } else {
                // If target is equal to the middle element, we have found the target.
                // Return the middle index.
                return mid;
            }
        }
        // If the loop finishes without finding the target (i.e., start becomes greater than end),
        // it means the target is not present in the array.
        // Return -1 to indicate that the target was not found.
        return -1;
    }
}
