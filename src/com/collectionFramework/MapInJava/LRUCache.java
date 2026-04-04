package com.collectionFramework.MapInJava;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRUCache (Least Recently Used Cache) Implementation
 * 
 * This code demonstrates how to implement an LRU cache using Java's LinkedHashMap.
 * An LRU cache automatically removes the least recently used items when it reaches
 * its maximum capacity. This is a fundamental data structure concept used in:
 * - Memory management systems
 * - Web caching (browser cache, CDN)
 * - Database query result caching
 * - Operating systems page replacement algorithms
 */
public class LRUCache<K,V> extends LinkedHashMap<K,V> {

    private int capacity;
    
    /**
     * Constructor initializes the cache with specified capacity
     * @param capacity - maximum number of entries the cache can hold
     * 
     * Key teaching point: We call super(capacity, 0.75f, true) where:
     * - capacity: initial capacity
     * - 0.75f: load factor (when to resize)
     * - true: accessOrder = true (CRITICAL - this enables LRU behavior)
     *   When accessOrder is true, LinkedHashMap maintains entries in order
     *   from least-recently-accessed to most-recently-accessed
     */
    public LRUCache(int capacity){
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    /**
     * This is the core method that makes LRU work
     * LinkedHashMap calls this method after each put() operation
     * 
     * @param eldest - the entry that was accessed least recently
     * @return true if the eldest entry should be removed, false otherwise
     * 
     * Teaching point: By returning true when size() > capacity,
     * we automatically remove the least recently used entry
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    /**
     * Demo showing LRU cache behavior
     * 
     * Expected output after execution:
     * {Alice=89, Ram=91, Vipul=89}
     * 
     * Explanation:
     * 1. Put Bob, Alice, Ram (cache now has 3 entries)
     * 2. Put Vipul (exceeds capacity of 3)
     * 3. removeEldestEntry() removes "Bob" (least recently used)
     * 4. Final cache contains Alice, Ram, Vipul (in order of recent access)
     */
    public static void main(String[] args) {
        LRUCache<String,Integer> studentMap = new LRUCache<>(3);
        studentMap.put("Bob",99);
        studentMap.put("Alice",89);
        studentMap.put("Ram",91);
        studentMap.put("Vipul",89);
        System.out.println(studentMap);
    }
}
