This code illustrates key **Object-Oriented Programming (OOP)** concepts using two classes: `Animal` and `Person`, and shows how to create and work with objects in Java.[1][2]

## OOP Concepts in the Code

### Class as Blueprint

- `Animal` and `Person` represent blueprints with fields (attributes) like `name`, `breed`, `colour`, `age` (for Animal), and `name`, `nationality`, `weight`, `age` (for Person).[2][1]
- These fields define the properties every object created from these classes will have.

### Object Creation (Instantiation)

- `Animal dog = new Animal();`
    - Here, `dog` is an **object** or **instance** of the `Animal` class.
    - This object has its own copy of the fields defined in the class.[1][2]

### Setting Attribute Values

- Fields are assigned specific values:
    - `dog.name = "Rocky";`
    - `dog.colour = "Brown";`
    - `dog.breed = "German Sheperd";`
    - `dog.age = 12;`
- Each object’s fields hold their own data, separate from other instances.[3]

### Accessing Attributes

- `System.out.println(dog.name);` prints `Rocky`—accessing the object's data using dot notation.

## Real-World Analogy

Think of `Animal` as a template for pets at a shelter:
- Each pet gets its own file (object) based on the template (class).
- The file is filled out with actual information about the pet (field values).

## How This Illustrates OOP

- **Encapsulation:** Data (name, age, breed, etc.) is bundled into objects, keeping related information together.[3][1]
- **Reusability:** More animals (e.g., cats, birds) can be created from the same `Animal` blueprint, each with unique values.
- **Abstraction:** The details of the animal are modeled as high-level attributes; the implementation details are hidden.

## Summary Table

| OOP Concept     | Example in Code                                |
|-----------------|------------------------------------------------|
| Class Blueprint | `class Animal { ... }`                         |
| Instantiation   | `Animal dog = new Animal();`                   |
| Attribute Setting | `dog.name = "Rocky"; dog.breed = ...`        |
| Attribute Access | `System.out.println(dog.name);`               |

This approach allows programmers to create many different objects (animals or people), each with their own details, but all following the logic of their respective blueprints—in full alignment with OOP principles.[2][1][3]

A real-world example of object-oriented programming (OOP) is modeling different cars in a car showroom.[3][4]

## Real-World Example: Car in a Showroom

Imagine a car showroom that sells various types of cars. Each car has its own brand, model, color, and price, but all cars share common characteristics and behaviors, such as being able to start, stop, or display details.

### Class Representation

In OOP, a **class** acts as a blueprint for cars:

```java
class Car {
    String brand;
    String model;
    String color;
    double price;

    void start() {
        System.out.println(brand + " " + model + " is starting.");
    }

    void stop() {
        System.out.println(brand + " " + model + " is stopping.");
    }

    void displayDetails() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Color: " + color + ", Price: " + price);
    }
}
```

### Creating Car Objects

Each **object** represents a specific car in the showroom:

```java
Car car1 = new Car();
car1.brand = "Toyota";
car1.model = "Camry";
car1.color = "Red";
car1.price = 25000.0;

Car car2 = new Car();
car2.brand = "Honda";
car2.model = "Civic";
car2.color = "Blue";
car2.price = 22000.0;
```

Each car object has its unique details but also the abilities (methods) defined for all cars.[4][3]

### How This Relates to OOP

- **Class = Car blueprint**: Defines what information and actions all cars have.
- **Object = Individual car**: Each car in the showroom, with its own characteristics and abilities.
- **Encapsulation**: Data about each car is bundled within each object.
- **Reusability**: Can easily create as many car objects as needed for the showroom, all based on the `Car` class.

This real-world scenario demonstrates how OOP helps manage complexity by organizing similar entities into classes and creating multiple unique instances (objects), just as a real showroom manages many cars efficiently.[3][4]
