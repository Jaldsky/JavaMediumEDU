
import java.util.Stack;

public class Lesson13 {
    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();

        integerStack.push(1); //добавляет элемент
        integerStack.push(5);
        integerStack.push(10);

//        System.out.println(integerStack.peek()); //показывает элемент, но не извлекает его
//        System.out.println(integerStack.pop());
//        System.out.println(integerStack.pop());
//        System.out.println(integerStack.pop());//достает последний добавленный элемент
//        System.out.println();

        while (!integerStack.empty()){
            System.out.println(integerStack.pop());
        }
    }
}
