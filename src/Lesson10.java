import java.util.*;

public class Lesson10 {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();

        animals.add("cat");
        animals.add("dog");
        animals.add("frog");
        animals.add("bird");

        Collections.sort(animals, new StringLenghtComparator());
        System.out.println(animals);

        List<Integer> numbers = new ArrayList<>();

        numbers.add(0);
        numbers.add(10);
        numbers.add(20);
        numbers.add(3);
        numbers.add(500);

        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2) {
                    return 1;
                } else if (o1 > o2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(numbers);


        List<Person1> personList = new ArrayList<>();
        personList.add(new Person1( 1, "Bob"));
        personList.add(new Person1( 2, "Tom"));
        personList.add(new Person1( 3, "Jef"));

        Collections.sort(personList, new Comparator<Person1>() {
            @Override
            public int compare(Person1 o1, Person1 o2) {
                if (o1.getId() > o2.getId()) {
                    return 1;
                } else if ( o1.getId() > o2.getId()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
    }
}
class StringLenghtComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        // o1 > 02 => 1
        // o1 < o2 => -1
        // o1 == o2 => 0
        if (o1.length() > o2.length()) {
            return 1;
        } else if (o1.length() < o2.length()) {
            return -1;
        } else {
            return 0;
        }
    }
}
class Person1 {
    private int id;
    private String name;

    public Person1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

