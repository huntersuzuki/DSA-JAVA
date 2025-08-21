package com.dsa.array;

import java.util.ArrayList;
import java.util.List;

public class DynamicArrays {
    public static void main(String[] args) {
        // We will be learning about List in java.

        // List is a dynamic array with dynamic size.
        // The size of the list increases according to the element we add.
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(4);
        list.add(140);
        list.add(14);
        System.out.println(list); //Output - [10, 4, 140, 14]
        // To iterate over the list we can use the traditional method which is a for-loop
        // We can use a new version of for-loop called as for-each loop.
        // Implementation as follows -

        for (int x : list){
            System.out.println("Value of x is: "+x);
            // Output -
            /*
                Value of x is: 10
                Value of x is: 4
                Value of x is: 140
                Value of x is: 14
             */
        }
    }
}
