package com.dsa.BinarySearch.FAANG_questions;

// 744. Find Smallest Letter Greater Than Target
// https://leetcode.com/problems/find-smallest-letter-greater-than-target/

/**
 * This class provides a solution to the LeetCode problem 744: Find Smallest Letter Greater Than Target.
 * The problem asks us to find the smallest character in a sorted list of characters that is larger than the given target character.
 * The letters wrap around. For example, if the target is 'z' and letters = ['a', 'b'], the answer is 'a'.
 */
public class LeetCode744 {

    /**
     * The main method to test the functionality of the nextGreatestLetter method.
     * It initializes an array of characters and a target character, then calls the
     * nextGreatestLetter method and prints the result.
     *
     * @param args Command line arguments (not used in this context).
     */
    static void main(String[] args) {
        // Example 1: Basic case
        char[] arr = {'c', 'f', 'j'};
        char target = 'a';
        LeetCode744 lc = new LeetCode744();
        char res = lc.nextGreatestLetter(arr, target);
        System.out.println(res);

        // Example 2: Target is present in the array, but we need the next greatest
        char[] arr2 = {'c', 'f', 'j'};
        char target2 = 'c';
        char res2 = lc.nextGreatestLetter(arr2, target2);
        System.out.println(res2); // Expected output: 'f'

        // Example 3: Target is greater than all elements, should wrap around
        char[] arr3 = {'c', 'f', 'j'};
        char target3 = 'k';
        char res3 = lc.nextGreatestLetter(arr3, target3);
        System.out.println(res3); // Expected output: 'c'

        // Example 4: Target is the last element, should wrap around
        char[] arr4 = {'c', 'f', 'j'};
        char target4 = 'j';
        char res4 = lc.nextGreatestLetter(arr4, target4);
        System.out.println(res4); // Expected output: 'c'

        // Example 5: Single element array
        char[] arr5 = {'a'};
        char target5 = 'a';
        char res5 = lc.nextGreatestLetter(arr5, target5);
        System.out.println(res5); // Expected output: 'a'

        // Example 6: Single element array, target smaller
        char[] arr6 = {'f'};
        char target6 = 'c';
        char res6 = lc.nextGreatestLetter(arr6, target6);
        System.out.println(res6); // Expected output: 'f'
    }

    /**
     * Finds the smallest character in a sorted list of characters that is larger than the given target character.
     * The letters wrap around. This method uses a binary search approach.
     *
     * @param letters The sorted array of characters.
     * @param target  The target character.
     * @return The smallest character in `letters` that is greater than `target`,
     * or the first character if no such character exists (due to wrap-around).
     */
    public char nextGreatestLetter(char[] letters, char target) {
        // Initialize the start and end pointers for binary search.
        int start = 0;
        int end = letters.length - 1;

        // Perform binary search. The loop continues as long as the search space is valid.
        while (start <= end) {
            // Calculate the middle index to avoid potential integer overflow
            // compared to (start + end) / 2.
            int mid = start + (end - start) / 2;

            // If the target is less than the character at the middle index,
            // it means the potential answer could be 'letters[mid]' or something to its left.
            // So, we narrow down the search space to the left half.
            if (target < letters[mid]) {
                end = mid - 1;
            }
            // If the target is greater than or equal to the character at the middle index,
            // it means 'letters[mid]' is not the answer (or not the smallest greater one).
            // We need to look in the right half for a character strictly greater than the target.
            else { // target >= letters[mid]
                start = mid + 1;
            }
        }

        // After the loop terminates, 'start' will point to the index of the smallest
        // character that is greater than the 'target'.
        // If 'start' goes out of bounds (i.e., becomes equal to letters.length),
        // it means all characters in the array are less than or equal to the target.
        // In this case, due to the wrap-around requirement, the answer is the first character
        // of the array (letters[0]).
        // The modulo operator `start % letters.length` elegantly handles this wrap-around:
        // - If `start` is within bounds (0 to letters.length - 1), `start % letters.length` is `start`.
        // - If `start` is `letters.length`, `letters.length % letters.length` is `0`,
        //   correctly returning the first element.
        return letters[start % letters.length];
    }
}
