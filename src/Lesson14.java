import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Lesson14 {
    public static void main(String[] args) {
        List<Integer> myList = new LinkedList<>();

        myList.add(1);
        myList.add(2);
        myList.add(3);

        for (int i:myList){ //нельзя удалять элементы во время смещения курсора
            System.out.println(i);
        }

        // Как реализовано

        int indx = 0; //во время смещения курсора можно одновременно еще удалять элементы
        Iterator<Integer> myIterator = myList.iterator();
        while (myIterator.hasNext()){
            System.out.println(myIterator.next());
            if (indx == 1)
                myIterator.remove();
            indx++;
        }
        System.out.println(myList);
    }
}
