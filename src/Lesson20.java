import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Lesson20 {
    //создание очереди с помощтю потокобезопасноый библиотеки
   private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
    //очередь не может вырасти больше чем на 10

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

    }
    private static void produce() throws InterruptedException { //создает очередь
        Random random = new Random();

        while (true){
            queue.put(random.nextInt(100));//помещение в очередь

        }
    }
    private static void consumer() throws InterruptedException { //обрабатывает очередь
        Random random = new Random();

        while (true) {
            Thread.sleep(100);
            if (random.nextInt(10) == 5) {
                System.out.println(queue.take()); //берет элементы из очереди ожидает пока элементы будут добавлены
                System.out.println("Queue size is " + queue.size());
            }
        }
    }
}
