// Package declaration - organizes related classes
package com.dsa.array;

// Import necessary Java utility classes
import java.util.ArrayList;  // For using ArrayList
import java.util.Scanner;    // For taking user input

/**
 * This class demonstrates the use of a 2D ArrayList in Java.
 * It creates a 3x3 matrix where each element is read from user input
 * and then prints the entire matrix.
 */
public class TwoDArrayList {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner sc = new Scanner(System.in);

        // Declare and initialize a 2D ArrayList
        // Outer ArrayList contains ArrayLists of Integers
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        // Initialize the 2D ArrayList with 3 rows
        // Each row is a new ArrayList of Integers
        for (int i = 0; i < 3; i++) {
            list.add(new ArrayList<>());  // Add a new empty row
        }

        // Nested loop to read and store 9 integers (3x3 matrix)
        // Outer loop for rows
        for (int i = 0; i < 3; i++) {
            // Inner loop for columns
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter element at position [" + i + "][" + j + "]: ");
                // Read integer input and add it to the current row
                list.get(i).add(sc.nextInt());
            }
        }

        // Print the entire 2D ArrayList
        System.out.println("\nThe 2D ArrayList contains:");
        System.out.println(list);

        // Close the scanner to prevent resource leak
        sc.close();
    }
}