package com.dsa.staticKeyword;

class Person{
    public int age;              // Non-static variable - har object ki apni copy hogi
    public String name;          // Non-static variable - har object ki apni copy hogi
    static int count;            // Static variable - sirf ek copy hogi saare objects ke liye

    // Constructor - jab bhi nayi Person object banti hai, ye execute hota hai
    Person(){
        count++;  // Har baar jab object banegi, ye static variable increment hoga
        // Ye sab objects ke liye common hai, toh ye track karega kitni objects bani
    }
}

public class LearningStaticKeyword {

    public static void main(String[] args) {

        // Pehli Person object create ki - count ban gaya 1
        Person pranay = new Person();

        // Doosri Person object create ki - count ban gaya 2
        Person manisha = new Person();

        // Teesri Person object create ki - count ban gaya 3
        Person vishal = new Person();

        // Har object ke liye alag-alag age assign kar sakte ho
        // Kyunki age non-static hai, toh har object ki apni copy hai
        pranay.age = 24;
        manisha.age = 46;
        vishal.age = 35;

        // Manisha ki age print hogi - 46
        System.out.println(manisha.age);

        // Static variable ko access karne ka sahi tarika - Class name se
        // Ye print karega "Total users: 3"
        // Kyunki 3 objects create hui thi aur har baar constructor ne count++ kiya
        System.out.println("Total users: "+Person.count);
    }
}
/*
* Key Points Jo Samajhne Zaroori Hain
Non-static variables (age, name): Har object ki apni alag copy hoti hai. Agar aap pranay.age = 24 karo, toh sirf pranay ki age change hogi, manisha ki nahi.

Static variable (count): Poori class ki sirf ek copy hoti hai. Teen objects bani, lekin count variable ki sirf ek copy hai memory mein jo teeno share kar rahe hain. Isliye jab bhi koi bhi object banti hai aur constructor mein count++ hota hai, wo same variable increment ho raha hai.

Access karne ka tarika: Static variables ko class name se access karna chahiye: Person.count. Aap pranay.count bhi likh sakte ho, but ye recommended nahi hai kyunki ye confusion create karta hai.

Memory efficiency: Static keyword ka main purpose memory manage karna hai. Agar aap 1000 Person objects banao aur count static na ho, toh memory waste hogi. But static hone se sirf ek copy memory mein rahegi jo sab share karenge.

Aapke code mein count variable counter ki tarah kaam kar raha hai jo track kar raha hai kitni Person objects create hui hain. Ye pattern bahut common hai jab aapko count rakhna ho ki kitne instances bane hain
* */