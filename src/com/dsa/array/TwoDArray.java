package com.dsa.array;

public class TwoDArray {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,4,5};
        int[] arr2 = new int[]{6,7,8,9,10};
        int[][] arr2d = new int[][]{arr1,arr2};// This is our 2d array.
        // now if we want to access an element from an array,
        // example element at index 1 from arr1.
        // Implementation as follows -
        System.out.println("Extracting Element at index 1 from arr1 array ");
        System.out.println("The Extracted element is: "+arr2d[0][1]);// Output - 2
        // Printing the entire 2D array using loops.
        // Implementation as follows -
        System.out.println("Traversing the entire 2D array.The elements are printed as follows - ");
        for (int i = 0; i < arr2d.length; i++) {
            for(int j = 0;j<arr2d[i].length;j++){
                System.out.print(arr2d[i][j]+", ");
            }
            System.out.println();
        }
    }
}
