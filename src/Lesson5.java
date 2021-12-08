import java.util.HashMap;
import java.util.Map;

public class Lesson5 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>(); //Intenger - тип ключа, String - тип значения
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        for (Map.Entry<Integer, String> entry: map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println(map);

        map.put(3, "3");
        System.out.println(map);

        System.out.println(map.get(1));
    }
}
