import java.util.HashMap;
import java.util.Objects;

/**
 * This class demonstrates the importance of overriding hashCode() and equals() methods
 * when using custom objects as keys in a HashMap.
 */
public class HashCodeAndEqualsMethod {
    public static void main(String[] args) {
        // Create a HashMap where the key is a custom Student object and the value is a String representing their role.
        HashMap<Student,String> map = new HashMap<>();
        
        // Creating three Student objects. Notice that student1 and student3 have the exact same name and id.
        Student student1 = new Student("Alice",1);
        Student student2 = new Student("Bob",2);
        Student student3 = new Student("Alice",1);
        
        // Adding the students to the map.
        // When putting a key-value pair, HashMap uses the hashCode() of the key to determine the bucket (index) to place it in.
        map.put(student1,"Engineer"); // HashCode1 is calculated for student1 -> maps to index1.
        map.put(student2,"Designer"); // HashCode2 is calculated for student2 -> maps to index2.
        
        // When inserting student3, HashMap calculates its hashCode.
        // Since we have overridden hashCode() in the Student class based on name and id, 
        // student3 will have the SAME hashCode as student1, mapping to the SAME bucket (index1).
        // Then, HashMap uses the equals() method to check if the key already exists in that bucket.
        // Since we overrode equals(), it sees student1 and student3 are logically equal.
        // Therefore, it REPLACES the value of student1 ("Engineer") with "Manager" for that key.
        map.put(student3,"Manager");


        // Because student3 overwrote student1's value due to them being considered equal keys,
        // the map only contains 2 entries: one for Alice (id:1) and one for Bob (id:2).
        System.out.println("HashMap size: "+map.size());
        
        // Since student1 and student3 refer to the same logical key in the map,
        // retrieving the value using either student1 or student3 will return the latest updated value ("Manager").
        System.out.println("Value of student 1: "+map.get(student1));
        System.out.println("Value of student 2: "+map.get(student3));


        // This demonstrates the exact same concept using the built-in String class.
        // The String class already correctly overrides hashCode() and equals() internally.
        HashMap<String,Integer> map1 = new HashMap<>();
        map1.put("Pranay",90); // HashCode1 -> index1
        map1.put("Shubham",89); // HashCode2 -> index2
        
        // "Pranay" is exactly equal to the previous "Pranay" string.
        // Same hashCode -> same index -> equals() returns true -> REPLACES 90 with 99.
        map1.put("Pranay",99); 
    }
}

/**
 * A custom class representing a Student.
 * If instances of this class are to be used as keys in Hash-based collections (HashMap, HashSet, etc.),
 * it is MANDATORY to override both hashCode() and equals().
 */
class Student {
    private String name;
    private int id;

    public Student(String name,int id){
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    /**
     * The hashCode() method returns an integer hash code value for the object.
     * This is used by hash-based collections to determine which "bucket" to put the object into.
     * Rule of thumb: If two objects are equal according to equals(), they MUST have the same hashCode().
     * Here, we generate the hash code based on the 'name' and 'id' fields.
     */
    @Override
    public int hashCode() {
        // Objects.hash() is a convenient utility method that computes a hash code for multiple fields combined.
        return Objects.hash(name,id);
    }

    /**
     * The equals() method determines if two objects are logically "equal".
     * By default, Object's equals() only checks memory addresses (like the '==' operator).
     * We override it to check if the actual data (name and id) of the students is the same.
     */
    @Override
    public boolean equals(Object obj) {
        // 1. Check if we are comparing the object to itself (same memory address).
        // This is a fast-path optimization.
        if (this == obj){
            return true;
        }
        
        // 2. Check if the other object is null. If it is, they can't be equal.
        if (obj == null){
            return false;
        }
        
        // 3. Check if both objects belong to the exact same class.
        // This prevents ClassCastExceptions and ensures we don't compare a Student to an Employee, for instance.
        if (getClass() != obj.getClass()){
            return false;
        }
        
        // 4. Downcast the Object to our specific Student type so we can access its fields safely.
        Student other = (Student) obj;
        
        // 5. Compare the significant fields for equality.
        // 'id' is a primitive (int), so we use '=='.
        // 'name' is an Object (String), so we use Objects.equals() which safely handles nulls without crashing.
        return id == other.getId() && Objects.equals(name,other.getName());
    }

    /**
     * Provides a string representation of the object, useful for logging or debugging.
     */
    @Override
    public String toString() {
        return "Id: "+id+" name: "+name;
    }
}