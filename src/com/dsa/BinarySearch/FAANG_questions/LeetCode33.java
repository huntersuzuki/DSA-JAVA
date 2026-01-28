package com.dsa.BinarySearch.FAANG_questions;

// 33. Search in Rotated Sorted Array.
// https://leetcode.com/problems/search-in-rotated-sorted-array/description/

/**
 * This class provides a solution for searching a target value in a rotated sorted array.
 * A rotated sorted array is a sorted array that has been rotated at some pivot point.
 * For example, [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].
 *
 * The main idea is to first find the pivot element, which is the largest element in the array.
 * Once the pivot is found, the array is divided into two sorted subarrays.
 * We can then determine which subarray the target belongs to and perform a standard binary search on that subarray.
 */
public class LeetCode33 {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        LeetCode33 lc33 = new LeetCode33();
        int ans = lc33.search(arr, target);
        System.out.println("The target is at index: " + ans);
    }

    /**
     * Searches for a target value in a rotated sorted array.
     *
     * @param nums   The rotated sorted array.
     * @param target The value to search for.
     * @return The index of the target if found, otherwise -1.
     */
    public int search(int[] nums, int target) {
        // Step 1: Find the pivot element in the array.
        int pivot = findPivot(nums);

        // Case 1: If no pivot is found, the array is not rotated.
        // Perform a normal binary search on the entire array.
        if (pivot == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        // Case 2: If the pivot element itself is the target.
        if (nums[pivot] == target) {
            return pivot;
        }

        // Case 3: If the target is greater than or equal to the first element,
        // it must be in the left sorted portion of the array (from start to pivot - 1).
        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1);
        }

        // Case 4: If the target is smaller than the first element,
        // it must be in the right sorted portion of the array (from pivot + 1 to end).
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }

    /**
     * Performs a standard binary search on a sorted subarray.
     *
     * @param arr    The array to search in.
     * @param target The value to search for.
     * @param start  The starting index of the subarray.
     * @param end    The ending index of the subarray.
     * @return The index of the target if found, otherwise -1.
     */
    public int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            // Calculate mid point to prevent integer overflow for large arrays.
            int mid = start + (end - start) / 2;

            if (target > arr[mid]) {
                start = mid + 1; // Target is in the right half.
            } else if (target < arr[mid]) {
                end = mid - 1; // Target is in the left half.
            } else {
                return mid; // Target found at mid index.
            }
        }
        return -1; // Target not found in the subarray.
    }

    /**
     * Finds the pivot element in a rotated sorted array (without duplicates).
     * The pivot is the largest element in the array, where the rotation happens.
     *
     * @param arr The rotated sorted array.
     * @return The index of the pivot element, or -1 if the array is not rotated.
     */
    public int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Case 1: mid is the pivot if it's greater than the next element.
            // (mid < end) check is to prevent index out of bounds.
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            // Case 2: mid-1 is the pivot if the element at mid is smaller than the previous element.
            // (mid > start) check is to prevent index out of bounds.
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            // Case 3: If the middle element is less than or equal to the start element,
            // the pivot must be in the left half (including mid).
            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                // Case 4: If the middle element is greater than the start element,
                // the pivot must be in the right half.
                start = mid + 1;
            }
        }
        return -1; // No pivot found, meaning the array is not rotated.
    }

    /**
     * Finds the pivot element in a rotated sorted array that may contain duplicate values.
     * This is a more complex version of findPivot.
     *
     * @param arr The rotated sorted array with possible duplicates.
     * @return The index of the pivot element, or -1 if not found.
     */
    public int findPivotWithDuplicateValues(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Same pivot-finding logic as the non-duplicate version.
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            // Special handling for duplicate values.
            // If elements at start, mid, and end are the same, we can't decide which way to go.
            // So, we shrink the search space from both ends.
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // Before shrinking, check if start or end are pivots.
                if (start < end && arr[start] > arr[start + 1]) {
                    return start; // start is the pivot
                }
                start++;

                if (end > start && arr[end] < arr[end - 1]) {
                    return end - 1; // end-1 is the pivot
                }
                end--;
            }
            // If the left side is sorted, or if there are duplicates but the right side is unsorted
            else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1; // Pivot is in the right half.
            } else {
                end = mid - 1; // Pivot is in the left half.
            }
        }
        return -1;
    }
}

/*
================ DETAILED DRY RUN =================
Array: [4, 5, 6, 7, 0, 1, 2], Target: 0

Step 1: search() method called
- nums = [4, 5, 6, 7, 0, 1, 2], target = 0

Step 2: findPivot() called
start = 0, end = 6

Iteration 1:
- mid = 0 + (6-0)/2 = 3
- arr[mid] = arr[3] = 7, arr[mid+1] = arr[4] = 0
- Check: arr[3] > arr[4]? 7 > 0? YES → Pivot found at index 3
- Return 3

Step 3: Back to search() method
- pivot = 3
- Check if nums[pivot] == target? nums[3] = 7, target = 0 → NO
- Check if target >= nums[0]? 0 >= 4? NO
- Search in right portion: binarySearch(nums, 0, 4, 6)

Step 4: binarySearch() called with start=4, end=6

Iteration 1:
- mid = 4 + (6-4)/2 = 5
- arr[mid] = arr[5] = 1
- Compare: target (0) < arr[mid] (1)? YES
- end = mid - 1 = 4

Iteration 2:
- start = 4, end = 4
- mid = 4 + (4-4)/2 = 4
- arr[mid] = arr[4] = 0
- Compare: target (0) == arr[mid] (0)? YES
- Return 4

FINAL RESULT: 4 (target found at index 4)

================ TIME & SPACE COMPLEXITY ================
Time Complexity: O(log n) - The algorithm is based on binary search, which has logarithmic time complexity.
In the worst case (with duplicates), it can degrade to O(n) if we have to check every element.
Space Complexity: O(1) - The algorithm uses a constant amount of extra space.

================ KEY INSIGHTS =================
1. A rotated sorted array consists of two sorted subarrays.
2. The pivot is the largest element and the point of rotation.
3. By finding the pivot, we can identify the two sorted subarrays.
4. Once the subarrays are known, we can use binary search on the appropriate one.
5. Handling duplicates requires special care, as it can be ambiguous which subarray to search.

================ EDGE CASES HANDLED ================
1. Non-rotated array (pivot = -1): The code correctly falls back to a standard binary search.
2. Target is the pivot element: This is checked explicitly.
3. Target in the left sorted portion.
4. Target in the right sorted portion.
5. Arrays with duplicate values are handled by the `findPivotWithDuplicateValues` method.
*/
