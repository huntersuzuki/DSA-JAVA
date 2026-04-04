package com.collectionFramework.ArrayListExplained;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * This class demonstrates the behavior of CopyOnWriteArrayList.
 * <p>
 * Key Concept:
 * CopyOnWriteArrayList is a thread-safe variant of ArrayList.
 * For every 'mutative' operation (add, set, remove), it creates a fresh copy of the underlying array.
 * <p>
 * Why use it?
 * 1. Thread Safety: It is designed for scenarios where reads vastly outnumber writes.
 * 2. No ConcurrentModificationException: The iterator reads from the "snapshot" of the array
 * taken at the time the iterator was created, so you can modify the list while iterating.
 */
public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        // Creating a CopyOnWriteArrayList
        List<String> shoppingList = new CopyOnWriteArrayList<>();
        shoppingList.add("Milk");
        shoppingList.add("Eggs");
        shoppingList.add("Bread");

        System.out.println("Initial Shopping list: " + shoppingList);

        // Demonstrating fail-safe iteration:
        // Unlike a regular ArrayList, this will NOT throw ConcurrentModificationException
        for (String list : shoppingList) {
            System.out.println(list);
            if (list.equals("Eggs")) {
                // This modification happens on a new copy of the array.
                // The current loop continues using the original snapshot.
                shoppingList.add("Butter");
                System.out.println("Added butter while adding");
            }
        }
        System.out.println("Updated Shopping list: " + shoppingList);
    }
}
