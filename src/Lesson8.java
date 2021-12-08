import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lesson8 {
    public static void main(String[] args) {
//        Map<Integer, String> map = new HashMap<>();
//        Set<Integer> set = new HashSet<>();
//
//        map.put(1, "Bob");
//        map.put(1, "Bob");
//
//        set.add(1);
//        set.add(1);
//
//        System.out.println(map);
//        System.out.println(set);

        Map<Person, Integer> testPerson1 = new HashMap<>();
        Set<Person> testPerson2 = new HashSet<>();

        Person person1 = new Person(1,"Mike");
        Person person2 = new Person(1,"Mike");

        testPerson1.put(person1, 28);
        testPerson1.put(person2, 17);

        testPerson2.add(person1);
        testPerson2.add(person2);

        System.out.println(testPerson1);
        System.out.println(testPerson2);
    }
}
class Person{
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }
    @Override
    // object --> int
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
