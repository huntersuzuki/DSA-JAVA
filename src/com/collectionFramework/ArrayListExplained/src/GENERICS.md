### What are Java Generics?

Java Generics allow you to use types (classes and interfaces) as parameters when defining classes, interfaces, and methods. Think of generics as "variables for types." Just as you pass arguments to a method, you can pass a specific type to a generic class or method.

Before generics were introduced in Java 5, collections could hold any object, which often led to runtime errors if you accidentally mixed data types. Generics solve this by enforcing type checking at compile time.

---

### Why Use Generics?

* **Stronger Type Safety:** Generics shift type-checking from runtime to compile time. If you try to put an integer into a list of strings, the compiler will catch the error immediately, preventing a `ClassCastException` later down the line.
* **Elimination of Type Casting:** When pulling an object out of a collection without generics, you have to cast it to its specific type. With generics, the compiler already knows the type, so no casting is needed.
* **Code Reusability:** You can write a single class or method that works safely with multiple different data types.

---

### How Generics Work (Code Example)

Here is a look at how collections operated before generics, compared to how they work with generics:

**Before Generics (Prone to runtime errors):**

```java
List names = new ArrayList();
names.add("Alice");
names.add(100); // The compiler allows this!

// This will throw a ClassCastException at runtime
String name = (String) names.get(1);

```

**With Generics (Type-safe):**

```java
List<String> names = new ArrayList<>();
names.add("Alice");
// names.add(100); // The compiler will flag this as an error immediately!

// No casting required
String name = names.get(0);

```

---

### Common Generic Naming Conventions

When you look at Java documentation or write your own generic classes, you will usually see single uppercase letters used as type parameters. While you can technically use any valid identifier, these are the standard conventions:

| Parameter | Meaning | Typical Usage |
| --- | --- | --- |
| **`T`** | Type | Used for a generic, standard type parameter. |
| **`E`** | Element | Used extensively in the Java Collections Framework (e.g., `List<E>`). |
| **`K`** | Key | Used in maps (e.g., `Map<K, V>`). |
| **`V`** | Value | Used in maps alongside the key. |
| **`N`** | Number | Used when the type parameter must be a numeric type. |

Would you like me to walk through how to create your own custom generic class or method?