import java.util.*;

public class Lesson11 {
    public static void main(String[] args) {
        List<Person2> people2List = new ArrayList<>();
        Set<Person2> people2Set = new TreeSet<>();

        addElements(people2List);
        addElements(people2Set);

        System.out.println(people2List);
        System.out.println(people2Set);

    }

    private static void addElements(Collection collections){
        collections.add(new Person2(1, "Alex"));
        collections.add(new Person2(2, "Mike"));
        collections.add(new Person2(3, "Ela"));
        collections.add(new Person2(4, "Georgelius"));

    }
}
class Person2 implements Comparable<Person2>{
    int id;
    String name;

    public Person2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person2 person2 = (Person2) o;

        if (id != person2.id) return false;
        return name != null ? name.equals(person2.name) : person2.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Person2 o) {
        if (this.name.length() > o.getName().length()){
            return 1;
        } else if (this.name.length() < o.getName().length()){
            return -1;
        } else {
            return 0;
        }
    }
}