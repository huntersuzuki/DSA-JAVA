package com.collectionFramework.MapInJava;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapDemo {
	public static void main(String[] args) {
		String key1 = new String("key");
		String key2 = new String("key");
		// This does not use "equals" method to create a hash code, rather uses "==" to
		// check the memory address, thus it returns different hash codes.
		System.out.println(System.identityHashCode(key1)); // Different hash code.
		System.out.println(System.identityHashCode(key2)); // Different hash code.
		// This uses "equals" method which checks the value instead of the memory
		// address, this it returns same hash code.
		System.out.println(key1.hashCode());// Same hash code.
		System.out.println(key2.hashCode());// Same hash code.
//		Map<String, Integer> map = new HashMap();
		Map<String, Integer> map = new IdentityHashMap<>();
		map.put(key1, 1);
		map.put(key2, 2);
		System.out.println(map);
	}
}
