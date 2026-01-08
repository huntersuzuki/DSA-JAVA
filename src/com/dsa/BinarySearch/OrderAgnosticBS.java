package com.dsa.BinarySearch;

import java.util.Scanner;

/**
 * This class implements an Order-Agnostic Binary Search algorithm.
 * An Order-Agnostic Binary Search is a variation of the standard Binary Search
 * that can work on both ascending and descending sorted arrays without needing
 * to know the sorting order beforehand. It automatically determines if the array
 * is sorted in ascending or descending order and adjusts its search logic accordingly.
 */
public class OrderAgnosticBS {
    /**
     * The main method serves as the entry point for the program.
     * It initializes an array, prompts the user for a target value,
     * calls the orderAgnosticBS method to find the target, and prints the result.
     *
     * @param args Command line arguments (not used in this program).
     */
    public static void main(String[] args) { // Changed to public static void main
        Scanner sc = new Scanner(System.in);
        // Example array sorted in ascending order
        int[] arr = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};
        // You can also test with a descending sorted array, e.g.:
        // int[] arr = {89, 45, 22, 18, 16, 15, 4, 3, 2, 0, -4, -12, -18};

        System.out.println("Enter the number you want to search: ");
        int target = sc.nextInt();

        // Call the orderAgnosticBS method to perform the search
        int ans = orderAgnosticBS(arr, target);

        // Print the result. If ans is -1, the target was not found.
        // Otherwise, ans is the index of the target in the array.
        if (ans != -1) {
            System.out.println("Target " + target + " found at index: " + ans);
        } else {
            System.out.println("Target " + target + " not found in the array.");
        }
        sc.close(); // Close the scanner to prevent resource leaks
    }

    /**
     * Implements the Order-Agnostic Binary Search algorithm.
     * This method searches for a target value in a sorted array (either ascending or descending).
     * It first determines the sorting order of the array and then applies the appropriate
     * binary search logic.
     *
     * @param arr    The integer array to be searched. This array must be sorted.
     * @param target The integer value to search for in the array.
     * @return The index of the target if found, otherwise -1.
     */
    static int orderAgnosticBS(int[] arr, int target) {
        // Initialize start and end pointers for the search range.
        int start = 0;
        int end = arr.length - 1;

        // Determine if the array is sorted in ascending or descending order.
        // This is done by comparing the first and last elements.
        // If arr[start] < arr[end], it's ascending. Otherwise, it's descending.
        boolean isAsc = arr[start] < arr[end];

        // The main binary search loop continues as long as the search range is valid.
        while (start <= end) {
            // Calculate the middle index.
            // This formula is preferred over (start + end) / 2 to prevent potential integer overflow
            // when start and end are very large.
            int mid = start + ((end - start) / 2);

            // If the middle element is the target, we've found it. Return its index.
            if (arr[mid] == target) {
                return mid;
            }

            // If the array is sorted in ascending order:
            if (isAsc) {
                // If the target is less than the middle element, it must be in the left half.
                // So, update the 'end' pointer to mid - 1.
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    // If the target is greater than the middle element, it must be in the right half.
                    // So, update the 'start' pointer to mid + 1.
                    start = mid + 1;
                }
            } else {
                // If the array is sorted in descending order:
                // If the target is greater than the middle element, it must be in the left half
                // (because elements decrease from left to right).
                // So, update the 'end' pointer to mid - 1.
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    // If the target is less than the middle element, it must be in the right half.
                    // So, update the 'start' pointer to mid + 1.
                    start = mid + 1;
                }
            }
        }
        // If the loop finishes and the target is not found, return -1.
        return -1;
    }
}
