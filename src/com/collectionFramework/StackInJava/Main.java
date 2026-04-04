package com.collectionFramework.StackInJava;

import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Create a new Stack object that stores Integers
        Stack<Integer> stack = new Stack<>();

        // push(): Adds elements to the top of the stack (LIFO - Last In, First Out)
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack); // Prints the entire stack: [1, 2, 3, 4, 5]

        stack.pop(); // Removes and returns the top element (5)
        System.out.println(stack); // Prints stack after pop: [1, 2, 3, 4]

        // peek(): Returns the top element without removing it
        System.out.println(stack.peek()); // Output: 4

        // isEmpty(): Checks if the stack has no elements
        System.out.println(stack.isEmpty()); // Output: false

        // size(): Returns the number of elements in the stack
        System.out.println(stack.size()); // Output: 4

        // search(): Returns the 1-based position from the top of the stack
        // In [1, 2, 3, 4], '3' is the 2nd element from the top
        System.out.println(stack.search(3)); // Output: 2
    }
}