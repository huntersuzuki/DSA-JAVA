package com.dsa.BinarySearch.FAANG_questions;

// Leetcode 852. Find peak index in a mountain array.
// https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
public class LeetCode852 {

    /**
     * This is the main method where the program execution begins.
     * It demonstrates the usage of the `peakIndexInMountainArray` method.
     *
     * @param args Command line arguments (not used in this program).
     */
    public static void main(String[] args) {
        int[] arr = {0, 10, 5, 2}; // Example mountain array
        int ans = peakIndexInMountainArray(arr); // Call the method to find the peak index
        System.out.println("The peak index in the array is: " + ans); // Print the result
    }

    /**
     * Finds the peak index in a mountain array.
     * A mountain array is defined as an array `arr` such that:
     * 1. `arr.length >= 3`
     * 2. There exists some `i` with `0 < i < arr.length - 1` such that:
     * `arr[0] < arr[1] < ... < arr[i-1] < arr[i] > arr[i+1] > ... > arr[arr.length - 1]`
     * <p>
     * This method uses a modified binary search approach to efficiently find the peak.
     *
     * @param arr The input mountain array.
     * @return The index of the peak element in the mountain array.
     */
    public static int peakIndexInMountainArray(int[] arr) {
        // Initialize 'start' to the beginning of the array and 'end' to the end of the array.
        // These pointers define the current search space.
        int start = 0;
        int end = arr.length - 1;

        // The binary search loop continues as long as 'start' is less than 'end'.
        // When 'start' equals 'end', we have found our peak element.
        while (start < end) {
            // Calculate the middle index to divide the search space.
            // The formula `start + (end - start) / 2` is used to prevent potential integer overflow
            // that might occur with `(start + end) / 2` if `start` and `end` are very large.
            int mid = start + (end - start) / 2;

            // Check if the element at 'mid' is greater than the element at 'mid + 1'.
            // This condition tells us if we are on the "decreasing" side of the mountain
            // or if 'mid' itself is the peak.
            if (arr[mid] > arr[mid + 1]) {
                // If `arr[mid]` is greater than `arr[mid + 1]`, it means we are either
                // at the peak or somewhere on the decreasing slope.
                // In either case, the peak element must be at or before `mid`.
                // So, we update 'end' to 'mid', narrowing our search space to the left half
                // (including 'mid').
                end = mid;
            } else {
                // If `arr[mid]` is NOT greater than `arr[mid + 1]`, it means `arr[mid] < arr[mid + 1]`.
                // This indicates that we are on the "increasing" side of the mountain.
                // Therefore, the peak element must be somewhere to the right of `mid`.
                // We update 'start' to `mid + 1`, narrowing our search space to the right half
                // (excluding 'mid' and starting from `mid + 1`).
                start = mid + 1;
            }
        }

        // When the loop terminates, 'start' will be equal to 'end'.
        // At this point, 'start' (or 'end') will point to the peak element's index.
        // This is because the search space has been continuously narrowed down until
        // only one element (the peak) remains.
        return start; // Or return 'end', both will be the same.
    }

    /*
     * Dry Run Example: arr = {0, 10, 5, 2}
     *
     * Initial state:
     * start = 0
     * end = 3 (arr.length - 1)
     *
     * Loop 1: (start < end) -> (0 < 3) is true
     *   mid = 0 + (3 - 0) / 2 = 0 + 3 / 2 = 1
     *   arr[mid] = arr[1] = 10
     *   arr[mid + 1] = arr[2] = 5
     *   Condition: arr[mid] > arr[mid + 1] -> (10 > 5) is true
     *   Action: end = mid = 1
     *   Current state: start = 0, end = 1
     *
     * Loop 2: (start < end) -> (0 < 1) is true
     *   mid = 0 + (1 - 0) / 2 = 0 + 1 / 2 = 0
     *   arr[mid] = arr[0] = 0
     *   arr[mid + 1] = arr[1] = 10
     *   Condition: arr[mid] > arr[mid + 1] -> (0 > 10) is false
     *   Action: start = mid + 1 = 0 + 1 = 1
     *   Current state: start = 1, end = 1
     *
     * Loop 3: (start < end) -> (1 < 1) is false. Loop terminates.
     *
     * Return start (which is 1).
     *
     * The peak element is 10, and its index is 1. The algorithm correctly returns 1.
     *
     * This binary search variant works because:
     * - If `arr[mid] > arr[mid + 1]`, it means we are on the decreasing slope or at the peak. The peak must be at or to the left of `mid`. So, we can safely discard elements to the right of `mid` (i.e., `mid + 1` onwards) by setting `end = mid`.
     * - If `arr[mid] < arr[mid + 1]`, it means we are on the increasing slope. The peak must be to the right of `mid`. So, we can safely discard `mid` and elements to its left by setting `start = mid + 1`.
     * Eventually, `start` and `end` will converge to the peak index.
     */
}
