
---

## 🧠 Concept Involved:

You're dealing with **multiple inheritance of default methods** from interfaces in Java.

---

### ✅ Java 8 Interfaces Can Have:

* **Abstract methods** – the old way.
* **Default methods** – introduced in Java 8.
* **Static methods**

So, in this example:

```java
interface A {
    default void sayHello() {
        System.out.println("Hello from interface A");
    }
}
```

and

```java
interface B {
    default void sayHello() {
        System.out.println("Hello from interface B");
    }
}
```

Each interface has its own `sayHello()` default implementation.

---

## 🚨 The Diamond Problem (Multiple Default Methods)

Now, your class `MyClassTwo` implements **both** interfaces:

```java
public class MyClassTwo implements A, B {
    ...
}
```

So, Java asks:

> "Which `sayHello()` should be called? `A`'s or `B`'s?"

This causes a **conflict**, often called the **diamond problem**.

---

## 🔥 What Happens if You Don’t Override?

If you **do not override `sayHello()`** in `MyClassTwo`, the compiler will give an **error**:

```
Error: class MyClassTwo inherits unrelated defaults for sayHello() from types A and B
```

So you **must override** the method in your class to **resolve the conflict**.

---

## ✅ The Correct Solution

You provide your own implementation of `sayHello()` in `MyClassTwo`:

```java
@Override
public void sayHello() {
    A.super.sayHello(); // Explicitly calling A's version
    // OR
    System.out.println("Hello from overridden method");
}
```

### 🔍 Explanation:

* `A.super.sayHello();` — tells the compiler:

  > "I want to call the `sayHello()` from **interface A**, not B."

* This is a **qualified super call** — allowed in Java **only when dealing with default methods in interfaces**.

* After that, you also add your own print statement:

  ```java
  System.out.println("Hello from overridden method");
  ```

So the final output will be:

```
Hello from interface A
Hello from overridden method
```

---

## ✅ Full Execution Flow

```java
public static void main(String[] args) {
    MyClassTwo myClassTwo = new MyClassTwo();
    myClassTwo.sayHello();
}
```

Output:

```
Hello from interface A
Hello from overridden method
```

---

## 🧠 Summary of Key Points:

| Concept                           | Explanation                                                                                         |
| --------------------------------- | --------------------------------------------------------------------------------------------------- |
| Default Method                    | Introduced in Java 8, allows interfaces to have method bodies.                                      |
| Multiple Interface Implementation | A class can implement many interfaces.                                                              |
| Conflict in Default Methods       | If two interfaces have the same default method, you **must override it** in the implementing class. |
| Resolving Conflict                | Use `InterfaceName.super.methodName()` to specify which version you want.                           |
| Why Override is Mandatory         | Java doesn't know which version to pick — to avoid ambiguity, it forces you to decide.              |

---

## ✅ Bonus: General Rule

> **“Class wins”** rule: If a method is defined in the class, it overrides interface default methods.

---

