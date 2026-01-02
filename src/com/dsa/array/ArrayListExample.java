package com.dsa.array;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class demonstrates the basic operations of ArrayList in Java.
 * ArrayList is a resizable array implementation of the List interface.
 */
public class ArrayListExample {

    /**
     * Main method to demonstrate ArrayList operations.
     * Note: This should have 'String[] args' parameter to be a proper Java entry point.
     */
    public static void main(String[] args) {
       // Create a Scanner object to read user input
       Scanner sc = new Scanner(System.in);
       
       // Initialize an empty ArrayList that will store Integer values
       // The diamond operator <> infers the type from the left side (Integer)
       ArrayList<Integer> list = new ArrayList<>();
       
       // Adding elements to the ArrayList using add() method
       // Elements are added to the end of the list
       list.add(25);  // Adds 25 at index 0
       list.add(67);  // Adds 67 at index 1
       list.add(89);  // Adds 89 at index 2
       list.add(90);  // Adds 90 at index 3
       list.add(55);  // Adds 55 at index 4
       list.add(72);  // Adds 72 at index 5
       list.add(23);  // Adds 23 at index 6
       // Print the entire list
       // ArrayList's toString() is automatically called, showing all elements in square brackets
       System.out.println("Original list: " + list);
       
       // Update the element at index 0 to 99
       // set() replaces the element at the specified position
       list.set(0, 99);
       System.out.println("After setting index 0 to 99: " + list);
       
       // Remove the element at index 2 (third element)
       // All subsequent elements are shifted to the left
       list.remove(2);
       System.out.println("After removing element at index 2: " + list);

       // Adding user input to the ArrayList
       System.out.println("Enter 5 integers to add to the list:");
       for (int i = 0; i < 5; i++) {
           // Read an integer from user input and add to the end of the list
           list.add(sc.nextInt());
       }
       
       // Accessing and printing elements using get()
       System.out.println("First 5 elements of the list:");
       for (int i = 0; i < 5; i++) {
           // get() retrieves the element at the specified index
           System.out.println("Element at index " + i + ": " + list.get(i));
       }
       
       // Note: The list can grow beyond its initial size
       System.out.println("Final size of the list: " + list.size());
       
       // Close the scanner to prevent resource leak
       sc.close();
    }
    
    /*
     * Key ArrayList Features Demonstrated:
     * 1. Dynamic resizing - grows automatically as elements are added
     * 2. Type safety - uses generics to ensure type consistency
     * 3. Common operations:
     *    - add(element): Appends to the end
     *    - set(index, element): Updates at specific position
     *    - remove(index): Removes element at position
     *    - get(index): Retrieves element at position
     *    - size(): Returns current number of elements
     * 4. Zero-based indexing
     */
}