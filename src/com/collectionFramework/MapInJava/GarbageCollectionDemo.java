package com.collectionFramework.MapInJava;

import java.lang.ref.WeakReference;

public class GarbageCollectionDemo {
    public static void main(String[] args) {
        
        /*
         * SECTION 1: STRONG REFERENCE
         * Most objects you create (e.g., String s = "hello") are Strong References.
         * The Garbage Collector will NEVER reclaim an object as long as a strong 
         * reference points to it.
         */
        Phone phone = new Phone("Apple", "17 pro max"); // 'phone' is a strong reference
        System.out.println("Before nulling: " + phone);
        
        // By setting phone to null, we break the link to the object.
        // The object is now "unreachable" and eligible for Garbage Collection.
        phone = null;
        System.out.println("After nulling strong ref: " + phone);

        System.out.println("--- Switching to Weak Reference Demo ---");

        /*
         * SECTION 2: WEAK REFERENCE
         * A WeakReference allows you to point to an object without "pinning" it in memory.
         * If the JVM performs a Garbage Collection and finds that an object is ONLY
         * reachable via WeakReferences, it will clear it immediately.
         */
        
        // We wrap our Phone object inside a WeakReference container.
        WeakReference<Phone> phWeakReference = new WeakReference<>(new Phone("Apple", "17 pro max"));
        
        // .get() returns the object if it still exists in memory.
        System.out.println("Before GC: " + phWeakReference.get());

        /*
         * System.gc() is a hint to the JVM to run the Garbage Collector.
         * While not guaranteed to run immediately, it usually does in simple demos.
         * Because the Phone object inside phWeakReference has NO strong references 
         * pointing to it, the GC will see it as "disposable".
         */
        System.gc();

        // We sleep to give the Garbage Collector thread time to finish its work.
        try {
            Thread.sleep(5000); 
        } catch (InterruptedException ignored) {
            // Standard practice for handling sleep interruptions
        }

        /*
         * If the GC ran, phWeakReference.get() will now return 'null'.
         * This proves the object was deleted from the heap despite our 
         * phWeakReference still existing.
         */
        System.out.println("After GC: " + phWeakReference.get());
    }
}

class Phone {
    String brand;
    String model;

    public Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Phone [brand=" + brand + ", model=" + model + "]";
    }
    
    // This method is called by the JVM right before an object is destroyed.
    @Override
    protected void finalize() {
        System.out.println("GC Notification: The Phone object is being deleted!");
    }
}