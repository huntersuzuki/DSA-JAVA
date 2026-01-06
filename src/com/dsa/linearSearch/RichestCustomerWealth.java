package com.dsa.linearSearch;

/**
 * This class, `RichestCustomerWealth`, provides a method to find the maximum wealth among a
 * group of customers, where each customer's wealth is represented by the sum of their bank accounts.
 * <p>
 * The problem statement is typically:
 * You are given an `m x n` integer grid `accounts` where `accounts[i][j]` is the amount of money
 * the `i`-th customer has in the `j`-th bank. Return the wealth that the richest customer has.
 * A customer's wealth is the total money they have in all their bank accounts.
 * The richest customer is the customer that has the maximum wealth.
 */
public class RichestCustomerWealth {

    /**
     * The main method serves as the entry point for the program.
     * It demonstrates how to use the `maximumWealth` method.
     *
     * @param args Command line arguments (not used in this program).
     */
    static void main(String[] args) {
        // Example input: a 2D array representing customer accounts.
        // Each inner array represents a customer's accounts.
        // For example:
        // Customer 0: {1, 5} -> Wealth = 1 + 5 = 6
        // Customer 1: {7, 3} -> Wealth = 7 + 3 = 10
        // Customer 2: {3, 5} -> Wealth = 3 + 5 = 8
        int[][] arr = {
                {1, 5},
                {7, 3},
                {3, 5}};

        // Create an instance of the RichestCustomerWealth class to call its methods.
        RichestCustomerWealth rcw = new RichestCustomerWealth();

        // Call the maximumWealth method with the example array and print the result.
        // The expected output for this example is 10 (from customer 1).
        System.out.println(rcw.maximumWealth(arr));
    }

    /**
     * Calculates the maximum wealth among all customers.
     *
     * @param accounts A 2D integer array where `accounts[i][j]` represents the amount of money
     *                 the `i`-th customer has in the `j`-th bank.
     * @return The maximum wealth found among all customers.
     */
    public int maximumWealth(int[][] accounts) {
        int maxValue = 0; // Initialize maxValue to 0. This variable will store the maximum wealth found so far.

        // Outer loop: Iterates through each customer (each row in the 2D array).
        for (int row = 0; row < accounts.length; row++) { // `accounts.length` gives the number of customers.
            int currentCustomerWealth = 0; // Initialize currentCustomerWealth to 0 for each new customer.
            // This is crucial: it resets the sum for every customer.

            // Inner loop: Iterates through each bank account for the current customer (each column in the current row).
            for (int col = 0; col < accounts[row].length; col++) { // `accounts[row].length` gives the number of accounts for the current customer.
                currentCustomerWealth += accounts[row][col]; // Add the amount in the current account to the customer's total wealth.
            }

            // After calculating the total wealth for the current customer, compare it with the `maxValue` found so far.
            if (currentCustomerWealth > maxValue) {
                maxValue = currentCustomerWealth; // If the current customer's wealth is greater, update `maxValue`.
            }
        }
        return maxValue; // Return the final maximum wealth found after checking all customers.
    }
}
