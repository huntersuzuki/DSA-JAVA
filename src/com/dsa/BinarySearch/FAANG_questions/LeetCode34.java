package com.dsa.BinarySearch.FAANG_questions;

import java.util.Arrays;

// 34. Find First and Last Position of Element in Sorted Array
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

/**
 * This Java code implements a solution for LeetCode problem 34: "Find First and Last Position of Element in Sorted Array".
 * The problem asks us to find the starting and ending position of a given target value in a sorted array of integers.
 * If the target is not found in the array, the function should return [-1, -1].
 * The algorithm must have an O(log n) runtime complexity, which immediately suggests using a binary search approach.
 */
public class LeetCode34 {
    /**
     * The main method serves as the entry point for the program and demonstrates the usage of the searchRange function.
     * It initializes a sample array and a target value, then calls searchRange to find the first and last occurrences
     * of the target, and finally prints the result to the console.
     *
     * @param args Command line arguments (not used in this program).
     */
    static void main(String[] args) {
        // Example 1: Target found multiple times
        int[] arr = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] ans = searchRange(arr, target);
        System.out.println(Arrays.toString(ans));

        // Example 2: Target not found
        int[] arr2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        int[] ans2 = searchRange(arr2, target2);
        System.out.println(Arrays.toString(ans2)); // Expected output: [-1, -1]

        // Example 3: Target found once
        int[] arr3 = {1};
        int target3 = 1;
        int[] ans3 = searchRange(arr3, target3);
        System.out.println(Arrays.toString(ans3)); // Expected output: [0, 0]

        // Example 4: Empty array
        int[] arr4 = {};
        int target4 = 0;
        int[] ans4 = searchRange(arr4, target4);
        System.out.println(Arrays.toString(ans4)); // Expected output: [-1, -1]
    }

    /**
     * This is the main function that finds the first and last position of a given target in a sorted array.
     * It leverages a modified binary search function (`search`) to find both the starting and ending indices.
     *
     * @param nums   The sorted array of integers.
     * @param target The integer value to search for.
     * @return An integer array of size 2, where the first element is the starting index and the second is the ending index.
     * Returns [-1, -1] if the target is not found.
     */
    static int[] searchRange(int[] nums, int target) {
        // Initialize the answer array with [-1, -1], which is the default return value if the target is not found.
        int[] ans = {-1, -1};

        // First, find the potential starting index of the target.
        // We pass 'true' for findStartIndex to instruct the search function to look for the leftmost occurrence.
        int start = search(nums, target, true);

        // Then, find the potential ending index of the target.
        // We pass 'false' for findStartIndex to instruct the search function to look for the rightmost occurrence.
        int end = search(nums, target, false);

        // Assign the found indices to the answer array.
        ans[0] = start;
        ans[1] = end;

        return ans;
    }

    /**
     * A modified binary search function that can find either the first or the last occurrence of a target value
     * in a sorted array.
     *
     * @param nums           The sorted array of integers.
     * @param target         The integer value to search for.
     * @param findStartIndex A boolean flag:
     *                       - If true, the function searches for the *first* occurrence of the target.
     *                       - If false, the function searches for the *last* occurrence of the target.
     * @return The index of the first or last occurrence of the target, or -1 if the target is not found.
     */
    static int search(int[] nums, int target, boolean findStartIndex) {
        // Initialize 'ans' to -1. This will store the potential answer (index) found so far.
        // If the target is not found, -1 will be returned.
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        // Standard binary search loop condition.
        while (start <= end) {
            // Calculate the middle index to avoid potential integer overflow compared to (start + end) / 2.
            int mid = start + (end - start) / 2;

            if (target < nums[mid]) {
                // If the target is less than the middle element, search in the left half.
                end = mid - 1;
            } else if (target > nums[mid]) {
                // If the target is greater than the middle element, search in the right half.
                start = mid + 1;
            } else {
                // If target == nums[mid], we've found a potential answer.
                ans = mid;
                // Now, we need to decide whether to continue searching for the first or last occurrence.
                if (findStartIndex) {
                    // If we are looking for the start index, it means we might find an even earlier occurrence
                    // in the left half. So, we try to shrink the search space to the left.
                    end = mid - 1;
                } else {
                    // If we are looking for the end index, it means we might find an even later occurrence
                    // in the right half. So, we try to shrink the search space to the right.
                    start = mid + 1;
                }
            }
        }
        // Return the found index, or -1 if the target was never found.
        return ans;
    }
}
