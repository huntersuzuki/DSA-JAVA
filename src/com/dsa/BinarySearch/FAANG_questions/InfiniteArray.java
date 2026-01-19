package com.dsa.BinarySearch.FAANG_questions;

// https://www.geeksforgeeks.org/dsa/find-position-element-sorted-array-infinite-numbers/

/**
 * This class implements a solution to find the position of an element in a sorted array of "infinite" numbers.
 * The problem statement implies that we don't know the size of the array, so we cannot directly apply
 * standard binary search which requires knowing the array's bounds.
 * <p>
 * The approach involves finding a suitable range (start and end indices) where the target element
 * might reside, and then performing a standard binary search within that range.
 * <p>
 * The core idea is to expand the search window exponentially until the target is found within the window
 * or the target is smaller than the element at the end of the window.
 */
public class InfiniteArray {

    /**
     * The main method serves as the entry point for the program.
     * It initializes an example array and a target value, then calls the `ans` method
     * to find the target's index and prints the result.
     *
     * @param args Command line arguments (not used in this program).
     */
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int target = 10;
        int ans = ans(arr, target);
        System.out.println(ans);
    }

    /**
     * This method finds the appropriate range (start and end indices) in the "infinite" array
     * where the target element might be present. Once the range is found, it delegates
     * to the `binarySearch` method to locate the target within that range.
     * <p>
     * The strategy is to start with a small window (start=0, end=1) and exponentially
     * increase its size until the target is within the current window's bounds (i.e., target <= arr[end]).
     *
     * @param arr    The input sorted array (simulating an infinite array).
     * @param target The element to search for.
     * @return The index of the target element if found, otherwise -1.
     */
    public static int ans(int[] arr, int target) {
        int start = 0;
        int end = 1;

        // Expand the search window exponentially until target is within arr[start...end]
        // or target is less than or equal to arr[end].
        while (target > arr[end]) {
            // Store the current 'end' as the new 'start' for the next window.
            int newStart = end + 1;
            // Double the size of the box:
            // Previous box size was (end - start + 1).
            // New end will be: current_end + (size_of_previous_box * 2)
            // This effectively doubles the size of the search window.
            end = end + (end - start + 1) * 2;
            // Update 'start' to the beginning of the new window.
            start = newStart;
        }
        // Once the loop terminates, we have a range [start, end] where the target
        // is potentially located. Now, perform a standard binary search within this range.
        return binarySearch(arr, target, start, end);
    }

    /**
     * Performs a standard binary search on a sorted array within a specified range.
     *
     * @param arr    The input sorted array.
     * @param target The element to search for.
     * @param start  The starting index of the search range (inclusive).
     * @param end    The ending index of the search range (inclusive).
     * @return The index of the target element if found, otherwise -1.
     */
    public static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            // Calculate the middle index to avoid potential integer overflow
            // compared to (start + end) / 2, especially for very large start/end values.
            int mid = start + (end - start) / 2;

            if (target > arr[mid]) {
                // If target is greater than the middle element,
                // search in the right half.
                start = mid + 1;
            } else if (target < arr[mid]) {
                // If target is less than the middle element,
                // search in the left half.
                end = mid - 1;
            } else {
                // If target is equal to the middle element, we found it.
                return mid;
            }
        }
        // If the loop finishes, it means the target was not found in the array.
        return -1;
    }

}

/*
Detailed Dry Run:

Array: arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170}
Target: target = 10

1. Call `main` method:
   - `arr` and `target` are initialized.
   - `ans(arr, target)` is called.

2. Inside `ans(arr, target)`:
   - `start = 0`
   - `end = 1`

   - **While loop: `while (target > arr[end])`**
     - **Iteration 1:**
       - `target` (10) > `arr[end]` (arr[1] = 5)? Yes, 10 > 5.
       - `newStart = end + 1` = 1 + 1 = 2
       - `end = end + (end - start + 1) * 2`
         - `end = 1 + (1 - 0 + 1) * 2`
         - `end = 1 + (2) * 2`
         - `end = 1 + 4 = 5`
       - `start = newStart` = 2
       - Current window: `start = 2`, `end = 5` (elements: 7, 9, 10, 90)

     - **Iteration 2:**
       - `target` (10) > `arr[end]` (arr[5] = 90)? No, 10 is not > 90.
       - The loop terminates.

   - Now, `start = 2` and `end = 5`.
   - Call `binarySearch(arr, target, start, end)` which is `binarySearch(arr, 10, 2, 5)`.

3. Inside `binarySearch(arr, 10, 2, 5)`:
   - `start = 2`, `end = 5`

   - **While loop: `while (start <= end)`**
     - **Iteration 1:**
       - `start` (2) <= `end` (5)? Yes.
       - `mid = start + (end - start) / 2` = 2 + (5 - 2) / 2 = 2 + 3 / 2 = 2 + 1 = 3
       - `arr[mid]` = `arr[3]` = 9
       - `target` (10) > `arr[mid]` (9)? Yes.
       - `start = mid + 1` = 3 + 1 = 4
       - Current range: `start = 4`, `end = 5`

     - **Iteration 2:**
       - `start` (4) <= `end` (5)? Yes.
       - `mid = start + (end - start) / 2` = 4 + (5 - 4) / 2 = 4 + 1 / 2 = 4 + 0 = 4
       - `arr[mid]` = `arr[4]` = 10
       - `target` (10) > `arr[mid]` (10)? No.
       - `target` (10) < `arr[mid]` (10)? No.
       - Else block: `target == arr[mid]`.
       - Return `mid` which is 4.

4. Back in `ans` method:
   - The value 4 is returned from `binarySearch`.

5. Back in `main` method:
   - `ans` variable receives 4.
   - `System.out.println(ans)` prints 4.

Output:
4
*/
