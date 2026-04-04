package com.collectionFramework.MapInJava;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(101,"Pranay");
        map.put(102,"Neha");
        map.put(103,"Priya");
//        map.put(null,"Ram"); // There cannot be more than one null key.
//        map.put(null,"Shriya"); // By writing this the ("null,"Ram") is replaced with (null,"Shriya").
        // Here the same phenomenon is happening because keys should be unique.
//        map.put(104,"Ameya");
//        map.put(104,"Megha");
        System.out.println(map);
        String student = map.get(102);
        System.out.println(student);
        System.out.println(map.containsKey(104));
        System.out.println(map.containsValue("Pranay"));

        Set<Integer> keys = map.keySet();
        for (int i:keys){
            System.out.println(map.get(i));
        }

        Set<Map.Entry<Integer,String>>entries =  map.entrySet();
        for (Map.Entry<Integer, String> entry: entries){
            System.out.println(entry.getKey() + ": " + entry.getValue());
            entry.setValue(entry.getValue().toUpperCase());
        }
        System.out.println(entries);


    }
}
