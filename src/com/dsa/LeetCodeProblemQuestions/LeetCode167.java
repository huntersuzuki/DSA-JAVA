package com.dsa.LeetCodeProblemQuestions;

import java.util.Arrays;
import java.util.Scanner;

// LeetCode 167. Two Sum II - Input Array Is Sorted.
// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
public class LeetCode167 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {2, 7, 11, 15};
        System.out.println("Enter a number for target search: ");
        int target = sc.nextInt();
        int[] ans = twoSum(arr, target);
        System.out.println(Arrays.toString(ans));
    }

    static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                int indexOne = left + 1;
                int indexTwo = right + 1;
                return new int[]{indexOne, indexTwo};
            }
            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }
}
