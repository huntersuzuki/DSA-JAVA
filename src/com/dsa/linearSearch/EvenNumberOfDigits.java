package com.dsa.linearSearch;

// Find numbers with an even number of digits.
// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/
public class EvenNumberOfDigits {
    static void main() {
        // This is the main method, the entry point of the program.
        // It's declared as 'static void main()' which is a common convention
        // for a simple executable block in Java, though typically it would be
        // 'public static void main(String[] args)' for a standard Java application.

        int[] nums = {12, 345, 2, 6, 7896};
//        int result = findNumbers(nums);
//        System.out.println(result);
        System.out.println(digits2(87685));
    }

    static int findNumbers(int[] nums) {
        // This method counts how many numbers in an array have an even number of digits.

        int count = 0;
        // Initialize a counter to keep track of numbers with an even number of digits.

        for (int num : nums) {
            // Iterate through each number in the input array 'nums'.

            if (even(num)) {
                // Call the 'even' method to check if the current number 'num' has an even number of digits.
                // If it does, increment the 'count'.
                count++;
            }
        }
        return count;
        // Return the total count of numbers with an even number of digits.
    }

    static boolean even(int num) {
        // This method checks if a given number has an even number of digits.

        int numberOfDigits = digits(num);
        // Call the 'digits' method to get the total number of digits in 'num'.

        if (numberOfDigits % 2 == 0) {
            // If the number of digits is perfectly divisible by 2 (i.e., it's an even number),
            // then return true.
            return true;
        }
        return false;
        // Otherwise, return false.
    }

    static int digits2(int num) {
        // This method calculates the number of digits in an integer using a mathematical approach (logarithm).
        // It's generally more efficient for very large numbers than iterative division.

        if (num < 0) {
            // If the number is negative, convert it to its positive equivalent.
            // The number of digits is the same for -123 and 123.
            num = num * -1;
        }
        if (num == 0) {
            // The number 0 has one digit. Handle this as a special case because log10(0) is undefined.
            return 1;
        }
        return (int) (Math.log10(num)) + 1;
        // The base-10 logarithm of a number gives you roughly the power to which 10 must be raised
        // to get that number. For example:
        // log10(1) = 0
        // log10(9) = 0.95...
        // log10(10) = 1
        // log10(99) = 1.99...
        // log10(100) = 2
        //
        // By taking the floor (casting to int) and adding 1, we get the number of digits.
        // For example:
        // For num = 12: log10(12) is approx 1.079. (int)1.079 is 1. 1 + 1 = 2 digits.
        // For num = 345: log10(345) is approx 2.537. (int)2.537 is 2. 2 + 1 = 3 digits.
        // This method works for positive integers.
    }

    static int digits(int num) {
        // This method calculates the number of digits in an integer using an iterative division approach.

        if (num < 0) {
            // If the number is negative, convert it to its positive equivalent.
            // The number of digits is the same for -123 and 123.
            num = num * -1;
        }
        if (num == 0) {
            // The number 0 has one digit. Handle this as a special case.
            return 1;
        }
        int count = 0;
        // Initialize a counter for the number of digits.

        while (num > 0) {
            // Loop as long as the number is greater than 0.
            // In each iteration, we effectively "remove" the last digit.

            count++;
            // Increment the digit count.

            num = num / 10;
            // Integer division by 10 removes the last digit.
            // Example:
            // num = 123
            // 1. count = 1, num = 123 / 10 = 12
            // 2. count = 2, num = 12 / 10 = 1
            // 3. count = 3, num = 1 / 10 = 0
            // Loop terminates because num is no longer > 0.
        }
        return count;
        // Return the total count of digits.
    }
}
