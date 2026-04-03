import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<String,Integer> linkedHashMap = new LinkedHashMap<>(11,0.8f,true); // Double-linked list behind the scene.
//        HashMap<String,Integer> hashMap = new HashMap<>();
        linkedHashMap.put("Orange",10);
        linkedHashMap.put("Guava",12);
        linkedHashMap.put("Apple",23);
        linkedHashMap.get("Apple");
        linkedHashMap.get("Guava");
        linkedHashMap.get("Orange");
        linkedHashMap.get("Guava");
        linkedHashMap.get("Apple");
        linkedHashMap.get("Apple");
        linkedHashMap.get("Guava");

        for(Map.Entry<String,Integer> entry : linkedHashMap.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
