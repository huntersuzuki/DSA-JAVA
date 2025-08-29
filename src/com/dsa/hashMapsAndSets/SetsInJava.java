package com.dsa.hashMapsAndSets;

import java.util.HashSet;
import java.util.Set;

public class SetsInJava {
    public static void main(String[] args) {
        // Sets are arrays but without duplicate values.
        // What it means is that a set cannot have any duplicate values.
        // Example -
        // array - [1,2,2,3,4]
        // set - [1,2,3,4], in set the duplicate 2 is ignored.
        // Implementation as follows -

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(2);
        set.add(3);
        set.add(4);
        System.out.println(set);
        // Output - [1, 2, 3, 4]
        // The duplicate value is ignored.
    }
}
