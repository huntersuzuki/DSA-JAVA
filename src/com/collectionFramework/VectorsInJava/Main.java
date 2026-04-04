package com.collectionFramework.VectorsInJava;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;


public class Main {
    public static void main(String[] args) {
        // The default capacity of a vector is 10.
        // We can give an initial capacity value into its constructor.
//        Vector<Integer> vector = new Vector<>(5,3);
//        vector.add(1);
//        vector.add(1);
//        vector.add(1);
//        vector.add(1);
//        vector.add(1);
//        System.out.println(vector.capacity());
//        vector.add(1);
//        System.out.println(vector.capacity());
//
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        linkedList.add(22);
//        linkedList.add(89);
//        linkedList.add(69);
//        linkedList.add(67);
//        Vector<Integer> vector1 = new Vector<>(linkedList);
//        System.out.println(vector1);


//        ArrayList<Integer> list = new ArrayList<>();
        Vector<Integer> list = new Vector<>();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Size of list: "+ list.size());
    }
}