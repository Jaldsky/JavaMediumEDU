import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lesson18 {
    private int counter;

    public static void main(String[] args) {
        new Worker().main();


    }
}
class Worker{
    Random random = new Random();

    Object lock1 = new Object(); //объекты на которых необходимо синхронизироваться
    Object lock2 = new Object();

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public void addToList1() { //два потока не могут выполнить этот метод одновременно
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(random.nextInt(100));
        }
    }

    public synchronized void addToList2(){ //два потока не могут выполнить этот метод одновременно
            synchronized (lock2) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list2.add(random.nextInt(100));
            }
    }

    public void main(){
        long before = System.currentTimeMillis();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long after = System.currentTimeMillis();

        System.out.println("Program took " + (after - before) + " ms to run");

        System.out.println("List1 size " + list1.size());
        System.out.println("List2 size " + list2.size());
    }

    public void work(){
        for (int i=0; i<1000; i++) {
            addToList1();
            addToList2();
    }
    }
}
