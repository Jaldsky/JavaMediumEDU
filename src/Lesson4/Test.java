package Lesson4;

public class Test {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(2);
        myLinkedList.add(10);
        myLinkedList.add(15);

        System.out.println(myLinkedList);
        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));
        System.out.println(myLinkedList.get(2));

        myLinkedList.remove(1);

        System.out.println(myLinkedList);
        myLinkedList.remove(1);
        System.out.println(myLinkedList);

    }
}
