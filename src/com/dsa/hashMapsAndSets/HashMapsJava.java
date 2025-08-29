package com.dsa.hashMapsAndSets;

import java.util.HashMap;
import java.util.Map;

public class HashMapsJava {
    public static void main(String[] args) {
        // HashMaps in java is used to store key value pairs.
        // Example -
        // Student roll number
        // key value     key value       key value
        // 1 - pranay    2 - aditi       3 - john
        // Hashmaps also have a very fast lookup, which means it can retrieve,
        // data very quickly.
        // Implementation is as follows -

        Map<Integer,String> map = new HashMap<>();
        map.put(1,"Pranay");
        map.put(2,"Aditi");
        map.put(3,"John");

//        System.out.println(map.get(2));
        // Output - Aditi
        // Beacuse at key 2 value Aditi is assigned.

        map.put(1,"Pranay Bhoir");
        System.out.println(map.get(1));
        // Output - Pranay Bhoir
        // The value will get overwritten.
    }
}
