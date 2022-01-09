import java.util.*;
import java.util.stream.Collectors;

public class Lesson34 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        List<Integer> list = new ArrayList<>();

        fillArr(arr);
        fillList(list);

        System.out.println(list);
        System.out.println(Arrays.toString(arr));

//        for (int i = 0; i < 10; i++){ //без использования лямбда-выражений
//            arr[i] = arr[i] * 2;
//            list.set(i, list.get(i) * 2);
//        }

        //map method
        arr = Arrays.stream(arr).map(a -> a * 2).toArray(); //Arrays.stream(arr) создание сущности с которой можно работать
        list = list.stream().map(a -> a * 2).collect(Collectors.toList()); // а - какой-то элемент из набора данных
        // map - отображение, берем элемент из старого множества и сопоставляем с новым
        // toArray преобразовавыет поток в массив

//        arr = Arrays.stream(arr).map(a -> 3).toArray();
        System.out.println(list);
        System.out.println(Arrays.toString(arr));
//--------------------------------------------------------------------------------------//
        //filter method
        int[] arr2 = new int[10];
        List<Integer> list2 = new ArrayList<>();

        fillArr(arr2);
        fillList(list2);

        arr2 = Arrays.stream(arr2).filter(a -> a % 2 == 0).toArray();
        list2 = list2.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());

        System.out.println(list2);
        System.out.println(Arrays.toString(arr2));

//        Arrays.stream(arr2).forEach(a -> System.out.print(a));
//        list2.stream().forEach(a -> System.out.print(a));
//--------------------------------------------------------------------------------------//
        //forEach method
        Arrays.stream(arr2).forEach(System.out::print); //можно сократить
        list2.stream().forEach(System.out::print);

//--------------------------------------------------------------------------------------//
        System.out.println();
        //reduce method
        int[] arr3 = new int[10];
        List<Integer> list3 = new ArrayList<>();

        fillArr(arr3);
        fillList(list3);
        // [1, 2, 3] //acc=1 b=2(acc=1+2=3)// acc=3 b=3(acc=3+3)//acc=6
        //если указат начальное значение аккумулятора, то итерация начнется с первого числа, с b=1
        int sumArr3 = Arrays.stream(arr3).reduce((acc, b) -> acc + b).getAsInt();
        int sumList3 = list3.stream().reduce((acc, b) -> acc + b).get();

        System.out.println(sumArr3);
        System.out.println(sumList3);

//--------------------------------------------------------------------------------------//
        int[] arr4 = new int[10];

        fillArr(arr4);

        int[] newArray = Arrays.stream(arr4).filter(a -> a % 2 != 0).map(a -> a * 2).toArray();
        System.out.println(Arrays.toString(newArray));
//--------------------------------------------------------------------------------------//
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(5);
        set.add(7);

        System.out.println(set);
        set = set.stream().map(a -> a * 10).collect(Collectors.toSet());
        System.out.println(set);

    }

    private static void fillList(List<Integer> list) {
        for (int i = 0; i < 10; i++){
            list.add(i + 1);
        }
    }

    private static void fillArr(int[] arr) {
        for (int i = 0; i < 10; i++){
            arr[i] = i + 1;
        }
    }
}
