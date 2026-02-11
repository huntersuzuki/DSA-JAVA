package com.dsa.BinarySearch.FAANG_questions;

/**
 * This class provides a solution to the LeetCode problem 410: "Split Array Largest Sum".
 * The problem asks to split an array into 'k' non-empty continuous subarrays
 * such that the largest sum among these subarrays is minimized.
 * <p>
 * For example, given nums = [7, 2, 5, 10, 8] and k = 2, the best way to split the array is
 * into [7, 2, 5] and [10, 8]. The sums of these subarrays are 14 and 18. The largest sum is 18.
 * We want to find the minimum possible value for this largest sum.
 * <p>
 * This problem can be solved using a binary search approach on the answer.
 * The key insight is that the minimum possible largest sum must lie between two bounds:
 * 1. The maximum element in the array (the lower bound). This is because the largest element must
 * belong to some subarray, so the sum of that subarray will be at least that element's value.
 * 2. The sum of all elements in the array (the upper bound). This corresponds to the case where k=1,
 * and the entire array is a single subarray.
 * <p>
 * We can then binary search for the answer within this range [max(nums), sum(nums)].
 * For each `mid` value in our binary search, we check if it's possible to split the array into `k`
 * or fewer subarrays such that no subarray has a sum greater than `mid`.
 * Link to the problem: https://leetcode.com/problems/split-array-largest-sum/description/
 */
public class LeetCode410 {
    /**
     * The main method to test the splitArray function.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 10, 8};
        int k = 2;
        int ans = splitArray(arr, k);
        System.out.println("The minimized largest sum is: " + ans);
    }

    /**
     * Finds the minimum largest sum of subarrays when splitting `nums` into `k` parts.
     *
     * @param nums The input array of integers.
     * @param k    The number of subarrays to split the array into.
     * @return The minimized largest sum among the `k` subarrays.
     */
    static int splitArray(int[] nums, int k) {
        // Initialize the search range for our binary search.
        int start = 0; // Will become the maximum element in the array.
        int end = 0;   // Will become the sum of all elements in the array.

        // Determine the lower and upper bounds for the binary search.
        for (int i = 0; i < nums.length; i++) {
            // `start` is the maximum single element, which is the minimum possible largest sum.
            start = Math.max(start, nums[i]);
            // `end` is the sum of all elements, which is the maximum possible largest sum (when k=1).
            end += nums[i];
        }

        // Binary search for the minimum possible largest sum.
        while (start < end) {
            // `mid` is our potential answer for the minimized largest sum.
            int mid = start + (end - start) / 2;

            // Now, we check if it's possible to split the array into `k` or fewer subarrays
            // such that the sum of each subarray does not exceed `mid`.
            int currentSum = 0;
            int pieces = 1; // Start with one subarray.

            for (int num : nums) {
                // If adding the current number to the current subarray exceeds `mid`,
                // we must start a new subarray.
                if (currentSum + num > mid) {
                    // Start a new subarray with the current number.
                    currentSum = num;
                    // Increment the count of subarrays (pieces).
                    pieces++;
                } else {
                    // Otherwise, add the current number to the current subarray.
                    currentSum += num;
                }
            }

            // After checking all numbers, `pieces` holds the number of subarrays required
            // if the largest sum is capped at `mid`.

            // If the number of pieces is greater than `k`, it means `mid` is too small.
            // We need to allow for a larger sum to reduce the number of pieces.
            // So, we search in the higher range.
            if (pieces > k) {
                start = mid + 1;
            } else {
                // If the number of pieces is less than or equal to `k`, it means `mid` is a possible answer.
                // It might even be possible to get a smaller largest sum.
                // So, we try to find a smaller `mid` by searching in the lower range.
                end = mid;
            }
        }
        // When the loop terminates, `start` and `end` will converge to the same value,
        // which is the smallest possible value for the largest sum of subarrays.
        // We can return either `start` or `end`.
        return end;
    }
}

/*
 * * ### Detailed Dry Run
 *
 * Let's trace the algorithm with `nums = {7, 2, 5, 10, 8}` and `k = 2`.
 *
 * **1. Initialization:**
 *    - `start` (lower bound) = `max(7, 2, 5, 10, 8)` = `10`
 *    - `end` (upper bound) = `7 + 2 + 5 + 10 + 8` = `32`
 *    - The search range for our answer is `[10, 32]`.
 *
 * **2. Binary Search Iteration 1:**
 *    - `start = 10`, `end = 32`
 *    - `mid = 10 + (32 - 10) / 2 = 21`
 *    - **Check:** Can we split the array into `k=2` pieces where no piece's sum exceeds 21?
 *      - Piece 1: `7 + 2 + 5 = 14` (currentSum = 14)
 *      - Next num is 10. `14 + 10 = 24`, which is `> 21`. So, we must start a new piece.
 *      - Piece 2: `10 + 8 = 18` (currentSum = 18)
 *    - We successfully split the array into 2 pieces: `[7, 2, 5]` and `[10, 8]`.
 *    - **Result:** `pieces = 2`. Since `pieces (2) <= k (2)`, it means a max sum of 21 is possible. But can we do better?
 *    - We try for a smaller max sum: `end = mid = 21`. New range: `[10, 21]`.
 *
 * **3. Binary Search Iteration 2:**
 *    - `start = 10`, `end = 21`
 *    - `mid = 10 + (21 - 10) / 2 = 15`
 *    - **Check:** Can we split with a max sum of 15?
 *      - Piece 1: `7 + 2 + 5 = 14` (currentSum = 14)
 *      - Next num is 10. `14 + 10 = 24 > 15`. Start a new piece.
 *      - Piece 2: `10` (currentSum = 10)
 *      - Next num is 8. `10 + 8 = 18 > 15`. Start a new piece.
 *      - Piece 3: `8`
 *    - We needed 3 pieces to keep the sum of each piece `<= 15`.
 *    - **Result:** `pieces = 3`. Since `pieces (3) > k (2)`, a max sum of 15 is too small.
 *    - We must allow a larger max sum: `start = mid + 1 = 16`. New range: `[16, 21]`.
 *
 * **4. Binary Search Iteration 3:**
 *    - `start = 16`, `end = 21`
 *    - `mid = 16 + (21 - 16) / 2 = 18`
 *    - **Check:** Can we split with a max sum of 18?
 *      - Piece 1: `7 + 2 + 5 = 14`
 *      - Next num is 10. `14 + 10 = 24 > 18`. New piece.
 *      - Piece 2: `10 + 8 = 18`
 *    - We successfully split the array into 2 pieces: `[7, 2, 5]` and `[10, 8]`.
 *    - **Result:** `pieces = 2`. Since `pieces (2) <= k (2)`, a max sum of 18 is possible. Let's see if we can do better.
 *    - `end = mid = 18`. New range: `[16, 18]`.
 *
 * **5. Binary Search Iteration 4:**
 *    - `start = 16`, `end = 18`
 *    - `mid = 16 + (18 - 16) / 2 = 17`
 *    - **Check:** Can we split with a max sum of 17?
 *      - Piece 1: `7 + 2 + 5 = 14`
 *      - Next num is 10. `14 + 10 = 24 > 17`. New piece.
 *      - Piece 2: `10`
 *      - Next num is 8. `10 + 8 = 18 > 17`. New piece.
 *      - Piece 3: `8`
 *    - We needed 3 pieces.
 *    - **Result:** `pieces = 3`. Since `pieces (3) > k (2)`, 17 is too small.
 *    - `start = mid + 1 = 18`. New range: `[18, 18]`.
 *
 * **6. Termination:**
 *    - `start = 18`, `end = 18`. The loop condition `start < end` is now false.
 *    - The loop terminates. The answer is `end` (or `start`), which is `18`.
 *
 * */
