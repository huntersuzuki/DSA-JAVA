package com.dsa.BinarySearch.FAANG_questions;

import java.util.Scanner;

/**
 * This class provides a method to find the "floor" of a given target number in a sorted array.
 * The floor of a number `x` in a sorted array is the largest element in the array that is less than or equal to `x`.
 * If no such element exists (i.e., all elements in the array are greater than `x`), it returns -1.
 * <p>
 * The implementation uses a binary search algorithm for efficient searching.
 */
public class FindFloorOfNumber {
    /**
     * The main method serves as the entry point for the program.
     * It initializes a sorted array, prompts the user for a target number,
     * calls the `floorOfNumber` method to find its floor, and prints the result.
     *
     * @param args Command line arguments (not used in this program).
     */
    public static void main(String[] args) { // Changed to public static void main for standard execution
        Scanner sc = new Scanner(System.in);
        // A sorted array of integers to search within.
        int[] arr = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};
        System.out.println("Enter the number you want the floor of: ");
        int target = sc.nextInt();
        // Call the floorOfNumber method to find the floor of the target.
        int res = floorOfNumber(arr, target);
        // Print the result. If res is -1, it means no floor was found.
        if (res != -1) {
            System.out.println("The floor of " + target + " is: " + arr[res] + " (at index " + res + ")");
        } else {
            System.out.println("The floor of " + target + " does not exist in the array (all elements are greater than target).");
        }
        sc.close(); // Close the scanner to prevent resource leaks.
    }

    /**
     * Finds the floor of a given target number in a sorted integer array using binary search.
     * The floor of a number `x` is the largest element in the array that is less than or equal to `x`.
     *
     * @param arr    The sorted integer array to search within.
     * @param target The number for which to find the floor.
     * @return The index of the floor element if found, or -1 if the target is smaller than the smallest element in the array.
     * Note: The current implementation returns the `end` index after the loop, which correctly points to the floor
     * if the target is not found exactly, but is greater than or equal to some element.
     * If the target is smaller than all elements, `end` will be -1.
     */
    static int floorOfNumber(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        // Edge case: If the target is smaller than the smallest element in the array,
        // there is no floor.
        if (target < arr[0]) {
            return -1; // Or you could return the index of the smallest element if that's desired, but -1 is standard for "not found".
        }

        // Binary search loop. The loop continues as long as the search space is valid (start <= end).
        while (start <= end) {
            // Calculate the middle index.
            // The expression `start + (end - start) / 2` is used to prevent potential integer overflow
            // that might occur with `(start + end) / 2` if `start` and `end` are very large.
            int mid = start + (end - start) / 2;

            // Case 1: Target is greater than the element at mid.
            // This means the floor (if it exists and is not arr[mid]) must be in the right half.
            // We update `start` to `mid + 1` to search in the right subarray.
            if (target > arr[mid]) {
                start = mid + 1;
            }
            // Case 2: Target is less than the element at mid.
            // This means the floor must be in the left half.
            // We update `end` to `mid - 1` to search in the left subarray.
            // The current `arr[mid]` cannot be the floor because it's greater than the target.
            else if (target < arr[mid]) {
                end = mid - 1;
            }
            // Case 3: Target is equal to the element at mid.
            // In this case, arr[mid] is the floor (and also the exact match).
            // We return the index `mid`.
            else { // target == arr[mid]
                return mid; // Found the exact target, which is also its floor.
            }
        }

        // After the loop terminates, `start` will be greater than `end`.
        // At this point, `end` will point to the largest element that is less than the target.
        // This is precisely the definition of the floor.
        //
        // Example dry run: arr = {2, 3, 4, 15, 16, 18}, target = 17
        // Initial: start = 0, end = 5
        // 1. mid = 2 (arr[2] = 4). target (17) > arr[mid] (4). start = 3. (start=3, end=5)
        // 2. mid = 4 (arr[4] = 16). target (17) > arr[mid] (16). start = 5. (start=5, end=5)
        // 3. mid = 5 (arr[5] = 18). target (17) < arr[mid] (18). end = 4. (start=5, end=4)
        // Loop terminates because start (5) > end (4).
        // The value of `end` is 4, which is the index of 16. 16 is the floor of 17.
        //
        // Example dry run: arr = {2, 3, 4, 15, 16, 18}, target = 1
        // Initial: start = 0, end = 5
        // 1. mid = 2 (arr[2] = 4). target (1) < arr[mid] (4). end = 1. (start=0, end=1)
        // 2. mid = 0 (arr[0] = 2). target (1) < arr[mid] (2). end = -1. (start=0, end=-1)
        // Loop terminates because start (0) > end (-1).
        // The value of `end` is -1. This correctly indicates no floor if we handle it.
        // However, the initial check `if (target < arr[0])` already handles this case.
        return end;
    }
}
