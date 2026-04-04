package com.collectionFramework.Linked_List;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(11);
        linkedList.add(12);
        linkedList.add(13);
        linkedList.get(2);
        linkedList.addFirst(2); // Ads an element at the first position
        linkedList.addLast(55); // Ads an element at the last position
        linkedList.getFirst(); // Gets an element at the first position
        linkedList.getLast(); // Gets an element at the last position
        System.out.println(linkedList);
//        linkedList.remove(12);
        linkedList.removeIf(x -> x%2 == 0); //  Removes nodes based on a condition.
        System.out.println(linkedList);

        LinkedList<String> animals = new LinkedList<>(Arrays.asList("Cat","Dog","Elephant"));
        LinkedList<String> animalsToRemove = new LinkedList<>(Arrays.asList("Dog","Lion"));
        animals.removeAll(animalsToRemove);
        System.out.println(animals);
    }
}
