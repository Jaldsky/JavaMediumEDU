import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Lesson12 {
    public static void main(String[] args) {
        Person3 personl1 = new Person3(1);
        Person3 personl2 = new Person3(2);
        Person3 personl3 = new Person3(3);
        Person3 personl4 = new Person3(4);

        Person3 personl5 = new Person3(5);

        Queue<Person3> person3s = new ArrayBlockingQueue<>(10); //если очередь заполнится, то мы не сможем добавить новые объекты
        person3s.add(personl4);
        person3s.add(personl1);
        person3s.add(personl3);
        person3s.add(personl2);

        for (Person3 person:person3s){
            System.out.println(person);
        }
        person3s.remove();
        System.out.println();
        System.out.println(person3s.peek());
        System.out.println(person3s.peek()); //с помощью этого метода можно посмотреть 1 элемент в очереди
        System.out.println(person3s);

        System.out.println(person3s.offer(personl5)); //в случае успешного добавлени =True


    }
}
class Person3{
    int id;

    public Person3(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person3{" +
                "id=" + id +
                '}';
    }
}
