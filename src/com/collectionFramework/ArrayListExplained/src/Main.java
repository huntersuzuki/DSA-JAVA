import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


//class StringLengthComparator implements Comparator<String>{
//
//    @Override
//    public int compare(String s1, String s2) {
//        return s1.length() -  s2.length();
//    }
//}

//class Movie {
//    String title;
//    Integer year;
//   public Movie(String title,Integer year){
//        this.title = title;
//        this.year = year;
//    }
//
//}

//class MovieComparator implements Comparator<Movie>{
//
//    @Override
//    public int compare(Movie m1, Movie m2) {
//        if (m1.year < m2.year){
//            return -1;
//        } else if (m2.year < m1.year) {
//            return 1;
//        }else {
//            return 0;
//        }
//       // To simplify the code, we can do
//        return m1.year.compareTo(m2.year);
//    }
//}


class Student {
    private final String name;
    private final double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }
}


class Main {
    public static void main(String[] args) {


        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 3.3));
        students.add(new Student("Bob", 3.7));
        students.add(new Student("Hamza", 4.0));
        students.add(new Student("Charlie", 3.9));
        students.add(new Student("Thomas", 3.7));
//        students.sort((o1, o2) -> {
//            if (o2.getGpa() - o1.getGpa() > 0) {
//                return 1;
//            } else if (o2.getGpa() - o1.getGpa() < 0) {
//                return -1;
//            } else {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });
        // We can use Java 8 method of Comparator.comparing
        // In this method we use Comparator.comparing method which was introduced in Java 8,
        // This is also called as comparator chaining.
        // In plain English, this code says:
        //"Sort the students by their GPA from highest to lowest. If two students have the exact same GPA, sort those specific students by their names alphabetically."
        Comparator<Student> comparator = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName);
        students.sort(comparator);

        for (Student s : students) {
            System.out.println(s.getName() + ": " + s.getGpa());
        }


//     List<String > fruits = Arrays.asList("banana","apple","date");
//     // This was an old way to implement an interface to a class and then
//     // override the method compare and then use that method to decide the sorting direction.
//     // refer the line number 4 to look at the old way of using comparator.
//     fruits.sort(new StringLengthComparator());
//     // The new method called as lambda expression introduced in Java 8.
//     fruits.sort((a,b) -> a.length() - b.length());
//     System.out.println(fruits);


//     List<Movie> movies = new ArrayList<>();
//     movies.add(new Movie("The matrix",1999));
//     movies.add(new Movie("The Godfather",1973));
//     movies.add(new Movie("Dhurandhar",2025));
//     movies.add(new Movie("Inception",2010));
//     movies.add(new Movie("Jurassic Park",1997));
//
//     movies.sort(new MovieComparator());
//     System.out.println(movies.stream().map(movie -> movie.title).toList());


//     List<Integer> list = new ArrayList<>();
//     list.add(3);
//     list.add(1);
//     list.add(2);
//     list.add(4);

//     // Converting List to Array
//     Integer[] array = list.toArray(new Integer[0]);
//
//     // We can also use comparator to sort the list, but with an additional feature,
//     // sorting the list in either ascending or descending.
//     list.sort(new MyComparator());
//     System.out.println(list);


//    //Sorting the list using sort() method
//     Collections.sort(list);
//     System.out.println(list);


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

//class MyComparator implements Comparator<Integer>{
//
//    @Override
//    public int compare(Integer o1, Integer o2) {
//        return o2 - o1;
//    }
//}