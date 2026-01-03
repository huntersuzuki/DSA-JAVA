package com.dsa.linearSearch;

import java.util.Scanner;

/**
 * This class demonstrates linear search operations on strings.
 * It provides two implementations to search for a character in a string:
 * 1. Using traditional for loop with index
 * 2. Using enhanced for loop with character array
 */
public class SearchString {

/**
     * Main method to demonstrate character search in a string.
     * Takes user input for the character to search and displays the result.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String searchString = "Pranay";
        System.out.println("Enter a character you want to search: ");
        char target = sc.next().charAt(0);
//        boolean result = searchString(searchString, target);
        boolean result2 = searchString2(searchString, target);
        System.out.println(result2);
    }

    /**
     * Searches for a character in a string using traditional for loop.
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(1) - no additional space required
     *
     * @param str    The string to search in
     * @param target The character to search for
     * @return true if character is found, false otherwise
     */
    static boolean searchString(String str, char target) {
        // Handle empty string case
        if (str.length() == 0) {
            return false;
        }
        
        // Iterate through each character in the string
        for (int i = 0; i < str.length(); i++) {
            // Compare current character with target character
            if (target == str.charAt(i)) {
                return true;  // Character found
            }
        }
        return false;  // Character not found
    }

    /**
     * Searches for a character in a string using enhanced for loop.
     * More readable alternative to the index-based search.
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(n) - creates a new character array
     *
     * @param str    The string to search in
     * @param target The character to search for
     * @return true if character is found, false otherwise
     */
    static boolean searchString2(String str, char target) {
        // Handle empty string case
        if (str.length() == 0) {
            return false;
        }
        
        // Convert string to character array and iterate
        for (char ch : str.toCharArray()) {
            // Compare current character with target character
            if (target == ch) {
                return true;  // Character found
            }
        }
        return false;  // Character not found
    }

}
