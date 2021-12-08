
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Lesson6 {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, String> treeMap = new TreeMap<>();

        testMap(hashMap);
        System.out.println();
        testMap(linkedHashMap);
        System.out.println();
        testMap(treeMap);

    }
    public static void testMap(Map<Integer, String> map){
        map.put(35, "Tom");
        map.put(56, "Jerry");
        map.put(22, "Quizz");
        map.put(0, "Gerald");
        map.put(1544, "Alex");
        map.put(100, "Tom");

        for (Map.Entry<Integer, String> entry:map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


    }
}
