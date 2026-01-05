package com.dsa.linearSearch;

import java.util.Arrays;
import java.util.Scanner;
// The `java.util.Scanner` class is used to get user input.
// It can parse primitive types and strings using regular expressions.

public class SearchInTwoDArray {
    // The `SearchInTwoDArray` class contains methods for searching and finding the maximum element
    // in a two-dimensional array (matrix).

    static void main(String[] args) {
        // The `main` method is the entry point of the program.
        // Note: In Java, the `main` method must be `public static void main(String[] args)`.
        // The current signature `static void main(String[] args)` is valid in some contexts (e.g.,
        // as a non-public static method that can be called, but not as the program's entry point
        // unless the JVM is configured specifically or it's a newer Java version feature like
        // implicit main for single-file source code programs, which is not standard for typical
        // project setups). For a standard executable Java program, it should be `public`.

        Scanner sc = new Scanner(System.in);
        // Creates a `Scanner` object named `sc` to read input from the console (System.in).

        int[][] arr = {
                {23, 4, 1},
                {18, 12, 3, 9},
                {78, 99, 34, 56},
                {67, 69}
        };
        // Declares and initializes a 2D integer array (matrix) named `arr`.
        // This array has 4 rows, and each row can have a different number of columns (it's a jagged array).

        System.out.println("Enter the number you want to search: ");
        // Prompts the user to enter a number to search for.

        int target = sc.nextInt();
        // Reads the integer entered by the user and stores it in the `target` variable.

        int[] ans = search(arr, target);
        // Calls the `search` method, passing the 2D array `arr` and the `target` value.
        // The method returns an array of two integers representing the row and column index
        // of the target if found, or `{-1, -1}` if not found.
        // The result is stored in the `ans` array.

        System.out.println(Arrays.toString(ans));
        // Prints the `ans` array to the console using `Arrays.toString()` for a user-friendly representation.
        // For example, if `ans` is `[1, 2]`, it will print "[1, 2]".

        System.out.println(max(arr));
        // Calls the `max` method, passing the 2D array `arr`.
        // The method returns the maximum element found in the array.
        // The result is printed to the console.

        // sc.close(); // It's good practice to close the scanner when done to release system resources.
    }

    static int[] search(int[][] arr, int target) {
        // The `search` method takes a 2D integer array `arr` and an integer `target` as input.
        // It aims to find the `target` value within the `arr`.
        // It returns an `int[]` of size 2: `[row_index, col_index]` if the target is found,
        // or `[-1, -1]` if the target is not found.

        for (int row = 0; row < arr.length; row++) {
            // This is the outer loop, iterating through each row of the 2D array.
            // `arr.length` gives the number of rows in the array.

            for (int col = 0; col < arr[row].length; col++) {
                // This is the inner loop, iterating through each column of the current `row`.
                // `arr[row].length` gives the number of columns in the current row.
                // This handles jagged arrays correctly.

                if (arr[row][col] == target) {
                    // Checks if the element at the current `[row][col]` position is equal to the `target`.
                    return new int[]{row, col};
                    // If the target is found, an array containing its row and column indices is immediately returned.
                    // This exits both loops and the method.
                }
            }
        }
        return new int[]{-1, -1};
        // If the loops complete without finding the target (i.e., no `return` statement was executed),
        // it means the target is not present in the array.
        // In this case, `{-1, -1}` is returned to indicate that the target was not found.
    }

    static int max(int[][] arr) {
        // The `max` method takes a 2D integer array `arr` as input.
        // It aims to find the maximum element within the `arr`.
        // It returns an `int` representing the maximum value found.

        int ans = arr[0][0]; // Initialize `ans` with the first element of the array.
        // Original code `int ans = arr[0][0] = 0;` is problematic.
        // `arr[0][0] = 0;` would assign 0 to the first element of the array, modifying the input array.
        // It should be `int ans = arr[0][0];` to correctly initialize `ans` with the first element's value
        // without modifying the array. If the array could be empty, additional checks would be needed.
        // Assuming `arr` is not empty and `arr[0]` is not empty.

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] > ans) {
                    // If the current element `arr[row][col]` is greater than the current maximum `ans`,
                    // update `ans` to this new maximum value.
                    ans = arr[row][col];
                }
            }
        }
        return ans;
        // After iterating through all elements, `ans` will hold the maximum value found in the array.
        // This maximum value is then returned.
    }
}
