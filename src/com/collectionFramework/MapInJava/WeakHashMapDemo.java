package com.collectionFramework.MapInJava;

import java.util.WeakHashMap;

//This code is a classic demonstration of how WeakHashMap manages memory automatically. In a standard HashMap, entries stay in memory as long as the Map itself exists. In a WeakHashMap, an entry is automatically removed when its key is no longer in use elsewhere in the program.
//
//1. Key Technical Concepts
//The Key is the Weak Link: The "Weak" in WeakHashMap refers to the keys, not the values. If the key object is garbage collected, the value is automatically removed from the map.
//
//The String Pool Trap: Notice you used new String("img1") instead of just "img1". This is intentional. String literals are stored in a special "Constant Pool" and are never garbage collected. Using new String() ensures the key is a unique object on the heap that can be collected.
//
//GC Trigger: System.gc() is a request to Java to clean up memory. When it runs, it sees that key1 and key2 are null, meaning no one "strongly" holds those String objects anymore—except for the Map's "weak" hold. The GC then reclaims them.

public class WeakHashMapDemo {
	public static void main(String[] args) {
		// 1. WeakHashMap stores its keys as WeakReferences.
		// If a key is not used anywhere else (no strong references), the entry is
		// deleted.
		WeakHashMap<String, Image> imageCache = new WeakHashMap<>();

		/*
		 * IMPORTANT: We create String objects using 'new'. If we used
		 * imageCache.put("img1", ...), the literal "img1" would stay in the String Pool
		 * forever, and the entry would NEVER be cleared.
		 */
		String key1 = new String("img1"); // Strong reference to the string object
		String key2 = new String("img2"); // Strong reference to the string object

		// 2. Put objects in the cache.
		// Even though it's a WeakHashMap, the entries are safe right now
		// because 'key1' and 'key2' are still alive in this method.
		imageCache.put(key1, new Image("Image 1"));
		imageCache.put(key2, new Image("Image 2"));

		System.out.println("Initial Cache Content: " + imageCache);

		// 3. Make the keys eligible for Garbage Collection.
		// By setting them to null, there are NO MORE strong references to
		// the "img1" and "img2" objects on the heap.
		key1 = null;
		key2 = null;

		// 4. Explicitly suggest to the JVM to run Garbage Collection.
		// The GC will see that the keys are only held by 'WeakReferences'
		// inside the map and will reclaim their memory.
		System.gc();

		// 5. We wait to allow the GC thread time to finish its work.
		simulateApplicationRunning();

		/*
		 * 6. The final check. WeakHashMap internally cleans itself up when you call
		 * methods like toString(), size(), or get(). You will likely see {} (empty map)
		 * because the GC cleared the keys and the map dropped the values.
		 */
		System.out.println("Cache after running (some entries may be cleared): " + imageCache);
	}

	private static void simulateApplicationRunning() {
		try {
			System.out.println("Simulating Application running (waiting for GC)..........");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Image {
	private String name;

	public Image(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Image [name=" + name + "]";
	}
}
//3. Why use this in real life?
//Imagine you are building a photo gallery app. You cache high-resolution images. If you use a normal HashMap, your app will eventually run out of memory and crash because the Map keeps holding those images. By using WeakHashMap, the "Cache" will automatically shrink and clear out old images as soon as the rest of your app stops using them.