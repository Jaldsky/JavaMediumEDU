import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lesson3 {
    public static void main(String[] args) {
//        List<Integer> linkedListTest = new LinkedList<>();
//        for (int i = 0; i < 100; i++){
//            linkedListTest.add(i);
//        }
//        System.out.println(linkedListTest.size());
//        System.out.println(linkedListTest.get(1));
//        linkedListTest.remove(1);
//        System.out.println(linkedListTest);
//
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> arrayList = new ArrayList<>();

        measureTimeAddEnd(linkedList);
        measureTimeAddEnd(arrayList);

        measureTimeGet(linkedList);
        measureTimeGet(arrayList);

        measureTimeAddStart(linkedList);
        measureTimeAddStart(arrayList);
    }

    private static void measureTimeAddEnd(List<Integer> list) {
            long start = System.currentTimeMillis();

            for (int i = 0; i < 1000000; i++){
                list.add(i); //добавление в конец листа
            }

            long end = System.currentTimeMillis();
        System.out.println("Add method " +(end-start));
    }

    private static void measureTimeGet(List<Integer> list) {
        for (int i = 0; i < 10000; i++){
            list.add(i);
        }

        long start = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++){
            list.get(i);
        }

        long end = System.currentTimeMillis();

        System.out.println("Get method " + (end-start));
    }

    private static void measureTimeAddStart(List<Integer> list) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++){
            list.add(0, i); //добавление в начало листа
        }

        long end = System.currentTimeMillis();
        System.out.println("Add in start method " +(end-start));
    }


}
