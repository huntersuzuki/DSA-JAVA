package com.dsa.BinarySearch.TwoDimensionBinarySearch.Questions;

import java.util.Arrays;
import java.util.Scanner;

public class SearchInTwoDMatrix {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50}
        };
        System.out.println("Enter the element you want to search: ");
        int target = sc.nextInt();
        int[] ans = search(matrix, target);
        System.out.println(Arrays.toString(ans));
    }

    static int[] search(int[][] matrix, int target) {
        int row = 0;
        int col = matrix.length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return new int[]{row, col};
            }
            if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return new int[]{-1, -1};
    }
}
