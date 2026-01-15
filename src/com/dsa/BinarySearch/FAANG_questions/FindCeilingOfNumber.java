package com.dsa.BinarySearch.FAANG_questions;

import java.util.Scanner;

/**
 * This class provides a method to find the ceiling of a given number in a sorted array.
 * The ceiling of a number 'x' is the smallest element in the array that is greater than or equal to 'x'.
 * This problem is a classic application of Binary Search.
 */
public class FindCeilingOfNumber {

    /**
     * The main method to demonstrate the functionality of finding the ceiling of a number.
     * It initializes a sorted array, prompts the user for a target number,
     * and then prints the ceiling of that number.
     *
     * @param args Command line arguments (not used in this program).
     */
    public static void main(String[] args) { // Changed to public static void main
        Scanner sc = new Scanner(System.in);
        // A sorted array of integers. Binary search requires the array to be sorted.
        int[] arr = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};
        System.out.println("Enter the number you want the ceiling of: ");
        int target = sc.nextInt();

        // Call the ceilingOfNumber method to find the ceiling.
        int res = ceilingOfNumber(arr, target);

        // Print the result.
        // If res is -1, it means the target is greater than the largest element in the array.
        // Otherwise, res is the index of the ceiling element.
        if (res == -1) {
            System.out.println("No ceiling found (target is greater than the largest element).");
        } else {
            System.out.println("The ceiling of " + target + " is at index: " + res + ", which is: " + arr[res]);
        }
        sc.close(); // Close the scanner to prevent resource leaks.
    }

    /**
     * Finds the index of the ceiling of a given target number in a sorted array.
     * The ceiling of a number 'x' is the smallest element in the array that is greater than or equal to 'x'.
     * This method uses a modified binary search algorithm.
     *
     * @param arr    The sorted array of integers.
     * @param target The number for which to find the ceiling.
     * @return The index of the ceiling element in the array. Returns -1 if the target
     * is greater than the largest element in the array (meaning no ceiling exists).
     */
    static int ceilingOfNumber(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        // Edge case: If the target is greater than the largest element in the array,
        // then no ceiling exists in the array.
        if (target > arr[arr.length - 1]) {
            return -1;
        }

        // Binary search loop. The loop continues as long as the 'start' pointer
        // is less than or equal to the 'end' pointer.
        while (start <= end) {
            // Calculate the middle index.
            // This way of calculating mid prevents potential integer overflow
            // that might occur with (start + end) / 2 if start and end are very large.
            int mid = start + (end - start) / 2; // Corrected from for loop to while loop

            // Case 1: If the target is greater than the element at mid.
            // This means the ceiling (if it exists) must be in the right half of the array.
            // So, we update 'start' to mid + 1.
            if (target > arr[mid]) {
                start = mid + 1;
            }
            // Case 2: If the target is less than the element at mid.
            // This means the ceiling could be the element at mid, or it could be in the left half.
            // We update 'end' to mid - 1 to search in the left half.
            else if (target < arr[mid]) { // Corrected from for loop to while loop
                end = mid - 1;
            }
            // Case 3: If the target is equal to the element at mid.
            // In this case, the element at mid is the ceiling itself.
            // We return its index.
            else { // Corrected from for loop to while loop
                return mid; // Found the exact target, which is also its ceiling.
            }
        }

        // After the loop terminates, 'start' will be pointing to the smallest element
        // that is greater than the target. This is because:
        // When the loop condition (start <= end) becomes false, it means 'start' has
        // crossed 'end'. Specifically, 'start' will be equal to 'end + 1'.
        //
        // Consider the last iteration where start <= end was true:
        // If target > arr[mid], then start becomes mid + 1.
        // If target < arr[mid], then end becomes mid - 1.
        //
        // In the scenario where the target is not found (i.e., no exact match),
        // 'start' will end up pointing to the index of the first element that is
        // greater than the target. This element is the ceiling.
        // For example, if arr = [2, 3, 5, 9] and target = 4:
        // Eventually, start will be 2 (pointing to 5) and end will be 1 (pointing to 3).
        // The loop terminates, and 'start' (which is 2) is returned. arr[2] is 5, which is the ceiling of 4.
        return start;
    }
}
