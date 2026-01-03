package com.dsa.linearSearch;

import java.util.Scanner;

/**
 * This program demonstrates searching for a character within a specified range of a string.
 * It uses linear search algorithm to find the target character between given start and end indices.
 */
public class SearchStringInRange {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner sc = new Scanner(System.in);
        
        // Initialize the string to search in and convert it to a character array
        String searchString = "dhurandhar";
        char[] charArray = searchString.toCharArray();
        
        // Get the target character from user
        System.out.println("Enter the character you want to search: ");
        char target = sc.next().charAt(0);
        
        // Get the search range from user
        System.out.println("Enter the start and end position (0-based index): ");
        int start = sc.nextInt();
        int end = sc.nextInt();
        
        // Perform the search and store the result
        boolean result = searchStringInRange(charArray, target, start, end);
        
        // Print the search result
        System.out.println("Character '" + target + "' " + 
                         (result ? "was found" : "was not found") + 
                         " in the specified range.");
    }

    /**
     * Searches for a target character within a specified range of a character array.
     * 
     * @param chars  The character array to search in
     * @param target The character to search for
     * @param start  The starting index of the search range (inclusive)
     * @param end    The ending index of the search range (inclusive)
     * @return       true if target is found within the range, false otherwise
     */
    static boolean searchStringInRange(char[] chars, char target, int start, int end) {
        // Input validation
        if (chars == null || chars.length == 0) {
            System.out.println("Error: The character array is empty or null.");
            return false;
        }
        
        // Validate the range
        if (start < 0 || end >= chars.length || start > end) {
            System.out.println("Error: Invalid range specified.");
            return false;
        }

        // Perform linear search within the specified range
        // Note: Using <= to include the end index in the search
        for (int i = start; i <= end; i++) {
            if (target == chars[i]) {
                return true;  // Character found
            }
        }
        
        return false;  // Character not found in the specified range
    }
}
