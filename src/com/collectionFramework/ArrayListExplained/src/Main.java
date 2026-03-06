import java.util.ArrayList;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Main{
 public static void main(String[] args) {

     List<Integer> list = new ArrayList<>();
     list.add(3);
     list.add(1);
     list.add(2);
     list.add(4);

     // Converting List to Array
     Integer[] array = list.toArray(new Integer[0]);

    //Sorting the list using sort() method
     Collections.sort(list);
     System.out.println(list);







//     // Before removing value
//     // Output - [1,2,3]
//     System.out.println();
//    list.remove(Integer.valueOf(1));
//     System.out.println(list);
//     // After removing value
//     // Output - [2,3]

























//     // Removing elements using values instead of indexes.
//     // String
//     List<String> fruits = new ArrayList<>();
//     fruits.add("Banana");
//     fruits.add("Banana");
//     fruits.add("Apple");
//     fruits.add("Mango");
//     fruits.add("Papaya");
//     fruits.add("Watermelon");
//     fruits.add("Orange");
//     // Before removing values
//     System.out.println(fruits);
//    // Removing the list of string using remove by value
//     fruits.remove("Banana");
//     System.out.println(fruits);
















//     // We can add elements in the array like the following
//     list.add(1);
//     list.add(2);
//     list.add(3);
//     // Or we can pass another list and add all elements in once.
//
//    List<Integer> list1 =  List.of(4,5,6,7,8,9,10);
//    list.addAll(list1);
//     System.out.println(list);



















//    // Declaring an arraylist.
//    ArrayList<Integer> list = new ArrayList<>(1000);
//
//    // Different way to declare arrays.
//     List<String> list1 = new ArrayList<>();
//
//     List<String> list2 = Arrays.asList("Monday","Tuesday");
//     list2.set(1,"Wednesday");
//
//     String[] arr = {"Apple","Banana","Orange"};
//     List<String> list3 = Arrays.asList(arr);
//
//     // With this we made the list3 modifiable
//     List<String> list5 = new ArrayList<>(list3);
//     list5.add("Mango");
//     System.out.println(list5);
//
//     // This was introduced in Java 9
//     List<Integer> list4 = List.of(1,2,3,4);// This creates an immutable list.
//// That means no modification can be done to this list.











//    // Adding elements in the arraylist.
//    list.add(22); // 0
//    list.add(89); // 1
//    list.add(99); // 2
//    list.add(101); // 3
//    list.add(102); // 4
//    list.add(103); // 5
//    list.add(104); // 6
//    list.add(105); // 7
//    list.add(106); // 8
//    list.add(107); // 9
//    list.add(108); // 10
//     System.out.println(list.size());
     














//    // method to get a particular element in the list using the index number.
//    System.out.println(list.get(2));
//    // method to get the size of the list similar to getting a length of an array.
//    System.out.println(list.size());
//    // printing all the elements using loop.
//    for (int i = 0; i < list.size(); i++) {
//      System.out.println(list.get(i));
//    }
//    for (int x: list){
//        System.out.println(x);
//    }
     // This checks if a particular element is present in the list.
//     System.out.println(list.contains(5));
//     System.out.println(list.contains(89));
//     for (int x:list){
//         System.out.println(x);
//         // Output -
//         // 22
//         // 89
//         // 99
//     }
//     list.remove(2); // Takes element index as an argument.
//     System.out.println("Element ate index 2 got removed");
//     for (int x:list){
//         System.out.println(x);
//         // Output -
//         // 22
//         // 89
//     }

//     // Method to add a particular element at a specified index:
//     list.add(2,33);
//
//     // Method to replace a particular element from an index and replace it with another element.
//     list.set(2,67); // this will replace the element at index 2 and add the specified value.

  }
}