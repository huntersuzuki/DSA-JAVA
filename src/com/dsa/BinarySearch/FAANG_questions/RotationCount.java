package com.dsa.BinarySearch.FAANG_questions;

/**
 * This class is designed to solve the problem of finding the rotation count in a rotated sorted array.
 * A rotated sorted array is a sorted array on which a rotation operation has been performed some number of times.
 * For example, if the original sorted array is {0, 1, 2, 4, 5, 6, 7}, after four rotations, it might become {4, 5, 6, 7, 0, 1, 2}.
 * The number of rotations is equal to the index of the minimum element in the array.
 * This code finds the "pivot" (the largest element), and its index + 1 gives the rotation count.
 *
 * Link to the problem: https://www.geeksforgeeks.org/dsa/find-rotation-count-rotated-sorted-array/
 */
public class RotationCount {
    /**
     * The main method serves as the entry point and a driver for testing the functionality.
     * It initializes a sample rotated sorted array and prints the number of rotations.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("The array is rotated " + CountRotations(arr) + " times.");
    }

    /**
     * Calculates the number of rotations in a rotated sorted array.
     * The number of rotations is equivalent to the index of the smallest element.
     * In a rotated sorted array, the largest element is called the "pivot". The smallest element
     * is always located right after the pivot.
     * Therefore, the rotation count is pivot_index + 1.
     * If the array is not rotated, our findPivot method will return -1.
     * In that case, pivot + 1 = 0, which correctly indicates 0 rotations.
     *
     * @param arr The input rotated sorted array.
     * @return The number of rotations.
     */
    private static int CountRotations(int[] arr) {
        int pivot = findPivot(arr);
        return pivot + 1;
    }

    /**
     * Finds the index of the pivot (the largest element) in a rotated sorted array using a modified binary search.
     * The key idea is to find the point in the array where the order "breaks".
     *
     * @param arr The input rotated sorted array.
     * @return The index of the pivot element, or -1 if the array is not rotated.
     */
    private static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        // Standard binary search loop.
        while (start <= end) {
            // Calculate mid point to avoid potential integer overflow.
            int mid = start + (end - start) / 2;

            // We are looking for the peak element, which is the pivot.
            // There are four main cases inside the loop.

            // Case 1: The pivot is the middle element.
            // This is true if mid is not the last element and the element at mid is greater than its next element.
            // e.g., in {4, 5, 6, 7, 0, 1, 2}, if mid points to 7, arr[mid] > arr[mid + 1] (7 > 0). So, 7 is the pivot.
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            // Case 2: The element just before mid is the pivot.
            // This is true if mid is not the first element and the element at mid is smaller than its previous element.
            // e.g., in {4, 5, 6, 7, 0, 1, 2}, if mid points to 0, arr[mid] < arr[mid - 1] (0 < 7). So, 7 (at mid-1) is the pivot.
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            // Case 3: The left half is sorted, so the pivot must be in the right half.
            // If the element at start is smaller than or equal to the element at mid, it implies
            // that the sub-array from start to mid is sorted in ascending order.
            // This means the "break" (the pivot) must be in the right part of the array.
            // e.g., in {3, 4, 5, 6, 7, 0, 1, 2}, if mid points to 5, arr[start](3) <= arr[mid](5).
            // So, we discard the left half and search in the right half for the peak.
            if (arr[start] < arr[mid]) {
                start = mid + 1;
            } else {
                // Case 4: The right half is sorted, or we are in the part of the array after the pivot.
                // The pivot must be in the left half.
                end = mid - 1;
            }
        }
        // If the loop finishes, it means the array was not rotated at all (it's fully sorted).
        // In this scenario, there is no pivot in the sense of a "peak", so we return -1.
        // This indicates 0 rotations when used in the CountRotations method.
        return -1;
    }
}
