import java.util.ArrayList;
import java.util.List;

public class Lesson1 {
    public static void main(String[] args) {
        int[] x = new int[3];
        for (int i = 0; i < x.length; i++){
            x[i] = 1;
        }

        List<Integer> arrayList = new ArrayList<>(); //такое написание требует конвенция List<Integer>
        for (int i =0; i < 100; i++){
            arrayList.add(i);
        }
        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(99));
        System.out.println(arrayList.remove(1));
        //устройство удаления было [1, 2, 3, 4] -->(удаляется элемент по индексу)
        // [1,  , 3, 4] -->(размер массива уменьшается и все элементы сдвигаются влево) [1, 3, 4]
        System.out.println(arrayList.size());
        System.out.println(arrayList);
        arrayList.add(1, 1);
        System.out.println(arrayList);

        for (int i = 0; i < arrayList.size(); i++){
            System.out.print(arrayList.get(i));
        }
        System.out.println();
        for (Integer integer: arrayList){
            System.out.print(arrayList.get(integer));
        }



    }
}
