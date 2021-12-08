import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Lesson7 {
    public static void main(String[] args) {
//        //в set нельзя хранить одинаковые элементы
//        Set<String> hashSet = new HashSet<>(); //не сохраняет порядок
//        Set<String> linkedHashSet = new LinkedHashSet<>(); //сохраняет порядок
//        Set<String> treeSet = new TreeSet<>(); //дает возможность сортировки
//
//        hashSet.add("Mike");
//        hashSet.add("Alex");
//        hashSet.add("Ela");
//        hashSet.add("George");
//        hashSet.add("George");
//
//        linkedHashSet.add("Mike");
//        linkedHashSet.add("Alex");
//        linkedHashSet.add("Ela");
//        linkedHashSet.add("George");
//        linkedHashSet.add("George");
//
//        treeSet.add("Mike");
//        treeSet.add("Alex");
//        treeSet.add("Ela");
//        treeSet.add("George");
//        treeSet.add("George");
//
//        for (String name:hashSet){
//            System.out.println(name);
//        }
//        System.out.println();
//        for (String name:linkedHashSet){
//            System.out.println(name);
//        }
//        System.out.println();
//        for (String name:treeSet){
//            System.out.println(name);
//        }
//
//
//        System.out.println(hashSet.contains("Tom"));
//        System.out.println(hashSet.isEmpty());

        Set<Integer> mySet1 = new HashSet<>();
        Set<Integer> mySet2 = new HashSet<>();

        mySet1.add(1);
        mySet1.add(2);
        mySet1.add(3);
        mySet1.add(4);
        mySet1.add(5);

        mySet2.add(2);
        mySet2.add(3);
        mySet2.add(4);
        mySet2.add(5);
        mySet2.add(6);
        mySet2.add(7);

        //объединение множеств
        Set<Integer> union = new HashSet<>(mySet1);
        union.addAll(mySet2);
        System.out.println(union);

        //пересечение
        Set<Integer> intersection = new HashSet<>(mySet1);
        intersection.retainAll(mySet2);
        System.out.println(intersection);

        //разность
        Set<Integer> difference = new HashSet<>(mySet1);
        difference.removeAll(mySet2);
        System.out.println(difference);



    }
}
